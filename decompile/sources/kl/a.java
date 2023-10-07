package kl;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class a {

    /* renamed from: kl.a$a  reason: collision with other inner class name */
    static class C0210a extends Authenticator {

        /* renamed from: a  reason: collision with root package name */
        private String f30134a;

        /* renamed from: b  reason: collision with root package name */
        private String f30135b;

        public C0210a(String str, String str2) {
            this.f30134a = str;
            this.f30135b = str2;
        }

        /* access modifiers changed from: protected */
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(this.f30134a, this.f30135b);
        }
    }

    public void a(String str, String str2, String str3) throws Exception {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.exmail.qq.com");
        properties.put("mail.smtp.auth", "true");
        MimeMessage mimeMessage = new MimeMessage(Session.getDefaultInstance(properties, new C0210a(str3, "Cflyai2021@")));
        mimeMessage.setFrom(new InternetAddress(str3));
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(str3));
        mimeMessage.setSubject(str);
        mimeMessage.setText(MimeUtility.encodeWord(str2));
        MimeMultipart mimeMultipart = new MimeMultipart("mixed");
        new MimeBodyPart();
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText(str2);
        mimeMultipart.addBodyPart(mimeBodyPart);
        mimeMessage.setContent(mimeMultipart);
        mimeMessage.saveChanges();
        Transport.send(mimeMessage);
    }
}
