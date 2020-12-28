package cn.how2j.springcloud.controller;

import cn.how2j.springcloud.pojo.Product;
import cn.how2j.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    @Value("${version}")
    private String version;

    @Autowired
    private ProductService productService;


    @RequestMapping("/products")
    public Object products(Model model){
        List<Product> products = productService.listProducts();
        model.addAttribute("ps", products);
        model.addAttribute("version", version);
        return "products";
    }
}
