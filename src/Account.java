public class Account {

    private String number;
    private double balance;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

    public Account() {
        // constructor chaining
        this("100001", 0.0, "Default Name", "Default email", "Default phone");

        System.out.println("Empty constructor called");
    }

    public Account(String number, double balance, String customerName, String email, String phone) {
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        customerEmail = email;
        customerPhone = phone;
    }

    public void depositFunds(double depositAmount) {
        this.balance += depositAmount;
        System.out.println("Deposit of $" + depositAmount + " made. New balance is $" +  this.balance);
    }

    public void withdrawFunds(double withdrawlAmount){
        if (balance - withdrawlAmount < 0){
            if (balance == 0.0) {
                System.out.println("Insufficient Funds! You have no money in your account.");

            } else {
                System.out.println("Insufficient Funds! You only have $" + this.balance +
                        " in your account.");
            }

        } else {
            balance -= withdrawlAmount;
            System.out.println("Withdrawal of $ "+withdrawlAmount +
                    " processed. Remaining balance = $"+ balance);
        }

    }



    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
