package main

import "fmt"

func is_prime(n int) bool {
	var i int = 2
	if n < 2 {
		return false
	}
	for i*i <= n {
		if n%i == 0 {
			return false
		}
		i++
	}
	return true
}

func main() {
	fmt.Println("Finding the first 1000 Prime Numbers")
	var prime_count int = 0
	var n int = 1
	for prime_count < 1000 {
		if is_prime(n) {
			prime_count++
			fmt.Println(n)
		}
		n++
	}
}
