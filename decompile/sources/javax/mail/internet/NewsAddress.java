package javax.mail.internet;

import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.Address;

public class NewsAddress extends Address {
    private static final long serialVersionUID = -4203797299824684143L;
    protected String host;
    protected String newsgroup;

    public NewsAddress() {
    }

    public NewsAddress(String str) {
        this(str, (String) null);
    }

    public NewsAddress(String str, String str2) {
        this.newsgroup = str;
        this.host = str2;
    }

    public static NewsAddress[] parse(String str) throws AddressException {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        Vector vector = new Vector();
        while (stringTokenizer.hasMoreTokens()) {
            vector.addElement(new NewsAddress(stringTokenizer.nextToken()));
        }
        int size = vector.size();
        NewsAddress[] newsAddressArr = new NewsAddress[size];
        if (size > 0) {
            vector.copyInto(newsAddressArr);
        }
        return newsAddressArr;
    }

    public static String toString(Address[] addressArr) {
        if (addressArr == null || addressArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(addressArr[0].toString());
        for (int i2 = 1; i2 < addressArr.length; i2++) {
            stringBuffer.append(",");
            stringBuffer.append(addressArr[i2].toString());
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        r4 = r4.host;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof javax.mail.internet.NewsAddress
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            javax.mail.internet.NewsAddress r4 = (javax.mail.internet.NewsAddress) r4
            java.lang.String r0 = r3.newsgroup
            java.lang.String r2 = r4.newsgroup
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = r3.host
            if (r0 != 0) goto L_0x001a
            java.lang.String r2 = r4.host
            if (r2 == 0) goto L_0x0026
        L_0x001a:
            if (r0 == 0) goto L_0x0028
            java.lang.String r4 = r4.host
            if (r4 == 0) goto L_0x0028
            boolean r4 = r0.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0028
        L_0x0026:
            r4 = 1
            return r4
        L_0x0028:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.NewsAddress.equals(java.lang.Object):boolean");
    }

    public String getHost() {
        return this.host;
    }

    public String getNewsgroup() {
        return this.newsgroup;
    }

    public String getType() {
        return "news";
    }

    public int hashCode() {
        String str = this.newsgroup;
        int i2 = 0;
        if (str != null) {
            i2 = 0 + str.hashCode();
        }
        String str2 = this.host;
        return str2 != null ? i2 + str2.toLowerCase(Locale.ENGLISH).hashCode() : i2;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setNewsgroup(String str) {
        this.newsgroup = str;
    }

    public String toString() {
        return this.newsgroup;
    }
}
