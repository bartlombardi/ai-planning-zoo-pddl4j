;; A TSP instance with ten cities.

(define (problem ten-cities)
  (:domain tsp-strips)
  (:objects entrata recintoLama bar orsi gabbiaLeoni fossaCoccodrilli casaElefanti gabbiaTigri casaScimmie areaPicnicToilette riservaUccelli casaPiccoliMammiferi casaRettili)
  (:init (connected entrata recintoLama) (connected entrata orsi)
         (connected entrata bar) (connected entrata gabbiaLeoni)
         (connected entrata casaElefanti) (connected entrata gabbiaTigri)
         (connected entrata fossaCoccodrilli) (connected entrata casaRettili)
         (connected entrata casaPiccoliMammiferi) 
         (connected entrata riservaUccelli) 
         (connected entrata areaPicnicToilette) (connected recintoLama casaElefanti)
         (connected orsi gabbiaLeoni) (connected orsi gabbiaTigri) (connected orsi fossaCoccodrilli)
         (connected orsi casaScimmie) (connected orsi casaRettili) (connected orsi casaPiccoliMammiferi)

         (connected orsi riservaUccelli) (connected orsi areaPicnicToilette)

         (not-visited recintoLama)
         (not-visited bar) (not-visited orsi) (not-visited gabbiaLeoni) 
         (not-visited fossaCoccodrilli) (not-visited casaElefanti) 
         (not-visited gabbiaTigri) (not-visited casaScimmie) 
         (not-visited areaPicnicToilette) (not-visited riservaUccelli) 
         (not-visited casaPiccoliMammiferi) (not-visited casaRettili)
         (in entrata) (starting entrata) (not-complete))

  (:goal (and (visited casaElefanti) (visited gabbiaLeoni)
              (visited recintoLama) (visited bar) (visited orsi)
              (visited riservaUccelli) (complete)))
  )


