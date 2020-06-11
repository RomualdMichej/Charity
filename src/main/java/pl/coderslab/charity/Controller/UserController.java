package pl.coderslab.charity.Controller;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repositorys.UserRepository;
import pl.coderslab.charity.util.ViewHelper;

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
        return "user/allUsers";
    }


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String postRegister(User user, Model model){
        user.setEnable(1);
        String note = "Hasła nie są identyczne!";
        if(user.getPassword().equals(user.getPassword2())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return "user/login";
        }else {
            model.addAttribute("note", note);
            return "user/register";
        }
    }

    @GetMapping("/edit")
    public String initEditUser(@RequestParam long toEditId, Model model) {
        model.addAttribute("user", userRepository.findById(toEditId));
        return "user/register";
    }

    @PostMapping("/edit")
    public String editUser(User user, Model model) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//        model.addAttribute("userList", userRepository.findAll());
//        return "allUsers";
        String note = "Hasła nie są identyczne!";
        if(user.getPassword().equals(user.getPassword2())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            model.addAttribute("userList", userRepository.findAll());
            return "user/allUsers";
        }else {
            model.addAttribute("note", note);
            return "user/register";
        }
    }

    @GetMapping("remove")
    public String initRemoveCoUser(@RequestParam long toRemoveId, Model model) {
        model.addAttribute("user", userRepository.findById(toRemoveId));
        model.addAttribute("viewHelper", new ViewHelper());
        return "user/remove";
    }

    @PostMapping("remove")
    public String removeUser(@RequestParam long toRemoveId, @ModelAttribute ViewHelper viewHelper, Model model) {
        if(viewHelper.getOption().equals("confirmed")) {
//            startRepository.updateToNull(competitorRepository.findById(toRemoveId));
//            List<Result> resultList = resultRepository.findAllByCompetitor(competitorRepository.findById(toRemoveId));
//            for (Result  result : resultList) {
//                resultRepository.delete(result);
//            }
            userRepository.deleteById(toRemoveId);
        }
        model.addAttribute("userList", userRepository.findAll());
        return "user/allUsers";
    }

    @GetMapping("/registerAdmin")
    public String registerAdmin(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/registerAdmin")
    public String postRegisterAdmin(User user, Model model){
        user.setEnable(0);
        String note = "Hasła nie są identyczne!";
        if(user.getPassword().equals(user.getPassword2())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            model.addAttribute("userList", userRepository.findAll());
            return "user/allUsers";
        }else {
            model.addAttribute("note", note);
            return "user/register";
        }
    }
}
