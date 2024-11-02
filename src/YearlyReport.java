import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    HashMap<Integer, HashMap<Boolean, YearTransaction>> yearTransactions = new HashMap<>();

    void printYearTransaction() {
        for (int month : yearTransactions.keySet()) {
            HashMap<Boolean, YearTransaction> monthTransactions = yearTransactions.get(month);
            YearTransaction expenseYearTransaction = monthTransactions.get(true);
            YearTransaction incomeYearTransaction = monthTransactions.get(false);
            expenseYearTransaction.printYearTransaction();
            incomeYearTransaction.printYearTransaction();
        }
    }

    int sumOfYear(int monthNum, boolean isExpense) {
        HashMap<Boolean, YearTransaction> monthTransactions = yearTransactions.get(monthNum);
        return monthTransactions.get(isExpense).amount;
    }
}
