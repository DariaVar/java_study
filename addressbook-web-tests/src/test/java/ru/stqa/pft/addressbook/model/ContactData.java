package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name = "firstname")
    private String firstname;
    @Expose
    @Column(name = "lastname")
    private String lastname;
    @Expose
    @Transient
    private String address;
    @Expose
    @Transient
    private String home;
    @Expose
    @Transient
    private String email;
    @Expose
    @Transient
    private String email2;
    @Transient
    private String email3;
    @Expose
    @Column(name = "home")
    @Type(type= "text")
    private String homePhone;
    @Expose
    @Column(name = "work")
    @Type(type= "text")
    private String workPhone;
    @Expose
    @Column(name = "mobile")
    @Type(type= "text")
    private  String mobilPhone;
    @Expose
    @Transient
    private String allPhones;
    @Expose
    @Transient
    private String allEmails;
    @Expose
    @Column(name = "photo")
    @Type(type= "text")
    private String photo;
    @Column (name = "deprecated", columnDefinition = "DATETIME")
    public String deprecated;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();

    public File getPhoto() {
        if (photo != null) {
            return new File(photo);
        } else {
            return null;
        }
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

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
    public ContactData withEmail2(String email2) {
        this.email = email2;
        return this;
    }
    public ContactData withEmail3(String email3) {
        this.email = email3;
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

    public Groups getGroups() {
        return new Groups(groups);
    }

    public String getDeprecated() {
        return deprecated;
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

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
