public class Customer {
    private String custId;
    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.custId = "cust0";
        while (checkCustId(custId)){
            String[] split = custId.split("t");
            int num = Integer.valueOf(split[1]);
            this.custId = "cust" + num++; // each time a match object is created match code increments
        }
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public boolean checkCustId(String custId){
        for(Customer customer: TrainBookingSystem.customerDetails){
            if(custId==customer.getCustId()){
                return true;
            }
        }
        return false;
    }
}
