package Cagas_Christian_Daniel_A_High;

public class FragileParcel extends Parcel{

    private double declaredValue;

    public FragileParcel(String trackingNo, double weightKg, double declaredValue) {
        super(trackingNo, weightKg);
        this.declaredValue = declaredValue;
    }

    @Override 
    public double computeFee() {
        return (getWeightKg() * 60) + (declaredValue * 0.02);
    }

    @Override 
    public void printReport() {
        super.printReport();

        System.out.printf(" Declared value: %.2f%n", declaredValue);
    }
    
}
