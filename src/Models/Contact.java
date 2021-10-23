package Models;

public class Contact {
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    public String getId() {
        return id;
    }
//    I was unsure of whether to include this, since if you leave out the setter method, you can't modify it
//    I would appreciate feedback as to whether this is necessary, but here it is, commented out
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Contact(String id, String firstName, String lastName, String phoneNumber, String address) {
        if (id.length() > 10 || id == null) throw new IllegalArgumentException("Invalid ID");
        if (firstName.length() > 10 || firstName == null) throw new IllegalArgumentException("Invalid first name");
        if (lastName.length() > 10 || lastName == null) throw new IllegalArgumentException("Invalid last name");
        if (phoneNumber.length() != 10 || phoneNumber == null) throw new IllegalArgumentException("Invalid phone number");
        if (address.length() > 30 || address == null) throw new IllegalArgumentException("Invalid address");
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }
}
