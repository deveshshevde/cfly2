package com.sun.mail.imap;

import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import java.util.Vector;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.MultipartDataSource;
import javax.mail.internet.MimePart;
import javax.mail.internet.MimePartDataSource;

public class IMAPMultipartDataSource extends MimePartDataSource implements MultipartDataSource {
    private Vector parts;

    protected IMAPMultipartDataSource(MimePart mimePart, BODYSTRUCTURE[] bodystructureArr, String str, IMAPMessage iMAPMessage) {
        super(mimePart);
        String str2;
        this.parts = new Vector(bodystructureArr.length);
        for (int i2 = 0; i2 < bodystructureArr.length; i2++) {
            Vector vector = this.parts;
            BODYSTRUCTURE bodystructure = bodystructureArr[i2];
            if (str == null) {
                str2 = Integer.toString(i2 + 1);
            } else {
                str2 = String.valueOf(str) + "." + Integer.toString(i2 + 1);
            }
            vector.addElement(new IMAPBodyPart(bodystructure, str2, iMAPMessage));
        }
    }

    public BodyPart getBodyPart(int i2) throws MessagingException {
        return (BodyPart) this.parts.elementAt(i2);
    }

    public int getCount() {
        return this.parts.size();
    }
}
