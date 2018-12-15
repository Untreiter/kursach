package Shop.domain;

import javax.persistence.*;

@Entity
public class ProductEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String shortDescription;
    private Integer price;

    public ProductEntity () {
    }

    public ProductEntity(String name, String shortDescription, Integer price) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

