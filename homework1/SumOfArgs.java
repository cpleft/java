/** class SumOfArgs
 * @author 杨谊 16130120200 429426523@qq.com
 * Thu Oct 25 19:53:26 CST 2018
 */

public class SumOfArgs
{
  public static void main(String[] args) 
  {
    int sum = 0;
    for (int i = 0; i < args.length; i++) {
      int x = 0;
      try {
        x = Integer.parseInt(args[i]);
      } catch (Exception e) {
        x = 0;
      }
      sum += x;
    }
    System.out.println(sum);
  }
}
