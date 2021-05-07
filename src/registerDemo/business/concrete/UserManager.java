package registerDemo.business.concrete;

import registerDemo.business.abstracts.UserCheckService;
import registerDemo.business.abstracts.UserService;
import registerDemo.core.abstracts.SignInService;
import registerDemo.core.abstracts.SignUpService;
import registerDemo.core.concrete.MailSend;
import registerDemo.dataAccess.abstracts.IUserDao;
import registerDemo.entitiy.concrete.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager implements UserService {

    UserCheckService userCheckService;
    IUserDao iUserDao;
    SignUpService signUpService;
    SignInService signInService;

    public UserManager(IUserDao iUserDao, SignUpService signUpService, SignInService signInService) {
        this.iUserDao = iUserDao;
        this.signUpService = signUpService;
        this.signInService = signInService;
    }

    public UserManager(UserCheckService userCheckService, IUserDao iUserDao) {
        this.userCheckService = userCheckService;
        this.iUserDao = iUserDao;
    }

    @Override
    public void singUp(User user) {

        if (userCheckService.checkMail(user.getEmail())) {
            if (userCheckService.checkAlreadyRegistered(user)) {
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
        ArrayList<User> users ;
        users=iUserDao.getAll();
        User userLogin = null;
        boolean login = false;
        for (User user: users){
            if(user.getEmail().equals(email) && user.getPassword().equals(password) && user.isEmailValidation()){
                login=true;
                userLogin=user;
            }
        }
        if(login){
            System.out.println("Kullanıcı adı ve şifre ile giriş başarılı: "+userLogin.getFirstName()+" "+userLogin.getLastName());
        }
        else {
            System.out.println("Hatalı email veya şifre ile giriş yapmaya çalıştınız ");
        }


    }

    @Override
    public void SignUpWithGoogle(String email) {
        if ( signUpService.signUpWithOthers(email)!=null){
            String emailToGo= signUpService.signUpWithOthers(email).get(0);
            String passwordToGo = signUpService.signUpWithOthers(email).get(1);
            String firstNameToGo=signUpService.signUpWithOthers(email).get(2);
            String lastNameToGo=signUpService.signUpWithOthers(email).get(3);
            iUserDao.add(new User(emailToGo,passwordToGo,firstNameToGo,lastNameToGo));


        }
        else{
            System.out.println("Google ile giriş başarısız");
        }
    }

    @Override
    public void SignInWithGoogle(String email) {
        List<String> listOfInfo ;
        listOfInfo =signInService.signInWithOthers(email);
        List<User> users ;
        users=iUserDao.getAll();

        User userLogin = null;
        boolean login = false;

        for (User user: users){
            if(user.getEmail().equals(listOfInfo.get(0)) && user.getPassword().equals(listOfInfo.get(1))){
                login=true;
                userLogin=user;
            }
        }
        if(login){
            System.out.println("Google ile giriş başarılı: "+userLogin.getFirstName()+" "+userLogin.getLastName()+" "+userLogin.getEmail());
        }
        else {
            System.out.println("Google ile giriş hatalı ");
        }

    }

}
