import java.util.Random;

public abstract class Account
{
  protected String accNum;
  protected double interestRate;
  protected int amountOfMoney;


  public Account(String accNum)
  {
    this.accNum = accNum;
    Random randomNum = new Random();
    interestRate = randomNum.nextDouble();
  }

  public String getAccountNumber()
  {
    return accNum;
  }

  public void deposit(int money)
  {

    try
    {
      if (money < 0)
      {
        throw new NegativeAmountException();
      }
      else
      {
        amountOfMoney += money;
      }
    }
    catch (NegativeAmountException ig)
    {
      System.out.println("You entered " + money + ". Please enter a positive value.");
    }

  }

  public void withdraw(int money)
  {
    try
    {
      if (money < 0)
      {
        throw new NegativeAmountException();
      }
      else
      {
        amountOfMoney -= money;
      }
    }
    catch (NegativeAmountException e)
    {
      System.out.println("The amount must be positive.");

    }

  }

  public int getAccountMoney()
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

  protected class InsufficientFundsException extends Exception
  {
    public InsufficientFundsException() {}

    public InsufficientFundsException(String msg)
    {
      System.out.println(msg);
    }

  }

  protected class NegativeAmountException extends Exception
  {

  }

}
