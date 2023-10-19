package exceptions.homework;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите данные в следующем формате:" +
                        "\"%s\" \"%s\" \"%s\" \"%s\" \"%s\" \"%s\"\n",
                "Имя", "Фамилия", "Отчество", "Дата рождения (в формате dd.mm.yyyy)",
                "номер телефона", "пол (f или m)");
        String data = scanner.nextLine();
        User user = User.createUser(data);


    }


}
