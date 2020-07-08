package xws.microservice.searchservice.model;

import java.util.Date;

public class SearchInfo {
 /**
  * TODO: Klasa za pretragu
  * */

    private String country;
    private String city;
    private Date startDate;
    private Date endDate;



    public SearchInfo(){

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
