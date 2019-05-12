/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package bankapp;

import java.io.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

/**
 *
 * @author
 */
public class BankApp extends JFrame {

  private JTextField firstNameField;
  private JTextField lastNameField;
  private JTextField addressField;
  private JTextField phoneNumberField;
  private JTextField accountNumberField;
  private JTextField checkingAccountNumberField;
  private JTextField balanceField;
  private JTextField withdrawDepositField;
  private JTextField interestMonthField;
  private JTextField calculatedInterestField;

  private JButton searchCustomerButton;
  private JButton previousCustomerButton;
  private JButton nextCustomerButton;
  private JButton addCustomerButton;
  private JButton updateCustomerButton;
  private JButton openSavingsAccountButton;
  private JButton openCheckingAccountutton;
  private JButton depositButton;
  private JButton withdrawButton;
  private JButton calculateInterestButton;
  private JButton clearButton;
  private JButton saveSummaryButton;
  private JButton loadCustomersButton;
  private JButton viewSavingsAccountButton;
  private JButton viewCheckingAccountButton;

  private JRadioButton savingsRadioButton;
  private JRadioButton checkingRadioButton;

  private ArrayList<Customer> data = Customer.getCustomerDataArray();
  private int count = 0;

  boolean isSavings = true;



  public BankApp()
  {
   /* try {
      UIManager.setLookAndFeel(
              UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException
            | IllegalAccessException | UnsupportedLookAndFeelException e) {
      System.out.println(e);
    } */

  }

