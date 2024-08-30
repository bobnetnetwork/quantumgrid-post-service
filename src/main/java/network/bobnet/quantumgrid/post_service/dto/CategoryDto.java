package network.bobnet.quantumgrid.post_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link network.bobnet.quantumgrid.post_service.entity.Category}
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -1866562871136698412L;

    private Long id;
    private String name;
    private String slug;
    private String description;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
    private Long parentId;
    @JsonIgnoreProperties({"posts"})
    private List<CategoryDto> children;
    @JsonIgnoreProperties({"mainCategory", "categories", "content", "mainCategoryId"})
    private List<PostDto> posts;
}
