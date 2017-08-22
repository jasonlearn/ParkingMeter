import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class PoliceDepartment here.
 * 
 * @author Jason Chan A00698160
 * @version Assignment #3
 */
public class PoliceDepartment
{
    private ArrayList<PoliceOfficer> policeOfficers;
    private String departmentLocation;

    /**
     * Default constructor for objects of class PoliceDepartment
     */
    public PoliceDepartment()
    {
        setDepartmentLocation("unknown");
    }

    /**
     * Constructor for objects of class PoliceDepartment
     */
    public PoliceDepartment(String newDepartmentLocation)
    {
        setDepartmentLocation(newDepartmentLocation);
        policeOfficers = new ArrayList<PoliceOfficer>();
    }       

    /**
     * Accessor Method for departmentLocation
     * @return departmentLocation
     */
    public String getDepartmentLocation()
    {
        return departmentLocation;
    }

    /**
     * Mutator method for departmentLocation
     * @return departmentLocation
     */
    public void setDepartmentLocation(String newDepartmentLocation)
    {
        if((newDepartmentLocation != null) && (newDepartmentLocation != ""))
        {
            departmentLocation = newDepartmentLocation;
        }
        else
        {
            departmentLocation = "unknown";
            System.out.println("The passed parameter cannot be null of an empty string");
        }
    }

    /**
     * Method to add PoliceOfficer - must not equal null
     */
    public void addPoliceOfficer(PoliceOfficer newPoliceOfficer)
    {
        if(newPoliceOfficer != null)
        {
            policeOfficers.add(newPoliceOfficer);
        }
    }

    /**
     * Method to search through the arraylist of parking tickets associated with the police officer
     */
    public ArrayList<ParkingTicket> getAllTicketsByOfficer(String officerName)
    {
        Iterator<PoliceOfficer> it = policeOfficers.iterator();
        if(officerName != null)
        {
            PoliceOfficer aPoliceOfficer = it.next();
            while(it.hasNext())
            {
                if(aPoliceOfficer.getOfficerName().equalsIgnoreCase(officerName))
                {
                    return aPoliceOfficer.getTicketsArray();
                }
                else
                {
                    return null;
                }
            }
        }
        else{
            return null;
        }
        return null;
    }

    /**
     * Method to calculate total amount of fines of all the parking tickets issued by all officers
     * @return totalFine
     */
    public int calculateTotalFines()
    {
        Iterator<PoliceOfficer> po = policeOfficers.iterator();
        int totalFines = 0;
        while(po.hasNext()){
            PoliceOfficer fines = po.next();
            totalFines += fines.calculateFineInCAD();
        }
        return totalFines;
    }    

    /**
     * Method to search all tickets using a parked car license number
     * issued by any officers in the department
     * @return totalTicketsOfParkedCar
     */
    public int calculateTicketsOfACar(String licenseNumber)
    {
        Iterator<PoliceOfficer> it = policeOfficers.iterator();
        int numberOfTickets = 0;
        PoliceOfficer tix = it.next();
        if(tix.getParkedCar().getLicenseNumber().equalsIgnoreCase(licenseNumber))
        {
            while(it.hasNext())
            {
                numberOfTickets++;
            }
        }
        else
        {
            System.out.println(licenseNumber + " has no ticket.");
        }
        return numberOfTickets;        
    }
}
