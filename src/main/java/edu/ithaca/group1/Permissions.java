package edu.ithaca.group1;

public class Permissions {

    private DaysOfWeek day;
    private double start;
    private double end;

    public Permissions(DaysOfWeek day, double startTime, double endTime)
    {
        this.day = day;
        this.start = startTime;
        this.end = endTime;
    }

    /**
     * Gets day
     * @return day enum (sun-sat)
     */
    public DaysOfWeek getDay() { return day; }

    /**
     * Gets start time
     * @return double representing time in 24 hour clock format
     */
    public double getStart() { return start; }

    /**
     * Gets end time
     * @return double representing time in 24 hour clock format
     */
    public double getEnd() { return end; }

    /**
     * Sets new day of the week
     * @param day
     */
    public void setDay(DaysOfWeek day) { this.day = day; }

    /**
     * Sets new start time
     * @param start new start time (must be double)
     */
    public void setStart(double start) { this.start = start; }

    /**
     * Sets new end time
     * @param end new end time (must be double)
     */
    public void setEnd(double end) { this.end = end; }
}
