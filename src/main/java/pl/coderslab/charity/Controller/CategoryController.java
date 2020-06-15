package pl.coderslab.charity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.repositorys.CategoryRepository;
import pl.coderslab.charity.util.ViewHelper;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public String showAllCategories(Model model) {
        model.addAttribute("categoryList", categoryRepository.findAll());
        return "category/allCategorys";
    }

    @GetMapping("/add") //JEDNOCZEŚNIE DODAJE I EDYTUJE
    public String addCategoryGet(Model model, @RequestParam long toEditId) {
        if(toEditId == 0) {
            model.addAttribute("category", new Category());
        }else {
            model.addAttribute("category", categoryRepository.findById(toEditId));
        }

        return "category/addEdit";
    }

    @PostMapping("/add") //JEDNOCZEŚNIE DODAJE I EDYTUJE
    public String addCategoryPost(Category category) {
        categoryRepository.save(category);;
        return "redirect:";
    }

    @GetMapping("remove")
    public String removeCategory(@RequestParam long toRemoveId, Model model) {
        model.addAttribute("category", categoryRepository.findCategoryById(toRemoveId));
        model.addAttribute("viewHelper", new ViewHelper());
        return "category/remove";
    }

    @PostMapping("remove")
    public String removeCategory(@RequestParam long toRemoveId, @ModelAttribute ViewHelper viewHelper) {
        if(viewHelper.getOption().equals("confirmed")) {
            categoryRepository.deleteById(toRemoveId);
        }
        return "redirect:";
    }
}
