
/* The Person Class is responsible for keeping track of information regarding each student */
public class Person {
private String Name = "_";
private String StudentID = "_";


public String getStudentID() {
	return StudentID;
}

public void setStudentID(String studentID) {
	StudentID = studentID;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}
public String toString(){
	String personString = "{" + Name + ":" + StudentID + "}";
	return personString;
}
public void AssembleFromString(String personString){
	personString = personString.substring(1, personString.length()-1);
	String[] parts =personString.split(":");
	Name = parts[0];
	StudentID = parts[1];
	
}

public String toShortString() {
	String shortString = Name + " " + StudentID;
	
	return shortString;
}

}
