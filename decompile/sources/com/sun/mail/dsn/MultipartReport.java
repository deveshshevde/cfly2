package com.sun.mail.dsn;

import java.io.IOException;
import java.util.Vector;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MultipartReport extends MimeMultipart {
    protected boolean constructed;

    public MultipartReport() throws MessagingException {
        super("report");
        setBodyPart(new MimeBodyPart(), 0);
        setBodyPart(new MimeBodyPart(), 1);
        this.constructed = true;
    }

    public MultipartReport(String str, DeliveryStatus deliveryStatus) throws MessagingException {
        super("report");
        ContentType contentType = new ContentType(this.contentType);
        contentType.setParameter("report-type", "delivery-status");
        this.contentType = contentType.toString();
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText(str);
        setBodyPart(mimeBodyPart, 0);
        MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
        mimeBodyPart2.setContent(deliveryStatus, "message/delivery-status");
        setBodyPart(mimeBodyPart2, 1);
        this.constructed = true;
    }

    public MultipartReport(String str, DeliveryStatus deliveryStatus, InternetHeaders internetHeaders) throws MessagingException {
        this(str, deliveryStatus);
        if (internetHeaders != null) {
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(new MessageHeaders(internetHeaders), "text/rfc822-headers");
            setBodyPart(mimeBodyPart, 2);
        }
    }

    public MultipartReport(String str, DeliveryStatus deliveryStatus, MimeMessage mimeMessage) throws MessagingException {
        this(str, deliveryStatus);
        if (mimeMessage != null) {
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(mimeMessage, "message/rfc822");
            setBodyPart(mimeBodyPart, 2);
        }
    }

    public MultipartReport(DataSource dataSource) throws MessagingException {
        super(dataSource);
        parse();
        this.constructed = true;
    }

    private synchronized void setBodyPart(BodyPart bodyPart, int i2) throws MessagingException {
        if (this.parts == null) {
            this.parts = new Vector();
        }
        if (i2 < this.parts.size()) {
            super.removeBodyPart(i2);
        }
        super.addBodyPart(bodyPart, i2);
    }

    public synchronized void addBodyPart(BodyPart bodyPart) throws MessagingException {
        if (!this.constructed) {
            super.addBodyPart(bodyPart);
        } else {
            throw new MessagingException("Can't add body parts to multipart/report 1");
        }
    }

    public synchronized void addBodyPart(BodyPart bodyPart, int i2) throws MessagingException {
        throw new MessagingException("Can't add body parts to multipart/report 2");
    }

    public synchronized DeliveryStatus getDeliveryStatus() throws MessagingException {
        if (getCount() < 2) {
            return null;
        }
        BodyPart bodyPart = getBodyPart(1);
        if (!bodyPart.isMimeType("message/delivery-status")) {
            return null;
        }
        try {
            return (DeliveryStatus) bodyPart.getContent();
        } catch (IOException e2) {
            throw new MessagingException("IOException getting DeliveryStatus", e2);
        }
    }

    public synchronized MimeMessage getReturnedMessage() throws MessagingException {
        if (getCount() < 3) {
            return null;
        }
        BodyPart bodyPart = getBodyPart(2);
        if (!bodyPart.isMimeType("message/rfc822") && !bodyPart.isMimeType("text/rfc822-headers")) {
            return null;
        }
        try {
            return (MimeMessage) bodyPart.getContent();
        } catch (IOException e2) {
            throw new MessagingException("IOException getting ReturnedMessage", e2);
        }
    }

    public synchronized String getText() throws MessagingException {
        try {
            BodyPart bodyPart = getBodyPart(0);
            if (bodyPart.isMimeType("text/plain")) {
                return (String) bodyPart.getContent();
            }
            if (bodyPart.isMimeType("multipart/alternative")) {
                Multipart multipart = (Multipart) bodyPart.getContent();
                for (int i2 = 0; i2 < multipart.getCount(); i2++) {
                    BodyPart bodyPart2 = multipart.getBodyPart(i2);
                    if (bodyPart2.isMimeType("text/plain")) {
                        return (String) bodyPart2.getContent();
                    }
                }
            }
            return null;
        } catch (IOException e2) {
            throw new MessagingException("Exception getting text content", e2);
        }
    }

    public synchronized MimeBodyPart getTextBodyPart() throws MessagingException {
        return (MimeBodyPart) getBodyPart(0);
    }

    public void removeBodyPart(int i2) throws MessagingException {
        throw new MessagingException("Can't remove body parts from multipart/report");
    }

    public boolean removeBodyPart(BodyPart bodyPart) throws MessagingException {
        throw new MessagingException("Can't remove body parts from multipart/report");
    }

    public synchronized void setDeliveryStatus(DeliveryStatus deliveryStatus) throws MessagingException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(deliveryStatus, "message/delivery-status");
        setBodyPart(mimeBodyPart, 2);
        ContentType contentType = new ContentType(this.contentType);
        contentType.setParameter("report-type", "delivery-status");
        this.contentType = contentType.toString();
    }

    public synchronized void setReturnedMessage(MimeMessage mimeMessage) throws MessagingException {
        if (mimeMessage == null) {
            BodyPart bodyPart = (BodyPart) this.parts.elementAt(2);
            super.removeBodyPart(2);
            return;
        }
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(mimeMessage, mimeMessage instanceof MessageHeaders ? "text/rfc822-headers" : "message/rfc822");
        setBodyPart(mimeBodyPart, 2);
    }

    public synchronized void setSubType(String str) throws MessagingException {
        throw new MessagingException("Can't change subtype of MultipartReport");
    }

    public synchronized void setText(String str) throws MessagingException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText(str);
        setBodyPart(mimeBodyPart, 0);
    }

    public synchronized void setTextBodyPart(MimeBodyPart mimeBodyPart) throws MessagingException {
        setBodyPart(mimeBodyPart, 0);
    }
}
