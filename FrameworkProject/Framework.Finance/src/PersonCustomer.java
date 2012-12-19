import java.util.Date;

public class PersonCustomer extends Customer {
    protected Date birthDate;

    public PersonCustomer(String name, IOrganization institution) {
        super(name, institution);
    }

    /**
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
