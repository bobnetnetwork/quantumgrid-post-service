package network.bobnet.quantumgrid.post_service.service;

import network.bobnet.quantumgrid.commons.dto.response.SimplePage;
import network.bobnet.quantumgrid.commons.service.AbstractService;
import network.bobnet.quantumgrid.post_service.entity.Tag;
import network.bobnet.quantumgrid.post_service.repository.TagRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TagService extends AbstractService<Tag> {

    public TagService(TagRepository tagRepository) {
        super(Tag.class, tagRepository);
    }

    public SimplePage<Tag> findAll(final Pageable pageable) {
        return getPageableEntityList(pageable);
    }

    public Tag findById(final Long id) {
        return findEntityById(id);
    }

    public Tag createTag(Tag tag) {
        return createEntityToRepository(tag);
    }

    public void deleteTag(Long id) {
        deleteEntityById(id);
    }
}