  /**
   * Initializes the components for the banking application.
   * This is the GUI. The rest takes care of everything.
   */
  private void initComponents() {
    setTitle("Banking Application");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationByPlatform(true);


    //set up size component
    ButtonGroup sizeGroup = new ButtonGroup();
    savingsRadioButton = new JRadioButton("Savings");
    checkingRadioButton = new JRadioButton("Checking");

    sizeGroup.add(savingsRadioButton);
    sizeGroup.add(checkingRadioButton);

    savingsRadioButton.setSelected(true);
    savingsRadioButton.addActionListener(
            event -> sizeRadioButtonClicked());
    checkingRadioButton.addActionListener(
            event -> sizeRadioButtonClicked());


    JPanel sizePanel = new JPanel();
    sizePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    sizePanel.add(savingsRadioButton);
    sizePanel.add(checkingRadioButton);

    add(sizePanel);


    // components go here
    firstNameField = new JTextField();
    lastNameField = new JTextField();
    addressField = new JTextField();
    phoneNumberField = new JTextField();
    accountNumberField = new JTextField() ;
    balanceField = new JTextField();
    withdrawDepositField = new JTextField() ;
    interestMonthField = new JTextField() ;
    calculatedInterestField = new JTextField() ;
    checkingAccountNumberField = new JTextField();

    balanceField.setEditable(false);
    calculatedInterestField.setEditable(false);

    Dimension dim = new Dimension(150, 20);
    firstNameField.setPreferredSize(dim);
    lastNameField.setPreferredSize(dim);
    addressField.setPreferredSize(dim);
    phoneNumberField.setPreferredSize(dim);
    accountNumberField.setPreferredSize(dim);
    balanceField.setPreferredSize(dim);
    withdrawDepositField.setPreferredSize(dim);
    interestMonthField.setPreferredSize(dim);
    calculatedInterestField.setPreferredSize(dim);
    firstNameField.setMinimumSize(dim);
    lastNameField.setMinimumSize(dim);
    addressField.setMinimumSize(dim);
    phoneNumberField.setMinimumSize(dim);
    accountNumberField.setMinimumSize(dim);
    balanceField.setMinimumSize(dim);
    withdrawDepositField.setMinimumSize(dim);
    interestMonthField.setMinimumSize(dim);
    calculatedInterestField.setMinimumSize(dim);
    checkingAccountNumberField.setPreferredSize(dim);

    //create the two Buttons
    searchCustomerButton = new JButton("Search Customer");
    previousCustomerButton = new JButton("Previous Customer");
    nextCustomerButton = new JButton("Next Customer");
    addCustomerButton = new JButton("Add Customer");
    updateCustomerButton = new JButton("Update Customer");
    openSavingsAccountButton = new JButton("Open Savings Account");
    openCheckingAccountutton = new JButton("Open Checking Account");
    depositButton = new JButton("deposit");
    withdrawButton = new JButton("withdraw");
    calculateInterestButton = new JButton("Calculate Interest");
    clearButton = new JButton("Clear fields");
    saveSummaryButton = new JButton("Summary report");
    loadCustomersButton = new JButton("Load customers");
    viewCheckingAccountButton = new JButton("View Checking Accounts");
    viewSavingsAccountButton = new JButton("View Savings Account");



    //create a panel that uses the GridBagLayout manager with right Alignment
    //JPanel buttonPanel = new JPanel();
    //buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    //add the 2 buttons to this panel
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    panel.add(searchCustomerButton, getConstraints(2, 0));
    panel.add(previousCustomerButton, getConstraints(2, 1));
    panel.add(nextCustomerButton, getConstraints(2, 2));
    panel.add(addCustomerButton, getConstraints(2, 3));
    panel.add(updateCustomerButton, getConstraints(2, 4));
    panel.add(clearButton, getConstraints(2, 5));
    panel.add(depositButton, getConstraints(2, 6));
    panel.add(withdrawButton, getConstraints(2, 7));
    panel.add(calculateInterestButton, getConstraints(2, 8));
    panel.add(saveSummaryButton, getConstraints(10, 10));
    panel.add(loadCustomersButton, getConstraints(3, 1));
    panel.add(viewCheckingAccountButton, getConstraints(3, 2));
    panel.add(viewSavingsAccountButton, getConstraints(3, 3));
    panel.add(openCheckingAccountutton, getConstraints(3,4));
    panel.add(openSavingsAccountButton, getConstraints(3, 5));


    //add action listeners to both buttons
    searchCustomerButton.addActionListener(e -> searchCustomerButtonClicked());
    previousCustomerButton.addActionListener(e -> previousCustomerButtonClicked());
    nextCustomerButton.addActionListener(e -> nextCustomerButtonClicked());
    addCustomerButton.addActionListener(e -> addCustomerButtonClicked());
    updateCustomerButton.addActionListener(e -> updateCustomerButtonClicked());
    withdrawButton.addActionListener(e -> withdrawButtonClicked());
    calculateInterestButton.addActionListener(e -> calculateInterestButtonClicked());
    clearButton.addActionListener(e -> clear());
    saveSummaryButton.addActionListener(e -> saveButtonPressed());
    viewCheckingAccountButton.addActionListener(e -> viewCheckingAccountButtonClicked());
    viewSavingsAccountButton.addActionListener(e -> viewSavingsAccountButtonClicked());
    openCheckingAccountutton.addActionListener(e -> openCheckingAccountButtonClicked());
    openSavingsAccountButton.addActionListener(e -> openSavingsAccountButtonClicked());
    depositButton.addActionListener(e -> depositIntoSpecifiedCheckingAccountButtonClicked());
    depositButton.addActionListener(e -> depositIntoSpecifiedSavingsAccountButtonClicked());

    //add this panel to the bottom of the frame
    //add(buttonPanel, BorderLayout.SOUTH);
    //create a panel that uses the GridBagLayout manager
    //JPanel panel = new JPanel();
    //panel.setLayout(new GridBagLayout());

    //code that add the 4 labels and textFields tot this Panel
    panel.add(new JLabel("Customer First Name"), getConstraints(0, 0));
    panel.add(firstNameField, getConstraints(1, 0));
    panel.add(new JLabel("Customer Last"), getConstraints(0, 1));
    panel.add(lastNameField, getConstraints(1, 1));
    panel.add(new JLabel("Address"), getConstraints(0, 2));
    panel.add(addressField, getConstraints(1, 2));
    panel.add(new JLabel("Phone Number"), getConstraints(0, 3));
    panel.add(phoneNumberField, getConstraints(1, 3));
    panel.add(new JLabel("Savings Account Number"), getConstraints(0, 4));
    panel.add(accountNumberField, getConstraints(1, 4));
    panel.add(new JLabel("Checking Account Number"), getConstraints(0, 5));
    panel.add(checkingAccountNumberField, getConstraints(1,5));
    panel.add(new JLabel("Balance"), getConstraints(0, 6));
    panel.add(balanceField, getConstraints(1, 6));
    panel.add(new JLabel("Withdraw/Deposit"), getConstraints(0, 7));
    panel.add(withdrawDepositField, getConstraints(1, 7));

    JPanel interest =  new JPanel();

    interest.add(interestMonthField, getConstraints(1, 11));
    interest.add(new JLabel("Calculated Interest:"), getConstraints(1, 11));
    interest.add(calculatedInterestField, getConstraints(2, 11));
    interest.add(new JLabel(""), getConstraints(0, 9));
    //panel.add(calculatedInterestField, getConstraints(1, 9));


    add(sizePanel, BorderLayout.NORTH);
    add(interest, BorderLayout.SOUTH);
    add(panel, BorderLayout.CENTER);
    //add(buttonPanel, BorderLayout.NORTH);
    //Pack the frame to set its size
    pack();
    setVisible(true);
  }

