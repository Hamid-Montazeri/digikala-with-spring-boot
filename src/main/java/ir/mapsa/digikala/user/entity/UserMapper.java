package ir.mapsa.digikala.user.entity;


import ir.mapsa.digikala.base.GenericMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User, UserDTO> {


}
