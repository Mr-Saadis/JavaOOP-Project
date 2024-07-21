package project.data;
public class BrainHealthParameter extends HealthParameter {
    private int cognitiveFunctionScore; // Score from cognitive tests, range 0-100
    private int sleepQualityScore; // Score from sleep quality assessment, range 0-100
    private int mentalHealthScore; // Score from mental health assessment, range 0-100

    public BrainHealthParameter(int cognitiveFunctionScore, int sleepQualityScore, int mentalHealthScore) {
        this.cognitiveFunctionScore = cognitiveFunctionScore;
        this.sleepQualityScore = sleepQualityScore;
        this.mentalHealthScore = mentalHealthScore;
    }

    @Override
    public void calculateScore() {
        double score = 0;

        // Cognitive Function Score
        if (cognitiveFunctionScore >= 90) {
            score += 40; // Excellent
        } else if (cognitiveFunctionScore >= 75) {
            score += 30; // Good
        } else if (cognitiveFunctionScore >= 60) {
            score += 20; // Average
        } else if (cognitiveFunctionScore >= 40) {
            score += 10; // Below Average
        } else {
            score += 0; // Poor
        }

        // Sleep Quality Score
        if (sleepQualityScore >= 90) {
            score += 30; // Excellent
        } else if (sleepQualityScore >= 75) {
            score += 20; // Good
        } else if (sleepQualityScore >= 60) {
            score += 10; // Average
        } else {
            score += 0; // Poor
        }

        // Mental Health Score
        if (mentalHealthScore >= 90) {
            score += 30; // Excellent
        } else if (mentalHealthScore >= 75) {
            score += 20; // Good
        } else if (mentalHealthScore >= 60) {
            score += 10; // Average
        } else {
            score += 0; // Poor
        }

        // Normalize score to a scale of 0 to 100
        setScore(score);
    }

    // Constructors, getters, and setters
    public int getCognitiveFunctionScore() {
        return cognitiveFunctionScore;
    }

    public void setCognitiveFunctionScore(int cognitiveFunctionScore) {
        this.cognitiveFunctionScore = cognitiveFunctionScore;
    }

    public int getSleepQualityScore() {
        return sleepQualityScore;
    }

    public void setSleepQualityScore(int sleepQualityScore) {
        this.sleepQualityScore = sleepQualityScore;
    }

    public int getMentalHealthScore() {
        return mentalHealthScore;
    }

    public void setMentalHealthScore(int mentalHealthScore) {
        this.mentalHealthScore = mentalHealthScore;
    }
}