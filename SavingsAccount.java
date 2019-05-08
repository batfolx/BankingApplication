import java.util.ArrayList;

public class SavingsAccount extends Account
{


  public SavingsAccount(String accNum)
  {
    super(accNum);

  }


  public void withdraw(int money)
  {
    try
    {
      if (amountOfMoney - money < 0)
      {
        throw new InsufficientFundsException("Not enough money!");
      }
      else if( money < 0)
      {
        throw new NegativeAmountException();
      }
      else
      {
        amountOfMoney -= money;
      }
    }
    catch (InsufficientFundsException e)
    {
      System.out.println("You don't have enough money! You have " + amountOfMoney + " and you tried to withdraw " + money + ".");
    }
    catch (NegativeAmountException e)
    {
      System.out.println("Pleas enter a positive withdrawl amount.");
    }


  }



  
}