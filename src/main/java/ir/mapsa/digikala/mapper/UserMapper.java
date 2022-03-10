package ir.mapsa.digikala.mapper;


import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.dto.UserDTO;
import ir.mapsa.digikala.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User, UserDTO> {


}
