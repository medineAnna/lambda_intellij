package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {
    public static void main(String[] args) {

        List<Integer> list=new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22, -60, 42, 15));

        ciftKareMax(list);
        System.out.println();
        System.out.println("  ***  ");

        toplamEl(list);
        System.out.println();
        System.out.println("  ***  ");

        ciftCarp(list);
        System.out.println();
        System.out.println("  ***  ");

        ciftCarp02(list);
        System.out.println();
        System.out.println("  ***  ");

        min1(list);
        System.out.println();
        System.out.println("  ***  ");

        min2(list);
        System.out.println();
        System.out.println("  ***  ");

        min3(list);
        System.out.println();
        System.out.println("  ***  ");

        min4(list);
        System.out.println();
        System.out.println("  ***  ");

    }
    //List'in cift olan elelmanlarin karelerini aliniz ve en buyugunu yazdiriniz
    public static void ciftKareMax(List<Integer>list){
        // Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t-> t*t).reduce(Integer::max);
        Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t-> t*t).reduce(Math::max);
        System.out.println(maxEl);
    }

    //List'teki tum elemanlarin toplamini yazdiriniz.
    //LAmbda Expression...
    public static void toplamEl(List<Integer>list) {
        Optional<Integer>  toplam = list.stream().reduce(Integer::sum);
        System.out.println(toplam);
    }
    //List'teki cift elemanlarin carpimini yazdiriniz.
    //Method Reference...
    public static void ciftCarp(List<Integer>list) {
        Optional<Integer> carp = list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);
        System.out.println(carp);
    }
    //List'teki cift elemanlarin carpimini yazdiriniz.
    //Lambda expression...
    public static void ciftCarp02(List<Integer>list) {
        Integer carp = list.stream().filter(Lambda01::ciftBul).reduce(1,(x,y)->(x*y));
        System.out.println(carp);
    }
    //list'deki elemanlardan en kucugunu 4 farkli yontem ile yazdiriniz
    //1.yontem Method ile == Integer class'dan
    public static void min1(List<Integer>list) {
        Optional<Integer> min = list.stream().reduce(Integer::min);
        System.out.println(min);
    }
    //2. yontem
    public static void min2(List<Integer>list) {
        Optional<Integer> min = list.stream().reduce(Integer::min);
        System.out.println(min);
    }
    //2.yontem method reference ile==Haluk class
    public static int minBul(int x, int y) {
        return x<y ? x :y;//ternary
    }
    public static void min3(List<Integer>list) {
        Optional<Integer> min = list.stream().reduce(Lambda02::minBul);
        System.out.println(min);
    }
    //3.yontem Method== Lambda Expression
    public static void min4(List<Integer>list) {
        Integer min = list.stream().reduce(Integer.MAX_VALUE, (x,y)-> x<y ? x:y);
        System.out.println(min);
    }
}
