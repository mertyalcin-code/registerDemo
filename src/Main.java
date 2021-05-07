import registerDemo.business.concrete.UserCheck;
import registerDemo.business.concrete.UserManager;
import registerDemo.core.concrete.GoogleSignInAdapter;
import registerDemo.core.concrete.GoogleSignUpAdapter;
import registerDemo.core.concrete.MailVerification;
import registerDemo.dataAccess.abstracts.IUserDao;
import registerDemo.dataAccess.concrete.UserDao;
import registerDemo.entitiy.concrete.User;

public class Main {

    public static void main(String[] args) {

        User user1 = new User("abc@gmail.com","123456","Ahmet","Yıldız");
        User user2 = new User("abc2@gmail.com","eksik","Ahmet2","Yıldız2");
        User user3 = new User("abc3","12/456","Ahmet3","Yıldız3");
        User user4 = new User("abc4@gmail.com","123*56","Ahmet4","Yıldız4");

        UserManager userManager = new UserManager(new UserCheck(new UserDao()), new UserDao() {});
        MailVerification mailVerification = new MailVerification();
        userManager.singUp(user1);//başarılı
        mailVerification.verify(user1);

        userManager.singUp(user2);//hatalı şifre
        userManager.singUp(user3);//hatalı mail

        userManager.singUp(user4);//başarılı
        mailVerification.verify(user4);

        userManager.singIn("abc@gmail.com","123456"); //başarılı
        userManager.singIn("abc@gmail.com","xxxx"); //başarısız
        userManager.singIn("abc2@gmail.com","eksik");//başarısız

        UserManager userManagerGoogle = new UserManager(new UserDao(),new GoogleSignUpAdapter(),new GoogleSignInAdapter());
        userManagerGoogle.SignUpWithGoogle("123@gmail.com");//başarılı
        userManagerGoogle.SignUpWithGoogle("12345@gmail.com");//başarılı
        userManagerGoogle.SignInWithGoogle("123@gmail.com");//başarılı
        userManagerGoogle.SignInWithGoogle("12345@gmail.com");//başarılı

        userManagerGoogle.SignInWithGoogle("nobody@gmail.com");// hatalı

































    }
}
