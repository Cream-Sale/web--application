package com.creamsale.web;

import com.creamsale.enums.categories.GeneralCategory;
import com.creamsale.model.OfferModel;
import com.creamsale.model.SearchRequestModel;
import com.creamsale.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping("/product/{category}/{productName}")
    public List<OfferModel> getProducts(@PathVariable String category, @PathVariable String productName){
        SearchRequestModel searchRequestModel = new SearchRequestModel();
        if (category.equals(GeneralCategory.ELECTRONICS.getValue())){
            searchRequestModel.setGeneralCategory(GeneralCategory.ELECTRONICS);
        }
        searchRequestModel.setSearchText(productName);
        return searchService.findOfferByProductName(searchRequestModel);
    }
}
