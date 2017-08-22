
/**
 * Write a description of class ParkingMeter here.
 * 
 * @author Jason Chan A00698160
 * @version Comp 1409 Assignment 1 - ParkingMeter
 */
public class ParkingMeter
{
    // instance variables - replace the example below with your own
    public final int MAXIMUM_AMOUNT_OF_PURCHASED_MINUTES = 180;
    public final int MINIMUM_AMOUNT_OF_PURCHASED_MINUTES = 0;
    public final double MINIMUM_PRICE_OF_ONE_MINUTE_IN_CAD = 0.0;
    
    private int numberOfPurchasedMinutes;
    private String meterType;
    private String meterLocation;
    private double priceOfOneMinuteInCAD;
    private boolean isThereACamera;  

    /**
     * Default Constructor for objects of class ParkingMeter
     */
    public ParkingMeter()
    {
        // initialise instance variables
        setNumberOfPurchasedMinutes(0);
        setMeterType("");
        setMeterLocation("");
        setPriceOfOneMinuteInCAD(0.0);
        isThereACamera = false;
    }

    /**
     * Constructor for objects of class ParkingMeter
     * @param newNumberOfPurchasedMinutes the number of purchased minutes - must be greater or equal to 0 and less than or equal to 180
     * @param newMeterType the meter type
     * @param newMeterLocation the location of the meter
     * @param newPriceOfOneMinuteInCAD the price of one minute in Canadian Dollars - must be greater or equal to 0.0
     * @param newIsThereACamera the verify if there is a camera at the parking meter
     */
    public ParkingMeter(int newNumberOfPurchasedMinutes, String newMeterType, String newMeterLocation, double newPriceOfOneMinute, boolean newIsThereACamera)
    {
        setNumberOfPurchasedMinutes(newNumberOfPurchasedMinutes);
        setMeterType(newMeterType);
        setMeterLocation(newMeterLocation);
        setPriceOfOneMinuteInCAD(newPriceOfOneMinute);
        isThereACamera = newIsThereACamera;
    }
    
    /**
     * Accessor Method for numberOfPurchasedMinutes
     * @return numberOfPurchasedMinutes of the ParkingMeter
     */
    public int getNumberOfPurchasedMinutes()
    {
        return numberOfPurchasedMinutes;
    }
    
    /**
     * Mutator Method for numberOfPurchasedMinutes
     * @param newNumberOfPurchasedMinutes to set the numberOfPurhcasedMinutes of the ParkingMeter
     */
    public void setNumberOfPurchasedMinutes(int newNumberOfPurchasedMinutes)
    {
        if((newNumberOfPurchasedMinutes > MINIMUM_AMOUNT_OF_PURCHASED_MINUTES) && (newNumberOfPurchasedMinutes <= MAXIMUM_AMOUNT_OF_PURCHASED_MINUTES))
        {
            numberOfPurchasedMinutes = newNumberOfPurchasedMinutes;
        }
        else if(newNumberOfPurchasedMinutes > MAXIMUM_AMOUNT_OF_PURCHASED_MINUTES)
        {
            numberOfPurchasedMinutes = MAXIMUM_AMOUNT_OF_PURCHASED_MINUTES;
            System.out.println("Error: number of purchased minutes must be less than" + MAXIMUM_AMOUNT_OF_PURCHASED_MINUTES + " minutes.");
        }
        else
        {
            numberOfPurchasedMinutes = MINIMUM_AMOUNT_OF_PURCHASED_MINUTES;
            System.out.println("Error: number of purchased minutes must be greater than " + MINIMUM_AMOUNT_OF_PURCHASED_MINUTES + " minutes.");
        }
    }
    
    /**
     * Accessor Method for meterType
     * @return meterType for the ParkingMeter
     */
    public String getMeterType()
    {
        return meterType;
    }
    
    /**
     * Mutator Method for meterType
     * @param newMeterType to set the meterType of the ParkingMeter
     */
    public void setMeterType(String newMeterType)
    {
        if(newMeterType != null)
        {
            meterType = newMeterType;
        }
        else{
            meterType = "";
            System.out.println("Error: meter type is invalid");
        }
    }
    
    /**
     * Accessor Method for meterLocation
     * @return meterLocation for the ParkingMeter
     */
    public String getMeterLocation()
    {
        return meterLocation;
    }
    
    /**
     * Mutator Method for meterLocation
     * @param newMeterLocation to set the meterLocation of ParkingMeter
     */
    public void setMeterLocation(String newMeterLocation)
    {
        if(newMeterLocation != null)
        {
            meterLocation = newMeterLocation;
        }
        else
        {
            meterLocation = "";
            System.out.println("Error: meter location is invalid");
        }
    }
    
    /**
     * Accessor Method for priceOfOneMinuteInCAD
     * @return priceOfOneMinuteInCAD for ParkingMeter
     */
    public double getPriceOfOneMinuteInCAD()
    {
        return priceOfOneMinuteInCAD;
    }
    
    /**
     * Mutator Method for priceOfOneMinuteInCAD
     * @param newPriceOfOneMinureInCAD to set the priceOfOneMinuteInCAD of ParkingMeter - the price must be greater or equal to 0.0
     */
    public void setPriceOfOneMinuteInCAD(double newPriceOfOneMinuteInCAD)
    {
        if(newPriceOfOneMinuteInCAD > MINIMUM_PRICE_OF_ONE_MINUTE_IN_CAD)
        {
            priceOfOneMinuteInCAD = newPriceOfOneMinuteInCAD;
        }
        else
        {
            priceOfOneMinuteInCAD = MINIMUM_PRICE_OF_ONE_MINUTE_IN_CAD;
            System.out.println("Price of one minute must be between greater than $" + MINIMUM_PRICE_OF_ONE_MINUTE_IN_CAD + ".");    
        }
    }
    
    /**
     * Accessor Method for isThereACamera
     * @return isThereACamera for ParkingMeter
     */
    public boolean isThereACamera()
    {
        return isThereACamera;
    }
    
    /**
     * To display details of number of purchased minutes, meter type, meter loaction, price of one minute, and if there is a camera for the ParkingMeter
     */
    public void displayDetails()
    {
        if(numberOfPurchasedMinutes > MINIMUM_AMOUNT_OF_PURCHASED_MINUTES && numberOfPurchasedMinutes <= MAXIMUM_AMOUNT_OF_PURCHASED_MINUTES)
        {
            System.out.println("########## Parking Meter Details ##########");
            System.out.println("Number Of Purchased Minutes: " + getNumberOfPurchasedMinutes() + "minutes");
            System.out.println("Meter Type: " + getMeterType());
            System.out.println("Meter Location: " + getMeterLocation());
            System.out.println("Price of One Minute: $" + getPriceOfOneMinuteInCAD() + " CAD");
            System.out.println("There Is A Camera: " + isThereACamera);
        }
        else
        {
            System.out.println("Error: The number of purchased minutes must be greater than " + MINIMUM_AMOUNT_OF_PURCHASED_MINUTES + " and " + MAXIMUM_AMOUNT_OF_PURCHASED_MINUTES + " minutes.");
        }
    }
}
