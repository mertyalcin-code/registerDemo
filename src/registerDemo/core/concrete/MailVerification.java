package registerDemo.core.concrete;

import registerDemo.core.abstracts.IMailVerification;
import registerDemo.dataAccess.abstracts.IUserDao;
import registerDemo.entitiy.concrete.User;

public class MailVerification implements IMailVerification {




    @Override
    public void verify(User user) {
        user.setEmailValidation(true);
        System.out.println("Kaydınız mail aktivasyonu ile tamamlandı: "+ user.getEmail());
    }
}
