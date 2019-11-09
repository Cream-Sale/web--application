package com.creamsale.web;

import com.creamsale.model.ProductModel;
import com.creamsale.service.SearchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @RequestMapping
    public List<ProductModel> getListOfProducts(){
        return SearchService.findAll();
    }


}
