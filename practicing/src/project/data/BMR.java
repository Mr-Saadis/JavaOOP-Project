package project.data;
public class BMR extends HealthParameter {
    private int bmr;
    private int gainWeightCalories;
    private int loseWeightCalories;
    private int MaintainWeightCalories;

    public BMR(int bmr, int gainWeightCalories, int loseWeightCalories, int maintainWeightCalories) {
        this.bmr = bmr;
        this.gainWeightCalories = gainWeightCalories;
        this.loseWeightCalories = loseWeightCalories;
        MaintainWeightCalories = maintainWeightCalories;
    }

    public int getGainWeightCalories() {
        return gainWeightCalories;
    }

    public void setGainWeightCalories(int gainWeightCalories) {
        this.gainWeightCalories = gainWeightCalories;
    }

    public int getLoseWeightCalories() {
        return loseWeightCalories;
    }

    public void setLoseWeightCalories(int loseWeightCalories) {
        this.loseWeightCalories = loseWeightCalories;
    }

    public int getMaintainWeightCalories() {
        return MaintainWeightCalories;
    }


    public void setMaintainWeightCalories(int maintainWeightCalories) {
        MaintainWeightCalories = maintainWeightCalories;
    }

    public double getBmr() {
        return bmr;
    }

    public void setBmr(int bmr) {
        this.bmr = bmr;
    }

    @Override
    public void calculateScore() {

        double score = 0;

        // Scoring based on BMR (example thresholds, can be adjusted based on specific health standards)
        if (bmr >= 1200 && bmr <= 1800) {
            score += 50; // Optimal range
        } else if ((bmr > 1800 && bmr <= 2200) || (bmr > 1000 && bmr < 1200)) {
            score += 30; // Slightly above or below optimal range
        } else if ((bmr > 2200 && bmr <= 2500) || (bmr >= 800 && bmr <= 1000)) {
            score += 10; // Moderately above or below optimal range
        } else {
            score += 0; // Far from optimal range
        }

        // Normalize score to a scale of 0 to 100
        setScore(score);
    }

    @Override
    public String toString() {
        return "BMR{" +
                "bmr=" + bmr +
                ", gainWeightCalories=" + gainWeightCalories +
                ", loseWeightCalories=" + loseWeightCalories +
                ", MaintainWeightCalories=" + MaintainWeightCalories +
                '}';
    }
}