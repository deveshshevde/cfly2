package javax.mail.internet;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.FolderClosedIOException;
import com.sun.mail.util.LineOutputStream;
import com.sun.mail.util.MessageRemovedIOException;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Vector;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.FolderClosedException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.HeaderTokenizer;
import retrofit.mime.MultipartTypedOutput;

public class MimeBodyPart extends BodyPart implements MimePart {
    static boolean cacheMultipart = true;
    private static boolean decodeFileName = false;
    private static boolean encodeFileName = false;
    private static boolean setContentTypeFileName = true;
    private static boolean setDefaultTextCharset = true;
    private Object cachedContent;
    protected byte[] content;
    protected InputStream contentStream;

    /* renamed from: dh  reason: collision with root package name */
    protected DataHandler f29475dh;
    protected InternetHeaders headers;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025 A[Catch:{ SecurityException -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027 A[Catch:{ SecurityException -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0038 A[Catch:{ SecurityException -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a A[Catch:{ SecurityException -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b A[Catch:{ SecurityException -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d A[Catch:{ SecurityException -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e A[Catch:{ SecurityException -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005f A[Catch:{ SecurityException -> 0x0062 }] */
    static {
        /*
            java.lang.String r0 = "mail.mime.setdefaulttextcharset"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x0062 }
            r1 = 0
            java.lang.String r2 = "false"
            r3 = 1
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ SecurityException -> 0x0062 }
            if (r0 == 0) goto L_0x0014
            r0 = 0
            goto L_0x0015
        L_0x0014:
            r0 = 1
        L_0x0015:
            setDefaultTextCharset = r0     // Catch:{ SecurityException -> 0x0062 }
            java.lang.String r0 = "mail.mime.setcontenttypefilename"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x0062 }
            if (r0 == 0) goto L_0x0027
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ SecurityException -> 0x0062 }
            if (r0 == 0) goto L_0x0027
            r0 = 0
            goto L_0x0028
        L_0x0027:
            r0 = 1
        L_0x0028:
            setContentTypeFileName = r0     // Catch:{ SecurityException -> 0x0062 }
            java.lang.String r0 = "mail.mime.encodefilename"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x0062 }
            if (r0 == 0) goto L_0x003a
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ SecurityException -> 0x0062 }
            if (r0 != 0) goto L_0x003a
            r0 = 1
            goto L_0x003b
        L_0x003a:
            r0 = 0
        L_0x003b:
            encodeFileName = r0     // Catch:{ SecurityException -> 0x0062 }
            java.lang.String r0 = "mail.mime.decodefilename"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x0062 }
            if (r0 == 0) goto L_0x004d
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ SecurityException -> 0x0062 }
            if (r0 != 0) goto L_0x004d
            r0 = 1
            goto L_0x004e
        L_0x004d:
            r0 = 0
        L_0x004e:
            decodeFileName = r0     // Catch:{ SecurityException -> 0x0062 }
            java.lang.String r0 = "mail.mime.cachemultipart"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x0062 }
            if (r0 == 0) goto L_0x005f
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ SecurityException -> 0x0062 }
            if (r0 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r1 = 1
        L_0x0060:
            cacheMultipart = r1     // Catch:{ SecurityException -> 0x0062 }
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeBodyPart.<clinit>():void");
    }

    public MimeBodyPart() {
        this.headers = new InternetHeaders();
    }

    public MimeBodyPart(InputStream inputStream) throws MessagingException {
        if (!(inputStream instanceof ByteArrayInputStream) && !(inputStream instanceof BufferedInputStream) && !(inputStream instanceof SharedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        this.headers = new InternetHeaders(inputStream);
        if (inputStream instanceof SharedInputStream) {
            SharedInputStream sharedInputStream = (SharedInputStream) inputStream;
            this.contentStream = sharedInputStream.newStream(sharedInputStream.getPosition(), -1);
            return;
        }
        try {
            this.content = ASCIIUtility.getBytes(inputStream);
        } catch (IOException e2) {
            throw new MessagingException("Error reading input stream", e2);
        }
    }

    public MimeBodyPart(InternetHeaders internetHeaders, byte[] bArr) throws MessagingException {
        this.headers = internetHeaders;
        this.content = bArr;
    }

    static String[] getContentLanguage(MimePart mimePart) throws MessagingException {
        String header = mimePart.getHeader("Content-Language", (String) null);
        if (header == null) {
            return null;
        }
        HeaderTokenizer headerTokenizer = new HeaderTokenizer(header, HeaderTokenizer.MIME);
        Vector vector = new Vector();
        while (true) {
            HeaderTokenizer.Token next = headerTokenizer.next();
            int type = next.getType();
            if (type == -4) {
                break;
            } else if (type == -1) {
                vector.addElement(next.getValue());
            }
        }
        if (vector.size() == 0) {
            return null;
        }
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        return strArr;
    }

    static String getDescription(MimePart mimePart) throws MessagingException {
        String header = mimePart.getHeader("Content-Description", (String) null);
        if (header == null) {
            return null;
        }
        try {
            return MimeUtility.decodeText(MimeUtility.unfold(header));
        } catch (UnsupportedEncodingException unused) {
            return header;
        }
    }

    static String getDisposition(MimePart mimePart) throws MessagingException {
        String header = mimePart.getHeader("Content-Disposition", (String) null);
        if (header == null) {
            return null;
        }
        return new ContentDisposition(header).getDisposition();
    }

    static String getEncoding(MimePart mimePart) throws MessagingException {
        HeaderTokenizer.Token next;
        int type;
        String header = mimePart.getHeader("Content-Transfer-Encoding", (String) null);
        if (header == null) {
            return null;
        }
        String trim = header.trim();
        if (trim.equalsIgnoreCase("7bit") || trim.equalsIgnoreCase("8bit") || trim.equalsIgnoreCase("quoted-printable") || trim.equalsIgnoreCase(MultipartTypedOutput.DEFAULT_TRANSFER_ENCODING) || trim.equalsIgnoreCase("base64")) {
            return trim;
        }
        HeaderTokenizer headerTokenizer = new HeaderTokenizer(trim, HeaderTokenizer.MIME);
        do {
            next = headerTokenizer.next();
            type = next.getType();
            if (type == -4) {
                return trim;
            }
        } while (type != -1);
        return next.getValue();
    }

    static String getFileName(MimePart mimePart) throws MessagingException {
        String header;
        String header2 = mimePart.getHeader("Content-Disposition", (String) null);
        String parameter = header2 != null ? new ContentDisposition(header2).getParameter("filename") : null;
        if (parameter == null && (header = mimePart.getHeader("Content-Type", (String) null)) != null) {
            try {
                parameter = new ContentType(header).getParameter("name");
            } catch (ParseException unused) {
            }
        }
        if (!decodeFileName || parameter == null) {
            return parameter;
        }
        try {
            return MimeUtility.decodeText(parameter);
        } catch (UnsupportedEncodingException e2) {
            throw new MessagingException("Can't decode filename", e2);
        }
    }

    static void invalidateContentHeaders(MimePart mimePart) throws MessagingException {
        mimePart.removeHeader("Content-Type");
        mimePart.removeHeader("Content-Transfer-Encoding");
    }

    static boolean isMimeType(MimePart mimePart, String str) throws MessagingException {
        try {
            return new ContentType(mimePart.getContentType()).match(str);
        } catch (ParseException unused) {
            return mimePart.getContentType().equalsIgnoreCase(str);
        }
    }

    static void setContentLanguage(MimePart mimePart, String[] strArr) throws MessagingException {
        StringBuffer stringBuffer = new StringBuffer(strArr[0]);
        for (int i2 = 1; i2 < strArr.length; i2++) {
            stringBuffer.append(',');
            stringBuffer.append(strArr[i2]);
        }
        mimePart.setHeader("Content-Language", stringBuffer.toString());
    }

    static void setDescription(MimePart mimePart, String str, String str2) throws MessagingException {
        if (str == null) {
            mimePart.removeHeader("Content-Description");
            return;
        }
        try {
            mimePart.setHeader("Content-Description", MimeUtility.fold(21, MimeUtility.encodeText(str, str2, (String) null)));
        } catch (UnsupportedEncodingException e2) {
            throw new MessagingException("Encoding error", e2);
        }
    }

    static void setDisposition(MimePart mimePart, String str) throws MessagingException {
        if (str == null) {
            mimePart.removeHeader("Content-Disposition");
            return;
        }
        String header = mimePart.getHeader("Content-Disposition", (String) null);
        if (header != null) {
            ContentDisposition contentDisposition = new ContentDisposition(header);
            contentDisposition.setDisposition(str);
            str = contentDisposition.toString();
        }
        mimePart.setHeader("Content-Disposition", str);
    }

    static void setEncoding(MimePart mimePart, String str) throws MessagingException {
        mimePart.setHeader("Content-Transfer-Encoding", str);
    }

    static void setFileName(MimePart mimePart, String str) throws MessagingException {
        String header;
        if (encodeFileName && str != null) {
            try {
                str = MimeUtility.encodeText(str);
            } catch (UnsupportedEncodingException e2) {
                throw new MessagingException("Can't encode filename", e2);
            }
        }
        String header2 = mimePart.getHeader("Content-Disposition", (String) null);
        if (header2 == null) {
            header2 = Part.ATTACHMENT;
        }
        ContentDisposition contentDisposition = new ContentDisposition(header2);
        contentDisposition.setParameter("filename", str);
        mimePart.setHeader("Content-Disposition", contentDisposition.toString());
        if (setContentTypeFileName && (header = mimePart.getHeader("Content-Type", (String) null)) != null) {
            try {
                ContentType contentType = new ContentType(header);
                contentType.setParameter("name", str);
                mimePart.setHeader("Content-Type", contentType.toString());
            } catch (ParseException unused) {
            }
        }
    }

    static void setText(MimePart mimePart, String str, String str2, String str3) throws MessagingException {
        if (str2 == null) {
            str2 = MimeUtility.checkAscii(str) != 1 ? MimeUtility.getDefaultMIMECharset() : "us-ascii";
        }
        mimePart.setContent(str, "text/" + str3 + "; charset=" + MimeUtility.quote(str2, HeaderTokenizer.MIME));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007e, code lost:
        if (r7.match("message/rfc822") != false) goto L_0x0080;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049 A[Catch:{ IOException -> 0x00e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f A[Catch:{ IOException -> 0x00e7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void updateHeaders(javax.mail.internet.MimePart r9) throws javax.mail.MessagingException {
        /*
            java.lang.String r0 = "charset"
            java.lang.String r1 = "Content-Type"
            javax.activation.DataHandler r2 = r9.getDataHandler()
            if (r2 != 0) goto L_0x000b
            return
        L_0x000b:
            java.lang.String r3 = r2.getContentType()     // Catch:{ IOException -> 0x00e7 }
            java.lang.String[] r4 = r9.getHeader(r1)     // Catch:{ IOException -> 0x00e7 }
            r5 = 0
            r6 = 1
            if (r4 != 0) goto L_0x0019
            r4 = 1
            goto L_0x001a
        L_0x0019:
            r4 = 0
        L_0x001a:
            javax.mail.internet.ContentType r7 = new javax.mail.internet.ContentType     // Catch:{ IOException -> 0x00e7 }
            r7.<init>(r3)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r8 = "multipart/*"
            boolean r8 = r7.match((java.lang.String) r8)     // Catch:{ IOException -> 0x00e7 }
            if (r8 == 0) goto L_0x0078
            boolean r5 = r9 instanceof javax.mail.internet.MimeBodyPart     // Catch:{ IOException -> 0x00e7 }
            if (r5 == 0) goto L_0x0038
            r5 = r9
            javax.mail.internet.MimeBodyPart r5 = (javax.mail.internet.MimeBodyPart) r5     // Catch:{ IOException -> 0x00e7 }
            java.lang.Object r5 = r5.cachedContent     // Catch:{ IOException -> 0x00e7 }
            if (r5 == 0) goto L_0x0033
            goto L_0x0045
        L_0x0033:
            java.lang.Object r5 = r2.getContent()     // Catch:{ IOException -> 0x00e7 }
            goto L_0x0045
        L_0x0038:
            boolean r5 = r9 instanceof javax.mail.internet.MimeMessage     // Catch:{ IOException -> 0x00e7 }
            if (r5 == 0) goto L_0x0033
            r5 = r9
            javax.mail.internet.MimeMessage r5 = (javax.mail.internet.MimeMessage) r5     // Catch:{ IOException -> 0x00e7 }
            java.lang.Object r8 = r5.cachedContent     // Catch:{ IOException -> 0x00e7 }
            if (r8 == 0) goto L_0x0033
            java.lang.Object r5 = r5.cachedContent     // Catch:{ IOException -> 0x00e7 }
        L_0x0045:
            boolean r8 = r5 instanceof javax.mail.internet.MimeMultipart     // Catch:{ IOException -> 0x00e7 }
            if (r8 == 0) goto L_0x004f
            javax.mail.internet.MimeMultipart r5 = (javax.mail.internet.MimeMultipart) r5     // Catch:{ IOException -> 0x00e7 }
            r5.updateHeaders()     // Catch:{ IOException -> 0x00e7 }
            goto L_0x0080
        L_0x004f:
            javax.mail.MessagingException r9 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x00e7 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r1 = "MIME part of type \""
            r0.<init>(r1)     // Catch:{ IOException -> 0x00e7 }
            r0.append(r3)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r1 = "\" contains object of type "
            r0.append(r1)     // Catch:{ IOException -> 0x00e7 }
            java.lang.Class r1 = r5.getClass()     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r1 = r1.getName()     // Catch:{ IOException -> 0x00e7 }
            r0.append(r1)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r1 = " instead of MimeMultipart"
            r0.append(r1)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x00e7 }
            r9.<init>(r0)     // Catch:{ IOException -> 0x00e7 }
            throw r9     // Catch:{ IOException -> 0x00e7 }
        L_0x0078:
            java.lang.String r8 = "message/rfc822"
            boolean r8 = r7.match((java.lang.String) r8)     // Catch:{ IOException -> 0x00e7 }
            if (r8 == 0) goto L_0x0081
        L_0x0080:
            r5 = 1
        L_0x0081:
            if (r5 != 0) goto L_0x00c2
            java.lang.String r5 = "Content-Transfer-Encoding"
            java.lang.String[] r5 = r9.getHeader(r5)     // Catch:{ IOException -> 0x00e7 }
            if (r5 != 0) goto L_0x0092
            java.lang.String r2 = javax.mail.internet.MimeUtility.getEncoding((javax.activation.DataHandler) r2)     // Catch:{ IOException -> 0x00e7 }
            setEncoding(r9, r2)     // Catch:{ IOException -> 0x00e7 }
        L_0x0092:
            if (r4 == 0) goto L_0x00c2
            boolean r2 = setDefaultTextCharset     // Catch:{ IOException -> 0x00e7 }
            if (r2 == 0) goto L_0x00c2
            java.lang.String r2 = "text/*"
            boolean r2 = r7.match((java.lang.String) r2)     // Catch:{ IOException -> 0x00e7 }
            if (r2 == 0) goto L_0x00c2
            java.lang.String r2 = r7.getParameter(r0)     // Catch:{ IOException -> 0x00e7 }
            if (r2 != 0) goto L_0x00c2
            java.lang.String r2 = r9.getEncoding()     // Catch:{ IOException -> 0x00e7 }
            if (r2 == 0) goto L_0x00b7
            java.lang.String r3 = "7bit"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ IOException -> 0x00e7 }
            if (r2 == 0) goto L_0x00b7
            java.lang.String r2 = "us-ascii"
            goto L_0x00bb
        L_0x00b7:
            java.lang.String r2 = javax.mail.internet.MimeUtility.getDefaultMIMECharset()     // Catch:{ IOException -> 0x00e7 }
        L_0x00bb:
            r7.setParameter(r0, r2)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r3 = r7.toString()     // Catch:{ IOException -> 0x00e7 }
        L_0x00c2:
            if (r4 == 0) goto L_0x00e6
            java.lang.String r0 = "Content-Disposition"
            r2 = 0
            java.lang.String r0 = r9.getHeader(r0, r2)     // Catch:{ IOException -> 0x00e7 }
            if (r0 == 0) goto L_0x00e3
            javax.mail.internet.ContentDisposition r2 = new javax.mail.internet.ContentDisposition     // Catch:{ IOException -> 0x00e7 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r0 = "filename"
            java.lang.String r0 = r2.getParameter(r0)     // Catch:{ IOException -> 0x00e7 }
            if (r0 == 0) goto L_0x00e3
            java.lang.String r2 = "name"
            r7.setParameter(r2, r0)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r3 = r7.toString()     // Catch:{ IOException -> 0x00e7 }
        L_0x00e3:
            r9.setHeader(r1, r3)     // Catch:{ IOException -> 0x00e7 }
        L_0x00e6:
            return
        L_0x00e7:
            r9 = move-exception
            javax.mail.MessagingException r0 = new javax.mail.MessagingException
            java.lang.String r1 = "IOException updating headers"
            r0.<init>(r1, r9)
            goto L_0x00f1
        L_0x00f0:
            throw r0
        L_0x00f1:
            goto L_0x00f0
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeBodyPart.updateHeaders(javax.mail.internet.MimePart):void");
    }

    static void writeTo(MimePart mimePart, OutputStream outputStream, String[] strArr) throws IOException, MessagingException {
        LineOutputStream lineOutputStream = outputStream instanceof LineOutputStream ? (LineOutputStream) outputStream : new LineOutputStream(outputStream);
        Enumeration nonMatchingHeaderLines = mimePart.getNonMatchingHeaderLines(strArr);
        while (nonMatchingHeaderLines.hasMoreElements()) {
            lineOutputStream.writeln((String) nonMatchingHeaderLines.nextElement());
        }
        lineOutputStream.writeln();
        OutputStream encode = MimeUtility.encode(outputStream, mimePart.getEncoding());
        mimePart.getDataHandler().writeTo(encode);
        encode.flush();
    }

    public void addHeader(String str, String str2) throws MessagingException {
        this.headers.addHeader(str, str2);
    }

    public void addHeaderLine(String str) throws MessagingException {
        this.headers.addHeaderLine(str);
    }

    public void attachFile(File file) throws IOException, MessagingException {
        FileDataSource fileDataSource = new FileDataSource(file);
        setDataHandler(new DataHandler((DataSource) fileDataSource));
        setFileName(fileDataSource.getName());
    }

    public void attachFile(String str) throws IOException, MessagingException {
        attachFile(new File(str));
    }

    public Enumeration getAllHeaderLines() throws MessagingException {
        return this.headers.getAllHeaderLines();
    }

    public Enumeration getAllHeaders() throws MessagingException {
        return this.headers.getAllHeaders();
    }

    public Object getContent() throws IOException, MessagingException {
        Object obj = this.cachedContent;
        if (obj != null) {
            return obj;
        }
        try {
            Object content2 = getDataHandler().getContent();
            if (cacheMultipart && (((content2 instanceof Multipart) || (content2 instanceof Message)) && !(this.content == null && this.contentStream == null))) {
                this.cachedContent = content2;
            }
            return content2;
        } catch (FolderClosedIOException e2) {
            throw new FolderClosedException(e2.getFolder(), e2.getMessage());
        } catch (MessageRemovedIOException e3) {
            throw new MessageRemovedException(e3.getMessage());
        }
    }

    public String getContentID() throws MessagingException {
        return getHeader("Content-Id", (String) null);
    }

    public String[] getContentLanguage() throws MessagingException {
        return getContentLanguage(this);
    }

    public String getContentMD5() throws MessagingException {
        return getHeader("Content-MD5", (String) null);
    }

    /* access modifiers changed from: protected */
    public InputStream getContentStream() throws MessagingException {
        InputStream inputStream = this.contentStream;
        if (inputStream != null) {
            return ((SharedInputStream) inputStream).newStream(0, -1);
        }
        if (this.content != null) {
            return new ByteArrayInputStream(this.content);
        }
        throw new MessagingException("No content");
    }

    public String getContentType() throws MessagingException {
        String header = getHeader("Content-Type", (String) null);
        return header == null ? "text/plain" : header;
    }

    public DataHandler getDataHandler() throws MessagingException {
        if (this.f29475dh == null) {
            this.f29475dh = new DataHandler((DataSource) new MimePartDataSource(this));
        }
        return this.f29475dh;
    }

    public String getDescription() throws MessagingException {
        return getDescription(this);
    }

    public String getDisposition() throws MessagingException {
        return getDisposition(this);
    }

    public String getEncoding() throws MessagingException {
        return getEncoding(this);
    }

    public String getFileName() throws MessagingException {
        return getFileName(this);
    }

    public String getHeader(String str, String str2) throws MessagingException {
        return this.headers.getHeader(str, str2);
    }

    public String[] getHeader(String str) throws MessagingException {
        return this.headers.getHeader(str);
    }

    public InputStream getInputStream() throws IOException, MessagingException {
        return getDataHandler().getInputStream();
    }

    public int getLineCount() throws MessagingException {
        return -1;
    }

    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        return this.headers.getMatchingHeaderLines(strArr);
    }

    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        return this.headers.getMatchingHeaders(strArr);
    }

    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        return this.headers.getNonMatchingHeaderLines(strArr);
    }

    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        return this.headers.getNonMatchingHeaders(strArr);
    }

    public InputStream getRawInputStream() throws MessagingException {
        return getContentStream();
    }

    public int getSize() throws MessagingException {
        byte[] bArr = this.content;
        if (bArr != null) {
            return bArr.length;
        }
        InputStream inputStream = this.contentStream;
        if (inputStream == null) {
            return -1;
        }
        try {
            int available = inputStream.available();
            if (available > 0) {
                return available;
            }
            return -1;
        } catch (IOException unused) {
            return -1;
        }
    }

    public boolean isMimeType(String str) throws MessagingException {
        return isMimeType(this, str);
    }

    public void removeHeader(String str) throws MessagingException {
        this.headers.removeHeader(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:3|4|(2:5|(1:28)(3:13|14|15))|(2:8|9)|10|11|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveFile(java.io.File r5) throws java.io.IOException, javax.mail.MessagingException {
        /*
            r4 = this;
            r0 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0029 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0029 }
            r2.<init>(r5)     // Catch:{ all -> 0x0029 }
            r1.<init>(r2)     // Catch:{ all -> 0x0029 }
            java.io.InputStream r0 = r4.getInputStream()     // Catch:{ all -> 0x0027 }
            r5 = 8192(0x2000, float:1.14794E-41)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x0027 }
        L_0x0013:
            int r2 = r0.read(r5)     // Catch:{ all -> 0x0027 }
            if (r2 > 0) goto L_0x0022
            if (r0 == 0) goto L_0x001e
            r0.close()     // Catch:{ IOException -> 0x001e }
        L_0x001e:
            r1.close()     // Catch:{ IOException -> 0x0021 }
        L_0x0021:
            return
        L_0x0022:
            r3 = 0
            r1.write(r5, r3, r2)     // Catch:{ all -> 0x0027 }
            goto L_0x0013
        L_0x0027:
            r5 = move-exception
            goto L_0x002b
        L_0x0029:
            r5 = move-exception
            r1 = r0
        L_0x002b:
            if (r0 == 0) goto L_0x0032
            r0.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0032
        L_0x0031:
        L_0x0032:
            if (r1 == 0) goto L_0x0037
            r1.close()     // Catch:{ IOException -> 0x0037 }
        L_0x0037:
            goto L_0x0039
        L_0x0038:
            throw r5
        L_0x0039:
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeBodyPart.saveFile(java.io.File):void");
    }

    public void saveFile(String str) throws IOException, MessagingException {
        saveFile(new File(str));
    }

    public void setContent(Object obj, String str) throws MessagingException {
        if (obj instanceof Multipart) {
            setContent((Multipart) obj);
        } else {
            setDataHandler(new DataHandler(obj, str));
        }
    }

    public void setContent(Multipart multipart) throws MessagingException {
        setDataHandler(new DataHandler(multipart, multipart.getContentType()));
        multipart.setParent(this);
    }

    public void setContentID(String str) throws MessagingException {
        if (str == null) {
            removeHeader("Content-ID");
        } else {
            setHeader("Content-ID", str);
        }
    }

    public void setContentLanguage(String[] strArr) throws MessagingException {
        setContentLanguage(this, strArr);
    }

    public void setContentMD5(String str) throws MessagingException {
        setHeader("Content-MD5", str);
    }

    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        this.f29475dh = dataHandler;
        this.cachedContent = null;
        invalidateContentHeaders(this);
    }

    public void setDescription(String str) throws MessagingException {
        setDescription(str, (String) null);
    }

    public void setDescription(String str, String str2) throws MessagingException {
        setDescription(this, str, str2);
    }

    public void setDisposition(String str) throws MessagingException {
        setDisposition(this, str);
    }

    public void setFileName(String str) throws MessagingException {
        setFileName(this, str);
    }

    public void setHeader(String str, String str2) throws MessagingException {
        this.headers.setHeader(str, str2);
    }

    public void setText(String str) throws MessagingException {
        setText(str, (String) null);
    }

    public void setText(String str, String str2) throws MessagingException {
        setText(this, str, str2, "plain");
    }

    public void setText(String str, String str2, String str3) throws MessagingException {
        setText(this, str, str2, str3);
    }

    /* access modifiers changed from: protected */
    public void updateHeaders() throws MessagingException {
        updateHeaders(this);
        Object obj = this.cachedContent;
        if (obj != null) {
            this.f29475dh = new DataHandler(obj, getContentType());
            this.cachedContent = null;
            this.content = null;
            InputStream inputStream = this.contentStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            this.contentStream = null;
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        writeTo(this, outputStream, (String[]) null);
    }
}
