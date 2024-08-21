Write-Output "Finding the First 1000 Primes using Powershell!"

function is_prime{
    param (
        [int]$n
    )
    $i = 2
    if ($n -lt 2){
        return $false
    }
    while( $i * $i -le $n) {
        if ($n % $i -eq 0){
            return $false
        }
        $i = $i + 1
    }
    return $true
}

$prime_count = 0
$num = 1

while($prime_count -lt 1000){
    $result = is_prime -n $num
    if($result){
        $prime_count = $prime_count + 1
        Write-Output $num
    }
    $num = $num + 1
}