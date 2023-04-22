import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        Assertions.assertEquals(contact, contactService.getContact("1"));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("1");
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.getContact("1"));
    }

    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateFirstName("1", "Jane");
        Assertions.assertEquals("Jane", contactService.getContact("1").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateLastName("1", "Smith");
        Assertions.assertEquals("Smith", contactService.getContact("1").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updatePhone("1", "9876543210");
        Assertions.assertEquals("9876543210", contactService.getContact("1").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateAddress("1", "456 Second St");
        Assertions.assertEquals("456 Second St", contactService.getContact("1").getAddress());
    }

    @Test
    public void testGetContactNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.getContact("1"));
    }

    @Test
    public void testAddDuplicateContactId() {
        Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1", "Jane", "Smith", "9876543210", "456 Second St");
        contactService.addContact(contact1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact2));
    }

    @Test
    public void testDeleteNonExistentContact() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("1"));
    }
}
