package pl.s461997.pracowniaprogramowaniaprzypominadlo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Users;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Users>> findAllUsers() {
        List<Users> allUsers = this.userService.findAll();
        return ResponseEntity.ok()
                .body(allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findUser(@PathVariable("id") Long id) {
        Optional<Users> user = this.userService.findById(id);
        if(user.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok()
                .body(user.get());
    }

    @PostMapping("/")
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Users> deleteUser(@PathVariable("id") Long id) {
        this.userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
