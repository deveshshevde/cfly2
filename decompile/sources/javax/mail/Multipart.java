package javax.mail;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

public abstract class Multipart {
    protected String contentType = "multipart/mixed";
    protected Part parent;
    protected Vector parts = new Vector();

    protected Multipart() {
    }

    public synchronized void addBodyPart(BodyPart bodyPart) throws MessagingException {
        if (this.parts == null) {
            this.parts = new Vector();
        }
        this.parts.addElement(bodyPart);
        bodyPart.setParent(this);
    }

    public synchronized void addBodyPart(BodyPart bodyPart, int i2) throws MessagingException {
        if (this.parts == null) {
            this.parts = new Vector();
        }
        this.parts.insertElementAt(bodyPart, i2);
        bodyPart.setParent(this);
    }

    public synchronized BodyPart getBodyPart(int i2) throws MessagingException {
        Vector vector;
        vector = this.parts;
        if (vector != null) {
        } else {
            throw new IndexOutOfBoundsException("No such BodyPart");
        }
        return (BodyPart) vector.elementAt(i2);
    }

    public String getContentType() {
        return this.contentType;
    }

    public synchronized int getCount() throws MessagingException {
        Vector vector = this.parts;
        if (vector == null) {
            return 0;
        }
        return vector.size();
    }

    public synchronized Part getParent() {
        return this.parent;
    }

    public synchronized void removeBodyPart(int i2) throws MessagingException {
        Vector vector = this.parts;
        if (vector != null) {
            this.parts.removeElementAt(i2);
            ((BodyPart) vector.elementAt(i2)).setParent((Multipart) null);
        } else {
            throw new IndexOutOfBoundsException("No such BodyPart");
        }
    }

    public synchronized boolean removeBodyPart(BodyPart bodyPart) throws MessagingException {
        boolean removeElement;
        Vector vector = this.parts;
        if (vector != null) {
            removeElement = vector.removeElement(bodyPart);
            bodyPart.setParent((Multipart) null);
        } else {
            throw new MessagingException("No such body part");
        }
        return removeElement;
    }

    /* access modifiers changed from: protected */
    public synchronized void setMultipartDataSource(MultipartDataSource multipartDataSource) throws MessagingException {
        this.contentType = multipartDataSource.getContentType();
        int count = multipartDataSource.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            addBodyPart(multipartDataSource.getBodyPart(i2));
        }
    }

    public synchronized void setParent(Part part) {
        this.parent = part;
    }

    public abstract void writeTo(OutputStream outputStream) throws IOException, MessagingException;
}
