import java.util.HashSet;

public class Contact {
	static HashSet<String> IDList = new HashSet<String>();
	final private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		if (contactID == null || contactID.length() > 10 || IDList.contains(contactID)) {
			throw new IllegalArgumentException("Invalid contactID");
		}
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		
		IDList.add(contactID);
	}
	
	public static void deleteContactID(String contactID) {
		if (IDList.contains(contactID)) {
			IDList.remove(contactID);
		} else {
			System.out.println("No delete occured, no ID found");
		}
	}
	
	public String getContactID() {
		return contactID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
}
