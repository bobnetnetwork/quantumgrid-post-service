package network.bobnet.quantumgrid.post_service.controller;

import com.github.fge.jsonpatch.JsonPatch;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import network.bobnet.quantumgrid.commons.dto.response.SimplePage;
import network.bobnet.quantumgrid.commons.util.DtoUtil;
import network.bobnet.quantumgrid.post_service.dto.PostDto;
import network.bobnet.quantumgrid.post_service.dto.request.CreatePostRequest;
import network.bobnet.quantumgrid.post_service.entity.Post;
import network.bobnet.quantumgrid.post_service.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<SimplePage<PostDto>> getAllPosts(
            @Parameter(hidden = true) @SortDefault(sort = "id") @PageableDefault(size = 20) final Pageable pageable
    ) {
        return ResponseEntity.ok(
                DtoUtil.convertSimplePage(
                        postService.findAll(pageable),
                        PostDto.class
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
        Post postEntity = postService.findById(id);
        return ResponseEntity.ok(modelMapper.map(postEntity, PostDto.class));
    }

    @PostMapping
    public ResponseEntity<Long > createPost(@RequestBody CreatePostRequest request) {
        Post postEntity = modelMapper.map(request, Post.class);
        Post savedPostEntity = postService.createPost(postEntity);
        return ResponseEntity.ok(savedPostEntity.getId());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PostDto> patchPost(@PathVariable Long id, @RequestBody JsonPatch patch) {
        return ResponseEntity.ok(modelMapper.map(postService.patch(id, patch), PostDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }
}
