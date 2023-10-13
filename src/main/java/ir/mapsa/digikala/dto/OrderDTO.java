package ir.mapsa.digikala.dto;

import io.swagger.annotations.ApiModelProperty;
import ir.mapsa.digikala.model.OrderStatus;
import ir.mapsa.digikala.model.User;
import lombok.Data;

import java.util.Date;

@Data
public class OrderDTO {

    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)
    private OrderStatus status;

    @ApiModelProperty(required = true, hidden = false)
    private Date date;

    @ApiModelProperty(required = true, hidden = false)
    private User user;


}
