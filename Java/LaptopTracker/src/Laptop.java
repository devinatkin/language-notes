
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Laptop {
private String laptopID= "";
private String laptopBrand= "";
private Person laptopHolder;
private Date signOutDate;

public void setSignOutDate(Date signOutDate) {
	this.signOutDate = signOutDate;
}

public String getSignOutDate() {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	return dateFormat.format(signOutDate);
}

public Person getLaptopHolder() {
	return laptopHolder;
}

public void setLaptopHolder(Person laptopHolder) {
	
			this.laptopHolder = laptopHolder;
			signOutDate = new Date();
			if (laptopHolder == null){
				signOutDate= null;
			}
}

public String getLaptopBrand() {
	return laptopBrand;
}

public void setLaptopBrand(String laptopBrand){
	this.laptopBrand = laptopBrand;
}

public String getLaptopID() {
	return laptopID;
}

public void setLaptopID(String laptopID) {
	this.laptopID = laptopID;
}

public String toString(){
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String laptopString= "";

if (laptopHolder == null){ //TODO make more stable in future versions
	laptopString = laptopID + ";" + laptopBrand + ";" + "IN" + ";" + dateFormat.format(new Date());
}
else{
	laptopString =   laptopID + ";" + laptopBrand + ";" + laptopHolder.toString() + ";"+ dateFormat.format(signOutDate);
}
	return laptopString;
}

public void AssembleFromString(String laptopString) {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

	
	String parts[]= laptopString.split(";");
	laptopID = parts[0];
	laptopBrand = parts[1];

	if (parts[2].equals("IN") ){
		laptopHolder = null;
	}
	else{
		Person holder = new Person();
			holder.AssembleFromString(parts[2]);
			laptopHolder = holder;
	}
	
	try {
		signOutDate= dateFormat.parse(parts[3]);
	} catch (ParseException e) {
		signOutDate = new Date();
		e.printStackTrace();
	}
	
	
	
}

public String toShortString(){
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	String shortString= "";
	shortString = laptopID + laptopBrand;
	if (laptopHolder != null){
		shortString = shortString + ":" + laptopHolder.toShortString() + ":" +  dateFormat.format(signOutDate);
	}
	return shortString;
}


}
