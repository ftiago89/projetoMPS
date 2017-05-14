package business.model;

//brazilian address modelling
import java.io.Serializable;

public class Address implements Serializable{
    private String street, complement, ngbhood, city, state, cep;

    public Address(String street, String complement, String ngbhood, String city, String state, String cep) {
        this.street = street;
        this.complement = complement;
        this.ngbhood = ngbhood;
        this.city = city;
        this.state = state;
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNgbhood() {
        return ngbhood;
    }

    public void setNgbhood(String ngbhood) {
        this.ngbhood = ngbhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
