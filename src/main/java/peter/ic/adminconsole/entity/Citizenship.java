package peter.ic.adminconsole.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Citizenship {

    @Id
    private int id;

    //    @Column(columnDefinition = "VARCHAR")
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
