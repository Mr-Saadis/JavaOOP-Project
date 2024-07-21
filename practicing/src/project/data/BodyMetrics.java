package project.data;
public class BodyMetrics extends HealthParameter {
    private double bmi; // Body Mass Index
    private double bodyFatPercentage; // Body fat percentage

    @Override
    public void calculateScore() {
        double score = 0;

        // BMI Score
        if (bmi >= 18.5 && bmi < 25) {
            score += 50; // Normal weight
        } else if (bmi >= 25 && bmi < 30) {
            score += 30; // Overweight
        } else if (bmi >= 30 && bmi < 35) {
            score += 10; // Obesity class I
        } else if (bmi >= 35 && bmi < 40) {
            score += 5; // Obesity class II
        } else if (bmi >= 40) {
            score += 0; // Obesity class III
        } else {
            score += 10; // Underweight
        }

        // Body Fat Percentage Score
        // Here, we'll assume a range of healthy body fat percentages:
        // - For men: 6-24%
        // - For women: 14-31%
        if (bodyFatPercentage >= 6 && bodyFatPercentage < 14) {
            score += 50; // Excellent for men
        } else if (bodyFatPercentage >= 14 && bodyFatPercentage < 18) {
            score += 40; // Good for men
        } else if (bodyFatPercentage >= 18 && bodyFatPercentage < 25) {
            score += 30; // Average for men
        } else if (bodyFatPercentage >= 25 && bodyFatPercentage < 31) {
            score += 20; // Below average for men
        } else if (bodyFatPercentage >= 31 && bodyFatPercentage <= 40) {
            score += 10; // Poor for men
        } else if (bodyFatPercentage < 6 || bodyFatPercentage > 40) {
            score += 0; // Extremely poor for men
        }

        // Normalize score to a scale of 0 to 100
        setScore(score);
    }

    // Constructors, getters, and setters


    public BodyMetrics(double bmi, double bodyFatPercentage) {
        this.bmi = bmi;
        this.bodyFatPercentage = bodyFatPercentage;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getBodyFatPercentage() {
        return bodyFatPercentage;
    }

    public void setBodyFatPercentage(double bodyFatPercentage) {
        this.bodyFatPercentage = bodyFatPercentage;
    }
}