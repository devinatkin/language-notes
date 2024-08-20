#!/usr/bin/perl
use warnings;
print("Finding the first 1000 Prime Numbers in Perl\n");

my $i = 1;
my $prime_count=0;

sub is_prime{
    my ($n) = @_;
    if ($n < 2){
        return 0;
    }

    my $counter = 2;
    while($counter * $counter <= $n){
        if ($n % $counter == 0){
            return 0;
        }
        $counter = $counter + 1;
    }
    return 1;
}

while ($prime_count < 1000) {
    if (is_prime($i)){
        print("$i\n");
        $prime_count = $prime_count + 1;
    }
    $i = $i + 1;

}