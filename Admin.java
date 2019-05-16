/**
 * Class that allows a user to login to the BankingApp main database to alter customers manually.
 *
 * @author Victor Velea
 * @version 5/15
 */
public class Admin
{
  private String password;
  private String login;
  private String name;

  /**
   * Constructor for an Administrator.
   * @param login The admins login.
   * @param password The admins password.
   * @param name The admins name.
   */
  public Admin(String login, String password, String name)
  {
    this.login = login;
    this.password = password;
    this.name = name;
  }

  /**
   * Gets the admins login.
   * @return the admins login.
   */
  public String getLogin()
  {
    return login;
  }

  /**
   * Gets the admins password.
   * @return the admins password.
   */
  public String getPassword()
  {
    return password;
  }

  /**
   * Gets the admins name.
   * @return admins name.
   */
  public String getName()
  {
    return name;
  }

}
