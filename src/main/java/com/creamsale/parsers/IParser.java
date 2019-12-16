package com.creamsale.parsers;

import com.creamsale.domain.CashBackShopInfoEntity;

import java.util.List;

public interface IParser {
    List<CashBackShopInfoEntity> parse() throws Exception;
}