  // Helper method to return GridBagConstraints objects
  private GridBagConstraints getConstraints(int x, int y) {
    GridBagConstraints c = new GridBagConstraints();
    c.anchor = GridBagConstraints.LINE_START;
    c.insets = new Insets(5, 5, 0, 5);
    c.gridx = x;
    c.gridy = y;
    return c;
  }


  /**
   * Main driver application for the BankingApp
   * @param args not used
   */
  public static void main(String[] args)
  {
    BankApp app = new BankApp();
    app.initComponents();
  }

  /**
   * Calculates the interest rate of a customer.
   */
  private void calculateInterestButtonClicked()
  {
    calculatedInterestField.setText(Double.toString(data.get(count).getCalculatedInterest()));
  }

  /**
   * Withdraw a certain amount of money from a customers savings or checking account.
   */
  private void withdrawButtonClicked()
  {
    String withDepos = withdrawDepositField.getText();

    try
    {
      if (isSavings)
      {
        int moneyWithdraw = Integer.parseInt(withDepos);
        data.get(count).subSavingsAccBalance(moneyWithdraw);
        balanceField.setText(Double.toString(data.get(count).getSavingsAccBalance()));
      }
      else
      {
        int moneyWithdraw = Integer.parseInt(withDepos);
        data.get(count).subCheckingAccountBalance(moneyWithdraw);
        balanceField.setText(Double.toString(data.get(count).getCheckingAccBalance()));
      }
    }
    catch(Exception ignored)
    {
      System.out.println("You need to enter a valid withdraw value.");
    }
  }

  /**
   * Deposits money into a specified savings account.
   * You must type the checking account number by which you want the money deposited into.
   * If no account is found with the account number, it adds it to the main checking account instead,
   * provided the "Checkings" button at the top is checked.
   */
  private void depositIntoSpecifiedCheckingAccountButtonClicked()
  {
    String checkingAccNum = checkingAccountNumberField.getText();

    for (int i = 0; i < data.get(count).getCheckingAccounts().size(); i++)
    {
      if (checkingAccNum.equals(data.get(count).getCheckingAccounts().get(i).getAccountNumber()))
      {
        try
        {
          data.get(count).getCheckingAccounts().get(i).deposit(Integer.parseInt(withdrawDepositField.getText()));
          return;
        }
        catch (Exception ig)
        {
          break;
        }
      }
    }

    if (!isSavings)
    {
      data.get(count).addCheckingAccBalance(Integer.parseInt(withdrawDepositField.getText()));
      balanceField.setText(data.get(count).getCheckingAccBalance() + "");
    }

  }

  /**
   * Deposits money into a specified savings account.
   * You must type the savings account number into the "Savings Account Number" field
   * by which you want the money deposited into.
   * If no account is found with the account number, it adds it to the main savings account instead,
   * provided the "Savings" button at the top is checked.
   */
  private void depositIntoSpecifiedSavingsAccountButtonClicked()
  {
    String savingsAccountNum = accountNumberField.getText();
    balanceField.setText("");

      for (int i = 0; i < data.get(count).getSavingsAccounts().size(); i++)
      {

        if (savingsAccountNum.equals(data.get(count).getSavingsAccounts().get(i).getAccountNumber()))
        {
          try
          {
            data.get(count).getSavingsAccounts().get(i).deposit(Integer.parseInt(withdrawDepositField.getText()));
            return;

          }
          catch (Exception ig)
          {
            break;
          }
        }
      }



      if (isSavings)
      {
        data.get(count).addSavingsAccBalance(Integer.parseInt(withdrawDepositField.getText()));
        balanceField.setText(data.get(count).getSavingsAccBalance() + "");
      }

  }

  /**
   * Updates a customers information.
   */
  private void updateCustomerButtonClicked() {
    String firstName = firstNameField.getText();
    String lastName = lastNameField.getText();
    String address = addressField.getText();
    String phoneNumber = phoneNumberField.getText();
    String accountNumber = accountNumberField.getText();
    for (int i = 0; i < data.size(); i++)
    {
      if ((data.get(i).getFirstName().equals(firstName)) ||
              (data.get(i).getLastName().equals(lastName)) ||
              (data.get(i).getAddress().equals(address)) ||
              (data.get(i).getPhoneNumber().equals(phoneNumber)) ||
              (data.get(i).getAccNumber().equals(accountNumber)))
      {
        System.out.println("Updating customer: " + data.get(i).getFirstName() + "...");
        System.out.println("Updating customer: " + data.get(i).getLastName() + "...");
        data.get(i).setFirstName(firstName);
        data.get(i).setLastName(lastName);
        data.get(i).setPhoneNumber(phoneNumber);
        data.get(i).setAddress(address);
        System.out.println("Successfully updated customer " + data.get(i).getFirstName() + "!");
      }
    }
  }

