package ir.mapsa.digikala.user.service;

import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.base.GenericRepository;
import ir.mapsa.digikala.base.GenericServiceImpl;
import ir.mapsa.digikala.user.entity.User;
import ir.mapsa.digikala.user.entity.UserDTO;
import ir.mapsa.digikala.user.entity.UserMapper;
import ir.mapsa.digikala.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericServiceImpl<User, UserDTO, Long> implements IUserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }


    @Override
    protected GenericRepository<User, Long> getRepository() {
        return userRepo;
    }

    @Override
    protected GenericMapper<User, UserDTO> getEntityMapper() {
        return userMapper;
    }
}
