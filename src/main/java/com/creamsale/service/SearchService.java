package com.creamsale.service;

import com.creamsale.db.CashBackDBManager;
import com.creamsale.db.ProductDBManager;
import com.creamsale.db.ShopsDBManager;
import com.creamsale.dto.CashBackDTO;
import com.creamsale.dto.ProductDTO;
import com.creamsale.dto.ShopDTO;
import com.creamsale.model.OfferModel;
import com.creamsale.model.SearchRequestModel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchService {

    public List<OfferModel> findOfferByProductName(SearchRequestModel searchRequestModel) {
        Map<ShopDTO, List<CashBackDTO>> shopWithCashBacksMap = new LinkedHashMap<>();

        List<ShopDTO> shopsWithOffer = ShopsDBManager.getShopsByGeneralCategory(searchRequestModel.getGeneralCategory());
        shopsWithOffer.forEach(shopDTO -> shopWithCashBacksMap.put(shopDTO, CashBackDBManager.getCashBacksByShop(shopDTO.getShopName())));

        List<ProductDTO> products = ProductDBManager.getProductsByGeneralCategory(searchRequestModel.getGeneralCategory());
        ProductDTO offerProduct = products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(searchRequestModel.getSearchText()) ||
                        product.getName().contains(searchRequestModel.getSearchText()))
                .findAny()
                .orElse(null);

        if (Objects.isNull(offerProduct)) {
            //ToDo
            throw new RuntimeException("Products '" + searchRequestModel.getSearchText() + "' not found!");
        } else {
            List<OfferModel> offers = new LinkedList<>();
            for (Map.Entry<ShopDTO, List<CashBackDTO>> shopWithCashBacks : shopWithCashBacksMap.entrySet()) {
                offers.add(new OfferModel(shopWithCashBacks.getValue(), shopWithCashBacks.getKey(), offerProduct));
            }
            return offers;
        }
    }
}
