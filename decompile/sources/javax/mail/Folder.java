package javax.mail;

import java.util.Vector;
import javax.mail.Flags;
import javax.mail.event.ConnectionEvent;
import javax.mail.event.ConnectionListener;
import javax.mail.event.FolderEvent;
import javax.mail.event.FolderListener;
import javax.mail.event.MailEvent;
import javax.mail.event.MessageChangedEvent;
import javax.mail.event.MessageChangedListener;
import javax.mail.event.MessageCountEvent;
import javax.mail.event.MessageCountListener;
import javax.mail.search.SearchTerm;

public abstract class Folder {
    public static final int HOLDS_FOLDERS = 2;
    public static final int HOLDS_MESSAGES = 1;
    public static final int READ_ONLY = 1;
    public static final int READ_WRITE = 2;
    private volatile Vector connectionListeners = null;
    private volatile Vector folderListeners = null;
    private volatile Vector messageChangedListeners = null;
    private volatile Vector messageCountListeners = null;
    protected int mode = -1;

    /* renamed from: q  reason: collision with root package name */
    private EventQueue f29472q;
    private Object qLock = new Object();
    protected Store store;

    static class TerminatorEvent extends MailEvent {
        private static final long serialVersionUID = 3765761925441296565L;

        TerminatorEvent() {
            super(new Object());
        }

        public void dispatch(Object obj) {
            Thread.currentThread().interrupt();
        }
    }

    protected Folder(Store store2) {
        this.store = store2;
    }

    private void queueEvent(MailEvent mailEvent, Vector vector) {
        synchronized (this.qLock) {
            if (this.f29472q == null) {
                this.f29472q = new EventQueue();
            }
        }
        this.f29472q.enqueue(mailEvent, (Vector) vector.clone());
    }

    private void terminateQueue() {
        synchronized (this.qLock) {
            if (this.f29472q != null) {
                Vector vector = new Vector();
                vector.setSize(1);
                this.f29472q.enqueue(new TerminatorEvent(), vector);
                this.f29472q = null;
            }
        }
    }

    public synchronized void addConnectionListener(ConnectionListener connectionListener) {
        if (this.connectionListeners == null) {
            this.connectionListeners = new Vector();
        }
        this.connectionListeners.addElement(connectionListener);
    }

    public synchronized void addFolderListener(FolderListener folderListener) {
        if (this.folderListeners == null) {
            this.folderListeners = new Vector();
        }
        this.folderListeners.addElement(folderListener);
    }

    public synchronized void addMessageChangedListener(MessageChangedListener messageChangedListener) {
        if (this.messageChangedListeners == null) {
            this.messageChangedListeners = new Vector();
        }
        this.messageChangedListeners.addElement(messageChangedListener);
    }

    public synchronized void addMessageCountListener(MessageCountListener messageCountListener) {
        if (this.messageCountListeners == null) {
            this.messageCountListeners = new Vector();
        }
        this.messageCountListeners.addElement(messageCountListener);
    }

    public abstract void appendMessages(Message[] messageArr) throws MessagingException;

    public abstract void close(boolean z2) throws MessagingException;

    public void copyMessages(Message[] messageArr, Folder folder) throws MessagingException {
        if (folder.exists()) {
            folder.appendMessages(messageArr);
            return;
        }
        throw new FolderNotFoundException(String.valueOf(folder.getFullName()) + " does not exist", folder);
    }

    public abstract boolean create(int i2) throws MessagingException;

    public abstract boolean delete(boolean z2) throws MessagingException;

    public abstract boolean exists() throws MessagingException;

    public abstract Message[] expunge() throws MessagingException;

    public void fetch(Message[] messageArr, FetchProfile fetchProfile) throws MessagingException {
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        terminateQueue();
    }

    public synchronized int getDeletedMessageCount() throws MessagingException {
        if (!isOpen()) {
            return -1;
        }
        int i2 = 0;
        int messageCount = getMessageCount();
        for (int i3 = 1; i3 <= messageCount; i3++) {
            try {
                if (getMessage(i3).isSet(Flags.Flag.DELETED)) {
                    i2++;
                }
            } catch (MessageRemovedException unused) {
            }
        }
        return i2;
    }

