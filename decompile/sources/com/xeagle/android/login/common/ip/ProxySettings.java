package com.xeagle.android.login.common.ip;

import android.net.ProxyInfo;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import java.lang.reflect.Method;
import java.util.List;

public class ProxySettings {

    /* renamed from: com.xeagle.android.login.common.ip.ProxySettings$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xeagle$android$login$common$ip$ProxySettings$PROXY_TYPE;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.xeagle.android.login.common.ip.ProxySettings$PROXY_TYPE[] r0 = com.xeagle.android.login.common.ip.ProxySettings.PROXY_TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$xeagle$android$login$common$ip$ProxySettings$PROXY_TYPE = r0
                com.xeagle.android.login.common.ip.ProxySettings$PROXY_TYPE r1 = com.xeagle.android.login.common.ip.ProxySettings.PROXY_TYPE.MANUAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$xeagle$android$login$common$ip$ProxySettings$PROXY_TYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xeagle.android.login.common.ip.ProxySettings$PROXY_TYPE r1 = com.xeagle.android.login.common.ip.ProxySettings.PROXY_TYPE.PAC_URL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.ip.ProxySettings.AnonymousClass1.<clinit>():void");
        }
    }

    private enum PROXY_TYPE {
        MANUAL,
        PAC_URL
    }

    public static WifiConfiguration setManualProxy(WifiConfiguration wifiConfiguration, String str, int i2, List<String> list) {
        return setProxy(wifiConfiguration, str, i2, list, PROXY_TYPE.MANUAL);
    }

    public static WifiConfiguration setPacURL(WifiConfiguration wifiConfiguration, String str) {
        return setProxy(wifiConfiguration, str, 0, (List<String>) null, PROXY_TYPE.PAC_URL);
    }

    private static WifiConfiguration setProxy(WifiConfiguration wifiConfiguration, String str, int i2, List<String> list, PROXY_TYPE proxy_type) {
        String str2;
        ProxyInfo proxyInfo;
        String str3;
        try {
            Class[] clsArr = {Class.forName("android.net.ProxyInfo")};
            Class<?> cls = Class.forName("android.net.wifi.WifiConfiguration");
            Method declaredMethod = cls.getDeclaredMethod("setHttpProxy", clsArr);
            declaredMethod.setAccessible(true);
            Class<?> type = Class.forName("android.net.IpConfiguration").getField("proxySettings").getType();
            Method declaredMethod2 = cls.getDeclaredMethod("setProxySettings", new Class[]{type});
            declaredMethod2.setAccessible(true);
            int i3 = AnonymousClass1.$SwitchMap$com$xeagle$android$login$common$ip$ProxySettings$PROXY_TYPE[proxy_type.ordinal()];
            ProxyInfo proxyInfo2 = null;
            if (i3 == 1) {
                str3 = "STATIC";
                proxyInfo = ProxyInfo.buildDirectProxy(str, i2, list);
            } else if (i3 != 2) {
                str2 = null;
                declaredMethod.invoke(wifiConfiguration, new Object[]{proxyInfo2});
                declaredMethod2.invoke(wifiConfiguration, new Object[]{Enum.valueOf(type, str2)});
                return wifiConfiguration;
            } else {
                str3 = "PAC";
                proxyInfo = ProxyInfo.buildPacProxy(Uri.parse(str));
            }
            String str4 = str3;
            proxyInfo2 = proxyInfo;
            str2 = str4;
            declaredMethod.invoke(wifiConfiguration, new Object[]{proxyInfo2});
            declaredMethod2.invoke(wifiConfiguration, new Object[]{Enum.valueOf(type, str2)});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return wifiConfiguration;
    }
}
