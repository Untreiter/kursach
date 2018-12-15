package Shop.controller;

import Shop.domain.ProductData;
import Shop.domain.ProductEntity;
import Shop.domain.ProductMedia;
import Shop.repos.ProductDataRepo;
import Shop.repos.ProductEntityRepo;
import Shop.repos.ProductMediaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@SuppressWarnings("ALL")
@Controller
public class AddProductController {
    private final ProductEntityRepo productEntityRepo;
    private final ProductDataRepo productDataRepo;
    private final ProductMediaRepo productMediaRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public AddProductController(ProductEntityRepo productEntityRepo, ProductDataRepo productDataRepo, ProductMediaRepo productMediaRepo) {
        this.productEntityRepo = productEntityRepo;
        this.productDataRepo = productDataRepo;
        this.productMediaRepo = productMediaRepo;
    }

    @GetMapping("/addProduct")
    public String addProduct (Model model)
    {
        model.addAttribute("show", false);

        return "addproduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String priceStr,
            @RequestParam(defaultValue = "") String shortDescription,
            @RequestParam(required = false) Integer availability,
            @RequestParam(defaultValue = "") String quantityStr,
            @RequestParam(defaultValue = "") String description,
            @RequestParam("productImage") MultipartFile file,
            Model model
    ) {
        String message = "";
        Boolean needToShow = true;
        Integer messageType = 0;

        if (name.equals("")
                || priceStr.equals("")
                || shortDescription.equals("")
                || description.equals("")
                || (!file.getContentType().equals("image/jpeg") && !file.isEmpty()&&file.getContentType().equals("image/png"))
        ) {
            messageType = 1;
            message = "Пожалуйста введите корректные данные о продукте";
            model.addAttribute("show", needToShow);
            model.addAttribute("messageType", messageType);
            model.addAttribute("message", message);

            return "addproduct";
        }
        try {
            Integer price = Integer.parseInt(priceStr);
            Integer quantity = Integer.parseInt(quantityStr);
            ProductEntity productEntity = new ProductEntity(name, shortDescription, price);
            productEntityRepo.save(productEntity);
            ProductData prData = new ProductData(productEntity.getId(), description, availability, quantity);
            productDataRepo.save(prData);

            if (file != null && !file.getOriginalFilename().isEmpty()) {
                File uploadDir = new File(uploadPath);

                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                String filename = "product_"
                        + productEntity.getId()
                        + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                file.transferTo(new File(uploadPath + "/" + filename));
                ProductMedia productMedia = new ProductMedia(productEntity.getId(), "image", name, filename);
                productMediaRepo.save(productMedia);
            }
            message = "Продукт сохранен.";
        } catch (Exception e) {
            message = "При создании продукта произошла ошибка: " + e.getMessage();
            messageType = 1;
        }
        model.addAttribute("show", needToShow);
        model.addAttribute("messageType", messageType);
        model.addAttribute("message", message);

        return "addproduct";
    }

}
