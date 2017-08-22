
/**
 * Write a description of class ParkingTicket here.
 * 
 * @author Jason Chan A00698160
 * @version 10.23.14 Assignment #2
 * @to dispense a ticket if all requirements are met
 */
public class ParkingTicket
{
    public static final String TICKET = "V";
    public static int TICKET_NUMBER = 1001;
    
    private String carMake;
    private String carModel;
    private String licenseNumber;
    private String ticketNumber;
    private PoliceOfficer policeOfficer;
    private int parkingFineInCAD;

    /**
     * Default Constructor for objects of class ParkingTicket
     */
    public ParkingTicket()
    {
        policeOfficer = new PoliceOfficer();
        ticketNumber = createTicketNumber();
        parkingFineInCAD = 0;
        carMake = "";
        carModel = "";
        licenseNumber = "";
    }

    /**
     * Constructor for objects of class ParkingTicket
     * @param newPoliceOfficer to set fields of policeOfficer
     */
    public ParkingTicket(PoliceOfficer newPoliceOfficer)
    {
        policeOfficer = newPoliceOfficer;
        ticketNumber = createTicketNumber();
        parkingFineInCAD = policeOfficer.calculateFineInCAD();
        carMake = newPoliceOfficer.getParkedCar().getCarMake();
        carModel = newPoliceOfficer.getParkedCar().getCarModel();
        licenseNumber = newPoliceOfficer.getParkedCar().getLicenseNumber();
    }
    
    /**
     * Accessor Method for police officer name
     * @return officerName
     */
    public String getOfficerName()
    {
        return policeOfficer.getOfficerName();
    }
    
    /**
     * Mutator Method for police officer name
     * @param newPoliceOfficerName to set the fields for policeOfficer
     */
    public void setOfficerName(String newOfficerName)
    {
        //sets policeOfficerName if newPoliceOfficerName is not null
        if(newOfficerName != null)
        {
            policeOfficer.setOfficerName(newOfficerName);
        }
        //else set policeOfficerName to and empty String
        else
        {
            System.out.println("Officer name is invalid");
            policeOfficer.setOfficerName("");
        }
    }
    
    /**
     * Accessor Method for badgeNumber
     * @return badgeNumber
     */
    public String getBadgeNumber()
    {
        return policeOfficer.getBadgeNumber();
    }
    
    /**
     * Mutator Method for badgeNumber
     * @param newBadgeNumber to set the fields for badgeNumber
     */
    public void setBadgeNumber(String newBadgeNumber)
    {
        //sets badgeNumber as newBadgeNumber if not null
        if(newBadgeNumber != null)
        {
            policeOfficer.setBadgeNumber(newBadgeNumber);
        }
        //else set as empty String
        else
        {
            System.out.println("Officer Badge is invalid");
            policeOfficer.setBadgeNumber("");
        }
    }    
    
    /**
     * Accessor Method for parked car licenseNumber
     * @return licenseNumber
     */
    public String getLicenseNumber()
    {
        return licenseNumber;
    }
    
    /**
     * Mutator Method for licenseNumber
     * @param newLicenseNumber to set the fields for licenseNumber
     */
    public void setLicenseNumber(String newLicenseNumber)
    {
        //set licenseNumber as newLicenseNumber if not null
        if(newLicenseNumber != null)
        {
            policeOfficer.getParkedCar().setLicenseNumber(newLicenseNumber);
        }
        //else set parkedCarLicenseNumber as empty String
        else
        {
            System.out.println("Parked Car License number is invalid");
            policeOfficer.getParkedCar().setLicenseNumber("");
        }
    }
    
    /**
     * Accessor Method for carMake
     * @return carMake
     */
    public String getCarMake()
    {
        return carMake;
    }
    
    /**
     * Mutator Method for carMake
     * @param newCarMake to set the fields for carMake
     */
    public void setCarMake(String newCarMake)
    {
        //set carMake as newCarMake if not null
        if(newCarMake != null)
        {
            policeOfficer.getParkedCar().setCarMake(newCarMake);
        }
        //else set carMake as an empty String
        else
        {
            System.out.println("Parked car make is invalid");
            policeOfficer.getParkedCar().setCarMake("");
        }
    }
    
    /**
     * Accessor Method for carModel
     * @return carModel
     */
    public String getCarModel()
    {
        return carModel;
    }
    
    /**
     * Mutator Method for carModel
     * @param newCarModel to set the fields for carModel
     */
    public void setCarModel(String newCarModel)
    {
        //set carModel as newCarModel if not null
        if(newCarModel != null)
        {
            policeOfficer.getParkedCar().setCarModel(newCarModel);
        }
        //else set carModel as an empty String
        else
        {
            System.out.println("Parked car model is invalid");
            policeOfficer.getParkedCar().setCarModel("");
        }
    }    
    
    /**
     * Accessor Method for parkingFineInCAD
     * @return parkingFineInCAD
     */
    public int getParkingFineInCAD()
    {
        return parkingFineInCAD;
    }
    
    /**
     * Mutator Method for parkingFineInCAD
     * @param newParkingFineInCAD to set the fields for parkingFineInCAD
     */
    public void setParkingFineInCAD(int newParkingFineInCAD)
    {
        //set parkingFineInCAD as newParkingFineInCAD if positive
        if(newParkingFineInCAD > 0)
        {
            parkingFineInCAD = newParkingFineInCAD;
        }
        //else set parkingFineInCAD to 0
        else
        {
            System.out.println("no fine");
            parkingFineInCAD = 0;
        }
    }
    
    /**
     * Accessor Method for ticketNumber
     * @return ticketNumber
     */
    public String getTicketNumber()
    {
        return ticketNumber;
    }
    
    /**
     * Method to create a TicketNumber - Ticker number must be unique
     * The ticket number goes in an increment of 1 for every ticket issued
     */
    private String createTicketNumber()
    {
        //creates the ticket number as a string and increase ticket number by
        //1 for every ticket issued
        return TICKET + TICKET_NUMBER++;
    }
    
    /**
     * Method to display the details of the ticket on the screen
     */
    public void displayTicket()
    {
        if(parkingFineInCAD > 0)
        {
            System.out.println("***** Assignment #2 Parking Ticket *****");
            System.out.println("Ticket Number: " + getTicketNumber());
            System.out.println("Officer Name: " + getOfficerName());
            System.out.println("Badge Number: " + getBadgeNumber());
            System.out.println("Parked Car License Number: " + getLicenseNumber());
            System.out.println("Parked Car Make: " + getCarMake());
            System.out.println("Parked Car Model: " + getCarModel());
            System.out.println("Parking Fine In CAD: $" + getParkingFineInCAD());
            System.out.println();
        }
        else
        {
            System.out.println("***** Assignment #2 Parking Ticket *****");
            System.out.println("No fine");
            System.out.println();
        }
    }
}
