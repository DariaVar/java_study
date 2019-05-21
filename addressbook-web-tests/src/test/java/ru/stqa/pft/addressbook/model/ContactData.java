package ru.stqa.pft.addressbook.model;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String lastname;
    private String address;
    private String home;
    private String email;
    private String email2;
    private String email3;
    private String group;
    private String homePhone;
    private String workPhone;
    private  String mobilPhone;
    private String allPhones;
    private String allEmails;


    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHome(String home) {
        this.home = home;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }
    public ContactData withEmail2(String email) {
        this.email = email;
        return this;
    }
    public ContactData withEmail3(String email) {
        this.email = email;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }


    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }
    public ContactData withMobilPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }
    public ContactData withAllPhones(String phones) {
        this.allPhones = phones;
        return this;
    }
    public ContactData withAllEmails(String emails) {
        this.allEmails = emails;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }
    public String getMobilPhone() {
        return workPhone;
    }
    public String getEmail2() {
        return email;
    }
    public String getEmail3() {
        return email;
    }
    public String getAllPhones() {
        return allPhones;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

}
