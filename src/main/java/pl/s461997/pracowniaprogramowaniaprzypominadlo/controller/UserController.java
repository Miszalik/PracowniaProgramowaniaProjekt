package pl.s461997.pracowniaprogramowaniaprzypominadlo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.model.Users;
import pl.s461997.pracowniaprogramowaniaprzypominadlo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Users>> findAllDietarySupplements() {
        List<Users> allUsers = this.userService.findAll();
        return ResponseEntity.ok()
                .body(allUsers);
    }
}
