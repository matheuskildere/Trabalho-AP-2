package work2;

public class Event {
    private String nameEvent;
    private String nameResponsible;
    private String city;
    private String uf;
    private String dateInitial;
    private String dateEnd;
    private int workload;

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public void setNameResponsible(String nameResponsible) {
        this.nameResponsible = nameResponsible;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setDateInitial(String dateInitial) {
        this.dateInitial = dateInitial;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public String getNameEvent() {
        return this.nameEvent;
    }

    public String getNameResponsible() {
        return this.nameResponsible;
    }

    public String getCity() {
        return this.city;
    }

    public String getUf() {
        return this.uf;
    }

    public String getDateInitial() {
        return this.dateInitial;
    }

    public String getDateEnd() {
        return this.dateEnd;
    }

    public int getWorkload() {
        return this.workload;
    }
}