import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    Map<String, Product> productMap = new HashMap<>();

    productMap.put("A1", new Product("Product1", 10, 4));
    productMap.put("A2", new Product("Product2", 9, 1));
    productMap.put("A3", new Product("Product3", 12, 2));
    productMap.put("A4", new Product("Product4", 7, 1));

    VendingMachine vendingMachine = new VendingMachine(productMap);
    vendingMachine.inputProductCode("A2");
    vendingMachine.insertCoins(6);
    vendingMachine.insertCoins(7);
    vendingMachine.inputProductCode("A2");
    vendingMachine.buyProduct();
    vendingMachine.inputProductCode("A2");
    vendingMachine.insertCoins(7);
    vendingMachine.inputProductCode("A2");
    vendingMachine.insertCoins(7);
    vendingMachine.inputProductCode("A4");
    vendingMachine.returnCoins();
    }
}