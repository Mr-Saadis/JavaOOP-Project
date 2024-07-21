package project.data;
public class HeartHealthParameter extends HealthParameter {
    private double bloodPressure; // Assuming this is systolic BP
    private int restingHeartRate; // in BPM
    private double cholesterolLevel; // in mg/dL
    private int physicalActivity; // in minutes per week
    private String bloodGroup;

    public HeartHealthParameter(double bloodPressure, int restingHeartRate, double cholesterolLevel, int physicalActivity,String bloodGroup) {
        this.bloodPressure = bloodPressure;
        this.restingHeartRate = restingHeartRate;
        this.cholesterolLevel = cholesterolLevel;
        this.physicalActivity = physicalActivity;
        this.bloodGroup = bloodGroup;
    }

    public HeartHealthParameter() {
    }

    @Override
    public void calculateScore() {
        double score = 0;

        // Blood Pressure Score
        if (bloodPressure < 120) {
            score += 20; // Normal
        } else if (bloodPressure < 130) {
            score += 15; // Elevated
        } else if (bloodPressure < 140) {
            score += 10; // Hypertension Stage 1
        } else if (bloodPressure < 180) {
            score += 5; // Hypertension Stage 2
        } else {
            score += 0; // Hypertensive Crisis
        }

        // Resting Heart Rate Score
        if (restingHeartRate < 60) {
            score += 20; // Excellent
        } else if (restingHeartRate < 70) {
            score += 15; // Good
        } else if (restingHeartRate < 80) {
            score += 10; // Average
        } else if (restingHeartRate < 90) {
            score += 5; // Below Average
        } else {
            score += 0; // Poor
        }

        // Cholesterol Level Score
        if (cholesterolLevel < 200) {
            score += 20; // Desirable
        } else if (cholesterolLevel < 240) {
            score += 10; // Borderline High
        } else {
            score += 0; // High
        }

        // Physical Activity Score
        if (physicalActivity >= 150) {
            score += 20; // Active
        } else if (physicalActivity >= 75) {
            score += 10; // Moderately Active
        } else {
            score += 5; // Inactive
        }

        // Normalize score to a scale of 0 to 100
        setScore(score);
    }

    // Constructors, getters, and setters
    public double getBloodPressure() {
        return bloodPressure;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getRestingHeartRate() {
        return restingHeartRate;
    }

    public void setRestingHeartRate(int restingHeartRate) {
        this.restingHeartRate = restingHeartRate;
    }

    public double getCholesterolLevel() {
        return cholesterolLevel;
    }

    public void setCholesterolLevel(double cholesterolLevel) {
        this.cholesterolLevel = cholesterolLevel;
    }

    public int getPhysicalActivity() {
        return physicalActivity;
    }

    public void setPhysicalActivity(int physicalActivity) {
        this.physicalActivity = physicalActivity;
    }

    @Override
    public String toString() {
        return "HeartHealthParameter{" +
                "bloodPressure=" + bloodPressure +
                ", restingHeartRate=" + restingHeartRate +
                ", cholesterolLevel=" + cholesterolLevel +
                ", physicalActivity=" + physicalActivity +
                '}';
    }
}