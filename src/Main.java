import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] products = {"Молоко", "Яблоки", "Сыр", "картофель", "Хлеб"};
        int[] prices = {80, 50, 200, 35, 45};
        int[] numb = new int[8];
        int sum = 0;
        System.out.println("Список товаров:");

        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб");

        }
        String[] saleProducts = {"Лук", "Груши", "Морковь"};
        int[] salePrices = {20, 100, 30};
        int[] saleNumb = new int[3];
        int sumSale = 0;

        System.out.println("Акция! 3 шт по цене 2! Товары по акции: ");

        for (int i = 0; i < saleProducts.length; i++) {
            System.out.println((i +1 + products.length) + ". " + saleProducts[i] + " " + salePrices[i] + " руб");
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

                if (numProduct > (numb.length - 1) || numProduct < 0) {
                    System.out.println("Первое число должно быть от 0 до 8!");
                } else if (amount == 0) {
                    numb[numProduct] = 0;
                } else {
                    numb[numProduct] += amount;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Нужно вводить только числа!");
            }
        }

        for (int i = 0; i < numb.length; i++) {
            if (i > (products.length - 1))
                saleNumb[i - products.length] = numb[i];
        }

        System.out.println("В вашей корзине:");
        for (int i = 0; i < products.length; i++) {
            if (numb[i] > 0) {
                System.out.println(products[i] + " " + numb[i] + " шт, " + prices[i] + " руб/шт. Итого: " + (numb[i] * prices[i]) + " руб");
                sum += (numb[i] * prices[i]);
            }
        }

        System.out.println("Товары по акции: ");
        for (int i = 0; i < saleProducts.length; i++) {
            if (saleNumb[i] > 0) {
                int saleSum = (saleNumb[i] - (saleNumb[i] / 3)) * salePrices[i];
                System.out.println(saleProducts[i] + " " + saleNumb[i] + " шт, " + salePrices[i] + " руб/шт. Итого: " + saleSum + " руб");
                sumSale += saleSum;
            }
        }

        System.out.println("Сумма всей покупки: " + (sum + sumSale) + " руб");
    }
}