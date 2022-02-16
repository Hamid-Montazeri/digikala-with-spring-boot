package ir.mapsa.digikala.category;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CategoryDTO {

    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)
    private String name;


}
