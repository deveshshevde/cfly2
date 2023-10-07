package com.hoho.android.usbserial.driver;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.util.Log;
import com.hoho.android.usbserial.driver.UsbSerialPort;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FtdiSerialDriver implements UsbSerialDriver {
    private final UsbDevice mDevice;
    private final List<UsbSerialPort> mPorts = new ArrayList();

    private enum DeviceType {
        TYPE_BM,
        TYPE_AM,
        TYPE_2232C,
        TYPE_R,
        TYPE_2232H,
        TYPE_4232H
    }

    public class FtdiSerialPort extends CommonUsbSerialPort {
        private static final int FTDI_DEVICE_IN_REQTYPE = 192;
        private static final int FTDI_DEVICE_OUT_REQTYPE = 64;
        private static final int MODEM_STATUS_HEADER_LENGTH = 2;
        private static final int SIO_GET_LATENCY_TIMER_REQUEST = 10;
        private static final int SIO_GET_MODEM_STATUS_REQUEST = 5;
        private static final int SIO_MODEM_CTRL_REQUEST = 1;
        private static final int SIO_MODEM_STATUS_CTS = 16;
        private static final int SIO_MODEM_STATUS_DSR = 32;
        private static final int SIO_MODEM_STATUS_RI = 64;
        private static final int SIO_MODEM_STATUS_RLSD = 128;
        private static final int SIO_RESET_PURGE_RX = 1;
        private static final int SIO_RESET_PURGE_TX = 2;
        private static final int SIO_RESET_REQUEST = 0;
        private static final int SIO_RESET_SIO = 0;
        private static final int SIO_SET_BAUD_RATE_REQUEST = 3;
        private static final int SIO_SET_DATA_REQUEST = 4;
        private static final int SIO_SET_DTR_HIGH = 257;
        private static final int SIO_SET_DTR_LOW = 256;
        private static final int SIO_SET_FLOW_CTRL_REQUEST = 2;
        private static final int SIO_SET_LATENCY_TIMER_REQUEST = 9;
        private static final int SIO_SET_RTS_HIGH = 514;
        private static final int SIO_SET_RTS_LOW = 512;
        private static final int USB_ENDPOINT_IN = 128;
        private static final int USB_ENDPOINT_OUT = 0;
        private static final int USB_READ_TIMEOUT_MILLIS = 5000;
        private static final int USB_RECIP_DEVICE = 0;
        private static final int USB_RECIP_ENDPOINT = 2;
        private static final int USB_RECIP_INTERFACE = 1;
        private static final int USB_RECIP_OTHER = 3;
        private static final int USB_TYPE_CLASS = 0;
        private static final int USB_TYPE_RESERVED = 0;
        private static final int USB_TYPE_STANDARD = 0;
        private static final int USB_TYPE_VENDOR = 0;
        private static final int USB_WRITE_TIMEOUT_MILLIS = 5000;
        private final String TAG = FtdiSerialDriver.class.getSimpleName();
        private boolean mDtrState = false;
        private int mIndex = 0;
        private boolean mRtsState = false;
        private DeviceType mType;

        public FtdiSerialPort(UsbDevice usbDevice, int i2) {
            super(usbDevice, i2);
        }

        private long[] convertBaudrate(int i2) {
            int i3 = i2;
            int i4 = 24000000 / i3;
            int[] iArr = {0, 3, 2, 4, 1, 5, 6, 7};
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                if (i5 >= 2) {
                    break;
                }
                int i9 = i4 + i5;
                if (i9 <= 8) {
                    i9 = 8;
                } else if (this.mType != DeviceType.TYPE_AM && i9 < 12) {
                    i9 = 12;
                } else if (i4 < 16) {
                    i9 = 16;
                } else if (this.mType != DeviceType.TYPE_AM && i9 > 131071) {
                    i9 = 131071;
                }
                int i10 = ((i9 / 2) + 24000000) / i9;
                int i11 = i10 < i3 ? i3 - i10 : i10 - i3;
                if (i5 == 0 || i11 < i6) {
                    i8 = i10;
                    if (i11 == 0) {
                        i7 = i9;
                        break;
                    }
                    i6 = i11;
                    i7 = i9;
                }
                i5++;
            }
            long j2 = (long) ((i7 >> 3) | (iArr[i7 & 7] << 14));
            if (j2 == 1) {
                j2 = 0;
            } else if (j2 == 16385) {
                j2 = 1;
            }
            return new long[]{(long) i8, (this.mType == DeviceType.TYPE_2232C || this.mType == DeviceType.TYPE_2232H || this.mType == DeviceType.TYPE_4232H) ? ((j2 >> 8) & 65280) | ((long) this.mIndex) : (j2 >> 16) & 65535, j2 & 65535};
        }

        private int getModemStatus() throws IOException {
            byte[] bArr = new byte[2];
            int controlTransfer = this.mConnection.controlTransfer(FTDI_DEVICE_IN_REQTYPE, 5, 0, this.mIndex, bArr, 2, 5000);
            if (controlTransfer == 2) {
                return bArr[0];
            }
            throw new IOException("Get modem statusfailed: result=" + controlTransfer);
        }

        private void reset() throws IOException {
            this.mType = DeviceType.TYPE_R;
            if (this.mDevice.getInterfaceCount() > 1) {
                this.mIndex = this.mPortNumber + 1;
                if (this.mDevice.getInterfaceCount() == 2) {
                    this.mType = DeviceType.TYPE_2232H;
                }
                if (this.mDevice.getInterfaceCount() == 4) {
                    this.mType = DeviceType.TYPE_4232H;
                }
            }
            int controlTransfer = this.mConnection.controlTransfer(64, 0, 0, this.mIndex, (byte[]) null, 0, 5000);
            if (controlTransfer == 0) {
                this.mDtrState = false;
                this.mRtsState = false;
                return;
            }
            throw new IOException("Reset failed: result=" + controlTransfer);
        }

        private int setBaudRate(int i2) throws IOException {
            long[] convertBaudrate = convertBaudrate(i2);
            long j2 = convertBaudrate[0];
            long j3 = convertBaudrate[1];
            int controlTransfer = this.mConnection.controlTransfer(64, 3, (int) convertBaudrate[2], (int) j3, (byte[]) null, 0, 5000);
            if (controlTransfer == 0) {
                return (int) j2;
            }
            throw new IOException("Setting baudrate failed: result=" + controlTransfer);
        }

        /* access modifiers changed from: protected */
        public void closeInt() {
            try {
                this.mConnection.releaseInterface(this.mDevice.getInterface(this.mPortNumber));
            } catch (Exception unused) {
            }
        }

        public boolean getCD() throws IOException {
            return (getModemStatus() & 128) != 0;
        }

        public boolean getCTS() throws IOException {
            return (getModemStatus() & 16) != 0;
        }

        public EnumSet<UsbSerialPort.ControlLine> getControlLines() throws IOException {
            int modemStatus = getModemStatus();
            EnumSet<UsbSerialPort.ControlLine> noneOf = EnumSet.noneOf(UsbSerialPort.ControlLine.class);
            if (this.mRtsState) {
                noneOf.add(UsbSerialPort.ControlLine.RTS);
            }
            if ((modemStatus & 16) != 0) {
                noneOf.add(UsbSerialPort.ControlLine.CTS);
            }
            if (this.mDtrState) {
                noneOf.add(UsbSerialPort.ControlLine.DTR);
            }
            if ((modemStatus & 32) != 0) {
                noneOf.add(UsbSerialPort.ControlLine.DSR);
            }
            if ((modemStatus & 128) != 0) {
                noneOf.add(UsbSerialPort.ControlLine.CD);
            }
            if ((modemStatus & 64) != 0) {
                noneOf.add(UsbSerialPort.ControlLine.RI);
            }
            return noneOf;
        }

        public boolean getDSR() throws IOException {
            return (getModemStatus() & 32) != 0;
        }

        public boolean getDTR() throws IOException {
            return this.mDtrState;
        }

        public UsbSerialDriver getDriver() {
            return FtdiSerialDriver.this;
        }

        public int getLatencyTimer() throws IOException {
            byte[] bArr = new byte[1];
            int controlTransfer = this.mConnection.controlTransfer(FTDI_DEVICE_IN_REQTYPE, 10, 0, this.mIndex, bArr, 1, 5000);
            if (controlTransfer == 1) {
                return bArr[0];
            }
            throw new IOException("Get latency timer failed: result=" + controlTransfer);
        }

        public boolean getRI() throws IOException {
            return (getModemStatus() & 64) != 0;
        }

        public boolean getRTS() throws IOException {
            return this.mRtsState;
        }

        public EnumSet<UsbSerialPort.ControlLine> getSupportedControlLines() throws IOException {
            return EnumSet.allOf(UsbSerialPort.ControlLine.class);
        }

        /* access modifiers changed from: protected */
        public void openInt(UsbDeviceConnection usbDeviceConnection) throws IOException {
            if (usbDeviceConnection.claimInterface(this.mDevice.getInterface(this.mPortNumber), true)) {
                String str = this.TAG;
                Log.d(str, "claimInterface " + this.mPortNumber + " SUCCESS");
                if (this.mDevice.getInterface(this.mPortNumber).getEndpointCount() >= 2) {
                    this.mReadEndpoint = this.mDevice.getInterface(this.mPortNumber).getEndpoint(0);
                    this.mWriteEndpoint = this.mDevice.getInterface(this.mPortNumber).getEndpoint(1);
                    reset();
                    return;
                }
                throw new IOException("Insufficient number of endpoints (" + this.mDevice.getInterface(this.mPortNumber).getEndpointCount() + ")");
            }
            throw new IOException("Error claiming interface " + this.mPortNumber);
        }

        public boolean purgeHwBuffers(boolean z2, boolean z3) throws IOException {
            int controlTransfer;
            int controlTransfer2;
            if (z2 && (controlTransfer2 = this.mConnection.controlTransfer(64, 0, 1, this.mIndex, (byte[]) null, 0, 5000)) != 0) {
                throw new IOException("purge write buffer failed: result=" + controlTransfer2);
            } else if (!z3 || (controlTransfer = this.mConnection.controlTransfer(64, 0, 2, this.mIndex, (byte[]) null, 0, 5000)) == 0) {
                return true;
            } else {
                throw new IOException("purge read buffer failed: result=" + controlTransfer);
            }
        }

        /* access modifiers changed from: protected */
        public int readFilter(byte[] bArr, int i2) throws IOException {
            if (i2 >= 2) {
                int maxPacketSize = this.mReadEndpoint.getMaxPacketSize();
                int i3 = ((i2 + maxPacketSize) - 1) / maxPacketSize;
                int i4 = 0;
                while (i4 < i3) {
                    int i5 = i4 == i3 + -1 ? (i2 - (i4 * maxPacketSize)) - 2 : maxPacketSize - 2;
                    if (i5 > 0) {
                        System.arraycopy(bArr, (i4 * maxPacketSize) + 2, bArr, (maxPacketSize - 2) * i4, i5);
                    }
                    i4++;
                }
                return i2 - (i3 * 2);
            }
            throw new IOException("Expected at least 2 bytes");
        }

        public void setDTR(boolean z2) throws IOException {
            int controlTransfer = this.mConnection.controlTransfer(64, 1, z2 ? SIO_SET_DTR_HIGH : 256, this.mIndex, (byte[]) null, 0, 5000);
            if (controlTransfer == 0) {
                this.mDtrState = z2;
                return;
            }
            throw new IOException("Set DTR failed: result=" + controlTransfer);
        }

        public void setLatencyTimer(int i2) throws IOException {
            int controlTransfer = this.mConnection.controlTransfer(64, 9, i2, this.mIndex, (byte[]) null, 0, 5000);
            if (controlTransfer != 0) {
                throw new IOException("Set latency timer failed: result=" + controlTransfer);
            }
        }

        public void setParameters(int i2, int i3, int i4, int i5) throws IOException {
            int i6;
            int i7;
            if (i2 > 0) {
                setBaudRate(i2);
                if (i3 == 5 || i3 == 6) {
                    throw new UnsupportedOperationException("Unsupported data bits: " + i3);
                } else if (i3 == 7 || i3 == 8) {
                    int i8 = i3 | 0;
                    if (i5 == 0) {
                        i6 = i8 | 0;
                    } else if (i5 == 1) {
                        i6 = i8 | 256;
                    } else if (i5 == 2) {
                        i6 = i8 | 512;
                    } else if (i5 == 3) {
                        i6 = i8 | 768;
                    } else if (i5 == 4) {
                        i6 = i8 | 1024;
                    } else {
                        throw new IllegalArgumentException("Invalid parity: " + i5);
                    }
                    if (i4 == 1) {
                        i7 = i6 | 0;
                    } else if (i4 == 2) {
                        i7 = i6 | 4096;
                    } else if (i4 != 3) {
                        throw new IllegalArgumentException("Invalid stop bits: " + i4);
                    } else {
                        throw new UnsupportedOperationException("Unsupported stop bits: 1.5");
                    }
                    int controlTransfer = this.mConnection.controlTransfer(64, 4, i7, this.mIndex, (byte[]) null, 0, 5000);
                    if (controlTransfer != 0) {
                        throw new IOException("Setting parameters failed: result=" + controlTransfer);
                    }
                } else {
                    throw new IllegalArgumentException("Invalid data bits: " + i3);
                }
            } else {
                throw new IllegalArgumentException("Invalid baud rate: " + i2);
            }
        }

        public void setRTS(boolean z2) throws IOException {
            int controlTransfer = this.mConnection.controlTransfer(64, 1, z2 ? 514 : 512, this.mIndex, (byte[]) null, 0, 5000);
            if (controlTransfer == 0) {
                this.mRtsState = z2;
                return;
            }
            throw new IOException("Set DTR failed: result=" + controlTransfer);
        }
    }

    public FtdiSerialDriver(UsbDevice usbDevice) {
        this.mDevice = usbDevice;
        for (int i2 = 0; i2 < usbDevice.getInterfaceCount(); i2++) {
            this.mPorts.add(new FtdiSerialPort(this.mDevice, i2));
        }
    }

    public static Map<Integer, int[]> getSupportedDevices() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1027, new int[]{UsbId.FTDI_FT232R, UsbId.FTDI_FT232H, UsbId.FTDI_FT2232H, UsbId.FTDI_FT4232H, UsbId.FTDI_FT231X});
        return linkedHashMap;
    }

    public UsbDevice getDevice() {
        return this.mDevice;
    }

    public List<UsbSerialPort> getPorts() {
        return this.mPorts;
    }
}
