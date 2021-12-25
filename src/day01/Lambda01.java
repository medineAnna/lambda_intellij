package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda01 {
    public static void main(String[] args) {
		/*
		   1) Lambda "Functional Programming"
		      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
		   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
		   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
		   ve hatasiz code yazma acilarindan cok faydalidir.
		   4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
		      Lambda kullanmak hatasız code kullanmaktır.
		*/

        List<Integer> list=new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,55));

        printElStructured(list);// method call
        System.out.println();
        System.out.println("  ***  ");

        printElFunctional(list);//lambda expression calisti
        System.out.println();
        System.out.println("  ***  ");

        printElFunctional1(list);//method reference
        System.out.println();
        System.out.println("  ***  ");

        printCiftElStructured(list);
        System.out.println();
        System.out.print("  ***  ");

        printCiftElFunc(list);
        System.out.println();
        System.out.print("  ***  ");

        printCiftElFunc2(list);
        System.out.println();
        System.out.print("  ***  ");

        printCift60kucuk(list);
        System.out.println();
        System.out.print("  ***  ");

        tek20Buyuk(list);
        System.out.println();
        System.out.print("  ***  ");

        ciftKare(list);
        System.out.println();
        System.out.print("  ***  ");

        tekKupBirFazla(list);
        System.out.println();
        System.out.print("  ***  ");

        ciftKareKok(list);
        System.out.println();
        System.out.print("  ***  ");

        listBuyukEl(list);
        System.out.println();
        System.out.print("  ***  ");


    }
    //structured Programming ile list elemanlarinin tamamini aralarina bosluk birakarak yazdiriniz

    public static void printElStructured(List<Integer> list) {
        for (Integer w : list) {
            System.out.print(w + " ");
        }
    }

    //Functional Programming ile list elemanlerinin  tamamini aralarina bosluk birakarak yazdiriniz

    public static void printElFunctional(List<Integer> list) {

        list.stream().forEach(t->System.out.print(t + " "));;//methodlari cagirdik
        //stream(); selale methodu
    }

    public static void printEl(int t) {//refere edilecek method create edildi
        System.out.println(t + " ");
    }

    public static void printElFunctional1(List<Integer> list) {
        list.stream().forEach(Lambda01 :: printEl);
    }
    //structured Programming ile list elemanlerinin  cift olanalrini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void printCiftElStructured(List<Integer> list) {

        for (Integer w : list) {
            if (w%2==0) {//aldigin w'le 2'e bolunuyormu
                System.out.println(w + " ");
            }
        }
    }

    public static void printCiftElFunc(List<Integer> list) {
        list.stream().filter(t->t%2==0).forEach(Lambda01 :: printEl);
        //filter();
    }
    public static boolean ciftBul(int i) {//refere edilecek tohum  method creat edildi

        return i%2==0;//dogru ise yazacak
    }
    public static void printCiftElFunc2(List<Integer> list) {
        list.stream().filter(Lambda01::ciftBul).forEach(Lambda01 :: printEl);//filter sart gorevi gorur if gibi ama tam degil
    }
    //Functional Programming ile list elemanlarinin  cift olanalrinin
    //60 dan kucuk olanlarını ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void printCift60kucuk(List<Integer> list) {
        list.stream().filter(t-> t%2==0 & t<60).forEach(Lambda01::printEl);
    }
    //Functional Programming ile list elemanlarinin  tek olanalrini veya 20 dan buyuk
    // olanlarını ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void tek20Buyuk(List<Integer> list) {
        list.stream().filter(t-> t%2==1 || t>20).forEach(Lambda01::printEl);
    }
    //Functional Programming ile list elemanlarinin  cift olanlarinin
    // karelerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKare(List<Integer> list) {
        list.stream().filter(Lambda01::ciftBul).map(t->t*t).forEach(Lambda01::printEl);
    }
    //Functional Programming ile list elemanlarinin  tek olanlarinin
    // kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void tekKupBirFazla(List<Integer> list) {
        list.stream().filter(t-> t%2==1).map(t->t*t*t+1).forEach(Lambda01::printEl);
    }

    //Functional Programming ile list elemanlarinin  cift olanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKareKok(List<Integer> list) {
        list.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).
                forEach(t->System.out.println(t + " "));
    }
    //list'in en buyuk elemanini yazdiriniz
    public static void listBuyukEl(List<Integer> list) {
        Optional<Integer> maxEl = list.stream().reduce(Math::max);//maxEl assign ettik
        System.out.println(maxEl);
        //Optional class= kolay kod yazilim

    }
}

