package ir.mapsa.digikala.service;

import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.base.GenericRepository;
import ir.mapsa.digikala.base.GenericServiceImpl;
import ir.mapsa.digikala.dto.UserDTO;
import ir.mapsa.digikala.mapper.UserMapper;
import ir.mapsa.digikala.model.User;
import ir.mapsa.digikala.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends GenericServiceImpl<User, UserDTO, Long> implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    protected GenericRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    protected GenericMapper<User, UserDTO> getEntityMapper() {
        return userMapper;
    }
}
