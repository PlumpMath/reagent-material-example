(ns material-ui.core
  (:require [reagent.core]))


(def material-tags
  '[AppBar
     AppCanvas
     Checkbox
     DatePicker
     Dialog
     DropDownIcon
     DropDownMenu
     EnhancedButton
     FlatButton
     FloatingActionButton
     FontIcon
     IconButton
     LeftNav
     MenuItem
     Menu
     Overlay
     Paper
     RadioButton
     RadioButtonGroup
     RaisedButton
     Slider
     Snackbar
     SvgIcon
     Tab
     Tabs
     TableHeader
     TextField
     Toggle
     ToolbarGroup
     Toolbar
     Tooltip])

(defn material-ui-react-import [tname]
  `(def ~tname (reagent.core/adapt-react-class (aget js/MaterialUI ~(name tname)))))

(defmacro export-material-ui-react-classes []
  `(do ~@(map material-ui-react-import material-tags)))

