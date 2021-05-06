import registerDemo.business.concrete.UserCheck;
import registerDemo.business.concrete.UserManager;
import registerDemo.core.concrete.MailVerification;
import registerDemo.dataAccess.abstracts.IUserDao;
import registerDemo.dataAccess.concrete.UserDao;
import registerDemo.entitiy.concrete.User;

public class Main {

    public static void main(String[] args) {

        User user1 = new User("abc@gmail.com","12345","Ahmet","Yıldız");
        User user2 = new User("abc2@gmail.com","12-456","Ahmet2","Yıldız2");
        User user3 = new User("abc3@gmail.com","12/456","Ahmet3","Yıldız3");
        User user4 = new User("abc4@gmail.com","123*56","Ahmet4","Yıldız4");

        UserManager userManager = new UserManager(new UserCheck(new UserDao()), new UserDao() {});
        userManager.singUp(user1);
        userManager.singUp(user2);

        MailVerification mailVerification = new MailVerification();
        mailVerification.verify(user2);

        userManager.singIn("abc2@gmail.com","12-456");
        userManager.singIn("abc@gmail.com","xxxx");































    }
}
