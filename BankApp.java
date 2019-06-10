import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

/**
 * Bank application class that simulates a real banking application.
 * There is a GUI and interactive features with this application.
 *
 * @author Victor Velea
 * @version 5/15
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
  private JTextField loginField;
  private JTextField passwordField;

  private JButton searchCustomerButton;
  private JButton previousCustomerButton;
  private JButton nextCustomerButton;
  private JButton addCustomerButton;
  private JButton updateCustomerButton;
  private JButton openSavingsAccountButton;
  private JButton openCheckingAccountButton;
  private JButton depositButton;
  private JButton withdrawButton;
  private JButton calculateInterestButton;
  private JButton clearButton;
  private JButton saveSummaryButton;
  private JButton loadCustomersButton;
  private JButton viewSavingsAccountButton;
  private JButton viewCheckingAccountButton;
  private JButton transactionButton;
  private JButton logoutButton;

  private JRadioButton savingsRadioButton;
  private JRadioButton checkingRadioButton;

  private Map<String, Customer> loginInfo;

  private ArrayList<Customer> data;
  private List<JTextField> textFields;
  private List<JButton> buttons;
  private List<Admin> administrators;
  private List<String> transactions;


  private int count = 0;

  private boolean isSavings = true;

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
   transactions = new ArrayList<>();
   loginInfo = new HashMap<>();
   administrators = new ArrayList<>();
   administrators.add(new Admin("potpie", "chicken", "Victor"));
   data = loadCustomersButtonClicked();
   //fillMap();
   startLoginPage();

  }


  private void startLoginPage()
  {
    JFrame loginFrame = new JFrame();
    JPanel loginPanel = new JPanel();

    loginPanel.setLayout(new GridBagLayout());

    JTextField loginField = new JTextField();
    JTextField passwordField = new JTextField();

    loginFrame.setPreferredSize(new Dimension(500,500));
    loginFrame.pack();


    JLabel loginLabel = new JLabel("Login: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JButton enterButton = new JButton("Enter");

    loginField.setPreferredSize(new Dimension(100, 25));
    passwordField.setPreferredSize(new Dimension(100,25));
    loginPanel.add(enterButton, getConstraints(5, 6));
    loginPanel.add(loginField, getConstraints(5, 1));
    loginPanel.add(passwordField, getConstraints(5, 2));
    loginPanel.add(loginLabel, getConstraints(4, 1));
    loginPanel.add(passwordLabel, getConstraints(4, 2));

    loginFrame.add(loginPanel);
    loginFrame.setVisible(true);
    enterButton.addActionListener(event ->
    {
      for (Admin admin : administrators)
      {
        if (loginField.getText().equals(admin.getLogin()) && passwordField.getText().equals(admin.getPassword()))
        {
          loginFrame.dispose();
          initComponents(admin);
          setTextFields();
          return;
        }
      }

      for (Customer customer : loginInfo.values())
      {
        if (customer.getLogin().equals(loginField.getText()) && customer.getPassword().equals(passwordField.getText()))
        {
          loginFrame.dispose();
          onLoginButtonPressed(customer);
          return;
        }
      }

      System.out.println("Could not find customer!");
    });
  }

  /**
   * Initializes the components for the banking application.
   * This is the GUI. The rest takes care of everything.
   */
  private void initComponents(Admin admin) {
    setTitle("Welcome, " + admin.getName() + ".");
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
    loginField = new JTextField();
    passwordField = new JTextField();

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
    textFields.add(loginField);
    textFields.add(passwordField);

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
    openCheckingAccountButton = new JButton("Open Checking Account");
    depositButton = new JButton("deposit");
    withdrawButton = new JButton("withdraw");
    calculateInterestButton = new JButton("Calculate Interest");
    clearButton = new JButton("Clear fields");
    saveSummaryButton = new JButton("Summary report");
    loadCustomersButton = new JButton("Load customers");
    viewCheckingAccountButton = new JButton("View Checking Accounts");
    viewSavingsAccountButton = new JButton("View Savings Account");
    transactionButton = new JButton("View Transaction History");
    logoutButton = new JButton("Logout");

    // adds all the buttons to the List of buttons
    // for visual purposes
    buttons.add(searchCustomerButton);
    buttons.add(previousCustomerButton);
    buttons.add(nextCustomerButton);
    buttons.add(addCustomerButton);
    buttons.add(updateCustomerButton);
    buttons.add(openSavingsAccountButton);
    buttons.add(openCheckingAccountButton);
    buttons.add(depositButton);
    buttons.add(withdrawButton);
    buttons.add(calculateInterestButton);
    buttons.add(clearButton);
    buttons.add(saveSummaryButton);
    buttons.add(loadCustomersButton);
    buttons.add(viewCheckingAccountButton);
    buttons.add(viewSavingsAccountButton);
    buttons.add(transactionButton);
    buttons.add(logoutButton);


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
    panel.add(openCheckingAccountButton, getConstraints(3,4));
    panel.add(openSavingsAccountButton, getConstraints(3, 5));
    panel.add(transactionButton, getConstraints(5, 5));
    panel.add(logoutButton, getConstraints(6,6));

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
    openCheckingAccountButton.addActionListener(e -> openCheckingAccountButtonClicked());
    openSavingsAccountButton.addActionListener(e -> openSavingsAccountButtonClicked());
    depositButton.addActionListener(e -> depositIntoSpecifiedCheckingAccountButtonClicked());
    depositButton.addActionListener(e -> depositIntoSpecifiedSavingsAccountButtonClicked());
    loadCustomersButton.addActionListener(e -> loadCustomersButtonClicked());
    logoutButton.addActionListener(event ->
            {
              startLoginPage();
              dispose();
            });
    transactionButton.addActionListener(e -> transactionButtonClicked());

    for (JButton button : buttons)
    {
      button.setBackground(Color.CYAN);

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
    panel.add(new JLabel("Login: "), getConstraints(2, 1));
    panel.add(loginField, getConstraints(3,2));
    panel.add(new JLabel("Password: "), getConstraints(2, 3));
    panel.add(loginField, getConstraints(3,4));

    JPanel interest =  new JPanel();

    interest.add(interestMonthField, getConstraints(1, 11));
    interest.add(new JLabel("Calculated Interest:"), getConstraints(1, 11));
    interest.add(calculatedInterestField, getConstraints(2, 11));
    interest.add(new JLabel(""), getConstraints(0, 9));
    //panel.add(calculatedInterestField, getConstraints(1, 9));


    add(sizePanel, BorderLayout.NORTH);
    add(interest, BorderLayout.SOUTH);
    add(panel, BorderLayout.CENTER);
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
          int oldBalance =  data.get(count).getCheckingAccounts().get(i).getAccountMoney();
          data.get(count).getCheckingAccounts().get(i).deposit(Integer.parseInt(withdrawDepositField.getText()));
          transactions.add("Customer " + data.get(count).getFullName() +  " deposited $" + withdrawDepositField.getText() + " from "
                  + data.get(count).getCheckingAccounts().get(i).getAccountNumber() + " checking account.\n"
                  + "Old balance was " + oldBalance + ". New balance is $" + data.get(count).getCheckingAccounts().get(i).getAccountMoney());
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
      int oldBalance =  data.get(count).getCheckingAccBalance();
      data.get(count).addCheckingAccBalance(Integer.parseInt(withdrawDepositField.getText()));
      balanceField.setText(data.get(count).getCheckingAccBalance() + "");
      transactions.add("Customer " + data.get(count).getFullName() +  " deposited $" + withdrawDepositField.getText() + " from main savings account.\n"
              + "Old balance was $" + oldBalance + ". New balance is $" + data.get(count).getCheckingAccBalance());
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
          int oldBalance =  data.get(count).getSavingsAccounts().get(i).getAccountMoney();
          data.get(count).getSavingsAccounts().get(i).deposit(Integer.parseInt(withdrawDepositField.getText()));
          transactions.add("Customer " + data.get(count).getFullName() +  " deposited $" + withdrawDepositField.getText() + " from "
                  + data.get(count).getSavingsAccounts().get(i).getAccountNumber() + " savings account.\n"
                  + "Old balance was " + oldBalance + ". New balance is $" + data.get(count).getSavingsAccounts().get(i).getAccountMoney());
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
      int oldBalance =  data.get(count).getSavingsAccBalance();
      data.get(count).addSavingsAccBalance(Integer.parseInt(withdrawDepositField.getText()));
      balanceField.setText(data.get(count).getSavingsAccBalance() + "");
      transactions.add("Customer " + data.get(count).getFullName() +  " deposited $" + withdrawDepositField.getText() + " from main savings account.\n"
              + "Old balance was $" + oldBalance + ". New balance is $" + data.get(count).getSavingsAccBalance());
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
          int oldBalance =  data.get(count).getSavingsAccounts().get(i).getAccountMoney();
          data.get(count).getSavingsAccounts().get(i).withdraw(Integer.parseInt(withdrawDepositField.getText()));
          transactions.add("Customer " + data.get(count).getFullName() +  " withdraw $" + withdrawDepositField.getText() + " from "
                  + data.get(count).getSavingsAccounts().get(i).getAccountNumber() + " savings account.\n"
                  + "Old balance was " + oldBalance + ". New balance is $" + data.get(count).getSavingsAccounts().get(i).getAccountMoney());
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
      int oldBalance =  data.get(count).getSavingsAccBalance();
      data.get(count).subSavingsAccBalance(Integer.parseInt(withdrawDepositField.getText()));
      balanceField.setText(data.get(count).getSavingsAccBalance() + "");
      transactions.add("Customer " + data.get(count).getFullName() +  " withdraw $" + withdrawDepositField.getText() + " from main savings account.\n"
              + "Old balance was $" + oldBalance + ". New balance is $" + data.get(count).getSavingsAccBalance());
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
          int oldBalance =  data.get(count).getCheckingAccounts().get(i).getAccountMoney();
          data.get(count).getCheckingAccounts().get(i).withdraw(Integer.parseInt(withdrawDepositField.getText()));
          transactions.add("Customer " + data.get(count).getFullName() +  " withdraw $" + withdrawDepositField.getText() + " from "
                  + data.get(count).getCheckingAccounts().get(i).getAccountNumber() + " checking account.\n"
                  + "Old balance was " + oldBalance + ". New balance is $" + data.get(count).getCheckingAccounts().get(i).getAccountMoney());


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
      int oldBalance = data.get(count).getCheckingAccBalance();
      data.get(count).subCheckingAccountBalance(Integer.parseInt(withdrawDepositField.getText()));
      balanceField.setText(data.get(count).getCheckingAccBalance() + "");
      transactions.add("Customer " + data.get(count).getFullName() +  " withdraw $" + withdrawDepositField.getText() + " from main savings account.\n"
                    + "Old balance was $" + oldBalance + ". New balance is $" + data.get(count).getCheckingAccBalance());
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
        transactions.add("Customer was successfully updated from " + before + " to " + data.get(i).getFullName());
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
    String login = loginField.getText();
    String password = passwordField.getText();
    Customer temp = new Customer(firstName, lastName, address, phoneNumber, new SavingsAccount(accountNumber), new CheckingAccount(accountNumber), login, password);
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

    transactions.add("Customer " + firstName + " " + lastName + " was added to the database.");
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

    if (isSavings)
    {
      balanceField.setText(data.get(count).getSavingsAccBalance() + "");
    }
    else
    {
      balanceField.setText(data.get(count).getCheckingAccBalance()+ "");
    }
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
                     " with balance $" + data.get(i).getSavingsAccounts().get(j).getAccountMoney() + "\n";
        }

        for (int k = 0; k < data.get(i).getCheckingAccounts().size(); k++)
        {
          checkAcc += "\n\tChecking Account " + data.get(i).getCheckingAccounts().get(k).getAccountNumber() +
                  " with balance $" + data.get(i).getCheckingAccounts().get(k).getAccountMoney() + "\n";
        }

        writer.write("Customer " + data.get(i).getFullName() + "\nMain savings account balance $" +  data.get(i).getSavingsAccBalance()
                 + ".\nMain checking account balance $" + data.get(i).getCheckingAccBalance() + ".\nSub-accounts: " + savingsAcc + checkAcc + "\n");
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
  private ArrayList<Customer> loadCustomersButtonClicked()
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

        tmpData.add(new Customer(firstAndLastName[0], firstAndLastName[1], address, phoneNum, new SavingsAccount(savings), new CheckingAccount(checking), firstAndLastName[0], firstAndLastName[1]));
        line = reader.readLine();

      }

      reader.close();
    }
    catch (IOException e)
    {
      System.out.println("Could not read file.");
    }

    data = tmpData;
    fillMap();
    return tmpData;

  }

  /**
   * Opens a new savings account to the current customer.
   * If a savings account exists with that number, an error message is displayed.
   */
  private void openSavingsAccountButtonClicked()
  {
    if (accountNumberField.getText().length() == 0) throw new IllegalArgumentException("Must enter a account number");

    for (int i = 0; i < data.get(count).getSavingsAccounts().size(); i++)
    {
      if (accountNumberField.getText().equals(data.get(count).getSavingsAccounts().get(i).getAccountNumber()))
      {
        JFrame tmpFrame = new JFrame();
        JTextField errorMsg = new JTextField("A savings account with that number already exists.");
        JPanel tmpPanel = new JPanel();
        JButton exitButton = new JButton("Click me to close");

        exitButton.addActionListener(event -> tmpFrame.dispose());

        tmpPanel.add(exitButton);
        tmpPanel.add(errorMsg);
        tmpFrame.add(tmpPanel);

        tmpFrame.setPreferredSize(new Dimension(500, 500));
        tmpFrame.pack();
        tmpFrame.setVisible(true);
        return;
      }
    }

    data.get(count).getSavingsAccounts().add(new SavingsAccount(accountNumberField.getText()));
    transactions.add("New checking account was opened for " + data.get(count).getFullName() + ". Savings account number " + checkingAccountNumberField.getText());
  }

  /**
   * Adds a new checking account to the current customer.
   * If a savings account exists with that number, an error message is displayed.
   */
  private void openCheckingAccountButtonClicked()
  {
    if (checkingAccountNumberField.getText().length() == 0) throw new IllegalArgumentException("Must enter a account number");
    for (int i = 0; i < data.get(count).getCheckingAccounts().size(); i++)
    {
      if (checkingAccountNumberField.getText().equals(data.get(count).getCheckingAccounts().get(i).getAccountNumber()))
      {
        JFrame tmpFrame = new JFrame();
        JTextField errorMsg = new JTextField("A checking account with that number already exists.");
        JPanel tmpPanel = new JPanel();
        JButton exitButton = new JButton("Click me to close");

        exitButton.addActionListener(event -> tmpFrame.dispose());


        tmpPanel.add(exitButton);
        tmpPanel.add(errorMsg);
        tmpFrame.add(tmpPanel);

        tmpFrame.setPreferredSize(new Dimension(500, 500));
        tmpFrame.pack();
        tmpFrame.setVisible(true);
        return;
      }
    }
    data.get(count).getCheckingAccounts().add(new CheckingAccount(checkingAccountNumberField.getText()));
    transactions.add("New checking account was opened for " + data.get(count).getFullName() + ". Checking account number " + checkingAccountNumberField.getText());
  }

  /**
   * Opens a log of transactions between customers and their associated accounts.
   */
  private void transactionButtonClicked()
  {
    JFrame transactionHistoryFrame = new JFrame();
    JPanel tmpPanel = new JPanel();

    for (String history : transactions)
    {
      JFormattedTextField transactionHistory = new JFormattedTextField(history);
      transactionHistory.setEditable(false);
      transactionHistory.setPreferredSize(new Dimension(700, 25));
      tmpPanel.add(transactionHistory);
    }

    transactionHistoryFrame.add(tmpPanel);
    transactionHistoryFrame.setPreferredSize(new Dimension(800,800));

    transactionHistoryFrame.pack();
    transactionHistoryFrame.setVisible(true);
  }

  /**
   * Fills the Map object with customers' first names as the key
   * and the associated Customer object as the value.
   */
  private void fillMap()
  {
    for (Customer customer: data)
    {
      System.out.println(customer.getFullName());
      loginInfo.put(customer.getFirstName(), customer);
    }
  }

  /**
   * Brings up the information for this particular customer.
   * @param customer the customer to be filled out.
   */
  private void onLoginButtonPressed(Customer customer)
  {

    ButtonGroup radioButtonGroup = new ButtonGroup();

    JButton depositLocalButton = new JButton("Deposit");
    JButton withdrawLocalButton = new JButton("Withdraw");
    JButton openCheckingAccountLocalButton = new JButton("Open Checking Account");
    JButton openSavingsAccountLocalButton = new JButton("Open Savings Account");
    JButton viewSavingsAccountLocalButton = new JButton("View Savings Accounts");
    JButton viewCheckingAccountLocalButton = new JButton("View Checking Accounts");
    JButton logoutButton = new JButton("Logout");

    JTextField balanceLocalField = new JTextField();
    balanceLocalField.setPreferredSize(new Dimension(100,25));
    balanceLocalField.setEditable(false);
    JTextField withdrawDepositLocalField = new JTextField();
    withdrawDepositLocalField.setPreferredSize(new Dimension(100, 25));
    JTextField savingsAccountLocalNumberField = new JTextField();
    savingsAccountLocalNumberField.setPreferredSize(new Dimension(100, 25));
    JTextField checkingAccountLocalNumberField = new JTextField();
    checkingAccountLocalNumberField.setPreferredSize(new Dimension(100, 25));

    JRadioButton checkingAccountRadioButton = new JRadioButton("Checking");
    JRadioButton savingsAccountRadioButton = new JRadioButton("Savings");
    savingsAccountRadioButton.setSelected(true);

    JLabel welcome = new JLabel("Welcome, " + customer.getFirstName() + ".");
    JPanel tmpPanel = new JPanel();
    tmpPanel.setLayout(new GridBagLayout());

    JFrame customerFrame = new JFrame();
    customerFrame.setResizable(true);

    tmpPanel.add(new JLabel("Balance"), getConstraints(0, 3));
    tmpPanel.add(balanceLocalField, getConstraints(1,3));
    tmpPanel.add(new JLabel("Withdraw/Deposit"), getConstraints(0, 2));
    tmpPanel.add(withdrawDepositLocalField, getConstraints(1, 2));
    tmpPanel.add(new JLabel("Savings account number"), getConstraints(0,4));
    tmpPanel.add(savingsAccountLocalNumberField, getConstraints(1,4));
    tmpPanel.add(new JLabel("Checking account number"), getConstraints(0, 5));
    tmpPanel.add(checkingAccountLocalNumberField, getConstraints(1,5));

    tmpPanel.add(depositLocalButton, getConstraints(3, 4));
    tmpPanel.add(withdrawLocalButton,getConstraints(3,3));

    tmpPanel.add(viewCheckingAccountLocalButton, getConstraints(3 ,2));
    tmpPanel.add(viewSavingsAccountLocalButton, getConstraints(3, 1));



    tmpPanel.add(welcome, getConstraints(1, 100));

    tmpPanel.add(openSavingsAccountLocalButton);
    tmpPanel.add(openCheckingAccountLocalButton);
    tmpPanel.add(logoutButton, getConstraints(5, 10));


    radioButtonGroup.add(checkingAccountRadioButton);
    radioButtonGroup.add(savingsAccountRadioButton);

    tmpPanel.add(checkingAccountRadioButton, getConstraints(1, 1));
    tmpPanel.add(savingsAccountRadioButton, getConstraints(0, 1));
    logoutButton.addActionListener(event ->
    {
      customerFrame.dispose();

      startLoginPage();
    });
    viewSavingsAccountLocalButton.addActionListener(event -> viewSavingsAccountButtonClicked(customer));
    viewCheckingAccountLocalButton.addActionListener(event -> viewCheckingAccountButtonClicked(customer));
    openCheckingAccountLocalButton.addActionListener(event ->
    {
      for (int i = 0; i < customer.getCheckingAccounts().size(); i++)
      {
        if (checkingAccountLocalNumberField.getText().equals(customer.getCheckingAccounts().get(i).getAccountNumber()))
        {
          System.out.println("Checking already exists");
          return;
        }
      }

      customer.addCheckingAccount(new CheckingAccount(checkingAccountLocalNumberField.getText()));

    });


    openSavingsAccountLocalButton.addActionListener(event ->
    {
      for (int i = 0; i < customer.getSavingsAccounts().size(); i++)
      {
        if (savingsAccountLocalNumberField.getText().equals(customer.getSavingsAccounts().get(i).getAccountNumber()))
        {
          System.out.println("Savings already exists");
          return;
        }
      }

      customer.addSavingsAccount(new SavingsAccount(savingsAccountLocalNumberField.getText()));
    });


    savingsAccountRadioButton.addActionListener(e -> isSavings = true);
    checkingAccountRadioButton.addActionListener(e -> isSavings = false);

    withdrawLocalButton.addActionListener(event ->
    {
      if (isSavings)
      {

        for (int i = 0; i < customer.getSavingsAccounts().size(); i++)
        {
          if (savingsAccountLocalNumberField.getText().equals(customer.getSavingsAccounts().get(i).getAccountNumber()))
          {
            customer.getSavingsAccounts().get(i).withdraw(Integer.parseInt(withdrawDepositLocalField.getText()));
            balanceLocalField.setText(customer.getSavingsAccounts().get(i).getAccountMoney() + "");
            return;
          }
        }
        customer.subSavingsAccBalance(Integer.parseInt(withdrawDepositLocalField.getText()));
        balanceLocalField.setText(customer.getSavingsAccBalance() + "");
      }
      else
      {
        for (int i = 0; i < customer.getCheckingAccounts().size(); i++)
        {
          if (checkingAccountLocalNumberField.getText().equals(customer.getCheckingAccounts().get(i).getAccountNumber()))
          {
            customer.getCheckingAccounts().get(i).withdraw(Integer.parseInt(withdrawDepositLocalField.getText()));
            balanceLocalField.setText(customer.getCheckingAccounts().get(i).getAccountMoney() + "");
            return;
          }
        }
        customer.subCheckingAccountBalance(Integer.parseInt(withdrawDepositLocalField.getText()));
        balanceLocalField.setText(customer.getCheckingAccBalance() + "");
      }

    });


    depositLocalButton.addActionListener(event ->
    {

      if (isSavings)
      {

        for (int i = 0; i < customer.getSavingsAccounts().size(); i++)
        {
          if (savingsAccountLocalNumberField.getText().equals(customer.getSavingsAccounts().get(i).getAccountNumber()))
          {
            customer.getSavingsAccounts().get(i).deposit(Integer.parseInt(withdrawDepositLocalField.getText()));
            balanceLocalField.setText(customer.getSavingsAccounts().get(i).getAccountMoney() + "");
            return;
          }
        }
        customer.addSavingsAccBalance(Integer.parseInt(withdrawDepositLocalField.getText()));
        balanceLocalField.setText(customer.getSavingsAccBalance() + "");
      }
      else
      {
        for (int i = 0; i < customer.getCheckingAccounts().size(); i++)
        {
          if (checkingAccountLocalNumberField.getText().equals(customer.getCheckingAccounts().get(i).getAccountNumber()))
          {
            customer.getCheckingAccounts().get(i).deposit(Integer.parseInt(withdrawDepositLocalField.getText()));
            balanceLocalField.setText(customer.getCheckingAccounts().get(i).getAccountMoney() + "");
            return;
          }
        }
        customer.addCheckingAccBalance(Integer.parseInt(withdrawDepositLocalField.getText()));
        balanceLocalField.setText(customer.getCheckingAccBalance() + "");

      }

    });

    customerFrame.setPreferredSize(new Dimension(800, 800));
    customerFrame.add(tmpPanel);
    customerFrame.pack();
    customerFrame.setVisible(true);

  }

  /**
   * Views the checking accounts for the specific customer.
   * @param customer the customers checking accounts to be views.
   */
  private void viewCheckingAccountButtonClicked(Customer customer)
  {
    JFrame jframe = new JFrame("Checking Accounts for customer " + customer.getFullName());
    JPanel tmpPanel = new JPanel();
    for (int i = 0; i < customer.getCheckingAccounts().size(); i++)
    {
      JTextField tmp = new JTextField("Checking Account Number " + customer.getCheckingAccounts().get(i).getAccountNumber()
              + " with $" + customer.getCheckingAccounts().get(i).getAccountMoney());
      tmp.setEditable(false);
      tmpPanel.add(tmp);
    }

    jframe.setPreferredSize(new Dimension(500,500));
    jframe.add(tmpPanel);
    jframe.pack();
    jframe.setVisible(true);
  }

  /**
   * Views the savings accounts for the specific customer.
   * @param customer the customer to be viewed.
   */
  private void viewSavingsAccountButtonClicked(Customer customer)
  {

    JFrame jframe = new JFrame("Savings Accounts for customer " + customer.getFullName());
    JPanel tmpPanel = new JPanel();
    for (int i = 0; i < customer.getSavingsAccounts().size(); i++)
    {
      JTextField tmp = new JTextField("Savings Account Number " + customer.getSavingsAccounts().get(i).getAccountNumber()
              + " with $" + customer.getSavingsAccounts().get(i).getAccountMoney());
      tmp.setEditable(false);
      tmpPanel.add(tmp);
    }

    jframe.setPreferredSize(new Dimension(500,500));
    jframe.add(tmpPanel);
    jframe.pack();
    jframe.setVisible(true);
  }
}

    
