// Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void), который вернет “перевернутый” список.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Task_1 {
    public static void task_1() throws IOException {
        String[] str = fileReader().replace("[", "").replace("]", "").split(",");
        LinkedList<String> lStr = new LinkedList<>();

        for (String s: str) {
            lStr.add(s);
        }
        System.out.println( " Начальный LinkedList список \n" + lStr);

        LinkedList<String> res = arrayList(lStr);
        System.out.println("Перевернутый список \n" + res);

    }

    private static LinkedList<String> arrayList(LinkedList lStr) {
        LinkedList<String> res = new LinkedList<>();
        while (!lStr.isEmpty()) {
            res.add((String) lStr.pollLast());
        }
        return res;
    }



    private static String fileReader() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("rec.txt"));
        String str = br.readLine();
        return str;
    }
}
