(define (domain taxi)
  (:requirements :strips :equality :typing :conditional-effects)

  ;; (:types place connection nconnection)

  (:predicates
    (at ?thing)             ;; where currentlu is a thing
    (walkable ?connection)  ;; is connection walkable
    ()
  )
  ;; place si trova a nodo
