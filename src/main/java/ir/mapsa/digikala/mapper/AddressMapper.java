package ir.mapsa.digikala.mapper;

import ir.mapsa.digikala.base.BaseMapper;
import ir.mapsa.digikala.dto.AddressDTO;
import ir.mapsa.digikala.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public interface AddressMapper extends BaseMapper<Address, AddressDTO> {

}
