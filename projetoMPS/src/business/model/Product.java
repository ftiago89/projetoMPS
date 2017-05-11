package business.model;

import java.util.Set;

//product modelling
public class Product {
    private String type;
    private Set<Enbroidery> enbroideries;

    public Product(String type, Set<Enbroidery> enbroideries) {
        this.type = type;
        this.enbroideries = enbroideries;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Enbroidery> getEnbroideries() {
        return enbroideries;
    }

    public void setEnbroideries(Set<Enbroidery> enbroideries) {
        this.enbroideries = enbroideries;
    }
}
