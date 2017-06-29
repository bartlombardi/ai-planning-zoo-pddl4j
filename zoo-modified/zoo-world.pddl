;; The Traveling Salesman problem, STRIPS version.
;; The predicate "connected" defines the graph; it doesn't have to
;; be made symmetric, since there're actions for going both "along"
;; and "against" the direction of an arc.
;; partendo dal problema del TSP

(define (domain zoo-world)
  (:requirements :strips)
  (:predicates (in ?x) (visited ?x) (not-visited ?x)
	       (starting ?x) (finishing ?x) (complete) (not-complete)
	       (sentiero ?x ?y) (erba ?x ?y) (visitedEdge ?x ?y) (not-visitedEdge ?x ?y))

  (:action move-along-sentiero
    :parameters (?x ?y)
    :precondition (and (in ?x) (not-visitedEdge ?x ?y) (not-complete)
		       (sentiero ?x ?y))
    :effect (and (not (in ?x)) (in ?y) (visited ?y) (not (not-visited ?y)) (visitedEdge ?x ?y) (not (not-visitedEdge ?x ?y))))

  (:action move-against-sentiero
    :parameters (?x ?y)
    :precondition (and (in ?x) (not-visitedEdge ?y ?x) (not-complete)
		       (sentiero ?y ?x))
    :effect (and (not (in ?x)) (in ?y) (visited ?y) (not (not-visited ?y)) (visitedEdge ?y ?x) (not (not-visitedEdge ?y ?x))))

  (:action move-along-erba
    :parameters (?x ?y)
    :precondition (and (in ?x) (not-complete)
           (erba ?x ?y))
    :effect (and (not (in ?x)) (in ?y) (visited ?y) ))

  (:action move-against-erba
    :parameters (?x ?y)
    :precondition (and (in ?x) (not-visited ?y) (not-complete)
           (erba ?y ?x))
    :effect (and (not (in ?x)) (in ?y) (visited ?y) ))


  ;; Ho bisogno di poter tornare indietro attualmente
  (:action move-back-along-erba
    :parameters (?x ?y)
    :precondition (and (in ?x) (visited ?y) (not-complete)
           (erba ?x ?y))
    :effect (and (not (in ?x)) (in ?y) (visited ?y)))

  ;; Ho bisogno di poter tornare indietro attualmente
  (:action move-back-against-erba
    :parameters (?x ?y)
    :precondition (and (in ?x) (visited ?y) (not-complete)
           (erba ?y ?x))
    :effect (and (not (in ?x)) (in ?y) (visited ?y)))

  ;;(:action finish-along
  ;;  :parameters (?x ?y)
  ;;  :precondition (and (in ?x) (finishing ?y) (not-visitedEdge ?x ?y) (visited ?y) (not-complete)
  ;;         (sentiero ?x ?y))
  ;;  :effect (and (not (in ?x)) (in ?y) (visitedEdge ?y ?x) (not (not-visitedEdge ?y ?x)) (visited ?y) (not (not-visited ?y)) (not (not-complete)) (complete) ))


  ;;(:action finish-against
  ;;  :parameters (?x ?y)
  ;;  :precondition (and (in ?x) (finishing ?y) (not-visitedEdge ?y ?x) (visited ?y) (not-complete)
  ;;         (sentiero ?y ?x))
  ;;  :effect (and (not (in ?x)) (in ?y) (visitedEdge ?y ?x) (not (not-visitedEdge ?y ?x)) (not (not-complete)) (complete) (visited ?y) (not (not-visited ?y)) ))



  ;; The "return" actions have to used to take the last step of the tour,
  ;; since this involves returning to a city allready visited (the starting
  ;; city).
  ;;(:action return-along
  ;;  :parameters (?x ?y)
  ;;  :precondition (and (in ?x) (starting ?y) (not-complete)
	;;	       (connected ?x ?y))
  ;;  :effect (and (not (in ?x)) (in ?y) (not (not-complete)) (complete)))
  ;;(:action return-against
  ;;  :parameters (?x ?y)
  ;;  :precondition (and (in ?x) (not-visited ?y) (not-complete)
	;;	       (connected ?y ?x))
  ;;  :effect (and (not (in ?x)) (in ?y) (not (not-complete)) (complete)))
 )