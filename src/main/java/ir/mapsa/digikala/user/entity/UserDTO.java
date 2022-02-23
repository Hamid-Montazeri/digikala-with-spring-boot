package ir.mapsa.digikala.user.entity;

import io.swagger.annotations.ApiModelProperty;
import ir.mapsa.digikala.address.entity.Address;
import lombok.Data;

@Data
public class UserDTO {

    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)
    private String name;

    @ApiModelProperty(required = true, hidden = false)
    private String family;

    @ApiModelProperty(required = true, hidden = false)
    private String phone;

    @ApiModelProperty(required = true, hidden = false)
    private Address address;



}
