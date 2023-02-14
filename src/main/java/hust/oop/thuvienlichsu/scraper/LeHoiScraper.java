package hust.oop.thuvienlichsu.scraper;

import hust.oop.thuvienlichsu.ThuVienLichSu;
import hust.oop.thuvienlichsu.entity.LeHoi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.ArrayList;
import java.util.List;

public class LeHoiScraper {
    private List<LeHoi> danhSachLeHoi;
    private int count = 0;

    public LeHoiScraper(){
        this.danhSachLeHoi = new ArrayList<>();
        System.out.println("# BEGIN SCRAPING [LeHoi]");
        scrap();
        System.out.println("# END SCRAPING[LeHoi]:" + (count) + " results found!");
        ThuVienLichSu.totalResults += count;
    }

    public List<LeHoi> getDanhSachLeHoi(){
        return danhSachLeHoi;
    }

    private void scrap() {
        String url_lehoi = "https://vi.wikipedia.org/wiki/L%E1%BB%85_h%E1%BB%99i_Vi%E1%BB%87t_Nam#Danh_s%C3%A1ch_m%E1%BB%99t_s%E1%BB%91_l%E1%BB%85_h%E1%BB%99i";

        try {
            final Document document = Jsoup.connect(url_lehoi).get();
            for (Element row : document.select("table.prettytable.wikitable tr")) {
                LeHoi leHoi = new LeHoi();
                
                final String day = row.select("td:nth-of-type(1)").text();
                final String location = row.select("td:nth-of-type(2)").text().split(",")[0];

                final String name = row.select("td:nth-of-type(3)").text();
                final String firstTime = row.select("td:nth-of-type(4)").text();
                final String relatedFigure = row.select("td:nth-of-type(5)").text();

                if (name.equals("")) continue;

                String[] splittedChars = relatedFigure.split(", ");
                for (String relateChar : splittedChars) {
                    leHoi.addNhanVatLienQuan(relateChar);
                }
                leHoi.setTenLeHoi(name);
                leHoi.setNgayToChuc(day);
                leHoi.setDiaDiemToChuc(location);
                leHoi.setNgayThanhLap(firstTime);

                this.danhSachLeHoi.add(leHoi);
                System.out.println("{LeHoi}:" + (++count) + ",stat=OK");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
