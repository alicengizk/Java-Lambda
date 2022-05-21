package lambdaTutorial;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

    /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 arklı obj'den List create ediniz.
     */
    public static void main(String[] args) {
        Universite bogazici = new Universite("bogazici", "matematik", 571, 93);
        Universite itu = new Universite("istanbul teknik", "isletme", 622, 81);
        Universite istanbul = new Universite("istanbul", "hukuk", 1453, 71);
        Universite marmara = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite ytu = new Universite("yildiz teknik", "gemi", 333, 74);
        List<Universite> unv = new ArrayList<>(Arrays.asList(bogazici, itu, istanbul, marmara, ytu));

        System.out.println(notOrt74BykUnv(unv));
        System.out.println("\n   ***   ");
        System.out.println(ogrSayisi110danAzMi(unv));
        System.out.println("\n   ***   ");
        System.out.println(matBolumVarMi(unv));
        System.out.println("\n   ***   ");
        System.out.println(ogrSayisinaGoreUnv(unv));
        System.out.println("\n   ***   ");
        System.out.println(notOrtGoreIlk3Unv(unv));
        System.out.println("\n   ***   ");
        System.out.println(ogrSayisiEnazIkinciUnv(unv));
        System.out.println("\n   ***   ");
        System.out.println(notOrt63denBuyukOgrSayisiToplami(unv));
        System.out.println("\n   ***   ");
        System.out.println(matBolumSayisi(unv));
        System.out.println("\n   ***   ");
        System.out.println(ogrSayisi571denBykEnBykNotOrt(unv));
        System.out.println("\n   ***   ");
        System.out.println(ogrSayisi500denKckEnKckNotOrt(unv));


    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<Universite> unv){

        return unv.
                stream().
                allMatch(t->t.getNotOrt()>74);
    }

    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.
    public static boolean ogrSayisi110danAzMi(List<Universite > unv){

        return unv.stream().allMatch(t->t.getOgrSayisi()>110);
    }

    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumVarMi(List<Universite> unv){
        return unv.stream().anyMatch(t->t.getBolum().contains("mat"));
    }

    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayisinaGoreUnv(List<Universite> unv) {
      return   unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi).
                        reversed()).
                collect(Collectors.toList());
    }

    //collect()->akısdaki elamanları istenen sarta gore toplar
    //Collectors.toList()->collect'e toplanan elemanlarilist'e cevirir

    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    public static List<Universite> notOrtGoreIlk3Unv(List<Universite> unv){
       return unv.stream().sorted(Comparator.comparing(Universite::getNotOrt).reversed()).limit(3).collect(Collectors.toList());
    }

    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.
    public static List<Universite> ogrSayisiEnazIkinciUnv(List<Universite> unv){
        return unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi)).
                limit(2).skip(1).collect(Collectors.toList());


    }

    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz
    public static Optional<Integer> notOrt63denBuyukOgrSayisiToplami(List<Universite> unv) {
       return unv.
                stream().
                filter(t->t.getNotOrt()>63).
                map(Universite::getOgrSayisi).
                reduce(Integer::sum);

    }
    // mapToInt() --> bu method akısdaki elemanların data type'nı
    // parameterisindeki() degere göre Int data type update eder
    // mapToInt() --> bu method akısdaki elemanların data type'nı
    // parameterisindeki() degere göre Int data type update eder


    //task 08--> Ogrenci sayisi 333'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
    public static OptionalDouble ogrSayisi333danBykNotOrtOrtalamsi(List<Universite> unv){
         return unv.
                  stream().
                  filter(t->t.getOgrSayisi()>333).
                  mapToInt(t->t.getNotOrt()).average();
    }
    // mapToDouble() --> bu method akısdaki elemanların data type'nı
    // parameterisindeki degere göre dooble data type update eder

    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int matBolumSayisi(List<Universite> unv){
       return (int) unv.stream().filter(t->t.getBolum().contains("mat")).count();

    }

    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz
    public static Optional<Universite> ogrSayisi571denBykEnBykNotOrt(List<Universite> unv){
      return unv.
                stream().
                filter(t->t.getOgrSayisi()>571).
                sorted(Comparator.comparing(Universite::getNotOrt).reversed()).findFirst();

    }

    //task 11-->Ogrenci sayilari 500'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static Optional<Universite> ogrSayisi500denKckEnKckNotOrt(List<Universite> unv){
        return unv.
                stream().
                filter(t->t.getOgrSayisi()>500).
                min(Comparator.comparing(Universite::getNotOrt));


    }

}