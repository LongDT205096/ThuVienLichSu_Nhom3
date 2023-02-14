package hust.oop.thuvienlichsu.scraper;

import hust.oop.thuvienlichsu.ThuVienLichSu;
import hust.oop.thuvienlichsu.entity.SuKien;

import hust.oop.thuvienlichsu.utils.StringFormater;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SuKienScraper {
    private final String URL = "https://thuvienlichsu.com/su-kien";
    private final String ROOT = "https://thuvienlichsu.com";
    private final String PAGE = "?page=";
    private List<SuKien> danhSachSuKien;
    private int count = 0;
    private final int START_PAGE = 1;
    private final int END_PAGE = 6;

    public SuKienScraper() {
        this.danhSachSuKien = new ArrayList<>();
        System.out.println("# BEGIN SCRAPING [SuKien]");
        scrap();
        System.out.println("# END SCRAPING[SuKien]:" + (count) + " results found!");
        ThuVienLichSu.totalResults += count;
    }

    private SuKien scrapInSubUrl(String subUrl) {
        List<String> listPlaces = new ArrayList<String>();  
        List<String> listChar = new ArrayList<String>(); 
        SuKien suKien = new SuKien();

        try {
            Document doc = Jsoup.connect(subUrl).get();
            Elements result = doc.select(".divide-tag");
            for(int i = 0; i < result.size(); i++) {
                Elements header = result.get(i).select("h3.header-edge");
                String title = header.text();
                if(i == 0){
                    List<String> tt = StringFormater.splitStringInTitle(title);
                    suKien.setTenSuKien(tt.get(0));
                    if(tt.size() == 2) {
                        suKien.setNamDienRa(tt.get(1));
                        suKien.setNamKetThuc(tt.get(1));
                    }
                    if(tt.size() == 3) {
                        suKien.setNamDienRa(tt.get(1).equals("") ? tt.get(2) : tt.get(1));
                        suKien.setNamKetThuc(tt.get(2).equals("") ? tt.get(1) : tt.get(2));
                    }
                }
                if(title.equals("Diễn biễn lịch sử")) {
                    for(Element element: result.select("p")){
                        element.remove();
                    }
                    suKien.setDienBien(result.get(i).select(".card-body").text());
                }
                if(title.equals("Địa điểm liên quan")) {
                    Elements diaDiemHTML = result.get(i).select(".card-body .card-title");
                    for(Element element : diaDiemHTML) {
                        String tenDiaDiem = element.text();
                        tenDiaDiem = StringFormater.splitStringInTitle(tenDiaDiem).get(0);
                        listPlaces.add(tenDiaDiem);
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
                suKien.setTenDiaDiem(listPlaces);
                suKien.setTenNhanVat(listChar);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return suKien;
    }

    private void scrap() {
        try {
            for(int i = START_PAGE; i <= END_PAGE; i++) {
                Document doc = Jsoup.connect(URL + PAGE + String.valueOf(i)).get();
                Elements result = doc.select(".divide-content .card-body a.click");
                for(int j = 0; j < result.size(); j++) {
                    this.danhSachSuKien.add(scrapInSubUrl(ROOT + result.get(j).attr("href")));
                    System.out.println("{SuKien}:" + (++count) + ",stat=OK");
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List<SuKien> getDanhSachSuKien() {
        return danhSachSuKien;
    }
}

