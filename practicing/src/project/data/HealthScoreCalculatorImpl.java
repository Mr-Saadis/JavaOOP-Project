package project.data;

import java.util.List;

public class HealthScoreCalculatorImpl implements HealthScoreCalculator {
    @Override
    public double calculateOverallHealthScore(List<HealthParameter> parameters) {
        double totalScore = 0;
        double weightSum = 0;

        for (HealthParameter parameter : parameters) {
            double weight = getWeight(parameter);
            totalScore += parameter.getScore() * weight;
            weightSum += weight;
        }

        return totalScore / weightSum;
    }

    private double getWeight(HealthParameter parameter) {
        // Implement logic to determine the weight of each parameter
        // For example:
        if (parameter instanceof HeartHealthParameter) return 0.20;
        if (parameter instanceof BrainHealthParameter) return 0.10;
        if (parameter instanceof LungHealthParameter) return 0.10;
        if (parameter instanceof BodyMetrics) return 0.10;
        if (parameter instanceof BMR) return 0.10;
        // Adjust weights as necessary
        return 0.10;
    }
}
