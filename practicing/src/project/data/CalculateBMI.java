package project.data;

public class CalculateBMI {
    User user;
    double bmi;
    double bodyFat;
    {
        user = User.getUser();
        bmi = (user.getWeight()/ user.getHeight()/ user.getHeight())*10000;

        if(user.getGender()== Gender.MALE){
            bodyFat = (1.20*bmi)+(0.23*user.getAge())-16.2;
        }else {
            bodyFat = (1.20*bmi)+(0.23*user.getAge())-16.2;
        }

        BodyMetrics bmI = new BodyMetrics(bmi,bodyFat);
        user.setBmi(bmI);
    }
}