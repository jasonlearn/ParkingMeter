import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class PoliceOfficer here.
 * 
 * @author Jason Chan A00698160
 * @version 10.23.14 Assignment #2
 */
public class PoliceOfficer
{
    public static final int FIRST_FINE = 25;
    public static final int ONE_HOUR_FINE = 20;
    public static final int TWO_HOUR_FINE = 40;
    public static final int ONE_HOUR = 60;
    public static final int TWO_HOUR = 120;

    private String officerName;
    private String badgeNumber;
    private ParkedCar parkedCar;
    private ParkingMeter parkingMeter;
    private ArrayList<ParkingTicket> ticketsArray;

    public boolean isParkingTimeExpired;

    /**
     * Default Constructor for objects of class PoliceOfficer
     */
    public PoliceOfficer()
    {
        setOfficerName("");
        setBadgeNumber("");
        setParkedCar(new ParkedCar());
        setParkingMeter(new ParkingMeter());
        isParkingTimeExpired();
    }

    /**
     * Constructor for objects of class PoliceOfficer
     * @param newOfficerName to set the officer name
     * @param newBadgeNumber to set the officer badge
     * @param newParkedCar to set the parked car
     * @param newParkingMeter so set the parking meter
     */
    public PoliceOfficer(String newOfficerName, String newBadgeNumber,
    ParkedCar newParkedCar, ParkingMeter newParkingMeter)
    {
        setOfficerName(newOfficerName);
        setBadgeNumber(newBadgeNumber);
        setParkedCar(newParkedCar);
        setParkingMeter(newParkingMeter);
        isParkingTimeExpired();
        ticketsArray = new ArrayList<ParkingTicket>();
    }

    /**
     * Method to add all tickets issued
     */
    public int sumOfFinesInCAD()
    {
        int fineSum = 0;
        for(ParkingTicket calculateAllTickets : ticketsArray){
            fineSum += calculateAllTickets.getParkingFineInCAD();
        }
        return fineSum;
    }

    /**
     * Accessor Method for officerName
     * @return officerName
     */
    public String getOfficerName()
    {
        //returns the officer's name
        return officerName;
    }

    /**
     * Mutator Method for officerName
     * @param newOfficerName to set the officerName only if it's a valid String
     * else it will be set as an empty String
     */
    public void setOfficerName(String newOfficerName)
    {
        //validates if newOfficerName is not equal to null
        if(newOfficerName != null)
        {
            officerName = newOfficerName;
        }
        //set officerName as an empty string and display an error message
        else{
            officerName = "";
            System.out.println("Error: officer name is invalid");
        }
    }

    /**
     * Accessor Method for badgeNumber
     * @return badgeNumber
     */
    public String getBadgeNumber()
    {
        //returns the officer's badge number
        return badgeNumber;
    }

    /**
     * Mutator Method for badgeNumber
     * @param newBadgeNumber to set the badgeNumber only if it's a valid String
     * else it will be set as an empty String
     */
    public void setBadgeNumber(String newBadgeNumber)
    {
        //varifies newBadgeNumber is not equal to null
        if(newBadgeNumber != null)
        {
            badgeNumber = newBadgeNumber;
        }
        //sets badgeNumber as an empty string and display error message
        else
        {
            badgeNumber = "";
            System.out.println("Error: badge number is invalid");
        }
    }

    /**
     * Accessor Method for parkedCar
     * @return parkedCar
     */
    public ParkedCar getParkedCar()
    {
        return parkedCar;
    }

    /**
     * Mutator Method for parkedCar
     * @param newParkedCar to set the parkedCar only if the String is valid
     * else parkedCar is set by creating a new object as default of parkedCar
     */
    public void setParkedCar(ParkedCar newParkedCar)
    {
        //varifies newParkedCar is not equal to null
        if(newParkedCar != null)
        {
            parkedCar = newParkedCar;
        }
        //sets parkedCar to create a new ParkedCar and display error message
        else
        {
            parkedCar = new ParkedCar();
            System.out.println("Error: ParkedCar is invalid");
        }
    }

