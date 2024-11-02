public class YearTransaction {
    int month;
    int amount;
    boolean isExpense;

    public YearTransaction(int month, int amount, boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }

    void printYearTransaction(){
        System.out.println("Месяц: " + month);
        System.out.println("Сумма: " + amount);
        System.out.println("Трата ли: " + isExpense);
    }
}
