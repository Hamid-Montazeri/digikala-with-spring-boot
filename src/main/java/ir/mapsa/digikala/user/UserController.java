package ir.mapsa.digikala.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;
    private final UserMapper mapper;

    @Autowired
    public UserController(IUserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping("/save")
    public User save(@RequestBody UserDTO userDTO) {
        User user = mapper.toEntity(userDTO);
        return userService.save(user);
    }

    @PutMapping("/update")
    public User update(@RequestBody UserDTO userDTO) {
        User user = mapper.toEntity(userDTO);
        return userService.update(user);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody User user) {
        userService.delete(user);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return mapper.toDTO(user);
    }

    @GetMapping("/getAll")
    public List<UserDTO> getAll() {
        List<User> allUsers = userService.getAllUsers();
        return mapper.toDTOs(allUsers);
    }



}
