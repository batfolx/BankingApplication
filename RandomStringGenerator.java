import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomStringGenerator
{

  /**
   *
   * @param amountOfCustomers amount of customers to be added to the data file.
   * @param append if you want to append to the existing data file or not.
   */
  public static void generateTextFile(int amountOfCustomers, boolean append)
  {
    BufferedWriter writer;

    try
    {
      writer = new BufferedWriter(new FileWriter("customers_data.txt", append));

      for (int i = 0; i < amountOfCustomers; i++)
      {
        writer.write(generateString() + "\n");
      }

      writer.close();

    }

    catch(IOException e)
    {}
  }

  /**
   * Generates a random customer string for testing purposes.
   * @return the customer as a String representation.
   */
  private static String generateString()
  {
    Random r = new Random();
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String nums = "1234567890";

    String[] firstNames = {"John", "Becky", "Chris", "Kaitlyn", "Jorge", "Nicole", "Tyler", "Victor", "Quincy", "Joseph", "Fenix",
                           "Puppy", "Jie", "Ron", "Moe", "Domino", "Flynn", "Jacob", "Jackson", "Allie", "Ally", "Sean", "Adam",
                           "ChickenPotPie", "Jesus", "God", "Juicy", "GoldenDoubloons", "Frenchie", "Yeet", "Pepperoni", "Asus",
                           "Ash", "Jax", "Singed", "Jarvan IV", "Garen", "Aatrox", "Annie", "Nami", "Sejuani", "Knix", "Nocturne"};

    String[] lastNames = {"Smith", "Jones", "Brown", "Miller", "Davis", "King", "Bones", "Davis", "Burger King", "Ross", "MacPhearson",
                           "My wife left me", "Lee", "Lopez", "Rivera", "Baker", "Baily", "White", "Harris", "Anderson", "Quimper",
                            "Parker", "Edwards", "Lewis", "Garcia", "Martinez", "Mister", "Foster", "Flores", "Washington", "McDonalds",
                           "Burger King Foot Lettuce"};

    String[] streetNames = {"Miller Court", "Street", "Avenue", "Boulevard", "Corner", "Cul De Sac", "Road", "Drive", "Park", "Parkway"};



    String all = alphabet + nums;
    String customer = "";
    String randomFirstName = "";
    String randomLastName = "";
    String address = "";
    String checkingAcc = "";
    String savingsAcc = "";
    String pNumber = "";

    randomFirstName = firstNames[r.nextInt(firstNames.length - 1)];
    randomLastName = lastNames[r.nextInt(lastNames.length-1)];

    String fullName = randomFirstName + " " +  randomLastName ;


    while (address.length() < 5)
    {
      address += nums.charAt(r.nextInt(nums.length()));
    }

    address += " " + lastNames[r.nextInt(lastNames.length-1)] + " " + streetNames[r.nextInt(streetNames.length-1)];

    while (checkingAcc.length() < 5)
    {
      checkingAcc += nums.charAt(r.nextInt(nums.length()));
      savingsAcc += nums.charAt(r.nextInt(nums.length()));
      pNumber += nums.charAt(r.nextInt(nums.length())) + "2";
    }

    customer = fullName + "," + address + "," + pNumber + "," + savingsAcc + "," + checkingAcc;


    return customer;


  }


}
