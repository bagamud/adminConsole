package peter.ic.adminconsole.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    private int id;
    private String name;
    private boolean reedWrite;

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

    public boolean isReedWrite() {
        return reedWrite;
    }

    public void setReedWrite(boolean reedWrite) {
        this.reedWrite = reedWrite;
    }
}
