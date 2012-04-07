(ns jerseyzoo.JerseyZooServletContainer
  (:import (jersey CljJerseyServletContainer)
           (java.util HashMap))
  (:require [zookeeper :as zk])
  (:gen-class :extends jersey.CljJerseyServletContainer
              :constructors {[String String] [String]}
              :state state
              :init init-state))

(def getConnection
  (memoize (fn [keepers]
             (let [conn (zk/connect keepers)]
               (ref conn)))))

(defn -init-state
  [packages keepers]
  [[packages] (ref {:keepers keepers :connection (getConnection keepers)})]
  )
