#include <iostream>

bool isPrime(int i){
    if(i < 2){
        return false;
    }
    int n = 2;
    while((n*n) <= i){
        if (i%n == 0){
            return false;
        }
        n++;
    }
    return true;
}

int main() {
    std::cout << "Finding the first 1000 Primes" << std::endl;
    int i = 0;
    int prime_count = 0;
    while (prime_count < 1000){
        if(isPrime(i)){
            std::cout << i << std::endl;
            prime_count += 1;
        }
        i++;
    }
    return 0;
}