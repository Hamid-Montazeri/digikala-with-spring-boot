package ir.mapsa.digikala.service;

import ir.mapsa.digikala.base.BaseMapper;
import ir.mapsa.digikala.base.BaseRepository;
import ir.mapsa.digikala.base.BaseServiceImpl;
import ir.mapsa.digikala.dto.UserDTO;
import ir.mapsa.digikala.mapper.UserMapper;
import ir.mapsa.digikala.model.User;
import ir.mapsa.digikala.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends BaseServiceImpl<User, UserDTO, Long> implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    protected BaseRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    protected BaseMapper<User, UserDTO> getEntityMapper() {
        return userMapper;
    }
}
