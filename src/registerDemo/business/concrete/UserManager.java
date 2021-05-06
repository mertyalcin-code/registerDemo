package registerDemo.business.concrete;

import registerDemo.business.abstracts.UserCheckService;
import registerDemo.business.abstracts.UserService;
import registerDemo.core.concrete.MailSend;
import registerDemo.dataAccess.abstracts.IUserDao;
import registerDemo.entitiy.concrete.User;

import java.util.ArrayList;

public class UserManager implements UserService {

    UserCheckService userCheckService;
    IUserDao iUserDao;

    public UserManager(UserCheckService userCheckService, IUserDao iUserDao) {
        this.userCheckService = userCheckService;
        this.iUserDao = iUserDao;
    }

    @Override
    public void singUp(User user) {

        if (userCheckService.checkMail(user.getEmail()) == true) {
            if (userCheckService.checkAlreadyRegistered(user) == true) {
                if (userCheckService.checkFirstName(user.getFirstName())) {
                    if (userCheckService.checkLastName(user.getLastName())) {
                        if(userCheckService.checkPassword(user.getPassword())) {
                            iUserDao.add(user);
                            MailSend.send(user);
                        }

                        else {System.out.println("Hatalı Şifre");
                        }
                    }else
                        {System.out.println("Hatalı Soyisim");
                    }
                } else {
                    System.out.println("Hatalı isim");
                }
            } else {
                System.out.println("Daha önceden kayıt yapılmış");
            }
        } else {
            System.out.println("Email hatalı");
        }}






    @Override
    public void singIn(String email, String password) {
        ArrayList<User> users = new ArrayList<User>();
        users=iUserDao.getAll();
        User userLogin = null;
        boolean login = false;
        for (User user: users){
            if(user.getEmail()==email && user.getPassword()==password &&user.isEmailValidation()==true){
                login=true;
                userLogin=user;
            }
        }
        if(login==true){
            System.out.println("Kullanıcı adı ve şifre ile giriş başarılı: "+userLogin.getFirstName()+" "+userLogin.getLastName());
        }
        else {
            System.out.println("Hatalı email veya şifre ile giriş yapmaya çalıştınız ");
        }

    }
}
