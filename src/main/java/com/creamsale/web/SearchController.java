package com.creamsale.web;

import com.creamsale.domain.CashBackEntity;
import com.creamsale.domain.CashBackShopInfoEntity;
import com.creamsale.enums.categories.GeneralCategory;
import com.creamsale.model.OfferModel;
import com.creamsale.model.SearchRequestModel;
import com.creamsale.parsers.LetyshopsParser;
import com.creamsale.repositories.CashBackRepository;
import com.creamsale.repositories.CashBackShopInfoRepository;
import com.creamsale.repositories.CashBackShopRepository;
import com.creamsale.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private CashBackRepository cashBackRepository;

    @Autowired
    private CashBackShopRepository cashBackShopRepository;

    @Autowired
    private CashBackShopInfoRepository cashBackShopInfoRepository;

    @RequestMapping("/product/{category}/{productName}")
    public List<OfferModel> getProducts(@PathVariable String category, @PathVariable String productName){
        SearchRequestModel searchRequestModel = new SearchRequestModel();
        if (category.equals(GeneralCategory.ELECTRONICS.getValue())){
            searchRequestModel.setGeneralCategory(GeneralCategory.ELECTRONICS);
        }
        searchRequestModel.setSearchText(productName);
        return searchService.findOfferByProductName(searchRequestModel);
    }

    @RequestMapping("/cashback/{cashBackName}/shops")
    public List<CashBackShopInfoEntity> getProducts(@PathVariable String cashBackName){
        Iterator<CashBackEntity> it = cashBackRepository.findAll().iterator();
        List<CashBackEntity> cashBackEntities = new LinkedList<>();
        it.forEachRemaining(cashBackEntities::add);

        CashBackEntity cashBackEntity = cashBackEntities.stream()
                .filter(c -> c.getName().equals(cashBackName))
                .findAny()
                .orElse(null);
        Iterator<CashBackShopInfoEntity> it1 = cashBackEntity.getCashBackShopsInfo().iterator();
        List<CashBackShopInfoEntity> cashBackShopInfoEntities = new LinkedList<>();
        it1.forEachRemaining(cashBackShopInfoEntities::add);
        return cashBackShopInfoEntities;
    }

    @RequestMapping("/product/update")
    public String updateProducts(){
        LetyshopsParser letyshopsParser = new LetyshopsParser();
        List<CashBackShopInfoEntity> shops = null;
        try {
            shops = letyshopsParser.parse();
        } catch (Exception e){
            e.printStackTrace();
        }
        cashBackShopInfoRepository.saveAll(shops);

        CashBackEntity cashBackEntity = new CashBackEntity();
        cashBackEntity.setName("Letyshops");
        cashBackEntity.setLink("https://letyshops.com");
        cashBackEntity.setCashBackShopsInfo(new HashSet<>(shops));
        cashBackRepository.save(cashBackEntity);
        return "true";
    }
}
