package ir.mapsa.digikala.address.entity;

import ir.mapsa.digikala.base.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends GenericMapper<Address, AddressDTO> {

}
