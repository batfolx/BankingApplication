import java.util.*;

/**
 * Class that encapsulates a Customer object.
 *
 * @author Victor Velea
 * @version 5/15
 */
public class Customer
{
  private String fName;
  private String lName;
  private String address;
  private String pNumber;
  private String login;
  private String password;
  private SavingsAccount savingsAcc;
  private CheckingAccount checkAcc;
  private List<SavingsAccount> savingsAccounts;
  private List<CheckingAccount> checkingAccounts;


  /**
   * Constructor for a Customer object. Each customer must have a name, phone number
   * address, and a checking and savings account.
   * Multiple savings accounts and checking accounts can be added to a customer.
   * @param fName The first name of the Customer.
   * @param lName The last name of the Customer.
   * @param address The address of the Customer.
   * @param pNumber The phone number of the Customer.
   * @param savingsAcc The savings account of the Customer.
   * @param checkAcc The checking account of the Customer.
   * @param login the login of the associated Customer.
   * @param password the password of the associated Customer.
   */
  public Customer(String fName, String lName, String address, String pNumber, SavingsAccount savingsAcc, CheckingAccount checkAcc, String login, String password)
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
      this.login = login;
      this.password = password;
      this.savingsAcc = savingsAcc;
      this.checkAcc = checkAcc;
      savingsAccounts = new ArrayList<>();
      checkingAccounts = new ArrayList<>();
    }
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
   * Method for getting the full name of a customer.
   * @return the full name of the customer.
   */
  public String getFullName()
  {
    return fName + " " + lName;
  }

  /**
   * Returns the account number of the savings account obj.
   * @return the account number.
   */
  public String getAccNumber()
  {
    return savingsAcc.getAccountNumber();
  }

  /**
   * Gets the login of the customer.
   * @return the login of the customer.
   */
  public String getLogin()
  {
    return login;
  }

  /**
   * Gets the password of the customer.
   * @return the password.
   */
  public String getPassword()
  {
    return password;
  }

  /**
   * Sets the login of the customer.
   * @param log the login to be set.
   */
  public void setLogin(String log)
  {
    login = log;
  }

  /**
   * Sets the password of a customer.
   * @param pass the password to be reset.
   */
  public void setPassword(String pass)
  {
    password = pass;
  }



  /**
   * Gets the main checking account number.
   * @return the checking account number.
   */
  public String getCheckingAccNumber()
  {
    return checkAcc.getAccountNumber();
  }

  /**
   *
   * @return the associated savings account balance.
   */
  public int getSavingsAccBalance()
  {
    return savingsAcc.getAccountMoney();
  }

  /**
   *
   * @return the associated checking account balance.
   */
  public int getCheckingAccBalance()
  {
    return checkAcc.getAccountMoney();
  }

  /**
   *
   * @param a the amount of money to be added to the savings account.
   */
  public void addSavingsAccBalance(int a)
  {
    savingsAcc.deposit(a);
  }

  /**
   *
   * @param amount the amount of money to be added to the checking account.
   */
  public void addCheckingAccBalance(int amount)
  {
    checkAcc.deposit(amount);
  }

  /**
   *
   * @param amount the amount to be subtracted from the checking account.
   */
  public void subCheckingAccountBalance(int amount)
  {
    checkAcc.withdraw(amount);
  }

  /**
   *
   * @param amount the amount to be subtracted from the savings account.
   */
  public void subSavingsAccBalance(int amount)
  {
    savingsAcc.withdraw(amount);
  }

  /**
   *
   * @param account the account to be added to the checkings account ArrayList.
   */
  public void addCheckingAccount(CheckingAccount account)
  {
    checkingAccounts.add(account);
  }

  /**
   * Adds a savings account to the ArrayList.
   * @param account the account to be added to the savings account ArrayList.
   */
  public void addSavingsAccount(SavingsAccount account)
  {
    savingsAccounts.add(account);
  }

  public List<SavingsAccount> getSavingsAccounts()
  {
    return savingsAccounts;
  }

  public List<CheckingAccount> getCheckingAccounts()
  {
    return checkingAccounts;
  }

  /**
   * Sets the first name of the customer.
   * @param firstName the name to be set.
   */
  public void setFirstName(String firstName)
  {
    fName = firstName;
  }

  /**
   * Sets the last name of the customer.
   * @param lastName the name to be set.
   */
  public void setLastName(String lastName)
  {
    lName = lastName;
  }

  /**
   * Sets the phone number of the customer.
   * @param pNum the phone number to be set.
   */
  public void setPhoneNumber(String pNum)
  {
    pNumber = pNum;
  }

  /**
   * Sets the address of the customer.
   * @param add the address of the customer
   */
  public void setAddress(String add)
  {
    address = add;
  }

  /**
   *
   * @return the interest with the specified account.
   */
  public double getCalculatedInterest()
  {
    return savingsAcc.calculateInterest();
  }

  public void setSavingsAccountNumber(String s)
  {
    savingsAcc.setAccNum(s);
  }

  public void setCheckingAccountNumber(String s)
  {
    checkAcc.setAccNum(s);
  }

  /**
   * Used for customer summary reports.
   * @return The string associated with the customer.
   */
  public String toString()
  {
    return "Customer name: " + getFirstName() + " " + getLastName() + "\n"
            + "Phone number: " + getPhoneNumber() + "\n"
            + "Address: " + getAddress() + "\n"
            + "Savings Account number: " + getAccNumber() + "\n"
            + "Checking Account number: " + getAccNumber() + "\n"
            + "Savings Account balance: " + savingsAcc.getAccountMoney() + "\n"
            + "Checking Account balance: " + checkAcc.getAccountMoney() + ".\n\n";

  }

}
