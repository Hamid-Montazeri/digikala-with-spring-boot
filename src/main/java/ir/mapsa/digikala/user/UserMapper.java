package ir.mapsa.digikala.user;


import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDTO userDTO);

    UserDTO toDTO(User user);

    List<User> toEntities(List<UserDTO> userDTOs);

    List<UserDTO> toDTOs(List<User> users);


}
