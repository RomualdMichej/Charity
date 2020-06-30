package pl.coderslab.charity.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repositorys.CategoryRepository;
import pl.coderslab.charity.repositorys.DonationRepository;
import pl.coderslab.charity.repositorys.InstitutionReopsitory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private final DonationRepository donationRepository;

    private final CategoryRepository categoryRepository;

    private final InstitutionReopsitory institutionReopsitory;

    public DonationController(DonationRepository donationRepository, CategoryRepository categoryRepository, InstitutionReopsitory institutionReopsitory) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionReopsitory = institutionReopsitory;
    }

    @GetMapping("/show")
    public String showAllDonations(Model model) {
        model.addAttribute("donationList", donationRepository.findAll());
        return "donation/allDonations";
    }

    @GetMapping("/add")
    public String show(Model model) {
        model.addAttribute("categoryList", categoryRepository.findAll());
        model.addAttribute("institutionList", institutionReopsitory.findAll());
        model.addAttribute("donation", new Donation());
        return "formDirec/form";
    }


    @PostMapping("/add")
    public String addDonation(@RequestParam String categoriesId,
                              @RequestParam Integer bags,
                              @RequestParam Long organizationId,
                              @RequestParam String address,
                              @RequestParam String city,
                              @RequestParam String postcode,
                              @RequestParam String phone,
                              @RequestParam String data,
                              @RequestParam LocalTime time,
                              @RequestParam String more_info) {

        List<Category> categoryList = new ArrayList<>();
        String[] partsOfCategories = categoriesId.split(",");
        for (String part : partsOfCategories) {
            categoryList.add(categoryRepository.findCategoryById(Long.parseLong(part)));
        }
        String[] partsOfData = data.split("-");
        LocalDate date = LocalDate.of(Integer.parseInt(partsOfData[0]),
                Integer.parseInt(partsOfData[1]), Integer.parseInt(partsOfData[2]));

        Donation donation = new Donation();
        donation.setCategoryList(categoryList);
        donation.setCity(city);
        donation.setInstitution(institutionReopsitory.findInstitutionById(organizationId));
        donation.setPickUpDate(date);
        donation.setPickUpTime(time);
        donation.setQuantity(bags);
        donation.setStreet(address);
        donation.setZipCode(postcode);
        donation.setPickUpComment(more_info);

        donationRepository.save(donation);

        return "formDirec/form-confirmation";
    }

}
