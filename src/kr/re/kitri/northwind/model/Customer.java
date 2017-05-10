package kr.re.kitri.northwind.model;

/**
 * Created by danawacomputer on 2017-05-10.
 */
public class Customer {

    // 필드
    private String customerid;
    private String companyname;
    private String contactname;
    private String address;
    private String city;
    private String phone;

    // 생성자
    public Customer() {
    }

    public Customer(String customerid, String companyname, String contactname, String address, String city, String phone) {
        this.customerid = customerid;
        this.companyname = companyname;
        this.contactname = contactname;
        this.address = address;
        this.city = city;
        this.phone = phone;
    }

    // 메소드
    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerid='" + customerid + '\'' +
                ", companyname='" + companyname + '\'' +
                ", contactname='" + contactname + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
