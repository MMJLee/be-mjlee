package dev.mjlee.bemjlee.User;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "users")
@CrossOrigin(origins = "http://localhost:8080")
// @CrossOrigin(origins = "https://mjlee.dev", allowedHeaders = "*",
// allowCredentials = "true")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/top5/")
    public List<User> getTop5Users() {
        return userService.getTop5Users();
    }

    @GetMapping(path = "/{id}/")
    public Optional<User> getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PostMapping(path = "/")
    public void registeUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping(path = "/statement/{id}/")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    // cleaner method, but commas aren't url standard
    // @PutMapping(path = "/game/used/{ids}")
    // public void setStatementsUsed(@PathVariable("ids") Long[] ids) {
    // statementService.setStatementsUsed(ids);
    // }
}