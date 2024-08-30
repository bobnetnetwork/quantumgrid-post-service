package network.bobnet.quantumgrid.post_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import network.bobnet.quantumgrid.post_service.enums.PostStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreatePostRequest {

    private String title;
    private String slug;
    private String content;
    private Long authorId;
    private PostStatus status;
}