    /**
     * Accessor Method for parkingMeter
     * @return parkingMeter
     */
    public ParkingMeter getParkingMeter()
    {
        return parkingMeter;
    }

    /**
     * Mutator Method for parkingMeter
     * @param newParkingMeter to set the parkingMeter only if the String is valid
     * else parkingMeter is set by creating a new object as default of parkingMeter
     */
    public void setParkingMeter(ParkingMeter newParkingMeter)
    {
        //Varifies newParkingMeter is not equal to null
        if(newParkingMeter != null)
        {
            parkingMeter = newParkingMeter;
        }
        //set parkingMeter to create a new ParkingMeter and display error message
        else
        {
            parkingMeter = new ParkingMeter();
            System.out.println("Error: ParkingMeter is invalid");
        }
    }

    /**
     * Method to check if the parkedCar time has expired by 
     * comparing numberOfMinutesParked with numberOfMinutesPurchased
     * if numberOfMinutesParked is greater than numberOfMinutesPurchased
     * then isParkingTimeExpired set to true, else false
     */
    public boolean isParkingTimeExpired()
    {
        //compares is number of purchased minutes is less than number of minutes parked, sets isParkingTimeExpired to true
        if(parkingMeter.getNumberOfPurchasedMinutes() < parkedCar.getNumberOfMinutesParked())
        {
            isParkingTimeExpired = true;
        }
        //sets isParkingTimeExpired to false if purchased minutes is greater than minutes parked.
        else
        {
            isParkingTimeExpired = false;
        }
        return isParkingTimeExpired;
    }

    /**
     * Method to calculate the fine.  Fine costs $25 for portion or the first hour,
     * $20 fine for every additional hours of expiration.
     */
    public int calculateFineInCAD()
    {
        int fine = 0;
        int minutesExpired = parkedCar.getNumberOfMinutesParked() - parkingMeter.getNumberOfPurchasedMinutes();
        if(isParkingTimeExpired == true)
        {
            fine += FIRST_FINE;
            if((minutesExpired > ONE_HOUR) && (minutesExpired < TWO_HOUR))
            {
                fine += ONE_HOUR_FINE;
            }
            else if(minutesExpired >= TWO_HOUR)
            {
                fine += TWO_HOUR_FINE;
            }
        }
        else
        {
            System.out.println("No fine");
        }

        return fine;
    }
    
    /**
     * Accessor Method for issuedTicket
     * @return issuedTicket
     */
    public ArrayList<ParkingTicket> getTicketsArray()
    {
        return ticketsArray;
    }

    /**
     * Method to issue a parking ticket only if isParkingTimeExpired equals true
     * and add issuedTicket to ticketsArray ArrayList
     */
    public void issuedTicket()
    {
        if(isParkingTimeExpired == true)
        {
            PoliceOfficer aPoliceOfficer = new PoliceOfficer(getOfficerName(), getBadgeNumber(), getParkedCar(), getParkingMeter());
            ParkingTicket issuedTicket = new ParkingTicket(aPoliceOfficer);
            ticketsArray.add(issuedTicket);
        }
    }

    /**
     * Method to calculate the sum of fines
     * @return sumOfFinesInCAD
     */
    public int calculateSumOfFinesInCAD()
    {
        Iterator<ParkingTicket> it = ticketsArray.iterator();
        int sum = 0;
        while(it.hasNext())
        {
            ParkingTicket fines = it.next();
            sum += fines.getParkingFineInCAD();
        }
        return sum;
    }

    /**
     * Method to use the licenseNumber of a car as parameter
     * @return numberOfTickets
     */
    public int getNumberOfTickets(String newLicenseNumber)
    {
        Iterator<ParkingTicket> it = ticketsArray.iterator();
        int counter = 0;
        while(it.hasNext())
        {
            ParkingTicket tickets = it.next();
            if(tickets.getLicenseNumber().equals(newLicenseNumber))
            {
                counter++;
            }
        }
        return counter;
    }
}
