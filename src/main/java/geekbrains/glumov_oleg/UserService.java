package geekbrains.glumov_oleg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final AutoInfo autoInfoService;

    @Autowired
    public UserService(AutoInfo autoInfoService) {
        this.autoInfoService = autoInfoService;
    }

    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        autoInfoService.notifyUser(user);

        return user;
    }

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserByID(Long id) {
        return userRepository.findById(id);
    }


}
