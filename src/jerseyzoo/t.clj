(ns jerseyzoo.t
  (:import (jerseyzoo.ti))
  )

(definterface myinterface
  (^Integer getId []))

(deftype t [] jerseyzoo.ti.ti
         (getId [this] 6))