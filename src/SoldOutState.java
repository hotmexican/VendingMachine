public class SoldOutState implements State{
    private final VendingMachine vendingMachine;

    public SoldOutState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int count) {
        System.out.println("Operation fell");
    }

    @Override
    public void inputProductCode(String productCode) {
        System.out.println("Operation fell");
    }

    @Override
    public void returnCoins() {
        System.out.println("Operation fell");
    }

    @Override
    public void buyProduct() {
        System.out.println("Product sold out");
        vendingMachine.setState(vendingMachine.getInsertCoinState());
    }
}
