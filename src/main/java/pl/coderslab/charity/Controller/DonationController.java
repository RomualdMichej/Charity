package pl.coderslab.charity.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repositorys.CategoryRepository;
import pl.coderslab.charity.repositorys.DonationRepository;
import pl.coderslab.charity.repositorys.InstitutionReopsitory;
import pl.coderslab.charity.util.ViewHelper;

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

    @GetMapping("/")
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


    @PostMapping("/add") //JEDNOCZEŚNIE DODAJE I EDYTUJE
    public String addDonation(Model model,
                              @RequestParam String categoriesId,
                              @RequestParam Integer bags,
                              @RequestParam Long organizationId,
                              @RequestParam String address,
                              @RequestParam String city,
                              @RequestParam String postcode,
                              @RequestParam String phone,
                              @RequestParam String data,
                              @RequestParam LocalTime time,
                              @RequestParam long toEditId,
                              @RequestParam String more_info) {

        List<Category> categoryList = new ArrayList<>();
        if (categoriesId.equals("")){
            categoryList = donationRepository.findById(toEditId).getCategoryList();
        }else {
            String[] partsOfCategories = categoriesId.split(",");
            for (String part : partsOfCategories) {
                categoryList.add(categoryRepository.findCategoryById(Long.parseLong(part)));
            }
        }

        LocalDate date;
        if (data.equals("")){
            date = donationRepository.findById(toEditId).getPickUpDate();
        }else {
            String[] partsOfData = data.split("-");
            date = LocalDate.of(Integer.parseInt(partsOfData[0]),
                    Integer.parseInt(partsOfData[1]), Integer.parseInt(partsOfData[2]));
        }
        Donation donation = new Donation();

        donation.setCategoryList(categoryList);

        if(city.equals("")) {
            donation.setCity(donationRepository.findById(toEditId).getCity());
        }else {
            donation.setCity(city);
        }
            donation.setInstitution(institutionReopsitory.findInstitutionById(organizationId));
        if(data.equals("")){
            donation.setPickUpDate(donationRepository.findById(toEditId).getPickUpDate());
        }else {
            donation.setPickUpDate(date);
        }
        if(time == null){
            donation.setPickUpTime(donationRepository.findById(toEditId).getPickUpTime());
        }else {
            donation.setPickUpTime(time);
        }
        if(bags == null){
            donation.setQuantity(donationRepository.findById(toEditId).getQuantity());
        }else {
            donation.setQuantity(bags);
        }
        if(address.equals("")){
            donation.setStreet(donationRepository.findById(toEditId).getStreet());
        }else {
            donation.setStreet(address);
        }
        if(postcode.equals("")){
            donation.setZipCode(donationRepository.findById(toEditId).getZipCode());
        }else {
            donation.setZipCode(postcode);
        }
        if(more_info.equals("")){
            donation.setPickUpComment(donationRepository.findById(toEditId).getPickUpComment());
        }else {
            donation.setPickUpComment(more_info);
        }
        if(toEditId != 0) {
            donation.setId(toEditId);
        }

        donationRepository.save(donation);

        if(toEditId != 0) {
            model.addAttribute("donationList", donationRepository.findAll());
            return "donation/allDonations";
        }else {
            return "formDirec/form-confirmation";

        }
    }

    @GetMapping("/edit")
    public String editGet(Model model, @RequestParam long toEditId) {
        model.addAttribute("categoryList", categoryRepository.findAll());
        model.addAttribute("institutionList", institutionReopsitory.findAll());
        model.addAttribute("donation", donationRepository.findById(toEditId));
        return "donation/edit";
    }

    @GetMapping("/remove")
    public String removeGet(@RequestParam long toRemoveId, Model model) {
        model.addAttribute("donation", donationRepository.findById(toRemoveId));
        model.addAttribute("viewHelper", new ViewHelper());
        return "donation/remove";
    }

    @PostMapping("/remove")
    public String removePost(@RequestParam long toRemoveId, @ModelAttribute ViewHelper viewHelper) {
        if(viewHelper.getOption().equals("confirmed")) {
            donationRepository.deleteById(toRemoveId);
        }
        return "redirect:";
    }
}
