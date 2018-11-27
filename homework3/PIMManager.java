import java.util.*;

class PIMTodo extends PIMEntity implements PIMDate {

  private String text;        // todo text
  private Calendar calendar;

  public PIMTodo() {
    // invoke super default constructor, set Priority = normal
    calendar = Calendar.getInstance();
  }
  public PIMTodo(String priority) {
    super(priority);
    calendar = Calendar.getInstance();
  }
  public PIMTodo(String priority, int year, int month, int 
                day, int hour, int minute, int second) {
    super(priority);
    calendar = Calendar.getInstance();
    // set date
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month);
    calendar.set(Calendar.DAY_OF_MONTH, day);
    calendar.set(Calendar.HOUR_OF_DAY, hour);
    calendar.set(Calendar.MINUTE, minute);
    calendar.set(Calendar.SECOND, second);
  }
  public PIMTodo(int year, int month, int 
                day, int hour, int minute, int second) {
    // invoke super default constructor, set Priority = normal
    calendar = Calendar.getInstance();
    // set date
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month);
    calendar.set(Calendar.DAY_OF_MONTH, day);
    calendar.set(Calendar.HOUR_OF_DAY, hour);
    calendar.set(Calendar.MINUTE, minute);
    calendar.set(Calendar.SECOND, second);
  }

  public void fromString(String s) {
    this.text = s;
  }
  public String toString() {
    String s = "TODO " + this.Priority +" "+ printDate() +"\n"+ text;
    return s;
  }

  // assistant method
  private String printDate() {
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH) + 1;
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int minute = calendar.get(Calendar.MINUTE);
    int second = calendar.get(Calendar.SECOND);
    int weekday = calendar.get(Calendar.DAY_OF_WEEK);
    String date = month +"/"+ day +"/"+ year +"/ "+ hour +":"+ 
                  minute +":"+ second;
    return date;
  }
} 
class PIMAppointment extends PIMEntity implements PIMDate {

  private String description;        // appointment text
  private Calendar calendar;

  public PIMAppointment() {
    // invoke super default constructor, set Priority = normal
    calendar = Calendar.getInstance();
  }
  public PIMAppointment(String priority) {
    super(priority);
    calendar = Calendar.getInstance();
  }
  public PIMAppointment(String priority, int year, int month, int 
                day, int hour, int minute, int second) {
    super(priority);
    calendar = Calendar.getInstance();
    // set date
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month);
    calendar.set(Calendar.DAY_OF_MONTH, day);
    calendar.set(Calendar.HOUR_OF_DAY, hour);
    calendar.set(Calendar.MINUTE, minute);
    calendar.set(Calendar.SECOND, second);
  }
  public PIMAppointment(int year, int month, int 
                day, int hour, int minute, int second) {
    // invoke super default constructor, set Priority = normal
    calendar = Calendar.getInstance();
    // set date
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month);
    calendar.set(Calendar.DAY_OF_MONTH, day);
    calendar.set(Calendar.HOUR_OF_DAY, hour);
    calendar.set(Calendar.MINUTE, minute);
    calendar.set(Calendar.SECOND, second);
  }

  public void fromString(String s) {
    this.description = s;
  }
  public String toString() {
    String s = "APPOINTMENT " + this.Priority +" "+ printDate() +"\n"+ description;
    return s;
  }

  // assistant method
  private String printDate() {
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH) + 1;
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int minute = calendar.get(Calendar.MINUTE);
    int second = calendar.get(Calendar.SECOND);
    int weekday = calendar.get(Calendar.DAY_OF_WEEK);
    String date = month +"/"+ day +"/"+ year +"/ "+ hour +":"+ 
                  minute +":"+ second;
    return date;
  }
}
class PIMNote extends PIMEntity {
  String text;    // note

  public PIMNote() {}
  public PIMNote(String priority) {
    super(priority);
  }

  public void fromString(String s) {
    this.text = s;
  }
  public String toString() {
    String s = "NOTE " + this.Priority +" "+"\n"+ text;
    return s;
  }
}
class PIMContact extends PIMEntity {
  String first_name;
  String last_name;
  String email;

  public PIMContact() {}
  public PIMContact(String priority) {
    super(priority);
  }

  public void fromString(String s) {
    // split String s by whitespace
    String[] s_arr = s.split("\\s+");
    first_name = s_arr[0];
    last_name = s_arr[1];
    email = s_arr[2];
  }
  public String toString() {
    String s = "CONTACT " + this.Priority +" "+"\n"+ 
              first_name +" "+ last_name +" "+ email;
    return s;
  }
}


