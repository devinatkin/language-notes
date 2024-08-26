import junit.framework.TestCase;


public class PersonTest extends TestCase {
public void testGetName(){
	Person p1 = new Person();
	p1.setName("devin");
	assertEquals("devin",p1.getName());
}
public void testGetStudentID(){
	Person p1 = new Person();
	p1.setName("devin");
	p1.setStudentID("51601514");
	assertEquals("devin",p1.getName());
	assertEquals("51601514",p1.getStudentID());
}
public void testAssemble(){
	Person p1 = new Person();
	p1.setName("devin");
	p1.setStudentID("51601514");
	String personString = p1.toString();
	Person p2 = new Person();
	
	p2.AssembleFromString(personString);
	assertEquals(p2.toString(),p1.toString());
	
}
}
