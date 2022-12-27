package com.example.manageproduct2.controller;

import com.example.manageproduct2.dto.ProductDTO;
import com.example.manageproduct2.service.BrandService;
import com.example.manageproduct2.service.ProductService;
import com.example.manageproduct2.service.StatusService;
import com.example.manageproduct2.service.Sub_CategoryService;
import com.example.manageproduct2.util.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    BrandService brandService;
    @Autowired
    Sub_CategoryService sub_categoryService;
    @Autowired
    StatusService statusService;

    @GetMapping("")
    public String viewProduct(Model model, @Param("searchByName") String searchByName, @Param("searchByPrice") Double searchByPrice) {
        model.addAttribute("productsAll", productService.getAll(searchByName, searchByPrice));
        model.addAttribute("brandsAll", brandService.getAll());
        model.addAttribute("subCategoryAll", sub_categoryService.getAll());
        model.addAttribute("statusAll", statusService.getAll());
        model.addAttribute("searchByName", searchByName);
        model.addAttribute("searchByPrice", searchByPrice);
        return "product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@Valid ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("message", bindingResult.getFieldErrors());
        } else {
            productService.save(productDTO);
            redirectAttributes.addFlashAttribute("success", "Add successful !");
        }
        return "redirect:/";
    }

    @GetMapping("/showView/{id}")
//    @ResponseBody
    public Object showView(@PathVariable(value = "id") Long id) {
//        return productService.getById(id);
        ProductDTO productDTO = productService.getById(id);
        if (productDTO != null) {
            return ResponseHelper.getObjectResponseEntity(HttpStatus.OK, productDTO);
        } else {
            return ResponseHelper.handleErrors(HttpStatus.NOT_FOUND, "Product is not existed !");
        }

    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Long id, @Valid ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        productService.update(id, productDTO);
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("message", bindingResult.getFieldErrors());
        } else {
            productService.update(id, productDTO);
            redirectAttributes.addFlashAttribute("success", "Update successful !");
        }
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id, RedirectAttributes redirectAttributes) {
        this.productService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Delete successful !");
        return "redirect:/";
    }

}
