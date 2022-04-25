package boxinator.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "weight")
    private double weight;
    @Column(name = "colour")
    private String colour;
    @Column(name = "country")
    private String country;

    public Order(String name, double weight, String colour, String country) {
        this.name = name;
        this.weight = weight;
        this.colour = colour;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getColour() {
        return colour;
    }

    public String getCountry() {
        return country;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
