#include <stdio.h>
#include <stdbool.h>

bool is_prime(int n){
    int i = 2;
    if(n < 2){
        return false;
    }
    while( (i*i) <= n){
        if( n%i == 0){
            return false;
        }
        i++;
    }
    return true;
}

int main() {
    int i = 0;
    int prime_count = 0;

    printf("Finding the first 1000 Primes\n");
    while(prime_count < 1000){
        if(is_prime(i)){
            prime_count++;
            printf("%d\n",i);
        }
        i++;
    }
    return 0;
}