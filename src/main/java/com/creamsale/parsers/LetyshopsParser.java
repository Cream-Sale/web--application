package com.creamsale.parsers;

import com.creamsale.domain.CashBackShopInfoEntity;
import com.creamsale.enums.CashBack;
import com.creamsale.utils.SequenceGenerator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LetyshopsParser implements IParser{
    //change it using enum value
    private final String letyshopLink = CashBack.LETYSHOPS.value()+"/by/shops/";

    /**
     * @param document must be like https://letyshops.com/by/shops?page=SOME_ID
     * @return links to shops on letyshop like /by/shops/lamoda-by, /by/shops/aliexpress ...
     */
    private List<String> getUrlsOfGoods(Document document) {
        return document.select(".b-teaser")
                .stream()
                .map(each -> each.child(1).attr("href"))
                .collect(Collectors.toList());
    }

    /**
     * @param localLinks like /by/shops/lamoda-by, /by/shops/aliexpress ...
     * @return like
     * <li>
     * https://letyshops.com/by/shops/lamoda-by,
     * https://letyshops.com/by/shops/aliexpress
     * </li>
     */
    private List<String> makeFullLinks(List<String> localLinks) {
        return localLinks.stream()
                .map(each -> CashBack.LETYSHOPS.value() + each) //change this hardcode to ENUM value
                .collect(Collectors.toList());
    }

    /**
     * @param document must be like https://letyshops.com/by/shops?page=SOME_ID
     * @return index of last possible page
     * @see "https://github.com/Cream-Sale/web--application/blob/master/avaliable_pages.jpg"
     */
    private int getLastPageIdx(Document document) {
        Elements linksToPages = document.select(".b-pagination__item");
        return Integer.parseInt(linksToPages.get(linksToPages.size() - 2).child(0).attr("data-page"));
    }

    /**
     * @param url     must be like https://letyshops.com/by/shops?page=
     * @param indices to be added to the end of url string
     * @return like
     * <li>
     * https://letyshops.com/by/shops?page=1,
     * https://letyshops.com/by/shops?page=2
     * </li>
     */
    private List<String> enumPages(String url, List<Integer> indices) {
        return indices.stream()
                .map(each -> url + each)
                .collect(Collectors.toList());
    }

    /**
     * @param document must be like https://letyshops.com/by/shops/lamoda-by
     * @return discount containing string like
     * <li>
     * up to 5 %
     * 4 %
     * up to 10 $
     * up to 3.5 BYN
     * </li>
     */
    private String getDiscountInfo(Document document) {
        return document.select(".b-shop-teaser__cash-value-row").select("span").text();
    }

    /**
     * @param document must be like https://letyshops.com/by/shops/lamoda-by
     */
    private String getShopName(Document document) {
        return document.select(".container").get(2).child(0).child(0).child(2).text();
    }

    /**
     * @param document must be like https://letyshops.com/by/shops/lamoda-by
     * @return like
     * <li>
     * 5% Мобильные аксессуары, одежда, предметы интерьера, садовые принадлежности
     * 1.5% Мобильные телефоны, планшеты и ноутбуки, компьютерная техника и аксессуары, аудио- и видеотехника, внешние хранилища
     * 2.5% Все остальное
     * 0.5% За товары из списка магазинов ниже
     * </li>
     */
    private List<String> getConditions(Document document) {
        return document.select(".b-module-info--conditions")
                .get(0).children()
                .stream()
                .map(Element::text)
                .collect(Collectors.toList());
    }

    /**
     * @param pagesLinks must be like
     *                   <li>
     *                   https://letyshops.com/by/shops?page=1,
     *                   https://letyshops.com/by/shops?page=2
     *                   </li>
     * @return like
     */
    private List<String> getUrlsOfGoods(List<String> pagesLinks) {
        return pagesLinks.stream().map(each -> {
            try {
                return Jsoup.connect(each).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }).filter(Objects::nonNull).flatMap(document -> getUrlsOfGoods(document).stream()).collect(Collectors.toList());
    }

    //будет возвращать коллекцию объектов, описывающих скидку
    public CashBackShopInfoEntity getFullPageData(String url) throws IOException {
        Document dddd = Jsoup.connect(url).get();
        CashBackShopInfoEntity cashBackShopInfoEntity = new CashBackShopInfoEntity();
        cashBackShopInfoEntity.setLink(url);
        cashBackShopInfoEntity.setName(getShopName(dddd));
        return cashBackShopInfoEntity;
    }

    // в интерфейсе тож поменяй возвращаемое
    public List<CashBackShopInfoEntity> parse() throws Exception {
        Document document = Jsoup.connect(letyshopLink).get();
        int lastPageIdx = getLastPageIdx(document);
        List<Integer> indicesFrom1ToLast = new SequenceGenerator(1, lastPageIdx, 1).generate();
        List<String> linksToAllPages = enumPages(CashBack.LETYSHOPS.value()+"/by/shops?page=", indicesFrom1ToLast);
        List<String> allLocalUrlsOfGoods = getUrlsOfGoods(linksToAllPages);
        List<String> fullGoodLinks = makeFullLinks(allLocalUrlsOfGoods);
        List<CashBackShopInfoEntity> res = new LinkedList<>();
        for (String url : fullGoodLinks) {
            res.add(getFullPageData(url));
        }
        return res;
    }
}