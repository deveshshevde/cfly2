package myjava.awt.datatransfer;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import myjava.awt.datatransfer.MimeTypeProcessor;
import np.a;

public class DataFlavor implements Externalizable, Cloneable {
    public static final DataFlavor javaFileListFlavor = new DataFlavor("application/x-java-file-list; class=java.util.List", "application/x-java-file-list");
    public static final String javaJVMLocalObjectMimeType = "application/x-java-jvm-local-objectref";
    public static final String javaRemoteObjectMimeType = "application/x-java-remote-object";
    public static final String javaSerializedObjectMimeType = "application/x-java-serialized-object";
    @Deprecated
    public static final DataFlavor plainTextFlavor = new DataFlavor("text/plain; charset=unicode; class=java.io.InputStream", "Plain Text");
    private static DataFlavor plainUnicodeFlavor = null;
    private static final long serialVersionUID = 8367026044764648243L;
    private static final String[] sortedTextFlavors = {"text/sgml", "text/xml", "text/html", "text/rtf", "text/enriched", "text/richtext", "text/uri-list", "text/tab-separated-values", "text/t140", "text/rfc822-headers", "text/parityfec", "text/directory", "text/css", "text/calendar", javaSerializedObjectMimeType, "text/plain"};
    public static final DataFlavor stringFlavor = new DataFlavor("application/x-java-serialized-object; class=java.lang.String", "Unicode String");
    private String humanPresentableName;
    private MimeTypeProcessor.MimeType mimeInfo;
    private Class<?> representationClass;

    public DataFlavor() {
        this.mimeInfo = null;
        this.humanPresentableName = null;
        this.representationClass = null;
    }

    public DataFlavor(Class<?> cls, String str) {
        MimeTypeProcessor.MimeType mimeType = new MimeTypeProcessor.MimeType("application", "x-java-serialized-object");
        this.mimeInfo = mimeType;
        this.humanPresentableName = str == null ? javaSerializedObjectMimeType : str;
        mimeType.a("class", cls.getName());
        this.representationClass = cls;
    }

    public DataFlavor(String str) throws ClassNotFoundException {
        init(str, (String) null, (ClassLoader) null);
    }

    public DataFlavor(String str, String str2) {
        try {
            init(str, str2, (ClassLoader) null);
        } catch (ClassNotFoundException e2) {
            throw new IllegalArgumentException(a.a("awt.16C", (Object) this.mimeInfo.a("class")), e2);
        }
    }

    public DataFlavor(String str, String str2, ClassLoader classLoader) throws ClassNotFoundException {
        init(str, str2, classLoader);
    }

