package com.creamsale.db;

import com.creamsale.dto.ProductDTO;
import com.creamsale.enums.categories.GeneralCategory;
import com.creamsale.service.SearchService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//ToDo this is dummy class
public class ProductDBManager {
    private static List<ProductDTO> items = new ArrayList<>();

    static {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            items.addAll(objectMapper.readValue(SearchService.class.getResourceAsStream("/products/electronics.json"),
                    TypeFactory.defaultInstance().constructCollectionType(List.class, ProductDTO.class)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<ProductDTO> getProductsByGeneralCategory(GeneralCategory generalCategory){
        List<ProductDTO> foundProducts = items.stream()
                .filter(i -> i.getGeneralCategory().equals(generalCategory))
                .collect(Collectors.toList());

        return foundProducts;
    }
}
