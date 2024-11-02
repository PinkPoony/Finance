import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    FileReader fileReader = new FileReader();
    ArrayList<MonthlyReport> monthlyReports = new ArrayList<>(3);
    YearlyReport yearReport = new YearlyReport();
    boolean isMonthFlag = false;
    boolean isYearFlag = false;

    public Manager() {
        for (int i = 0; i < 3; i++) {
            MonthlyReport monthlyReport = new MonthlyReport();
            monthlyReports.add(monthlyReport);
        }
    }

    void loadMonthlyReports() {
        loadMonthlyReport(0, "m.202101.csv");
        loadMonthlyReport(1, "m.202102.csv");
        loadMonthlyReport(2, "m.202103.csv");
    }

    void loadMonthlyReport(int numOfMonth, String nameFile) {
        ArrayList<String> lines = fileReader.readFileContents(nameFile);
        MonthlyReport month = monthlyReports.get(numOfMonth);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] fields = line.split(",");
            String name = fields[0];
            boolean isExpense = Boolean.parseBoolean(fields[1]);
            int quantity = Integer.parseInt(fields[2]);
            int sumOfOne = Integer.parseInt(fields[3]);
            Transaction transaction = new Transaction(name, isExpense, quantity, sumOfOne);
            month.transactions.put(name, transaction);
            isMonthFlag = true;
        }
    }

    void printMonthlyReport() {
        for (int i = 0; i < monthlyReports.size(); i++) {
            MonthlyReport report = monthlyReports.get(i);
            System.out.println(getMonthByNumber(i + 1));
            report.printTransactions();
        }
    }

    void loadYearlyReport() {
        ArrayList<String> lines = fileReader.readFileContents("y.2021.csv");
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] fields = line.split(",");
            int month = Integer.parseInt(fields[0]);
            int amount = Integer.parseInt(fields[1]);
            boolean isExpense = Boolean.parseBoolean(fields[2]);
            YearTransaction yearTransaction = new YearTransaction(month, amount, isExpense);
            if(yearReport.yearTransactions.containsKey(month)) {
                HashMap<Boolean, YearTransaction> monthTransactions = yearReport.yearTransactions.get(month);
                monthTransactions.put(isExpense, yearTransaction);
            } else {
                HashMap<Boolean, YearTransaction> monthTransactions = new HashMap<>();
                monthTransactions.put(isExpense, yearTransaction);
                yearReport.yearTransactions.put(month, monthTransactions);
                isYearFlag = true;
            }
        }
    }

    void printYearlyReport(){
        yearReport.printYearTransaction();
    }

    void compareOfReports(){
        if(isMonthFlag && isYearFlag){
            boolean isEqual = true;
            for(int i = 0; i < monthlyReports.size(); i++){
                MonthlyReport monthlyReport = monthlyReports.get(i);
                int sumExpensesOfMonth = monthlyReport.sumOfMonth(true);
                int sumIncomesOfMonth = monthlyReport.sumOfMonth(false);
                int sumExpensesOfYear = yearReport.sumOfYear(i+1, true);
                int sumIncomesOfYear = yearReport.sumOfYear(i+1, false);
                if (sumIncomesOfMonth != sumIncomesOfYear || sumExpensesOfMonth != sumExpensesOfYear){
                    System.out.println("Несовпадение в месяце: " + (i+1));
                    isEqual = false;
                }
            }
            if (isEqual){
                System.out.println("Отчёты полностью верны!");
            } else {
                System.out.println("Отчёты не совпали(");
            }
        } else {
            System.out.println("Сначала нужно загрузить файлы!");
        }
    }


    String getMonthByNumber(int num) {
        if (num == 1) {
            return "ЯНВАРЬ";
        } else if (num == 2) {
            return "ФЕВРАЛЬ";
        } else if (num == 3) {
            return "МАРТ";
        }
        return "Ошибка";
    }
}
