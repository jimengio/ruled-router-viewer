
(ns app.updater (:require [respo.cursor :refer [mutate]]))

(defn updater [store op op-data op-id op-time]
  (case op
    :states (update store :states (mutate op-data))
    :set-data (assoc store :data op-data)
    :set-path (assoc store :path op-data)
    :hydrate-storage op-data
    (do (js/console.warn "Unknown op:" op) store)))
