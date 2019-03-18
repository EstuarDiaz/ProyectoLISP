(print "Hello, welcome to this program")
(print "Choose n")
(define n (read))

(define factorial (lambda (x)
  (
    if(= x 1)(* x 1)(* x (factorial (- x 1)))
  )
))

(define result (factorial n))
(print "Factorial: ")
(print result)