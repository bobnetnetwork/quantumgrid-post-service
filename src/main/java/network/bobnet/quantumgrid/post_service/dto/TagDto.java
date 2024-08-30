package network.bobnet.quantumgrid.post_service.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link network.bobnet.quantumgrid.post_service.entity.Tag}
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TagDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -2746603041509661958L;

    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
}
