package day01;

import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println(topla(10));
        System.out.println("   ***   ");

        System.out.println(topla1(10));
        System.out.println("   ***   ");

        System.out.println(topla2(10));
        System.out.println("   ***   ");

        System.out.println(toplaCift(10));
        System.out.println("   ***   ");
    }

    //Tsak 01==Structured Programming ve Functioanl Programming ile 1'den x'e kadar tamsayilari toplayan bir program yazin
    //Structured Programming
    public static int topla(int x) {
        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }

    //Functional Programming
    public static int topla1(int x) {
        return IntStream.range(1, x + 1).sum();
    }

    public static int topla2(int x) {
        return IntStream.rangeClosed(1, x).sum();
    }

    //Task 02== 1'den x'e kadar cift tamsayilari toplayan bir program yazin
    public static int toplaCift(int x) {
        return IntStream.rangeClosed(1, x).//1,2,3,4//
                filter(t-> t%2==0).//2,4,6,8
        sum();
    }}

