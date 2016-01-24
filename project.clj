(defproject admin-v2b "0.1.0-SNAPSHOT"
  :min-lein-version "2.5"
  :plugins [[lein-figwheel "0.5.0-1"]]

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [reagent "0.6.0-alpha"]
                 [org.clojure/clojurescript "1.7.228"]]

  :clean-targets ^{:protect false} ["resources/public/js"
                                    "resources/public/css"
                                    :target
                                    "out"
                                    "figwheel_server.log"]

  :cljsbuild
  {:builds [{:id "dev"
             :source-paths ["src"]
             :figwheel {:http-server-root "public" ;; this will be in resources/
                        :server-port 3449
                        :css-dirs ["resources/public/css"]
                        :open-file-command "scripts/emacsclient_path_lineno.sh"}
             :compiler {:main "admin-v2b.core"
                        :output-to "resources/public/js/main.js"
                        :output-dir "resources/public/js/out"
                        :asset-path "js/out"
                        :optimizations :none}}]}

  :profiles
  {:dev {:repl-options { ;;:init-ns admin-v2b.core
                        :nrepl-middleware
                        [cemerick.piggieback/wrap-cljs-repl
                         cider.nrepl.middleware.apropos/wrap-apropos
                         cider.nrepl.middleware.classpath/wrap-classpath
                         cider.nrepl.middleware.complete/wrap-complete
                         cider.nrepl.middleware.debug/wrap-debug
                         cider.nrepl.middleware.format/wrap-format
                         cider.nrepl.middleware.info/wrap-info
                         cider.nrepl.middleware.inspect/wrap-inspect
                         cider.nrepl.middleware.macroexpand/wrap-macroexpand
                         cider.nrepl.middleware.ns/wrap-ns
                         cider.nrepl.middleware.pprint/wrap-pprint
                         cider.nrepl.middleware.pprint/wrap-pprint-fn
                         cider.nrepl.middleware.refresh/wrap-refresh
                         cider.nrepl.middleware.resource/wrap-resource
                         cider.nrepl.middleware.stacktrace/wrap-stacktrace
                         cider.nrepl.middleware.test/wrap-test
                         cider.nrepl.middleware.trace/wrap-trace
                         cider.nrepl.middleware.out/wrap-out
                         cider.nrepl.middleware.undef/wrap-undef
                         ]}
         :dependencies [[com.cemerick/piggieback "0.2.1"]
                        ;;[figwheel-sidecar "0.5.0-1"]
                        [cider/cider-nrepl "0.10.1"]
                        [org.clojure/tools.nrepl "0.2.10"]]

         }

   }

  )
