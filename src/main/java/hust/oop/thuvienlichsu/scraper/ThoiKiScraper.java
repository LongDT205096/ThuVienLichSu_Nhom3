package hust.oop.thuvienlichsu.scraper;

import hust.oop.thuvienlichsu.ThuVienLichSu;
import hust.oop.thuvienlichsu.entity.ThoiKi;
import hust.oop.thuvienlichsu.utils.StringFormater;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class ThoiKiScraper {
    private final String URL = "https://vansu.vn/viet-nam/viet-nam-nhan-vat";
    private List<ThoiKi> danhSachThoiKi;
    private int count = 0;
    public ThoiKiScraper() {
        this.danhSachThoiKi = new ArrayList<>();
        System.out.println("# BEGIN SCRAPING [ThoiKi]");
        scrap();
        System.out.println("# END SCRAPING[ThoiKi]:" + (count) + " results found!");
        ThuVienLichSu.totalResults += count;
    }

    public List<ThoiKi> getDanhSachThoiKi() {
        return danhSachThoiKi;
    }

    private void scrap() {
        StringFormater formater = new StringFormater();
        try {
            Document doc = Jsoup.connect(URL).get();
            Elements firstResult = doc.select(".menu:nth-child(4)");
            Element danhSachThoiKiHTML = firstResult.get(0);
            Elements thoiKiHTML = danhSachThoiKiHTML.select(".item");
            for(int i = 1; i < thoiKiHTML.size(); i++) {
                ThoiKi thoiKi = new ThoiKi();
                String tenThoiKi = thoiKiHTML.get(i).text();
                List<String> componentThoiKi = StringFormater.splitStringInTitle(tenThoiKi);
                thoiKi.setTenThoiKi(componentThoiKi.get(0));
                if(componentThoiKi.size() > 1) {
                    String bd = componentThoiKi.get(1);
                    String kt = componentThoiKi.get(2);
                    if(!bd.toLowerCase().contains("trcn") && kt.toLowerCase().contains("trcn")) bd += " trCN";
                    thoiKi.setNamBatDau(bd);
                    thoiKi.setNamKetThuc(kt);
                }
                this.danhSachThoiKi.add(thoiKi);
                System.out.println("{ThoiKi}:" + (++count) + ",stat=OK");

            }
            this.danhSachThoiKi.get(0).setNamBatDau("Không rõ");
            this.danhSachThoiKi.get(0).setNamKetThuc("Không rõ");

            int namKetThucGanNhat = Integer.parseInt(this.danhSachThoiKi.get(this.danhSachThoiKi.size()-2).getNamKetThuc());
            this.danhSachThoiKi.get(danhSachThoiKi.size()-1).setNamBatDau(String.valueOf(namKetThucGanNhat));
            this.danhSachThoiKi.get(danhSachThoiKi.size()-1).setNamKetThuc(Year.now().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
