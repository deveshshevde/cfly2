package javax.mail;

import javax.mail.FetchProfile;

public interface UIDFolder {
    public static final long LASTUID = -1;

    public static class FetchProfileItem extends FetchProfile.Item {
        public static final FetchProfileItem UID = new FetchProfileItem("UID");

        protected FetchProfileItem(String str) {
            super(str);
        }
    }

    Message getMessageByUID(long j2) throws MessagingException;

    Message[] getMessagesByUID(long j2, long j3) throws MessagingException;

    Message[] getMessagesByUID(long[] jArr) throws MessagingException;

    long getUID(Message message) throws MessagingException;

    long getUIDValidity() throws MessagingException;
}
