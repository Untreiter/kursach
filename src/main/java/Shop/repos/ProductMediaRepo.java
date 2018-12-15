package Shop.repos;

import Shop.domain.ProductMedia;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductMediaRepo extends CrudRepository<ProductMedia, Long> {
    List<ProductMedia> findByProductId(Integer id);
}
