/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package bankapp;

import javafx.scene.layout.Border;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
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
  private List<JTextField> textFields;
  private List<JButton> buttons;
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

   buttons = new ArrayList<>();
   textFields = new ArrayList<>();

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

    textFields.add(firstNameField);
    textFields.add(lastNameField);
    textFields.add(addressField);
    textFields.add(phoneNumberField);
    textFields.add(accountNumberField);
    textFields.add(balanceField);
    textFields.add(withdrawDepositField);
    textFields.add(interestMonthField);
    textFields.add(calculatedInterestField);
    textFields.add(checkingAccountNumberField);




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

    //create the buttons
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

    // adds all the buttons to the List of buttons
    // for visual purposes
    buttons.add(searchCustomerButton);
    buttons.add(previousCustomerButton);
    buttons.add(nextCustomerButton);
    buttons.add(addCustomerButton);
    buttons.add(updateCustomerButton);
    buttons.add(openSavingsAccountButton);
    buttons.add(openCheckingAccountutton);
    buttons.add(depositButton);
    buttons.add(withdrawButton);
    buttons.add(calculateInterestButton);
    buttons.add(clearButton);
    buttons.add(saveSummaryButton);
    buttons.add(loadCustomersButton);
    buttons.add(viewCheckingAccountButton);
    buttons.add(viewSavingsAccountButton);





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
    withdrawButton.addActionListener(e -> withdrawFromSpecifiedSavingsAccountButtonClicked());
    withdrawButton.addActionListener(e -> withdrawFromSpecifiedCheckingAccountButtonClicked());
    calculateInterestButton.addActionListener(e -> calculateInterestButtonClicked());
    clearButton.addActionListener(e -> clear());
    saveSummaryButton.addActionListener(e -> saveButtonPressed());
    viewCheckingAccountButton.addActionListener(e -> viewCheckingAccountButtonClicked());
    viewSavingsAccountButton.addActionListener(e -> viewSavingsAccountButtonClicked());
    openCheckingAccountutton.addActionListener(e -> openCheckingAccountButtonClicked());
    openSavingsAccountButton.addActionListener(e -> openSavingsAccountButtonClicked());
    depositButton.addActionListener(e -> depositIntoSpecifiedCheckingAccountButtonClicked());
    depositButton.addActionListener(e -> depositIntoSpecifiedSavingsAccountButtonClicked());
    loadCustomersButton.addActionListener(e -> loadCustomersButtonClicked());

    for (JButton button : buttons)
    {
      button.setBackground(Color.ORANGE);

    }



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
  private GridBagConstraints getConstraints(int x, int y)
  {
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
   * Allows the Customer to withdraw money from a specified savings account.
   * If no account number matches, the main savings account is subtracted from.
   * If you would like to withdraw from an account, type the account number you'd like to withdraw from.
   * Then, hit the Savings radio button to switch to the savings account. Click the withdraw button.
   */
  private void withdrawFromSpecifiedSavingsAccountButtonClicked()
  {
    String savingAccountNum = accountNumberField.getText();


    for (int i = 0; i < data.get(count).getSavingsAccounts().size(); i++)
    {

      if (data.get(count).getSavingsAccounts().get(i).getAccountNumber().equals(savingAccountNum))
      {
        try
        {
          data.get(count).getSavingsAccounts().get(i).withdraw(Integer.parseInt(withdrawDepositField.getText()));
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
      data.get(count).subSavingsAccBalance(Integer.parseInt(withdrawDepositField.getText()));
      balanceField.setText(data.get(count).getCheckingAccBalance() + "");
    }
  }

  /**
   * Allows the Customer to withdraw money from a specified checking account.
   * If no account number matches, the main checking account is subtracted from.
   */
  private void withdrawFromSpecifiedCheckingAccountButtonClicked()
  {
    String checkingAccountNum = checkingAccountNumberField.getText();


    for (int i = 0; i < data.get(count).getCheckingAccounts().size(); i++)
    {

      if (data.get(count).getCheckingAccounts().get(i).getAccountNumber().equals(checkingAccountNum))
      {
        try
        {
          data.get(count).getCheckingAccounts().get(i).withdraw(Integer.parseInt(withdrawDepositField.getText()));
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
      data.get(count).subCheckingAccountBalance(Integer.parseInt(withdrawDepositField.getText()));
      balanceField.setText(data.get(count).getCheckingAccBalance() + "");
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
    String checkingAccNumber = checkingAccountNumberField.getText();

    for (int i = 0; i < data.size(); i++)
    {
      if ((data.get(i).getFirstName().equals(firstName)) ||
              (data.get(i).getLastName().equals(lastName)) ||
              (data.get(i).getAddress().equals(address)) ||
              (data.get(i).getPhoneNumber().equals(phoneNumber)) ||
              (data.get(i).getAccNumber().equals(accountNumber)) ||
               data.get(i).getCheckingAccNumber().equals(checkingAccNumber))
      {

        String before = data.get(i).getFullName();

        JFrame tmpFrame = new JFrame();
        JTextField msg = new JTextField("Customer updated!");
        JPanel tmpPanel = new JPanel();
        JButton close = new JButton("Click me to close");

        close.addActionListener(event ->   tmpFrame.dispose());

        data.get(i).setFirstName(firstName);
        data.get(i).setLastName(lastName);
        data.get(i).setPhoneNumber(phoneNumber);
        data.get(i).setAddress(address);
        data.get(i).setCheckingAccountNumber(checkingAccNumber);
        data.get(i).setSavingsAccountNumber(accountNumber);

        String after = data.get(i).getFullName();
        msg.setText("Successfully updated " + before + " to " + after + "!");
        msg.setEditable(false);

        tmpPanel.add(close, getConstraints(2, 6));
        tmpPanel.add(msg, getConstraints(2, 5));
        tmpFrame.add(tmpPanel);
        tmpFrame.setPreferredSize(new Dimension(700, 700));
        tmpFrame.pack();
        tmpFrame.setVisible(true);
        break;
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

    JFrame tmpFrame = new JFrame();
    JTextField msg = new JTextField();
    JPanel tmpPanel = new JPanel();
    JButton close = new JButton("Click me to close");

    close.addActionListener(event ->   tmpFrame.dispose());

    msg.setText("Successfully added " + firstName + " " + lastName + "!");
    msg.setEditable(false);

    tmpPanel.add(close, getConstraints(2, 6));
    tmpPanel.add(msg, getConstraints(2, 5));
    tmpFrame.add(tmpPanel);
    tmpFrame.setPreferredSize(new Dimension(700, 700));
    tmpFrame.pack();
    tmpFrame.setVisible(true);
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
   * Helper function to set the text fields.
   */
  private void setTextFields()
  {
    firstNameField.setText(data.get(count).getFirstName());
    lastNameField.setText(data.get(count).getLastName());
    addressField.setText(data.get(count).getAddress());
    phoneNumberField.setText(data.get(count).getPhoneNumber());
    accountNumberField.setText(data.get(count).getAccNumber());
    checkingAccountNumberField.setText(data.get(count).getCheckingAccNumber());
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
    for (JTextField textField : textFields)
    {
      textField.setText("");
    }

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

      for (int i = 0; i < data.size(); i++)
      {
        String checkAcc = "";
        String savingsAcc = "";



        for (int j = 0; j < data.get(i).getSavingsAccounts().size(); j++)
        {
          savingsAcc += "\n\tSavings Account " + data.get(i).getSavingsAccounts().get(j).getAccountNumber() +
                     " with balance " + data.get(i).getSavingsAccounts().get(j).getAccountMoney() + "\n";
        }

        for (int k = 0; k < data.get(i).getCheckingAccounts().size(); k++)
        {
          checkAcc += "\n\tChecking Account " + data.get(i).getCheckingAccounts().get(k).getAccountNumber() +
                  " with balance " + data.get(i).getCheckingAccounts().get(k).getAccountMoney() + "\n";
        }

        writer.write("Customer " + data.get(i).getFullName() + " with savings account balance " +  data.get(i).getSavingsAccBalance() + " with accounts: " + savingsAcc + checkAcc + "\n");
        writer.write("-----------------------------------------------------------------\n");
      }


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
                                      + " with $" + data.get(count).getCheckingAccounts().get(i).getAccountMoney());
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
              + " with $" + data.get(count).getSavingsAccounts().get(i).getAccountMoney());
      tmp.setEditable(false);
      tmpPanel.add(tmp);
    }

    jframe.setPreferredSize(new Dimension(500,500));
    jframe.add(tmpPanel);
    jframe.pack();
    jframe.setVisible(true);
  }

  /**
   * Loads a text file with Customer data into the banking system. Overwrites the original data.
   */
  private void loadCustomersButtonClicked()
  {
    BufferedReader reader;
    ArrayList<Customer> tmpData  = new ArrayList<>();

    try
    {
      reader = new BufferedReader(new FileReader("C:\\Users\\Victor\\IdeaProjects\\BankingApp\\customers_data.txt"));

      String line = reader.readLine();

      while(line != null)
      {
        String[] components = line.split(",");
        String[] firstAndLastName = components[0].split(" ");
        String address = components[1];
        String phoneNum = components[2];
        String savings = components[3];
        String checking = components[4];

        tmpData.add(new Customer(firstAndLastName[0], firstAndLastName[1], address, phoneNum, new SavingsAccount(savings), new CheckingAccount(checking)));
        line = reader.readLine();

      }

      reader.close();
    }
    catch (IOException e)
    {
      System.out.println("Could not read file.");
    }

    data = tmpData;
  }

  /**
   * Opens a new savings account to the current customer.
   */
  private void openSavingsAccountButtonClicked()
  {
    if (accountNumberField.getText().length() == 0) throw new IllegalArgumentException("Must enter a account number");

    for (int i = 0; i < data.get(count).getSavingsAccounts().size(); i++)
    {
      if (accountNumberField.getText().equals(data.get(count).getSavingsAccounts().get(i).getAccountNumber()))
      {
        System.out.println("A savings account with that number already exists.");
        return;
      }
    }

    data.get(count).getSavingsAccounts().add(new SavingsAccount(accountNumberField.getText()));

  }

  /**
   * Adds a new checking account to the current customer.
   */
  private void openCheckingAccountButtonClicked()
  {
    if (checkingAccountNumberField.getText().length() == 0) throw new IllegalArgumentException("Must enter a account number");
    for (int i = 0; i < data.get(count).getCheckingAccounts().size(); i++)
    {
      if (checkingAccountNumberField.getText().equals(data.get(count).getCheckingAccounts().get(i).getAccountNumber()))
      {
        System.out.println("A checking account with that number already exists.");
        return;
      }
    }
    data.get(count).getCheckingAccounts().add(new CheckingAccount(checkingAccountNumberField.getText()));
  }

}

    
