namespace QuantumRandomNumberGenerator {
    open Microsoft.Quantum.Convert;
    open Microsoft.Quantum.Intrinsic;
    open Microsoft.Quantum.Math;


    operation GenerateRandomBit() : Result {
        // Allocate a qubit
        use q = Qubit();

        // Set the qubit into a superposition of 0 and 1 using the Hadamard
        H(q);

        // At this point the qubit 'q' has 50/50 odds of being measured
        // |0〉 or |1〉;

        // We measure the qubit and grab the result using the M oepration
        let result = M(q);


        // Reset the qubit (THIS IS MANDATORY TO RELEASE THE QUBIT!!!)
        Reset(q);

        return result;
    }

    // Generate a random number between 0 and max
    operation GenerateRandomNumberInRange(max: Int) : Int {
        // Determine the number of bits needed to represent the 'max' value and store it.
        mutable bits = [];
        let nBits = BitSizeI(max);

        for idxBit in 1..nBits {
            set bits += [GenerateRandomBit()];
        }
        let sample = ResultArrayAsInt(bits);

        // (The guide says to only return if it's within range. My question is... can it not be?)
        return sample > max ? GenerateRandomNumberInRange(max) | sample;
    }

    @EntryPoint()
    operation Main() : Int {
        let max = 100;
        Message($"Generating a random number between 0 and {max}");

        return GenerateRandomNumberInRange(max);
    }

}