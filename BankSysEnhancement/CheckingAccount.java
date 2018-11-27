/** Designed for checking the exceptions about class BankSystem 
 * @author 杨谊 16130120200 429426523@qq.com 
 * @version JDK10 
 * @since JDK5
 * Thu Oct 25 19:15:39 CST 2018
 */

public class CheckingAccount 
{
  public static void main(String[] args) 
  {
    try {
      BankAccount person = new BankAccount("person", -5000); // constructed with a negative balance
      person.deposits(-100);  // a negative amount is deposited
      person.withdrawals(10000); // account is overdrawn
    } catch (IllegalArgumentException e) {
      System.out.println("Caught it!");
    }
  }
}
