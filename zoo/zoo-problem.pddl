;; A zoo-planner-problem instance.

(define (problem zoo-problem)
  (:domain tsp-strips)
  (:objects entrata recintoLama bar orsi gabbiaLeoni 
            fossaCoccodrilli casaElefanti gabbiaTigri
            casaScimmie areaPicnicToilette riservaUccelli
            casaPiccoliMammiferi casaRettili 
            ;;; T
            T1 T2 T3 T4 T5 T6 T7 T8 T9
            ;;; I
            I1 I2)
  (:init 
         (connected entrata T1) (connected entrata T3)
         (connected T1 T2) (connected T1 bar) 
         (connected T2 recintoLama) (connected T2 casaElefanti)
         (connected T3 orsi) (connected T3 gabbiaLeoni)
         (connected gabbiaLeoni T4) (connected T3 T4)
         (connected T4 fossaCoccodrilli) (connected T4 gabbiaTigri)
         (connected T4 T5) (connected T5 casaScimmie) (connected T5 I1)
         (connected gabbiaTigri T6)
         (connected T6 T9) (connected T6 T7) (connected T7 T9)
         (connected T9 casaRettili) 
         (connected T7 T8) (connected T8 casaPiccoliMammiferi)
         (connected T8 I2) (connected I2 riservaUccelli)
         (connected I2 areaPicnicToilette)
         (connected I1 I2) (connected casaElefanti I1)
         (connected bar I1)

         (not-visited recintoLama)
         (not-visited bar)
         (not-visited orsi) 
         (not-visited gabbiaLeoni) 
         (not-visited fossaCoccodrilli) 
         (not-visited casaElefanti) 
         (not-visited gabbiaTigri) 
         (not-visited casaScimmie) 
         (not-visited areaPicnicToilette) 
         (not-visited riservaUccelli) 
         (not-visited casaPiccoliMammiferi) 
         (not-visited casaRettili)
         (not-visited T1) (not-visited T2) (not-visited T3) 
         (not-visited T4) (not-visited T5) (not-visited T6) 
         (not-visited T7) (not-visited T8) (not-visited T9)

         (not-visited I1) (not-visited I2) 

         (in entrata) (starting entrata) (not-complete))

  (:goal (and (visited casaElefanti) (visited gabbiaLeoni)
              (visited recintoLama) (visited bar) (visited orsi)
              (visited riservaUccelli) (complete)))
  )
