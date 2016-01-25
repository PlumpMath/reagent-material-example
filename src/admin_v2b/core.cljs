(ns admin-v2b.core
  (:require [reagent.core :as r]
            [goog.dom :as gdom]
            [material-ui.core :as mui]))

#_ (do (use 'figwheel-sidecar.repl-api) (cljs-repl))

(enable-console-print!)

(defonce st (r/atom 0))

(defn app []
  [:div
   ;;[IconButton {:iconClassName "mdfi_action_favorite_outline"}]
   [mui/TextField]
   [:br]
   [mui/Slider {:name "slide1"}]
   [:br]
   [:h1 {:on-click #(swap! st inc)} "count: " @st]])

(r/render-component [app] (gdom/getElement "app"))

(swap! st inc)
