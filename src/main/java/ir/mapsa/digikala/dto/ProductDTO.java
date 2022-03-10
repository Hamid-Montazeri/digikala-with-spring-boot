package ir.mapsa.digikala.dto;

import io.swagger.annotations.ApiModelProperty;
import ir.mapsa.digikala.model.ProductType;
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
    private ProductType productType;

    @ApiModelProperty(required = true, hidden = true)
    private CategoryDTO category;

/*    @ApiModelProperty(required = true, hidden = true)
    private User user;

    @ApiModelProperty(required = true, hidden = true)
    private Cart cart;*/


}
