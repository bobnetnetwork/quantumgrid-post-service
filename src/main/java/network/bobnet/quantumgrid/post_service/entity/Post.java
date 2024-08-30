package network.bobnet.quantumgrid.post_service.entity;

import jakarta.persistence.*;
import lombok.*;
import network.bobnet.quantumgrid.post_service.enums.PostStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts", schema = "postservice")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ToString.Include
    private Long id;

    @Column(name = "title", nullable = false)
    @ToString.Include
    private String title;

    @Column(name = "slug", nullable = false)
    @ToString.Include
    private String slug;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "author_id", nullable = false)
    private Long authorId;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    @ToString.Include
    private PostStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private Long updatedBy;
}
