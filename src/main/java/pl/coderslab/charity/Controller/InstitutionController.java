package pl.coderslab.charity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repositorys.DonationRepository;
import pl.coderslab.charity.repositorys.InstitutionReopsitory;
import pl.coderslab.charity.util.ViewHelper;

import java.util.List;

@Controller
@RequestMapping("/institution")
public class InstitutionController {

    private final InstitutionReopsitory institutionReopsitory;

    private final DonationRepository donationRepository;

    public InstitutionController(InstitutionReopsitory institutionReopsitory, DonationRepository donationRepository) {
        this.institutionReopsitory = institutionReopsitory;
        this.donationRepository = donationRepository;
    }

    @GetMapping("/")
    public String showAllInstitutions(Model model) {
        model.addAttribute("institutionList", institutionReopsitory.findAll());
        return "institution/allInstitutions";
    }

    @GetMapping("/add") //JEDNOCZEŚNIE DODAJE I EDYTUJE
    public String addInstitutionGet(Model model, @RequestParam long toEditId) {
        if(toEditId == 0) {
            model.addAttribute("institution", new Institution());
        }else {
            model.addAttribute("institution", institutionReopsitory.findById(toEditId));
        }

        return "institution/addEdit";
    }

    @PostMapping("/add") //JEDNOCZEŚNIE DODAJE I EDYTUJE
    public String addInstitutionGetPost(Institution institution) {
        institutionReopsitory.save(institution);;
        return "redirect:";
    }

    @GetMapping("remove")
    public String removeInstitutionGet(@RequestParam long toRemoveId, Model model) {
        model.addAttribute("category", institutionReopsitory.findInstitutionById(toRemoveId));
        model.addAttribute("viewHelper", new ViewHelper());
        return "category/remove";
    }

    @PostMapping("remove")
    public String removeInstitutionPost(@RequestParam long toRemoveId, @ModelAttribute ViewHelper viewHelper) {
        if(viewHelper.getOption().equals("confirmed")) {
            List<Donation> donationToRemoveList = donationRepository.findAllByInstitution(institutionReopsitory.findInstitutionById(toRemoveId));
            for (Donation donation : donationToRemoveList) {
                donationRepository.delete(donation);
            }
            institutionReopsitory.deleteById(toRemoveId);
        }
        return "redirect:";
    }
}
