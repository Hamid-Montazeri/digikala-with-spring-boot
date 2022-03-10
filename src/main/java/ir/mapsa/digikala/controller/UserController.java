package ir.mapsa.digikala.controller;

import ir.mapsa.digikala.dto.UserDTO;
import ir.mapsa.digikala.mapper.UserMapper;
import ir.mapsa.digikala.model.User;
import ir.mapsa.digikala.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;
    private final UserMapper mapper;

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody UserDTO userDTO) {
        User savedUser = userService.save(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody UserDTO userDTO) {
        User savedUser = userService.findById(mapper.toEntity(userDTO).getId()).orElseThrow();

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
