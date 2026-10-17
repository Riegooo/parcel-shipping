package Cagas_Christian_Daniel_A_High;

public class DocumentParcel extends Parcel{
    
    private boolean express;

    public DocumentParcel(String trackingNo, double weightKg, boolean express) {
        super(trackingNo, weightKg);
        this.express = express;
        
    }

    public DocumentParcel(String trackingNo, double weightKg) {
        this(trackingNo, weightKg, false);
    }

    @Override 
    public double computeFee() {
        double fee = getWeightKg() * 40;

        if (express) {
            fee += 100;
        }

        return fee;
    }
}
