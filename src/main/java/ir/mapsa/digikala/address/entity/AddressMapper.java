package ir.mapsa.digikala.address.entity;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toEntity(AddressDTO addressDTO);

    AddressDTO toDTO(Address address);

    List<Address> toEntities(List<AddressDTO> addressDTOs);

    List<AddressDTO> toDTOs(List<Address> addresses);


}
