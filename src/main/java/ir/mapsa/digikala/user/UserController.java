package ir.mapsa.digikala.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<User> save(@RequestBody UserDTO userDTO) {
        User user = mapper.toEntity(userDTO);
        User savedUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody UserDTO userDTO) {
        User user = mapper.toEntity(userDTO);
        User updatedUser = userService.update(user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedUser);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody User user) {
        userService.delete(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        UserDTO userDTO = mapper.toDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAll() {
        List<User> allUsers = userService.getAllUsers();
        List<UserDTO> userDTOS = mapper.toDTOs(allUsers);
        return ResponseEntity.ok(userDTOS);
    }



}
