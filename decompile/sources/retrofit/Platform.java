package retrofit;

import android.os.Build;
import android.os.Process;
import com.google.gson.Gson;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import retrofit.RestAdapter;
import retrofit.Utils;
import retrofit.android.AndroidApacheClient;
import retrofit.android.AndroidLog;
import retrofit.android.MainThreadExecutor;
import retrofit.appengine.UrlFetchClient;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.client.UrlConnectionClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

abstract class Platform {
    static final boolean HAS_RX_JAVA = hasRxJavaOnClasspath();
    private static final Platform PLATFORM = findPlatform();

    private static class Android extends Platform {
        private Android() {
        }

        /* access modifiers changed from: package-private */
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        /* access modifiers changed from: package-private */
        public Client.Provider defaultClient() {
            final Client instantiate = Platform.hasOkHttpOnClasspath() ? OkClientInstantiator.instantiate() : Build.VERSION.SDK_INT < 9 ? new AndroidApacheClient() : new UrlConnectionClient();
            return new Client.Provider() {
                public Client get() {
                    return instantiate;
                }
            };
        }

        /* access modifiers changed from: package-private */
        public Converter defaultConverter() {
            return new GsonConverter(new Gson());
        }

        /* access modifiers changed from: package-private */
        public Executor defaultHttpExecutor() {
            return Executors.newCachedThreadPool(new ThreadFactory() {
                public Thread newThread(final Runnable runnable) {
                    return new Thread(new Runnable() {
                        public void run() {
                            Process.setThreadPriority(10);
                            runnable.run();
                        }
                    }, "Retrofit-Idle");
                }
            });
        }

        /* access modifiers changed from: package-private */
        public RestAdapter.Log defaultLog() {
            return new AndroidLog("Retrofit");
        }
    }

    private static class AppEngine extends Base {
        private AppEngine() {
            super();
        }

        /* access modifiers changed from: package-private */
        public Client.Provider defaultClient() {
            final UrlFetchClient urlFetchClient = new UrlFetchClient();
            return new Client.Provider() {
                public Client get() {
                    return urlFetchClient;
                }
            };
        }
    }

    private static class Base extends Platform {
        private Base() {
        }

        /* access modifiers changed from: package-private */
        public Executor defaultCallbackExecutor() {
            return new Utils.SynchronousExecutor();
        }

        /* access modifiers changed from: package-private */
        public Client.Provider defaultClient() {
            final Client instantiate = Platform.hasOkHttpOnClasspath() ? OkClientInstantiator.instantiate() : new UrlConnectionClient();
            return new Client.Provider() {
                public Client get() {
                    return instantiate;
                }
            };
        }

        /* access modifiers changed from: package-private */
        public Converter defaultConverter() {
            return new GsonConverter(new Gson());
        }

        /* access modifiers changed from: package-private */
        public Executor defaultHttpExecutor() {
            return Executors.newCachedThreadPool(new ThreadFactory() {
                public Thread newThread(final Runnable runnable) {
                    return new Thread(new Runnable() {
                        public void run() {
                            Thread.currentThread().setPriority(1);
                            runnable.run();
                        }
                    }, "Retrofit-Idle");
                }
            });
        }

        /* access modifiers changed from: package-private */
        public RestAdapter.Log defaultLog() {
            return new RestAdapter.Log() {
                public void log(String str) {
                    System.out.println(str);
                }
            };
        }
    }

    private static class OkClientInstantiator {
        private OkClientInstantiator() {
        }

        static Client instantiate() {
            return new OkClient();
        }
    }

    Platform() {
    }

    private static Platform findPlatform() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new Android();
            }
        } catch (ClassNotFoundException unused) {
        }
        return System.getProperty("com.google.appengine.runtime.version") != null ? new AppEngine() : new Base();
    }

    static Platform get() {
        return PLATFORM;
    }

    /* access modifiers changed from: private */
    public static boolean hasOkHttpOnClasspath() {
        try {
            Class.forName("com.squareup.okhttp.OkHttpClient");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static boolean hasRxJavaOnClasspath() {
        try {
            Class.forName("ok.b");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract Executor defaultCallbackExecutor();

    /* access modifiers changed from: package-private */
    public abstract Client.Provider defaultClient();

    /* access modifiers changed from: package-private */
    public abstract Converter defaultConverter();

    /* access modifiers changed from: package-private */
    public abstract Executor defaultHttpExecutor();

    /* access modifiers changed from: package-private */
    public abstract RestAdapter.Log defaultLog();
}
