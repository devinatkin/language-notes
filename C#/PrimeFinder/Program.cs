// See https://aka.ms/new-console-template for more information
using System.Security.Cryptography.X509Certificates;

Console.WriteLine("Finding the first 1000 Prime Numbers");

bool IsPrime(int n){
    if(n<2){
        return false;
    }
    int i = 2;
    while (i*i <= n){
        if(n % i == 0){
            return false;
        }
        i += 1;
    }
    return true;
}

int i = 0;
int prime_counter = 0;

while(prime_counter < 1000){
    if(IsPrime(i)){
        prime_counter += 1;
        Console.WriteLine(i);
    }
    i += 1;
}