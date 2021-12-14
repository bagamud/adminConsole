package peter.ic.adminconsole.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CountryRegion {

    @Id
    private int regCode;
    private String title;
    private int federalCode;

    public int getRegCode() {
        return regCode;
    }

    public void setRegCode(int regCode) {
        this.regCode = regCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFederalCode() {
        return federalCode;
    }

    public void setFederalCode(int federalCode) {
        this.federalCode = federalCode;
    }
}
