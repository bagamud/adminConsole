package peter.ic.adminconsole.entity;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int idUser;
    private String snils;

    @Column(unique = true)
    private String username;
    private String passwd;
    private boolean temporaryPasswd;

    private String surname;
    private String firstName;
    private String lastName;

    @ManyToOne(targetEntity = Department.class)
    private Department department;

    @ManyToOne(targetEntity = Post.class)
    private Post post;

    @ManyToOne(targetEntity = Services.class)
    private Services services;


    @ManyToOne(targetEntity = Rank.class)
    private Rank rank;

    private String contacts;

    private String email;
    private boolean active;

    @ManyToOne(targetEntity = Role.class)
    private Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
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

    public boolean isTemporaryPasswd() {
        return temporaryPasswd;
    }

    public void setTemporaryPasswd(boolean temporaryPasswd) {
        this.temporaryPasswd = temporaryPasswd;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
