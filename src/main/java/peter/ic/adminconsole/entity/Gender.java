package peter.ic.adminconsole.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Gender {

    @Id
    private int id;

    //    @Column(columnDefinition = "VARCHAR")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
