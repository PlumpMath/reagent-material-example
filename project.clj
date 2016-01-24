(defproject admin-v2b "0.1.0-SNAPSHOT"
  :min-lein-version "2.5.3"
  :plugins [[lein-figwheel "0.5.0-4"]]

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [reagent "0.6.0-alpha"]
                 [org.clojure/clojurescript "1.7.228"]]

  :clean-targets ^{:protect false} [:target
                                    "resources/public/js"
                                    "resources/public/css"
                                    "figwheel_server.log"]


  :figwheel {:http-server-root "public" ;; this will be in resources/
             :css-dirs ["resources/public/css"]
             :server-port 3449
             :server-ip "0.0.0.0"
             :websocket-host :js-client-host

             :nrepl-port 7888
             :nrepl-middleware ["cider.nrepl/cider-middleware"
                                ;;"refactor-nrepl.middleware/wrap-refactor"
                                "cemerick.piggieback/wrap-cljs-repl"]

             :open-file-command "emacsclient"}

  :cljsbuild
  {:builds [{:id "dev"
             :source-paths ["src"]
             :figwheel true
             :compiler {:main "admin-v2b.core"
                        :output-to "resources/public/js/main.js"
                        :output-dir "resources/public/js/out"
                        :asset-path "js/out"
                        :optimizations :none}}]}

  :profiles
  {:repl {:plugins [[cider/cider-nrepl "0.11.0-SNAPSHOT"]]}
   :dev {:repl-options { ;;:init-ns admin-v2b.core
                        :nrepl-middleware
                        [cemerick.piggieback/wrap-cljs-repl]}
         :dependencies [[com.cemerick/piggieback "0.2.1"]
                        [figwheel-sidecar "0.5.0-SNAPSHOT"]
                        [cider/cider-nrepl "0.11.0-SNAPSHOT"]]

         }

   }

  )
