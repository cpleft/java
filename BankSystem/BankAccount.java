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

  public BankAccount(String s, double b) {
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
  public boolean deposits(double money) {
    if (money < 0) { 
      transaction_list.add("Transaction - deposits: error1(money < 0)");
      transaction_list.remove(0);
      return false;
    }
    else {
      balance += money;
      transaction_list.add("Transaction - deposits: " + money);
      transaction_list.remove(0);
      return true;
    }
  }

  /** @param money money must not be lesser than 0  */
  public boolean withdrawals(double money) {
    if (money < 0) {
      transaction_list.add("Transaction - withdrawals: error1(money < 0)");
      transaction_list.remove(0);
      return false;
    }
    if (balance < money){
      transaction_list.add("Transaction - withdrawals: error2(money > balance)");
      transaction_list.remove(0);
      return false;
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


  /** testment */
  public static void main(String[] argus)
  {
    // first object of BankAccount
    BankAccount person1 = new BankAccount("person1", 5000);
    System.out.println(person1.returnName());
    System.out.println(person1.returnBalance());
    System.out.println(person1.returnAmount());
    person1.printTransaction();

    person1.deposits(1000);
    System.out.println(person1.returnName());
    System.out.println(person1.returnBalance());
    System.out.println(person1.returnAmount());
    person1.printTransaction();

    person1.withdrawals(2000);
    System.out.println(person1.returnName());
    System.out.println(person1.returnBalance());
    System.out.println(person1.returnAmount());
    person1.printTransaction();

    System.out.println();
    // second object of BankAccount
    BankAccount person2 = new BankAccount("person2", 1000);
    System.out.println(person2.returnName());
    System.out.println(person2.returnBalance());
    System.out.println(person2.returnAmount());
    person1.printTransaction();

    // first object of CreditAccount
                                          // name, balance, credit_line
    CreditAccount person3 = new CreditAccount("person3", 1000, 5000); 
    System.out.println(person3.returnName());
    System.out.println(person3.returnBalance());
    System.out.println(person3.returnAmount());
    person3.printTransaction();

    person3.deposits(1000);
    System.out.println(person3.returnName());
    System.out.println(person3.returnBalance());
    System.out.println(person3.returnAmount());
    person3.printTransaction();

    person3.withdrawals(4000);
    System.out.println(person3.returnName());
    System.out.println(person3.returnBalance());
    System.out.println(person3.returnAmount());
    person3.printTransaction();

  }

}
