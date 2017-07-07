(define (problem zooproblem)
  (:domain zoo)
  (:objects visitor camel1 camel2 camel3
            n1 n2 n3 n4 n5 n6 n7 n8 n9 n10
            entrance lama bar bear lion
            elep croc tiger monkey bird
            smallmammal reptile wc)
  (:init
    (visitor visitor)
    (mobile visitor)
    (able-to-climb visitor)
    (camel camel1)
    (camel camel2)
    (camel camel3)

    (at visitor entrance)
    (at camel1 bar)
    (at camel2 n5)
    (at camel3 n7)

    (to-discover n1) (to-discover n2) (to-discover n3) (to-discover n4)
    (to-discover n5) (to-discover n6) (to-discover n7) (to-discover n8)
    (to-discover n9)
    (to-discover lama)
    (to-discover bar)
    (to-discover bear)
    (to-discover lion)
    (to-discover elep)
    (to-discover croc)
    (to-discover tiger)
    (to-discover monkey)
    (to-discover bird)
    (to-discover smallmammal)
    (to-discover reptile)
    (to-discover wc)

    (shadow entrance n2) (shadow n2 entrance)
    (shadow n2 n1) (shadow n1 n2)
    (shadow n1 lama) (shadow lama n1)
    (shadow n3 bear) (shadow bear n3)
    (shadow n4 croc) (shadow croc n4)
    (shadow n6 monkey) (shadow monkey n6)
    (shadow n7 bird) (shadow bird n7)
    (shadow n8 smallmammal) (shadow smallmammal n8)
    (shadow n9 reptile) (shadow reptile n9)

    (road n1 elep) (road elep n1)
    (road n2 bar) (road bar n2)
    (road elep n5) (road n5 elep)
    (road entrance n3) (road n3 entrance)
    (road n3 lion) (road lion n3)
    (road n3 n4) (road n4 n3)
    (road n4 n10) (road n10 n4)
    (road n10 lion) (road lion n10)
    (road n10 tiger) (road tiger n10)
    (road n4 n6) (road n6 n4)
    (road n6 n5) (road n5 n6)
    (road tiger n8) (road n8 tiger)
    (road tiger n9) (road n9 tiger)
    (road n9 n8) (road n8 n9)
    (road n8 n7) (road n7 n8)
    (road n7 wc) (road wc n7)
    (able-to-walk n1 elep) (able-to-walk elep n1)
    (able-to-walk n2 bar) (able-to-walk bar n2)
    (able-to-walk elep n5) (able-to-walk n5 elep)
    (able-to-walk entrance n3) (able-to-walk n3 entrance)
    (able-to-walk n3 lion) (able-to-walk lion n3)
    (able-to-walk n3 n4) (able-to-walk n4 n3)
    (able-to-walk n4 n10) (able-to-walk n10 n4)
    (able-to-walk n10 lion) (able-to-walk lion n10)
    (able-to-walk n10 tiger) (able-to-walk tiger n10)
    (able-to-walk n4 n6) (able-to-walk n6 n4)
    (able-to-walk n6 n5) (able-to-walk n5 n6)
    (able-to-walk tiger n8) (able-to-walk n8 tiger)
    (able-to-walk tiger n9) (able-to-walk n9 tiger)
    (able-to-walk n9 n8) (able-to-walk n8 n9)
    (able-to-walk n8 n7) (able-to-walk n7 n8)
    (able-to-walk n7 wc) (able-to-walk wc n7)

    (camelroad bar n5) (camelroad n5 bar)
    (camelroad n5 n7) (camelroad n7 n5)
    (able-to-ride bar n5) (able-to-ride n5 bar)
    (able-to-ride n5 n7) (able-to-ride n7 n5)
  )

  (:goal (and
          (not (to-discover elep))
          (not (to-discover lion))
          (not (to-discover lama))
          (not (to-discover bar))
          (not (to-discover bear))
          (not (to-discover bird))
          (at visitor wc)))
)
