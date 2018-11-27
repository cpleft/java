import java.util.*;
public class Test {
  public static void main(String[] args) {
    Calendar calendar = Calendar.getInstance();
    // System.out.println(Calendar.FEBRUARY);
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH) + 1;
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int minute = calendar.get(Calendar.MINUTE);
    int second = calendar.get(Calendar.SECOND);
    int weekday = calendar.get(Calendar.DAY_OF_WEEK);
    /*
    System.out.println("现在是" + year + "年" + month + "月" + day + "日" + hour
                     + "时" + minute + "分" + second + "秒" + "星期" + weekday);
                     */

    String s = "3/4/2018 15:23:44 ";
    String[] s_arr = s.split("\\s+|\\/+|\\:+");
    for (String i:s_arr)
      System.out.println(i);
  }
}
