package com.creamsale.web;

import com.creamsale.model.ProductModel;
import com.creamsale.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping
    public List<ProductModel> getListOfProducts(){
        return searchService.findAll();
    }

    @RequestMapping("/product/{productName}")
    public List<ProductModel> getProducts(@PathVariable String productName){
        List<ProductModel> allProducts = searchService.findAll();
        List<ProductModel> products = allProducts.stream()
                .filter(productModel -> productModel.getName().equalsIgnoreCase(productName))
                .collect(Collectors.toList());
        return products;
    }
}
