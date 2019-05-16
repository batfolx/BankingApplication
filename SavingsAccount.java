import javax.swing.*;
import java.awt.*;

/**
 * Subclass of the Account class. Has different functionality in terms of withdrawing money.
 *
 * @author Victor Velea
 * @version 5/15
 */
public class SavingsAccount extends Account
{

  /**
   *  Constructor for a SavingsAccount.
   * @param accNum the account number.
   */
  public SavingsAccount(String accNum)
  {
    super(accNum);
  }

  /**
   * Overrides method from Account class. Money cannot be less than 0 or more than the amount of money currently
   * in the account.
   * @param money the money to be withdrawn.
   */
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
      String msg = "You don't have enough money! You have " + amountOfMoney + " and you tried to withdraw " + money + ".";
      JFrame frame = new JFrame("Error! Enter a positive amount.");
      JButton ok = new JButton("Click here to exit.");
      JTextArea message = new JTextArea(msg);
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
    catch (NegativeAmountException e)
    {
      System.out.println("Pleas enter a positive withdrawl amount.");
    }
  }
}