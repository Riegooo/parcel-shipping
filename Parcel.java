package Cagas_Christian_Daniel_A_High;

public abstract class Parcel implements Billable{

    protected String trackingNo;
    private double  weightKg;

    public static final double VAT_RATE = 0.12;
    private static int parcelCount = 0;

    public Parcel(String trackingNo, double weightKg) {
        this.trackingNo = trackingNo;

        if (weightKg <= 0){
            this.weightKg = 0;
            System.out.println("Invalid Weight");
        } else {
            this.weightKg = weightKg;
        }

        parcelCount++;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public static int getParcelCount(){
        return parcelCount;
    }

    public abstract double computeFee();

    public double computeFreewithVat() {
        return computeFee() * (1 + VAT_RATE);
    }

    public void printReport() {
        System.out.printf("Parcel [" + trackingNo + "] - " + weightKg + " kg%n");
    }

    public String getLabel(){
        return trackingNo;
    }



}