package io.realm;

import com.xeagle.android.login.amba.connectivity.IChannelListener;
import java.nio.ByteBuffer;
import java.util.Date;

public enum RealmFieldType {
    INTEGER(0),
    BOOLEAN(1),
    STRING(2),
    BINARY(4),
    DATE(8),
    FLOAT(9),
    DOUBLE(10),
    OBJECT(12),
    LIST(13),
    LINKING_OBJECTS(14),
    INTEGER_LIST(128),
    BOOLEAN_LIST(IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN),
    STRING_LIST(IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR),
    BINARY_LIST(IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL),
    DATE_LIST(IChannelListener.CMD_CHANNEL_CARD_PROTECTED),
    FLOAT_LIST(IChannelListener.CMD_CHANNEL_START_SESSION_FAILED),
    DOUBLE_LIST(138);
    
    private static final RealmFieldType[] basicTypes = null;
    private static final RealmFieldType[] listTypes = null;
    private final int nativeValue;

    static {
        basicTypes = new RealmFieldType[15];
        listTypes = new RealmFieldType[15];
        for (RealmFieldType realmFieldType : values()) {
            int i2 = realmFieldType.nativeValue;
            if (i2 < 128) {
                basicTypes[i2] = realmFieldType;
            } else {
                listTypes[i2 - 128] = realmFieldType;
            }
        }
    }

    private RealmFieldType(int i2) {
        this.nativeValue = i2;
    }

    public static RealmFieldType fromNativeValue(int i2) {
        RealmFieldType realmFieldType;
        RealmFieldType realmFieldType2;
        if (i2 >= 0) {
            RealmFieldType[] realmFieldTypeArr = basicTypes;
            if (i2 < realmFieldTypeArr.length && (realmFieldType2 = realmFieldTypeArr[i2]) != null) {
                return realmFieldType2;
            }
        }
        if (128 <= i2) {
            int i3 = i2 - 128;
            RealmFieldType[] realmFieldTypeArr2 = listTypes;
            if (i3 < realmFieldTypeArr2.length && (realmFieldType = realmFieldTypeArr2[i3]) != null) {
                return realmFieldType;
            }
        }
        throw new IllegalArgumentException("Invalid native Realm type: " + i2);
    }

    public int getNativeValue() {
        return this.nativeValue;
    }

    public boolean isValid(Object obj) {
        int i2 = this.nativeValue;
        if (i2 == 0) {
            return (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte);
        }
        if (i2 == 1) {
            return obj instanceof Boolean;
        }
        if (i2 == 2) {
            return obj instanceof String;
        }
        if (i2 == 4) {
            return (obj instanceof byte[]) || (obj instanceof ByteBuffer);
        }
        if (i2 == 132) {
            return false;
        }
        switch (i2) {
            case 8:
                return obj instanceof Date;
            case 9:
                return obj instanceof Float;
            case 10:
                return obj instanceof Double;
            default:
                switch (i2) {
                    case 12:
                    case 13:
                    case 14:
                        break;
                    default:
                        switch (i2) {
                            case 128:
                            case IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN:
                            case IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR:
                                break;
                            default:
                                switch (i2) {
                                    case IChannelListener.CMD_CHANNEL_CARD_PROTECTED:
                                    case IChannelListener.CMD_CHANNEL_START_SESSION_FAILED:
                                    case 138:
                                        break;
                                    default:
                                        throw new RuntimeException("Unsupported Realm type:  " + this);
                                }
                        }
                }
                return false;
        }
    }
}
