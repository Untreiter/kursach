package Shop.controller;

import Shop.domain.ProductEntity;
import Shop.domain.ProductMedia;
import Shop.repos.ProductEntityRepo;
import Shop.repos.ProductMediaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final ProductEntityRepo productEntityRepo;
    private final ProductMediaRepo productMediaRepo;

    @Autowired
    public HomeController(ProductEntityRepo productEntityRepo, ProductMediaRepo productMediaRepo) {
        this.productEntityRepo = productEntityRepo;
        this.productMediaRepo = productMediaRepo;
    }

    @GetMapping("/")
    public String redirectToHome()
    {
        return "redirect:/catalog";
    }

    @GetMapping("/catalog")
    public String home(
            @RequestParam(required = false, defaultValue = "") String nameFilter,
            @RequestParam(required = false, defaultValue = "") String fromFilter,
            @RequestParam(required = false, defaultValue = "") String toFilter,
            @RequestParam(required = false, defaultValue = "") String order,
            @PageableDefault(sort = {"name"}, direction = Sort.Direction.ASC, size = 6) Pageable pageable,
            Model model
    ) {
        Page<ProductEntity> productEntities;
        Iterable<ProductMedia> productMedia;
        Integer tempFrom = 0;
        Integer tempTo = 0;
        String message = "";
        Integer messageType = 0;

        try {
            tempFrom = fromFilter.isEmpty() ? 0 : Integer.parseInt(fromFilter);
            tempTo = toFilter.isEmpty() ? 999999 : Integer.parseInt(toFilter);
            if (tempTo < tempFrom) {
                throw new Exception();
            }
        } catch (Exception e) {
            productEntities = productEntityRepo.findAll(pageable);
            message = "Пожалуйста введите корректныеданные в поля фильтра";
            model.addAttribute("show", true);
            model.addAttribute("messageType", messageType);
            model.addAttribute("message", message);
            model.addAttribute("productEntities", productEntities);
            model.addAttribute("url", "/catalog");
            model.addAttribute("nameFilter", nameFilter);
            model.addAttribute("fromFilter", fromFilter);
            model.addAttribute("toFilter", toFilter);
            model.addAttribute("order", 0);

            return "home";
        }
        Integer orderVal = 0;

        if (!order.isEmpty() && order.equals("name")) {
            productEntities = productEntityRepo
                    .findByNameContainingAndPriceBetweenOrderByNameAsc(
                            nameFilter,
                            tempFrom,
                            tempTo,
                            pageable
                    );
            orderVal = 1;
        } else if (!order.isEmpty() && order.equals("price")) {
            productEntities = productEntityRepo
                    .findByNameContainingAndPriceBetweenOrderByPriceAsc(
                            nameFilter,
                            tempFrom,
                            tempTo,
                            pageable
                    );
            orderVal = 2;
        } else {
            productEntities = productEntityRepo
                    .findByNameContainingAndPriceBetween(
                            nameFilter,
                            tempFrom,
                            tempTo,
                            pageable
                    );
        }
        productMedia = productMediaRepo.findAll();
        model.addAttribute("productMedia", productMedia);
        model.addAttribute("productEntities", productEntities);
        model.addAttribute("url", "/catalog");
        model.addAttribute("nameFilter", nameFilter);
        model.addAttribute("fromFilter", fromFilter);
        model.addAttribute("toFilter", toFilter);
        model.addAttribute("order", orderVal);

        return "home";
    }
}
