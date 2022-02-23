package ir.mapsa.digikala.user.service;

import ir.mapsa.digikala.exception.NotFoundException;
import ir.mapsa.digikala.user.entity.User;
import ir.mapsa.digikala.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User save(User user) {
//        if (userRepo.existsById(user.getId())) {
//            throw new ConflictException("The User with ID \"" + user.getId() + "\" already exists");
//        }
        return userRepo.save(user);
    }

    @Override
    public User update(User user) {
        Optional<User> optionalUser = userRepo.findById(user.getId());
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("The Product \"" + user.getName() + "\" with ID \"" + user.getId() + "\" not found");
        }

        User savedUser = optionalUser.get();

        savedUser.setName(user.getName());
        savedUser.setFamily(user.getFamily());
        savedUser.setPhone(user.getPhone());

        return userRepo.save(savedUser);
    }

    @Override
    public void delete(User user) {
        userRepo.delete(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("The requested User with ID \"" + id + "\" not found");
        }

        return optionalUser.get();
    }

    @Override
    @Cacheable(value = "user")
    public List<User> getAllUsers() {
        List<User> users = (List<User>) userRepo.findAll();
        if (users.isEmpty()) {
            throw new NotFoundException("No User found!");
        }
        return users;
    }

}
