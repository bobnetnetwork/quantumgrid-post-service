package network.bobnet.quantumgrid.post_service.dto;

import lombok.*;
import network.bobnet.quantumgrid.post_service.enums.PostStatus;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link network.bobnet.quantumgrid.post_service.entity.Post}
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -2217040622103103522L;

    private Long id;
    private String title;
    private String slug;
    private String content;
    private Long authorId;
    private PostStatus status;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
}
