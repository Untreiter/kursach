package Shop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductData {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    private Integer productId;
    private String description;
    private Integer availability;
    private Integer quantity;

    public ProductData()
    {
    }

    public ProductData(Integer productId, String description, Integer availability, Integer quantity)
    {
        this.productId = productId;
        this.description = description;
        this.availability = availability;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
