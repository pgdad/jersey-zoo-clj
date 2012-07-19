(defproject jersey-zoo-clj "1.0.3"
  :description "jersey servlet with curator framework"
  :aot [jerseyzoo.JerseyZooServletContainer] 
  :repl-init jerseyzoo.JerseyZooServletContainer
  :plugins [[ lein-swank "1.4.4"]]
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [jersey-clj "1.0.2"]
                 [com.netflix.curator/curator-framework "1.1.13"]]
  :profiles {:dev {:dependencies
                   [[org.eclipse.jetty/jetty-servlet "8.1.4.v20120524"]]}})
