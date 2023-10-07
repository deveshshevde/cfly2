package com.sun.mail.imap;

import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.iap.ResponseHandler;
import com.sun.mail.imap.Utility;
import com.sun.mail.imap.protocol.FetchResponse;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.IMAPResponse;
import com.sun.mail.imap.protocol.ListInfo;
import com.sun.mail.imap.protocol.MessageSet;
import com.sun.mail.imap.protocol.Status;
import com.sun.mail.imap.protocol.UID;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Vector;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.FolderNotFoundException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Quota;
import javax.mail.StoreClosedException;
import javax.mail.UIDFolder;
import javax.mail.search.FlagTerm;

public class IMAPFolder extends Folder implements ResponseHandler, UIDFolder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ABORTING = 2;
    private static final int IDLE = 1;
    private static final int RUNNING = 0;
    protected static final char UNKNOWN_SEPARATOR = '￿';
    protected String[] attributes;
    protected Flags availableFlags;
    private Status cachedStatus;
    private long cachedStatusTime;
    private boolean connectionPoolDebug;
    private boolean debug;
    private boolean doExpungeNotification;
    protected boolean exists;
    protected String fullName;
    /* access modifiers changed from: private */
    public int idleState;
    protected boolean isNamespace;
    protected Vector messageCache;
    protected Object messageCacheLock;
    protected String name;
    private boolean opened;
    private PrintStream out;
    protected Flags permanentFlags;
    protected IMAPProtocol protocol;
    private int realTotal;
    private boolean reallyClosed;
    private int recent;
    protected char separator;
    private int total;
    protected int type;
    protected Hashtable uidTable;
    private long uidnext;
    private long uidvalidity;

    public static class FetchProfileItem extends FetchProfile.Item {
        public static final FetchProfileItem HEADERS = new FetchProfileItem("HEADERS");
        public static final FetchProfileItem SIZE = new FetchProfileItem("SIZE");

        protected FetchProfileItem(String str) {
            super(str);
        }
    }

    public interface ProtocolCommand {
        Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException;
    }

    protected IMAPFolder(ListInfo listInfo, IMAPStore iMAPStore) {
        this(listInfo.name, listInfo.separator, iMAPStore);
        if (listInfo.hasInferiors) {
            this.type |= 2;
        }
        if (listInfo.canOpen) {
            this.type |= 1;
        }
        this.exists = true;
        this.attributes = listInfo.attrs;
    }

    protected IMAPFolder(String str, char c2, IMAPStore iMAPStore) {
        super(iMAPStore);
        int indexOf;
        this.exists = false;
        this.isNamespace = false;
        this.opened = false;
        this.reallyClosed = true;
        this.idleState = 0;
        this.total = -1;
        this.recent = -1;
        this.realTotal = -1;
        this.uidvalidity = -1;
        this.uidnext = -1;
        this.doExpungeNotification = true;
        this.cachedStatus = null;
        this.cachedStatusTime = 0;
        this.debug = false;
        Objects.requireNonNull(str, "Folder name is null");
        this.fullName = str;
        this.separator = c2;
        this.messageCacheLock = new Object();
        this.debug = iMAPStore.getSession().getDebug();
        this.connectionPoolDebug = iMAPStore.getConnectionPoolDebug();
        PrintStream debugOut = iMAPStore.getSession().getDebugOut();
        this.out = debugOut;
        if (debugOut == null) {
            this.out = System.out;
        }
        this.isNamespace = false;
        if (c2 != 65535 && c2 != 0 && (indexOf = this.fullName.indexOf(c2)) > 0 && indexOf == this.fullName.length() - 1) {
            this.fullName = this.fullName.substring(0, indexOf);
            this.isNamespace = true;
        }
    }

    protected IMAPFolder(String str, char c2, IMAPStore iMAPStore, boolean z2) {
        this(str, c2, iMAPStore);
        this.isNamespace = z2;
    }

    private void checkClosed() {
        if (this.opened) {
            throw new IllegalStateException("This operation is not allowed on an open folder");
        }
    }

    private void checkExists() throws MessagingException {
        if (!this.exists && !exists()) {
            throw new FolderNotFoundException((Folder) this, String.valueOf(this.fullName) + " not found");
        }
    }

    private void checkFlags(Flags flags) throws MessagingException {
        if (this.mode != 2) {
            throw new IllegalStateException("Cannot change flags on READ_ONLY folder: " + this.fullName);
        }
    }

    private void checkOpened() throws FolderClosedException {
        if (this.opened) {
            return;
        }
        if (this.reallyClosed) {
            throw new IllegalStateException("This operation is not allowed on a closed folder");
        }
        throw new FolderClosedException(this, "Lost folder connection to server");
    }

    private void checkRange(int i2) throws MessagingException {
        if (i2 < 1) {
            throw new IndexOutOfBoundsException();
        } else if (i2 > this.total) {
            synchronized (this.messageCacheLock) {
                try {
                    keepConnectionAlive(false);
                } catch (ConnectionException e2) {
                    throw new FolderClosedException(this, e2.getMessage());
                } catch (ProtocolException e3) {
                    throw new MessagingException(e3.getMessage(), e3);
                }
            }
            if (i2 > this.total) {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    private void cleanup(boolean z2) {
        releaseProtocol(z2);
        this.protocol = null;
        this.messageCache = null;
        this.uidTable = null;
        this.exists = false;
        this.attributes = null;
        this.opened = false;
        this.idleState = 0;
        notifyConnectionListeners(3);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:37|38|39|40|(1:42)) */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x008f, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0079 */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007d A[Catch:{ ProtocolException -> 0x0092, all -> 0x0090 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void close(boolean r4, boolean r5) throws javax.mail.MessagingException {
        /*
            r3 = this;
            java.lang.Object r0 = r3.messageCacheLock
            monitor-enter(r0)
            boolean r1 = r3.opened     // Catch:{ all -> 0x00a5 }
            if (r1 != 0) goto L_0x0014
            boolean r2 = r3.reallyClosed     // Catch:{ all -> 0x00a5 }
            if (r2 != 0) goto L_0x000c
            goto L_0x0014
        L_0x000c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a5 }
            java.lang.String r5 = "This operation is not allowed on a closed folder"
            r4.<init>(r5)     // Catch:{ all -> 0x00a5 }
            throw r4     // Catch:{ all -> 0x00a5 }
        L_0x0014:
            r2 = 1
            r3.reallyClosed = r2     // Catch:{ all -> 0x00a5 }
            if (r1 != 0) goto L_0x001b
            monitor-exit(r0)     // Catch:{ all -> 0x00a5 }
            return
        L_0x001b:
            r3.waitIfIdle()     // Catch:{ ProtocolException -> 0x0092 }
            if (r5 == 0) goto L_0x0046
            boolean r4 = r3.debug     // Catch:{ ProtocolException -> 0x0092 }
            if (r4 == 0) goto L_0x003e
            java.io.PrintStream r4 = r3.out     // Catch:{ ProtocolException -> 0x0092 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ProtocolException -> 0x0092 }
            java.lang.String r1 = "DEBUG: forcing folder "
            r5.<init>(r1)     // Catch:{ ProtocolException -> 0x0092 }
            java.lang.String r1 = r3.fullName     // Catch:{ ProtocolException -> 0x0092 }
            r5.append(r1)     // Catch:{ ProtocolException -> 0x0092 }
            java.lang.String r1 = " to close"
            r5.append(r1)     // Catch:{ ProtocolException -> 0x0092 }
            java.lang.String r5 = r5.toString()     // Catch:{ ProtocolException -> 0x0092 }
            r4.println(r5)     // Catch:{ ProtocolException -> 0x0092 }
        L_0x003e:
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r3.protocol     // Catch:{ ProtocolException -> 0x0092 }
            if (r4 == 0) goto L_0x0087
            r4.disconnect()     // Catch:{ ProtocolException -> 0x0092 }
            goto L_0x0087
        L_0x0046:
            javax.mail.Store r5 = r3.store     // Catch:{ ProtocolException -> 0x0092 }
            com.sun.mail.imap.IMAPStore r5 = (com.sun.mail.imap.IMAPStore) r5     // Catch:{ ProtocolException -> 0x0092 }
            boolean r5 = r5.isConnectionPoolFull()     // Catch:{ ProtocolException -> 0x0092 }
            if (r5 == 0) goto L_0x006a
            boolean r5 = r3.debug     // Catch:{ ProtocolException -> 0x0092 }
            if (r5 == 0) goto L_0x005b
            java.io.PrintStream r5 = r3.out     // Catch:{ ProtocolException -> 0x0092 }
            java.lang.String r1 = "DEBUG: pool is full, not adding an Authenticated connection"
            r5.println(r1)     // Catch:{ ProtocolException -> 0x0092 }
        L_0x005b:
            if (r4 == 0) goto L_0x0062
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r3.protocol     // Catch:{ ProtocolException -> 0x0092 }
            r4.close()     // Catch:{ ProtocolException -> 0x0092 }
        L_0x0062:
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r3.protocol     // Catch:{ ProtocolException -> 0x0092 }
            if (r4 == 0) goto L_0x0087
            r4.logout()     // Catch:{ ProtocolException -> 0x0092 }
            goto L_0x0087
        L_0x006a:
            if (r4 != 0) goto L_0x0080
            int r4 = r3.mode     // Catch:{ ProtocolException -> 0x0092 }
            r5 = 2
            if (r4 != r5) goto L_0x0080
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r3.protocol     // Catch:{ ProtocolException -> 0x0079 }
            java.lang.String r5 = r3.fullName     // Catch:{ ProtocolException -> 0x0079 }
            r4.examine(r5)     // Catch:{ ProtocolException -> 0x0079 }
            goto L_0x0080
        L_0x0079:
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r3.protocol     // Catch:{ ProtocolException -> 0x0092 }
            if (r4 == 0) goto L_0x0080
            r4.disconnect()     // Catch:{ ProtocolException -> 0x0092 }
        L_0x0080:
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r3.protocol     // Catch:{ ProtocolException -> 0x0092 }
            if (r4 == 0) goto L_0x0087
            r4.close()     // Catch:{ ProtocolException -> 0x0092 }
        L_0x0087:
            boolean r4 = r3.opened     // Catch:{ all -> 0x00a5 }
            if (r4 == 0) goto L_0x008e
            r3.cleanup(r2)     // Catch:{ all -> 0x00a5 }
        L_0x008e:
            monitor-exit(r0)     // Catch:{ all -> 0x00a5 }
            return
        L_0x0090:
            r4 = move-exception
            goto L_0x009d
        L_0x0092:
            r4 = move-exception
            javax.mail.MessagingException r5 = new javax.mail.MessagingException     // Catch:{ all -> 0x0090 }
            java.lang.String r1 = r4.getMessage()     // Catch:{ all -> 0x0090 }
            r5.<init>(r1, r4)     // Catch:{ all -> 0x0090 }
            throw r5     // Catch:{ all -> 0x0090 }
        L_0x009d:
            boolean r5 = r3.opened     // Catch:{ all -> 0x00a5 }
            if (r5 == 0) goto L_0x00a4
            r3.cleanup(r2)     // Catch:{ all -> 0x00a5 }
        L_0x00a4:
            throw r4     // Catch:{ all -> 0x00a5 }
        L_0x00a5:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a5 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.close(boolean, boolean):void");
    }

    private synchronized Folder[] doList(final String str, final boolean z2) throws MessagingException {
        checkExists();
        int i2 = 0;
        if (!isDirectory()) {
            return new Folder[0];
        }
        final char separator2 = getSeparator();
        ListInfo[] listInfoArr = (ListInfo[]) doCommandIgnoreFailure(new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                if (z2) {
                    return iMAPProtocol.lsub("", String.valueOf(IMAPFolder.this.fullName) + separator2 + str);
                }
                return iMAPProtocol.list("", String.valueOf(IMAPFolder.this.fullName) + separator2 + str);
            }
        });
        if (listInfoArr == null) {
            return new Folder[0];
        }
        if (listInfoArr.length > 0) {
            String str2 = listInfoArr[0].name;
            if (str2.equals(String.valueOf(this.fullName) + separator2)) {
                i2 = 1;
            }
        }
        IMAPFolder[] iMAPFolderArr = new IMAPFolder[(listInfoArr.length - i2)];
        for (int i3 = i2; i3 < listInfoArr.length; i3++) {
            iMAPFolderArr[i3 - i2] = new IMAPFolder(listInfoArr[i3], (IMAPStore) this.store);
        }
        return iMAPFolderArr;
    }

    private int findName(ListInfo[] listInfoArr, String str) {
        int i2 = 0;
        while (i2 < listInfoArr.length && !listInfoArr[i2].name.equals(str)) {
            i2++;
        }
        if (i2 >= listInfoArr.length) {
            return 0;
        }
        return i2;
    }

    private IMAPProtocol getProtocol() throws ProtocolException {
        waitIfIdle();
        return this.protocol;
    }

    /* access modifiers changed from: private */
    public Status getStatus() throws ProtocolException {
        int statusCacheTimeout = ((IMAPStore) this.store).getStatusCacheTimeout();
        if (statusCacheTimeout > 0 && this.cachedStatus != null && System.currentTimeMillis() - this.cachedStatusTime < ((long) statusCacheTimeout)) {
            return this.cachedStatus;
        }
        IMAPProtocol iMAPProtocol = null;
        try {
            IMAPProtocol storeProtocol = getStoreProtocol();
            try {
                Status status = storeProtocol.status(this.fullName, (String[]) null);
                if (statusCacheTimeout > 0) {
                    this.cachedStatus = status;
                    this.cachedStatusTime = System.currentTimeMillis();
                }
                releaseStoreProtocol(storeProtocol);
                return status;
            } catch (Throwable th) {
                th = th;
                iMAPProtocol = storeProtocol;
                releaseStoreProtocol(iMAPProtocol);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            releaseStoreProtocol(iMAPProtocol);
            throw th;
        }
    }

    private boolean isDirectory() {
        return (this.type & 2) != 0;
    }

    private void keepConnectionAlive(boolean z2) throws ProtocolException {
        if (System.currentTimeMillis() - this.protocol.getTimestamp() > 1000) {
            waitIfIdle();
            this.protocol.noop();
        }
        if (z2 && ((IMAPStore) this.store).hasSeparateStoreConnection()) {
            IMAPProtocol iMAPProtocol = null;
            try {
                iMAPProtocol = ((IMAPStore) this.store).getStoreProtocol();
                if (System.currentTimeMillis() - iMAPProtocol.getTimestamp() > 1000) {
                    iMAPProtocol.noop();
                }
            } finally {
                ((IMAPStore) this.store).releaseStoreProtocol(iMAPProtocol);
            }
        }
    }

    private void releaseProtocol(boolean z2) {
        IMAPStore iMAPStore;
        IMAPProtocol iMAPProtocol;
        IMAPProtocol iMAPProtocol2 = this.protocol;
        if (iMAPProtocol2 != null) {
            iMAPProtocol2.removeResponseHandler(this);
            if (z2) {
                iMAPStore = (IMAPStore) this.store;
                iMAPProtocol = this.protocol;
            } else {
                iMAPStore = (IMAPStore) this.store;
                iMAPProtocol = null;
            }
            iMAPStore.releaseProtocol(this, iMAPProtocol);
        }
    }

    private void setACL(final ACL acl, final char c2) throws MessagingException {
        doOptionalCommand("ACL not supported", new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                iMAPProtocol.setACL(IMAPFolder.this.fullName, c2, acl);
                return null;
            }
        });
    }

    private synchronized void throwClosedException(ConnectionException connectionException) throws FolderClosedException, StoreClosedException {
        if ((this.protocol == null || connectionException.getProtocol() != this.protocol) && (this.protocol != null || this.reallyClosed)) {
            throw new StoreClosedException(this.store, connectionException.getMessage());
        }
        throw new FolderClosedException(this, connectionException.getMessage());
    }

    public void addACL(ACL acl) throws MessagingException {
        setACL(acl, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: javax.mail.internet.MimeMessage[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized javax.mail.Message[] addMessages(javax.mail.Message[] r9) throws javax.mail.MessagingException {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.checkOpened()     // Catch:{ all -> 0x0028 }
            int r0 = r9.length     // Catch:{ all -> 0x0028 }
            javax.mail.internet.MimeMessage[] r0 = new javax.mail.internet.MimeMessage[r0]     // Catch:{ all -> 0x0028 }
            com.sun.mail.imap.AppendUID[] r9 = r8.appendUIDMessages(r9)     // Catch:{ all -> 0x0028 }
            r1 = 0
        L_0x000c:
            int r2 = r9.length     // Catch:{ all -> 0x0028 }
            if (r1 < r2) goto L_0x0011
            monitor-exit(r8)
            return r0
        L_0x0011:
            r2 = r9[r1]     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x0025
            long r3 = r2.uidvalidity     // Catch:{ all -> 0x0028 }
            long r5 = r8.uidvalidity     // Catch:{ all -> 0x0028 }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0025
            long r2 = r2.uid     // Catch:{ MessagingException -> 0x0025 }
            javax.mail.Message r2 = r8.getMessageByUID(r2)     // Catch:{ MessagingException -> 0x0025 }
            r0[r1] = r2     // Catch:{ MessagingException -> 0x0025 }
        L_0x0025:
            int r1 = r1 + 1
            goto L_0x000c
        L_0x0028:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x002c
        L_0x002b:
            throw r9
        L_0x002c:
            goto L_0x002b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.addMessages(javax.mail.Message[]):javax.mail.Message[]");
    }

    public void addRights(ACL acl) throws MessagingException {
        setACL(acl, '+');
    }

    public synchronized void appendMessages(Message[] messageArr) throws MessagingException {
        checkExists();
        int appendBufferSize = ((IMAPStore) this.store).getAppendBufferSize();
        for (Message message : messageArr) {
            try {
                final MessageLiteral messageLiteral = new MessageLiteral(message, message.getSize() > appendBufferSize ? 0 : appendBufferSize);
                final Date receivedDate = message.getReceivedDate();
                if (receivedDate == null) {
                    receivedDate = message.getSentDate();
                }
                final Flags flags = message.getFlags();
                doCommand(new ProtocolCommand() {
                    public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                        iMAPProtocol.append(IMAPFolder.this.fullName, flags, receivedDate, messageLiteral);
                        return null;
                    }
                });
            } catch (IOException e2) {
                throw new MessagingException("IOException while appending messages", e2);
            } catch (MessageRemovedException unused) {
            }
        }
    }

    public synchronized AppendUID[] appendUIDMessages(Message[] messageArr) throws MessagingException {
        AppendUID[] appendUIDArr;
        checkExists();
        int appendBufferSize = ((IMAPStore) this.store).getAppendBufferSize();
        appendUIDArr = new AppendUID[messageArr.length];
        for (int i2 = 0; i2 < messageArr.length; i2++) {
            Message message = messageArr[i2];
            try {
                final MessageLiteral messageLiteral = new MessageLiteral(message, message.getSize() > appendBufferSize ? 0 : appendBufferSize);
                final Date receivedDate = message.getReceivedDate();
                if (receivedDate == null) {
                    receivedDate = message.getSentDate();
                }
                final Flags flags = message.getFlags();
                appendUIDArr[i2] = (AppendUID) doCommand(new ProtocolCommand() {
                    public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                        return iMAPProtocol.appenduid(IMAPFolder.this.fullName, flags, receivedDate, messageLiteral);
                    }
                });
            } catch (IOException e2) {
                throw new MessagingException("IOException while appending messages", e2);
            } catch (MessageRemovedException unused) {
            }
        }
        return appendUIDArr;
    }

    public synchronized void close(boolean z2) throws MessagingException {
        close(z2, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0082, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void copyMessages(javax.mail.Message[] r4, javax.mail.Folder r5) throws javax.mail.MessagingException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.checkOpened()     // Catch:{ all -> 0x0083 }
            int r0 = r4.length     // Catch:{ all -> 0x0083 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r3)
            return
        L_0x0009:
            javax.mail.Store r0 = r5.getStore()     // Catch:{ all -> 0x0083 }
            javax.mail.Store r1 = r3.store     // Catch:{ all -> 0x0083 }
            if (r0 != r1) goto L_0x007e
            java.lang.Object r0 = r3.messageCacheLock     // Catch:{ all -> 0x0083 }
            monitor-enter(r0)     // Catch:{ all -> 0x0083 }
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r3.getProtocol()     // Catch:{ CommandFailedException -> 0x0048, ConnectionException -> 0x003d, ProtocolException -> 0x0032 }
            r2 = 0
            com.sun.mail.imap.protocol.MessageSet[] r4 = com.sun.mail.imap.Utility.toMessageSet(r4, r2)     // Catch:{ CommandFailedException -> 0x0048, ConnectionException -> 0x003d, ProtocolException -> 0x0032 }
            if (r4 == 0) goto L_0x0028
            java.lang.String r2 = r5.getFullName()     // Catch:{ CommandFailedException -> 0x0048, ConnectionException -> 0x003d, ProtocolException -> 0x0032 }
            r1.copy((com.sun.mail.imap.protocol.MessageSet[]) r4, (java.lang.String) r2)     // Catch:{ CommandFailedException -> 0x0048, ConnectionException -> 0x003d, ProtocolException -> 0x0032 }
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            goto L_0x0081
        L_0x0028:
            javax.mail.MessageRemovedException r4 = new javax.mail.MessageRemovedException     // Catch:{ CommandFailedException -> 0x0048, ConnectionException -> 0x003d, ProtocolException -> 0x0032 }
            java.lang.String r1 = "Messages have been removed"
            r4.<init>(r1)     // Catch:{ CommandFailedException -> 0x0048, ConnectionException -> 0x003d, ProtocolException -> 0x0032 }
            throw r4     // Catch:{ CommandFailedException -> 0x0048, ConnectionException -> 0x003d, ProtocolException -> 0x0032 }
        L_0x0030:
            r4 = move-exception
            goto L_0x007c
        L_0x0032:
            r4 = move-exception
            javax.mail.MessagingException r5 = new javax.mail.MessagingException     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = r4.getMessage()     // Catch:{ all -> 0x0030 }
            r5.<init>(r1, r4)     // Catch:{ all -> 0x0030 }
            throw r5     // Catch:{ all -> 0x0030 }
        L_0x003d:
            r4 = move-exception
            javax.mail.FolderClosedException r5 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x0030 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0030 }
            r5.<init>(r3, r4)     // Catch:{ all -> 0x0030 }
            throw r5     // Catch:{ all -> 0x0030 }
        L_0x0048:
            r4 = move-exception
            java.lang.String r1 = r4.getMessage()     // Catch:{ all -> 0x0030 }
            java.lang.String r2 = "TRYCREATE"
            int r1 = r1.indexOf(r2)     // Catch:{ all -> 0x0030 }
            r2 = -1
            if (r1 == r2) goto L_0x0072
            javax.mail.FolderNotFoundException r4 = new javax.mail.FolderNotFoundException     // Catch:{ all -> 0x0030 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            java.lang.String r2 = r5.getFullName()     // Catch:{ all -> 0x0030 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0030 }
            r1.<init>(r2)     // Catch:{ all -> 0x0030 }
            java.lang.String r2 = " does not exist"
            r1.append(r2)     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0030 }
            r4.<init>((javax.mail.Folder) r5, (java.lang.String) r1)     // Catch:{ all -> 0x0030 }
            throw r4     // Catch:{ all -> 0x0030 }
        L_0x0072:
            javax.mail.MessagingException r5 = new javax.mail.MessagingException     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = r4.getMessage()     // Catch:{ all -> 0x0030 }
            r5.<init>(r1, r4)     // Catch:{ all -> 0x0030 }
            throw r5     // Catch:{ all -> 0x0030 }
        L_0x007c:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r4     // Catch:{ all -> 0x0083 }
        L_0x007e:
            super.copyMessages(r4, r5)     // Catch:{ all -> 0x0083 }
        L_0x0081:
            monitor-exit(r3)
            return
        L_0x0083:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.copyMessages(javax.mail.Message[], javax.mail.Folder):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean create(final int r4) throws javax.mail.MessagingException {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = r4 & 1
            r1 = 0
            if (r0 != 0) goto L_0x000b
            char r0 = r3.getSeparator()     // Catch:{ all -> 0x0025 }
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            com.sun.mail.imap.IMAPFolder$6 r2 = new com.sun.mail.imap.IMAPFolder$6     // Catch:{ all -> 0x0025 }
            r2.<init>(r4, r0)     // Catch:{ all -> 0x0025 }
            java.lang.Object r4 = r3.doCommandIgnoreFailure(r2)     // Catch:{ all -> 0x0025 }
            if (r4 != 0) goto L_0x0019
            monitor-exit(r3)
            return r1
        L_0x0019:
            boolean r4 = r3.exists()     // Catch:{ all -> 0x0025 }
            if (r4 == 0) goto L_0x0023
            r0 = 1
            r3.notifyFolderListeners(r0)     // Catch:{ all -> 0x0025 }
        L_0x0023:
            monitor-exit(r3)
            return r4
        L_0x0025:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.create(int):boolean");
    }

    public synchronized boolean delete(boolean z2) throws MessagingException {
        checkClosed();
        if (z2) {
            Folder[] list = list();
            for (Folder delete : list) {
                delete.delete(z2);
            }
        }
        if (doCommandIgnoreFailure(new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                iMAPProtocol.delete(IMAPFolder.this.fullName);
                return Boolean.TRUE;
            }
        }) == null) {
            return false;
        }
        this.exists = false;
        this.attributes = null;
        notifyFolderListeners(2);
        return true;
    }

    public Object doCommand(ProtocolCommand protocolCommand) throws MessagingException {
        try {
            return doProtocolCommand(protocolCommand);
        } catch (ConnectionException e2) {
            throwClosedException(e2);
            return null;
        } catch (ProtocolException e3) {
            throw new MessagingException(e3.getMessage(), e3);
        }
    }

    public Object doCommandIgnoreFailure(ProtocolCommand protocolCommand) throws MessagingException {
        try {
            return doProtocolCommand(protocolCommand);
        } catch (CommandFailedException unused) {
            return null;
        } catch (ConnectionException e2) {
            throwClosedException(e2);
            return null;
        } catch (ProtocolException e3) {
            throw new MessagingException(e3.getMessage(), e3);
        }
    }

    public Object doOptionalCommand(String str, ProtocolCommand protocolCommand) throws MessagingException {
        try {
            return doProtocolCommand(protocolCommand);
        } catch (BadCommandException e2) {
            throw new MessagingException(str, e2);
        } catch (ConnectionException e3) {
            throwClosedException(e3);
            return null;
        } catch (ProtocolException e4) {
            throw new MessagingException(e4.getMessage(), e4);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0021, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r0 = getStoreProtocol();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x002d, code lost:
        return r3.doCommand(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x002e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x002f, code lost:
        releaseStoreProtocol(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0032, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doProtocolCommand(com.sun.mail.imap.IMAPFolder.ProtocolCommand r3) throws com.sun.mail.iap.ProtocolException {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.opened     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0020
            javax.mail.Store r0 = r2.store     // Catch:{ all -> 0x0033 }
            com.sun.mail.imap.IMAPStore r0 = (com.sun.mail.imap.IMAPStore) r0     // Catch:{ all -> 0x0033 }
            boolean r0 = r0.hasSeparateStoreConnection()     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x0020
            java.lang.Object r0 = r2.messageCacheLock     // Catch:{ all -> 0x0033 }
            monitor-enter(r0)     // Catch:{ all -> 0x0033 }
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r2.getProtocol()     // Catch:{ all -> 0x001d }
            java.lang.Object r3 = r3.doCommand(r1)     // Catch:{ all -> 0x001d }
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            monitor-exit(r2)     // Catch:{ all -> 0x0033 }
            return r3
        L_0x001d:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            throw r3     // Catch:{ all -> 0x0033 }
        L_0x0020:
            monitor-exit(r2)     // Catch:{ all -> 0x0033 }
            r0 = 0
            com.sun.mail.imap.protocol.IMAPProtocol r0 = r2.getStoreProtocol()     // Catch:{ all -> 0x002e }
            java.lang.Object r3 = r3.doCommand(r0)     // Catch:{ all -> 0x002e }
            r2.releaseStoreProtocol(r0)
            return r3
        L_0x002e:
            r3 = move-exception
            r2.releaseStoreProtocol(r0)
            throw r3
        L_0x0033:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0033 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.doProtocolCommand(com.sun.mail.imap.IMAPFolder$ProtocolCommand):java.lang.Object");
    }

    public synchronized boolean exists() throws MessagingException {
        final String str;
        String[] strArr = null;
        ListInfo[] listInfoArr = null;
        if (!this.isNamespace || this.separator == 0) {
            str = this.fullName;
        } else {
            str = String.valueOf(this.fullName) + this.separator;
        }
        ListInfo[] listInfoArr2 = (ListInfo[]) doCommand(new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.list("", str);
            }
        });
        if (listInfoArr2 != null) {
            int findName = findName(listInfoArr2, str);
            this.fullName = listInfoArr2[findName].name;
            this.separator = listInfoArr2[findName].separator;
            int length = this.fullName.length();
            if (this.separator != 0 && length > 0) {
                int i2 = length - 1;
                if (this.fullName.charAt(i2) == this.separator) {
                    this.fullName = this.fullName.substring(0, i2);
                }
            }
            this.type = 0;
            if (listInfoArr2[findName].hasInferiors) {
                this.type |= 2;
            }
            if (listInfoArr2[findName].canOpen) {
                this.type |= 1;
            }
            this.exists = true;
            strArr = listInfoArr2[findName].attrs;
        } else {
            this.exists = this.opened;
        }
        this.attributes = strArr;
        return this.exists;
    }

    public synchronized Message[] expunge() throws MessagingException {
        return expunge((Message[]) null);
    }

    public synchronized Message[] expunge(Message[] messageArr) throws MessagingException {
        Message[] messageArr2;
        checkOpened();
        Vector vector = new Vector();
        if (messageArr != null) {
            FetchProfile fetchProfile = new FetchProfile();
            fetchProfile.add((FetchProfile.Item) UIDFolder.FetchProfileItem.UID);
            fetch(messageArr, fetchProfile);
        }
        synchronized (this.messageCacheLock) {
            int i2 = 0;
            this.doExpungeNotification = false;
            try {
                IMAPProtocol protocol2 = getProtocol();
                if (messageArr != null) {
                    protocol2.uidexpunge(Utility.toUIDSet(messageArr));
                } else {
                    protocol2.expunge();
                }
                this.doExpungeNotification = true;
                while (i2 < this.messageCache.size()) {
                    IMAPMessage iMAPMessage = (IMAPMessage) this.messageCache.elementAt(i2);
                    if (iMAPMessage.isExpunged()) {
                        vector.addElement(iMAPMessage);
                        this.messageCache.removeElementAt(i2);
                        if (this.uidTable != null) {
                            long uid = iMAPMessage.getUID();
                            if (uid != -1) {
                                this.uidTable.remove(new Long(uid));
                            }
                        }
                    } else {
                        iMAPMessage.setMessageNumber(iMAPMessage.getSequenceNumber());
                        i2++;
                    }
                }
            } catch (CommandFailedException e2) {
                if (this.mode != 2) {
                    throw new IllegalStateException("Cannot expunge READ_ONLY folder: " + this.fullName);
                }
                throw new MessagingException(e2.getMessage(), e2);
            } catch (ConnectionException e3) {
                throw new FolderClosedException(this, e3.getMessage());
            } catch (ProtocolException e4) {
                throw new MessagingException(e4.getMessage(), e4);
            } catch (Throwable th) {
                this.doExpungeNotification = true;
                throw th;
            }
        }
        this.total = this.messageCache.size();
        int size = vector.size();
        messageArr2 = new Message[size];
        vector.copyInto(messageArr2);
        if (size > 0) {
            notifyMessageRemovedListeners(true, messageArr2);
        }
        return messageArr2;
    }

    public synchronized void fetch(Message[] messageArr, FetchProfile fetchProfile) throws MessagingException {
        checkOpened();
        IMAPMessage.fetch(this, messageArr, fetchProfile);
    }

    public synchronized void forceClose() throws MessagingException {
        close(false, true);
    }

    public ACL[] getACL() throws MessagingException {
        return (ACL[]) doOptionalCommand("ACL not supported", new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.getACL(IMAPFolder.this.fullName);
            }
        });
    }

    public String[] getAttributes() throws MessagingException {
        if (this.attributes == null) {
            exists();
        }
        return (String[]) this.attributes.clone();
    }

    public synchronized int getDeletedMessageCount() throws MessagingException {
        int length;
        if (!this.opened) {
            checkExists();
            return -1;
        }
        Flags flags = new Flags();
        flags.add(Flags.Flag.DELETED);
        try {
            synchronized (this.messageCacheLock) {
                length = getProtocol().search(new FlagTerm(flags, true)).length;
            }
            return length;
        } catch (ConnectionException e2) {
            throw new FolderClosedException(this, e2.getMessage());
        } catch (ProtocolException e3) {
            throw new MessagingException(e3.getMessage(), e3);
        }
    }

    public Folder getFolder(String str) throws MessagingException {
        if (this.attributes == null || isDirectory()) {
            char separator2 = getSeparator();
            return new IMAPFolder(String.valueOf(this.fullName) + separator2 + str, separator2, (IMAPStore) this.store);
        }
        throw new MessagingException("Cannot contain subfolders");
    }

    public synchronized String getFullName() {
        return this.fullName;
    }

    public synchronized Message getMessage(int i2) throws MessagingException {
        checkOpened();
        checkRange(i2);
        return (Message) this.messageCache.elementAt(i2 - 1);
    }

    /* access modifiers changed from: package-private */
    public IMAPMessage getMessageBySeqNumber(int i2) {
        for (int i3 = i2 - 1; i3 < this.total; i3++) {
            IMAPMessage iMAPMessage = (IMAPMessage) this.messageCache.elementAt(i3);
            if (iMAPMessage.getSequenceNumber() == i2) {
                return iMAPMessage;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized javax.mail.Message getMessageByUID(long r5) throws javax.mail.MessagingException {
        /*
            r4 = this;
            monitor-enter(r4)
            r4.checkOpened()     // Catch:{ all -> 0x005f }
            r0 = 0
            java.lang.Object r1 = r4.messageCacheLock     // Catch:{ ConnectionException -> 0x0054, ProtocolException -> 0x0049 }
            monitor-enter(r1)     // Catch:{ ConnectionException -> 0x0054, ProtocolException -> 0x0049 }
            java.lang.Long r2 = new java.lang.Long     // Catch:{ all -> 0x0046 }
            r2.<init>(r5)     // Catch:{ all -> 0x0046 }
            java.util.Hashtable r3 = r4.uidTable     // Catch:{ all -> 0x0046 }
            if (r3 == 0) goto L_0x001c
            java.lang.Object r0 = r3.get(r2)     // Catch:{ all -> 0x0046 }
            com.sun.mail.imap.IMAPMessage r0 = (com.sun.mail.imap.IMAPMessage) r0     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0023
            monitor-exit(r1)     // Catch:{ all -> 0x0046 }
            monitor-exit(r4)
            return r0
        L_0x001c:
            java.util.Hashtable r3 = new java.util.Hashtable     // Catch:{ all -> 0x0046 }
            r3.<init>()     // Catch:{ all -> 0x0046 }
            r4.uidTable = r3     // Catch:{ all -> 0x0046 }
        L_0x0023:
            com.sun.mail.imap.protocol.IMAPProtocol r3 = r4.getProtocol()     // Catch:{ all -> 0x0046 }
            com.sun.mail.imap.protocol.UID r5 = r3.fetchSequenceNumber(r5)     // Catch:{ all -> 0x0046 }
            if (r5 == 0) goto L_0x0043
            int r6 = r5.seqnum     // Catch:{ all -> 0x0046 }
            int r3 = r4.total     // Catch:{ all -> 0x0046 }
            if (r6 > r3) goto L_0x0043
            int r6 = r5.seqnum     // Catch:{ all -> 0x0046 }
            com.sun.mail.imap.IMAPMessage r0 = r4.getMessageBySeqNumber(r6)     // Catch:{ all -> 0x0046 }
            long r5 = r5.uid     // Catch:{ all -> 0x0046 }
            r0.setUID(r5)     // Catch:{ all -> 0x0046 }
            java.util.Hashtable r5 = r4.uidTable     // Catch:{ all -> 0x0046 }
            r5.put(r2, r0)     // Catch:{ all -> 0x0046 }
        L_0x0043:
            monitor-exit(r1)     // Catch:{ all -> 0x0046 }
            monitor-exit(r4)
            return r0
        L_0x0046:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0046 }
            throw r5     // Catch:{ ConnectionException -> 0x0054, ProtocolException -> 0x0049 }
        L_0x0049:
            r5 = move-exception
            javax.mail.MessagingException r6 = new javax.mail.MessagingException     // Catch:{ all -> 0x005f }
            java.lang.String r0 = r5.getMessage()     // Catch:{ all -> 0x005f }
            r6.<init>(r0, r5)     // Catch:{ all -> 0x005f }
            throw r6     // Catch:{ all -> 0x005f }
        L_0x0054:
            r5 = move-exception
            javax.mail.FolderClosedException r6 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x005f }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x005f }
            r6.<init>(r4, r5)     // Catch:{ all -> 0x005f }
            throw r6     // Catch:{ all -> 0x005f }
        L_0x005f:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.getMessageByUID(long):javax.mail.Message");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        throw new javax.mail.MessagingException(r0.getMessage(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        throw new javax.mail.StoreClosedException(r4.store, r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0 = getStoreProtocol();
        r1 = r0.examine(r4.fullName);
        r0.close();
        r1 = r1.total;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        releaseStoreProtocol(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0049, code lost:
        throw new javax.mail.MessagingException(r1.getMessage(), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        releaseStoreProtocol(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004d, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x005c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0066, code lost:
        throw new javax.mail.MessagingException(r1.getMessage(), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0067, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0071, code lost:
        throw new javax.mail.FolderClosedException(r4, r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x0008, B:18:0x0029, B:26:0x0040, B:35:0x0052] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int getMessageCount() throws javax.mail.MessagingException {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.opened     // Catch:{ all -> 0x0074 }
            if (r0 != 0) goto L_0x004e
            r4.checkExists()     // Catch:{ all -> 0x0074 }
            com.sun.mail.imap.protocol.Status r0 = r4.getStatus()     // Catch:{ BadCommandException -> 0x0028, ConnectionException -> 0x001b, ProtocolException -> 0x0010 }
            int r0 = r0.total     // Catch:{ BadCommandException -> 0x0028, ConnectionException -> 0x001b, ProtocolException -> 0x0010 }
            monitor-exit(r4)
            return r0
        L_0x0010:
            r0 = move-exception
            javax.mail.MessagingException r1 = new javax.mail.MessagingException     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x0074 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0074 }
            throw r1     // Catch:{ all -> 0x0074 }
        L_0x001b:
            r0 = move-exception
            javax.mail.StoreClosedException r1 = new javax.mail.StoreClosedException     // Catch:{ all -> 0x0074 }
            javax.mail.Store r2 = r4.store     // Catch:{ all -> 0x0074 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0074 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0074 }
            throw r1     // Catch:{ all -> 0x0074 }
        L_0x0028:
            r0 = 0
            com.sun.mail.imap.protocol.IMAPProtocol r0 = r4.getStoreProtocol()     // Catch:{ ProtocolException -> 0x003f }
            java.lang.String r1 = r4.fullName     // Catch:{ ProtocolException -> 0x003f }
            com.sun.mail.imap.protocol.MailboxInfo r1 = r0.examine(r1)     // Catch:{ ProtocolException -> 0x003f }
            r0.close()     // Catch:{ ProtocolException -> 0x003f }
            int r1 = r1.total     // Catch:{ ProtocolException -> 0x003f }
            r4.releaseStoreProtocol(r0)     // Catch:{ all -> 0x0074 }
            monitor-exit(r4)
            return r1
        L_0x003d:
            r1 = move-exception
            goto L_0x004a
        L_0x003f:
            r1 = move-exception
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x003d }
            java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x003d }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x003d }
            throw r2     // Catch:{ all -> 0x003d }
        L_0x004a:
            r4.releaseStoreProtocol(r0)     // Catch:{ all -> 0x0074 }
            throw r1     // Catch:{ all -> 0x0074 }
        L_0x004e:
            java.lang.Object r0 = r4.messageCacheLock     // Catch:{ all -> 0x0074 }
            monitor-enter(r0)     // Catch:{ all -> 0x0074 }
            r1 = 1
            r4.keepConnectionAlive(r1)     // Catch:{ ConnectionException -> 0x0067, ProtocolException -> 0x005c }
            int r1 = r4.total     // Catch:{ ConnectionException -> 0x0067, ProtocolException -> 0x005c }
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            monitor-exit(r4)
            return r1
        L_0x005a:
            r1 = move-exception
            goto L_0x0072
        L_0x005c:
            r1 = move-exception
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x005a }
            java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x005a }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x005a }
            throw r2     // Catch:{ all -> 0x005a }
        L_0x0067:
            r1 = move-exception
            javax.mail.FolderClosedException r2 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x005a }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x005a }
            r2.<init>(r4, r1)     // Catch:{ all -> 0x005a }
            throw r2     // Catch:{ all -> 0x005a }
        L_0x0072:
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            throw r1     // Catch:{ all -> 0x0074 }
        L_0x0074:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.getMessageCount():int");
    }

    public synchronized Message[] getMessagesByUID(long j2, long j3) throws MessagingException {
        Message[] messageArr;
        checkOpened();
        try {
            synchronized (this.messageCacheLock) {
                if (this.uidTable == null) {
                    this.uidTable = new Hashtable();
                }
                UID[] fetchSequenceNumbers = getProtocol().fetchSequenceNumbers(j2, j3);
                messageArr = new Message[fetchSequenceNumbers.length];
                for (int i2 = 0; i2 < fetchSequenceNumbers.length; i2++) {
                    IMAPMessage messageBySeqNumber = getMessageBySeqNumber(fetchSequenceNumbers[i2].seqnum);
                    messageBySeqNumber.setUID(fetchSequenceNumbers[i2].uid);
                    messageArr[i2] = messageBySeqNumber;
                    this.uidTable.put(new Long(fetchSequenceNumbers[i2].uid), messageBySeqNumber);
                }
            }
        } catch (ConnectionException e2) {
            throw new FolderClosedException(this, e2.getMessage());
        } catch (ProtocolException e3) {
            throw new MessagingException(e3.getMessage(), e3);
        }
        return messageArr;
    }

    public synchronized Message[] getMessagesByUID(long[] jArr) throws MessagingException {
        long[] jArr2;
        Message[] messageArr;
        checkOpened();
        try {
            synchronized (this.messageCacheLock) {
                if (this.uidTable != null) {
                    Vector vector = new Vector();
                    for (long l2 : jArr) {
                        Hashtable hashtable = this.uidTable;
                        Long l3 = new Long(l2);
                        if (!hashtable.containsKey(l3)) {
                            vector.addElement(l3);
                        }
                    }
                    int size = vector.size();
                    jArr2 = new long[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        jArr2[i2] = ((Long) vector.elementAt(i2)).longValue();
                    }
                } else {
                    this.uidTable = new Hashtable();
                    jArr2 = jArr;
                }
                if (jArr2.length > 0) {
                    UID[] fetchSequenceNumbers = getProtocol().fetchSequenceNumbers(jArr2);
                    for (int i3 = 0; i3 < fetchSequenceNumbers.length; i3++) {
                        IMAPMessage messageBySeqNumber = getMessageBySeqNumber(fetchSequenceNumbers[i3].seqnum);
                        messageBySeqNumber.setUID(fetchSequenceNumbers[i3].uid);
                        this.uidTable.put(new Long(fetchSequenceNumbers[i3].uid), messageBySeqNumber);
                    }
                }
                messageArr = new Message[jArr.length];
                for (int i4 = 0; i4 < jArr.length; i4++) {
                    messageArr[i4] = (Message) this.uidTable.get(new Long(jArr[i4]));
                }
            }
        } catch (ConnectionException e2) {
            throw new FolderClosedException(this, e2.getMessage());
        } catch (ProtocolException e3) {
            throw new MessagingException(e3.getMessage(), e3);
        }
        return messageArr;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:1|2|(2:4|5)|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0017 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String getName() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = r2.name     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0017
            java.lang.String r0 = r2.fullName     // Catch:{ MessagingException -> 0x0017 }
            char r1 = r2.getSeparator()     // Catch:{ MessagingException -> 0x0017 }
            int r1 = r0.lastIndexOf(r1)     // Catch:{ MessagingException -> 0x0017 }
            int r1 = r1 + 1
            java.lang.String r0 = r0.substring(r1)     // Catch:{ MessagingException -> 0x0017 }
            r2.name = r0     // Catch:{ MessagingException -> 0x0017 }
        L_0x0017:
            java.lang.String r0 = r2.name     // Catch:{ all -> 0x001b }
            monitor-exit(r2)
            return r0
        L_0x001b:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.getName():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        throw new javax.mail.MessagingException(r0.getMessage(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        throw new javax.mail.StoreClosedException(r4.store, r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0 = getStoreProtocol();
        r1 = r0.examine(r4.fullName);
        r0.close();
        r1 = r1.recent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        releaseStoreProtocol(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0049, code lost:
        throw new javax.mail.MessagingException(r1.getMessage(), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        releaseStoreProtocol(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004d, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x005c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0066, code lost:
        throw new javax.mail.MessagingException(r1.getMessage(), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0067, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0071, code lost:
        throw new javax.mail.FolderClosedException(r4, r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x0008, B:18:0x0029, B:26:0x0040, B:35:0x0052] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int getNewMessageCount() throws javax.mail.MessagingException {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.opened     // Catch:{ all -> 0x0074 }
            if (r0 != 0) goto L_0x004e
            r4.checkExists()     // Catch:{ all -> 0x0074 }
            com.sun.mail.imap.protocol.Status r0 = r4.getStatus()     // Catch:{ BadCommandException -> 0x0028, ConnectionException -> 0x001b, ProtocolException -> 0x0010 }
            int r0 = r0.recent     // Catch:{ BadCommandException -> 0x0028, ConnectionException -> 0x001b, ProtocolException -> 0x0010 }
            monitor-exit(r4)
            return r0
        L_0x0010:
            r0 = move-exception
            javax.mail.MessagingException r1 = new javax.mail.MessagingException     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x0074 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0074 }
            throw r1     // Catch:{ all -> 0x0074 }
        L_0x001b:
            r0 = move-exception
            javax.mail.StoreClosedException r1 = new javax.mail.StoreClosedException     // Catch:{ all -> 0x0074 }
            javax.mail.Store r2 = r4.store     // Catch:{ all -> 0x0074 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0074 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0074 }
            throw r1     // Catch:{ all -> 0x0074 }
        L_0x0028:
            r0 = 0
            com.sun.mail.imap.protocol.IMAPProtocol r0 = r4.getStoreProtocol()     // Catch:{ ProtocolException -> 0x003f }
            java.lang.String r1 = r4.fullName     // Catch:{ ProtocolException -> 0x003f }
            com.sun.mail.imap.protocol.MailboxInfo r1 = r0.examine(r1)     // Catch:{ ProtocolException -> 0x003f }
            r0.close()     // Catch:{ ProtocolException -> 0x003f }
            int r1 = r1.recent     // Catch:{ ProtocolException -> 0x003f }
            r4.releaseStoreProtocol(r0)     // Catch:{ all -> 0x0074 }
            monitor-exit(r4)
            return r1
        L_0x003d:
            r1 = move-exception
            goto L_0x004a
        L_0x003f:
            r1 = move-exception
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x003d }
            java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x003d }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x003d }
            throw r2     // Catch:{ all -> 0x003d }
        L_0x004a:
            r4.releaseStoreProtocol(r0)     // Catch:{ all -> 0x0074 }
            throw r1     // Catch:{ all -> 0x0074 }
        L_0x004e:
            java.lang.Object r0 = r4.messageCacheLock     // Catch:{ all -> 0x0074 }
            monitor-enter(r0)     // Catch:{ all -> 0x0074 }
            r1 = 1
            r4.keepConnectionAlive(r1)     // Catch:{ ConnectionException -> 0x0067, ProtocolException -> 0x005c }
            int r1 = r4.recent     // Catch:{ ConnectionException -> 0x0067, ProtocolException -> 0x005c }
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            monitor-exit(r4)
            return r1
        L_0x005a:
            r1 = move-exception
            goto L_0x0072
        L_0x005c:
            r1 = move-exception
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x005a }
            java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x005a }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x005a }
            throw r2     // Catch:{ all -> 0x005a }
        L_0x0067:
            r1 = move-exception
            javax.mail.FolderClosedException r2 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x005a }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x005a }
            r2.<init>(r4, r1)     // Catch:{ all -> 0x005a }
            throw r2     // Catch:{ all -> 0x005a }
        L_0x0072:
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            throw r1     // Catch:{ all -> 0x0074 }
        L_0x0074:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.getNewMessageCount():int");
    }

    public synchronized Folder getParent() throws MessagingException {
        char separator2 = getSeparator();
        int lastIndexOf = this.fullName.lastIndexOf(separator2);
        if (lastIndexOf != -1) {
            return new IMAPFolder(this.fullName.substring(0, lastIndexOf), separator2, (IMAPStore) this.store);
        }
        return new DefaultFolder((IMAPStore) this.store);
    }

    public synchronized Flags getPermanentFlags() {
        return (Flags) this.permanentFlags.clone();
    }

    public Quota[] getQuota() throws MessagingException {
        return (Quota[]) doOptionalCommand("QUOTA not supported", new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.getQuotaRoot(IMAPFolder.this.fullName);
            }
        });
    }

    public synchronized char getSeparator() throws MessagingException {
        if (this.separator == 65535) {
            ListInfo[] listInfoArr = null;
            ListInfo[] listInfoArr2 = (ListInfo[]) doCommand(new ProtocolCommand() {
                public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                    return iMAPProtocol.isREV1() ? iMAPProtocol.list(IMAPFolder.this.fullName, "") : iMAPProtocol.list("", IMAPFolder.this.fullName);
                }
            });
            if (listInfoArr2 != null) {
                this.separator = listInfoArr2[0].separator;
            } else {
                this.separator = '/';
            }
        }
        return this.separator;
    }

    /* access modifiers changed from: protected */
    public synchronized IMAPProtocol getStoreProtocol() throws ProtocolException {
        if (this.connectionPoolDebug) {
            this.out.println("DEBUG: getStoreProtocol() - borrowing a connection");
        }
        return ((IMAPStore) this.store).getStoreProtocol();
    }

    public synchronized int getType() throws MessagingException {
        if (!this.opened) {
            checkExists();
        } else if (this.attributes == null) {
            exists();
        }
        return this.type;
    }

    public synchronized long getUID(Message message) throws MessagingException {
        if (message.getFolder() == this) {
            checkOpened();
            IMAPMessage iMAPMessage = (IMAPMessage) message;
            long uid = iMAPMessage.getUID();
            if (uid != -1) {
                return uid;
            }
            synchronized (this.messageCacheLock) {
                try {
                    IMAPProtocol protocol2 = getProtocol();
                    iMAPMessage.checkExpunged();
                    UID fetchUID = protocol2.fetchUID(iMAPMessage.getSequenceNumber());
                    if (fetchUID != null) {
                        uid = fetchUID.uid;
                        iMAPMessage.setUID(uid);
                        if (this.uidTable == null) {
                            this.uidTable = new Hashtable();
                        }
                        this.uidTable.put(new Long(uid), iMAPMessage);
                    }
                } catch (ConnectionException e2) {
                    throw new FolderClosedException(this, e2.getMessage());
                } catch (ProtocolException e3) {
                    throw new MessagingException(e3.getMessage(), e3);
                }
            }
            return uid;
        }
        throw new NoSuchElementException("Message does not belong to this folder");
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x001a=Splitter:B:13:0x001a, B:38:0x004e=Splitter:B:38:0x004e} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x0045=Splitter:B:34:0x0045, B:22:0x002d=Splitter:B:22:0x002d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized long getUIDNext() throws javax.mail.MessagingException {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.opened     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0009
            long r0 = r5.uidnext     // Catch:{ all -> 0x0052 }
            monitor-exit(r5)
            return r0
        L_0x0009:
            r0 = 0
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r5.getStoreProtocol()     // Catch:{ BadCommandException -> 0x0041, ConnectionException -> 0x0037, ProtocolException -> 0x0029, all -> 0x0024 }
            java.lang.String r2 = "UIDNEXT"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ BadCommandException -> 0x0022, ConnectionException -> 0x0020, ProtocolException -> 0x001e }
            java.lang.String r3 = r5.fullName     // Catch:{ BadCommandException -> 0x0022, ConnectionException -> 0x0020, ProtocolException -> 0x001e }
            com.sun.mail.imap.protocol.Status r0 = r1.status(r3, r2)     // Catch:{ BadCommandException -> 0x0022, ConnectionException -> 0x0020, ProtocolException -> 0x001e }
        L_0x001a:
            r5.releaseStoreProtocol(r1)     // Catch:{ all -> 0x0052 }
            goto L_0x003d
        L_0x001e:
            r0 = move-exception
            goto L_0x002d
        L_0x0020:
            r2 = move-exception
            goto L_0x0039
        L_0x0022:
            r0 = move-exception
            goto L_0x0045
        L_0x0024:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x004e
        L_0x0029:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x002d:
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x004d }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x004d }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x004d }
            throw r2     // Catch:{ all -> 0x004d }
        L_0x0037:
            r2 = move-exception
            r1 = r0
        L_0x0039:
            r5.throwClosedException(r2)     // Catch:{ all -> 0x004d }
            goto L_0x001a
        L_0x003d:
            long r0 = r0.uidnext     // Catch:{ all -> 0x0052 }
            monitor-exit(r5)
            return r0
        L_0x0041:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0045:
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x004d }
            java.lang.String r3 = "Cannot obtain UIDNext"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x004d }
            throw r2     // Catch:{ all -> 0x004d }
        L_0x004d:
            r0 = move-exception
        L_0x004e:
            r5.releaseStoreProtocol(r1)     // Catch:{ all -> 0x0052 }
            throw r0     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r0 = move-exception
            monitor-exit(r5)
            goto L_0x0056
        L_0x0055:
            throw r0
        L_0x0056:
            goto L_0x0055
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.getUIDNext():long");
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x001a=Splitter:B:13:0x001a, B:38:0x004e=Splitter:B:38:0x004e} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x0045=Splitter:B:34:0x0045, B:22:0x002d=Splitter:B:22:0x002d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized long getUIDValidity() throws javax.mail.MessagingException {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.opened     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0009
            long r0 = r5.uidvalidity     // Catch:{ all -> 0x0052 }
            monitor-exit(r5)
            return r0
        L_0x0009:
            r0 = 0
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r5.getStoreProtocol()     // Catch:{ BadCommandException -> 0x0041, ConnectionException -> 0x0037, ProtocolException -> 0x0029, all -> 0x0024 }
            java.lang.String r2 = "UIDVALIDITY"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ BadCommandException -> 0x0022, ConnectionException -> 0x0020, ProtocolException -> 0x001e }
            java.lang.String r3 = r5.fullName     // Catch:{ BadCommandException -> 0x0022, ConnectionException -> 0x0020, ProtocolException -> 0x001e }
            com.sun.mail.imap.protocol.Status r0 = r1.status(r3, r2)     // Catch:{ BadCommandException -> 0x0022, ConnectionException -> 0x0020, ProtocolException -> 0x001e }
        L_0x001a:
            r5.releaseStoreProtocol(r1)     // Catch:{ all -> 0x0052 }
            goto L_0x003d
        L_0x001e:
            r0 = move-exception
            goto L_0x002d
        L_0x0020:
            r2 = move-exception
            goto L_0x0039
        L_0x0022:
            r0 = move-exception
            goto L_0x0045
        L_0x0024:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x004e
        L_0x0029:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x002d:
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x004d }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x004d }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x004d }
            throw r2     // Catch:{ all -> 0x004d }
        L_0x0037:
            r2 = move-exception
            r1 = r0
        L_0x0039:
            r5.throwClosedException(r2)     // Catch:{ all -> 0x004d }
            goto L_0x001a
        L_0x003d:
            long r0 = r0.uidvalidity     // Catch:{ all -> 0x0052 }
            monitor-exit(r5)
            return r0
        L_0x0041:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0045:
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x004d }
            java.lang.String r3 = "Cannot obtain UIDValidity"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x004d }
            throw r2     // Catch:{ all -> 0x004d }
        L_0x004d:
            r0 = move-exception
        L_0x004e:
            r5.releaseStoreProtocol(r1)     // Catch:{ all -> 0x0052 }
            throw r0     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r0 = move-exception
            monitor-exit(r5)
            goto L_0x0056
        L_0x0055:
            throw r0
        L_0x0056:
            goto L_0x0055
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.getUIDValidity():long");
    }

    public synchronized int getUnreadMessageCount() throws MessagingException {
        int length;
        if (!this.opened) {
            checkExists();
            try {
                return getStatus().unseen;
            } catch (BadCommandException unused) {
                return -1;
            } catch (ConnectionException e2) {
                throw new StoreClosedException(this.store, e2.getMessage());
            } catch (ProtocolException e3) {
                throw new MessagingException(e3.getMessage(), e3);
            }
        } else {
            Flags flags = new Flags();
            flags.add(Flags.Flag.SEEN);
            try {
                synchronized (this.messageCacheLock) {
                    length = getProtocol().search(new FlagTerm(flags, false)).length;
                }
                return length;
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this, e4.getMessage());
            } catch (ProtocolException e5) {
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
    }

    public void handleResponse(Response response) {
        IMAPMessage messageBySeqNumber;
        if (response.isOK() || response.isNO() || response.isBAD() || response.isBYE()) {
            ((IMAPStore) this.store).handleResponseCode(response);
        }
        if (response.isBYE()) {
            if (this.opened) {
                cleanup(false);
            }
        } else if (response.isOK() || !response.isUnTagged()) {
        } else {
            if (!(response instanceof IMAPResponse)) {
                this.out.println("UNEXPECTED RESPONSE : " + response.toString());
                this.out.println("CONTACT javamail@sun.com");
                return;
            }
            IMAPResponse iMAPResponse = (IMAPResponse) response;
            if (iMAPResponse.keyEquals("EXISTS")) {
                int number = iMAPResponse.getNumber();
                int i2 = this.realTotal;
                if (number > i2) {
                    int i3 = number - i2;
                    Message[] messageArr = new Message[i3];
                    for (int i4 = 0; i4 < i3; i4++) {
                        int i5 = this.total + 1;
                        this.total = i5;
                        int i6 = this.realTotal + 1;
                        this.realTotal = i6;
                        IMAPMessage iMAPMessage = new IMAPMessage(this, i5, i6);
                        messageArr[i4] = iMAPMessage;
                        this.messageCache.addElement(iMAPMessage);
                    }
                    notifyMessageAddedListeners(messageArr);
                }
            } else if (iMAPResponse.keyEquals("EXPUNGE")) {
                IMAPMessage messageBySeqNumber2 = getMessageBySeqNumber(iMAPResponse.getNumber());
                messageBySeqNumber2.setExpunged(true);
                for (int messageNumber = messageBySeqNumber2.getMessageNumber(); messageNumber < this.total; messageNumber++) {
                    IMAPMessage iMAPMessage2 = (IMAPMessage) this.messageCache.elementAt(messageNumber);
                    if (!iMAPMessage2.isExpunged()) {
                        iMAPMessage2.setSequenceNumber(iMAPMessage2.getSequenceNumber() - 1);
                    }
                }
                this.realTotal--;
                if (this.doExpungeNotification) {
                    notifyMessageRemovedListeners(false, new Message[]{messageBySeqNumber2});
                }
            } else if (iMAPResponse.keyEquals("FETCH")) {
                FetchResponse fetchResponse = (FetchResponse) iMAPResponse;
                Flags flags = (Flags) fetchResponse.getItem(Flags.class);
                if (flags != null && (messageBySeqNumber = getMessageBySeqNumber(fetchResponse.getNumber())) != null) {
                    messageBySeqNumber._setFlags(flags);
                    notifyMessageChangedListeners(1, messageBySeqNumber);
                }
            } else if (iMAPResponse.keyEquals("RECENT")) {
                this.recent = iMAPResponse.getNumber();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void handleResponses(Response[] responseArr) {
        for (int i2 = 0; i2 < responseArr.length; i2++) {
            if (responseArr[i2] != null) {
                handleResponse(responseArr[i2]);
            }
        }
    }

    public synchronized boolean hasNewMessages() throws MessagingException {
        boolean z2 = false;
        if (this.opened) {
            synchronized (this.messageCacheLock) {
                try {
                    keepConnectionAlive(true);
                    if (this.recent > 0) {
                        z2 = true;
                    }
                } catch (ConnectionException e2) {
                    throw new FolderClosedException(this, e2.getMessage());
                } catch (ProtocolException e3) {
                    throw new MessagingException(e3.getMessage(), e3);
                }
            }
            return z2;
        }
        checkExists();
        Boolean bool = (Boolean) doCommandIgnoreFailure(new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                ListInfo[] list = iMAPProtocol.list("", IMAPFolder.this.fullName);
                if (list != null) {
                    if (list[0].changeState == 1) {
                        return Boolean.TRUE;
                    }
                    if (list[0].changeState == 2) {
                        return Boolean.FALSE;
                    }
                }
                return IMAPFolder.this.getStatus().recent > 0 ? Boolean.TRUE : Boolean.FALSE;
            }
        });
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        if (r0 == null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r2 = r3.protocol;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        if (r2 == null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        if (r2.processIdleResponse(r0) != false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        r3.idleState = 0;
        r3.messageCacheLock.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        r0 = ((com.sun.mail.imap.IMAPStore) r3.store).getMinIdleTime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        if (r0 <= 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        java.lang.Thread.sleep((long) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0057, code lost:
        throw new javax.mail.MessagingException(r0.getMessage(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0058, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0059, code lost:
        throwClosedException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        r0 = r3.protocol.readIdleResponse();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r1 = r3.messageCacheLock;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void idle() throws javax.mail.MessagingException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.checkOpened()     // Catch:{ all -> 0x005d }
            java.lang.String r0 = "IDLE not supported"
            com.sun.mail.imap.IMAPFolder$19 r1 = new com.sun.mail.imap.IMAPFolder$19     // Catch:{ all -> 0x005d }
            r1.<init>()     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r3.doOptionalCommand(r0, r1)     // Catch:{ all -> 0x005d }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005d }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005d }
            if (r0 != 0) goto L_0x0019
            monitor-exit(r3)     // Catch:{ all -> 0x005d }
            return
        L_0x0019:
            monitor-exit(r3)     // Catch:{ all -> 0x005d }
        L_0x001a:
            com.sun.mail.imap.protocol.IMAPProtocol r0 = r3.protocol
            com.sun.mail.iap.Response r0 = r0.readIdleResponse()
            java.lang.Object r1 = r3.messageCacheLock     // Catch:{ ConnectionException -> 0x0058, ProtocolException -> 0x004d }
            monitor-enter(r1)     // Catch:{ ConnectionException -> 0x0058, ProtocolException -> 0x004d }
            if (r0 == 0) goto L_0x0032
            com.sun.mail.imap.protocol.IMAPProtocol r2 = r3.protocol     // Catch:{ all -> 0x004a }
            if (r2 == 0) goto L_0x0032
            boolean r0 = r2.processIdleResponse(r0)     // Catch:{ all -> 0x004a }
            if (r0 != 0) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            monitor-exit(r1)     // Catch:{ all -> 0x004a }
            goto L_0x001a
        L_0x0032:
            r0 = 0
            r3.idleState = r0     // Catch:{ all -> 0x004a }
            java.lang.Object r0 = r3.messageCacheLock     // Catch:{ all -> 0x004a }
            r0.notifyAll()     // Catch:{ all -> 0x004a }
            monitor-exit(r1)     // Catch:{ all -> 0x004a }
            javax.mail.Store r0 = r3.store
            com.sun.mail.imap.IMAPStore r0 = (com.sun.mail.imap.IMAPStore) r0
            int r0 = r0.getMinIdleTime()
            if (r0 <= 0) goto L_0x0049
            long r0 = (long) r0
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0049 }
        L_0x0049:
            return
        L_0x004a:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x004a }
            throw r0     // Catch:{ ConnectionException -> 0x0058, ProtocolException -> 0x004d }
        L_0x004d:
            r0 = move-exception
            javax.mail.MessagingException r1 = new javax.mail.MessagingException
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2, r0)
            throw r1
        L_0x0058:
            r0 = move-exception
            r3.throwClosedException(r0)
            goto L_0x001a
        L_0x005d:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x005d }
            goto L_0x0061
        L_0x0060:
            throw r0
        L_0x0061:
            goto L_0x0060
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.idle():void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:4|5|(3:7|8|9)|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x000c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isOpen() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.Object r0 = r2.messageCacheLock     // Catch:{ all -> 0x0014 }
            monitor-enter(r0)     // Catch:{ all -> 0x0014 }
            boolean r1 = r2.opened     // Catch:{ all -> 0x0011 }
            if (r1 == 0) goto L_0x000c
            r1 = 0
            r2.keepConnectionAlive(r1)     // Catch:{ ProtocolException -> 0x000c }
        L_0x000c:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            boolean r0 = r2.opened     // Catch:{ all -> 0x0014 }
            monitor-exit(r2)
            return r0
        L_0x0011:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r1     // Catch:{ all -> 0x0014 }
        L_0x0014:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.isOpen():boolean");
    }

    public synchronized boolean isSubscribed() {
        final String str;
        ListInfo[] listInfoArr = null;
        if (!this.isNamespace || this.separator == 0) {
            str = this.fullName;
        } else {
            str = String.valueOf(this.fullName) + this.separator;
        }
        try {
            listInfoArr = (ListInfo[]) doProtocolCommand(new ProtocolCommand() {
                public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                    return iMAPProtocol.lsub("", str);
                }
            });
        } catch (ProtocolException unused) {
        }
        if (listInfoArr == null) {
            return false;
        }
        return listInfoArr[findName(listInfoArr, str)].canOpen;
    }

    public Folder[] list(String str) throws MessagingException {
        return doList(str, false);
    }

    public Rights[] listRights(final String str) throws MessagingException {
        return (Rights[]) doOptionalCommand("ACL not supported", new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.listRights(IMAPFolder.this.fullName, str);
            }
        });
    }

    public Folder[] listSubscribed(String str) throws MessagingException {
        return doList(str, true);
    }

    public Rights myRights() throws MessagingException {
        return (Rights) doOptionalCommand("ACL not supported", new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.myRights(IMAPFolder.this.fullName);
            }
        });
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void open(int r8) throws javax.mail.MessagingException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.checkClosed()     // Catch:{ all -> 0x00e8 }
            javax.mail.Store r0 = r7.store     // Catch:{ all -> 0x00e8 }
            com.sun.mail.imap.IMAPStore r0 = (com.sun.mail.imap.IMAPStore) r0     // Catch:{ all -> 0x00e8 }
            com.sun.mail.imap.protocol.IMAPProtocol r0 = r0.getProtocol(r7)     // Catch:{ all -> 0x00e8 }
            r7.protocol = r0     // Catch:{ all -> 0x00e8 }
            java.lang.Object r0 = r7.messageCacheLock     // Catch:{ all -> 0x00e8 }
            monitor-enter(r0)     // Catch:{ all -> 0x00e8 }
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r7.protocol     // Catch:{ all -> 0x00e5 }
            r1.addResponseHandler(r7)     // Catch:{ all -> 0x00e5 }
            r1 = 0
            r2 = 0
            r3 = 1
            if (r8 != r3) goto L_0x0024
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r7.protocol     // Catch:{ CommandFailedException -> 0x00b7, ProtocolException -> 0x00a2 }
            java.lang.String r5 = r7.fullName     // Catch:{ CommandFailedException -> 0x00b7, ProtocolException -> 0x00a2 }
            com.sun.mail.imap.protocol.MailboxInfo r4 = r4.examine(r5)     // Catch:{ CommandFailedException -> 0x00b7, ProtocolException -> 0x00a2 }
            goto L_0x002c
        L_0x0024:
            com.sun.mail.imap.protocol.IMAPProtocol r4 = r7.protocol     // Catch:{ CommandFailedException -> 0x00b7, ProtocolException -> 0x00a2 }
            java.lang.String r5 = r7.fullName     // Catch:{ CommandFailedException -> 0x00b7, ProtocolException -> 0x00a2 }
            com.sun.mail.imap.protocol.MailboxInfo r4 = r4.select(r5)     // Catch:{ CommandFailedException -> 0x00b7, ProtocolException -> 0x00a2 }
        L_0x002c:
            int r5 = r4.mode     // Catch:{ all -> 0x00e5 }
            if (r5 == r8) goto L_0x0063
            r5 = 2
            if (r8 != r5) goto L_0x0042
            int r8 = r4.mode     // Catch:{ all -> 0x00e5 }
            if (r8 != r3) goto L_0x0042
            javax.mail.Store r8 = r7.store     // Catch:{ all -> 0x00e5 }
            com.sun.mail.imap.IMAPStore r8 = (com.sun.mail.imap.IMAPStore) r8     // Catch:{ all -> 0x00e5 }
            boolean r8 = r8.allowReadOnlySelect()     // Catch:{ all -> 0x00e5 }
            if (r8 == 0) goto L_0x0042
            goto L_0x0063
        L_0x0042:
            com.sun.mail.imap.protocol.IMAPProtocol r8 = r7.protocol     // Catch:{ ProtocolException -> 0x004b }
            r8.close()     // Catch:{ ProtocolException -> 0x004b }
            r7.releaseProtocol(r3)     // Catch:{ ProtocolException -> 0x004b }
            goto L_0x0059
        L_0x004b:
            com.sun.mail.imap.protocol.IMAPProtocol r8 = r7.protocol     // Catch:{ ProtocolException -> 0x0050, all -> 0x0054 }
            r8.logout()     // Catch:{ ProtocolException -> 0x0050, all -> 0x0054 }
        L_0x0050:
            r7.releaseProtocol(r2)     // Catch:{ all -> 0x0059 }
            goto L_0x0059
        L_0x0054:
            r8 = move-exception
            r7.releaseProtocol(r2)     // Catch:{ all -> 0x0059 }
            throw r8     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r7.protocol = r1     // Catch:{ all -> 0x00e5 }
            javax.mail.ReadOnlyFolderException r8 = new javax.mail.ReadOnlyFolderException     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = "Cannot open in desired mode"
            r8.<init>(r7, r1)     // Catch:{ all -> 0x00e5 }
            throw r8     // Catch:{ all -> 0x00e5 }
        L_0x0063:
            r7.opened = r3     // Catch:{ all -> 0x00e5 }
            r7.reallyClosed = r2     // Catch:{ all -> 0x00e5 }
            int r8 = r4.mode     // Catch:{ all -> 0x00e5 }
            r7.mode = r8     // Catch:{ all -> 0x00e5 }
            javax.mail.Flags r8 = r4.availableFlags     // Catch:{ all -> 0x00e5 }
            r7.availableFlags = r8     // Catch:{ all -> 0x00e5 }
            javax.mail.Flags r8 = r4.permanentFlags     // Catch:{ all -> 0x00e5 }
            r7.permanentFlags = r8     // Catch:{ all -> 0x00e5 }
            int r8 = r4.total     // Catch:{ all -> 0x00e5 }
            r7.realTotal = r8     // Catch:{ all -> 0x00e5 }
            r7.total = r8     // Catch:{ all -> 0x00e5 }
            int r8 = r4.recent     // Catch:{ all -> 0x00e5 }
            r7.recent = r8     // Catch:{ all -> 0x00e5 }
            long r5 = r4.uidvalidity     // Catch:{ all -> 0x00e5 }
            r7.uidvalidity = r5     // Catch:{ all -> 0x00e5 }
            long r4 = r4.uidnext     // Catch:{ all -> 0x00e5 }
            r7.uidnext = r4     // Catch:{ all -> 0x00e5 }
            java.util.Vector r8 = new java.util.Vector     // Catch:{ all -> 0x00e5 }
            int r4 = r7.total     // Catch:{ all -> 0x00e5 }
            r8.<init>(r4)     // Catch:{ all -> 0x00e5 }
            r7.messageCache = r8     // Catch:{ all -> 0x00e5 }
        L_0x008e:
            int r8 = r7.total     // Catch:{ all -> 0x00e5 }
            if (r2 < r8) goto L_0x0095
            monitor-exit(r0)     // Catch:{ all -> 0x00e5 }
            r8 = r1
            goto L_0x00be
        L_0x0095:
            java.util.Vector r8 = r7.messageCache     // Catch:{ all -> 0x00e5 }
            com.sun.mail.imap.IMAPMessage r4 = new com.sun.mail.imap.IMAPMessage     // Catch:{ all -> 0x00e5 }
            int r2 = r2 + 1
            r4.<init>(r7, r2, r2)     // Catch:{ all -> 0x00e5 }
            r8.addElement(r4)     // Catch:{ all -> 0x00e5 }
            goto L_0x008e
        L_0x00a2:
            r8 = move-exception
            com.sun.mail.imap.protocol.IMAPProtocol r3 = r7.protocol     // Catch:{ ProtocolException -> 0x00a8 }
            r3.logout()     // Catch:{ ProtocolException -> 0x00a8 }
        L_0x00a8:
            r7.releaseProtocol(r2)     // Catch:{ all -> 0x00e5 }
            r7.protocol = r1     // Catch:{ all -> 0x00e5 }
            javax.mail.MessagingException r1 = new javax.mail.MessagingException     // Catch:{ all -> 0x00e5 }
            java.lang.String r2 = r8.getMessage()     // Catch:{ all -> 0x00e5 }
            r1.<init>(r2, r8)     // Catch:{ all -> 0x00e5 }
            throw r1     // Catch:{ all -> 0x00e5 }
        L_0x00b7:
            r8 = move-exception
            r7.releaseProtocol(r3)     // Catch:{ all -> 0x00e5 }
            r7.protocol = r1     // Catch:{ all -> 0x00e5 }
            monitor-exit(r0)     // Catch:{ all -> 0x00e5 }
        L_0x00be:
            if (r8 == 0) goto L_0x00da
            r7.checkExists()     // Catch:{ all -> 0x00e8 }
            int r0 = r7.type     // Catch:{ all -> 0x00e8 }
            r0 = r0 & r3
            if (r0 != 0) goto L_0x00d0
            javax.mail.MessagingException r8 = new javax.mail.MessagingException     // Catch:{ all -> 0x00e8 }
            java.lang.String r0 = "folder cannot contain messages"
            r8.<init>(r0)     // Catch:{ all -> 0x00e8 }
            throw r8     // Catch:{ all -> 0x00e8 }
        L_0x00d0:
            javax.mail.MessagingException r0 = new javax.mail.MessagingException     // Catch:{ all -> 0x00e8 }
            java.lang.String r1 = r8.getMessage()     // Catch:{ all -> 0x00e8 }
            r0.<init>(r1, r8)     // Catch:{ all -> 0x00e8 }
            throw r0     // Catch:{ all -> 0x00e8 }
        L_0x00da:
            r7.exists = r3     // Catch:{ all -> 0x00e8 }
            r7.attributes = r1     // Catch:{ all -> 0x00e8 }
            r7.type = r3     // Catch:{ all -> 0x00e8 }
            r7.notifyConnectionListeners(r3)     // Catch:{ all -> 0x00e8 }
            monitor-exit(r7)
            return
        L_0x00e5:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00e5 }
            throw r8     // Catch:{ all -> 0x00e8 }
        L_0x00e8:
            r8 = move-exception
            monitor-exit(r7)
            goto L_0x00ec
        L_0x00eb:
            throw r8
        L_0x00ec:
            goto L_0x00eb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.open(int):void");
    }

    /* access modifiers changed from: protected */
    public synchronized void releaseStoreProtocol(IMAPProtocol iMAPProtocol) {
        if (iMAPProtocol != this.protocol) {
            ((IMAPStore) this.store).releaseStoreProtocol(iMAPProtocol);
        }
    }

    public void removeACL(final String str) throws MessagingException {
        doOptionalCommand("ACL not supported", new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                iMAPProtocol.deleteACL(IMAPFolder.this.fullName, str);
                return null;
            }
        });
    }

    public void removeRights(ACL acl) throws MessagingException {
        setACL(acl, '-');
    }

    public synchronized boolean renameTo(final Folder folder) throws MessagingException {
        checkClosed();
        checkExists();
        if (folder.getStore() != this.store) {
            throw new MessagingException("Can't rename across Stores");
        } else if (doCommandIgnoreFailure(new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                iMAPProtocol.rename(IMAPFolder.this.fullName, folder.getFullName());
                return Boolean.TRUE;
            }
        }) == null) {
            return false;
        } else {
            this.exists = false;
            this.attributes = null;
            notifyFolderRenamedListeners(folder);
            return true;
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized javax.mail.Message[] search(javax.mail.search.SearchTerm r6) throws javax.mail.MessagingException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.checkOpened()     // Catch:{ all -> 0x004f }
            r0 = 0
            javax.mail.Message[] r0 = (javax.mail.Message[]) r0     // Catch:{ CommandFailedException -> 0x0049, SearchException -> 0x0043, ConnectionException -> 0x0038, ProtocolException -> 0x002d }
            java.lang.Object r1 = r5.messageCacheLock     // Catch:{ CommandFailedException -> 0x0049, SearchException -> 0x0043, ConnectionException -> 0x0038, ProtocolException -> 0x002d }
            monitor-enter(r1)     // Catch:{ CommandFailedException -> 0x0049, SearchException -> 0x0043, ConnectionException -> 0x0038, ProtocolException -> 0x002d }
            com.sun.mail.imap.protocol.IMAPProtocol r2 = r5.getProtocol()     // Catch:{ all -> 0x002a }
            int[] r2 = r2.search(r6)     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x0027
            int r0 = r2.length     // Catch:{ all -> 0x002a }
            com.sun.mail.imap.IMAPMessage[] r0 = new com.sun.mail.imap.IMAPMessage[r0]     // Catch:{ all -> 0x002a }
            r3 = 0
        L_0x0018:
            int r4 = r2.length     // Catch:{ all -> 0x002a }
            if (r3 < r4) goto L_0x001c
            goto L_0x0027
        L_0x001c:
            r4 = r2[r3]     // Catch:{ all -> 0x002a }
            com.sun.mail.imap.IMAPMessage r4 = r5.getMessageBySeqNumber(r4)     // Catch:{ all -> 0x002a }
            r0[r3] = r4     // Catch:{ all -> 0x002a }
            int r3 = r3 + 1
            goto L_0x0018
        L_0x0027:
            monitor-exit(r1)     // Catch:{ all -> 0x002a }
            monitor-exit(r5)
            return r0
        L_0x002a:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x002a }
            throw r0     // Catch:{ CommandFailedException -> 0x0049, SearchException -> 0x0043, ConnectionException -> 0x0038, ProtocolException -> 0x002d }
        L_0x002d:
            r6 = move-exception
            javax.mail.MessagingException r0 = new javax.mail.MessagingException     // Catch:{ all -> 0x004f }
            java.lang.String r1 = r6.getMessage()     // Catch:{ all -> 0x004f }
            r0.<init>(r1, r6)     // Catch:{ all -> 0x004f }
            throw r0     // Catch:{ all -> 0x004f }
        L_0x0038:
            r6 = move-exception
            javax.mail.FolderClosedException r0 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x004f }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x004f }
            r0.<init>(r5, r6)     // Catch:{ all -> 0x004f }
            throw r0     // Catch:{ all -> 0x004f }
        L_0x0043:
            javax.mail.Message[] r6 = super.search(r6)     // Catch:{ all -> 0x004f }
            monitor-exit(r5)
            return r6
        L_0x0049:
            javax.mail.Message[] r6 = super.search(r6)     // Catch:{ all -> 0x004f }
            monitor-exit(r5)
            return r6
        L_0x004f:
            r6 = move-exception
            monitor-exit(r5)
            goto L_0x0053
        L_0x0052:
            throw r6
        L_0x0053:
            goto L_0x0052
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.search(javax.mail.search.SearchTerm):javax.mail.Message[]");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized javax.mail.Message[] search(javax.mail.search.SearchTerm r6, javax.mail.Message[] r7) throws javax.mail.MessagingException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.checkOpened()     // Catch:{ all -> 0x0063 }
            int r0 = r7.length     // Catch:{ all -> 0x0063 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r5)
            return r7
        L_0x0009:
            r0 = 0
            r1 = r0
            javax.mail.Message[] r1 = (javax.mail.Message[]) r1     // Catch:{ CommandFailedException -> 0x005d, SearchException -> 0x0057, ConnectionException -> 0x004c, ProtocolException -> 0x0041 }
            java.lang.Object r2 = r5.messageCacheLock     // Catch:{ CommandFailedException -> 0x005d, SearchException -> 0x0057, ConnectionException -> 0x004c, ProtocolException -> 0x0041 }
            monitor-enter(r2)     // Catch:{ CommandFailedException -> 0x005d, SearchException -> 0x0057, ConnectionException -> 0x004c, ProtocolException -> 0x0041 }
            com.sun.mail.imap.protocol.IMAPProtocol r3 = r5.getProtocol()     // Catch:{ all -> 0x003e }
            com.sun.mail.imap.protocol.MessageSet[] r0 = com.sun.mail.imap.Utility.toMessageSet(r7, r0)     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x0036
            int[] r0 = r3.search((com.sun.mail.imap.protocol.MessageSet[]) r0, (javax.mail.search.SearchTerm) r6)     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x0033
            int r1 = r0.length     // Catch:{ all -> 0x003e }
            com.sun.mail.imap.IMAPMessage[] r1 = new com.sun.mail.imap.IMAPMessage[r1]     // Catch:{ all -> 0x003e }
            r3 = 0
        L_0x0024:
            int r4 = r0.length     // Catch:{ all -> 0x003e }
            if (r3 < r4) goto L_0x0028
            goto L_0x0033
        L_0x0028:
            r4 = r0[r3]     // Catch:{ all -> 0x003e }
            com.sun.mail.imap.IMAPMessage r4 = r5.getMessageBySeqNumber(r4)     // Catch:{ all -> 0x003e }
            r1[r3] = r4     // Catch:{ all -> 0x003e }
            int r3 = r3 + 1
            goto L_0x0024
        L_0x0033:
            monitor-exit(r2)     // Catch:{ all -> 0x003e }
            monitor-exit(r5)
            return r1
        L_0x0036:
            javax.mail.MessageRemovedException r0 = new javax.mail.MessageRemovedException     // Catch:{ all -> 0x003e }
            java.lang.String r1 = "Messages have been removed"
            r0.<init>(r1)     // Catch:{ all -> 0x003e }
            throw r0     // Catch:{ all -> 0x003e }
        L_0x003e:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003e }
            throw r0     // Catch:{ CommandFailedException -> 0x005d, SearchException -> 0x0057, ConnectionException -> 0x004c, ProtocolException -> 0x0041 }
        L_0x0041:
            r6 = move-exception
            javax.mail.MessagingException r7 = new javax.mail.MessagingException     // Catch:{ all -> 0x0063 }
            java.lang.String r0 = r6.getMessage()     // Catch:{ all -> 0x0063 }
            r7.<init>(r0, r6)     // Catch:{ all -> 0x0063 }
            throw r7     // Catch:{ all -> 0x0063 }
        L_0x004c:
            r6 = move-exception
            javax.mail.FolderClosedException r7 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x0063 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0063 }
            r7.<init>(r5, r6)     // Catch:{ all -> 0x0063 }
            throw r7     // Catch:{ all -> 0x0063 }
        L_0x0057:
            javax.mail.Message[] r6 = super.search(r6, r7)     // Catch:{ all -> 0x0063 }
            monitor-exit(r5)
            return r6
        L_0x005d:
            javax.mail.Message[] r6 = super.search(r6, r7)     // Catch:{ all -> 0x0063 }
            monitor-exit(r5)
            return r6
        L_0x0063:
            r6 = move-exception
            monitor-exit(r5)
            goto L_0x0067
        L_0x0066:
            throw r6
        L_0x0067:
            goto L_0x0066
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.search(javax.mail.search.SearchTerm, javax.mail.Message[]):javax.mail.Message[]");
    }

    public synchronized void setFlags(Message[] messageArr, Flags flags, boolean z2) throws MessagingException {
        checkOpened();
        checkFlags(flags);
        if (messageArr.length != 0) {
            synchronized (this.messageCacheLock) {
                try {
                    IMAPProtocol protocol2 = getProtocol();
                    MessageSet[] messageSet = Utility.toMessageSet(messageArr, (Utility.Condition) null);
                    if (messageSet != null) {
                        protocol2.storeFlags(messageSet, flags, z2);
                    } else {
                        throw new MessageRemovedException("Messages have been removed");
                    }
                } catch (ConnectionException e2) {
                    throw new FolderClosedException(this, e2.getMessage());
                } catch (ProtocolException e3) {
                    throw new MessagingException(e3.getMessage(), e3);
                }
            }
        }
    }

    public void setQuota(final Quota quota) throws MessagingException {
        doOptionalCommand("QUOTA not supported", new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                iMAPProtocol.setQuota(quota);
                return null;
            }
        });
    }

    public synchronized void setSubscribed(final boolean z2) throws MessagingException {
        doCommandIgnoreFailure(new ProtocolCommand() {
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                if (z2) {
                    iMAPProtocol.subscribe(IMAPFolder.this.fullName);
                    return null;
                }
                iMAPProtocol.unsubscribe(IMAPFolder.this.fullName);
                return null;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void waitIfIdle() throws ProtocolException {
        while (true) {
            int i2 = this.idleState;
            if (i2 != 0) {
                if (i2 == 1) {
                    this.protocol.idleAbort();
                    this.idleState = 2;
                }
                try {
                    this.messageCacheLock.wait();
                } catch (InterruptedException unused) {
                }
            } else {
                return;
            }
        }
    }
}
