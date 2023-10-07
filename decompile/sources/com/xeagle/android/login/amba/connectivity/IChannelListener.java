package com.xeagle.android.login.amba.connectivity;

public interface IChannelListener {
    public static final int CMD_CHANNEL_CARD_PROTECTED = 136;
    public static final int CMD_CHANNEL_ERROR_BLE_DISABLED = 131;
    public static final int CMD_CHANNEL_ERROR_BLE_INVALID_ADDR = 130;
    public static final int CMD_CHANNEL_ERROR_BROKEN_CHANNEL = 132;
    public static final int CMD_CHANNEL_ERROR_CONNECT = 134;
    public static final int CMD_CHANNEL_ERROR_INVALID_TOKEN = 129;
    public static final int CMD_CHANNEL_ERROR_TIMEOUT = 128;
    public static final int CMD_CHANNEL_ERROR_WAKEUP = 133;
    public static final int CMD_CHANNEL_EVENT_BATTERY_LEVEL = 20;
    public static final int CMD_CHANNEL_EVENT_CONNECTED = 13;
    public static final int CMD_CHANNEL_EVENT_DEL = 6;
    public static final int CMD_CHANNEL_EVENT_DEL_FILE_PATH = 49;
    public static final int CMD_CHANNEL_EVENT_DEL_FILE_POS = 50;
    public static final int CMD_CHANNEL_EVENT_DRONE_BURN_FW = 65;
    public static final int CMD_CHANNEL_EVENT_FORMAT_SD = 18;
    public static final int CMD_CHANNEL_EVENT_GET_ALL_SETTINGS = 10;
    public static final int CMD_CHANNEL_EVENT_GET_DEVINFO = 17;
    public static final int CMD_CHANNEL_EVENT_GET_FILE = 7;
    public static final int CMD_CHANNEL_EVENT_GET_FILE_PATH = 48;
    public static final int CMD_CHANNEL_EVENT_GET_INFO = 8;
    public static final int CMD_CHANNEL_EVENT_GET_NUM_FILES = 16;
    public static final int CMD_CHANNEL_EVENT_GET_OPTIONS = 11;
    public static final int CMD_CHANNEL_EVENT_GET_SETTING = 55;
    public static final int CMD_CHANNEL_EVENT_GET_SPACE = 15;
    public static final int CMD_CHANNEL_EVENT_GET_THUMB = 37;
    public static final int CMD_CHANNEL_EVENT_GET_VERSION = 51;
    public static final int CMD_CHANNEL_EVENT_GET_ZOOM_INFO = 39;
    public static final int CMD_CHANNEL_EVENT_HEART_DATA = 56;
    public static final int CMD_CHANNEL_EVENT_IMAGE_BURN_FW = 64;
    public static final int CMD_CHANNEL_EVENT_INIT = 1;
    public static final int CMD_CHANNEL_EVENT_LOG = 3;
    public static final int CMD_CHANNEL_EVENT_LS = 5;
    public static final int CMD_CHANNEL_EVENT_NEW_DEVICE = 54;
    public static final int CMD_CHANNEL_EVENT_NOTIFICATION = 40;
    public static final int CMD_CHANNEL_EVENT_PUT_FILE = 19;
    public static final int CMD_CHANNEL_EVENT_RECORD_START = 52;
    public static final int CMD_CHANNEL_EVENT_RECORD_STOP = 53;
    public static final int CMD_CHANNEL_EVENT_RECORD_TIME = 21;
    public static final int CMD_CHANNEL_EVENT_RESETVF = 9;
    public static final int CMD_CHANNEL_EVENT_SET_ATTRIBUTE = 36;
    public static final int CMD_CHANNEL_EVENT_SET_SETTING = 12;
    public static final int CMD_CHANNEL_EVENT_SET_ZOOM = 38;
    public static final int CMD_CHANNEL_EVENT_SHOW_ALERT = 4;
    public static final int CMD_CHANNEL_EVENT_SHUTDOWN = 2;
    public static final int CMD_CHANNEL_EVENT_START_CONNECT = 32;
    public static final int CMD_CHANNEL_EVENT_START_LS = 33;
    public static final int CMD_CHANNEL_EVENT_START_SESSION = 23;
    public static final int CMD_CHANNEL_EVENT_STOP_VF = 22;
    public static final int CMD_CHANNEL_EVENT_TAKE_PHOTO = 41;
    public static final int CMD_CHANNEL_EVENT_UPGRADE_DRONE_NOTIFY = 57;
    public static final int CMD_CHANNEL_EVENT_WAKEUP_OK = 35;
    public static final int CMD_CHANNEL_EVENT_WAKEUP_START = 34;
    public static final int CMD_CHANNEL_MSG = 0;
    public static final int CMD_CHANNEL_NO_MORE_SPACE = 135;
    public static final int CMD_CHANNEL_START_SESSION_FAILED = 137;
    public static final int DATA_CHANNEL_EVENT_GET_FINISH = 514;
    public static final int DATA_CHANNEL_EVENT_GET_PROGRESS = 513;
    public static final int DATA_CHANNEL_EVENT_GET_START = 512;
    public static final int DATA_CHANNEL_EVENT_PUT_FINISH = 517;
    public static final int DATA_CHANNEL_EVENT_PUT_MD5 = 518;
    public static final int DATA_CHANNEL_EVENT_PUT_PROGRESS = 516;
    public static final int DATA_CHANNEL_EVENT_PUT_START = 515;
    public static final int DATA_CHANNEL_MSG = 512;
    public static final int MSG_MASK = 2147483392;
    public static final int STREAM_CHANNEL_ERROR_PLAYING = 1026;
    public static final int STREAM_CHANNEL_EVENT_BUFFERING = 1024;
    public static final int STREAM_CHANNEL_EVENT_PLAYING = 1025;
    public static final int STREAM_CHANNEL_MSG = 1024;

    void onChannelEvent(int i2, Object obj, String... strArr);
}