package owner.util;
import java.util.List;

import java.util.Scanner;



import java.util.ArrayList;
import java.util.logging.Logger;

public class Tenant {
  private static final Logger logger = Logger.getLogger(Admindashboard.class.getName());

  private String name;
  private String phoneNumber;
  private String bankCard;
  private String email;
  private String password;
  public static List<House> availableHouses;
  public List<House> HousesAfterRemove  = new ArrayList<>();;  
  private List<Furniture> advertisedFurniture;
  public int houseId;

  private List<House> ownedHouses;
   public static boolean tenancheck1 =false ;
  static Scanner scanner = new Scanner(System.in);
  List<House> availableHousesCopy = new ArrayList<>();
  public static boolean Remove ;
  public Tenant(String name, String phoneNumber, String bankCard, String email, String password) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.bankCard = bankCard;
    this.email = email;
    this.password = password;
    this.availableHouses = new ArrayList<>();
    this.advertisedFurniture = new ArrayList<>();
    this.ownedHouses = new ArrayList<>();
  }

  public Tenant() {
	// TODO Auto-generated constructor stub
}

public void updatePhoneNumber(String newPhoneNumber) {
    this.phoneNumber = newPhoneNumber;
  }

  public void updateBankCard(String newBankCard) {
    this.bankCard = newBankCard;
  }

  public void updateEmail(String newEmail) {
    this.email = newEmail;
  }

  public void updatePassword(String newPassword) {
    this.password = newPassword;
  }

  public void addHouse(House house, boolean rented) {
      house.setRented(rented);
      availableHouses.add(house);
      ownedHouses.add(house);
  }
  public void addAdvertisedFurniture(Furniture furniture) {
    advertisedFurniture.add(furniture);
  }

  public List<Furniture> getAdvertisedFurniture() {
    return advertisedFurniture;
  }

  public void addFurniture(Furniture furniture) {
    advertisedFurniture.add(furniture);
  }

  public boolean removeFurnitureByName(String name) {
    for (Furniture furniture : advertisedFurniture) {
      if (furniture.getName().equalsIgnoreCase(name)) {
        advertisedFurniture.remove(furniture);
        return true;
      }
    }
    return false;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getBankCard() {
    return bankCard;
  } 

  public void setBankCard(String bankCard) {
    this.bankCard = bankCard;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  public void viewOwnedHouses() {
      logger.info("Owned Houses:");
      for (House house : ownedHouses) {
          logger.info("House Name: " + house.getName());
          logger.info("Description: " + house.getDescription());
          logger.info("Price: " + house.getPrice());
          logger.info("Location: " + house.getLocation());
          logger.info("Services: " + house.getServices());
          logger.info("-------------------------");
      }
  }
  public static void displayDashboard() {
    Tenant activeTenant = null; // Initialize activeTenant variable
    
    // Create multiple tenant instances to simulate different tenants logging in
    Tenant tenant1 = new Tenant("laila", "123456789", "1234 5678 3456", "laila@com", "123");

    tenant1.addHouse(new House(1,1, "house 1", "description", 2000, "nablus", "Services 1"), true);
    tenant1.addHouse(new House(2,1, "House 2", "description", 1500, "nablus", "Services 2"), false);
    tenant1.addHouse(new House(3,1, "House 3", "description", 1500, "nablus", "Services 3"), false);
    boolean isLoggedIn = true;
    tenancheck1=true;
    while (isLoggedIn) {
    

      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          activeTenant = tenant1; // Set the active tenant to tenant1 or tenant2
          if (activeTenant != null) {
            activeTenant.bookAccommodation();
          } else {
            logger.info("Please log in to book accommodation.");
          }
          break;
        case 2:
          activeTenant = tenant1; // Set the active tenant to tenant1 or tenant2
          if (activeTenant != null) {
            activeTenant.showFurniture();
          } else {
            logger.info("Please log in to view furniture.");
          }
          break;
        case 3:
          activeTenant = tenant1; // Set the active tenant to tenant1 or tenant2
          if (activeTenant != null) {
            activeTenant.viewProfile();
          } else {
            logger.info("Please log in to view your profile.");
          }
          break;
        case 4:

          logger.info("Logged out successfully");
          isLoggedIn = false;
          break;
        case 5:
            activeTenant.viewOwnedHouses(); // View owned houses added by the tenant
            break;
        default:
          logger.info("Invalid choice!");
          break;
      }

      // After logging out, go back to the username and password page
//      if (!isLoggedIn) {
//        username.main(null);
//      }
    }
  }
  // Rest of the code...

  public void showFurniture() {
    logger.info("Welcome to your furniture view...");
    logger.info("1 - Showing advertised furniture");
    logger.info("2 - Advertise furniture");
    logger.info("3 - Go back to Dashboard menu");
    logger.info("4 - Log out from the system");
    boolean isLoggedIn2 = true;

    while (isLoggedIn2) {
      try (Scanner scanner = new Scanner(System.in)) {
        int choice = scanner.nextInt();

        switch (choice) {
          case 1:
            showFurniture1();
            break;
          case 2:
            advertiseFurniture();
            break;
          case 3:
            // Go back to the main menu
            displayDashboard();
            break;
          case 4:
            // Log out
            logger.info("Logged out successfully");
            isLoggedIn2=false;
            break;
          default:
            logger.info("Invalid choice!");
            break;
        }
      }
    }
  }

  public void addRentedHouse(String houseName) {
    for (House house : availableHouses) {
      if (house.getName().equalsIgnoreCase(houseName)) {
        house.setRented(true);
        break;
      }
    }
  }

  public void showFurniture1() {

    logger.info("Showing advertised furniture...");
    logger.info("1 - Go back to Dashboard menu");
    for (Furniture furniture : advertisedFurniture) {
      logger.info("Name: " + furniture.getName());
      logger.info("Description: " + furniture.getDescription());
      logger.info("Price: " + furniture.getPrice());
      logger.info("-------------------------");
    }

    try (Scanner scanner = new Scanner(System.in)) {
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          showFurniture();
          break;
        default:
          logger.info("Invalid input");
          break;
      }
    }
  }
 public int checkbill(int numberOfMounth , int cost ) {
	 int rentAmount = cost * numberOfMounth;
	return rentAmount;
	 
 }
  public void advertiseFurniture() {
    Scanner scanner = new Scanner(System.in);
    scanner = new Scanner(System.in);

    logger.info("Enter furniture details:");
    logger.info("Name: ");
    String name = scanner.nextLine();

    logger.info("Description: ");
    String description = scanner.nextLine();

    logger.info("Price: ");
    double price = scanner.nextDouble();

    Furniture furniture = new Furniture(name, description, price);
    addFurniture(furniture);

    logger.info("Furniture advertised successfully!");
    logger.info("1 -Go back to Dashboard menu");
    logger.info("2 - Add more advertised furniture");
    logger.info("3 - Remove advertised furniture");
    int choice = scanner.nextInt();

    switch (choice) {
      case 1:
        showFurniture();
        break;
      case 2:
        advertiseFurniture();
        break;
      case 3:
        removeFurniture();
        break;
      default:
        logger.info("Invalid input");
        break;
    }
  }

  public void removeFurniture() {
    Scanner scanner = new Scanner(System.in);
    logger.info("Enter the name of the furniture to remove:");
    String name = scanner.nextLine();

    boolean removed = removeFurnitureByName(name);
    if (removed) {
      logger.info("Furniture removed successfully!");
    } else {
      logger.info("Furniture not found!");
    }

    logger.info("1 - Go back to Dashboard menu");
    logger.info("2 - Add more advertised furniture");

    int choice = scanner.nextInt();

    switch (choice) {
      case 1:
        showFurniture();
        break;
      case 2:
        advertiseFurniture();
        break;
      default:
        logger.info("Invalid input");
        break;
    }
  }

  public void bookAccommodation() {
    Scanner scanner = new Scanner(System.in);

    logger.info("Booking accommodation...");

    logger.info("Available houses:");
    int count = 1;

    for (Residences ss : Owner.ownedResidences) {
      for(House house : ss.getHouses())
      if (!house.isRented()) {
        logger.info("House " + count);
        logger.info("ID: " + house.getId());
        logger.info("Name: " + house.getName());
        logger.info("Description: " + house.getDescription());
        logger.info("Price: " + house.getPrice());
        logger.info("Location: " + house.getLocation());
        logger.info("Services: " + house.getServices());
        logger.info("-------------------------");
        count++;
        availableHousesCopy.add(house);
      }
    }
    if (availableHousesCopy.isEmpty()) {
      logger.info("No available houses at the moment. Please check again later.");
      logger.info("1 - Go to showFurniture");

      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          showFurniture();
          break;
        default:
          logger.info("Invalid input");
          break;
      }
    }

    logger.info("Enter the ID of the house you want to book: ");
    houseId = scanner.nextInt();

    House chosenHouse = homeRented(houseId);
