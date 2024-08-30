package network.bobnet.quantumgrid.post_service.repository;

import network.bobnet.quantumgrid.post_service.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
