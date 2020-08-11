package pl.coderslab.charity.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private int enable;
    private String street;
    private String city;
    private String zipCode;
    @Transient
    private String password2;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getEnable() {
        return enable;
    }

    public String getPassword2() {
        return password2;
    }

    public String getStreet() {return  street; }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
