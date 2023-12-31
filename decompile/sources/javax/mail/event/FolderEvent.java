package javax.mail.event;

import javax.mail.Folder;

public class FolderEvent extends MailEvent {
    public static final int CREATED = 1;
    public static final int DELETED = 2;
    public static final int RENAMED = 3;
    private static final long serialVersionUID = 5278131310563694307L;
    protected transient Folder folder;
    protected transient Folder newFolder;
    protected int type;

    public FolderEvent(Object obj, Folder folder2, int i2) {
        this(obj, folder2, folder2, i2);
    }

    public FolderEvent(Object obj, Folder folder2, Folder folder3, int i2) {
        super(obj);
        this.folder = folder2;
        this.newFolder = folder3;
        this.type = i2;
    }

    public void dispatch(Object obj) {
        int i2 = this.type;
        if (i2 == 1) {
            ((FolderListener) obj).folderCreated(this);
        } else if (i2 == 2) {
            ((FolderListener) obj).folderDeleted(this);
        } else if (i2 == 3) {
            ((FolderListener) obj).folderRenamed(this);
        }
    }

    public Folder getFolder() {
        return this.folder;
    }

    public Folder getNewFolder() {
        return this.newFolder;
    }

    public int getType() {
        return this.type;
    }
}
