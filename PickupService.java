package Cagas_Christian_Daniel_A_High;

public class PickupService implements Billable {
    
    private String customer;
    private double fee;

    public PickupService(String customer, double fee) {
        this.customer = customer;
        setFee(fee);
    }

    public void setFee(double fee) {
        if (fee > 0) {
            this.fee = fee;
        }
    }

    @Override 
    public double computeFee() {
        return fee;
    }

    @Override 
    public String getLabel() {
        return customer;
    }

    @Override 
    public void printReport() {
        System.out.printf("Pickup - %s: %.2f%n", customer, fee);
    }

}
