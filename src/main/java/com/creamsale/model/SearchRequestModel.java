package com.creamsale.model;

import com.creamsale.enums.categories.GeneralCategory;

public class SearchRequestModel {
    private String searchText;
    private GeneralCategory generalCategory;

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public GeneralCategory getGeneralCategory() {
        return generalCategory;
    }

    public void setGeneralCategory(GeneralCategory generalCategory) {
        this.generalCategory = generalCategory;
    }
}
