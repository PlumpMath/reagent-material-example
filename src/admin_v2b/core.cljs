(ns admin-v2b.core
  (:require [reagent.core :as r]))

(.log js/console "Heyyyyyyyyy cowboy")
#_ (enable-console-print!)

(defn hello-world []
  [:h1 "hello world!!!! "])

(r/render-component [hello-world] (.-body js/document))


#_ (doseq [i (range 3)] (js/alert (str "Hello World " i)))

#_ (reduce + (range 1 100))

#_ (apply str (interpose ", " (range 1 100)))
