package mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtils {

	private String from ="";
	private String to="";
	private String msg="";
	private String host="";
	private String subject="";
	private int port;
	
	String getsubject(){
		return this.subject;
	}

	void setsubject(String subject){
		this.subject = subject;
	}
	
	String getform(){
		return this.from;
	}

	void setfrom(String from){
		this.from = from;
	}
	
	String getto(){
		return this.to; 
	}

	void setto(String to){
		this.to = to;
	}
	
	void setmsg(String msg){
		this.msg = msg;
	}

	String getmsg(){
		return this.msg;
	}
	
	
	String gethost(){
		return this.host;
	}

	void sethost(String host){
		this.host = host;
	}
	
	int getport(){
		return this.port;
	}
	
	void setport(int port){
		this.port = port;
	}
	
	void sendaEmail(){
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        String msgBody = this.msg;

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from, from.substring(0, from.indexOf("@"))));
            msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress(to, to.substring(0, to.indexOf("@"))));
            msg.setSubject(subject);
            msg.setText(msgBody);
            Transport.send(msg);

        } catch (Throwable e) {
            // ...
        }
	}
	
	
}
