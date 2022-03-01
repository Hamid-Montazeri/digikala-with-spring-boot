package ir.mapsa.digikala.user.entity;


import ir.mapsa.digikala.base.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User, UserDTO> {


}
