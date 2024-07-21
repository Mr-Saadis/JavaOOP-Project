package project.data;

import java.util.List;

public interface HealthScoreCalculator {
    double calculateOverallHealthScore(List<HealthParameter> parameters);
}
