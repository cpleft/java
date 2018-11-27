/** Design BankSystem class. You need to design more than one class. For example: 
 * You need to design a class BankAccount to model users’ bank accounts. Probably 
 * different bank accounts (CashAccount, CreditAccount, …). The account should 
 * keep a user’s name and balance, accurate to the nearest cent…
 * The user should be able to make deposits and withdrawals on his/her account, 
 * as well as changing the account’s name at any time. Also, the system needs 
 * to be able to find out how many BankAccounts have been created in total.
 * For each account, only the last 6 Transactions should be able to store in 
 * ascending order and be printed.  
 */
/** Patch: Add Exceptions 
 * Thu Oct 25 18:54:00 CST 2018
 */
import java.util.ArrayList;
/** Implementation of class BankAccount (base)
 * @author 杨谊 16130120200 429426523@qq.com 
 * @version JDK10 
 * @since JDK5
 */

public class BankAccount 
{
  protected String name;      // user name 
  protected double balance;   // accurate to the nearest cent

  protected ArrayList<String> transaction_list;   // should be directly used by its children

  public static int amount = 0;   // the amount of account
  private static void addAmount() { amount++; }  // invoked by constructor
  public int returnAmount() { return BankAccount.amount; }

  public BankAccount(String s, double b) throws IllegalArgumentException {
    if (b < 0) throw new IllegalArgumentException();
    name = s;
    balance = b;
    transaction_list = new ArrayList<>(6);    // store 6 pieces of transactions 
    addAmount();      
  }

  public double returnBalance() {
    return balance;
  }

  public String returnName() {
    return name;
  }

  public void alterName(String name) {
    this.name = name;
    transaction_list.add("Transaction - Alter name: " + name);
    transaction_list.remove(0);
  }

  /** @param money money must not be lesser than 0  */
  public boolean deposits(double money) throws IllegalArgumentException {
    if (money < 0) { 
      transaction_list.add("Transaction - deposits: error1(money < 0)");
      transaction_list.remove(0);
      throw new IllegalArgumentException();
    }
    else {
      balance += money;
      transaction_list.add("Transaction - deposits: " + money);
      transaction_list.remove(0);
      return true;
    }
  }

  /** @param money money must not be lesser than 0  */
  public boolean withdrawals(double money) throws IllegalArgumentException {
    if (money < 0) {
      transaction_list.add("Transaction - withdrawals: error1(money < 0)");
      transaction_list.remove(0);
      throw new IllegalArgumentException();
    }
    if (balance < money){
      transaction_list.add("Transaction - withdrawals: error2(money > balance)");
      transaction_list.remove(0);
      throw new IllegalArgumentException();
    }
    else {
      balance -= money;
      transaction_list.add("Transaction - withdrawals: " + money);
      transaction_list.remove(0);
      return true;
    }
  }

  public void printTransaction() {
    for (int i = transaction_list.size()-1; i >= 0; i--) {
      if (transaction_list.get(i) != null)    // isEmpty()
        System.out.println(transaction_list.get(i));
    }
  }
}

/* Exception: IllegalArgumentException */
class IllegalArgumentException extends Exception { }
