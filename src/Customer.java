public class Customer {
    private String custId;
    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName, String custId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.custId = custId;
    }

    public Customer() {
    }

    public void setCustId(String custId) {
        if(custId!= null){
        this.custId = custId;
        }
    }

    public void setFirstName(String firstName) {
        if(firstName!= null && firstName.matches( "[A-Z][a-z]*" )) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if(lastName != null && lastName.matches( "[A-Z][a-z]*" )){
            this.lastName = lastName;
        }
    }

    public String getCustId() {
        return custId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
