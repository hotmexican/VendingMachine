public class InsertedCoinsState implements State{
    private final VendingMachine vendingMachine;

    public InsertedCoinsState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int count) {
        vendingMachine.addCoins(count);
        System.out.println("Coins inserted: " + vendingMachine.getCoins());
    }

    @Override
    public void inputProductCode(String productCode) {
        Product product = vendingMachine.getProductByProductCode(productCode);
        int price = vendingMachine.getPrice(product);
        int coins = vendingMachine.getCoins();
        if(coins>=price){
            int count = product.getCount();
            if(count==0)
                vendingMachine.setState(vendingMachine.getSoldOutState());
            else
                vendingMachine.setState(vendingMachine.getSoldState());
            vendingMachine.buyProduct();
        }
        else {
            int diff = price - coins;
            System.out.println("Need " + diff);
        }

    }

    @Override
    public void returnCoins() {
        vendingMachine.resetCoins();
        System.out.println("Return coins");
        vendingMachine.setState( vendingMachine.getReadyState());
    }

    @Override
    public void buyProduct() {
        System.out.println("Operation fell");
    }
}
