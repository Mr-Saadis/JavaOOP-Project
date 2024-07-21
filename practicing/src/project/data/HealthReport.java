package project.data;
import java.util.List;

public class HealthReport {
    private User user;
    private List<HealthParameter> healthParameters;

    public HealthReport(User user, List<HealthParameter> healthParameters) {
        this.user = user;
        this.healthParameters = healthParameters;
    }

    public double generateReport() {

        double totalScore = 0;
        for (HealthParameter parameter : healthParameters) {
            parameter.calculateScore();
            totalScore += parameter.getScore();
        }

        return totalScore / healthParameters.size();
    }

    // Getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<HealthParameter> getHealthParameters() {
        return healthParameters;
    }

    public void setHealthParameters(List<HealthParameter> healthParameters) {
        this.healthParameters = healthParameters;
    }

}
