package pl.coderslab.charity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hi")
public class HiController {

    @GetMapping("/")
    @ResponseBody
    public String hi(){
        return "HI!";
    }
}
