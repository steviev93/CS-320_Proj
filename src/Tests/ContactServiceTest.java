package Tests;

import Models.Contact;
import Services.ContactService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class ContactServiceTest {
    //Creating contacts for tests
    Contact c1 = new Contact(
            "24iilo",
            "Barbera",
            "Streisand",
            "1234567890",
            "42 Wallaby Way");
    Contact c2 = new Contact(
            "llao91",
            "James",
            "Bond",
            "1234567890",
            "42 Wallaby Way");
    ContactService contactService = new ContactService();

    @Test
    void testAddContact() {

        contactService.addContact(
                c1.getId(),
                c1.getFirstName(),
                c1.getLastName(),
                c1.getPhoneNumber(),
                c1.getAddress());
        contactService.addContact(
                c2.getId(),
                c2.getFirstName(),
                c2.getLastName(),
                c2.getPhoneNumber(),
                c2.getAddress());

        //Asserting Ids are in hashmap
        assertTrue(contactService.getContactHashMap().containsKey(c1.getId()));
        assertTrue(contactService.getContactHashMap().containsKey(c2.getId()));

        //Asserting fields match for c1
        assertEquals(contactService.getContactHashMap().get(c1.getId()).getFirstName(), c1.getFirstName());
        assertEquals(contactService.getContactHashMap().get(c1.getId()).getLastName(), c1.getLastName());
        assertEquals(contactService.getContactHashMap().get(c1.getId()).getPhoneNumber(), c1.getPhoneNumber());
        assertEquals(contactService.getContactHashMap().get(c1.getId()).getAddress(), c1.getAddress());

        //Asserting fields match for c2
        assertEquals(contactService.getContactHashMap().get(c2.getId()).getFirstName(), c2.getFirstName());
        assertEquals(contactService.getContactHashMap().get(c2.getId()).getLastName(), c2.getLastName());
        assertEquals(contactService.getContactHashMap().get(c2.getId()).getPhoneNumber(), c2.getPhoneNumber());
        assertEquals(contactService.getContactHashMap().get(c2.getId()).getAddress(), c2.getAddress());

    }

    @Test
    void duplicateKeyTest() {
        contactService.addContact(
                c1.getId(),
                c1.getFirstName(),
                c1.getLastName(),
                c1.getPhoneNumber(),
                c1.getAddress());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(
                    "24iilo",
                    "Peter",
                    "Parker",
                    "1234567890",
                    "42 Wallaby Way");

        });
    }

    @Test
    void testDeleteContact() {

        contactService.addContact(
                c1.getId(),
                c1.getFirstName(),
                c1.getLastName(),
                c1.getPhoneNumber(),
                c1.getAddress());


        contactService.deleteContact(c1.getId());
        assertTrue(!contactService.getContactHashMap().containsKey(c1.getId()));
    }

    @Test
    void testUpdateContactExists() {

        contactService.addContact(
                c1.getId(),
                c1.getFirstName(),
                c1.getLastName(),
                c1.getPhoneNumber(),
                c1.getAddress());

        //testing non-existent key first
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact(
                    "somekey",
                    "Peter",
                    "Parker",
                    "1234567890",
                    "42 Wallaby Way");

        });
    }
    @Test
    void testUpdateContact() {

        contactService.addContact(
                c1.getId(),
                c1.getFirstName(),
                c1.getLastName(),
                c1.getPhoneNumber(),
                c1.getAddress());

        contactService.updateContact(
                "24iilo",
                "Peter",
                "Parker",
                "1234567890",
                "42 Wallaby Way"
        );
        assertEquals(contactService.getContactHashMap().get(c1.getId()).getFirstName(), "Peter");
        assertEquals(contactService.getContactHashMap().get(c1.getId()).getLastName(), "Parker");
        assertEquals(contactService.getContactHashMap().get(c1.getId()).getPhoneNumber(), "1234567890");
        assertEquals(contactService.getContactHashMap().get(c1.getId()).getAddress(), "42 Wallaby Way");

    }
}
