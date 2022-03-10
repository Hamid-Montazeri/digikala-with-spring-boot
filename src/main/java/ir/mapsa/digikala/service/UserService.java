package ir.mapsa.digikala.service;

import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.base.GenericRepository;
import ir.mapsa.digikala.base.GenericServiceImpl;
import ir.mapsa.digikala.dto.UserDTO;
import ir.mapsa.digikala.mapper.UserMapper;
import ir.mapsa.digikala.model.User;
import ir.mapsa.digikala.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericServiceImpl<User, UserDTO, Long> implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    protected GenericRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    protected GenericMapper<User, UserDTO> getEntityMapper() {
        return userMapper;
    }
}
