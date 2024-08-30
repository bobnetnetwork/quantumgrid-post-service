package network.bobnet.quantumgrid.post_service.service;

import com.github.fge.jsonpatch.JsonPatch;
import network.bobnet.quantumgrid.commons.dto.response.SimplePage;
import network.bobnet.quantumgrid.commons.service.AbstractService;
import network.bobnet.quantumgrid.post_service.entity.Post;
import network.bobnet.quantumgrid.post_service.repository.PostRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService extends AbstractService<Post> {

    public PostService(PostRepository postRepository) {
        super(Post.class, postRepository);
    }

    public SimplePage<Post> findAll(final Pageable pageable) {
        return getPageableEntityList(pageable);
    }

    public Post findById(final Long id) {
        return findEntityById(id);
    }

    public Post createPost(Post post) {
        return createEntityToRepository(post);
    }

    public void deletePost(Long id) {
        deleteEntityById(id);
    }

    public Post patch(Long id, JsonPatch patch) {
        return patchEntity(id, patch);
    }
}
