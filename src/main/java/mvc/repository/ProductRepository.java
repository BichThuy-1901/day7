package mvc.repository;

import mvc.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductRepository, Integer> {

}
