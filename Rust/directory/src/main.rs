use std::{fs, io};

fn main() -> io::Result<()>{
    println!("Printing all the files in a directory");

    let mut input = String::new();
    io::stdin().read_line(&mut input)?;
    let path = input.trim();

    let entries = fs::read_dir(path)?
        .map(|res| res.map(|e| e.path()))
        .collect::<Result<Vec<_>, io::Error>>()?;

    for entry in entries {
        println!("{}", entry.display());
    }

    Ok(())
}
