package com.creamsale.service;

import com.creamsale.model.ProductModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    //ToDo not static!!!
    private static List<ProductModel> items = new ArrayList<>();

    //ToDo not static!!!
    static {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            items.addAll(objectMapper.readValue(SearchService.class.getResourceAsStream("/products/phone.json"),
                    TypeFactory.defaultInstance().constructCollectionType(List.class, ProductModel.class)));
            items.addAll(objectMapper.readValue(SearchService.class.getResourceAsStream("/products/watch.json"),
                    TypeFactory.defaultInstance().constructCollectionType(List.class, ProductModel.class)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ProductModel> findAll() {
        return items;
    }
}
