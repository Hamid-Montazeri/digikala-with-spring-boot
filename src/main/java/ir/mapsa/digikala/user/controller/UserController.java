package ir.mapsa.digikala.user.controller;

import ir.mapsa.digikala.exception.NotFoundException;
import ir.mapsa.digikala.user.entity.User;
import ir.mapsa.digikala.user.entity.UserDTO;
import ir.mapsa.digikala.user.entity.UserMapper;
import ir.mapsa.digikala.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        User savedUser = userService.save(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody UserDTO userDTO) {
        Optional<User> optionalUser = userService.findById(mapper.toEntity(userDTO).getId());

        if (optionalUser.isEmpty()) {
            throw new NotFoundException("The requested \"User\" not found.");
        }

        User savedUser = optionalUser.get();

        savedUser.setName(userDTO.getName());
        savedUser.setFamily(userDTO.getFamily());
        savedUser.setPhone(userDTO.getPhone());
        savedUser.setAddress(userDTO.getAddress());

        User updatedUser = userService.save(mapper.toDto(savedUser));

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedUser);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody User user) {
        userService.delete(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        Optional<User> optionalUser = userService.findById(id);

        if (optionalUser.isEmpty()) {
            throw new NotFoundException("The requested \"User\" not found.");
        }

        UserDTO userDTO = mapper.toDto(optionalUser.get());

        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAll() {
        List<User> allUsers = (List<User>) userService.findAll();
        List<UserDTO> userDTOS = mapper.toDTOs(allUsers);
        return ResponseEntity.ok(userDTOS);
    }


}
