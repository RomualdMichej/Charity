package pl.coderslab.charity.Controller;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repositorys.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/showAll")
    public String showAllUsers(Model model) {
        model.addAttribute("userList", userRepository.findAll());
        return "allUsers";
    }


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(User user, Model model){
        user.setEnable(1);
        String note = "Hasła nie są identyczne!";
        if(user.getPassword().equals(user.getPassword2())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return "login";
        }else {
            model.addAttribute("note", note);
            return "register";
        }
    }

    @GetMapping("/edit")
    public String initEditUser(@RequestParam long toEditId, Model model) {
        model.addAttribute("user", userRepository.findById(toEditId));
        return "register";
    }

    @PostMapping("/edit")
    public String editUser(User user) {
        userRepository.save(user);
        return "redirect:";
    }
}
