import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Abstract class for an Account.
 *
 * @author Victor Velea
 * @version 5/15
 */
public abstract class Account
{
  protected String accNum;
  protected double interestRate;
  protected int amountOfMoney;


  /**
   * Constructor for an Account object.
   * @param accNum the account Number.
   */
  public Account(String accNum)
  {
    this.accNum = accNum;
    Random randomNum = new Random();
    interestRate = randomNum.nextDouble();
  }

  /**
   * Gets the account number associated with this account.
   * @return the account number.
   */
  public String getAccountNumber()
  {
    return accNum;
  }

  /**
   * Sets the account number.
   * @param s the account number to be set.
   */
  public void setAccNum(String s)
  {
    accNum = s;
  }

  /**
   * Deposits money into this account. Throws exceptions if parameter is wrong.
   * precondition: money must be positive.
   * @param money the money to be deposited.
   */
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
      JFrame frame = new JFrame();
      JButton ok = new JButton("Click here to exit.");
      JTextArea message = new JTextArea("Error! Enter a positive amount.");
      message.setPreferredSize(new Dimension(300,300));

      JPanel panel = new JPanel();
      panel.add(ok);
      panel.add(message);
      frame.add(panel);
      frame.setPreferredSize(new Dimension(250, 250));

      frame.pack();
      frame.setVisible(true);
      ok.addActionListener(event -> frame.dispose());

    }

  }

  /**
   * Withdraws money from this account. Throws exceptions if parameter is wrong.
   * @param money the money to be deposited.
   */
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

  /**
   * Gets the account money.
   * @return the account money.
   */
  public int getAccountMoney()
  {
    return amountOfMoney;
  }

  /**
   * Calculates the interest rate associated with this account.
   * @return the calculated interest rate.
   */
  public double calculateInterest()
  {
    double interest;
    interest = amountOfMoney * interestRate;
    return interest;
  }

  /**
   * Gets the interest rate.
   * @return the interest rate.
   */
  public double getInterestRate()
  {
    return interestRate;
  }

  /**
   * Nested class for throwing an exception for the deposit and withdraw methods.
   */
  protected class InsufficientFundsException extends Exception
  {
    public InsufficientFundsException() {}

    public InsufficientFundsException(String msg)
    {
      System.out.println(msg);
    }

  }

  /**
   * Nested class for throwing an exception for the deposit and withdraw methods.
   */
  protected class NegativeAmountException extends Exception
  {

  }

}
