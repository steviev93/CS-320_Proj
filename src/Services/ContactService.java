package Services;

import Models.Contact;
import Models.Task;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    Map<String, Contact> contactHashMap = new HashMap<String, Contact>();

    public Map<String, Contact> getContactHashMap() {
        return contactHashMap;
    }
    public void addContact(String id, String firstName, String lastName, String phoneNumber, String address) {
        Contact c = new Contact(id, firstName, lastName, phoneNumber, address);
        if (contactHashMap.containsKey(id)) throw new IllegalArgumentException("Duplicate ID exists. Select another");
        else contactHashMap.put(id, c);
    }
    public void updateContact(String id, String firstName, String lastName, String phoneNumber, String address) {
        if (!contactHashMap.containsKey(id)) throw new IllegalArgumentException("ID does not exist");
        Contact c = contactHashMap.get(id);
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setPhoneNumber(phoneNumber);
        c.setAddress(address);
        contactHashMap.put(id, c);
    }
    public void deleteContact(String id) {
        if (!contactHashMap.containsKey(id)) throw new IllegalArgumentException("ID does not exist");
        else contactHashMap.remove(id);
    }


}
