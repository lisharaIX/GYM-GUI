
/**
 * Write a description of class PremiumMember here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class PremiumMember extends GymMember 
{
    private final double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;

    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.premiumCharge = 50000;
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    public double getPremiumCharge() {
        return premiumCharge;
    }

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public boolean isFullPayment() {
        return isFullPayment;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public String payDueAmount(double paidAmount) {
        if (this.isFullPayment) {
            return "Payment is already full.";
        }

        this.paidAmount += paidAmount;

        if (this.paidAmount > this.premiumCharge) {
            return "Payment exceeds the premium charge.";
        }

        double remainingAmount = this.premiumCharge - this.paidAmount;

        if (this.paidAmount == this.premiumCharge) {
            this.isFullPayment = true;
            return "Payment successful. Remaining amount: 0";
        } else {
            return "Payment successful. Remaining amount: " + remainingAmount;
        }
    }

    public void calculateDiscount() {
        if (this.isFullPayment) {
            this.discountAmount = 0.10 * this.premiumCharge;
            System.out.println("Discount calculated: " + this.discountAmount);
        } else {
            System.out.println("No discount applied. Payment is not full.");
        }
    }

    public void revertPremiumMember() {
        super.resetMember();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Is Full Payment: " + isFullPayment);

        double remainingAmount = premiumCharge - paidAmount;
        System.out.println("Remaining Amount: " + remainingAmount);

        if (isFullPayment) {
            System.out.println("Discount Amount: " + discountAmount);
        }
    }

    @Override
    public void markAttendance(){
        super.attendance++;
        super.loyaltyPoints += 10;
    }
}