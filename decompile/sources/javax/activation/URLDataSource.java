package javax.activation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLDataSource implements DataSource {
    private URL url = null;
    private URLConnection url_conn = null;

    public URLDataSource(URL url2) {
        this.url = url2;
    }

    public String getContentType() {
        try {
            if (this.url_conn == null) {
                this.url_conn = this.url.openConnection();
            }
        } catch (IOException unused) {
        }
        URLConnection uRLConnection = this.url_conn;
        String contentType = uRLConnection != null ? uRLConnection.getContentType() : null;
        return contentType == null ? "application/octet-stream" : contentType;
    }

    public InputStream getInputStream() throws IOException {
        return this.url.openStream();
    }

    public String getName() {
        return this.url.getFile();
    }

    public OutputStream getOutputStream() throws IOException {
        URLConnection openConnection = this.url.openConnection();
        this.url_conn = openConnection;
        if (openConnection == null) {
            return null;
        }
        openConnection.setDoOutput(true);
        return this.url_conn.getOutputStream();
    }

    public URL getURL() {
        return this.url;
    }
}
