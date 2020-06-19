package pl.coderslab.charity.Controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repositorys.UserRepository;

@Controller
@RequestMapping("/super")
public class SuperController {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public SuperController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String createAdmin() {
        User user = new User();
        user.setEnable(0);
        user.setEmail("admin@admin");
        String password = "qwerty";
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return "user/adminPanel";
    }
}
