package ir.mapsa.digikala.cart.entity;

import io.swagger.annotations.ApiModelProperty;
import ir.mapsa.digikala.user.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class CartDTO {

    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)
    private String code;

    @ApiModelProperty(required = true, hidden = false)
    private Date date;

    @ApiModelProperty(required = true, hidden = false)
    private User user;




}
