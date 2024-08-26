import java.util.ArrayList;


public class Cart {
private ArrayList<Laptop> laptops = new ArrayList<Laptop>();
private ArrayList<Person> people = new ArrayList<Person>();
	public void addLaptop(Laptop newLaptop) {
	this.laptops.add(newLaptop);
	}

	public void addPerson(Person newPerson) {
		people.add(newPerson);
	}

	public boolean signOut(Laptop l1, Person p1) {
		Person currentHolder = l1.getLaptopHolder();
		if (currentHolder == null){ //TODO find more stable way of representing an empty person
			l1.setLaptopHolder(p1);
			return true;
		}
		else{
			return false; //if laptop is signed out already then return false
		}
		
	}
	public boolean signIn(Laptop l1){
		if (l1.getLaptopHolder() != null){
			l1.setLaptopHolder(null);
			return true;
		}
		else{
			return false; //If laptop is already signed out then return a false
		}
	}
	
	
	
	
	public ArrayList<Laptop> getUnavailableLaptops() {
	ArrayList<Laptop> result = new ArrayList<Laptop>();
	for (Laptop aLaptop: laptops){
		if (aLaptop.getLaptopHolder() != null){
			result.add(aLaptop);
		}
	}
	return result;
	}
	public ArrayList<Laptop> getAvailableLaptops() {
		ArrayList<Laptop> result = new ArrayList<Laptop>();
		for (Laptop aLaptop: laptops){
			if (aLaptop.getLaptopHolder() == null){
				result.add(aLaptop);
			}
		}
		return result;
		}  
	public String toString(){
		String cartString= people.toString() + "-"+ laptops.toString();
		return cartString;
	}

	public void AssembleFromString(String cartString) {
	cartString = cartString.replace("[", "");
	cartString = cartString.replace("]", "");
	String parts[] = cartString.split("-");
	//deals with the people section of the cart string
	String peopleString = parts[0];
	
	String peopleParts[] = peopleString.split(", ");
	for (String stringPerson: peopleParts){
		Person pHolder = new Person();
		pHolder.AssembleFromString(stringPerson);
		addPerson(pHolder);
		}
		
	//deals with the laptop section of the cart string
	String laptopString = parts[1];

	String laptopParts[] = laptopString.split(", ");
	for (String stringLaptop: laptopParts){
				Laptop lHolder = new Laptop();

			lHolder.AssembleFromString(stringLaptop);
			addLaptop(lHolder);
	}	
		
		

		
	}
	public ArrayList<Laptop> getLaptops(){
		return laptops;
	}
}
