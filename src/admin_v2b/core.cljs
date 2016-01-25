(ns admin-v2b.core
  (:require [reagent.core :as r]
            [material-ui.core :as ui]
            [goog.dom :as gdom])
)

#_ (do (use 'figwheel-sidecar.repl-api) (cljs-repl))

(enable-console-print!)

(defonce st (r/atom 0))

(def TextField (reagent.core/adapt-react-class (aget js/MaterialUI "TextField")))
(def Slider (reagent.core/adapt-react-class (aget js/MaterialUI "Slider")))

#_ (def ^:dynamic *mui-theme*
     (.getCurrentTheme (js/MaterialUI.Styles.ThemeManager.)))


#_ (defn main-panel []
  (r/create-class {:display-name "Main Panel"
                   :reagent-render (fn [] [IconButton {:name "slide1"}])}))

(defn app []
  [:div
   ;;[IconButton {:iconClassName "mdfi_action_favorite_outline"}]
   [TextField]
   [:br]
   [Slider {:name "slide1"}]
   [:br]
   [:h1 {:on-click #(swap! st inc)} "count: " @st]])

(r/render-component [app] (gdom/getElement "app"))

(swap! st inc)


#_ (doseq [i (range 3)] (js/alert (str "Hello World " i)))

#_ (reduce + (range 1 100))

#_ (apply str (interpose ", " (range 1 100)))
