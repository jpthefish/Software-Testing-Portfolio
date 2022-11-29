import java.util.Hashtable;

public class ContactService {

	// Contact database is a hash table that stores contactIDs and corresponding contacts
	static Hashtable<String, Contact> database = new Hashtable<String, Contact>();
	
	public static void add(String contactID, String firstName, String lastName, String phone, String address) {
		Contact newContact = new Contact(contactID, firstName, lastName, phone, address);
		database.put(contactID, newContact);
	}
	
	public static void update(String contactID, String firstName, String lastName, String phone, String address) {
		delete(contactID);
		add(contactID, firstName, lastName, phone, address);
	}
	
	public static void delete(String contactID) {
		Contact.deleteContactID(contactID);
		database.remove(contactID);
	}

	/*
	public static void main(String[] args) {		
		add("123", "Ana", "Gutierrez", "1234567890", "143 N 5th St");
	}
	*/

}