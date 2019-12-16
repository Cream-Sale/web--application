package com.creamsale.web;

import com.creamsale.db.CashBackDBManager;
import com.creamsale.db.ProductDBManager;
import com.creamsale.dto.CashBackDTO;
import com.creamsale.dto.ProductDTO;
import com.creamsale.enums.CashBack;
import com.creamsale.enums.categories.GeneralCategory;
import com.creamsale.enums.shops.Shop;
import com.creamsale.freemaker.forms.SearchForm;
import com.creamsale.freemaker.forms.SearchResultForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);

        return "index";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.POST)
    public String indexSearch(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {

        String search = searchForm.getSearch();
        final String updSearch = search.toLowerCase();

        if (search.length() > 0) {
            List<ProductDTO> products = ProductDBManager.getProductsByGeneralCategory(GeneralCategory.ELECTRONICS);
            ProductDTO productDTO = products.stream()
                    .filter(p -> p.getName().equalsIgnoreCase(updSearch))
                    .findAny()
                    .orElse(null);
            if (Objects.isNull(productDTO))
                return "index";

            CashBackDTO letyshops = CashBackDBManager.getCashBack(CashBack.LETYSHOPS);
            if (Objects.isNull(letyshops))
                return "index";

            CashBackDTO backit = CashBackDBManager.getCashBack(CashBack.BACKIT);
            if (Objects.isNull(backit))
                return "index";

            Float letyshopsSale = letyshops.getShops().get(Shop.FIVE_ELEMENT).getSalePercent();
            Float backitSale = backit.getShops().get(Shop.FIVE_ELEMENT).getSalePercent();

            SearchResultForm letyshopsForm = new SearchResultForm();
            letyshopsForm.setProductName(productDTO.getName());
            letyshopsForm.setPrice(productDTO.getPrice());
            letyshopsForm.setCashBackName("letyshops");
            letyshopsForm.setCashBackSale(letyshopsSale);
            letyshopsForm.setPriceWithSale((float) Math.floor((100-letyshopsSale)*productDTO.getPrice()/100));

            SearchResultForm backitForm = new SearchResultForm();
            backitForm.setProductName(productDTO.getName());
            backitForm.setPrice(productDTO.getPrice());
            backitForm.setCashBackName("backit");
            backitForm.setCashBackSale(backitSale);
            backitForm.setPriceWithSale((float) Math.floor((100-backitSale)*productDTO.getPrice()/100));


            /*SearchResultForm searchResultForm = new SearchResultForm();
            searchResultForm.setProductName("iphone 7");
            searchResultForm.setPrice(999.99F);
            searchResultForm.setCashBackName("letyshops");
            searchResultForm.setCashBackSale(2.5F);
            searchResultForm.setPriceWithSale(909.99F);

            SearchResultForm searchResultForm1 = new SearchResultForm();
            searchResultForm1.setProductName("iphone 7");
            searchResultForm1.setPrice(999.99F);
            searchResultForm1.setCashBackName("backit");
            searchResultForm1.setCashBackSale(4F);
            searchResultForm1.setPriceWithSale(959.99F);*/

            List<SearchResultForm> searchResultForms = new LinkedList<>();
            searchResultForms.add(letyshopsForm);
            searchResultForms.add(backitForm);

            model.addAttribute("searchResults", searchResultForms);
            return "index";
        }

        return "index";
    }

}
