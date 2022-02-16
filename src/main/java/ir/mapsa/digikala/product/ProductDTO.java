package ir.mapsa.digikala.product;

import io.swagger.annotations.ApiModelProperty;
import ir.mapsa.digikala.category.CategoryDTO;
import lombok.Data;

@Data
public class ProductDTO {

    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)
    private String name;

    @ApiModelProperty(required = true, hidden = false)
    private Double regularPrice;

    @ApiModelProperty(required = true, hidden = false)
    private Double salePrice;

    @ApiModelProperty(required = true, hidden = false)
    private String image;

    @ApiModelProperty(required = true, hidden = false)
    private Type type;

    @ApiModelProperty(required = false, hidden = true)
    private CategoryDTO category;

}
