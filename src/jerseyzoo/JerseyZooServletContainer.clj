(ns jerseyzoo.JerseyZooServletContainer
  (:import (jersey CljJerseyServletContainer)
           (java.util HashMap)
           (com.netflix.curator.framework CuratorFrameworkFactory)
           (com.netflix.curator.retry RetryNTimes))
  (:gen-class :extends jersey.CljJerseyServletContainer
              :constructors {[String String] [String]}
              :state state
              :init init-state
              :methods [#^{:static true} [ getFramework [String] Object]]))

(def getFramework
  (memoize (fn [keepers]
             (let [rp (RetryNTimes. 1000 100)
                   fWork (CuratorFrameworkFactory/newClient keepers rp)]
               (.start fWork)
               fWork))))

(defn -getFramework
  [keepers]
  (getFramework keepers))

#_(defn getCuratorFramework
  [keepers]
  (getFramework keepers))

(defn -init-state
  [packages keepers]
  [[packages] (ref {:keepers keepers :fWork (getFramework keepers)})]
  )
