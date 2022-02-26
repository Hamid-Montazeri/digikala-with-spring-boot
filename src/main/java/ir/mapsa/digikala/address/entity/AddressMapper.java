package ir.mapsa.digikala.address.entity;

import ir.mapsa.digikala.base.GenericMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper extends GenericMapper<Address, AddressDTO> {

}
