package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {
    static String[] tri = new String[]{"", "Сто", "Двести", "Триста", "Четыреста", "Пятьсот", "Шестьсот", "Семьсот", "Восемьсот" ,"Девятьсот"};
    static String[] dva = new String[]{"", "Десять", "Двадцать", "Тридцать", "Сорок", "Пятьдесят", "Шестьдесят", "Семьдесят", "Восемьдесят", "Девяносто"};
    static String[] odin = new String[]{"", "Один", "Два", "Три", "Четыре", "Пять", "Шесть", "Семь", "Восемь", "Девять"};
    static String[] isk = new String[]{"", "Одиннадцать", "Двенадцать", "Тринадцать", "Четырнадцать", "Пятьнадцать", "Шестьнадцать", "Семьнадцать", "Восемьнадцать", "Девятнадцать"};

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите 1 если хотите перевести int в string и 2, если наоборот.");
        String m = scan.next();
        System.out.println("Введите число.");
        if (m.equals('1')){int num = scan.nextInt();toStr(num);
        }else{String number = br.readLine();toIn(number);}

    }

    public static void toStr(int num){
        int[] myNum = new int[3];
        myNum[0] = num / 100;
        myNum[1] = num / 10 % 10;
        myNum[2] = num % 10;
        if (num % 100 < 20 && num % 100 > 10) {
            System.out.print(isk[num % 10] );
        } else {
            System.out.print(tri[myNum[0]] + " " + dva[myNum[1]] + " " + odin[myNum[2]]);
        }

    }
    public static void toIn(String number){
        int[] index = new int[]{number.indexOf(' '), number.lastIndexOf(' ')};
        if (number.length() - number.replaceAll(" ", "").length() <= 2 ) {
            if (index[0] != index[1]) {   // Если кол-во пробелов == 2, значит присутствуют все разряды
                String tra = number.substring(0, index[0]);
                String dvi = number.substring(1 + index[0], index[1]);
                String last = number.substring(index[1] + 1, number.length());
                for (int i = 0; i < 10; i++) {
                    if (tra.equals(tri[i])) {
                        System.out.print(i);
                    }
                }
                for (int i = 0; i < 10; i++) {
                    if (dvi.equals(dva[i])) {
                        System.out.print(i);
                    }
                }
                for (int i = 0; i < 10; i++) {
                    if (last.equals(odin[i])) {
                        System.out.print(i);
                    }
                }
            }

            if (index[0] == index[1] && index[1] != -1) { // Если пробел один, значит одного разряда нет, либо
                String first = number.substring(0, index[0]);        // присутствуют слова исключения.
                String second = number.substring(1 + index[0]);
                int tmp = 0; //
                //Проверяю есть ли слова исключения.
                for (int i = 0; i < 10; i++) {
                    if (second.equals(isk[i])) {
                        tmp += 1;
                    }
                }
                if (tmp == 0) { // Если слов исключений нет:
                    for (int i = 0; i < 10; i++) {
                        if (first.equals(tri[i])) {
                            System.out.print(i * 10);
                        }
                        if (first.equals(dva[i])) {
                            System.out.print(i);
                        }
                    }
                    for (int i = 0; i < 10; i++) {
                        if (second.equals(dva[i])) {
                            System.out.print(i * 10);
                        }
                        if (second.equals(odin[i])) {
                            System.out.print(i);
                        }

                    }

                } else { // Если есть слова исключения.
                    for (int i = 0; i < 10; i++) {
                        if (first.equals(tri[i])) {
                            System.out.print(i);
                        }
                    }
                    for (int i = 0; i < 10; i++) {
                        if (second.equals(isk[i])) {
                            System.out.print(i + 10);
                        }
                    }
                }
            }


            if (index[0] == index[1] && index[0] == -1) { // Если пробелов нет.Один разряд, либо слово исключение.
                for (int i = 0; i < 10; i++) {
                    if (number.equals(tri[i])) {
                        System.out.print(i * 100);
                    }
                    if (number.equals(dva[i])) {
                        System.out.print(i * 10);
                    }
                    if (number.equals(odin[i])) {
                        System.out.print(i);
                    }
                    if (number.equals(isk[i])) {
                        System.out.print(i + 10);
                    }
                }
            }
        }else{System.out.println("Ошибка ввода числа. Попробуйте снова");}
    }

}
