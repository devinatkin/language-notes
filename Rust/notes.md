# Rust Notes
Going to need a rust cheat sheet to relearn this language.

## Berylium Library
Requires that SDL2 be available. In windows I was able to add the needed dll to the debug folder to get cargo run to function as expected. 

Pong is basic and essentially only Semi-functioning but sufficient to draw windows and make further projects so I'm satisfied for this repository. 

## Cargo 
Cargo is the rust project manager program for initializing directories, adding libraries, and running the code. 

```
cargo init .
```
This will initialize the current directory with a Cargo.lock and a Cargo.toml file.

```
cargo run
```
This will run the current rust project