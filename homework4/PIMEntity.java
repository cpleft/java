public abstract class PIMEntity {
  String Priority;  // every kind of item has a priority

  // default constructor set priority to "normal"
  PIMEntity() {
    Priority = "normal";
  }

  // priority can be established via this constructor
  PIMEntity(String priority) {
    Priority = priority;
  }

  // accessor method for getting the priority string
  public void setPriority(String P) {
    Priority = P;
  }
  
  // Each PIMEntity needs to be able to set all state information
  // (fields) from a single text string.
  abstract public void fromString(String s);

  // This is actually already defined by the super class
  // Object, but redefinded here as abstract to make sure
  // that derived classes actually implement it
  abstract public String toString();
}
