import java.util.ArrayList;

import junit.framework.TestCase;


public class CartTest extends TestCase {
	
private	Cart c1 = new Cart();
private	Laptop l1 = new Laptop();
private	Person p1 = new Person();
private Person p2 = new Person();
public void testSignOut(){
	setup();
	c1.signOut(l1,p1);
	ArrayList<Laptop> TestArray;
	TestArray = c1.getUnavailableLaptops();
	assertTrue(TestArray.contains(l1));
	assertEquals(l1.getLaptopHolder().getName(), "devin");
	assertFalse(c1.signOut(l1, p2)); //If laptop is already signed out it returns false
	c1.signIn(l1);
	c1.signOut(l1,p2);
	assertEquals(l1.getLaptopHolder().getName(), "Bob");

}

private void setup() {
	 
	l1.setLaptopID("1");
	l1.setLaptopBrand("Toshiba");
	p1.setName("devin");
	p2.setName("Bob");
	p1.setStudentID("51601514");
	c1.addLaptop(l1);
	c1.addPerson(p2);
	c1.addPerson(p1);
}

public void testAssembles(){
	setup();
	Cart c2 = new Cart();
	Laptop l2 = new Laptop();
	l2.setLaptopID("5");
	l2.setLaptopBrand("devinTop");

	c1.addLaptop(l2);
	c1.signOut(l1, p2);
	c1.signOut(l2, p1);
	String cartString = c1.toString();
	c2.AssembleFromString(cartString);
	assertEquals(c1.toString(),c2.toString());
}

}
