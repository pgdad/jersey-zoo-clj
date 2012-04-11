(ns jerseyzoo.JerseyZooServletContainer
  (:import (jersey CljJerseyServletContainer)
           (java.util HashMap))
  (:require [zookeeper :as zk])
  (:gen-class :extends jersey.CljJerseyServletContainer
              :constructors {[String String] [String]}
              :state state
              :init init-state
              :methods [#^{:static true} [ getConnection [String] Object]]))

(def getConnection
  (memoize (fn [keepers]
             (let [conn (zk/connect keepers)]
               (ref conn)))))

(defn -getConnection
  [keepers]
  (getConnection keepers))

(defn getZooConnection
  [keepers]
  (getConnection keepers))

(defn -init-state
  [packages keepers]
  [[packages] (ref {:keepers keepers :connection (getConnection keepers)})]
  )
