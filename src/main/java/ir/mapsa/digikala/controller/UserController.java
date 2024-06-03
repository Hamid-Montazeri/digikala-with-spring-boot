package ir.mapsa.digikala.controller;

import ir.mapsa.digikala.base.BaseController;
import ir.mapsa.digikala.base.BaseMapper;
import ir.mapsa.digikala.base.BaseService;
import ir.mapsa.digikala.dto.UserDTO;
import ir.mapsa.digikala.mapper.UserMapper;
import ir.mapsa.digikala.model.User;
import ir.mapsa.digikala.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController extends BaseController<User, UserDTO, Long> {

    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    protected BaseService<User, UserDTO, Long> getBaseService() {
        return userService;
    }

    @Override
    protected BaseMapper<User, UserDTO> getBaseMapper() {
        return userMapper;
    }

}
