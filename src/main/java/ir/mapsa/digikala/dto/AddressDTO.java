package ir.mapsa.digikala.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddressDTO {

    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)
    private String state;

    @ApiModelProperty(required = true, hidden = false)
    private String city;

    @ApiModelProperty(required = true, hidden = false)
    private String mainStreet;

    @ApiModelProperty(required = true, hidden = false)
    private String alley;

    @ApiModelProperty(required = true, hidden = false)
    private Integer numberPlate;

    @ApiModelProperty(required = true, hidden = false)
    private Integer apartmentNumber;

    @ApiModelProperty(required = true, hidden = false)
    private String postalCode;

    @ApiModelProperty(required = true, hidden = false)
    private Long latitude;

    @ApiModelProperty(required = true, hidden = false)
    private Long longitude;


}
