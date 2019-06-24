package work2;
/**
 * The {@code Event} help to save information about the Events.
 */
public class Event {
    private String nameEvent;
    private String nameResponsible;
    private String city;
    private String uf;
    private String dateInitial;
    private String dateEnd;
    private int workload;
    
    /**
    * @param nameEvent the nameEvent to set
    */
    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }
    /**
    * @param nameResponsible the nameResponsible to set
    */
    public void setNameResponsible(String nameResponsible) {
        this.nameResponsible = nameResponsible;
    }
    /**
    * @param city the city to set
    */
    public void setCity(String city) {
        this.city = city;
    }
    /**
    * @param uf the uf to set
    */
    public void setUf(String uf) {
        this.uf = uf;
    }
    /**
    * @param dateInitial the dateInitial to set
    */
    public void setDateInitial(String dateInitial) {
        this.dateInitial = dateInitial;
    }
    /**
    * @param dateEnd the dateEnd to set
    */
    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
    /**
    * @param workload the workload to set
    */
    public void setWorkload(int workload) {
        this.workload = workload;
    }

    /**
     * @return the nameEvent
     */
    public String getNameEvent() {
        return this.nameEvent;
    }
    /**
     * @return the nameResponsible
     */
    public String getNameResponsible() {
        return this.nameResponsible;
    }
    /**
     * @return the city
     */
    public String getCity() {
        return this.city;
    }
    /**
     * @return the uf
     */
    public String getUf() {
        return this.uf;
    }
    /**
     * @return the dateInitial
     */
    public String getDateInitial() {
        return this.dateInitial;
    }
    /**
     * @return the dateEnd
     */
    public String getDateEnd() {
        return this.dateEnd;
    }
    /**
     * @return the workload
     */
    public int getWorkload() {
        return this.workload;
    }
}