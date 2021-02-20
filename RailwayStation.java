/**
 * Represents a railway station
 * @author Matan cohen
 * @version 02/05/2020
 */
public class RailwayStation
{
    //delclarations
    public final int MAX_TRAINS = 100; //The max number of trains in the array
    private Train [] _station; //Train array 
    private int _noOfTrs; //The number of trains
        
    /**
     * default contructor
     */
    public RailwayStation() 
    {
        _station = new Train[MAX_TRAINS];
        _noOfTrs = 0;
    }
    
    /**
     * Add a new train to the trains array,
     * if the list if full, the train will be not added.
     * @param f The new train to add.
     * @return True if able to add the new train, false otherwise.
     */
    public boolean addTrain(Train f)
    {                     
        if (_noOfTrs == MAX_TRAINS)
            return false;        
        
        boolean flag = false;
        
        for (int i = 0; i < _noOfTrs; i++){
            if (_station[i].equals(f)){
                flag = true;
                break;
            }
        }
        if(flag)
            return false;
        
        else{
            for (int i = 0; i < _noOfTrs; i++){
                if(_station[i] == null){
                    _station[i] = f;
                    _noOfTrs++;
                    return true;
                }                                                    
            }
            _station[_noOfTrs] = f;
            _noOfTrs++;
            return true;
        }
    }
    
    /**
     * Remove a train from the trains array,
     * if the array is empty, the train will be not removed.
     * @param f The train to remove.
     * @return True if able to remove the train, false otherwise.
     */
    public boolean removeTrain(Train f)
    {
        if(_noOfTrs < 1)
            return false;
        Train j = _station[_noOfTrs -1 ];
        
        for (int i = 0; i < _noOfTrs; i++)
            if (_station[i].equals(f)){
                _station[i] = j;
                _station[_noOfTrs - 1] = null; 
                _noOfTrs -= 1;              
                return true;}
        return false;            
    }
    
    /**
     * Get destination and return the first departure in the array to this destination.
     * @param place The destination.
     * @return The first departure in the array to this destination, if the array is empty return null.
     */
    public Time1 firstDepartureToDestination(String place)
    {
        Train first = null;
        
        for (int i = 0; i < _noOfTrs; i++){
            if (_station[i].getDestination().equals((place)))
                if (first == null || _station[i].getDeparture().before(first.getDeparture())) 
                    first = _station[i];                 
        }
        if (first == null)
            return null;
        else return new Time1 (first.getDeparture());    
    }
 
    /**
     * Counts all the full trains in the array.
     * @returs The number of how much there is a full trains is the array.
     */
    public int howManyFullTrains()
    {
        int howMany = 0; 
        
        for (int i = 0; i < _noOfTrs; i++)
            if (_station[i].isFull())
                howMany++;
        return howMany;        
    }
    
    /**
     * check which destination arrive the most trains.
     * @return Which destination arrive the most trains. 
     */
    public String mostPopularDestination()
    {
        int maxNum = 0;
        String mostPopular = null;
        
        for(int i = 0; i < _noOfTrs; i++)
        {
            int numOfTrains = 0;
            for(int j = 0; j < _noOfTrs; j++){
                if (_station[i].getDestination().equals(_station[j].getDestination()))
                    numOfTrains++;
            }
            if (numOfTrains > maxNum){
                maxNum = numOfTrains;
                mostPopular = _station[i].getDestination();
            }
        }   
        return mostPopular;
    }
    
    /**
     * Check which train ticket is the most expensive.
     * @return The Train with the most expensive ticket, if the array is empty return null.
     */
    public Train mostExpensiveTicket()
    {        
        if (_noOfTrs < 1)
            return null; 
        Train mostExpensive = _station[0];
        
        for (int i = 1; i < _noOfTrs; i++)
            if (mostExpensive.isCheaper(_station[i]))
                mostExpensive = _station[i];
        return new Train (mostExpensive);        
    }
    
    /**
     * Check which train have the bigest duration to destination.
     * @return The train that have the bigest duration to destination.
     */
    public Train longestTrain()
    {          
        if (_noOfTrs == 0)
            return null;
            
        Train longest = _station[0];
                     
        for(int i = 1; i < _noOfTrs; i++)
            if (longest.getDuration() < _station[i].getDuration())
                longest = _station[i];
        return new Train (longest);
    }
    
    /**
     * Return string that describes in one list the all trains in order according to the array. 
     * @return All the trains in the array in one list 
     **/
    public String toString()
    {
    String str = "The trains today are:\n";
    
    if (_noOfTrs < 1)
        return ("There are no trains today.");
           
    for (int i = 0; i < _noOfTrs; i++)
        if (_station[i].isFull())
            str += "Train to " + _station[i].getDestination() + " departs at " + _station[i].getDeparture() + "." + " Train is full.\n";
        else str += "Train to " + _station[i].getDestination() + " departs at " + _station[i].getDeparture() + "." + " Train is not full.\n"; 
    return str;
    }
}