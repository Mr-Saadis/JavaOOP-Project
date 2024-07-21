package project.data;


import java.util.Arrays;

public class User {
    private static User user;

    public User() {
    }

    public static synchronized User getUser() {
        if(user == null){
            user = new User();
        }
        return user;
    }

    public void CreateReport(){
        HealthReport report = new HealthReport(user, Arrays.asList(lungHealthParameter, heartHealthParameter, brainHealthParameter,bmi, bmr));
        totalScore = report.generateReport();
    }


    private String userId;
    private String firstname;
    private String lastName;
    private int age;
    private Gender gender;
    private double height; // in centimeters
    private double weight; // in kilograms

    private HeartHealthParameter heartHealthParameter;
    private LungHealthParameter lungHealthParameter;
    private BrainHealthParameter brainHealthParameter;
    private BMR bmr;
    private BodyMetrics bmi;

    public BodyMetrics getBmi() {
        return bmi;
    }

    public void setBmi(BodyMetrics bmi) {
        this.bmi = bmi;
    }

    private double totalScore;

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public BMR getBmr() {
        return bmr;
    }

    public void setBmr(BMR bmr) {
        this.bmr = bmr;
    }

    public BrainHealthParameter getBrainHealthParameter() {
        return brainHealthParameter;
    }

    public void setBrainHealthParameter(BrainHealthParameter brainHealthParameter) {
        this.brainHealthParameter = brainHealthParameter;
    }

    // Constructor
    public User(String userId, String firstname,String lastName, int age, Gender gender, double height, double weight) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    // Getters and Setters


    public HeartHealthParameter getHeartHealthParameter() {
        return heartHealthParameter;
    }

    public void setHeartHealthParameter(HeartHealthParameter heartHealthParameter) {
        this.heartHealthParameter = heartHealthParameter;
    }

    public LungHealthParameter getLungHealthParameter() {
        return lungHealthParameter;
    }

    public void setLungHealthParameter(LungHealthParameter lungHealthParameter) {
        this.lungHealthParameter = lungHealthParameter;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", height=" + height +
                ", weight=" + weight +
                ", heartHealthParameter=" + heartHealthParameter +
                ", lungHealthParameter=" + lungHealthParameter +
                ", brainHealthParameter=" + brainHealthParameter +
                ", bmr=" + bmr +
                '}';
    }

}