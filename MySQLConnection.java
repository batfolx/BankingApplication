import java.sql.*;

public class MySQLConnection
{
  public static void main(String[] args)
  {
    try
    {
      String dbUrl = "jdbc:mysql://localhost:3306/customers";
      String username = "debian-sys-maint";
      String password =  "nRk7FUG4xz06yocK";

      //grab a connection form the database...

      Connection myConnection = DriverManager.getConnection(dbUrl, username, password);
      System.out.println("hehe");
      //create statement object...

      Statement myStatement = myConnection.createStatement();

      ResultSet myResultSet=myStatement.executeQuery("Select * from custs");


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
}
