package lambdaTutorial;

import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println("Task 01 Amele Topla ---> " + toplaAmele(10));
        System.out.println("   ***   ");
        System.out.println("Task 01 Cincix Topla ---> " + toplaCincix(10));
        System.out.println("   ***   ");
        System.out.println("Task 02 ---> " + toplaCift(10));
        System.out.println("   ***   ");
        System.out.println("Task 03 ---> " + toplaIlkXCift(10));
        System.out.println("   ***   ");
        System.out.println("Task 04 ---> " + toplaIlkXTek(10));
        System.out.println("   ***   ");
        System.out.println("Task 05 ---> ");
        ikininIlkXKuvveti(7);
        System.out.println("   ***   ");
        System.out.println("Task 06 ---> ");
        istenenSayininIlkXKuvveti(4, 3);
        System.out.println("   ***   ");
        istenenSayininIlkXKuvveti(3, 4);
        System.out.println("   ***   ");
        System.out.println("Task 07 ---> " +istenenSayininFaktoriyeliniAlma(5));
        System.out.println("   ***   ");
        System.out.println("Task 08 ---> "+istenenSayininXKuvvetiniAlma(4,3));
        System.out.println("   ***   ");
        System.out.println("Task 08 ---> "+istenenSayininXKuvvetiniAlma2(3,4));

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile
    // 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

    //Structured(AMELE) Programming
    public static int toplaAmele(int x) {
        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }

    //Functional(cincix Programming
    public static int toplaCincix(int x) {
        return IntStream.
                range(1, x + 1). // 1'den x 'e kadawr (x dahil, x+1 dahil degil) int degerler akisa alindi.
                        sum(); // akisdaki int degerler toplandi.
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int toplaCift(int x) {
        return IntStream.
                rangeClosed(1, x). // 1'den x 'e kadawr (x dahil) int degerler akisa alindi.
                        filter(Lambda01::ciftBul). // akistaki cift int degerler filtrelendi
                        sum(); // akisdaki int degerler toplandi.
    }


    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int toplaIlkXCift(int x) {
        return IntStream.iterate(2, t -> t + 2). // 2 den sonsuza kadar elemanlari 2 artirarak akisa alir.
                limit(x). // akistaki ilk x int degeri akisa alir
                sum(); // akisdaki int degerler toplandi.
    }
    //iterate(seed, repeat action) -->
    // seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa koy

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int toplaIlkXTek(int x) {
        return IntStream.iterate(1, t -> t + 2).
                limit(x).sum();
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvveti(int x) {
        IntStream.
                iterate(2, t -> t * 2).
                limit(x).
                forEach(Lambda01::yazdir);
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istenenSayininIlkXKuvveti(int istenensayi, int x) {
        IntStream.
                iterate(istenensayi, t -> t * istenensayi).
                limit(x).
                forEach(Lambda01::yazdir);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int istenenSayininFaktoriyeliniAlma(int x) {
        return IntStream.
                rangeClosed(1, x).
                reduce(1, Math::multiplyExact);
    }

    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static IntStream istenenSayininXKuvvetiniAlma(int istenensayi, int x) {
        return IntStream.
                iterate(istenensayi,t->t*istenensayi).
                limit(x).skip(x-1);
    }
    public static int istenenSayininXKuvvetiniAlma2(int istenensayi, int x) {
        return IntStream.
                iterate(istenensayi, t -> t * istenensayi).
                limit(x).reduce(0,(t,u)->u);
    }
    public static double xKuvveti (int istenenSayi, int x) {
        return Math.pow(istenenSayi,x);

    }

}
