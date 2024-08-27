# Scala Notes

```
scalac Hello.scala
```
This will compile scala code into an executable.

```
scala Hello
```
This will then run the scala code.

## Functions

```
    def is_prime(i: Int): Boolean = {
        if (i < 2) {
            return false
        }
        var n: Int = 2
        while((n*n) <= i){
            if(i%n == 0){
                return false
            }
            n += 1
        }

        return true
    }
```

Functions are methods. 

```
val greet = (name: String) => println(s"Hello, $name!")
```

Anonymous Functions (Lambda Functions), this uses the whole =>

```
def applyFunction(f: (Int, Int) => Int, a: Int, b: Int): Int = {
  f(a, b)
}
```

Higher Order functions, can take or recieve functions as their inputs or outputs.

## Variables (val vs var)
val is for variables which are non-mutable.
var is for variables which are mutable.

## Chisel Notes
This is the reason I'm interested in Scala as it's an HDL version of the language.