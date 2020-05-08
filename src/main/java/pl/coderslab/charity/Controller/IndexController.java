package pl.coderslab.charity.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repositorys.DonationRepository;
import pl.coderslab.charity.repositorys.InstitutionReopsitory;

import java.util.List;

@Controller
//@RequestMapping("institution")
public class IndexController {

    private final InstitutionReopsitory institutionReopsitory;

    private final DonationRepository donationRepository;

    public IndexController(InstitutionReopsitory institutionReopsitory, DonationRepository donationRepository) {
        this.institutionReopsitory = institutionReopsitory;
        this.donationRepository = donationRepository;
    }

    @GetMapping("/")
    public String show(Model model) {
        List<Donation> donationList = donationRepository.findAll();
        int quantity = 0;
        for (Donation donation : donationList) {
            quantity += donation.getQuantity();
        }
        model.addAttribute("allInstitutions", institutionReopsitory.findAll());
        model.addAttribute("quantity", quantity);
        model.addAttribute("donationQuantity", donationList.size());
        return "index";
    }
}
