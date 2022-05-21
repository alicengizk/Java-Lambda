package lambdaTutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Universite {

    /*
TASK :
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method
           içinde 5 arklı obj'den List create ediniz.
           Pojo Class : plan aşamasında java object --> model class ( depo class)
           Private variable
           constructor
           getter setter
           toString

 */

    private String universite;
    private String bolum;
    private int ogrSayisi;
    private int notOrt;

    public Universite() {
    }

    public Universite(String universite, String bolum, int ogrSayisi, int notOrt) {
        this.universite = universite;
        this.bolum = bolum;
        this.ogrSayisi = ogrSayisi;
        this.notOrt = notOrt;
    }

    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrSayisi() {
        return ogrSayisi;
    }

    public void setOgrSayisi(int ogrSayisi) {
        this.ogrSayisi = ogrSayisi;
    }

    public int getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(int notOrt) {
        this.notOrt = notOrt;
    }

    @Override
    public String toString() {
        return "Universite{" +
                "universite='" + universite + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrSayisi=" + ogrSayisi +
                ", notOrt=" + notOrt +
                "\n"+
                '}';
    }
}