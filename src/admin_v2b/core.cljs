(ns admin-v2b.core
  (:require [reagent.core :as r]
            [goog.dom :as gdom]))

#_ (do (use 'figwheel-sidecar.repl-api) (cljs-repl))

(enable-console-print!)

(defonce st (r/atom 0))

(defn app []
  [:h1 {:on-click #(swap! st inc)} "count: " @st])

(r/render-component [app] (gdom/getElement "app"))




#_ (doseq [i (range 3)] (js/alert (str "Hello World " i)))

#_ (reduce + (range 1 100))

#_ (apply str (interpose ", " (range 1 100)))
