package javax.mail;

public class MessagingException extends Exception {
    private static final long serialVersionUID = -7569192289819959253L;
    private Exception next;

    public MessagingException() {
        initCause((Throwable) null);
    }

    public MessagingException(String str) {
        super(str);
        initCause((Throwable) null);
    }

    public MessagingException(String str, Exception exc) {
        super(str);
        this.next = exc;
        initCause((Throwable) null);
    }

    private final String superToString() {
        return super.toString();
    }

    public synchronized Throwable getCause() {
        return this.next;
    }

    public synchronized Exception getNextException() {
        return this.next;
    }

    public synchronized boolean setNextException(Exception exc) {
        boolean z2;
        Exception exc2 = this;
        while (true) {
            if (!(exc2 instanceof MessagingException)) {
                break;
            } else if (((MessagingException) exc2).next == null) {
                break;
            } else {
                exc2 = ((MessagingException) exc2).next;
            }
        }
        if (exc2 instanceof MessagingException) {
            ((MessagingException) exc2).next = exc;
            z2 = true;
        } else {
            z2 = false;
        }
        return z2;
    }

    public synchronized String toString() {
        String exc = super.toString();
        Exception exc2 = this.next;
        if (exc2 == null) {
            return exc;
        }
        if (exc == null) {
            exc = "";
        }
        StringBuffer stringBuffer = new StringBuffer(exc);
        while (exc2 != null) {
            stringBuffer.append(";\n  nested exception is:\n\t");
            if (exc2 instanceof MessagingException) {
                MessagingException messagingException = (MessagingException) exc2;
                stringBuffer.append(messagingException.superToString());
                exc2 = messagingException.next;
            } else {
                stringBuffer.append(exc2.toString());
                exc2 = null;
            }
        }
        return stringBuffer.toString();
    }
}
