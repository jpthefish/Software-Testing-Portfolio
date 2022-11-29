import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	@Test
	void testContactServiceAddsContact() {
		ContactService.add("124", "Oscar", "Forsythe", "1234567890", "143 N 5th St");
		assertTrue(ContactService.database.containsKey("124"));
	}

	@Test
	void testContactServiceUpdatesContact() {
		ContactService.add("123", "Ana", "Gutierrez", "1234567890", "143 N 5th St");
		String nameBeforeUpdate = ContactService.database.get("123").getFirstName();
		ContactService.update("123", "Annabelle", "Gutierrez", "1234567890", "143 N 5th St");
		String nameAfterUpdate = ContactService.database.get("123").getFirstName();
		assertNotEquals(nameBeforeUpdate, nameAfterUpdate);
	}
	
	@Test
	void testContactServiceDeletesContact() {
		ContactService.add("123", "Ana", "Gutierrez", "1234567890", "143 N 5th St");
		assertTrue(ContactService.database.containsKey("123"));
		ContactService.delete("123");
		assertFalse(ContactService.database.containsKey("123"));
	}
	
}
