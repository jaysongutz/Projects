public class DateTime {

    // DO NOT MODIFY THE INSTANCE VARIABLES
    int year;   // 1000 - 3000
    int month;  // 01 - 12
    int day;    // 01 - 31
    int hours;  // 00 - 23
    int mins;   // 00 - 59
    private static final int YEAR_POS = 0;
    private static final int MONTH_POS = 1;
    private static final int DAY_POS = 2;
    private static final int HOUR_POS = 3;
    private static final int MIN_POS = 4;
    /**
     * Constructor for DateTime
     *
     * @param year  the year value for DateTime
     * @param month the month value for DateTime
     * @param day   the day value for DateTime
     * @param hours the hours value for DateTime
     * @param mins  the mins value for DateTime
     */
    public DateTime(int year, int month, int day, int hours, int mins) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hours = hours;
        this.mins = mins;
    }

    /**
     * Constructor that takes in the date time in a string format
     * string format: 2020-04-22@16:15
     *
     * @param dateTime the string representation of date and time
     */
    public DateTime(String dateTime) {
    	String[] dateTimeArray = dateTime.split("[\\p{Punct}\\s]+");
    	this.year =  Integer.parseInt(dateTimeArray[YEAR_POS]);
    	this.month =  Integer.parseInt(dateTimeArray[MONTH_POS]);
    	this.day = Integer.parseInt(dateTimeArray[DAY_POS]);
    	this.hours = Integer.parseInt(dateTimeArray[HOUR_POS]);
    	this.mins = Integer.parseInt(dateTimeArray[MIN_POS]);
    }

    /**
     * Method to get the year
     *
     * @return the value of year
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Method to get the month
     *
     * @return the value of month
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * Method to get the day
     *
     * @return the value of day
     */
    public int getDay() {
        return this.day;
    }

    /**
     * Method to get the hours
     *
     * @return the value of hours
     */
    public int getHours() {
        return this.hours;
    }

    /**
     * Method to get the minutes
     *
     * @return the value of minutes
     */
    public int getMins() {
        return this.mins;
    }

    /**
     * toString method to print the date and time
     *
     * @return A string representation of the DateTime
     */
    @Override
    public String toString() {
    	String str = "";
    	String yrStr = Integer.toString(this.year);
    	String monthStr = "";
    	String dayStr = "";
    	String hoursStr = "";
    	String minsStr = "";
	    	if (this.month > 9) {
	    		monthStr = Integer.toString(this.month);
	    	}
	    	else {
	    		monthStr = "0" + Integer.toString(this.month);
	    	}
	    	if (this.day > 9) {
	    		dayStr = Integer.toString(this.day);
	    	}
	    	else {
	    		dayStr = "0" + Integer.toString(this.day);
	    	}
	    	if (this.hours > 9) {
	    		hoursStr = Integer.toString(this.hours);
	    	}
	    	else {
	    		hoursStr = "0" + Integer.toString(this.hours);
	    	}
	    	if (this.mins > 9) {
	    		minsStr = Integer.toString(this.mins);
	    	}
	    	else {
	    		minsStr = "0" + Integer.toString(this.mins);
	    	}
	    	str = yrStr + "-" + monthStr + "-" + 
    		  dayStr + "@" + hoursStr + ":" +
    		  minsStr;
	    	return str;
    }

    /**
     * Method to compare the given dateTime with this DateTime
     *
     * @param dateTime DateTime value that this
     *                 instance must be compared with
     * @return         -1 if this DateTime is earlier (smaller), 0 if
     *                 they are same, 1 if this DateTime comes later
     *                 (greater)
     */
    public int compare(DateTime dateTime) {
    	if (this.year < dateTime.year) {return -1;}
    	else if (this.year > dateTime.year){return 1;}
    	if (this.month < dateTime.month) {return -1;}
    	else if (this.month > dateTime.month) {return 1;};
    	if (this.day < dateTime.day) {return -1;}
    	else if (this.day > dateTime.day) {return 1;}
    	if (this.hours < dateTime.hours) {return -1;}
    	else if (this.mins > dateTime.mins) {return 1;}
    	if (this.mins < dateTime.mins) {return -1;}
    	else if (this.month > dateTime.month) {return 1;}
    	else {return 0;}
    }

    /**
     * equals method to check for DateTime equality
     *
     * @param other The other object to check the equality
     *
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {return false;}
        if (!(other instanceof DateTime)) {return false;}
        DateTime otherObj = (DateTime) other;
        
        return (this.year == otherObj.year) && 
        	   (this.month == otherObj.month) &&
        	   (this.day == otherObj.day) &&
        	   (this.hours == otherObj.hours) &&
        	   (this.mins == otherObj.mins);
    }
}
