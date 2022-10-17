public class SoldState implements State{
    private final VendingMachine vendingMachine;

    public SoldState(VendingMachine vendingMachine) {
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
        int count = vendingMachine.getProduct().getCount();
        vendingMachine.getProduct().setCount( count-1 );
        vendingMachine.reduceCoins( vendingMachine.getProduct().getPrice());
        System.out.println("Buying....");
        System.out.flush();
        if(vendingMachine.getCoins()>0)
            vendingMachine.setState(vendingMachine.getInsertCoinState());
        else
            vendingMachine.setState(vendingMachine.getReadyState());
    }
}
