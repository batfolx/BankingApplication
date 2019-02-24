import java.util.Random;
import java.util.*;

public class SavingsAccount
{
  private double interestRate;
  private String accNum;
  private int amountOfMoney;
  private ArrayList<Customer> o;
  
  public SavingsAccount(String accNum)
  {
    Random randomNum = new Random();
    interestRate = randomNum.nextDouble();
    
    this.accNum = accNum;
  }
  
  public String getAccountNumber()
  {
    return accNum;
  }
  
  public void addCustomer(Customer o)
  {
    this.o.add(o);
  }
  
  public void deposit(int money)
  {
    amountOfMoney += money;
  }
  
  public void withdraw(int money)
  {
    amountOfMoney -= money;
  }
  
  public int getSavingsAccountMoney()
  {
    return amountOfMoney;
  }
  
  public double calculateInterest()
  {
    double interest;
    interest = amountOfMoney * interestRate;
    return interest;
  }
  public double getInterestRate()
  {
    return interestRate;
  }
  
}