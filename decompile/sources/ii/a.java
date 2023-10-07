package ii;

import ik.b;
import il.c;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.entity.AbstractHttpEntity;

public class a extends AbstractHttpEntity implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    protected byte[] f13557a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f13558b;

    /* renamed from: c  reason: collision with root package name */
    private String f13559c;

    /* renamed from: d  reason: collision with root package name */
    private List<NameValuePair> f13560d;

    public a() {
        this((String) null);
    }

    public a(String str) {
        this.f13558b = true;
        this.f13559c = "UTF-8";
        if (str != null) {
            this.f13559c = str;
        }
        setContentType("application/x-www-form-urlencoded");
        this.f13560d = new ArrayList();
    }

    public a(List<NameValuePair> list, String str) {
        this.f13558b = true;
        this.f13559c = "UTF-8";
        if (str != null) {
            this.f13559c = str;
        }
        setContentType("application/x-www-form-urlencoded");
        this.f13560d = list;
        a();
    }

    private void a() {
        if (this.f13558b) {
            try {
                this.f13557a = b.a((List<? extends NameValuePair>) this.f13560d, this.f13559c).getBytes(this.f13559c);
            } catch (UnsupportedEncodingException e2) {
                c.a(e2.getMessage(), e2);
            }
            this.f13558b = false;
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public InputStream getContent() throws IOException {
        a();
        return new ByteArrayInputStream(this.f13557a);
    }

    public long getContentLength() {
        a();
        return (long) this.f13557a.length;
    }

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            a();
            outputStream.write(this.f13557a);
            outputStream.flush();
            return;
        }
        throw new IllegalArgumentException("Output stream may not be null");
    }
}
