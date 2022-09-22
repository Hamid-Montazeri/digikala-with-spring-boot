package ir.mapsa.digikala.controller;

import ir.mapsa.digikala.dto.UserDTO;
import ir.mapsa.digikala.mapper.UserMapper;
import ir.mapsa.digikala.model.User;
import ir.mapsa.digikala.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;
    private final UserMapper mapper;

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody UserDTO userDTO) {
        User savedUser = userService.save(mapper.toEntity(userDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody UserDTO userDTO) {
        User userEntity = mapper.toEntity(userDTO);
        User updatedUser = userService.save(userEntity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedUser);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody User user) {
        userService.delete(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        User user = userService.findById(id).orElseThrow();
        UserDTO userDTO = mapper.toDto(user);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAll() {
        List<User> allUsers = (List<User>) userService.findAll();
        List<UserDTO> userDTOS = mapper.toDTOs(allUsers);
        return ResponseEntity.ok(userDTOS);
    }


}
