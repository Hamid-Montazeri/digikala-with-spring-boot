package ir.mapsa.digikala.mapper;


import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.dto.UserDTO;
import ir.mapsa.digikala.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {AddressMapper.class, CartMapper.class})
public interface UserMapper extends GenericMapper<User, UserDTO> {


}
