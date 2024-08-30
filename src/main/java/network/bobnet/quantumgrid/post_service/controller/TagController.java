package network.bobnet.quantumgrid.post_service.controller;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import network.bobnet.quantumgrid.commons.dto.response.SimplePage;
import network.bobnet.quantumgrid.commons.util.DtoUtil;
import network.bobnet.quantumgrid.post_service.dto.TagDto;
import network.bobnet.quantumgrid.post_service.dto.request.CreateTagRequest;
import network.bobnet.quantumgrid.post_service.entity.Tag;
import network.bobnet.quantumgrid.post_service.service.TagService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tags")
public class TagController {

    private final TagService tagService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<SimplePage<TagDto>> getAllTags(
            @Parameter(hidden = true) @SortDefault(sort = "id") @PageableDefault(size = 20) final Pageable pageable
    ) {
        return ResponseEntity.ok(
                DtoUtil.convertSimplePage(
                        tagService.findAll(pageable),
                        TagDto.class
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDto> getTagById(@PathVariable Long id) {
        return ResponseEntity.ok(modelMapper.map(tagService.findById(id), TagDto.class));
    }

    @PostMapping
    public ResponseEntity<Long> createTag(@RequestBody CreateTagRequest request) {
        Tag tagEntity = modelMapper.map(request, Tag.class);
        Tag savedTagEntity = tagService.createTag(tagEntity);
        return ResponseEntity.ok(savedTagEntity.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
        return ResponseEntity.ok().build();
    }
}
