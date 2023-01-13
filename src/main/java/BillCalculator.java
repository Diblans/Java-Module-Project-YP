import java.util.Scanner;
public class BillCalculator {
    public void startBillCalculator() {
        int people = enterNumberOfPeople();
        Calculator calculator = new Calculator();
        calculator.enterListOfItems();
        System.out.println("Добавленные товары:");
        calculator.printNamesItems();
        double amountPerPerson = calculator.calculate(people);
        printAmountPerPerson(amountPerPerson);
    }

    private int enterNumberOfPeople() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите количество людей");
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                if (n > 1) {
                    return n;
                }
            }
            scanner.nextLine();
            System.out.println("Вы ввели некорректное количество людей");
        }
    }

    private void printAmountPerPerson(double amountPerPerson) {
        String ruble;
        int intAmountPerPerson = (int) amountPerPerson;
        if (intAmountPerPerson % 100 >= 10 && intAmountPerPerson % 100 <= 20) {
            ruble = "рублей";
        } else {
            switch (intAmountPerPerson % 10) {
                case 1:
                    ruble = "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    ruble = "рубля";
                    break;
                default:
                    ruble = "рублей";
            }
        }
        System.out.printf("С каждого человека %.2f %s", amountPerPerson, ruble);
    }

}
