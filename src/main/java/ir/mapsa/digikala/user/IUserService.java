package ir.mapsa.digikala.user;

import java.util.List;

public interface IUserService {

    User save(User user);

    User update(User user);

    void delete(User user);

    User getUserById(Long id);

    List<User> getAllUsers();


}