    public abstract Folder getFolder(String str) throws MessagingException;

    public abstract String getFullName();

    public abstract Message getMessage(int i2) throws MessagingException;

    public abstract int getMessageCount() throws MessagingException;

    public synchronized Message[] getMessages() throws MessagingException {
        Message[] messageArr;
        if (isOpen()) {
            int messageCount = getMessageCount();
            messageArr = new Message[messageCount];
            for (int i2 = 1; i2 <= messageCount; i2++) {
                messageArr[i2 - 1] = getMessage(i2);
            }
        } else {
            throw new IllegalStateException("Folder not open");
        }
        return messageArr;
    }

    public synchronized Message[] getMessages(int i2, int i3) throws MessagingException {
        Message[] messageArr;
        messageArr = new Message[((i3 - i2) + 1)];
        for (int i4 = i2; i4 <= i3; i4++) {
            messageArr[i4 - i2] = getMessage(i4);
        }
        return messageArr;
    }

    public synchronized Message[] getMessages(int[] iArr) throws MessagingException {
        Message[] messageArr;
        int length = iArr.length;
        messageArr = new Message[length];
        for (int i2 = 0; i2 < length; i2++) {
            messageArr[i2] = getMessage(iArr[i2]);
        }
        return messageArr;
    }

    public int getMode() {
        if (isOpen()) {
            return this.mode;
        }
        throw new IllegalStateException("Folder not open");
    }

    public abstract String getName();

    public synchronized int getNewMessageCount() throws MessagingException {
        if (!isOpen()) {
            return -1;
        }
        int i2 = 0;
        int messageCount = getMessageCount();
        for (int i3 = 1; i3 <= messageCount; i3++) {
            try {
                if (getMessage(i3).isSet(Flags.Flag.RECENT)) {
                    i2++;
                }
            } catch (MessageRemovedException unused) {
            }
        }
        return i2;
    }

    public abstract Folder getParent() throws MessagingException;

    public abstract Flags getPermanentFlags();

    public abstract char getSeparator() throws MessagingException;

    public Store getStore() {
        return this.store;
    }

    public abstract int getType() throws MessagingException;

    public URLName getURLName() throws MessagingException {
        URLName uRLName = getStore().getURLName();
        String fullName = getFullName();
        StringBuffer stringBuffer = new StringBuffer();
        getSeparator();
        if (fullName != null) {
            stringBuffer.append(fullName);
        }
        return new URLName(uRLName.getProtocol(), uRLName.getHost(), uRLName.getPort(), stringBuffer.toString(), uRLName.getUsername(), (String) null);
    }

    public synchronized int getUnreadMessageCount() throws MessagingException {
        if (!isOpen()) {
            return -1;
        }
        int i2 = 0;
        int messageCount = getMessageCount();
        for (int i3 = 1; i3 <= messageCount; i3++) {
            try {
                if (!getMessage(i3).isSet(Flags.Flag.SEEN)) {
                    i2++;
                }
            } catch (MessageRemovedException unused) {
            }
        }
        return i2;
    }

    public abstract boolean hasNewMessages() throws MessagingException;

    public abstract boolean isOpen();

    public boolean isSubscribed() {
        return true;
    }

    public Folder[] list() throws MessagingException {
        return list("%");
    }

    public abstract Folder[] list(String str) throws MessagingException;

    public Folder[] listSubscribed() throws MessagingException {
        return listSubscribed("%");
    }

    public Folder[] listSubscribed(String str) throws MessagingException {
        return list(str);
    }

    /* access modifiers changed from: protected */
    public void notifyConnectionListeners(int i2) {
        if (this.connectionListeners != null) {
            queueEvent(new ConnectionEvent(this, i2), this.connectionListeners);
        }
        if (i2 == 3) {
            terminateQueue();
        }
    }

    /* access modifiers changed from: protected */
    public void notifyFolderListeners(int i2) {
        if (this.folderListeners != null) {
            queueEvent(new FolderEvent(this, this, i2), this.folderListeners);
        }
        this.store.notifyFolderListeners(i2, this);
    }

