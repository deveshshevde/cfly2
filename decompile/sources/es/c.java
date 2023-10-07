package es;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static DefaultHttpClient f26965a = a();

    public static String a(File file, String str, String str2, String str3, String str4, String str5) throws IOException {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("api_key", str4));
        linkedList.add(new BasicNameValuePair("login", str));
        linkedList.add(new BasicNameValuePair("password", str2));
        linkedList.add(new BasicNameValuePair("privacy", str5));
        linkedList.add(new BasicNameValuePair("autoCreate", "true"));
        String format = String.format("%s/api/v1/mission/upload/%s?%s", new Object[]{"https://api.3drobotics.com", str3, URLEncodedUtils.format(linkedList, "utf-8")});
        try {
            PrintStream printStream = System.out;
            printStream.println("Starting upload to " + "https://api.3drobotics.com");
            HttpPost httpPost = new HttpPost(format);
            httpPost.setEntity(new FileEntity(file, "application/vnd.mavlink.tlog"));
            httpPost.setHeader("Accept", "application/json");
            String str6 = (String) f26965a.execute(httpPost, new BasicResponseHandler());
            PrintStream printStream2 = System.out;
            printStream2.println("Received JSON response: " + str6);
            JSONArray jSONArray = new JSONArray(str6);
            if (jSONArray.length() == 1) {
                String string = jSONArray.getJSONObject(0).getString("viewURL");
                PrintStream printStream3 = System.out;
                printStream3.println("View URL is " + string);
                return string;
            }
            throw new IOException("The server rejected this log file");
        } catch (HttpResponseException e2) {
            if (e2.getStatusCode() == 406) {
                return null;
            }
            throw e2;
        } catch (JSONException e3) {
            throw new IOException("Malformed server response: " + e3.getMessage());
        }
    }

    private static DefaultHttpClient a() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }
}
