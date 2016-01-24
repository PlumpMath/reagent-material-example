(ns admin-v2b.core
  (:require [reagent.core :as r]
            [goog.dom :as gdom]))

#_ (do (use 'figwheel-sidecar.repl-api) (cljs-repl))

(enable-console-print!)
(println "hello")

(defonce st (r/atom {:rerender-flip-bit true}))

(defn hello-world []
  [:h1 "hello: " (str (:rerender-flip-bit @st))])

(swap! st complement)
(r/render-component [hello-world] (gdom/getElement "app"))




#_ (doseq [i (range 3)] (js/alert (str "Hello World " i)))

#_ (reduce + (range 1 100))

#_ (apply str (interpose ", " (range 1 100)))
