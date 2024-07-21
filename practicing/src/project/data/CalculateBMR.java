package project.data;

public class CalculateBMR {
    User user ;
    double bmr;

    {
        user = User.getUser();
        if (user.getGender() == Gender.MALE) {
            bmr = 88.362 + (13.397 * user.getWeight()) + (4.799 * user.getHeight()) - (5.677 * user.getAge());
        } else {
            bmr = 447.593 + (9.247 * user.getWeight()) + (3.098 * user.getHeight()) - (4.330 * user.getAge());
        }
        // Adjust BMR based on activity level
        double tdee = bmr * 1.4;

        int lose = (int)(tdee * 0.8);
        int gain = (int)(tdee * 1.2);
        int maintain = (int)(tdee);

        BMR bmR = new BMR((int)(bmr),gain,lose,maintain);
        user.setBmr(bmR);
    }
}