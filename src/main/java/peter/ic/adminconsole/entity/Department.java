package peter.ic.adminconsole.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Department {

    @Id
    private int code;

    @ManyToOne(targetEntity = CountryRegion.class)
    private CountryRegion countryRegion;

    private String title;
    private String shortTitle;
    private int parentCode;
    private boolean participant;

    @Column(nullable = true)
    private boolean active;

    public CountryRegion getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(CountryRegion countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getParentCode() {
        return parentCode;
    }

    public void setParentCode(int parentCode) {
        this.parentCode = parentCode;
    }

    public boolean isParticipant() {
        return participant;
    }

    public void setParticipant(boolean participant) {
        this.participant = participant;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
