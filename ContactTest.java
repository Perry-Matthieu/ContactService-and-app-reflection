import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTest {
    @Test
    public void testCreateContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Assertions.assertEquals("1", contact.getId());
        Assertions.assertEquals("John", contact.getFirstName());
        Assertions.assertEquals("Doe", contact.getLastName());
        Assertions.assertEquals("1234567890", contact.getPhone());
        Assertions.assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact contact = new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testNullFirstName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact contact = new Contact("1", null, "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testNullLastName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact contact = new Contact("1", "John", null, "1234567890", "123 Main St");
        });
    }

    @Test
    public void testInvalidPhone() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact contact = new Contact("1", "John", "Doe", "12345678901", "123 Main St");
        });
    }

    @Test
    public void testNullAddress() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact contact = new Contact("1", "John", "Doe", "1234567890", null);
        });
    }
}
