fn main() {
    println!("Find the First 100 Prime Finders");
    let mut i: i32 = 1;
    let mut prime_count: i32 = 0;

    while prime_count < 1000 {
        if is_prime(i) {
            prime_count += 1;
            println!("{}", i)
        }

        i += 1;
    }
}

fn is_prime(n: i32) -> bool{
    let mut i: i32 = 2;
    if n < 2 {
        return false;
    }
    while (i*i) <= n{
        if n%i == 0 {
            return false;
        }
        i += 1;
    }
    return true;
}