(ns admin-v2b.core
  (:require [reagent.core :as r]
            [goog.dom :as gdom]
            [material-ui.core :as ui]))

#_ (do (use 'figwheel-sidecar.repl-api) (cljs-repl))

(enable-console-print!)

(defonce st (r/atom 0))

(def app-state (r/atom {
                        :left-nav {
                                   :open false
                                   }
                        :name {
                               :first ""
                               :last ""
                               }
                        }))

(def refresh-left-nav (atom false))

(def menu-items [
                 {:payload "home" :text "Home"  }
                 {:payload "favorites" :text "Favorites" }
                 {:payload "about" :text "About" }
                 ])


(defn left-nav-component []
  (r/create-class {

                   ;;:component-did-mount #(-> (. % -refs.leftNav) .open)
                   :component-will-update
                   (fn [c new-args]
                     (-> (. c -refs.leftNav) .toggle))

                   :render
                   (fn [this]
                     [ui/LeftNav {:ref "leftNav"
                                  :docked false
                                  :open (-> @app-state :left-nav :open)
                                  ;;:menu-items menu-items
                                  }
                      [ui/MenuItem {:primaryText "Home"}]
                      [ui/MenuItem {:primaryText "Favorites"}]
                      [ui/MenuItem {:primaryText "About"}]

                      ])}))

(defn main []
  [ui/AppCanvas {:predefinedLayout 1}
   [ui/AppBar {:class                    "mui-dark-theme"
               :title                    "Reagent Material Example"
               :zDepth                   0
               :onLeftIconButtonTouchTap (fn []
                                           (swap! app-state assoc-in [:left-nav :open] true)
                                           (println "open left nav: " (get-in @app-state [:left-nav :open]))
                                           (swap! refresh-left-nav not)
                                           ;(-> (.' left-nav -refs.leftNav) .open)
                                           )}
    [:div.action-icons
     [ui/IconButton {:iconClassName "mdfi_navigation_more_vert"}]
     [ui/IconButton {:iconClassName "mdfi_action_favorite_outline"}]
     [ui/IconButton {:iconClassName "mdfi_action_search"}]]]
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

(defonce state (r/atom
                {:title          "Reagent Material"
                 :messages       []
                 :re-render-flip false}))

(r/render-component [main state] (.-body js/document))

(swap! st inc)
