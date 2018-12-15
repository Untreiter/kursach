package Shop.repos;

import Shop.domain.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductEntityRepo extends CrudRepository<ProductEntity, Long> {
    List<ProductEntity> findAll();

    Page<ProductEntity> findAll(Pageable pageable);

    List<ProductEntity> findById(Integer id);

    Page<ProductEntity> findById(Integer id, Pageable pageable);

    Page<ProductEntity> findByNameContainingAndPriceBetween(String name, Integer from, Integer to, Pageable pageable);

    Page<ProductEntity> findByNameContainingAndPriceBetweenOrderByNameAsc(String name, Integer from, Integer to, Pageable pageable);

    Page<ProductEntity> findByNameContainingAndPriceBetweenOrderByPriceAsc(String name, Integer from, Integer to, Pageable pageable);

}
