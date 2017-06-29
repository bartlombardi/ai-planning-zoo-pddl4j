(define (problem zoo-problem)
  (:domain zoo-world)
  (:objects t1 t2 t3 t4 t5 t6 t7 t8 t9 i1 i2 entrata lama bar orsi leoni coccodrilli elefanti tigri scimmie picnic uccelli mammiferi rettili)
  (:init 
         (connected t1 entrata) (connected t1 t2) (connected t1 bar)
         (connected t2 lama) (connected t2 elefanti)
         (connected t3 orsi) (connected t3 leoni) (connected t3 entrata)
         (connected t3 t4) (connected t4 leoni)  
         (connected t4 coccodrilli) (connected t4 tigri)
         (connected t4 t5)
         (connected t5 scimmie) (connected t5 i1)
         (connected t6 tigri)
         (connected t6 t7) (connected t6 t9) 
         (connected t7 t8) (connected t7 t9)
         (connected t8 mammiferi) (connected t8 i2) 
         (connected t9 rettili)
         (connected i1 i2) (connected i1 elefanti)
         (connected i1 bar) 
         (connected i2 uccelli)
         (connected i2 picnic)

         (visited entrata)
         (not-visited lama)
         (not-visited bar)
         (not-visited orsi) 
         (not-visited leoni) 
         (not-visited coccodrilli) 
         (not-visited elefanti) 
         (not-visited tigri) 
         (not-visited scimmie) 
         (not-visited picnic) 
         (not-visited uccelli) 
         (not-visited mammiferi) 
         (not-visited rettili)
         (not-visited t1) (not-visited t2) (not-visited t3) 
         (not-visited t4) (not-visited t5) (not-visited t6) 
         (not-visited t7) (not-visited t8) (not-visited t9)
         (not-visited I1) (not-visited I2) 
         (in entrata) (starting entrata) (finishing picnic) (not-complete))

  (:goal (and (visited elefAnti) (visited leoni) (visited lama) (visited bar) (visited orsi) (visited uccelli) (visited picnic) (complete)))
  )