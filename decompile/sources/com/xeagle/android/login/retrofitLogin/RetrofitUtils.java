package com.xeagle.android.login.retrofitLogin;

import android.util.Log;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.u;
import okhttp3.z;
import okio.c;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    public static RetrofitUtils mInstance;
    private static final u sLoggingInterceptor = new u() {
        public ab intercept(u.a aVar) throws IOException {
            String str;
            z a2 = aVar.a();
            c cVar = new c();
            if (a2.d() != null) {
                a2.d().writeTo(cVar);
            } else {
                Log.d("Interceptor", "request.body() == null");
            }
            Log.e("ServeTest", "===request url====" + String.valueOf(a2.a()));
            StringBuilder sb = new StringBuilder();
            sb.append(a2.a());
            if (a2.d() != null) {
                str = "?" + RetrofitUtils._parseParams(a2.d(), cVar);
            } else {
                str = "";
            }
            sb.append(str);
            Log.e("ServeTest", sb.toString());
            return aVar.a(a2);
        }
    };
    private String baseUrl;
    private Retrofit.Builder builder = new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(SimpleHttpClient.getInstance().getOkHttpClient());

    /* renamed from: retrofit  reason: collision with root package name */
    private Retrofit f23805retrofit;

    private RetrofitUtils(String str) {
        this.baseUrl = str;
        Log.i("ServeTest", "RetrofitUtils:==== " + str);
    }

    /* access modifiers changed from: private */
    public static String _parseParams(aa aaVar, c cVar) throws UnsupportedEncodingException {
        return (aaVar.contentType() == null || aaVar.contentType().toString().contains("multipart")) ? "null" : URLDecoder.decode(cVar.p(), "UTF-8");
    }

    public static RetrofitUtils getInstance(String str) {
        if (mInstance == null) {
            synchronized (RetrofitUtils.class) {
                mInstance = new RetrofitUtils(str);
            }
        }
        mInstance.setBaseUrl(str);
        return mInstance;
    }

    private void setBaseUrl(String str) {
        Retrofit.Builder builder2 = this.builder;
        if (builder2 != null) {
            this.f23805retrofit = builder2.baseUrl(str).build();
        }
    }

    public <T> T create(Class<T> cls) {
        return this.f23805retrofit.create(cls);
    }
}
