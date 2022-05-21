package lambdaTutorial;

import java.util.*;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("kusleme", "adana", "trilece",
                "havucDilim", "buryan", "yaglama", "kokorec", "araBasi", "guvec", "trilece", "trilece", "trilece"));

        alfByktekrarsiz(menu);
        System.out.println("\n   ***   ");
        tersSiraliTkrrsz(menu);
        System.out.println("\n   ***   ");
        KcktenBuyugeKarakterSayisinaGore(menu);
        System.out.println("\n   ***   ");
        sonHarfeGoreTersSirali(menu);
        System.out.println("\n   ***   ");
        ciftKarelerTekrrsizBk(menu);
        System.out.println("\n   ***   ");
        karakterSayisiKontrol(menu);
        System.out.println("\n   ***   ");
        wBaslayanYemek(menu);
        System.out.println("\n   ***   ");
        xBitenYemek(menu);
        System.out.println("\n   ***   ");
        enCokKarakteriOlan(menu);
        System.out.println("\n   ***   ");
        ilkElHarcSonHarfeGoreSiraliPrint(menu);

    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfByktekrarsiz(List<String> yemek) {
        yemek. // akis kaynagi
                stream(). // akisa girdi
                //map(t->t.toUpperCase()).// Jamp.ex elemanlar buyuk harf update edildi
                        map(String::toUpperCase). // method refere edildi
                sorted(). // alfabetik (natural dogal) sira yapildi
                distinct(). // benzersiz : tekrarsiz hale getirildi
                forEach(t -> System.out.print(t + " ")); // print edildi
    }
    //distinct() => Bu method tekrarlı elemanları sadece bir kere akisa alir.
    // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
    // Sıralı akışlar için, farklı elemanın seçimi sabittir (yinelenen öğeler için,
    // karşılaşma sırasında ilk görünen öğe korunur.)
    // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.

    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void tersSiraliTkrrsz(List<String> yemek) {
        yemek.
                stream().
                map(String::length).
                sorted(Comparator.reverseOrder()).
                distinct().
                forEach(Lambda01::yazdir);
    }

    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void KcktenBuyugeKarakterSayisinaGore(List<String> yemek) {
        yemek.
                stream().
                sorted(Comparator.
                        comparing(String::length)).
                forEach(t -> System.out.print(t + " "));
    }

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHarfeGoreTersSirali(List<String> yemek) {
        yemek.
                stream().
                sorted(Comparator.
                        comparing(t -> t.toString().
                                charAt(t.toString().
                                        length() - 1)).
                        reversed()).
                forEach(t -> System.out.print(t + " "));
    }
    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan
    // ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
    public static void ciftKarelerTekrrsizBk(List<String>yemek){
        yemek.
                stream().
                map(String::length).
                map(t->t*t).
                filter(Lambda01::ciftBul).
                distinct().
                sorted(Comparator.reverseOrder()).
                forEach(Lambda01::yazdir);
    }
    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void karakterSayisiKontrol(List<String>yemek){
       // amele kod
        boolean kontrol= yemek.
                stream().
                allMatch(t->t.length()<=7);
       if (kontrol){
           System.out.println("List Elemanlari 7 ve Daha Az Harften Olusur");
       } else  System.out.println("List Elemanlari 7 Harften Buyuk");
        System.out.println(kontrol);

        // cincix code

        System.out.println(yemek.
                stream().
                allMatch(t -> t.length() <= 7) ? "List Elemanlari 7 ve Daha Az Harften Olusur" : "List Elemanlari 7 Harften Buyuk");
    }

    //anyMatch() --> enaz bir eleman sarti saglarsa true
    //                  aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true
    //                  en az bir eleman sarti saglamazsa false return eder.
    //noneMatch() --> hic bir sarti SAGLAMAZSA true
    //                  en az bir eleman sarti SAGLARSA false return eder.


    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.

    public static void wBaslayanYemek(List<String>yemek){
        System.out.println(yemek.
                stream().
                noneMatch(t -> t.startsWith("w")) ?
                "w ile baslayan yemegin menude ne isi var" : "hic w ile yemek olur mu");
    }
    // Task : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.

    public static void xBitenYemek(List<String> yemek){
        System.out.println(yemek.
                stream().
                anyMatch(t -> t.endsWith("x")) ?
                "x olmadan olmaz":"x ile bitmez");
    }
    // Task : Karakter sayisi en buyuk elemani yazdiriniz.

    public  static void enCokKarakteriOlan(List<String >yemek){
       Stream<String> enCokKarakterliEleman= yemek.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).limit(1);
                //findFirst());
        System.out.println(Arrays.toString(enCokKarakterliEleman.toArray()));

        /*
        enCokKarakterliEleman.toArray() --> limit() meth return den dolayi stream
        type olan enCokKarakterliEleman toArray() method ile array type olarak convert edildi.

         */


        /*
       TRICK : •    Stream'ler ekrana direk yazdırılamaz.
    Stream'i toArray() ile Array'e çeviririz.
    Array'i de Arrays.toString() 'in içine alıp yazdırabiliriz.
       Ör; System.out.println(Arrays.toString(***.toArray()));
    veya System.out.println(Arrays.asList(***.toArray())); kullanılabilir.
   */

        //limit(a) akısdan cıkan elemanları
        // a parametresine gore ilk a elamanı alır

        //limit(1) => Sınırlandırma demek.
        // Bu akışın elemanlarından oluşan,
        // uzunluğu maxSize'dan uzun olmayacak
        // şekilde kesilmiş bir akış return eder.
        // Stream return eder.

    }
    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

    public static void ilkElHarcSonHarfeGoreSiraliPrint(List<String > yemek){
        yemek.
                stream().
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).
                skip(1).
                forEach(t -> System.out.print(t + " "));
    }

}
