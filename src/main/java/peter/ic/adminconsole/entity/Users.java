package peter.ic.adminconsole.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Users {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //    @Column(unique = true, columnDefinition = "VARCHAR")
    private String username;

    //    @Column(columnDefinition = "VARCHAR")
    private String passwd;

    //    @Column(columnDefinition = "VARCHAR")
    private String lastName;

    //    @Column(columnDefinition = "VARCHAR")
    private String firstName;

    //    @Column(columnDefinition = "VARCHAR")
    private String middleName;

    @ManyToOne(targetEntity = Department.class)
    private Department department;

    @ManyToOne(targetEntity = Position.class)
    private Position position;

    //    @Column(columnDefinition = "VARCHAR")
    private String contacts;

    //    @Column(columnDefinition = "VARCHAR")
    private String email;
    private boolean active;

    private Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }


    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