//    for (House house : availableHousesCopy) {
//      if (house.getId() == houseId) {
//        chosenHouse = house;
//        break;
//      }
//    }
    
    
    if (chosenHouse == null) {
      logger.info("Invalid house selection.");
      bookAccommodation();
      return;
    }

    scanner.nextLine(); // Consume newline character
    logger.info("Enter your full name: ");
    String tenantName = scanner.nextLine();

    logger.info("Enter the number of months to rent: ");
    int numMonths = scanner.nextInt();
    double rentAmount =checkbill( chosenHouse.getPrice(), numMonths);


    scanner.nextLine(); // Consume newline character
    logger.info("Enter the payment method and details: ");
    String paymentMethod = scanner.nextLine();

    chosenHouse.setRented(true);

    logger.info("Booking successful! You have booked the house:");
    logger.info("House Name: " + chosenHouse.getName());
    logger.info("Tenant Name: " + tenantName);
    logger.info("Number of Months: " + numMonths);
    logger.info("Rent Amount: " + rentAmount);
    logger.info("Payment Method: " + paymentMethod);
    logger.info("---------------------------------------------");
    logger.info("---------------------------------------------");

    addRentedHouse(chosenHouse.getName());
    availableHouses.remove(chosenHouse);
    HousesAfterRemove=availableHouses;
     Remove = homeRemove(houseId);
    logger.info("1 - Go back to bookAccommodation");
    logger.info("2 - Go back to Dashboard menu");

    int choice = scanner.nextInt();

    switch (choice) {
      case 1:
        bookAccommodation();
        logger.info("test");
        break;
      case 2:
        displayDashboard();
        break;
      default:
        logger.info("Invalid input");
        break;
    }
  }

  public static String newPhoneNumber;
  public static String newBankCard;
  public static String newEmail;
  public static String newPassword;
  public boolean FlageUpdatePassword = false;
  public boolean FlageUpdatePhone = false;
  public boolean FlageUpdateBank = false;
  public boolean FlageUpdateEmail = false;

  public void viewProfile() {
    logger.info("Viewing tenant profile...");
    logger.info("Name: " + name);
    logger.info("Phone Number: " + phoneNumber);
    logger.info("Bank Card: " + bankCard);
    logger.info("Email: " + email);
    logger.info("Password: " + password);

    logger.info("1 - Go back to Dashboard menu");
    logger.info("2 - Edit Profile Information");
    int choice = scanner.nextInt();

    switch (choice) {
      case 1:
        displayDashboard();
        break;
      case 2:
        updateProfileInformation();
        break;
      default:
        logger.info("Invalid input");
        break;
    }
  }
