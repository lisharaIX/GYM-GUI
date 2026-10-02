
/**
 * Write a description of class RegularMember here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class RegularMember extends GymMember {
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;

    public RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String referralSource) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.referralSource = referralSource;
        this.isEligibleForUpgrade = false;
        this.attendanceLimit = 30;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = "";
    }

    public int getAttendanceLimit() {
        return attendanceLimit;
    }

    public boolean isEligibleForUpgrade() {
        return isEligibleForUpgrade;
    }

    public String getRemovalReason() {
        return removalReason;
    }

    public String getReferralSource() {
        return referralSource;
    }

    public String getPlan() {
        return plan;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void markAttendance() {
        super.attendance++;
        super.loyaltyPoints += 5;
        if (super.attendance >= attendanceLimit) {
            isEligibleForUpgrade = true;
        }
    }

    public double getPlanPrice(String plan) {
        switch (plan.toLowerCase()) {
            case "basic":
                return 6500;
            case "standard":
                return 12500;
            case "deluxe":
                return 18500;
            default:
                return -1;
        }
    }

    public String upgradePlan(String plan) {
        if (!isEligibleForUpgrade) {
            return "Member is not eligible for upgrade yet.";
        }

        if (this.plan.equalsIgnoreCase(plan)) {
            return "Member is already subscribed to the " + plan + " plan.";
        }

        double newPrice = getPlanPrice(plan);
        if (newPrice == -1) {
            return "Invalid plan provided.";
        } else {
            this.plan = plan;
            this.price = newPrice;
            return "Plan upgraded to " + plan + " successfully.";
        }
    }

    public void revertRegularMember(String removalReason) {
        super.resetMember();
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = removalReason;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        if (!removalReason.isEmpty()) {
            System.out.println("Removal Reason: " + removalReason);
        }
    }
    }