public class PIMManager {

  public static void main(String[] args) {
    System.out.println("Welcome to PIM");
    String prompt = "---Enter a command (suported commands are List " + 
                    "Create Save Load Quit)---\n>>> ";
    System.out.print(prompt);
    ArrayList<PIMEntity> list = new ArrayList<PIMEntity>();   // store PIMEntities
    ArrayList<PIMEntity> temp_list = new ArrayList<PIMEntity>(); //store buf PIMEntities
    // read commands
    Scanner in = new Scanner(System.in);
    String input = in.nextLine().trim().toLowerCase();
    // new manager
    PIMManager manager = new PIMManager();
    while (!input.equals("quit".trim())) {
      switch (input) {
        case "list":    manager.parseList(list, temp_list, in); break;
        case "create":  manager.parseCreate(list, temp_list, in); break;
        case "save":    manager.parseSave(list, temp_list, in); break;
        case "load":    manager.parseLoad(list, temp_list, in); break;
        default: System.out.println("Invalid input!\n>>> ");
      }
    System.out.println();
    System.out.print(prompt);
    input = in.nextLine().trim();
    }
  }

  public void parseList(ArrayList<PIMEntity> list, 
              ArrayList<PIMEntity> temp_list, Scanner in) {
    System.out.println("There are " + list.size() + " items.");
    int i = 1;
    for (PIMEntity p:list) {
      System.out.println("Item " + i +": " + p.toString());
      i++;
    }
  }
  public void parseCreate(ArrayList<PIMEntity> list, 
              ArrayList<PIMEntity> temp_list, Scanner in) {
    System.out.print("Enter an item type ( todo, note, contact" +
      " or appointment\n>>> ");
    String input = in.nextLine().trim().toLowerCase();
    switch (input) {
      case "todo": {
        System.out.print("Enter date for todo item:\n>>> ");
        String input1 = in.nextLine();
        System.out.print("Enter todo text:\n>>> ");
        String input2 = in.nextLine();
        System.out.print("Enter todo priority:\n>>> ");
        String input3 = in.nextLine();
        // parse date
        int[] date = new int[6];
        String[] input_date = input1.split("\\s+|\\/|\\:");
        int i = 0;
        for (String s:input_date) {
          date[i] = Integer.valueOf(s);
          i++;  
        }

        PIMTodo todo = new PIMTodo(input3, date[0], date[1], date[2], 
                                  date[3], date[4], date[5]);
        todo.fromString(input2);
        temp_list.add(todo);
        break;
      }
      case "note": {
        System.out.print("Enter note text:\n>>> ");
        String input4 = in.nextLine();
        System.out.print("Enter note priority:\n>>> ");
        String input5 = in.nextLine();

        PIMNote note = new PIMNote(input5);
        note.fromString(input4);
        temp_list.add(note);
        break;
      }
      case "contact": {
        System.out.print("Enter contact text:\n>>> ");
        String input6 = in.nextLine();
        System.out.print("Enter contact priority:\n>>> ");
        String input7 = in.nextLine();

        PIMContact contact = new PIMContact(input7);
        contact.fromString(input6);
        temp_list.add(contact);
        break;
      }
      case "appointment": {
        System.out.print("Enter date for appointment item:\n>>> ");
        String input8 = in.nextLine();
        System.out.print("Enter appointment text:\n>>> ");
        String input9 = in.nextLine();
        System.out.print("Enter appointment priority:\n>>> ");
        String input10 = in.nextLine();
        // parse date
        int[] date = new int[6];
        String[] input_date = input8.split("\\s+|\\/|\\:");
        int i = 0;
        for (String s:input_date) {
          date[i] = Integer.valueOf(s);
          i++;  
        }

        PIMAppointment appointment = new PIMAppointment(input10, date[0], 
                                  date[1], date[2], date[3], date[4], date[5]);
        appointment.fromString(input9);
        temp_list.add(appointment);
        break;
      }
      default: System.out.println("Invalid input!\n>>> ");
    }
  }
  public void parseSave(ArrayList<PIMEntity> list, 
              ArrayList<PIMEntity> temp_list, Scanner in) {
    for (PIMEntity e:temp_list) {
      list.add(e);
    }
    temp_list.clear();
  }
  public void parseLoad(ArrayList<PIMEntity> list, 
              ArrayList<PIMEntity> temp_list, Scanner in) {}
}
