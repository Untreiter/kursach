package Shop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductMedia {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    private Integer productId;
    private String type;
    private String altCode;
    private String imgPath;

    public ProductMedia() {

    }

    public ProductMedia(Integer productId, String type, String altCode, String imgPath) {
        this.productId = productId;
        this.type = type;
        this.altCode = altCode;
        this.imgPath = imgPath;
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

    public String getAltCode() {
        return altCode;
    }

    public void setAltCode(String altCode) {
        this.altCode = altCode;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

