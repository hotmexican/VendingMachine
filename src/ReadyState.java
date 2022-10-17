public class ReadyState implements State{
    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int count) {
        vendingMachine.addCoins(count);
        System.out.println("Coins inserted: " + vendingMachine.getCoins());
        vendingMachine.setState(vendingMachine.getInsertCoinState());
    }

    @Override
    public void inputProductCode(String productCode) {
        Product product = vendingMachine.getProductByProductCode(productCode);
        if(product!=null){
            System.out.println(product.getName() + " : " + vendingMachine.getPrice(product));
        }
        else
            System.out.println("could not retrieve product name and price!");
    }

    @Override
    public void returnCoins() {
        System.out.println("Insert the coins first");
    }

    @Override
    public void buyProduct() {
        System.out.println("First the coins, and then the goodies)");
    }
}
