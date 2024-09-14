namespace HelloQuantum {

    // Allocate Qubits
    // use q1 = Qubit(); // Allocate 1 qubit
    // use q5 = Qubit[5]; // Allocate 5 qubits

    // Reset the qubit so it can be safely released
    // Reset(qubit);

    open Microsoft.Quantum.Intrinsic;

    @EntryPoint()
    operation SayHelloQ() : Unit {
        Message("Hello World! Q#");
    }
}