package registerDemo.core.concrete;

import registerDemo.entitiy.concrete.User;

public class MailSend {

     public static void send(User user){

      System.out.println("Aktivasyon maili başarı ile gönderildi: "+user.getEmail());
    }

}