  /**
   * Adds a customer to the database.
   */
  private void addCustomerButtonClicked()
  {
    String firstName = firstNameField.getText();
    String lastName = lastNameField.getText();
    String address = addressField.getText();
    String phoneNumber = phoneNumberField.getText();
    String accountNumber = accountNumberField.getText();
    Customer temp = new Customer(firstName, lastName, address, phoneNumber, new SavingsAccount(accountNumber), new CheckingAccount(accountNumber));
    data.add(temp);
  }

  /**
   * Goes to the next customer in the database.
   */
  private void nextCustomerButtonClicked()
  {
    if (count == data.size() - 1)
    {
      count = -1;
    }
    count++;

    setTextFields();

    if (isSavings)
    {
      balanceField.setText(Double.toString(data.get(count).getSavingsAccBalance()));
    }
    else
    {
      balanceField.setText(Double.toString(data.get(count).getCheckingAccBalance()));
    }

  }

  /**
   * Goes to the previous customer in the database.
   */
  private void previousCustomerButtonClicked()
  {
    if (count == 0)
    {
      count = data.size();
    }
    count--;
    setTextFields();
    if (isSavings)
    {

      balanceField.setText(Double.toString(data.get(count).getSavingsAccBalance()));
      calculatedInterestField.setText(Double.toString(data.get(count).getCalculatedInterest()));
    }
    else
    {
      balanceField.setText(Double.toString(data.get(count).getCheckingAccBalance()));
      calculatedInterestField.setText(Double.toString(data.get(count).getCalculatedInterest()));
    }

  }

  /**
   * Helped function to set the text fields.
   */
  private void setTextFields()
  {
    firstNameField.setText(data.get(count).getFirstName());
    lastNameField.setText(data.get(count).getLastName());
    addressField.setText(data.get(count).getAddress());
    phoneNumberField.setText(data.get(count).getPhoneNumber());
    accountNumberField.setText(data.get(count).getAccNumber());
    calculatedInterestField.setText(Double.toString(data.get(count).getCalculatedInterest()));
  }

  /**
   * Searches the database for a specified customer; does nothing if not found.
   */
  private void searchCustomerButtonClicked()
  {
    String firstName = firstNameField.getText();
    String lastName = lastNameField.getText();
    String address = addressField.getText();
    String phoneNumber = phoneNumberField.getText();
    String accountNumber = accountNumberField.getText();
    for (int i = 0; i < data.size(); i++)
    {
      if ((data.get(i).getFirstName().equals(firstName)) ||
              (data.get(i).getLastName().equals(lastName)) ||
              (data.get(i).getAddress().equals(address)) ||
              (data.get(i).getPhoneNumber().equals(phoneNumber)) ||
              (data.get(i).getAccNumber().equals(accountNumber)))
      {
        firstNameField.setText(data.get(i).getFirstName());
        lastNameField.setText(data.get(i).getLastName());
        addressField.setText(data.get(i).getAddress());
        phoneNumberField.setText(data.get(i).getPhoneNumber());
        accountNumberField.setText(data.get(i).getAccNumber());
        count = i;
      }
    }
  }

  /**
   * This method switches between a savings account and a checking account.
   */
  private void sizeRadioButtonClicked()
  {
    if (savingsRadioButton.isSelected())
    {
      balanceField.setText(Double.toString(data.get(count).getSavingsAccBalance()));
      withdrawDepositField.setText("");
      enableSavingsControls(true);
    }
    else if (checkingRadioButton.isSelected())
    {
      balanceField.setText(Double.toString(data.get(count).getCheckingAccBalance()));
      withdrawDepositField.setText("");
      enableSavingsControls(false);
    }
  }

  /**
   * This method differentiates between the savings option and the checking option clicked.
   * @param b the boolean parameter to be switched
   */
  private void enableSavingsControls(boolean b)
  {
    if (b)
    {
      isSavings = true;
    }
    else
    {
      isSavings = false;
    }

  }

