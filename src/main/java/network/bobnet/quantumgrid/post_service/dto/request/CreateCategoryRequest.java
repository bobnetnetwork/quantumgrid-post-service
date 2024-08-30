package network.bobnet.quantumgrid.post_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import network.bobnet.quantumgrid.post_service.dto.CategoryDto;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateCategoryRequest {

    private String name;
    private String slug;
    private String description;
    private CategoryDto parent;
}
