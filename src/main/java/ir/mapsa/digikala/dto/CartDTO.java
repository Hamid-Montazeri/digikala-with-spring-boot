package ir.mapsa.digikala.dto;

import io.swagger.annotations.ApiModelProperty;
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
    private UserDTO user;


}
