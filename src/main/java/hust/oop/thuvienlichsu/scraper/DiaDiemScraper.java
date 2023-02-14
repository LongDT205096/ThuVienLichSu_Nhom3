package hust.oop.thuvienlichsu.scraper;

import hust.oop.thuvienlichsu.ThuVienLichSu;
import hust.oop.thuvienlichsu.entity.DiaDiem;
import hust.oop.thuvienlichsu.utils.StringFormater;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DiaDiemScraper {
    private final String URL = "https://thuvienlichsu.com/dia-diem";
    private final String ROOT = "https://thuvienlichsu.com";
    private final String PAGE = "?page=";
    private int count = 0;
    private final int START_PAGE = 1;
    private final int END_PAGE = 6;
    private List<DiaDiem> danhSachDiaDiem;

    public DiaDiemScraper() {
        this.danhSachDiaDiem = new ArrayList<>();
        System.out.println("# BEGIN SCRAPING [DiaDiem]");
        scrap();
        System.out.println("# END SCRAPING[DiaDiem]:" + (count) + " results found!");
        ThuVienLichSu.totalResults += count;
    }

    public List<DiaDiem> getDanhSachDiaDiem() {
        return danhSachDiaDiem;
    }

    private DiaDiem scrapInSubUrl(String subUrl) {
        List<String> listEv = new ArrayList<String>();  
        List<String> listChar = new ArrayList<String>(); 
        DiaDiem diaDiem = new DiaDiem();

        try {
            Document doc = Jsoup.connect(subUrl).get();
            Elements result = doc.select(".divide-tag");
            for(int i = 0; i < result.size(); i++) {
                Elements header = result.get(i).select("h3.header-edge");
                String title = header.text();
                if(i == 0) {
                    diaDiem.setTenDiaDiem(title);
                }
                if(title.equals("Diễn biễn lịch sử")) {
                    for(Element element: result.select("p")){
                        element.remove();
                    }
                    diaDiem.setNoiDung(result.get(i).select(".card-body").text());
                }
                if(title.equals("Sự kiện liên quan")) {
                    Elements suKienLienQuanHTML = result.get(i).select(".card-body h4.card-title");
                    for(Element element : suKienLienQuanHTML) {
                        String tenSuKien = element.text();
                        tenSuKien = StringFormater.splitStringInTitle(tenSuKien).get(0);
                        listEv.add(tenSuKien);
                    }
                }
                if(title.equals("Nhân vật liên quan")) {
                    Elements nhanVatLienQuanHTML = result.get(i).select(".card-body h4.card-title");
                    for(Element element : nhanVatLienQuanHTML) {
                        String tenNhanVat = element.text();
                        tenNhanVat = StringFormater.splitStringInTitle(tenNhanVat).get(0);
                        listChar.add(tenNhanVat);
                    }
                }
                diaDiem.setTenSuKien(listEv);
                diaDiem.setTenNhanVat(listChar);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return diaDiem;
    }

    private void scrap() {
        try {
            for(int i = START_PAGE; i <= END_PAGE; i++) {
                Document doc = Jsoup.connect(URL + PAGE + String.valueOf(i)).get();
                Elements result = doc.select(".divide-content .card-body a.click");
                for(int j = 0; j < result.size(); j++) {
                    this.danhSachDiaDiem.add(scrapInSubUrl(ROOT + result.get(j).attr("href")));
                    System.out.println("{DiaDiem}:" + (++count) + ",stat=OK");
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
