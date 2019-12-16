package com.creamsale.db;

import com.creamsale.dto.ShopDTO;
import com.creamsale.enums.categories.GeneralCategory;
import com.creamsale.enums.shops.Shop;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

//ToDo this is dummy class
public class ShopsDBManager {

    //ToDo this is dummy method
    public static List<ShopDTO> getShopsByGeneralCategory(GeneralCategory generalCategory){
        List<ShopDTO> foundShops = new ArrayList<>();
        try {
            switch (generalCategory){
                case ELECTRONICS:
                    foundShops.add(new ShopDTO(Shop.FIVE_ELEMENT, generalCategory, new URI("https://5element.by/")));
                    foundShops.add(new ShopDTO(Shop.SVYAZNOY, generalCategory, new URI("https://www.svyaznoy.by/")));
                    break;
                case CLOTHES_AND_SHOES:
                    foundShops.add(new ShopDTO(Shop.LAMODA, generalCategory, new URI("https://www.lamoda.by/")));
                    break;
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return foundShops;
    }

    public static ShopDTO get5Element(){
        try {
            return new ShopDTO(Shop.FIVE_ELEMENT, GeneralCategory.ELECTRONICS, new URI("https://5element.by/"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }
}
