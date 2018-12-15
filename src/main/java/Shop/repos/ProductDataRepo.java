package Shop.repos;

import Shop.domain.ProductData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductDataRepo extends CrudRepository<ProductData, Long> {
    List<ProductData> findByProductId(Integer id);
}

