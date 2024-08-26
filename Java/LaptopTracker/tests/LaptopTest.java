import java.util.Date;

import junit.framework.TestCase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class LaptopTest extends TestCase {
public void testGetLaptopID(){
	Laptop l1 = new Laptop();
	l1.setLaptopID("1");
	assertEquals("1", l1.getLaptopID());
}
public void testGetLaptopBrand(){
	Laptop l1 = new Laptop(); 
	l1.setLaptopID("1");
	l1.setLaptopBrand("Toshiba");
	assertEquals("1", l1.getLaptopID());
	assertEquals("Toshiba",l1.getLaptopBrand());
}

public void testGetPerson(){
	Laptop l1 = new Laptop();
	l1.setLaptopID("1");
	l1.setLaptopBrand("Toshiba");
	Person p1 = new Person();
	p1.setName("devin");
	p1.setStudentID("51601514");
	l1.setLaptopHolder(p1);
	assertEquals(p1,l1.getLaptopHolder());
}

public void testGetSignOutDate(){
	Laptop l1 = new Laptop();
	l1.setLaptopID("1");
	l1.setLaptopBrand("Toshiba");
	Person p1 = new Person();
	p1.setName("devin");
	p1.setStudentID("51601514");
	l1.setLaptopHolder(p1);
	Date today = new Date();
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	assertEquals(dateFormat.format(today),l1.getSignOutDate());
	
}
public void testAssembles(){
	Laptop l1 = new Laptop();
	l1.setLaptopID("1");
	l1.setLaptopBrand("Toshiba");
	Person p1 = new Person();
	p1.setName("devin");
	p1.setStudentID("51601514");
	l1.setLaptopHolder(p1);
	String laptopString = l1.toString();
	Laptop l2 = new Laptop();
	l2.AssembleFromString(laptopString);
	assertEquals(l2.toString(),l1.toString());
}
}
