package network.bobnet.quantumgrid.post_service.service;

import com.github.fge.jsonpatch.JsonPatch;
import network.bobnet.quantumgrid.commons.dto.response.SimplePage;
import network.bobnet.quantumgrid.commons.service.AbstractService;
import network.bobnet.quantumgrid.post_service.entity.Category;
import network.bobnet.quantumgrid.post_service.repository.CategoryRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends AbstractService<Category> {

    public CategoryService(CategoryRepository categoryRepository) {
        super(Category.class, categoryRepository);
    }

    public SimplePage<Category> findAll(final Pageable pageable) {
        return getPageableEntityList(pageable);
    }

    public Category findById(final Long id) {
        return findEntityById(id);
    }

    public Category createCategory(Category category) {
        return createEntityToRepository(category);
    }

    public void deleteCategory(Long id) {
        deleteEntityById(id);
    }

    public Category patch(Long id, JsonPatch patch) {
        return patchEntity(id, patch);
    }
}
