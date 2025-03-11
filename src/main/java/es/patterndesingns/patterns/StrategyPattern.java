package es.patterndesingns.patterns;

import es.patterndesingns.behavioralpatterns.strategy.order.Order;
import es.patterndesingns.behavioralpatterns.strategy.strategies.PayByCreditCard;
import es.patterndesingns.behavioralpatterns.strategy.strategies.PayByPayPal;
import es.patterndesingns.behavioralpatterns.strategy.strategies.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class StrategyPattern {

    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }

    private static void chooseProduct() throws IOException {
        int cost;
        String continueChoice;
        do {
            System.out.print("""
                             Please, select a product:
                             1 - Mother board
                             2 - CPU
                             3 - HDD
                             4 - Memory
                            """);
            int choice = Integer.parseInt(reader.readLine());
            cost = priceOnProducts.get(choice);
            System.out.print("Count: ");
            int count = Integer.parseInt(reader.readLine());
            order.setTotalCost(cost * count);
            System.out.print("Do you wish to continue selecting products? Y/N: ");
            continueChoice = reader.readLine();
        } while (continueChoice.equalsIgnoreCase("Y"));
    }

    private static void chooseStrategy() throws IOException {
        if (strategy == null) {
            System.out.println("""
                            Please, select a payment method:
                            1 - PalPay
                            2 - Credit Card""");
            String paymentMethod = reader.readLine();

            // Client creates different strategies based on input from user,
            // application configuration, etc.
            if ("1".equals(paymentMethod)) {
                strategy = new PayByPayPal();
            } else {
                strategy = new PayByCreditCard();
            }
        }
    }

    private static void proceedPayment() throws IOException {
        System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
        String proceed = reader.readLine();
        if (proceed.equalsIgnoreCase("P")) {
            // Finally, strategy handles the payment.
            if (strategy.pay(order.getTotalCost())) {
                System.out.println("Payment has been successful.");
            } else {
                System.out.println("FAIL! Please, check your data.");
            }
            order.setClosed();

        }
    }
    public static void execute(boolean execute) throws IOException {
        if(execute) {
            while (!order.isClosed()) {
                chooseProduct();
                chooseStrategy();
                // Order object delegates gathering payment data to strategy object,
                // since only strategies know what data they need to process a
                // payment.
                order.processOrder(strategy);
                proceedPayment();
            }
        }else {
            System.out.println("Strategy pattern not executed");
        }
    }
}
