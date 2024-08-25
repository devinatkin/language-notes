# Haskell Notes
```
ghc -o hello hello.hs
```
To compile haskell to a runnable program

```
-- Generating an infinite list of primes (This is the more functional method of getting primes)
primes :: [Int]
primes = sieve [2..]

sieve :: [Int] -> [Int]
sieve (p:xs) = p : sieve [x | x <- xs, x `mod` p/= 0]

-- From the infinite list take a definite list of just the 1000 first primes
first1000Primes :: [Int]
first1000Primes = take 1000 primes

-- Actually running the code and printing the values in this list
main :: IO ()
main = print first1000Primes

```

Haskell as a functional program is a bit difficult for certain operations like loops. Instead of using a for loop they use their sieve method as a form of recursive function.

## sieve function
Processes through lists of code.

## take function
Grabs the first x number of elements form the beggining of the list.