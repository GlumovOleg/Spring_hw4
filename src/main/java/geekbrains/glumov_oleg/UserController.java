package geekbrains.glumov_oleg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model){
        model.addAttribute("users", userService.getAllUser());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.getUserByID(id));
        return "userProfile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestParam Long id, @RequestParam String name, @RequestParam int age, @RequestParam String email) {
        return new ResponseEntity<>(userService.createUser(id, name, age, email), HttpStatus.CREATED);
    }

}

