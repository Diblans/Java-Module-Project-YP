import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Calculator {
    private final List<Item> list = new ArrayList<>();
    public void enterListOfItems() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите название товара");
            String name = scanner.nextLine();
            if (name.equals("")) {
                System.out.println("Вы не ввели название товара, попробуйте снова");
                continue;
            }
            System.out.println("Введите цену товара");
            double cost;
            if (scanner.hasNextDouble()) {
                cost = scanner.nextDouble();
                scanner.nextLine();
                if (cost < 0) {
                    System.out.println("Цена не может быть отрицательной, попробуйте снова");
                    continue;
                }
            } else {
                System.out.println("Вы некорректно ввели цену, попробуйте снова");
                scanner.nextLine();
                continue;
            }
            list.add(new Item(name, cost));
            System.out.println("Товар добавлен");
            System.out.println("Для завершения ввода товаров напишите \"Завершить\". Если хотите " +
                    "продолжить, нажмите Enter");
            String endPhrase = scanner.nextLine();
            if (endPhrase.equalsIgnoreCase("завершить")) {
                break;
            }
        }
    }

    public double calculate(int people) {
        if (list.isEmpty()) {
            return 0;
        } else {
            double summa = 0;
            for (Item item : list) {
                summa += item.getCost();
            }
            return summa / people;
        }
    }

    public void printNamesItems() {
        if (list.isEmpty()) {
            System.out.println("Нет товаров");
        } else {
            for (Item item : list) {
                System.out.println(item.getName());
            }
        }
    }
}

