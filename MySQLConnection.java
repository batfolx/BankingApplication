import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class MySQLConnection
{

  public static final String dbUrl = "jdbc:mysql://localhost:3306/customers?serverTimezone=UTC";
  public static final String username = "root";
  public static final String password = getPassword();


  public static void main(String[] args)
  {


    try
    {
      //grab a connection form the database...

      Connection myConnection = DriverManager.getConnection(dbUrl, username, password);
      //create statement object...

      Statement myStatement = myConnection.createStatement();

      ResultSet myResultSet=myStatement.executeQuery("Select * from customers");


      //process result set...

      while (myResultSet.next())
      {
        System.out.println("Customer info " + myResultSet.getString("firstName") + " " + myResultSet.getString( "lastName"));

      }



    }
    catch (Exception ig) {
      ig.printStackTrace();
      ig.printStackTrace();
    }
  }

  public static String getPassword()
  {
      BufferedReader reader;
      String pword = "";

      try
      {
          reader = new BufferedReader(new FileReader(".info.txt"));
          pword = reader.readLine();
          reader.close();
      }
      catch(Exception e)
      {}

      return pword;
  }


}
