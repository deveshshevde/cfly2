package com.sun.mail.dsn;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataContentHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeUtility;
import myjava.awt.datatransfer.DataFlavor;

public class text_rfc822headers implements DataContentHandler {
    private static ActivationDataFlavor myDF = new ActivationDataFlavor(MessageHeaders.class, "text/rfc822-headers", "RFC822 headers");
    private static ActivationDataFlavor myDFs = new ActivationDataFlavor(String.class, "text/rfc822-headers", "RFC822 headers");

    private String getCharset(String str) {
        try {
            String parameter = new ContentType(str).getParameter("charset");
            if (parameter == null) {
                parameter = "us-ascii";
            }
            return MimeUtility.javaCharset(parameter);
        } catch (Exception unused) {
            return null;
        }
    }

    private Object getStringContent(DataSource dataSource) throws IOException {
        String str = null;
        try {
            str = getCharset(dataSource.getContentType());
            InputStreamReader inputStreamReader = new InputStreamReader(dataSource.getInputStream(), str);
            char[] cArr = new char[1024];
            int i2 = 0;
            while (true) {
                int read = inputStreamReader.read(cArr, i2, cArr.length - i2);
                if (read == -1) {
                    return new String(cArr, 0, i2);
                }
                i2 += read;
                if (i2 >= cArr.length) {
                    int length = cArr.length;
                    char[] cArr2 = new char[(length < 262144 ? length + length : length + 262144)];
                    System.arraycopy(cArr, 0, cArr2, 0, i2);
                    cArr = cArr2;
                }
            }
        } catch (IllegalArgumentException unused) {
            throw new UnsupportedEncodingException(str);
        }
    }

    public Object getContent(DataSource dataSource) throws IOException {
        try {
            return new MessageHeaders(dataSource.getInputStream());
        } catch (MessagingException e2) {
            throw new IOException("Exception creating MessageHeaders: " + e2);
        }
    }

    public Object getTransferData(DataFlavor dataFlavor, DataSource dataSource) throws IOException {
        if (myDF.equals(dataFlavor)) {
            return getContent(dataSource);
        }
        if (myDFs.equals(dataFlavor)) {
            return getStringContent(dataSource);
        }
        return null;
    }

    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{myDF, myDFs};
    }

    public void writeTo(Object obj, String str, OutputStream outputStream) throws IOException {
        if (obj instanceof MessageHeaders) {
            try {
                ((MessageHeaders) obj).writeTo(outputStream);
            } catch (MessagingException e2) {
                Exception nextException = e2.getNextException();
                if (nextException instanceof IOException) {
                    throw ((IOException) nextException);
                }
                throw new IOException("Exception writing headers: " + e2);
            }
        } else if (obj instanceof String) {
            String str2 = null;
            try {
                str2 = getCharset(str);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, str2);
                String str3 = (String) obj;
                outputStreamWriter.write(str3, 0, str3.length());
                outputStreamWriter.flush();
            } catch (IllegalArgumentException unused) {
                throw new UnsupportedEncodingException(str2);
            }
        } else {
            throw new IOException("\"" + myDFs.getMimeType() + "\" DataContentHandler requires String object, " + "was given object of type " + obj.getClass().toString());
        }
    }
}
