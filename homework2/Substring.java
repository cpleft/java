/** @author 杨谊 16130120200 429426523@qq.com
 */

public class Substring
{
  public static void main(String[] args)
  {
    String s = args[0];
    int index = Integer.parseInt(args[1]);
    int len = Integer.parseInt(args[2]);
    System.out.println(s.substring(index, index+len));
  }
}
