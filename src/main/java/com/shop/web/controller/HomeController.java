package com.shop.web.controller;

import com.shop.data.model.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HomeController {
   @Autowired
   ProductService productServiceImpl;

    @GetMapping(value={"/" , "/index"})
public String getIndex(Model model){
        List<Product> productList = productServiceImpl.findAll();
        model.addAttribute("products",productList);
    return "index";
}
@GetMapping("/about")
public String getAbout(){
        return "about";
}

@GetMapping("/product")
public String getProduct(){
        return "product";
}

@GetMapping("/services")
public  String getServices(){
        return "services";
}

@GetMapping("/single/{id}")
public ModelAndView getSingle(@PathVariable("id") Long id){
    ModelAndView modelAndView = new ModelAndView( "single");
    Product product = productServiceImpl.findById(id);
    modelAndView.addObject(product);
        return modelAndView;
}
}

