package com.quapt.myf4h.product.core.utill;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailServices extends Authenticator {
	
	String user;
    String pw;
    public MailServices (String username, String password)
    {
       super();
       this.user = username;
       this.pw = password;
    }
   public PasswordAuthentication getPasswordAuthentication()
   {
      return new PasswordAuthentication(user, pw);
   }

}
