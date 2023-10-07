package com.huawei.android.multiscreen.dlna.sdk.jni;

public class DlnaUniswitch {

    /* renamed from: k  reason: collision with root package name */
    protected static final DlnaUniswitch f20868k = new DlnaUniswitch();

    /* renamed from: a  reason: collision with root package name */
    public int f20869a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f20870b = "00:00:00";

    /* renamed from: c  reason: collision with root package name */
    public String f20871c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f20872d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f20873e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f20874f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f20875g = "00:00:00";

    /* renamed from: h  reason: collision with root package name */
    public String f20876h = "00:00:00";

    /* renamed from: i  reason: collision with root package name */
    public int f20877i = -1;

    /* renamed from: j  reason: collision with root package name */
    public int f20878j = -1;

    static {
        System.loadLibrary("avutil");
        System.loadLibrary("avcodec");
        System.loadLibrary("avformat");
        System.loadLibrary("sqlite3");
        System.loadLibrary("ixml");
        System.loadLibrary("threadutil");
        System.loadLibrary("upnp");
        System.loadLibrary("vppdlna");
        System.loadLibrary("dlnajni");
    }

    protected DlnaUniswitch() {
    }

    public static DlnaUniswitch a() {
        return f20868k;
    }

    public native DlnaBrowseRecordResultInfo DlnaApiDmcBrowseRecordSchedules(int i2, String str, int i3, int i4, String str2);

    public native String DlnaApiDmcCreateRecordSchedule(int i2, int i3, Object obj);

    public native int DlnaApiDmcDeleteRecordSchedule(int i2, int i3, Object obj);

    public native int DlnaApiDmcDisableRecordSchedule(int i2, String str);

    public native int DlnaApiDmcEnableRecordSchedule(int i2, String str);

    public native DlnaDiskSpace DlnaApiDmcGetDiskSpace(int i2);

    public native DlnaSRCapabilities DlnaApiDmcGetRecordScheduleCapabilities(int i2);

    public native int dlnaApiDMCSendPlay(int i2, int i3, String str);

    public native int dlnaApiDMCSendSetTransportUri(int i2, int i3, String str, String str2);

    public native int dlnaApiDMCSendStop(int i2, int i3);

    public native DLNACreateObjectInfo dlnaApiDmcCreateObject(int i2, String str, String str2);

    public native int dlnaApiDmcDestroyObject(int i2, String str);

    public native DLNAImportExportResourceInfo dlnaApiDmcExportResource(int i2, String str, String str2);

    public native String dlnaApiDmcGetFeatureList(int i2);

    public native DLNAHuaweiIdInfo dlnaApiDmcGetHuaweiId(int i2, int i3);

    public native DLNAMuteInfo dlnaApiDmcGetMute(int i2, int i3, int i4);

    public native DLNAPositionInfo dlnaApiDmcGetPositionInfo(int i2, int i3);

    public native DLNAProtocolInfo dlnaApiDmcGetProtocolInfo(int i2, int i3);

    public native DLNATransferProgressInfo dlnaApiDmcGetTransferProgress(int i2, int i3);

    public native DLNATransportInfo dlnaApiDmcGetTransportInfo(int i2, int i3);

    public native DLNAVolumeInfo dlnaApiDmcGetVolume(int i2, int i3, int i4);

    public native DLNAImportExportResourceInfo dlnaApiDmcImportResource(int i2, String str, String str2);

    public native DLNAMoveObjectInfo dlnaApiDmcMoveObject(int i2, String str, String str2);

    public native int dlnaApiDmcPause(int i2, int i3);

    public native int dlnaApiDmcQueryTunerUsability(int i2, int i3, DLNADmsTVMediaInfo dLNADmsTVMediaInfo);

    public native DlnaSearchResultInfo dlnaApiDmcSearch(int i2, String str, int i3, int i4, String str2, String str3, String str4);

    public native int dlnaApiDmcSearchDevice();

    public native int dlnaApiDmcSeek(int i2, int i3, int i4, int i5, String str);

    public native int dlnaApiDmcSetMute(int i2, int i3, int i4, boolean z2);

    public native int dlnaApiDmcSetNextAVTransportURI(int i2, int i3, String str, String str2);

    public native int dlnaApiDmcSetNextLocalFileTransferURI(int i2, int i3, String str);

    public native String dlnaApiDmcSetPrivateAVTransportURI(int i2, int i3, String str);

    public native int dlnaApiDmcSetRemoteKey(int i2, int i3, String str);

    public native int dlnaApiDmcSetVolume(int i2, int i3, int i4, int i5);

    public native int dlnaApiDmcStopTransferResource(int i2, int i3);

    public native DLNAImportExportResourceInfo dlnaApiDmcUploadLocalFile(String str, int i2, String str2, String str3);

    public native int dlnaApiDmpBrowseReq(int i2, String str, int i3, String str2, int i4, int i5, int i6);

    public native int dlnaApiDmrNotifyMute(int i2, int i3, boolean z2);

    public native int dlnaApiDmrNotifyVolume(int i2, int i3, int i4);

    public native int dlnaApiDmrSetHuaweiId(String str);

    public native int dlnaApiDmrSetMediaState(int i2, int i3);

    public native int dlnaApiDmsAddMediaFiles(int i2, int i3, DlnaDmsMediaInfo[] dlnaDmsMediaInfoArr);

    public native int dlnaApiDmsAddSharedDir(String str, int i2);

    public native int dlnaApiDmsDelMediaFiles(int i2, int[] iArr);

    public native int dlnaApiDmsDelSharedDir(String str, int i2);

    public native int dlnaApiDmsEnableShare(boolean z2);

    public native int dlnaApiDmsUpdateSharedFiles(String str, int i2);

    public native int dlnaApiDmsUpdateSharedFiles(DlnaDmsShareDir[] dlnaDmsShareDirArr, int i2);

    public native String dlnaApiGetVersion();

    public native int dlnaApiIpChange();

    public native int dlnaApiSetAddShareDirParams(int i2, int i3);

    public native int dlnaApiSetConfig(int i2, int i3);

    public native int dlnaApiSetDeviceName(String str);

    public native int dlnaApiSetDmcAutoBrowseDisable(int i2);

    public native int dlnaApiSetLogLevel(int i2);

    public native int dlnaApiSetProductType(int i2);

    public native int dlnaApiStackDestroy();

    public native int dlnaApiStackInit(int i2, String str);

    public native int mSApiStackDestroy();

    public native RcuDeviceProfile[] ruiApiRuicCPGetDeviceProfile(int i2);

    public native int ruiApiRuicCPRefreshDeviceList();

    public native int ruiApiSetLogLevel(int i2);

    public native int ruiApiStackDestroy();

    public native int ruiApiStackInit(int i2);

    public native int ruiRcuCApiNotifyCursorStatusChanged(int i2, boolean z2);

    public native int ruiRcuCApiNotifyTextChanged(int i2, String str);

    public native int ruiRcuCPApiGetRemoteCursorStatus(int i2, int i3);

    public native String ruiRcuCPApiGetRemoteText(int i2, int i3);

    public native int ruiRcuCPApiSendKey(int i2, int i3, String str);

    public native int ruiRcuCPApiSendText(int i2, int i3, int i4, String str);
}
