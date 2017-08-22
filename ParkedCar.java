
/**
 * Write a description of class ParkedCar here.
 * 
 * @author Jason Chan A00698160 
 * @version Comp 1409 Assignment #1 - ParkedCar
 */
public class ParkedCar
{
    // instance variables - replace the example below with your own
    public static final int MINIMUM_MINUTES_PARKED = 0;
    public static final int MAXIMUM_MINUTES_PARKED = 180;
    
    private String carMake;
    private String carModel;
    private String carColour;
    private String licenseNumber;
    private int numberOfMinutesParked;
    private String ownerName;

    /**
     * Default Constructor for objects of class ParkedCar
     */
    public ParkedCar()
    {
        // initialise instance variables
        setCarMake("");
        setCarModel("");
        setCarColour("");
        setLicenseNumber("");
        setNumberOfMinutesParked(0);
        setOwnerName("");
    }
    
    /**
     * Constructor for objects of class ParkedCar
     * @param newCarMake the make of the parked car
     * @param newCarModel the model of the parked car
     * @param newCarColour the colour of the parked car
     * @param newLicenseNumber the license number of the parked car
     * @param newNumberOfMinutesParked the number of minute parked of the parked car - the number must be greater or equal to 0
     * @param newOnwerName the name of the owner of the parked car
     */
    public ParkedCar(String newCarMake, String newCarModel, String newCarColour, String newLicenseNumber, int newNumberOfMinutesParked, String newOwnerName)
    {
        setCarMake(newCarMake);
        setCarModel(newCarModel);
        setCarColour(newCarColour);
        setLicenseNumber(newLicenseNumber);
        setNumberOfMinutesParked(newNumberOfMinutesParked);
        setOwnerName(newOwnerName);
    }
    
    /**
     * Accessor Method for carMake
     * @return the carMake of the parked car
     */
    public String getCarMake()
    {
        return carMake;
    }
    
    /**
     * Mutator Method for carMake
     * @param newCarMake to set the carMake of the parked car
     */
    public void setCarMake(String newCarMake)
    {
        if(newCarMake != null)
        {
            carMake = newCarMake;
        }
        else{
            carMake = "";
            System.out.println("Error: make of car is invalid");
        }
    }
    
    /**
     * Accessor Method for carModel
     * @return the carModel of the parked car
     */
    public String getCarModel()
    {
        return carModel;
    }
    
    /**
     * Mutator Method for carModel
     * @param newCarModel to set the carModel of the parked car
     */
    public void setCarModel(String newCarModel)
    {
        if(newCarModel != null)
        {
            carModel = newCarModel;
        }
        else{
            carModel = "";
            System.out.println("Error: car model is invalid");
        }
    }
    
    /**
     * Accessor Method for carColour
     * @return the carColour of the parked car
     */
    public String getCarColour()
    {
        return carColour;
    }
    
    /**
     * Mutator Method for carColour
     * @param newCarColour to set the carColour of the parked car
     */
    public void setCarColour(String newCarColour)
    {
        if(newCarColour != null)
        {
            carColour = newCarColour;
        }
        else{
            carColour = "";
            System.out.println("Error: car colour is invalid");
        }
    }
    
    /**
     * Accessor Method for licenseNumber
     * @return the licenseNumber of the parked car
     */
    public String getLicenseNumber()
    {
        return licenseNumber;
    }
    
    /**
     * Mutator Method for licenseNumber
     * @param newLicenseNumber to set the licenseNumber of the parked car
     */
    public void setLicenseNumber(String newLicenseNumber)
    {
        if(newLicenseNumber != null)
        {
            licenseNumber = newLicenseNumber;
        }
        else{
            licenseNumber = "";
            System.out.println("Error: licnese number is invalid");
        }
    }
    
    /**
     * Accessor Method for numberOfMinutesParked
     * @return the numberOfMinutesParked of the parked car
     */
    public int getNumberOfMinutesParked()
    {
        return numberOfMinutesParked;
    }
    
    /**
     * Mutator Method for numberOfMinutesParked
     * @param newNumberOfMinutesParked to set the numberOfMinutesParked of the parked car
     */
    public void setNumberOfMinutesParked(int newNumberOfMinutesParked)
    {
        if((newNumberOfMinutesParked > MINIMUM_MINUTES_PARKED) && (newNumberOfMinutesParked <= MAXIMUM_MINUTES_PARKED))
        {
            numberOfMinutesParked = newNumberOfMinutesParked;
        }
        else{
            numberOfMinutesParked = MINIMUM_MINUTES_PARKED;
            System.out.println("Error: number of minutes parked must be greater than 0");
        }
    }
    
    /**
     * Accessor Method for ownerName
     * @return the ownerName of the parked car
     */
    public String getOwnerName()
    {
        return ownerName;
    }
    
    /**
     * Mutator Method for ownerName
     * @param newOwnerName to set the ownerName of the parked car
     */
    public void setOwnerName(String newOwnerName)
    {
        if(newOwnerName != null)
        {
            ownerName = newOwnerName;
        }
        else{
            ownerName = "";
            System.out.println("Error: name of owner is invalid");
        }
    }
    
    /**
     * to display the car make, model, colour, license number, number of minutes parked, and owner name of the parked car
     */
    public void displayDetails()
    {
        System.out.println("########### Parked Car Detail ###########");
        System.out.println("Car Make: --------------- " + getCarMake());
        System.out.println("Car Model: -------------- " + getCarModel());
        System.out.println("Car Colour: ------------- " + getCarColour());
        System.out.println("License Number: --------- " + getLicenseNumber());
        System.out.println("Number of minutes parked: " + getNumberOfMinutesParked() + " Mins");
        System.out.println("Owner Name: ------------- " + getOwnerName());
    }
}
