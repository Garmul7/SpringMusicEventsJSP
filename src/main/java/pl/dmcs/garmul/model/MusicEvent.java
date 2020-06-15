package pl.dmcs.garmul.model;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.List;

@Entity
public class MusicEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String eventtitle;
    @Column(length = 100000)
    private String eventdescription;
    private String eventcountry;
    private String eventcity;
    private String eventdate;
    private String eventprice;
    private Boolean eventIsActive;

    @ElementCollection
    private List<String> eventPeople;

// id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
// title
    public String getEventtitle() {
        return eventtitle;
    }
    public void setEventtitle(String eventtitle) {
        this.eventtitle = eventtitle;
    }
// description
    public String getEventdescription() {
        return eventdescription;
    }
    public void setEventdescription(String eventdescription) {
        this.eventdescription = eventdescription;
    }
// country
    public String getEventcountry() {
        return eventcountry;
    }
    public void setEventcountry(String eventcountry) {
        this.eventcountry = eventcountry;
    }
// city
    public String getEventcity() {
        return eventcity;
    }
    public void setEventcity(String eventcity) {
        this.eventcity = eventcity;
    }
// date
    public String getEventdate() {
        return eventdate;
    }
    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }
// price
    public String getEventprice() {
        return eventprice;
    }
    public void setEventprice(String eventprice) {
        this.eventprice = eventprice;
    }
// is Active
    public Boolean getEventIsActive() {return eventIsActive; }
    public void setEventIsActive(Boolean eventIsActive) { this.eventIsActive = eventIsActive; }
// people who have bought
    public List<String> getEventPeople() { return eventPeople;}
    public void setEventPeople(List<String> eventPeople) { this.eventPeople = eventPeople;}
}
