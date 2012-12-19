public class CompanyCustomer extends Customer {
    protected int employeeCount;

    public CompanyCustomer(String name, IOrganization organization) {
        super(name, organization);
    }

    /**
     * @param employeeCount the noOfEmployees to set
     */
    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }
}
