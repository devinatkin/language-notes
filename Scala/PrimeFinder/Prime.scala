object Prime {

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

    def main(args: Array[String]) = {
        println("Finding the First 1000 Prime Numbers.")
        var Prime_Count: Int = 0
        var i: Int = 1

        while(Prime_Count < 1000){
            if(is_prime(i)){
                Prime_Count += 1
                println(i)
            }
            i += 1
        }
    }
}