public static  int profileChoice;

  public int updateProfileInformation() {
    logger.info("---------------------");
    logger.info("1 - Update phone number");
    logger.info("2 - Update bank card");
    logger.info("3 - Update email");
    logger.info("4 - Update password");

    profileChoice = scanner.nextInt();
    scanner.nextLine(); // Consume newline character

    switch (profileChoice) {
      case 1:
        logger.info("Enter new phone number: ");
        newPhoneNumber = scanner.nextLine();
        updatePhoneNumber(newPhoneNumber);
        logger.info("Phone number updated successfully!");
        FlageUpdatePhone = true;
        break;
      case 2:
        logger.info("Enter new bank card: ");
        newBankCard = scanner.nextLine();
        updateBankCard(newBankCard);
        logger.info("Bank card updated successfully!");
        FlageUpdateBank = true;
        break;
      case 3:
        logger.info("Enter new email: ");
        newEmail = scanner.nextLine();
        updateEmail(newEmail);
        logger.info("Email updated successfully!");
        FlageUpdateEmail = true;
        break;
      case 4:
        logger.info("Enter new password: ");
        newPassword = scanner.nextLine();
        updatePassword(newPassword);
        logger.info("Password updated successfully!");
        FlageUpdatePassword = true;
        break;
      default:
        logger.info("Invalid choice!");
        break;
    }
    viewProfile();
    return profileChoice;
  }
public boolean homeRemove(int id) {
	
for (House house : HousesAfterRemove) {
	  logger.info(String.valueOf(house.getId())) ;
	  logger.info(String.valueOf(id));
	  logger.info("") ;
    if (house.getId() == id)
     return false;
}
  	   return true;
  
}

  public House homeRented(int id) {
	  for (House house : availableHousesCopy) {
	      if (house.getId() == id) {
	        return house ;
	      }
	     }
	return null;
  }
	public List<House> getOwnedHouses() {
		return ownedHouses;
	}

	public void setOwnedHouses(List<House> ownedHouses) {
		this.ownedHouses = ownedHouses;
	}
  // Other methods and class definitions...
}
