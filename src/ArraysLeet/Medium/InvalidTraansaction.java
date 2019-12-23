package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.List;

public class InvalidTraansaction {
    public static void main(String[] args) {

        String s [] = {"alice,20,800,mtv","alice,50,100,beijing"};
        System.out.println(invalidTransactions(s).toString());
    }

    public static List<String> invalidTransactions(String[] transactions) {

        int i;
        List<Transaction> al = new ArrayList<>();
        for(String str: transactions){
            String[] transactonDetails = str.split(",");
            Transaction transaction = new Transaction(transactonDetails[0],Integer.valueOf(transactonDetails[1]),
                    Integer.valueOf(transactonDetails[2]),transactonDetails[3]);
            al.add(transaction);
        }
        List<String> invalid = new ArrayList<>();
        for(Transaction transaction: al){
            String generate = transaction.name+ "," + transaction.time + "," + transaction.amount +","+ transaction.city;
            if(transaction.amount > 1000){
                    invalid.add(generate);
            } else {
                if(chekInAList(transaction,al)){
                    invalid.add(generate);
                }
            }
        }
        return invalid;
    }

    private static boolean chekInAList(Transaction transaction, List<Transaction> al) {
        for(Transaction transactionIt: al){
            if(transactionIt.name.equals(transaction.name) && Math.abs(transactionIt.time - transaction.time) <=60 &&
            !transactionIt.city.equals(transaction.city)){
                return true;
            }
        }
        return false;
    }

    public static class Transaction{
        String name;
        int time;

        public Transaction(String name, int time, int amount, String city) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }

        int amount;
        String city;

    }
}
