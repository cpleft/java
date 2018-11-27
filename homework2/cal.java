import java.util.Calendar;

public class cal
{
  public Calendar calendar = Calendar.getInstance();
  
  public cal() {}
  public cal(int month, int year) {
    calendar.set(year, month-1, 1);
  }
  public void printCalendar() {
    printMonthAndYear();
    printSunToSat();
    printDays();
  }

  // assistant methods
  private void printMonthAndYear() {
    switch (calendar.get(calendar.MONTH)+1) {
      case 1: System.out.print("January"); break;
      case 2: System.out.print("February"); break;
      case 3: System.out.print("March"); break;
      case 4: System.out.print("April"); break;
      case 5: System.out.print("May"); break;
      case 6: System.out.print("June"); break;
      case 7: System.out.print("July"); break;
      case 8: System.out.print("August"); break;
      case 9: System.out.print("September"); break;
      case 10: System.out.print("October"); break;
      case 11: System.out.print("November"); break;
      case 12: System.out.print("December"); break;
    }
    System.out.println(" " + calendar.get(calendar.YEAR));
  }
  private void printSunToSat() {
    System.out.println("Su Mo Tu We Th Fr Sa");
  }
  private void printDays() {
    int daysOfMonth = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
    int firstDayInWeek = calendar.get(calendar.DAY_OF_WEEK);

    // Offset
    for (int i = 0; i < 3 * (firstDayInWeek - 1); i++)
        System.out.print(" ");

    for (int i = 0; i < daysOfMonth; i++) {
        // Print spaces according to date
        if (i < 9)
            System.out.print(" " + (i + 1) + " ");
        else
            System.out.print((i + 1) + " ");

        // Change line
        if ((i + firstDayInWeek) % 7 == 0) {
            System.out.println();
        }
    }
    System.out.println();
  }



  /** main */
  public static void main(String[] args)
  {
    if (args.length == 2 && Integer.parseInt(args[0])>0 && 
        Integer.parseInt(args[0])<=12 && Integer.parseInt(args[1])>=0 && 
        Integer.parseInt(args[1])<9999 ) {

        cal c = new cal(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        c.printCalendar();
    }
    else {
      cal c = new cal();
      c.printCalendar();
    }
  }

}
