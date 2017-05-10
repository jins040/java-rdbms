package kr.re.kitri.northwind.model;

import java.time.LocalDate;

/**
 * Created by danawacomputer on 2017-05-10.
 */
public class JoinCustomerOrder {

    // 필드
    private String contactName;
    private String city;
    private String country;
    private String orderdate;
    private String shipcountry;

    // 생성자
    public JoinCustomerOrder() {
    }

    public JoinCustomerOrder(String contactName, String city, String country, String orderdate, String shipcountry) {
        this.contactName = contactName;
        this.city = city;
        this.country = country;
        this.orderdate = orderdate;
        this.shipcountry = shipcountry;
    }

    // 매소드
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getOrderdate() {
        return orderdate;
    }
    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getShipcountry() {
        return shipcountry;
    }
    public void setShipcountry(String shipcountry) {
        this.shipcountry = shipcountry;
    }

    @Override
    public String toString() {
        return "JoinCustomerOrder{" +
                "contactName='" + contactName + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", orderdate='" + orderdate + '\'' +
                ", shipcountry='" + shipcountry + '\'' +
                '}';
    }
}
