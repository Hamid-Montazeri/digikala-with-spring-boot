package ir.mapsa.digikala.product.entity;

import io.swagger.annotations.ApiModelProperty;
import ir.mapsa.digikala.cart.entity.Cart;
import ir.mapsa.digikala.category.entity.CategoryDTO;
import ir.mapsa.digikala.user.entity.User;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

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

    @ApiModelProperty(required = true, hidden = true)
    private CategoryDTO category;

/*    @ApiModelProperty(required = true, hidden = true)
    private User user;

    @ApiModelProperty(required = true, hidden = true)
    private Cart cart;*/


}
