package kr.ac.jejunu.cafeteria.review.suyeon.service;

import kr.ac.jejunu.cafeteria.review.suyeon.model.MenuModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetMenuService {
    private static String Haksik_URL = "http://www.jejunu.ac.kr/camp/stud/foodmenu";

    public List<MenuModel> getMenu() throws IOException {
        List<MenuModel> menuList = new ArrayList<>();
        Document doc = Jsoup.connect(Haksik_URL).get();
        Elements contents = doc.select("table tbody tr");

        MenuModel menuModel = null;
        String day = null;
        String weekend = null;
        for (Element content : contents) {
            Elements tdContents = content.select("td.border_right.border_bottom.txt_center");
            if (tdContents.size() == 4) {
                String[] date = tdContents.get(0).text().split(" ");
                day = date[0];
                weekend = date[1];
                menuModel = MenuModel.builder()
                        .day(day)
                        .weekend(weekend)
                        .division(tdContents.get(1).text())
                        .lunch(tdContents.get(2).text())
                        .dinner(tdContents.get(3).text())
                        .build();

            } else if (tdContents.size() == 3) {
                menuModel = MenuModel.builder()
                        .day(day)
                        .weekend(weekend)
                        .division(tdContents.get(0).text())
                        .lunch(tdContents.get(1).text())
                        .dinner(tdContents.get(2).text())
                        .build();
            } else {
                continue;
            }
            menuList.add(menuModel);
        }
        return menuList;
    }
}
