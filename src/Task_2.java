// Реализуйте очередь с помощью LinkedList со следующими методами:
//enqueue() - помещает элемент в конец очереди,
//dequeue() - возвращает первый элемент из очереди и удаляет его,
//first() - возвращает первый элемент из очереди, не удаляя.


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Task_2 {
    public static void task_2() throws IOException {
        String[] str = fileReader().replace("[", "").replace("]", "").split(",");
        Deque<String> qList = new LinkedList<>();

        for (String s: str) {
            qList.add(s);
        }
        System.out.println( " Начальный LinkedList список \n" + qList);

        getNum((LinkedList) qList);
    }

    private static void getNum(LinkedList qList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие введя цифру : \n 1. Поместить элемент в конец очереди \n 2. Показать первый элемент и удалить его" +
                "\n 3. Показать первый элемент, не удаляя\n 4. Для остановки программы ");
        String num = scanner.nextLine();

            if(num.equals("1")) {
                System.out.println("Введите строку и я добавлю ее в конец списка :");
                String in = scanner.nextLine();
                System.out.println("Начальный список\n" + qList);
                qList.addLast(in);
                System.out.println("Новый список \n" + qList);
                System.out.println();
                getNum((LinkedList) qList);
            } else if (num.equals("2")) {
                System.out.println("Начальный список\n" + qList);
                System.out.println("Первый элемент списка\n" + qList.pollFirst());
                System.out.println("Новый список\n" + qList);
                System.out.println();
                getNum((LinkedList) qList);
            } else if (num.equals("3")) {
                qList.getFirst();
                System.out.println("Начальный список\n" + qList);
                System.out.println("Первый элемент");
                System.out.println(qList.get(0));
//            System.out.println("Первый элемент списка\n" + qList.pollFirst());
                System.out.println("Почему-то .pollFirst тоже удаляет элемент списка, почему не знаю, сделал по старинке)) \nСписок не изменился\n" + qList);
                System.out.println();
                getNum((LinkedList) qList);
            } else if (num.equals("4")){
                System.out.println("Остановка программы");
                return;
            }
            else {
                System.out.println("Вы ввели не число или не число от 1 до 3, повторите ввод ");
                System.out.println();
                getNum((LinkedList) qList);
            }
        }

    private static String fileReader() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("rec.txt"));
        String str = br.readLine();
        return str;
    }
}
