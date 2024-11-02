import java.util.HashMap;

public class MonthlyReport {
    HashMap<String, Transaction> transactions = new HashMap<>();

    void printTransactions() {
        for (String name : transactions.keySet()) {
            Transaction transaction = transactions.get(name);
            System.out.println(name + ": " + transaction.sumOfOne);
        }
    }

    int sumOfMonth(boolean isExpense) {
        int sum = 0;
        for (String name : transactions.keySet()) {
            Transaction transaction = transactions.get(name);
            if (transaction.isExpense == isExpense) {
                sum += transaction.sumOfOne * transaction.quantity;
            }
        }
        return sum;
    }
}
