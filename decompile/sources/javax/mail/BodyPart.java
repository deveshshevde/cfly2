package javax.mail;

public abstract class BodyPart implements Part {
    protected Multipart parent;

    public Multipart getParent() {
        return this.parent;
    }

    /* access modifiers changed from: package-private */
    public void setParent(Multipart multipart) {
        this.parent = multipart;
    }
}
