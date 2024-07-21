package project.data;

public abstract class HealthParameter {
    private double score;
    public abstract void calculateScore();

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}