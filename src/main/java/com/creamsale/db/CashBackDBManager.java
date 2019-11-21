package com.creamsale.db;

import com.creamsale.dto.CashBackDTO;
import com.creamsale.enums.shops.Shop;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//ToDo this is dummy class
public class CashBackDBManager {

    private static List<CashBackDTO> items = new ArrayList<>();

    static {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            items.add(objectMapper.readValue(CashBackDBManager.class.getResourceAsStream("/cashbacks/letyshops.json"), CashBackDTO.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<CashBackDTO> getCashBacksByShop(Shop shop){
        List<CashBackDTO> foundCashBacks = items.stream()
                .filter(i -> i.getShops().containsKey(shop))
                .collect(Collectors.toList());

        return foundCashBacks;
    }
}
