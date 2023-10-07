package com.xeagle.android.login.amba.connectivity;

import android.content.Context;
import android.util.Log;
import ch.a;
import com.flypro.core.util.e;
import com.xeagle.android.utils.c;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class CmdChannel {
    private static final int AMBA_BATTERY_LEVEL = 13;
    private static final int AMBA_BURN_FW = 8;
    private static final int AMBA_CANCLE_XFER = 1287;
    private static final int AMBA_CD = 1283;
    private static final int AMBA_DEL = 1281;
    private static final int AMBA_FORCE_SPLIT = 516;
    private static final int AMBA_FORMAT_SD = 4;
    private static final int AMBA_GET_ALL = 3;
    private static final int AMBA_GET_DEVINFO = 11;
    private static final int AMBA_GET_FILE = 1285;
    private static final int AMBA_GET_MEDIAINFO = 1026;
    private static final int AMBA_GET_NUM_FILES = 6;
    private static final int AMBA_GET_OPTIONS = 9;
    private static final int AMBA_GET_SETTING = 1;
    private static final int AMBA_GET_SPACE = 5;
    private static final int AMBA_GET_THUMB = 1025;
    private static final int AMBA_HEART_DATA = 2049;
    private static final int AMBA_LS = 1282;
    private static final int AMBA_NEW_DEVICE = 1793;
    private static final int AMBA_NOTIFICATION = 7;
    private static final int AMBA_POWER_MANAGE = 12;
    private static final int AMBA_PUT_FILE = 1286;
    private static final int AMBA_PWD = 1284;
    private static final int AMBA_RECORD_START = 513;
    private static final int AMBA_RECORD_STOP = 514;
    private static final int AMBA_RECORD_TIME = 515;
    private static final int AMBA_RESETVF = 259;
    private static final int AMBA_SET_ATTRIBUTE = 1027;
    private static final int AMBA_SET_BITRATE = 16;
    private static final int AMBA_SET_CLINT_INFO = 261;
    private static final int AMBA_SET_SETTING = 2;
    private static final int AMBA_START_SESSION = 257;
    private static final int AMBA_STOP_PHOTO = 770;
    private static final int AMBA_STOP_SESSION = 258;
    private static final int AMBA_STOP_VF = 260;
    private static final int AMBA_TAKE_PHOTO = 769;
    private static final int AMBA_ZOOM = 14;
    private static final int AMBA_ZOOM_INFO = 15;
    private static final int APP_NOT_READY = -22;
    private static final int CARD_PROTECTED = -18;
    private static final int ERROR_NETCTRL_NO_CARD = -30;
    private static final String[] ERR_CODE = {"OK", "UNKNOW(-1)", "INVALID_ERROR(-2)", "SESSION_START_FAIL(-3)", "INVALID_SESSION(-4)", "REACH_MAX_CLIENT(-5)", "INVALID_ERROR(-6)", "JSON_PACKAGE_ERROR(-7)", "JSON_PACKAGE_TIMEOUT(-8)", "JSON_SYNTAX_ERROR(-9)", "INVALID_ERROR(-10)", "INVALID_ERROR(-11)", "INVALID_ERROR(-12)", "INVALID_OPTION_VALUE(-13)", "INVALID_OPERATION(-14)", "INVALID_ERROR(-15)", "HDMI_INSERTED(-16)", "NO_MORE_SPACE(-17)", "CARD_PROTECTED(-18)", "NO_MORE_MEMORY(-19)", "PIV_NOT_ALLOWED(-20)", "SYSTEM_BUSY(-21)", "APP_NOT_READY(-22)", "OPERATION_UNSUPPORTED(-23)", "INVALID_TYPE(-24)", "INVALID_PARAM(-25)", "INVALID_PATH(-26)"};
    private static final int ERR_INVALID = -6;
    private static final int ERR_INVALID_TOKEN = -4;
    private static final int ERR_JSON_PACKAGE = -7;
    private static final int ERR_JSON_SYNTAX = -9;
    private static final int ERR_JSON_TIMEOUT = -8;
    private static final int ERR_MAX_NUM = 26;
    private static final int ERR_OPERATION = -14;
    private static final int ERR_OPTION_VALUE = -13;
    private static final int NEW_DEVICE_REQUEST = -32;
    private static final int NO_MORE_SPACE = -17;
    private static final int RX_TIMEOUT = 15000;
    private static final int START_SESSION_FAILED = -31;
    private static final int SYSTEM_BUSY = -21;
    private static final String TAG = "CmdChannel";
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static final Pattern f23792p = Pattern.compile("\\d+");
    private Context context;
    private boolean mAutoStartSession;
    private boolean mCheckSessionId;
    /* access modifiers changed from: private */
    public IChannelListener mListener;
    /* access modifiers changed from: private */
    public boolean mReplyReceived;
    /* access modifiers changed from: private */
    public final Object mRxLock = new Object();
    protected int mSessionId;

    class QueueRunnable implements Runnable {
        QueueRunnable() {
        }

        private void handleNotification(String str) {
            try {
                if (c.a(str, "}") == 1) {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.getInt("msg_id") == 7) {
                        String string = jSONObject.getString("type");
                        if (!string.equals("fw_upgrade_failed")) {
                            if (!string.equals("fw_upgrade_complete")) {
                                Log.e(CmdChannel.TAG, "unhandled notification " + string + "!!!");
                                CmdChannel.this.mListener.onChannelEvent(40, string, new String[0]);
                                return;
                            }
                        }
                        CmdChannel.this.mListener.onChannelEvent(4, string, new String[0]);
                    } else if (jSONObject.getInt("msg_id") == CmdChannel.AMBA_NEW_DEVICE) {
                        CmdChannel.this.mListener.onChannelEvent(54, (Object) null, new String[0]);
                    } else if (jSONObject.getInt("msg_id") == CmdChannel.AMBA_HEART_DATA) {
                        CmdChannel.this.mListener.onChannelEvent(56, jSONObject, new String[0]);
                    }
                } else {
                    String[] split = str.replace("}{", "}|{").split("\\|");
                    for (int i2 = 0; i2 < split.length; i2++) {
                        if (split[i2].contains("\"msg_id\":7")) {
                            Log.i("newUI", "handleNotification: ----" + split[i2]);
                            CmdChannel.this.mListener.onChannelEvent(40, new JSONObject(split[i2]).get("type"), new String[0]);
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:85:0x033d  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0349  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void handleResponse(java.lang.String r13) {
            /*
                r12 = this;
                java.lang.String r0 = "duration"
                java.lang.String r1 = "thumb_file"
                java.lang.String r2 = "type"
                java.lang.String r3 = "CmdChannel"
                r4 = 0
                org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x031a }
                r5.<init>(r13)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r6 = "rval"
                int r6 = r5.getInt(r6)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r7 = "msg_id"
                int r7 = r5.getInt(r7)     // Catch:{ JSONException -> 0x031a }
                r8 = -31
                r9 = 0
                if (r6 == r8) goto L_0x0308
                r8 = -4
                if (r6 == r8) goto L_0x02fa
                r8 = -18
                if (r6 == r8) goto L_0x02ec
                r8 = -17
                if (r6 == r8) goto L_0x02de
                r8 = 11
                r10 = 9
                if (r7 == r10) goto L_0x02d1
                if (r7 == r8) goto L_0x02c2
                r8 = 769(0x301, float:1.078E-42)
                if (r7 == r8) goto L_0x02b3
                r8 = 1281(0x501, float:1.795E-42)
                if (r7 == r8) goto L_0x02a5
                r8 = 1282(0x502, float:1.796E-42)
                if (r7 == r8) goto L_0x0297
                r8 = 1285(0x505, float:1.8E-42)
                java.lang.String r11 = "size"
                if (r7 == r8) goto L_0x026d
                r8 = 1286(0x506, float:1.802E-42)
                if (r7 == r8) goto L_0x025e
                java.lang.String r8 = "param"
                switch(r7) {
                    case 1: goto L_0x0227;
                    case 2: goto L_0x0218;
                    case 3: goto L_0x0209;
                    case 4: goto L_0x01fa;
                    case 5: goto L_0x01eb;
                    case 6: goto L_0x01d8;
                    default: goto L_0x004d;
                }
            L_0x004d:
                switch(r7) {
                    case 13: goto L_0x01b4;
                    case 14: goto L_0x01a1;
                    case 15: goto L_0x018e;
                    default: goto L_0x0050;
                }
            L_0x0050:
                switch(r7) {
                    case 257: goto L_0x0159;
                    case 258: goto L_0x0153;
                    case 259: goto L_0x0146;
                    case 260: goto L_0x0137;
                    default: goto L_0x0053;
                }
            L_0x0053:
                switch(r7) {
                    case 513: goto L_0x0128;
                    case 514: goto L_0x0119;
                    case 515: goto L_0x010a;
                    default: goto L_0x0056;
                }
            L_0x0056:
                switch(r7) {
                    case 1025: goto L_0x00fb;
                    case 1026: goto L_0x006e;
                    case 1027: goto L_0x005b;
                    default: goto L_0x0059;
                }
            L_0x0059:
                goto L_0x03b3
            L_0x005b:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 36
                java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ JSONException -> 0x031a }
                java.lang.String[] r5 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r2, r5)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x006e:
                boolean r2 = r5.has(r1)     // Catch:{ JSONException -> 0x031a }
                if (r2 != 0) goto L_0x0077
                java.lang.String r1 = ""
                goto L_0x008c
            L_0x0077:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x031a }
                r2.<init>()     // Catch:{ JSONException -> 0x031a }
                java.lang.String r6 = "thumb: "
                r2.append(r6)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r1 = r5.getString(r1)     // Catch:{ JSONException -> 0x031a }
                r2.append(r1)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r1 = r2.toString()     // Catch:{ JSONException -> 0x031a }
            L_0x008c:
                boolean r2 = r5.has(r0)     // Catch:{ JSONException -> 0x031a }
                if (r2 == 0) goto L_0x00aa
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x031a }
                r2.<init>()     // Catch:{ JSONException -> 0x031a }
                r2.append(r1)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r1 = "\nduration: "
                r2.append(r1)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r0 = r5.getString(r0)     // Catch:{ JSONException -> 0x031a }
                r2.append(r0)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r1 = r2.toString()     // Catch:{ JSONException -> 0x031a }
            L_0x00aa:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x031a }
                r0.<init>()     // Catch:{ JSONException -> 0x031a }
                r0.append(r1)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r1 = "\nresolution: "
                r0.append(r1)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r1 = "resolution"
                java.lang.String r1 = r5.getString(r1)     // Catch:{ JSONException -> 0x031a }
                r0.append(r1)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r1 = "\nsize: "
                r0.append(r1)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r1 = r5.getString(r11)     // Catch:{ JSONException -> 0x031a }
                r0.append(r1)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r1 = "\ndate: "
                r0.append(r1)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r1 = "date"
                java.lang.String r1 = r5.getString(r1)     // Catch:{ JSONException -> 0x031a }
                r0.append(r1)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r1 = "\ntype: "
                r0.append(r1)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r1 = "media_type"
                java.lang.String r1 = r5.getString(r1)     // Catch:{ JSONException -> 0x031a }
                r0.append(r1)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.CmdChannel r1 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r1 = r1.mListener     // Catch:{ JSONException -> 0x031a }
                r2 = 8
                java.lang.String[] r5 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r1.onChannelEvent(r2, r0, r5)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x00fb:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 37
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x010a:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 21
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x0119:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 53
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r9, r2)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x0128:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 52
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r9, r2)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x0137:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 22
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r9, r2)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x0146:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                java.lang.String[] r1 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r10, r9, r1)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x0153:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                r0.mSessionId = r4     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x0159:
                java.lang.String r0 = r5.getString(r8)     // Catch:{ JSONException -> 0x031a }
                java.util.regex.Pattern r1 = com.xeagle.android.login.amba.connectivity.CmdChannel.f23792p     // Catch:{ JSONException -> 0x031a }
                java.util.regex.Matcher r0 = r1.matcher(r0)     // Catch:{ JSONException -> 0x031a }
                boolean r1 = r0.find()     // Catch:{ JSONException -> 0x031a }
                if (r1 == 0) goto L_0x0177
                com.xeagle.android.login.amba.connectivity.CmdChannel r1 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                java.lang.String r0 = r0.group(r4)     // Catch:{ JSONException -> 0x031a }
                int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ JSONException -> 0x031a }
                r1.mSessionId = r0     // Catch:{ JSONException -> 0x031a }
            L_0x0177:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 23
                com.xeagle.android.login.amba.connectivity.CmdChannel r2 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                int r2 = r2.mSessionId     // Catch:{ JSONException -> 0x031a }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ JSONException -> 0x031a }
                java.lang.String[] r5 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r2, r5)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x018e:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 39
                java.lang.String r2 = r5.getString(r8)     // Catch:{ JSONException -> 0x031a }
                java.lang.String[] r5 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r2, r5)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x01a1:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 38
                java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ JSONException -> 0x031a }
                java.lang.String[] r5 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r2, r5)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x01b4:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 20
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x031a }
                r2.<init>()     // Catch:{ JSONException -> 0x031a }
                java.lang.String r6 = "Battery Level: "
                r2.append(r6)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r5 = r5.getString(r8)     // Catch:{ JSONException -> 0x031a }
                r2.append(r5)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x031a }
                java.lang.String[] r5 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r2, r5)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x01d8:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 16
                java.lang.String r2 = r5.getString(r8)     // Catch:{ JSONException -> 0x031a }
                java.lang.String[] r5 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r2, r5)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x01eb:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 15
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x01fa:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 18
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x0209:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 10
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r13, r2)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x0218:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 12
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x0227:
                java.lang.String r0 = r5.getString(r2)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r1 = "sw_version"
                boolean r0 = r0.equals(r1)     // Catch:{ JSONException -> 0x031a }
                if (r0 != 0) goto L_0x024f
                java.lang.String r0 = r5.getString(r2)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r1 = "hw_version"
                boolean r0 = r0.equals(r1)     // Catch:{ JSONException -> 0x031a }
                if (r0 == 0) goto L_0x0240
                goto L_0x024f
            L_0x0240:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 55
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x024f:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 51
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x025e:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 19
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r9, r2)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x026d:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x031a }
                r0.<init>()     // Catch:{ JSONException -> 0x031a }
                java.lang.String r1 = "handleResponse: ---file-----"
                r0.append(r1)     // Catch:{ JSONException -> 0x031a }
                r0.append(r5)     // Catch:{ JSONException -> 0x031a }
                java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x031a }
                android.util.Log.i(r3, r0)     // Catch:{ JSONException -> 0x031a }
                int r0 = r5.getInt(r11)     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.CmdChannel r1 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r1 = r1.mListener     // Catch:{ JSONException -> 0x031a }
                r2 = 7
                java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch:{ JSONException -> 0x031a }
                java.lang.String[] r5 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r1.onChannelEvent(r2, r0, r5)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x0297:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 5
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x02a5:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 6
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r9, r2)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x02b3:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 41
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x02c2:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 17
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x02d1:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                java.lang.String[] r1 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r8, r5, r1)     // Catch:{ JSONException -> 0x031a }
                goto L_0x03b3
            L_0x02de:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 135(0x87, float:1.89E-43)
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r9, r2)     // Catch:{ JSONException -> 0x031a }
                return
            L_0x02ec:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 136(0x88, float:1.9E-43)
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r9, r2)     // Catch:{ JSONException -> 0x031a }
                return
            L_0x02fa:
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 129(0x81, float:1.81E-43)
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r9, r2)     // Catch:{ JSONException -> 0x031a }
                return
            L_0x0308:
                r0 = 257(0x101, float:3.6E-43)
                if (r7 != r0) goto L_0x0319
                com.xeagle.android.login.amba.connectivity.CmdChannel r0 = com.xeagle.android.login.amba.connectivity.CmdChannel.this     // Catch:{ JSONException -> 0x031a }
                com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r0.mListener     // Catch:{ JSONException -> 0x031a }
                r1 = 137(0x89, float:1.92E-43)
                java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x031a }
                r0.onChannelEvent(r1, r9, r2)     // Catch:{ JSONException -> 0x031a }
            L_0x0319:
                return
            L_0x031a:
                r0 = move-exception
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "JSON Error: "
                r1.append(r2)
                java.lang.String r0 = r0.getMessage()
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                android.util.Log.e(r3, r0)
                java.lang.String r0 = "stop_record"
                boolean r1 = r13.contains(r0)
                r2 = 40
                if (r1 == 0) goto L_0x0349
                com.xeagle.android.login.amba.connectivity.CmdChannel r13 = com.xeagle.android.login.amba.connectivity.CmdChannel.this
                com.xeagle.android.login.amba.connectivity.IChannelListener r13 = r13.mListener
                java.lang.String[] r1 = new java.lang.String[r4]
                r13.onChannelEvent(r2, r0, r1)
                goto L_0x03b3
            L_0x0349:
                java.lang.String r0 = "remote_video_key_stop"
                boolean r1 = r13.contains(r0)
                if (r1 == 0) goto L_0x035d
                com.xeagle.android.login.amba.connectivity.CmdChannel r13 = com.xeagle.android.login.amba.connectivity.CmdChannel.this
                com.xeagle.android.login.amba.connectivity.IChannelListener r13 = r13.mListener
                java.lang.String[] r1 = new java.lang.String[r4]
                r13.onChannelEvent(r2, r0, r1)
                goto L_0x03b3
            L_0x035d:
                java.lang.String r0 = "stop_normal_record"
                boolean r1 = r13.contains(r0)
                if (r1 == 0) goto L_0x0371
                com.xeagle.android.login.amba.connectivity.CmdChannel r13 = com.xeagle.android.login.amba.connectivity.CmdChannel.this
                com.xeagle.android.login.amba.connectivity.IChannelListener r13 = r13.mListener
                java.lang.String[] r1 = new java.lang.String[r4]
                r13.onChannelEvent(r2, r0, r1)
                goto L_0x03b3
            L_0x0371:
                java.lang.String r0 = "start_normal_record"
                boolean r1 = r13.contains(r0)
                if (r1 == 0) goto L_0x0385
                com.xeagle.android.login.amba.connectivity.CmdChannel r13 = com.xeagle.android.login.amba.connectivity.CmdChannel.this
                com.xeagle.android.login.amba.connectivity.IChannelListener r13 = r13.mListener
                java.lang.String[] r1 = new java.lang.String[r4]
                r13.onChannelEvent(r2, r0, r1)
                goto L_0x03b3
            L_0x0385:
                java.lang.String r0 = "start_record"
                boolean r1 = r13.contains(r0)
                if (r1 == 0) goto L_0x03a0
                java.lang.String r13 = "newUI"
                java.lang.String r1 = "handleResponse: ----start record"
                android.util.Log.e(r13, r1)
                com.xeagle.android.login.amba.connectivity.CmdChannel r13 = com.xeagle.android.login.amba.connectivity.CmdChannel.this
                com.xeagle.android.login.amba.connectivity.IChannelListener r13 = r13.mListener
                java.lang.String[] r1 = new java.lang.String[r4]
                r13.onChannelEvent(r2, r0, r1)
                goto L_0x03b3
            L_0x03a0:
                java.lang.String r0 = "remote_video_key_start"
                boolean r13 = r13.contains(r0)
                if (r13 == 0) goto L_0x03b3
                com.xeagle.android.login.amba.connectivity.CmdChannel r13 = com.xeagle.android.login.amba.connectivity.CmdChannel.this
                com.xeagle.android.login.amba.connectivity.IChannelListener r13 = r13.mListener
                java.lang.String[] r1 = new java.lang.String[r4]
                r13.onChannelEvent(r2, r0, r1)
            L_0x03b3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.amba.connectivity.CmdChannel.QueueRunnable.handleResponse(java.lang.String):void");
        }

        public void run() {
            while (true) {
                try {
                    String readFromChannel = CmdChannel.this.readFromChannel();
                    if (readFromChannel != null) {
                        while (true) {
                            try {
                                new JSONObject(readFromChannel);
                                break;
                            } catch (JSONException unused) {
                                Log.i(CmdChannel.TAG, "JSON segment: " + readFromChannel);
                                readFromChannel = readFromChannel + CmdChannel.this.readFromChannel();
                            }
                        }
                        Log.e(CmdChannel.TAG, readFromChannel);
                        if (readFromChannel.contains("rval")) {
                            handleResponse(readFromChannel);
                            boolean unused2 = CmdChannel.this.mReplyReceived = true;
                            synchronized (CmdChannel.this.mRxLock) {
                                CmdChannel.this.mRxLock.notify();
                            }
                        } else {
                            boolean unused3 = CmdChannel.this.mReplyReceived = true;
                            synchronized (CmdChannel.this.mRxLock) {
                                CmdChannel.this.mRxLock.notify();
                            }
                            handleNotification(readFromChannel);
                        }
                    } else {
                        return;
                    }
                } catch (Exception e2) {
                    Log.e(CmdChannel.TAG, e2.getMessage());
                    return;
                }
            }
            while (true) {
            }
        }
    }

    public CmdChannel(Context context2, IChannelListener iChannelListener) {
        this.mListener = iChannelListener;
        this.context = context2;
        this.mCheckSessionId = false;
        this.mAutoStartSession = true;
    }

    public CmdChannel(IChannelListener iChannelListener) {
        this.mListener = iChannelListener;
        this.mCheckSessionId = false;
        this.mAutoStartSession = true;
    }

    private void addLog(String str) {
        IChannelListener iChannelListener = this.mListener;
        if (iChannelListener != null) {
            iChannelListener.onChannelEvent(3, str, new String[0]);
        }
    }

    private boolean waitForReply(String str) {
        try {
            synchronized (this.mRxLock) {
                this.mRxLock.wait(15000);
            }
            if (this.mReplyReceived) {
                return true;
            }
            this.mListener.onChannelEvent(128, str, new String[0]);
            return false;
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public synchronized boolean burnFW(String str) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 8 + ",\"param\":\"" + str + "\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean cancelGetFile(String str) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + AMBA_CANCLE_XFER + ",\"param\":\"" + str + "\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean cancelPutFile(String str, int i2) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + AMBA_CANCLE_XFER + ",\"param\":\"" + str + "\",\"sent_size\":" + i2 + "}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public boolean checkSessionID() {
        if (this.mCheckSessionId && this.mSessionId <= 0) {
            if (!this.mAutoStartSession) {
                this.mListener.onChannelEvent(IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN, (Object) null, new String[0]);
                return false;
            }
            startSession();
        }
        return true;
    }

    public synchronized boolean deleteFile(String str, int i2) {
        boolean z2;
        z2 = false;
        this.mListener.onChannelEvent(50, Integer.valueOf(i2), new String[0]);
        this.mListener.onChannelEvent(49, str, new String[0]);
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + AMBA_DEL + ",\"param\":\"" + str + "\"}")) {
                z2 = true;
            }
        }
        return z2;
    }

    public synchronized boolean forceSplit() {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 516 + "}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean formatSD(String str) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 4 + ",\"param\":\"" + str + "\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean fusedNewDevice() {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"msg_id\":1793,\"rval\":0,\"token\":" + this.mSessionId + "}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean getAllSettings() {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 3 + "}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean getBatteryLevel() {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 13 + "}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean getDevInfo() {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 11 + "}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean getFile(String str) {
        boolean z2;
        z2 = false;
        this.mListener.onChannelEvent(48, str, new String[0]);
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + AMBA_GET_FILE + ",\"param\":\"" + str + "\",\"offset\":0,\"fetch_size\":0}")) {
                z2 = true;
            }
        }
        return z2;
    }

    public String getHeartStr() {
        return "{\"token\":" + this.mSessionId + ",\"msg_id\":" + 6666 + "}";
    }

    public synchronized boolean getInfo(String str) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 1026 + ",\"param\":\"" + str + "\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean getNumFiles(String str) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 6 + ",\"type\":\"" + str + "\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean getRecordTime() {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 515 + "}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0034, code lost:
        if (sendRequest("{\"token\":" + r3.mSessionId + ",\"msg_id\":" + 1 + ",\"type\":\"" + r4 + "\"}") != false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean getSecStream_bit(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.checkSessionID()     // Catch:{ all -> 0x003a }
            r1 = 1
            if (r0 == 0) goto L_0x0037
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
            r0.<init>()     // Catch:{ all -> 0x003a }
            java.lang.String r2 = "{\"token\":"
            r0.append(r2)     // Catch:{ all -> 0x003a }
            int r2 = r3.mSessionId     // Catch:{ all -> 0x003a }
            r0.append(r2)     // Catch:{ all -> 0x003a }
            java.lang.String r2 = ",\"msg_id\":"
            r0.append(r2)     // Catch:{ all -> 0x003a }
            r0.append(r1)     // Catch:{ all -> 0x003a }
            java.lang.String r2 = ",\"type\":\""
            r0.append(r2)     // Catch:{ all -> 0x003a }
            r0.append(r4)     // Catch:{ all -> 0x003a }
            java.lang.String r4 = "\"}"
            r0.append(r4)     // Catch:{ all -> 0x003a }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x003a }
            boolean r4 = r3.sendRequest(r4)     // Catch:{ all -> 0x003a }
            if (r4 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            monitor-exit(r3)
            return r1
        L_0x003a:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.amba.connectivity.CmdChannel.getSecStream_bit(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0034, code lost:
        if (sendRequest("{\"token\":" + r3.mSessionId + ",\"msg_id\":" + 1 + ",\"type\":\"" + r4 + "\"}") != false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean getSetting(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.checkSessionID()     // Catch:{ all -> 0x003a }
            r1 = 1
            if (r0 == 0) goto L_0x0037
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
            r0.<init>()     // Catch:{ all -> 0x003a }
            java.lang.String r2 = "{\"token\":"
            r0.append(r2)     // Catch:{ all -> 0x003a }
            int r2 = r3.mSessionId     // Catch:{ all -> 0x003a }
            r0.append(r2)     // Catch:{ all -> 0x003a }
            java.lang.String r2 = ",\"msg_id\":"
            r0.append(r2)     // Catch:{ all -> 0x003a }
            r0.append(r1)     // Catch:{ all -> 0x003a }
            java.lang.String r2 = ",\"type\":\""
            r0.append(r2)     // Catch:{ all -> 0x003a }
            r0.append(r4)     // Catch:{ all -> 0x003a }
            java.lang.String r4 = "\"}"
            r0.append(r4)     // Catch:{ all -> 0x003a }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x003a }
            boolean r4 = r3.sendRequest(r4)     // Catch:{ all -> 0x003a }
            if (r4 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            monitor-exit(r3)
            return r1
        L_0x003a:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.amba.connectivity.CmdChannel.getSetting(java.lang.String):boolean");
    }

    public synchronized boolean getSettingOptions(String str) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 9 + ",\"param\":\"" + str + "\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean getSpace(String str) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 5 + ",\"type\":\"" + str + "\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean getThumb(String str, String str2) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 1025 + ",\"param\":\"" + str + "\",\"type\":\"" + str2 + "\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0034, code lost:
        if (sendRequest("{\"token\":" + r3.mSessionId + ",\"msg_id\":" + 1 + ",\"type\":\"" + r4 + "\"}") != false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean getVersion(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.checkSessionID()     // Catch:{ all -> 0x003a }
            r1 = 1
            if (r0 == 0) goto L_0x0037
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
            r0.<init>()     // Catch:{ all -> 0x003a }
            java.lang.String r2 = "{\"token\":"
            r0.append(r2)     // Catch:{ all -> 0x003a }
            int r2 = r3.mSessionId     // Catch:{ all -> 0x003a }
            r0.append(r2)     // Catch:{ all -> 0x003a }
            java.lang.String r2 = ",\"msg_id\":"
            r0.append(r2)     // Catch:{ all -> 0x003a }
            r0.append(r1)     // Catch:{ all -> 0x003a }
            java.lang.String r2 = ",\"type\":\""
            r0.append(r2)     // Catch:{ all -> 0x003a }
            r0.append(r4)     // Catch:{ all -> 0x003a }
            java.lang.String r4 = "\"}"
            r0.append(r4)     // Catch:{ all -> 0x003a }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x003a }
            boolean r4 = r3.sendRequest(r4)     // Catch:{ all -> 0x003a }
            if (r4 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            monitor-exit(r3)
            return r1
        L_0x003a:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.amba.connectivity.CmdChannel.getVersion(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0034, code lost:
        if (sendRequest("{\"token\":" + r3.mSessionId + ",\"msg_id\":" + 1 + ",\"type\":\"" + r4 + "\"}") != false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean getWifi_ChanBW(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.checkSessionID()     // Catch:{ all -> 0x003a }
            r1 = 1
            if (r0 == 0) goto L_0x0037
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
            r0.<init>()     // Catch:{ all -> 0x003a }
            java.lang.String r2 = "{\"token\":"
            r0.append(r2)     // Catch:{ all -> 0x003a }
            int r2 = r3.mSessionId     // Catch:{ all -> 0x003a }
            r0.append(r2)     // Catch:{ all -> 0x003a }
            java.lang.String r2 = ",\"msg_id\":"
            r0.append(r2)     // Catch:{ all -> 0x003a }
            r0.append(r1)     // Catch:{ all -> 0x003a }
            java.lang.String r2 = ",\"type\":\""
            r0.append(r2)     // Catch:{ all -> 0x003a }
            r0.append(r4)     // Catch:{ all -> 0x003a }
            java.lang.String r4 = "\"}"
            r0.append(r4)     // Catch:{ all -> 0x003a }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x003a }
            boolean r4 = r3.sendRequest(r4)     // Catch:{ all -> 0x003a }
            if (r4 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            monitor-exit(r3)
            return r1
        L_0x003a:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.amba.connectivity.CmdChannel.getWifi_ChanBW(java.lang.String):boolean");
    }

    public synchronized boolean getZoomInfo(String str) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 15 + ",\"type\":\"" + str + "\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean listDir(String str) {
        if (!checkSessionID()) {
            return false;
        }
        this.mListener.onChannelEvent(33, str, new String[0]);
        return sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + AMBA_LS + ",\"param\":\"" + str + " -D -S\"}");
    }

    public synchronized boolean putFile(String str, String str2, long j2) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + AMBA_PUT_FILE + ",\"param\":\"" + str + "\",\"size\":" + j2 + ",\"md5sum\":\"" + str2 + "\",\"offset\":0}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    /* access modifiers changed from: protected */
    public abstract String readFromChannel();

    public void reset() {
        this.mSessionId = 0;
    }

    public synchronized boolean resetViewfinder() {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + AMBA_RESETVF + ",\"param\":\"none_force\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public String sendChanBw(String str, String str2) {
        return "cfly_msg chanbw\t" + str + "\t" + this.mSessionId + "\t" + str2;
    }

    public boolean sendRequest(String str) {
        Log.e(TAG, str);
        this.mReplyReceived = false;
        writeToChannel(str.getBytes());
        return waitForReply(str);
    }

    public synchronized boolean setBitRate(int i2) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 16 + ",\"param\":\"" + i2 + "\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean setClntInfo(String str, String str2) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + AMBA_SET_CLINT_INFO + ",\"type\":\"" + str + "\",\"param\":\"" + str2 + "\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean setCommonSetting(String str, int i2) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 2 + ",\"type\":\"" + str + "\",\"param\":\"" + i2 + "\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean setMediaAttribute(String str, int i2) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 1027 + ",\"type\":" + i2 + ",\"param\":\"" + str + "\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean setSecStream_bit(String str, String str2) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 2 + ",\"type\":\"" + str + "\",\"param\":\"" + str2 + "\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean setSetting(String str) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 2 + "," + str + "}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean setWifiSsid(String str) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 2 + ",\"param\":\"Drone-" + str + "\",\"type\":\"wifi_ssid\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean setWifi_ChanBW(String str, String str2) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 2 + ",\"type\":\"" + str + "\",\"param\":\"" + str2 + "\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean setZoom(String str, int i2) {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 14 + ",\"type\":\"" + str + "\",\"param\":\"" + i2 + "\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean standBy() {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 12 + ",\"param\":\"cam_stb\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public void startIO() {
        new Thread(new QueueRunnable()).start();
    }

    public synchronized boolean startRecord() {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 513 + "}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean startSession() {
        e eVar = new e(this.context.getApplicationContext());
        Log.i(TAG, "startSession: ---ip---" + eVar.g() + "---mac---" + a.a());
        if (!eVar.g().contains("172.50.10") && !eVar.g().contains("192.168.10")) {
            return false;
        }
        return sendRequest("{\"token\":0,\"msg_id\":257,\"ip\":\"" + eVar.g() + "\",\"mac\":\"" + a.a() + "\"}");
    }

    public synchronized boolean stopPhoto() {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + AMBA_STOP_PHOTO + "}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean stopRecord() {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 514 + "}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean stopSession() {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + AMBA_STOP_SESSION + "}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean stopViewfinder() {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + AMBA_STOP_VF + "}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean takePhoto() {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + AMBA_TAKE_PHOTO + "}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    public synchronized boolean upgradeFirmware() {
        boolean z2;
        if (checkSessionID()) {
            if (sendRequest("{\"token\":" + this.mSessionId + ",\"msg_id\":" + 8 + "\"}")) {
                z2 = true;
            }
        }
        z2 = false;
        return z2;
    }

    /* access modifiers changed from: protected */
    public abstract void writeToChannel(byte[] bArr);
}
