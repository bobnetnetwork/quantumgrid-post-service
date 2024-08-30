package network.bobnet.quantumgrid.post_service.repository;

import network.bobnet.quantumgrid.post_service.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