    private static List<DataFlavor> fetchTextFlavors(List<DataFlavor> list, String str) {
        LinkedList linkedList = new LinkedList();
        Iterator<DataFlavor> it2 = list.iterator();
        while (it2.hasNext()) {
            DataFlavor next = it2.next();
            if (next.isFlavorTextType()) {
                if (next.mimeInfo.c().equals(str)) {
                    if (!linkedList.contains(next)) {
                        linkedList.add(next);
                    }
                }
            }
            it2.remove();
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        return linkedList;
    }

    private String getCharset() {
        if (this.mimeInfo == null || isCharsetRedundant()) {
            return "";
        }
        String a2 = this.mimeInfo.a("charset");
        return (!isCharsetRequired() || !(a2 == null || a2.length() == 0)) ? a2 == null ? "" : a2 : no.a.a().d();
    }

    private static List<DataFlavor> getFlavors(List<DataFlavor> list, Class<?> cls) {
        LinkedList linkedList = new LinkedList();
        for (DataFlavor next : list) {
            if (next.representationClass.equals(cls)) {
                linkedList.add(next);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        return list;
    }

    private static List<DataFlavor> getFlavors(List<DataFlavor> list, String[] strArr) {
        LinkedList linkedList = new LinkedList();
        Iterator<DataFlavor> it2 = list.iterator();
        while (it2.hasNext()) {
            DataFlavor next = it2.next();
            if (isCharsetSupported(next.getCharset())) {
                for (String forName : strArr) {
                    if (Charset.forName(forName).equals(Charset.forName(next.getCharset()))) {
                        linkedList.add(next);
                    }
                }
            } else {
                it2.remove();
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        return list;
    }

    private String getKeyInfo() {
        String str = String.valueOf(this.mimeInfo.c()) + ";class=" + this.representationClass.getName();
        if (!this.mimeInfo.a().equals("text") || isUnicodeFlavor()) {
            return str;
        }
        return String.valueOf(str) + ";charset=" + getCharset().toLowerCase();
    }

    public static final DataFlavor getTextPlainUnicodeFlavor() {
        if (plainUnicodeFlavor == null) {
            plainUnicodeFlavor = new DataFlavor("text/plain; charset=" + no.a.a().d() + "; class=java.io.InputStream", "Plain Text");
        }
        return plainUnicodeFlavor;
    }

    private void init(String str, String str2, ClassLoader classLoader) throws ClassNotFoundException {
        try {
            MimeTypeProcessor.MimeType a2 = MimeTypeProcessor.a(str);
            this.mimeInfo = a2;
            if (str2 != null) {
                this.humanPresentableName = str2;
            } else {
                this.humanPresentableName = String.valueOf(a2.a()) + '/' + this.mimeInfo.b();
            }
            String a3 = this.mimeInfo.a("class");
            if (a3 == null) {
                a3 = "java.io.InputStream";
                this.mimeInfo.a("class", a3);
            }
            this.representationClass = classLoader == null ? Class.forName(a3) : classLoader.loadClass(a3);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException(a.a("awt.16D", (Object) str));
        }
    }

    private boolean isByteCodeFlavor() {
        Class<?> cls = this.representationClass;
        if (cls != null) {
            return cls.equals(InputStream.class) || this.representationClass.equals(ByteBuffer.class) || this.representationClass.equals(byte[].class);
        }
        return false;
    }

    private boolean isCharsetRedundant() {
        String c2 = this.mimeInfo.c();
        return c2.equals("text/rtf") || c2.equals("text/tab-separated-values") || c2.equals("text/t140") || c2.equals("text/rfc822-headers") || c2.equals("text/parityfec");
    }

    private boolean isCharsetRequired() {
        String c2 = this.mimeInfo.c();
        return c2.equals("text/sgml") || c2.equals("text/xml") || c2.equals("text/html") || c2.equals("text/enriched") || c2.equals("text/richtext") || c2.equals("text/uri-list") || c2.equals("text/directory") || c2.equals("text/css") || c2.equals("text/calendar") || c2.equals(javaSerializedObjectMimeType) || c2.equals("text/plain");
    }

    private static boolean isCharsetSupported(String str) {
        try {
            return Charset.isSupported(str);
        } catch (IllegalCharsetNameException unused) {
            return false;
        }
    }

    private boolean isUnicodeFlavor() {
        Class<?> cls = this.representationClass;
        if (cls != null) {
            return cls.equals(Reader.class) || this.representationClass.equals(String.class) || this.representationClass.equals(CharBuffer.class) || this.representationClass.equals(char[].class);
        }
        return false;
    }

    private static List<DataFlavor> selectBestByAlphabet(List<DataFlavor> list) {
        int size = list.size();
        String[] strArr = new String[size];
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = list.get(i2).getCharset();
        }
        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
        for (DataFlavor next : list) {
            if (strArr[0].equalsIgnoreCase(next.getCharset())) {
                linkedList.add(next);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        return linkedList;
    }

    private static DataFlavor selectBestByCharset(List<DataFlavor> list) {
        List<DataFlavor> flavors = getFlavors(list, new String[]{"UTF-16", "UTF-8", "UTF-16BE", "UTF-16LE"});
        if (flavors == null && (flavors = getFlavors(list, new String[]{no.a.a().d()})) == null && (flavors = getFlavors(list, new String[]{"US-ASCII"})) == null) {
            flavors = selectBestByAlphabet(list);
        }
        if (flavors != null) {
            return flavors.size() == 1 ? flavors.get(0) : selectBestFlavorWOCharset(flavors);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = getFlavors(r2, (java.lang.Class<?>) java.lang.String.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        r0 = getFlavors(r2, (java.lang.Class<?>) java.nio.CharBuffer.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r0 = getFlavors(r2, (java.lang.Class<?>) char[].class);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static myjava.awt.datatransfer.DataFlavor selectBestFlavorWCharset(java.util.List<myjava.awt.datatransfer.DataFlavor> r2) {
        /*
            java.lang.Class<java.io.Reader> r0 = java.io.Reader.class
            java.util.List r0 = getFlavors((java.util.List<myjava.awt.datatransfer.DataFlavor>) r2, (java.lang.Class<?>) r0)
            r1 = 0
            if (r0 == 0) goto L_0x0010
        L_0x0009:
            java.lang.Object r2 = r0.get(r1)
            myjava.awt.datatransfer.DataFlavor r2 = (myjava.awt.datatransfer.DataFlavor) r2
            return r2
        L_0x0010:
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.util.List r0 = getFlavors((java.util.List<myjava.awt.datatransfer.DataFlavor>) r2, (java.lang.Class<?>) r0)
            if (r0 == 0) goto L_0x0019
            goto L_0x0009
        L_0x0019:
            java.lang.Class<java.nio.CharBuffer> r0 = java.nio.CharBuffer.class
            java.util.List r0 = getFlavors((java.util.List<myjava.awt.datatransfer.DataFlavor>) r2, (java.lang.Class<?>) r0)
            if (r0 == 0) goto L_0x0022
            goto L_0x0009
        L_0x0022:
            java.lang.Class<char[]> r0 = char[].class
            java.util.List r0 = getFlavors((java.util.List<myjava.awt.datatransfer.DataFlavor>) r2, (java.lang.Class<?>) r0)
            if (r0 == 0) goto L_0x002b
            goto L_0x0009
        L_0x002b:
            myjava.awt.datatransfer.DataFlavor r2 = selectBestByCharset(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: myjava.awt.datatransfer.DataFlavor.selectBestFlavorWCharset(java.util.List):myjava.awt.datatransfer.DataFlavor");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.List<myjava.awt.datatransfer.DataFlavor>, java.util.List] */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r0 = getFlavors((java.util.List<myjava.awt.datatransfer.DataFlavor>) r2, (java.lang.Class<?>) java.nio.ByteBuffer.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
        r0 = getFlavors((java.util.List<myjava.awt.datatransfer.DataFlavor>) r2, (java.lang.Class<?>) byte[].class);
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static myjava.awt.datatransfer.DataFlavor selectBestFlavorWOCharset(java.util.List<myjava.awt.datatransfer.DataFlavor> r2) {
        /*
            java.lang.Class<java.io.InputStream> r0 = java.io.InputStream.class
            java.util.List r0 = getFlavors((java.util.List<myjava.awt.datatransfer.DataFlavor>) r2, (java.lang.Class<?>) r0)
            r1 = 0
            if (r0 == 0) goto L_0x0010
        L_0x0009:
            java.lang.Object r2 = r0.get(r1)
        L_0x000d:
            myjava.awt.datatransfer.DataFlavor r2 = (myjava.awt.datatransfer.DataFlavor) r2
            return r2
        L_0x0010:
            java.lang.Class<java.nio.ByteBuffer> r0 = java.nio.ByteBuffer.class
            java.util.List r0 = getFlavors((java.util.List<myjava.awt.datatransfer.DataFlavor>) r2, (java.lang.Class<?>) r0)
            if (r0 == 0) goto L_0x0019
            goto L_0x0009
        L_0x0019:
            java.lang.Class<byte[]> r0 = byte[].class
            java.util.List r0 = getFlavors((java.util.List<myjava.awt.datatransfer.DataFlavor>) r2, (java.lang.Class<?>) r0)
            if (r0 == 0) goto L_0x0022
            goto L_0x0009
        L_0x0022:
            java.lang.Object r2 = r2.get(r1)
            goto L_0x000d
        */
        throw new UnsupportedOperationException("Method not decompiled: myjava.awt.datatransfer.DataFlavor.selectBestFlavorWOCharset(java.util.List):myjava.awt.datatransfer.DataFlavor");
    }

    public static final DataFlavor selectBestTextFlavor(DataFlavor[] dataFlavorArr) {
        if (dataFlavorArr == null) {
            return null;
        }
        List<List<DataFlavor>> sortTextFlavorsByType = sortTextFlavorsByType(new LinkedList(Arrays.asList(dataFlavorArr)));
        if (sortTextFlavorsByType.isEmpty()) {
            return null;
        }
        List list = sortTextFlavorsByType.get(0);
        return list.size() == 1 ? (DataFlavor) list.get(0) : ((DataFlavor) list.get(0)).getCharset().length() == 0 ? selectBestFlavorWOCharset(list) : selectBestFlavorWCharset(list);
    }

    private static List<List<DataFlavor>> sortTextFlavorsByType(List<DataFlavor> list) {
        LinkedList linkedList = new LinkedList();
        for (String fetchTextFlavors : sortedTextFlavors) {
            List<DataFlavor> fetchTextFlavors2 = fetchTextFlavors(list, fetchTextFlavors);
            if (fetchTextFlavors2 != null) {
                linkedList.addLast(fetchTextFlavors2);
            }
        }
        if (!list.isEmpty()) {
            linkedList.addLast(list);
        }
        return linkedList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        return r0.loadClass(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        return r2.loadClass(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        return java.lang.ClassLoader.getSystemClassLoader().loadClass(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r0 = java.lang.Thread.currentThread().getContextClassLoader();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (r0 != null) goto L_0x0019;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static final java.lang.Class<?> tryToLoadClass(java.lang.String r1, java.lang.ClassLoader r2) throws java.lang.ClassNotFoundException {
        /*
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0005 }
            return r1
        L_0x0005:
            java.lang.ClassLoader r0 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ ClassNotFoundException -> 0x000e }
            java.lang.Class r1 = r0.loadClass(r1)     // Catch:{ ClassNotFoundException -> 0x000e }
            return r1
        L_0x000e:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r0 = r0.getContextClassLoader()
            if (r0 == 0) goto L_0x001e
            java.lang.Class r1 = r0.loadClass(r1)     // Catch:{ ClassNotFoundException -> 0x001e }
            return r1
        L_0x001e:
            java.lang.Class r1 = r2.loadClass(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: myjava.awt.datatransfer.DataFlavor.tryToLoadClass(java.lang.String, java.lang.ClassLoader):java.lang.Class");
    }

    public Object clone() throws CloneNotSupportedException {
        DataFlavor dataFlavor = new DataFlavor();
        dataFlavor.humanPresentableName = this.humanPresentableName;
        dataFlavor.representationClass = this.representationClass;
        MimeTypeProcessor.MimeType mimeType = this.mimeInfo;
        dataFlavor.mimeInfo = mimeType != null ? (MimeTypeProcessor.MimeType) mimeType.clone() : null;
        return dataFlavor;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DataFlavor)) {
            return false;
        }
        return equals((DataFlavor) obj);
    }

    @Deprecated
    public boolean equals(String str) {
        if (str == null) {
            return false;
        }
        return isMimeTypeEqual(str);
    }

    public boolean equals(DataFlavor dataFlavor) {
        if (dataFlavor == this) {
            return true;
        }
        if (dataFlavor == null) {
            return false;
        }
        MimeTypeProcessor.MimeType mimeType = this.mimeInfo;
        if (mimeType == null) {
            return dataFlavor.mimeInfo == null;
        }
        if (!mimeType.a(dataFlavor.mimeInfo) || !this.representationClass.equals(dataFlavor.representationClass)) {
            return false;
        }
        if (!this.mimeInfo.a().equals("text") || isUnicodeFlavor()) {
            return true;
        }
        String charset = getCharset();
        String charset2 = dataFlavor.getCharset();
        return (!isCharsetSupported(charset) || !isCharsetSupported(charset2)) ? charset.equalsIgnoreCase(charset2) : Charset.forName(charset).equals(Charset.forName(charset2));
    }

    public final Class<?> getDefaultRepresentationClass() {
        return InputStream.class;
    }

    public final String getDefaultRepresentationClassAsString() {
        return getDefaultRepresentationClass().getName();
    }

    public String getHumanPresentableName() {
        return this.humanPresentableName;
    }

    /* access modifiers changed from: package-private */
    public MimeTypeProcessor.MimeType getMimeInfo() {
        return this.mimeInfo;
    }

    public String getMimeType() {
        MimeTypeProcessor.MimeType mimeType = this.mimeInfo;
        if (mimeType != null) {
            return MimeTypeProcessor.a(mimeType);
        }
        return null;
    }

    public String getParameter(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("humanpresentablename")) {
            return this.humanPresentableName;
        }
        MimeTypeProcessor.MimeType mimeType = this.mimeInfo;
        if (mimeType != null) {
            return mimeType.a(lowerCase);
        }
        return null;
    }

    public String getPrimaryType() {
        MimeTypeProcessor.MimeType mimeType = this.mimeInfo;
        if (mimeType != null) {
            return mimeType.a();
        }
        return null;
    }

    public Reader getReaderForText(a aVar) throws UnsupportedFlavorException, IOException {
        InputStream inputStream;
        ByteArrayInputStream byteArrayInputStream;
        Object transferData = aVar.getTransferData(this);
        if (transferData == null) {
            throw new IllegalArgumentException(a.a("awt.16E"));
        } else if (transferData instanceof Reader) {
            Reader reader = (Reader) transferData;
            reader.reset();
            return reader;
        } else if (transferData instanceof String) {
            return new StringReader((String) transferData);
        } else {
            if (transferData instanceof CharBuffer) {
                return new CharArrayReader(((CharBuffer) transferData).array());
            }
            if (transferData instanceof char[]) {
                return new CharArrayReader((char[]) transferData);
            }
            String charset = getCharset();
            if (transferData instanceof InputStream) {
                inputStream = (InputStream) transferData;
                inputStream.reset();
            } else {
                if (transferData instanceof ByteBuffer) {
                    byteArrayInputStream = new ByteArrayInputStream(((ByteBuffer) transferData).array());
                } else if (transferData instanceof byte[]) {
                    byteArrayInputStream = new ByteArrayInputStream((byte[]) transferData);
                } else {
                    throw new IllegalArgumentException(a.a("awt.16F"));
                }
                inputStream = byteArrayInputStream;
            }
            return charset.length() == 0 ? new InputStreamReader(inputStream) : new InputStreamReader(inputStream, charset);
        }
    }

    public Class<?> getRepresentationClass() {
        return this.representationClass;
    }

    public String getSubType() {
        MimeTypeProcessor.MimeType mimeType = this.mimeInfo;
        if (mimeType != null) {
            return mimeType.b();
        }
        return null;
    }

    public int hashCode() {
        return getKeyInfo().hashCode();
    }

    public boolean isFlavorJavaFileListType() {
        return List.class.isAssignableFrom(this.representationClass) && isMimeTypeEqual(javaFileListFlavor);
    }

    public boolean isFlavorRemoteObjectType() {
        return isMimeTypeEqual(javaRemoteObjectMimeType) && isRepresentationClassRemote();
    }

    public boolean isFlavorSerializedObjectType() {
        return isMimeTypeSerializedObject() && isRepresentationClassSerializable();
    }

    public boolean isFlavorTextType() {
        if (equals(stringFlavor) || equals(plainTextFlavor)) {
            return true;
        }
        MimeTypeProcessor.MimeType mimeType = this.mimeInfo;
        if (mimeType != null && !mimeType.a().equals("text")) {
            return false;
        }
        String charset = getCharset();
        if (!isByteCodeFlavor()) {
            return isUnicodeFlavor();
        }
        if (charset.length() != 0) {
            return isCharsetSupported(charset);
        }
        return true;
    }

    public boolean isMimeTypeEqual(String str) {
        try {
            return this.mimeInfo.a(MimeTypeProcessor.a(str));
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public final boolean isMimeTypeEqual(DataFlavor dataFlavor) {
        MimeTypeProcessor.MimeType mimeType = this.mimeInfo;
        MimeTypeProcessor.MimeType mimeType2 = dataFlavor.mimeInfo;
        return mimeType != null ? mimeType.a(mimeType2) : mimeType2 == null;
    }

    public boolean isMimeTypeSerializedObject() {
        return isMimeTypeEqual(javaSerializedObjectMimeType);
    }

    public boolean isRepresentationClassByteBuffer() {
        return ByteBuffer.class.isAssignableFrom(this.representationClass);
    }

    public boolean isRepresentationClassCharBuffer() {
        return CharBuffer.class.isAssignableFrom(this.representationClass);
    }

    public boolean isRepresentationClassInputStream() {
        return InputStream.class.isAssignableFrom(this.representationClass);
    }

    public boolean isRepresentationClassReader() {
        return Reader.class.isAssignableFrom(this.representationClass);
    }

    public boolean isRepresentationClassRemote() {
        return false;
    }

    public boolean isRepresentationClassSerializable() {
        return Serializable.class.isAssignableFrom(this.representationClass);
    }

    public boolean match(DataFlavor dataFlavor) {
        return equals(dataFlavor);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public String normalizeMimeType(String str) {
        return str;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public String normalizeMimeTypeParameter(String str, String str2) {
        return str2;
    }

    public synchronized void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.humanPresentableName = (String) objectInput.readObject();
        MimeTypeProcessor.MimeType mimeType = (MimeTypeProcessor.MimeType) objectInput.readObject();
        this.mimeInfo = mimeType;
        this.representationClass = mimeType != null ? Class.forName(mimeType.a("class")) : null;
    }

    public void setHumanPresentableName(String str) {
        this.humanPresentableName = str;
    }

    public String toString() {
        return String.valueOf(getClass().getName()) + "[MimeType=(" + getMimeType() + ");humanPresentableName=" + this.humanPresentableName + "]";
    }

    public synchronized void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.humanPresentableName);
        objectOutput.writeObject(this.mimeInfo);
    }
}
