(defproject jersey-zoo-clj "1.0.2"
  :description "jersey servlet with zookeeper connection"
  :aot [jerseyzoo.JerseyZooServletContainer] 
  :repl-init jerseyzoo.JerseyZooServletContainer
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [jersey-clj "1.0.2"]
                 [zookeeper-clj "0.9.2"]]
  :dev-dependencies [[org.eclipse.jetty/jetty-servlet "8.1.3.v20120416"]])
