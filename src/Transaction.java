public class Transaction {
    String name;
    boolean isExpense;
    int quantity;
    int sumOfOne;

    public Transaction (String name, boolean isExpense, int quantity, int sumOfOne){
        this.name = name;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }

}
