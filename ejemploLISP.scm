(print "Hello, welcome to this program")
(print "Choose what do you want to do")
(print "Choose the first number")
(define a (read))
(print "Choose the second number")
(define b (read))
(print "1. Sum")
(print "2. Substraction")
(print "3. Multiplication")
(print "4. Division")
(print "5. Quit")
(print "Select an option")
(define opcion(read))

(if(= opcion 1) (print(+ a b)) (
  if(= opcion 2) (print(- a b)) (
    if(= opcion 3) (print(* a b)) (
      if(= opcion 4) (print(/ a b)) (print "Bye!")
    )
  )
))