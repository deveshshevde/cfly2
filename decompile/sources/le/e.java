package le;

import com.xeagle.android.login.beans.ApkVersion;
import com.xeagle.android.login.beans.SplashBeans;
import com.xeagle.android.vjoystick.beans.PdfBean;
import ok.b;
import okhttp3.ac;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface e {
    @Streaming
    @GET
    b<ac> a(@Url String str);

    @Streaming
    @GET
    b<PdfBean> b(@Url String str);

    @GET
    b<ApkVersion> c(@Url String str);

    @GET
    b<SplashBeans> d(@Url String str);
}
