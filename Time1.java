/**
 * Represents time - hours:minutes.
 * 
 * @author: Matan Cohen
 *@version 15/04/2020
 */
public class Time1
{
   
   //delclarations
   private int _hour;
   private int _minute; 
      
    
   /**
    *Constructs a Time1 object. Construct a new time instance with the specified hour and minute .
    *hour should be between 0-23, otherwise it should be set to 0.
    *minute should be between 0-59, otherwise it should be set to 0.
    *@param h the hour of the time
    *@param m the minute of the time   
    */
   public Time1(int h, int m)
   {
         if(h < 0 || h > 23)
            _hour = 0;
         else _hour = h;
                  
         if(m < 0 || m > 59)   
            _minute = 0;
         else _minute = m;
   }
     
   /**
     *t constructor for Time1. Construct a time with the same instance variables as another time
     *@param t The time object from which to construct the new time
     */
   public Time1(Time1 other)
   {
       _hour = other._hour;
       _minute = other._minute;
   }
     
   /**
     *Returns the hour of the time.
     *@return The hour of the time
     */
   public int getHour()
   {
        return _hour;
   }
     
   /**
     *Returns the minutes of the time.
     *@return Returns the minutes of the time
     */
   public int getMinute()
   {
        return _minute;
   }
    
   /**
    * Changes the hour of the time. If an illegal number is received hour will be unchanged.
    * @param num The new hour
    */
   public void setHour(int h)
   {
       if(h >= 0 && h <= 23)
           _hour = h;
   }
     
   /**
     * Changes the minute of the time. If an illegal number is received minute will be unchanged.
     *@param num The new minute
     */
   public void setMinute(int m)
   {
        if(m >= 0 && m <= 59)
           _minute = m;
   }
    
   /**
     * Returns a string representation of this time ("hh:mm").
     * @overrides toString in class java.lang.Object
     * @return String representation of this time ("hh:mm").
   */
   public String toString()
   {
       String hour = (_hour < 10) ? "0" + _hour : "" + _hour;
       String min = (_minute < 10) ? "0" + _minute : "" + _minute;
       return hour + ":" + min;
   }
     
   /**
   * Return the amount of minutes since midnight.
   * @return Amount of minutes since midnight 
   */
   public int minFromMidnight()
   {
       int mfm = 60 * _hour + _minute; //mfm=minFromMidnight
       return mfm;
   }
     
   /**
   * Checks if the received time is equal to this time.
   * @param other The time to be compared with this time
   * @return True if the received time is equal to this time
   */
   public boolean equals(Time1 other)
   {
       return (other._hour == _hour && other._minute == _minute);
   }
     
   /**
   * Checks if this time is before a received time.
   * @param other The time to check if this time is before
   * @return True if this time is before other time
   */
   public boolean before(Time1 other)
   {
      if (_hour < other._hour)
           return true;
      else if (_hour > other._hour)
           return false;
        
      if (_minute >= other._minute)
           return false;
      else return true;
   }
     
   /**
    * Check if this time is after a received time.
    * @param other The time to check if this time is after
    * @return True if this time is after other time
    */
   public boolean after(Time1 other)
   {
       return other.before(this);
   }
     
   /**
    * Calculates the difference (in minutes) between two times. Assumption: this time is after other time.
    * @param other The time to check the difference to
    * @return int difference in minutes
    */
   public int difference(Time1 other)
   {
       return (60 * _hour + _minute)-(60 * other._hour + other._minute);
   }
     
   /**
    * Adds num Minutes to time.
    * @param num The number of minutes to add
    * @return the update time
    */
   public Time1 addMinutes(int num)
   {
       int tempMinute = (((this._minute + num)%60)+60)%60;
       int tempHour = ((this._hour +(this._minute + num)/60)%24);
       if(this._minute + num < 0)
          tempHour = tempHour - 1;
       tempHour = (tempHour +24)%24;
       return new Time1(tempHour,tempMinute);
   }
}





     
     
     
     

