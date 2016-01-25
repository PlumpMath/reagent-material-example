(ns admin-v2b.core
  (:require [reagent.core :as r]
            [goog.dom :as gdom]
            [material-ui.core :as ui]
            [material-ui.icons :as icon]))

#_ (do (use 'figwheel-sidecar.repl-api) (cljs-repl))
(enable-console-print!)


(def app-state (r/atom {
                        :left-nav {
                                   :open false
                                   }
                        :name {
                               :first ""
                               :last ""
                               }
                        }))


(defn left-nav-component []
  [ui/LeftNav {:ref "leftNav"
               :docked false
               :open (-> @app-state :left-nav :open)}
   [ui/MenuItem {:primaryText "Home"
                 :leftIcon (r/as-element [icon/ActionHome])
                 :onTouchTap #(swap! app-state assoc-in [:left-nav :open] false)}]
   [ui/MenuItem {:primaryText "Favorites"
                 :leftIcon (r/as-element [icon/ActionFavorite])
                 :onTouchTap #(swap! app-state assoc-in [:left-nav :open] false)}]
   [ui/MenuItem {:primaryText "About"
                 :leftIcon (r/as-element [icon/FileCloud])
                 :onTouchTap #(swap! app-state assoc-in [:left-nav :open] false)}]])


(defn main []
  [ui/AppCanvas {:predefinedLayout 1}
   [ui/AppBar {:class                    "mui-dark-theme"
               :title                    "Reagent Material Example"
               :zDepth                   0
               :onLeftIconButtonTouchTap (fn []
                                           (swap! app-state assoc-in [:left-nav :open] true)
                                           )}
    [:div.action-icons
     [ui/IconButton [icon/ActionSearch]]
     [ui/IconButton {:iconClassName "material-icons"} "account_box"]
     [ui/IconButton {:iconClassName "material-icons"} "perm_data_settings"]
     ]]
   [left-nav-component]
   [:div.mui-app-content-canvas
    [:br]
    [:br]
    [:br]
    [:br]
    [ui/TextField {:hintText "Please enter your first name"
                   :floatingLabelText "First Name"
                   :value (get-in @app-state [:name :first])
                   :on-change #(swap! app-state assoc-in [:name :first] (-> % .-target .-value))
                   }]

    [:br]
    [ui/TextField {:hintText "Please enter your last name"
                   :value (get-in @app-state [:name :last])
                   :on-change #(swap! app-state assoc-in [:name :last] (-> % .-target .-value))
                   :floatingLabelText "Last Name"}]
    [:br]
    [:input.form-control {
                          :type      "text"
                          :value     (get-in @app-state [:name :first])
                          :on-change #(swap! app-state assoc-in [:name :first] (-> % .-target .-value))}]
    [:input.form-control {
                          :type      "text"
                          :value     (get-in @app-state [:name :last])
                          :on-change #(swap! app-state assoc-in [:name :last] (-> % .-target .-value))}]
    ]])


(r/render-component [main] (gdom/getElement "app"))

