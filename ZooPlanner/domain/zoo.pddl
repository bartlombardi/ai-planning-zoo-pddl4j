(define (domain zoo)
  (:requirements :strips :equality :negative-preconditions)
  (:predicates
    (at ?thing ?place)          ; thing si trova in place
    (visitor ?v)                ; v è un visitatore
    (camel ?c)                  ; c è un cammello
    (riding ?visitor ?thing)    ; il visitatore sta andando su qualcosa
    (mobile ?thing)             ; thing è mobile (probabilmente superfluo
                                ; rispetto a riding ma lo lasiamo)

    (road ?from ?to)            ; sentiero
    (shadow ?from ?to)          ; ombra
    (camelroad ?from ?to)       ; strada per cammello

    (to-discover ?place)        ; il visitatore deve ancora peassare per questo posto
    (able-to-walk ?from ?to)    ; il visitatore può ancora percorrere quella strada?
    (able-to-climb ?visitor)    ; il visitatore può ancora salire sul cammello?
    (able-to-ride ?from ?to)    ; il cammello può ancora percorrere quella strada?
  )

  (:action Walk
    :parameters (?visitor ?from ?to)
    :precondition (and (visitor ?visitor)
        (at ?visitor ?from)
        (mobile ?visitor)
        (road ?from ?to)
        (not (= ?from ?to))
        (able-to-walk ?from ?to))
    :effect (and (at ?visitor ?to)
        (not (to-discover ?to))
        (not (at ?visitor ?from))
        (not (able-to-walk ?to ?from))
        (not (able-to-walk ?from ?to)))
  )

  (:action Shadow-Walk
    :parameters (?visitor ?from ?to)
    :precondition (and (visitor ?visitor)
        (at ?visitor ?from)
        (mobile ?visitor)
        (shadow ?from ?to)
        (not (= ?from ?to)))
    :effect (and (at ?visitor ?to)
        (not (to-discover ?to))
        (not (at ?visitor ?from)))
  )

  (:action Get-on-Camel
    :parameters (?visitor ?place ?camel)
    :precondition (and (visitor ?visitor)
          (at ?visitor ?place)
          (camel ?camel)
          (at ?camel ?place)
          (able-to-climb ?visitor)
          (not (riding ?visitor ?camel))
          (mobile ?visitor))
    :effect (and (riding ?visitor ?camel)
          (mobile ?camel)
          (not (at ?visitor ?place))
          (not (mobile ?visitor)))
  )

  ; attenzione qui riding non c'è
  (:action Ride-Camel
    :parameters (?visitor ?camel ?from ?to)
    :precondition (and (camelroad ?from ?to)
          (at ?camel ?from)
          (visitor ?visitor)
          (mobile ?camel)
          (riding ?visitor ?camel)
          (able-to-ride ?from ?to)
          (not (= ?from ?to)))
    :effect (and (at ?camel ?to)
          (not (to-discover ?to))
          (not (at ?camel ?from))
          (not (able-to-ride ?from ?to))
          (not (able-to-ride ?to ?from)))
  )

  (:action Get-off-Camel
    :parameters (?visitor ?place ?camel)
    :precondition (and (visitor ?visitor)
          (camel ?camel)
          (riding ?visitor ?camel)
          (at ?camel ?place))
    :effect (and (at ?visitor ?place)
          (mobile ?visitor)
          (not (able-to-climb ?visitor))
          (not (riding ?visitor ?camel))
          (not (mobile ?camel)))
  )
)
