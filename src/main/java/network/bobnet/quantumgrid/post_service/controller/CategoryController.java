package network.bobnet.quantumgrid.post_service.controller;

import com.github.fge.jsonpatch.JsonPatch;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import network.bobnet.quantumgrid.commons.dto.response.SimplePage;
import network.bobnet.quantumgrid.commons.util.DtoUtil;
import network.bobnet.quantumgrid.post_service.dto.CategoryDto;
import network.bobnet.quantumgrid.post_service.dto.request.CreateCategoryRequest;
import network.bobnet.quantumgrid.post_service.entity.Category;
import network.bobnet.quantumgrid.post_service.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<SimplePage<CategoryDto>> getAllCategories(
            @Parameter(hidden = true) @SortDefault(sort = "id") @PageableDefault(size = 20) final Pageable pageable
    ) {
        return ResponseEntity.ok(
                DtoUtil.convertSimplePage(
                        categoryService.findAll(pageable),
                        CategoryDto.class
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(modelMapper.map(categoryService.findById(id), CategoryDto.class));
    }

    @PostMapping
    public ResponseEntity<Long> createCategory(@RequestBody CreateCategoryRequest request) {
        Category categoryEntity = modelMapper.map(request, Category.class);
        Category savedCategoryEntity = categoryService.createCategory(categoryEntity);
        return ResponseEntity.ok(savedCategoryEntity.getId());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryDto> patchCategory(@PathVariable Long id, @RequestBody JsonPatch patch) {
        return ResponseEntity.ok(modelMapper.map(categoryService.patch(id, patch), CategoryDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
