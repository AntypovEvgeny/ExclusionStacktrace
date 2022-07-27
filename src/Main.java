import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] products = {"Молоко", "Яблоки", "Сыр", "картофель", "Хлеб"};
        int[] prices = {80, 50, 200, 35, 45};
        int[] numb = new int[5];
        int sum = 0;
        System.out.println("Список товаров:");

        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб");

        }

        while (true) {
            try {
                System.out.println("Выберите товар и количество.");
                String input = scanner.nextLine();
                if (input.equals("end")) {
                    break;
                }

                String[] parts = input.split(" ");
                if (parts.length != 2) {
                    System.out.println("Нужно ввести два числа через пробел!");
                    continue;
                }

                int numProduct = Integer.parseInt(parts[0]) - 1;
                int amount = Integer.parseInt(parts[1]);

                if (numProduct > 4 || numProduct < 0) {
                    System.out.println("Первое число должно быть от 0 до 5!");
                } else if (amount == 0) {
                    numb[numProduct] = 0;
                } else {
                    numb[numProduct] += amount;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Нужно вводить только числа!");
                continue;
            }

        }
        System.out.println("В вашей корзине:");
        for (int i = 0; i < products.length; i++) {
            if (numb[i] > 0) {
                System.out.println(products[i] + " " + numb[i] + " шт, " + prices[i] + " руб/шт. Итого: " + (numb[i] * prices[i]) + " руб");
                sum += (numb[i] * prices[i]);
            }
        }

        System.out.println("Сумма всей покупки: " + sum + " руб");
    }

}
