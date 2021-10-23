package Tests;

import Models.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    void testContactCreate() {
        Contact c = new Contact(
                "24iilo",
                "Barbera",
                "Streisand",
                "1234567890",
                "42 Wallaby Way");
        assertEquals(c.getId(),"24iilo");
        assertEquals(c.getFirstName(), "Barbera");
        assertEquals(c.getLastName(), "Streisand");
        assertEquals(c.getPhoneNumber(),"1234567890");
        assertEquals(c.getAddress(),"42 Wallaby Way");
    }

    @Test
    void testIDLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact(
                    "24iilo10938",
                    "Barbera",
                    "Streisand",
                    "1234567890",
                    "42 Wallaby Way");

        });
    }
    @Test
    void testIDNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Contact c = new Contact(
                    null,
                    "Barbera",
                    "Streisand",
                    "1234567890",
                    "42 Wallaby Way");

        });
    }
    @Test
    void testFirstNameLength() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact(
                    "24iilo",
                    "Barbera204970917",
                    "Streisand",
                    "1234567890",
                    "42 Wallaby Way");

        });
    }
    @Test
    void testFirstNameNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Contact c = new Contact(
                    "24iilo",
                    null,
                    "Streisand",
                    "1234567890",
                    "42 Wallaby Way");

        });
    }

    @Test
    void testLastNameLength() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact(
                    "24iilo",
                    "Barbera",
                    "Streisand11",
                    "1234567890",
                    "42 Wallaby Way");

        });
    }
    @Test
    void testLastNameNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Contact c = new Contact(
                    "24iilo",
                    "Barbera",
                    null,
                    "1234567890",
                    "42 Wallaby Way");

        });
    }
    @Test
    void testPhoneNumberLength() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact(
                    "24iilo",
                    "Barbera",
                    "Streisand",
                    "123456789",
                    "42 Wallaby Way");

        });
    }
    @Test
    void testPhoneNumberNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Contact c = new Contact(
                    "24iilo",
                    "Barbera",
                    "Streisand",
                    null,
                    "42 Wallaby Way");

        });
    }
    @Test
    void testAddressLength() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Contact c = new Contact(
                    "24iilo",
                    "Barbera",
                    "Streisand",
                    "1234567890",
                    "42 Wallaby Way, Sydney, Australia,130981902784");

        });
    }
    @Test
    void testAddressNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Contact c = new Contact(
                    "24iilo",
                    "Barbera",
                    "Streisand",
                    "1234567890",
                    null);

        });
    }
}
