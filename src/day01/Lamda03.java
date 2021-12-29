package day01;

import java.util.*;
import java.util.stream.Stream;

public class Lamda03 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>(Arrays.asList("Mehmet","Emre","Nilgun","Mehmet","Yildiz","Kader","Emine","Islam","Islam","Emret"));

        buyHarfTeksiz(list);
        System.out.println();
        System.out.println("  ***  ");

        karakTeksizTersSira(list);
        System.out.println();
        System.out.println("  ***  ");

        karakSayKucBuy(list);
        System.out.println();
        System.out.println("  ***  ");

        sonHarfTers(list);
        System.out.println();
        System.out.println("  ***  ");

        uzunKareTeksizBuyKuc(list);
        System.out.println();
        System.out.println("  ***  ");

        karSay7az(list);
        System.out.println();
        System.out.println("  ***  ");

        wBaslamaKont(list);
        System.out.println();
        System.out.println("  ***  ");

        karakBuy(list);
        System.out.println();
        System.out.println("  ***  ");

        ilkElHaricSonHarfSira(list);
        System.out.println();
        System.out.println("  ***  ");
    }
   //List elemanlarini Alfabetik buyuk harf ve tekrarsiz yazdirin
    public static void buyHarfTeksiz( List<String> list){
        list.stream().map(t-> t.toUpperCase()).sorted().distinct().forEach(t-> System.out.print(t + " "));
    }
    //list elelmanlarinin character sayisini ters sirali olarak tekrarsiz yazdiriniz
    public static void karakTeksizTersSira(List<String> list){
        list.stream().map(t-> t.length()).sorted(Comparator.reverseOrder()).distinct().forEach(Lambda01::printEl);//string data type'i int'e cevirdik map'de
    }
 //List elemanlarini character sayisina gore kckten byk egore yazdiriniz.
    public static void karakSayKucBuy(List<String> list){
        list.stream().sorted(Comparator.comparing(t-> t.length())).forEach(t-> System.out.print(t + " "));
    }
    //List elemanlarinin son harfine gore ters sirali yazdirin
    public static void sonHarfTers(List<String> list){
        list.stream().sorted(Comparator.comparing(t-> t.toString().charAt(t.toString().length()-1)).reversed()).forEach(t-> System.out.print(t + " "));
    }
    //Cift sayili elemanlarin uzunluklarinin karelerini hesaplayan, tekrarsiz buyukten kucuge yazdiriniz
    public static void uzunKareTeksizBuyKuc (List<String> list){
        list.
                stream().
                map(t-> t.length()*t.length()).//string elemani karakter sayisina cevirildi
                filter(Lambda01::ciftBul).
                distinct().//tekrarsiz
                sorted(Comparator.reverseOrder()).//ters sira b->k
                forEach(t-> System.out.print(t + " "));
    }
    //List elemanlarinin karakter sayisini 7 ve 7'den az olma durumunu kontrol ediniz.
    public static void karSay7az(List<String> list){
      boolean kontrol= list.stream().allMatch(t-> t.length()<=7);
     /* if (kontrol){
          System.out.println("list elemanlari 7 harf'den buyuk degil.");
      }else{
          System.out.println("list elemanlari 7 harf'den buyuk.");
      } if hali */
        System.out.println(kontrol);
    }
    //List elemanlarinin "W" ile baslamasini kontrol edin
    public static void wBaslamaKont(List<String> list){
        System.out.println(list.stream().noneMatch(t-> t.startsWith("W")) ? "W ile basliyor" : "W ile baslamiyor");
    }
    //karaker sayisinin en buyuk elemanini yazdirin
    public static void karakBuy(List<String> list){
        Stream <String> sonIsim = list.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).//length karakter uzunluguna gore siraladi
                        reversed()).//ters siralama
                // findFirst());//ilk elemani aldi
                        limit(1);
        System.out.println(Arrays.toString(sonIsim.toArray()));// array yazdirdik, sonra akisdan cikan elemani arraye cevirdik
    }
    //list elemanlarinin son harfine gore siralayip, ilk eleman haric kalan elemanlari yazdirin
    public static void ilkElHaricSonHarfSira(List<String> list){
        list.stream().sorted(Comparator.comparing(t-> t.toString().charAt(t.length()-1))).skip(1).forEach(System.out::println);//skip 1
    }
}
