/** Implementation of class CreditAccount
 * @author 杨谊 16130120200 429426523@qq.com 
 * @version JDK10 
 * @since JDK5
 */

public class CreditAccount extends BankAccount 
{
  protected double credit_line;    // 贷款额度

  public CreditAccount(String name, double balance, double credit_line) {
    super(name, balance);
    this.credit_line = credit_line;
  }

  @Override 
  public boolean withdrawals(double money) {
    if (balance + credit_line < money) {
      transaction_list.add("Transaction - withdrawals: error3(money > credit_line + balance)");
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

}//end class
