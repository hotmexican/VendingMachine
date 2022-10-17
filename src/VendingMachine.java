import java.util.Map;

public class VendingMachine {

    private State state, insertCoinState, readyState, soldOutState, soldState;
    private Product product;
    private int coins;
    private String productCode;
    private final Map<String, Product> productMap;

    public VendingMachine(Map<String, Product> productMap) {
        state = getReadyState();
        this.productMap = productMap;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getInsertCoinState() {
        if(insertCoinState==null)
            insertCoinState = new InsertedCoinsState(this);
        return insertCoinState;
    }

    public void setInsertCoinState(State insertCoinState) {
        this.insertCoinState = insertCoinState;
    }

    public State getReadyState() {
        if(readyState == null)
            readyState = new ReadyState(this);
        return readyState;
    }

    public void setReadyState(State readyState) {
        this.readyState = readyState;
    }

    public State getSoldOutState() {
        if(soldOutState==null)
            soldOutState = new SoldOutState(this);
        return soldOutState;
    }

    public void setSoldOutState(State soldOutState) {
        this.soldOutState = soldOutState;
    }

    public State getSoldState() {
        if(soldState==null)
            soldState = new SoldState(this);
        return soldState;
    }

    public void setSoldState(State soldState) {
        this.soldState = soldState;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCoins() {
        return coins;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public Product getProductByProductCode(String productCode) {
        product = productMap.get(productCode);
        return product;
    }

    public int getPrice(Product product) {
        return product.getPrice();
    }

    public void buyProduct() {
        getState().buyProduct();
    }

    public void resetCoins() {
        coins = 0;
    }

    public void reduceCoins(int price) {
        coins-=price;
    }
    public void addCoins(int price) {
        coins += price;
    }

    public void inputProductCode(String productCode){
        getState().inputProductCode(productCode);
    }

    public void insertCoins(int count){
        getState().insertCoin(count);
    }
    public void returnCoins() {
        getState().returnCoins();
    }
}
