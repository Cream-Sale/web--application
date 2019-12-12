package com.creamsale.web;

import com.creamsale.db.ProductDBManager;
import com.creamsale.domain.CashBackEntity;
import com.creamsale.domain.CashBackSaleEntity;
import com.creamsale.domain.ShopEntity;
import com.creamsale.dto.ProductDTO;
import com.creamsale.enums.categories.GeneralCategory;
import com.creamsale.model.OfferModel;
import com.creamsale.model.SearchRequestModel;
import com.creamsale.repositories.CashBackRepository;
import com.creamsale.repositories.CashBackSaleRepository;
import com.creamsale.repositories.ProductRepository;
import com.creamsale.repositories.ShopRepository;
import com.creamsale.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CashBackRepository cashBackRepository;

    @Autowired
    private CashBackSaleRepository cashBackSaleRepository;

    @Autowired
    private ShopRepository shopRepository;

    @RequestMapping("/product/{category}/{productName}")
    public List<OfferModel> getProducts(@PathVariable String category, @PathVariable String productName){
        SearchRequestModel searchRequestModel = new SearchRequestModel();
        if (category.equals(GeneralCategory.ELECTRONICS.getValue())){
            searchRequestModel.setGeneralCategory(GeneralCategory.ELECTRONICS);
        }
        searchRequestModel.setSearchText(productName);
        return searchService.findOfferByProductName(searchRequestModel);
    }

    @RequestMapping("/product/update")
    public String updateProducts(){
        ShopEntity shopEntity = new ShopEntity();
        shopEntity.setGeneralCategory(GeneralCategory.ELECTRONICS);
        shopEntity.setName("5Element");
        shopEntity.setLink("https://5element.by");
        shopRepository.save(shopEntity);
        ShopEntity shopEntity1 = new ShopEntity();
        shopEntity1.setGeneralCategory(GeneralCategory.ELECTRONICS);
        shopEntity1.setName("electrosila");
        shopEntity1.setLink("https://sila.by");
        shopRepository.save(shopEntity1);

        CashBackEntity cashBackEntity = new CashBackEntity();
        cashBackEntity.setName("LetyShops");
        cashBackEntity.setLink("https://letyshops.com");
        cashBackRepository.save(cashBackEntity);

        Iterator<ShopEntity> it = shopRepository.findAll().iterator();
        Set<ShopEntity> shopEntities = new HashSet<>();
        it.forEachRemaining(shopEntities::add);

        CashBackSaleEntity cashBackSaleEntity = new CashBackSaleEntity();
        cashBackSaleEntity.setSalePercent(5L);
        cashBackSaleEntity.setDescription("description 5 element");
        ShopEntity shopEntity2 = shopEntities.stream()
                .filter(s -> s.getName().equals("5Element"))
                .findAny()
                .orElse(null);
        cashBackSaleEntity.setShop(shopEntity2);
        cashBackSaleEntity.setCashBack(cashBackRepository.findById(1).get());
        CashBackSaleEntity cashBackSaleEntity1 = new CashBackSaleEntity();
        cashBackSaleEntity1.setSalePercent(3L);
        cashBackSaleEntity1.setDescription("description electrosila");
        ShopEntity shopEntity3 = shopEntities.stream()
                .filter(s -> s.getName().equals("electrosila"))
                .findAny()
                .orElse(null);
        cashBackSaleEntity1.setShop(shopEntity3);
        cashBackSaleEntity1.setCashBack(cashBackRepository.findById(1).get());

        cashBackSaleRepository.save(cashBackSaleEntity);
        cashBackSaleRepository.save(cashBackSaleEntity1);

        return "true";
    }
}
