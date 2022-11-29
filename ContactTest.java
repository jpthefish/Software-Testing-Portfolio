import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	@Test
	void testContact() {
		Contact contact = new Contact("12", "Ana", "Gutierrez", "1234567890", "143 N 5th St");
		assertTrue(contact.getContactID().equals("12"));
		assertTrue(contact.getFirstName().equals("Ana"));
		assertTrue(contact.getLastName().equals("Gutierrez"));
		assertTrue(contact.getPhone().equals("1234567890"));
		assertTrue(contact.getAddress().equals("143 N 5th St"));
	}

	@Test
	void testContactIDNotUnique() {
		new Contact("123", "Ana", "Gutierrez", "1234567890", "143 N 5th St");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "Ana", "Gutierrez", "1234567890", "143 N 5th St");
		});
	}
	
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789010231", "Ana", "Gutierrez", "1234567890", "143 N 5th St");
		});	
	}
	
	@Test
	void testContactIDIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Ana", "Gutierrez", "1234567890", "143 N 5th St");
		});	
	}
	
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "Anabelladellapella", "Gutierrez", "1234567890", "143 N 5th St");
		});
	}
	
	@Test
	void testContactFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", null, "Gutierrez", "1234567890", "143 N 5th St");
		});	
	}
	
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "Ana", "GutierrezGutierrezGutierrez", "1234567890", "143 N 5th St");
		});
	}
	
	@Test
	void testContactLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "Ana", null, "1234567890", "143 N 5th St");
		});
	}
	
	@Test
	void testContactPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "Ana", "Gutierrez", "1234567890123465780", "143 N 5th St");
		});
	}
	
	@Test
	void testContactPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "Ana", "Gutierrez", "12345", "143 N 5th St");
		});
	}
	
	@Test
	void testContactPhoneIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "Ana", "Gutierrez", null, "143 N 5th St");
		});
	}
	
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "Ana", "Gutierrez", "1234567890", "143 N 5th St143 N 5th St143 N 5th St");
		});
	}
	
	@Test
	void testContactAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "Ana", "Gutierrez", "1234567890", null);
		});
	}
	
	@Test
	void contactDeletesID() {
		new Contact("125", "Ana", "Gutierrez", "1234567890", "143 N 5th St");
		Contact.deleteContactID("125");
		assertFalse(Contact.IDList.contains("125"));
	}
}
