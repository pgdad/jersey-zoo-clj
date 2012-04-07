(ns jerseyzoo.test.core
  (:use [clojure.test])
  (:import (jerseyzoo JerseyZooServletContainer)
           (org.eclipse.jetty.servlet ServletContextHandler ServletHolder)
           (org.eclipse.jetty.server Server)
           (org.eclipse.jetty.server.handler HandlerCollection ConnectHandler)
           (org.eclipse.jetty.server.nio SelectChannelConnector)
           ))

(deftest server-in-jetty
  (let [server (Server.)
        connector (SelectChannelConnector.)
        handlers (HandlerCollection.)]
    (. connector setPort 8787)
    (. server addConnector connector)
    (. server setHandler handlers)
    (let [context (ServletContextHandler. handlers
                                          "/" ServletContextHandler/SESSIONS)
          jerseyServlet (ServletHolder. (JerseyZooServletContainer. "jersey" "localhost"))
          handler (ConnectHandler.)]
      (. context addServlet jerseyServlet "/*")
      (. handlers addHandler handler)
      (. server start)
      (Thread/sleep (* 15 1000))
      ;; TODO: add meaningful test cases
      (. server stop)
      )))