  /**
   * Clears the text fields of the fields.
   */
  private void clear()
  {
    firstNameField.setText("");
    lastNameField.setText("");
    addressField.setText("");
    phoneNumberField.setText("");
    accountNumberField.setText("");
    balanceField.setText("");
    calculatedInterestField.setText("");
    count = 0;
  }

  /**
   * Saves the customers info to a text file.
   */
  private void saveButtonPressed()
  {
    BufferedWriter writer;
    try
    {
      writer = new BufferedWriter(new FileWriter("customers.txt"));

      String checkAcc = "";
      String savingsAcc = "";
      String mainInfo = "";

      for (int i = 0; i < data.size(); i++)
      {
        for (int j = 0; j < data.get(i).getSavingsAccounts().size(); j++)
        {
          savingsAcc += "\n\tSavings Account " + data.get(i).getSavingsAccounts().get(j).getAccountNumber() +
                     " with balance " + data.get(i).getSavingsAccounts().get(j).getAccountMoney() + "\n";
        }

        for (int k = 0; k < data.get(i).getCheckingAccounts().size(); k++)
        {
          checkAcc += "\n\tChecking Account " + data.get(i).getCheckingAccounts().get(k).getAccountNumber() +
                  " with balance " + data.get(i).getSavingsAccounts().get(k).getAccountNumber() + "\n";
        }

        mainInfo += "Customer " + data.get(i).getFullName() + " with accounts " + savingsAcc + checkAcc + "\n\n";

      }

      writer.write(mainInfo);



      writer.close();
    }
    catch(IOException e)
    {
      System.out.println("Could not write to file.");
    }
  }

  /**
   * Brings up a new frame that lists all of the checking account associated with that customer.
   */
  private void viewCheckingAccountButtonClicked()
  {
    JFrame jframe = new JFrame("Checking Accounts for customer " + data.get(count).getFullName());
    JPanel tmpPanel = new JPanel();
    for (int i = 0; i < data.get(count).getCheckingAccounts().size(); i++)
    {
      JTextField tmp = new JTextField("Checking Account Number " + data.get(count).getCheckingAccounts().get(i).getAccountNumber()
                                      + " with balance " + data.get(count).getCheckingAccounts().get(i).getAccountMoney());
      tmp.setEditable(false);
      tmpPanel.add(tmp);
    }

    jframe.setPreferredSize(new Dimension(500,500));
    jframe.add(tmpPanel);
    jframe.pack();
    jframe.setVisible(true);
  }

  /**
   * Brings up a new frame that displays all of the savings accounts associated with the current customer.
   */
  private void viewSavingsAccountButtonClicked()
  {

    JFrame jframe = new JFrame("Savings Accounts for customer " + data.get(count).getFullName());
    JPanel tmpPanel = new JPanel();
    for (int i = 0; i < data.get(count).getSavingsAccounts().size(); i++)
    {
      JTextField tmp = new JTextField("Savings Account Number " + data.get(count).getSavingsAccounts().get(i).getAccountNumber()
              + " with balance " + data.get(count).getSavingsAccounts().get(i).getAccountMoney());
      tmp.setEditable(false);
      tmpPanel.add(tmp);
    }

    jframe.setPreferredSize(new Dimension(500,500));
    jframe.add(tmpPanel);
    jframe.pack();
    jframe.setVisible(true);
  }

  private void loadCustomersButtonClicked()
  {
    BufferedReader reader;
    data = new ArrayList<>();

    try
    {
      reader = new BufferedReader(new FileReader("load_customers.txt"));

      String line = reader.readLine();


      while(line != null)
      {
        line = reader.readLine();
        String lName = reader.readLine();
        String address = reader.readLine();
        String pNum = reader.readLine();
        String savingAccNum = reader.readLine();
        String checkingAccNum = reader.readLine();
        data.add(new Customer(line, lName, address, pNum, new SavingsAccount(savingAccNum), new CheckingAccount(checkingAccNum)));

      }

    }
    catch (IOException e)
    {
      System.out.println("Could not read file.");
    }
  }

  /**
   * Opens a new savings account to the current customer.
   */
  private void openSavingsAccountButtonClicked()
  {
    if (accountNumberField.getText().length() == 0) throw new IllegalArgumentException("Must enter a account number");

    data.get(count).getSavingsAccounts().add(new SavingsAccount(accountNumberField.getText()));

  }

  /**
   * Adds a new checking account to the current customer.
   */
  private void openCheckingAccountButtonClicked()
  {
    if (checkingAccountNumberField.getText().length() == 0) throw new IllegalArgumentException("Must enter a account number");

    data.get(count).getCheckingAccounts().add(new CheckingAccount(checkingAccountNumberField.getText()));
  }

}

    
