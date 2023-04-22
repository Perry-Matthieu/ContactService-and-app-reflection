import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts;
    
    public ContactService() {
        contacts = new HashMap<>();
    }
    
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getId())) {
            throw new IllegalArgumentException("Contact with ID " + contact.getId() + " already exists");
        }
        contacts.put(contact.getId(), contact);
        System.out.println("Contact Added");
    }
    
    public void deleteContact(String id) {
        if (!contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact with ID " + id + " does not exist");
        }
        contacts.remove(id);
        System.out.println("Contact Removed");
    }
    
    public void updateFirstName(String id, String firstName) {
        if (!contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact with ID " + id + " does not exist");
        }
        Contact contact = contacts.get(id);
        contact.setFirstName(firstName);
        System.out.println("Successfully Updated");
    }
    
    public void updateLastName(String id, String lastName) {
        if (!contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact with ID " + id + " does not exist");
        }
        Contact contact = contacts.get(id);
        contact.setLastName(lastName);
        System.out.println("Successfully Updated");
    }
    
    public void updatePhone(String id, String phone) {
        if (!contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact with ID " + id + " does not exist");
        }
        Contact contact = contacts.get(id);
        contact.setPhone(phone);
        System.out.println("Successfully Updated");
    }
    
    public void updateAddress(String id, String address) {
        if (!contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact with ID " + id + " does not exist");
        }
        Contact contact = contacts.get(id);
        contact.setAddress(address);
        System.out.println("Successfully Updated");
    }
    
    public Contact getContact(String id) {
        if (!contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact with ID " + id + " does not exist");
        }
        return contacts.get(id);
    }
}
