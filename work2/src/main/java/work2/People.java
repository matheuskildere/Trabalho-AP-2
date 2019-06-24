package work2;
/**
 * The {@code People} help to save information about the participants.
 */
public class People {
    private String name;
    private String email;
    private long cpf;

    /**
    * @param name the name to set
    */
    public void setName(String name) {
        this.name = name;
    }
    /**
    * @param email the email to set
    */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
    * @param cpf the cpf to set
    */
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }
    /**
     * @return the cpf
     */
    public long getCpf() {
        return this.cpf;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

}