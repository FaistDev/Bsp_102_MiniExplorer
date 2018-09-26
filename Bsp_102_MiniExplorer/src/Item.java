
import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;


public class Item extends File {

    private String dateiname="";
    private LocalDateTime datum=LocalDateTime.now();
    private int kb=0;
    private String attribut="";

    public Item(String dateiname, long datum, int kb, String pathname) {
        super(pathname);
        this.dateiname = dateiname;
        this.datum = LocalDateTime.ofEpochSecond(datum/1000, 0, ZoneOffset.UTC);
        this.kb = kb;
        this.attribut = attribut;
    }

    public Item(String dateiname, String pathname) {
        super(pathname);
        this.dateiname = dateiname;
    }

    @Override
    public String toString() {
        return dateiname+" "+datum.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))+" "+kb+" "+attribut;
    }

    public String getDateiname() {
        return dateiname;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public int getKb() {
        return kb;
    }

    public String getAttribut() {
        return attribut;
    }

    public void setAttribut(String attribut) {
        this.attribut = this.attribut+attribut;
    }
    
    

}
