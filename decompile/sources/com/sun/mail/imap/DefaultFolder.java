package com.sun.mail.imap;

import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.ListInfo;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;

public class DefaultFolder extends IMAPFolder {
    protected DefaultFolder(IMAPStore iMAPStore) {
        super("", 65535, iMAPStore);
        this.exists = true;
        this.type = 2;
    }

    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Cannot append to Default Folder");
    }

    public boolean delete(boolean z2) throws MessagingException {
        throw new MethodNotSupportedException("Cannot delete Default Folder");
    }

    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("Cannot expunge Default Folder");
    }

    public Folder getFolder(String str) throws MessagingException {
        return new IMAPFolder(str, 65535, (IMAPStore) this.store);
    }

    public String getName() {
        return this.fullName;
    }

    public Folder getParent() {
        return null;
    }

    public boolean hasNewMessages() throws MessagingException {
        return false;
    }

    public Folder[] list(final String str) throws MessagingException {
        ListInfo[] listInfoArr = null;
        ListInfo[] listInfoArr2 = (ListInfo[]) doCommand(new IMAPFolder.ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.list("", str);
            }
        });
        if (listInfoArr2 == null) {
            return new Folder[0];
        }
        int length = listInfoArr2.length;
        IMAPFolder[] iMAPFolderArr = new IMAPFolder[length];
        for (int i2 = 0; i2 < length; i2++) {
            iMAPFolderArr[i2] = new IMAPFolder(listInfoArr2[i2], (IMAPStore) this.store);
        }
        return iMAPFolderArr;
    }

    public Folder[] listSubscribed(final String str) throws MessagingException {
        ListInfo[] listInfoArr = null;
        ListInfo[] listInfoArr2 = (ListInfo[]) doCommand(new IMAPFolder.ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.lsub("", str);
            }
        });
        if (listInfoArr2 == null) {
            return new Folder[0];
        }
        int length = listInfoArr2.length;
        IMAPFolder[] iMAPFolderArr = new IMAPFolder[length];
        for (int i2 = 0; i2 < length; i2++) {
            iMAPFolderArr[i2] = new IMAPFolder(listInfoArr2[i2], (IMAPStore) this.store);
        }
        return iMAPFolderArr;
    }

    public boolean renameTo(Folder folder) throws MessagingException {
        throw new MethodNotSupportedException("Cannot rename Default Folder");
    }
}
