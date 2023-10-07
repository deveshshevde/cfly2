package com.hoho.android.usbserial.driver;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import com.hoho.android.usbserial.driver.UsbSerialPort;
import java.io.IOException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class Ch34xSerialDriver implements UsbSerialDriver {
    private static final int GCL_CD = 8;
    private static final int GCL_CTS = 1;
    private static final int GCL_DSR = 2;
    private static final int GCL_RI = 4;
    private static final int LCR_CS5 = 0;
    private static final int LCR_CS6 = 1;
    private static final int LCR_CS7 = 2;
    private static final int LCR_CS8 = 3;
    private static final int LCR_ENABLE_PAR = 8;
    private static final int LCR_ENABLE_RX = 128;
    private static final int LCR_ENABLE_TX = 64;
    private static final int LCR_MARK_SPACE = 32;
    private static final int LCR_PAR_EVEN = 16;
    private static final int LCR_STOP_BITS_2 = 4;
    private static final int SCL_DTR = 32;
    private static final int SCL_RTS = 64;
    private static final String TAG = "Ch34xSerialDriver";
    private final UsbDevice mDevice;
    private final UsbSerialPort mPort;

    public class Ch340SerialPort extends CommonUsbSerialPort {
        private static final int USB_TIMEOUT_MILLIS = 5000;
        private final int DEFAULT_BAUD_RATE = 9600;
        private boolean dtr = false;
        private boolean rts = false;

        public Ch340SerialPort(UsbDevice usbDevice, int i2) {
            super(usbDevice, i2);
        }

        private void checkState(String str, int i2, int i3, int[] iArr) throws IOException {
            byte b2;
            byte[] bArr = new byte[iArr.length];
            int i4 = 0;
            int controlIn = controlIn(i2, i3, 0, bArr);
            if (controlIn < 0) {
                throw new IOException("Failed send cmd [" + str + "]");
            } else if (controlIn == iArr.length) {
                while (i4 < iArr.length) {
                    if (iArr[i4] == -1 || iArr[i4] == (b2 = bArr[i4] & 255)) {
                        i4++;
                    } else {
                        throw new IOException("Expected 0x" + Integer.toHexString(iArr[i4]) + " byte, but get 0x" + Integer.toHexString(b2) + " [" + str + "]");
                    }
                }
            } else {
                throw new IOException("Expected " + iArr.length + " bytes, but get " + controlIn + " [" + str + "]");
            }
        }

        private int controlIn(int i2, int i3, int i4, byte[] bArr) {
            return this.mConnection.controlTransfer(192, i2, i3, i4, bArr, bArr.length, 5000);
        }

        private int controlOut(int i2, int i3, int i4) {
            return this.mConnection.controlTransfer(64, i2, i3, i4, (byte[]) null, 0, 5000);
        }

        private byte getStatus() throws IOException {
            byte[] bArr = new byte[2];
            if (controlIn(149, 1798, 0, bArr) >= 0) {
                return bArr[0];
            }
            throw new IOException("Error getting control lines");
        }

        private void initialize() throws IOException {
            checkState("init #1", 95, 0, new int[]{-1, 0});
            if (controlOut(161, 0, 0) >= 0) {
                setBaudRate(9600);
                checkState("init #4", 149, 9496, new int[]{-1, 0});
                if (controlOut(154, 9496, 195) >= 0) {
                    checkState("init #6", 149, 1798, new int[]{-1, -1});
                    if (controlOut(161, 20511, 55562) >= 0) {
                        setBaudRate(9600);
                        setControlLines();
                        checkState("init #10", 149, 1798, new int[]{-1, -1});
                        return;
                    }
                    throw new IOException("Init failed: #7");
                }
                throw new IOException("Init failed: #5");
            }
            throw new IOException("Init failed: #2");
        }

        private void setBaudRate(int i2) throws IOException {
            long j2 = 1532620800 / ((long) i2);
            int i3 = 3;
            while (j2 > 65520 && i3 > 0) {
                j2 >>= 3;
                i3--;
            }
            if (j2 <= 65520) {
                long j3 = IjkMediaMeta.AV_CH_TOP_BACK_CENTER - j2;
                if (controlOut(154, 4882, (int) ((65280 & j3) | ((long) (i3 | 128)))) < 0) {
                    throw new IOException("Error setting baud rate: #1)");
                } else if (controlOut(154, 3884, (int) (255 & j3)) < 0) {
                    throw new IOException("Error setting baud rate: #2");
                }
            } else {
                throw new UnsupportedOperationException("Unsupported baud rate: " + i2);
            }
        }

        private void setControlLines() throws IOException {
            if (controlOut(164, ((this.dtr ? 32 : 0) | (this.rts ? 64 : 0)) ^ -1, 0) < 0) {
                throw new IOException("Failed to set control lines");
            }
        }

        /* access modifiers changed from: protected */
        public void closeInt() {
            int i2 = 0;
            while (i2 < this.mDevice.getInterfaceCount()) {
                try {
                    this.mConnection.releaseInterface(this.mDevice.getInterface(i2));
                    i2++;
                } catch (Exception unused) {
                    return;
                }
            }
        }

        public boolean getCD() throws IOException {
            return (getStatus() & 8) == 0;
        }

        public boolean getCTS() throws IOException {
            return (getStatus() & 1) == 0;
        }

        public EnumSet<UsbSerialPort.ControlLine> getControlLines() throws IOException {
            byte status = getStatus();
            EnumSet<UsbSerialPort.ControlLine> noneOf = EnumSet.noneOf(UsbSerialPort.ControlLine.class);
            if (this.rts) {
                noneOf.add(UsbSerialPort.ControlLine.RTS);
            }
            if ((status & 1) == 0) {
                noneOf.add(UsbSerialPort.ControlLine.CTS);
            }
            if (this.dtr) {
                noneOf.add(UsbSerialPort.ControlLine.DTR);
            }
            if ((status & 2) == 0) {
                noneOf.add(UsbSerialPort.ControlLine.DSR);
            }
            if ((status & 8) == 0) {
                noneOf.add(UsbSerialPort.ControlLine.CD);
            }
            if ((status & 4) == 0) {
                noneOf.add(UsbSerialPort.ControlLine.RI);
            }
            return noneOf;
        }

        public boolean getDSR() throws IOException {
            return (getStatus() & 2) == 0;
        }

        public boolean getDTR() throws IOException {
            return this.dtr;
        }

        public UsbSerialDriver getDriver() {
            return Ch34xSerialDriver.this;
        }

        public boolean getRI() throws IOException {
            return (getStatus() & 4) == 0;
        }

        public boolean getRTS() throws IOException {
            return this.rts;
        }

        public EnumSet<UsbSerialPort.ControlLine> getSupportedControlLines() throws IOException {
            return EnumSet.allOf(UsbSerialPort.ControlLine.class);
        }

        /* access modifiers changed from: protected */
        public void openInt(UsbDeviceConnection usbDeviceConnection) throws IOException {
            int i2 = 0;
            while (i2 < this.mDevice.getInterfaceCount()) {
                if (this.mConnection.claimInterface(this.mDevice.getInterface(i2), true)) {
                    i2++;
                } else {
                    throw new IOException("Could not claim data interface");
                }
            }
            UsbInterface usbInterface = this.mDevice.getInterface(this.mDevice.getInterfaceCount() - 1);
            for (int i3 = 0; i3 < usbInterface.getEndpointCount(); i3++) {
                UsbEndpoint endpoint = usbInterface.getEndpoint(i3);
                if (endpoint.getType() == 2) {
                    if (endpoint.getDirection() == 128) {
                        this.mReadEndpoint = endpoint;
                    } else {
                        this.mWriteEndpoint = endpoint;
                    }
                }
            }
            initialize();
            setBaudRate(9600);
        }

        public void setDTR(boolean z2) throws IOException {
            this.dtr = z2;
            setControlLines();
        }

        public void setParameters(int i2, int i3, int i4, int i5) throws IOException {
            int i6;
            if (i2 > 0) {
                setBaudRate(i2);
                if (i3 == 5) {
                    i6 = 192;
                } else if (i3 == 6) {
                    i6 = 193;
                } else if (i3 == 7) {
                    i6 = 194;
                } else if (i3 == 8) {
                    i6 = 195;
                } else {
                    throw new IllegalArgumentException("Invalid data bits: " + i3);
                }
                if (i5 != 0) {
                    if (i5 == 1) {
                        i6 |= 8;
                    } else if (i5 == 2) {
                        i6 |= 24;
                    } else if (i5 == 3) {
                        i6 |= 40;
                    } else if (i5 == 4) {
                        i6 |= 56;
                    } else {
                        throw new IllegalArgumentException("Invalid parity: " + i5);
                    }
                }
                if (i4 != 1) {
                    if (i4 == 2) {
                        i6 |= 4;
                    } else if (i4 != 3) {
                        throw new IllegalArgumentException("Invalid stop bits: " + i4);
                    } else {
                        throw new UnsupportedOperationException("Unsupported stop bits: 1.5");
                    }
                }
                if (controlOut(154, 9496, i6) < 0) {
                    throw new IOException("Error setting control byte");
                }
                return;
            }
            throw new IllegalArgumentException("Invalid baud rate: " + i2);
        }

        public void setRTS(boolean z2) throws IOException {
            this.rts = z2;
            setControlLines();
        }
    }

    public Ch34xSerialDriver(UsbDevice usbDevice) {
        this.mDevice = usbDevice;
        this.mPort = new Ch340SerialPort(usbDevice, 0);
    }

    public static Map<Integer, int[]> getSupportedDevices() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Integer.valueOf(UsbId.VENDOR_QINHENG), new int[]{UsbId.QINHENG_CH340, UsbId.QINHENG_CH341A});
        return linkedHashMap;
    }

    public UsbDevice getDevice() {
        return this.mDevice;
    }

    public List<UsbSerialPort> getPorts() {
        return Collections.singletonList(this.mPort);
    }
}
