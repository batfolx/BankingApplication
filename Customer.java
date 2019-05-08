import java.lang.reflect.Array;
import java.util.*;
public class Customer
{
  private String fName;
  private String lName;
  private String address;
  private String pNumber;
  private SavingsAccount acc;
  private CheckingAccount checkAcc;
  
  public Customer(String fName, String lName, String address, String pNumber, SavingsAccount acc, CheckingAccount checkAcc)
  {
    if (fName == null || fName.length() == 0)
    {
      throw new IllegalArgumentException("Please input a name.");
    } 
    else
    {
    this.fName = fName;
    this.lName = lName;
    this.address = address;
    this.pNumber = pNumber;
    this.acc = acc;
    this.checkAcc = checkAcc;
    }
    
  }
 /**
  * Returns the names as a String array.
  * @return the names as a string array.
  */
  public String[] getflName()
  {
    String[] names = {fName, lName};
    return names;
  }
  
 /**
  * Returns the first name.
  * @return the first name as a string.
  */  
  public String getFirstName()
  {
    return fName;
  }
  
 /**
  * Returns the last name.
  * @return the last name as a string.
  */  
  public String getLastName()
  {
    return lName;
  }
  
 /**
  * Returns the address of the customer.
  * @return the address.
  */
  public String getAddress()
  {
    return address;
  }

 /**
  * Returns the phone number of the customer.
  * @return the phone number.
  */  
  public String getPhoneNumber()
  {
    return pNumber;
  }


 /**
  * Returns the account number of the savings account obj.
  * @return the account number.
  */    
  public String getAccNumber()
  {
    return acc.getAccountNumber();
  }
  
  public int getSavingsAccBalance()
  {
    return acc.getAccountMoney();
  }

  public int getCheckingAccBalance()
  {
    return checkAcc.getAccountMoney();
  }

  
  public void addSavingsAccBalance(int a)
  {
    acc.deposit(a);
  }
  public void addCheckingAccBalance(int amount)
  {
    checkAcc.deposit(amount);
  }

  public void subCheckingAccountBalance(int amount)
  {
    checkAcc.withdraw(amount);
  }



  public void subSavingsAccBalance(int a)
  {
    acc.withdraw(a);
  }
  
  public void setFirstName(String n)
  {
    fName = n;
  }
  
  public void setLastName(String n)
  {
    lName = n;
  }
  
  public void setPhoneNumber(String n)
  {
    pNumber = n;
  }
  
  public void setAddress(String n)
  {
    address = n;
  }
  
  public double getCalculatedInterest()
  {
    return acc.calculateInterest();
  }

  public String toString()
  {
    return "Customer name: " + getFirstName() + " " + getLastName() + "\n"
            + "Phone number: " + getPhoneNumber() + "\n"
            + "Address: " + getAddress() + "\n"
            + "Savings Account number: " + getAccNumber() + "\n"
            + "Checking Account number: " + getAccNumber() + "\n"
            + "Savings Account balance: " + acc.getAccountMoney() + "\n"
            + "Checking Account balance: " + checkAcc.getAccountMoney() + ".\n\n";

  }

  
  public static ArrayList<Customer> getCustomerDataArray()
  {
    ArrayList<Customer> data = new ArrayList<>();
    Customer Victor = new Customer("Victor", "Velea", "4321 Hungry avenue","703547", new SavingsAccount("1102"), new CheckingAccount("1102"));
    Customer Kaitlyn = new Customer("Kaitlyn", "Smith", "19002 Smile Drive","222222", new SavingsAccount("1103"), new CheckingAccount("1103"));
    Customer Jessie = new Customer("Jessie", "Quincy", "302 drive apt 401","871523", new SavingsAccount("1104"),new CheckingAccount("1104"));
    Customer Jie = new Customer("Jie", "I forgot your pronouns", "1234 dude guy drive",
            "8887437", new SavingsAccount("1105"), new CheckingAccount("1105"));
    data.add(Victor);
    data.add(Kaitlyn);
    data.add(Jessie);
    data.add(Jie);
    data.add(new Customer("jose", "muffin", "7261 Girraffe Road Court", "8749088833", new SavingsAccount("1106"), new CheckingAccount("1106")));
    return data;
  }
  
}
