// К калькулятору из предыдущего дз добавить логирование.
//        1 + 3 = 4
//        4 + 3 = 7

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Task_3 {
    public static void task_3() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        getIn2((ArrayList) arr);
//        charIn((ArrayList) arr);
    }

    private static void getIn2 (ArrayList arr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число :");
        String num = scanner.nextLine();
        try {
            Double.parseDouble(num);
            arr.add(num);
            System.out.println(arr);
            charIn((ArrayList) arr);
        } catch (NumberFormatException e) {
            System.out.println( "Это не число");
            getIn2((ArrayList) arr);
        }
    }

    private static void getIn (ArrayList arr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число :");
        String num = scanner.nextLine();
        try {
            Double.parseDouble(num);
            arr.add(num);
//            System.out.println(arr);
            calculation((ArrayList) arr);
        } catch (NumberFormatException e) {
            System.out.println( "Это не число");
            getIn((ArrayList) arr);
        }
    }

    private static String charIn (ArrayList arr) {
//        System.out.println(arr);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите оператор ( *,/,+,-,=) или введите back для возврата на операцию назад или stop для остановки программы : ");
        String op = scanner.nextLine();
        if  (op.equals("back")) {
            Back((ArrayList) arr);
        } else if (op.equals("stop")) {
            scanner.close();
        } else if (op.equals("=")){
//            arr.add("=");
//            System.out.println(arr);
            equally((ArrayList) arr);
        } else if (!op.equals("+") && !op.equals("-") && !op.equals("/") && !op.equals("*")) {
            System.out.println("Это не оператор ");
            charIn((ArrayList) arr);
        } else {
            arr.add(op);
            System.out.println(arr);
            getIn((ArrayList) arr);
        }
        return op;
    }

    private static void Back (ArrayList arr) {
        int size = arr.size();
        if (size > 4) {
            size = arr.size();
            arr.subList(size - 4, size).clear();
            System.out.println(arr);
            charIn((ArrayList) arr);
        } else if (arr.size() > 1) {
            arr.subList(1, arr.size()).clear();
        } else System.out.println("Начинаем заново");
        arr.clear();
        System.out.println(arr);
        getIn2((ArrayList) arr);
    }

    private static Double calculation(ArrayList arr) {
        arr.add("=");
        int result;
        int a = Integer.parseInt((String) arr.get(arr.size() - 4));
//        System.out.println(a);
        int b = Integer.parseInt((String) arr.get(arr.size()- 2));
//        System.out.println(b);
//        System.out.println(arr.get(arr.size() - 3));
        if (arr.get(arr.size() - 3).equals("+")) {
            result = a + b;
            arr.add(String.valueOf(result));
            System.out.println(arr);
            charIn((ArrayList) arr);
        } else if (arr.get(arr.size() - 3).equals("-")) {
            result = a - b;
            arr.add(String.valueOf(result));
            System.out.println(arr);
            charIn((ArrayList) arr);
        } else if (arr.get(arr.size() - 3).equals("*")) {
            result = a * b;
            arr.add(String.valueOf(result));
            System.out.println(arr);
            charIn((ArrayList) arr);
        } else if (arr.get(arr.size() - 3).equals("/")) {
            result = a / b;
            arr.add(String.valueOf(result));
            System.out.println(arr);
            charIn((ArrayList) arr);
        } else {
            System.out.println("Неизвестная операция");
            charIn((ArrayList) arr);
        }
        return null;
    }

    private static void equally(ArrayList arr) {
        System.out.println(arr);
        charIn((ArrayList) arr);
    }
}

//System.out.printf("%.3f", result) //  убрать 3 знака в double