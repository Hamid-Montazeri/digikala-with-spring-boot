package ir.mapsa.digikala.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

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
        return userRepo.save(user);
    }

    @Override
    public User update(User user) {
        Optional<User> optionalUser = userRepo.findById(user.getId());
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("'User' not found with requested 'id'");
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
            throw new NotFoundException("'User' not found with requested 'id'");
        }

        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }

}
