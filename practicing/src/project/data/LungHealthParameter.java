package project.data;

public class LungHealthParameter extends HealthParameter {
    private double spirometryResult;
    private double oxygenSaturation;
    private boolean isSmoker;

    @Override
    public void calculateScore() {
        double score = 0;

        // Spirometry Result Score
        if (spirometryResult >= 80) {
            score += 40; // Excellent
        } else if (spirometryResult >= 70) {
            score += 30; // Good
        } else if (spirometryResult >= 60) {
            score += 20; // Fair
        } else {
            score += 10; // Poor
        }

        // Oxygen Saturation Score
        if (oxygenSaturation >= 95) {
            score += 40; // Excellent
        } else if (oxygenSaturation >= 90) {
            score += 30; // Good
        } else if (oxygenSaturation >= 85) {
            score += 20; // Fair
        } else {
            score += 10; // Poor
        }

        // Smoking Status Score
        if (!isSmoker) {
            score += 20; // Non-smoker
        } else {
            score += 0; // Smoker
        }

        // Normalize score to a scale of 0 to 100
        setScore(score);
    }

    public LungHealthParameter(double spirometryResult, double oxygenSaturation, boolean isSmoker) {
        this.spirometryResult = spirometryResult;
        this.oxygenSaturation = oxygenSaturation;
        this.isSmoker = isSmoker;
    }

    // Constructors, getters, and setters
    public double getSpirometryResult() {
        return spirometryResult;
    }

    public void setSpirometryResult(double spirometryResult) {
        this.spirometryResult = spirometryResult;
    }

    public double getOxygenSaturation() {
        return oxygenSaturation;
    }

    public void setOxygenSaturation(double oxygenSaturation) {
        this.oxygenSaturation = oxygenSaturation;
    }

    public boolean isSmoker() {
        return isSmoker;
    }

    public void setSmoker(boolean isSmoker) {
        this.isSmoker = isSmoker;
    }

    public void setIsSmoker(boolean b) {
    }
}