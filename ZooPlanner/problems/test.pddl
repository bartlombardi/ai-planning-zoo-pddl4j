(define (problem zoo)
(:domain test)
(:objects visitor camel1 camel2 camel3 entrance n1 n2 n3 n4 n5 n6 n7 n8 n9 n10 smammal bird tiger bear lama bar lion monkey wc eleph croc reptile)
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

	(to-discover entrance)
	(to-discover n1)
	(to-discover n2)
	(to-discover n3)
	(to-discover n4)
	(to-discover n5)
	(to-discover n6)
	(to-discover n7)
	(to-discover n8)
	(to-discover n9)
	(to-discover n10)
	(to-discover smammal)
	(to-discover bird)
	(to-discover tiger)
	(to-discover bear)
	(to-discover lama)
	(to-discover bar)
	(to-discover lion)
	(to-discover monkey)
	(to-discover wc)
	(to-discover eleph)
	(to-discover croc)
	(to-discover reptile)

	(shadow entrance n1) (shadow n1 entrance) (able-to-walk entrance n1) (able-to-walk n1 entrance)
	(shadow n1 n2) (shadow n2 n1) (able-to-walk n1 n2) (able-to-walk n2 n1)
	(shadow n2 smammal) (shadow smammal n2) (able-to-walk n2 smammal) (able-to-walk smammal n2)
	(shadow n3 tiger) (shadow tiger n3) (able-to-walk n3 tiger) (able-to-walk tiger n3)
	(shadow n4 bear) (shadow bear n4) (able-to-walk n4 bear) (able-to-walk bear n4)
	(shadow n7 monkey) (shadow monkey n7) (able-to-walk n7 monkey) (able-to-walk monkey n7)
	(shadow n8 wc) (shadow wc n8) (able-to-walk n8 wc) (able-to-walk wc n8)
	(shadow n9 eleph) (shadow eleph n9) (able-to-walk n9 eleph) (able-to-walk eleph n9)
	(shadow n10 croc) (shadow croc n10) (able-to-walk n10 croc) (able-to-walk croc n10)
	(road entrance n3) (road n3 entrance) (able-to-walk entrance n3) (able-to-walk n3 entrance)
	(road n1 bird) (road bird n1) (able-to-walk n1 bird) (able-to-walk bird n1)
	(road n2 bar) (road bar n2) (able-to-walk n2 bar) (able-to-walk bar n2)
	(road n3 n4) (road n4 n3) (able-to-walk n3 n4) (able-to-walk n4 n3)
	(road n3 lama) (road lama n3) (able-to-walk n3 lama) (able-to-walk lama n3)
	(road n4 n5) (road n5 n4) (able-to-walk n4 n5) (able-to-walk n5 n4)
	(road n4 n7) (road n7 n4) (able-to-walk n4 n7) (able-to-walk n7 n4)
	(road n5 lama) (road lama n5) (able-to-walk n5 lama) (able-to-walk lama n5)
	(road n5 lion) (road lion n5) (able-to-walk n5 lion) (able-to-walk lion n5)
	(road n6 n7) (road n7 n6) (able-to-walk n6 n7) (able-to-walk n7 n6)
	(road n6 bar) (road bar n6) (able-to-walk n6 bar) (able-to-walk bar n6)
	(road n8 n9) (road n9 n8) (able-to-walk n8 n9) (able-to-walk n9 n8)
	(road n8 reptile) (road reptile n8) (able-to-walk n8 reptile) (able-to-walk reptile n8)
	(road n9 n10) (road n10 n9) (able-to-walk n9 n10) (able-to-walk n10 n9)
	(road n9 lion) (road lion n9) (able-to-walk n9 lion) (able-to-walk lion n9)
	(road n10 lion) (road lion n10) (able-to-walk n10 lion) (able-to-walk lion n10)
	(camelroad n6 n8) (camelroad n8 n6) (able-to-ride n6 n8) (able-to-ride n8 n6)
	(camelroad n6 bird) (camelroad bird n6) (able-to-ride n6 bird) (able-to-ride bird n6))
(:goal (and
	(not (to-discover lion))
	(not (to-discover eleph))
	(not (to-discover monkey))
	(not (to-discover bear))
	(at visitor croc)))
)