    /* access modifiers changed from: protected */
    public void notifyFolderRenamedListeners(Folder folder) {
        if (this.folderListeners != null) {
            queueEvent(new FolderEvent(this, this, folder, 3), this.folderListeners);
        }
        this.store.notifyFolderRenamedListeners(this, folder);
    }

    /* access modifiers changed from: protected */
    public void notifyMessageAddedListeners(Message[] messageArr) {
        if (this.messageCountListeners != null) {
            queueEvent(new MessageCountEvent(this, 1, false, messageArr), this.messageCountListeners);
        }
    }

    /* access modifiers changed from: protected */
    public void notifyMessageChangedListeners(int i2, Message message) {
        if (this.messageChangedListeners != null) {
            queueEvent(new MessageChangedEvent(this, i2, message), this.messageChangedListeners);
        }
    }

    /* access modifiers changed from: protected */
    public void notifyMessageRemovedListeners(boolean z2, Message[] messageArr) {
        if (this.messageCountListeners != null) {
            queueEvent(new MessageCountEvent(this, 2, z2, messageArr), this.messageCountListeners);
        }
    }

    public abstract void open(int i2) throws MessagingException;

    public synchronized void removeConnectionListener(ConnectionListener connectionListener) {
        if (this.connectionListeners != null) {
            this.connectionListeners.removeElement(connectionListener);
        }
    }

    public synchronized void removeFolderListener(FolderListener folderListener) {
        if (this.folderListeners != null) {
            this.folderListeners.removeElement(folderListener);
        }
    }

    public synchronized void removeMessageChangedListener(MessageChangedListener messageChangedListener) {
        if (this.messageChangedListeners != null) {
            this.messageChangedListeners.removeElement(messageChangedListener);
        }
    }

    public synchronized void removeMessageCountListener(MessageCountListener messageCountListener) {
        if (this.messageCountListeners != null) {
            this.messageCountListeners.removeElement(messageCountListener);
        }
    }

    public abstract boolean renameTo(Folder folder) throws MessagingException;

    public Message[] search(SearchTerm searchTerm) throws MessagingException {
        return search(searchTerm, getMessages());
    }

    public Message[] search(SearchTerm searchTerm, Message[] messageArr) throws MessagingException {
        Vector vector = new Vector();
        for (int i2 = 0; i2 < messageArr.length; i2++) {
            try {
                if (messageArr[i2].match(searchTerm)) {
                    vector.addElement(messageArr[i2]);
                }
            } catch (MessageRemovedException unused) {
            }
        }
        Message[] messageArr2 = new Message[vector.size()];
        vector.copyInto(messageArr2);
        return messageArr2;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setFlags(int r2, int r3, javax.mail.Flags r4, boolean r5) throws javax.mail.MessagingException {
        /*
            r1 = this;
            monitor-enter(r1)
        L_0x0001:
            if (r2 <= r3) goto L_0x0005
            monitor-exit(r1)
            return
        L_0x0005:
            javax.mail.Message r0 = r1.getMessage(r2)     // Catch:{ MessageRemovedException -> 0x0010, all -> 0x000d }
            r0.setFlags(r4, r5)     // Catch:{ MessageRemovedException -> 0x0010, all -> 0x000d }
            goto L_0x0010
        L_0x000d:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x0010:
            int r2 = r2 + 1
            goto L_0x0001
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Folder.setFlags(int, int, javax.mail.Flags, boolean):void");
    }

    public synchronized void setFlags(int[] iArr, Flags flags, boolean z2) throws MessagingException {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            try {
                getMessage(iArr[i2]).setFlags(flags, z2);
            } catch (MessageRemovedException unused) {
            }
        }
    }

    public synchronized void setFlags(Message[] messageArr, Flags flags, boolean z2) throws MessagingException {
        for (int i2 = 0; i2 < messageArr.length; i2++) {
            try {
                messageArr[i2].setFlags(flags, z2);
            } catch (MessageRemovedException unused) {
            }
        }
    }

    public void setSubscribed(boolean z2) throws MessagingException {
        throw new MethodNotSupportedException();
    }

    public String toString() {
        String fullName = getFullName();
        return fullName != null ? fullName : super.toString();
    }
}
