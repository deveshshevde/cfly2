package com.hoho.android.usbserial.driver;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import com.hoho.android.usbserial.driver.UsbSerialPort;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cp21xxSerialDriver implements UsbSerialDriver {
    private static final String TAG = "Cp21xxSerialDriver";
    private final UsbDevice mDevice;
    private final List<UsbSerialPort> mPorts = new ArrayList();

    public class Cp21xxSerialPort extends CommonUsbSerialPort {
        private static final int DTR_DISABLE = 256;
        private static final int DTR_ENABLE = 257;
        private static final int FLUSH_READ_CODE = 10;
        private static final int FLUSH_WRITE_CODE = 5;
        private static final int REQTYPE_DEVICE_TO_HOST = 193;
        private static final int REQTYPE_HOST_TO_DEVICE = 65;
        private static final int RTS_DISABLE = 512;
        private static final int RTS_ENABLE = 514;
        private static final int SILABSER_FLUSH_REQUEST_CODE = 18;
        private static final int SILABSER_GET_MDMSTS_REQUEST_CODE = 8;
        private static final int SILABSER_IFC_ENABLE_REQUEST_CODE = 0;
        private static final int SILABSER_SET_BAUDRATE = 30;
        private static final int SILABSER_SET_LINE_CTL_REQUEST_CODE = 3;
        private static final int SILABSER_SET_MHS_REQUEST_CODE = 7;
        private static final int STATUS_CD = 128;
        private static final int STATUS_CTS = 16;
        private static final int STATUS_DSR = 32;
        private static final int STATUS_RI = 64;
        private static final int UART_DISABLE = 0;
        private static final int UART_ENABLE = 1;
        private static final int USB_WRITE_TIMEOUT_MILLIS = 5000;
        private boolean dtr = false;
        private boolean mIsRestrictedPort;
        private boolean rts = false;

        public Cp21xxSerialPort(UsbDevice usbDevice, int i2) {
            super(usbDevice, i2);
        }

        private byte getStatus() throws IOException {
            byte[] bArr = new byte[1];
            int controlTransfer = this.mConnection.controlTransfer(REQTYPE_DEVICE_TO_HOST, 8, 0, this.mPortNumber, bArr, 1, 5000);
            if (controlTransfer == 1) {
                return bArr[0];
            }
            throw new IOException("Control transfer failed: 8 / 0 -> " + controlTransfer);
        }

        private void setBaudRate(int i2) throws IOException {
            if (this.mConnection.controlTransfer(65, 30, 0, this.mPortNumber, new byte[]{(byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)}, 4, 5000) < 0) {
                throw new IOException("Error setting baud rate");
            }
        }

        private void setConfigSingle(int i2, int i3) throws IOException {
            int controlTransfer = this.mConnection.controlTransfer(65, i2, i3, this.mPortNumber, (byte[]) null, 0, 5000);
            if (controlTransfer != 0) {
                throw new IOException("Control transfer failed: " + i2 + " / " + i3 + " -> " + controlTransfer);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0004 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void closeInt() {
            /*
                r3 = this;
                r0 = 0
                r3.setConfigSingle(r0, r0)     // Catch:{ Exception -> 0x0004 }
            L_0x0004:
                android.hardware.usb.UsbDeviceConnection r0 = r3.mConnection     // Catch:{ Exception -> 0x0011 }
                android.hardware.usb.UsbDevice r1 = r3.mDevice     // Catch:{ Exception -> 0x0011 }
                int r2 = r3.mPortNumber     // Catch:{ Exception -> 0x0011 }
                android.hardware.usb.UsbInterface r1 = r1.getInterface(r2)     // Catch:{ Exception -> 0x0011 }
                r0.releaseInterface(r1)     // Catch:{ Exception -> 0x0011 }
            L_0x0011:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hoho.android.usbserial.driver.Cp21xxSerialDriver.Cp21xxSerialPort.closeInt():void");
        }

        public boolean getCD() throws IOException {
            return (getStatus() & 128) != 0;
        }

        public boolean getCTS() throws IOException {
            return (getStatus() & 16) != 0;
        }

        public EnumSet<UsbSerialPort.ControlLine> getControlLines() throws IOException {
            byte status = getStatus();
            EnumSet<UsbSerialPort.ControlLine> noneOf = EnumSet.noneOf(UsbSerialPort.ControlLine.class);
            if (this.rts) {
                noneOf.add(UsbSerialPort.ControlLine.RTS);
            }
            if ((status & 16) != 0) {
                noneOf.add(UsbSerialPort.ControlLine.CTS);
            }
            if (this.dtr) {
                noneOf.add(UsbSerialPort.ControlLine.DTR);
            }
            if ((status & 32) != 0) {
                noneOf.add(UsbSerialPort.ControlLine.DSR);
            }
            if ((status & 128) != 0) {
                noneOf.add(UsbSerialPort.ControlLine.CD);
            }
            if ((status & 64) != 0) {
                noneOf.add(UsbSerialPort.ControlLine.RI);
            }
            return noneOf;
        }

        public boolean getDSR() throws IOException {
            return (getStatus() & 32) != 0;
        }

        public boolean getDTR() throws IOException {
            return this.dtr;
        }

        public UsbSerialDriver getDriver() {
            return Cp21xxSerialDriver.this;
        }

        public boolean getRI() throws IOException {
            return (getStatus() & 64) != 0;
        }

        public boolean getRTS() throws IOException {
            return this.rts;
        }

        public EnumSet<UsbSerialPort.ControlLine> getSupportedControlLines() throws IOException {
            return EnumSet.allOf(UsbSerialPort.ControlLine.class);
        }

        /* access modifiers changed from: protected */
        public void openInt(UsbDeviceConnection usbDeviceConnection) throws IOException {
            this.mIsRestrictedPort = this.mDevice.getInterfaceCount() == 2 && this.mPortNumber == 1;
            if (this.mPortNumber < this.mDevice.getInterfaceCount()) {
                UsbInterface usbInterface = this.mDevice.getInterface(this.mPortNumber);
                if (this.mConnection.claimInterface(usbInterface, true)) {
                    for (int i2 = 0; i2 < usbInterface.getEndpointCount(); i2++) {
                        UsbEndpoint endpoint = usbInterface.getEndpoint(i2);
                        if (endpoint.getType() == 2) {
                            if (endpoint.getDirection() == 128) {
                                this.mReadEndpoint = endpoint;
                            } else {
                                this.mWriteEndpoint = endpoint;
                            }
                        }
                    }
                    setConfigSingle(0, 1);
                    setConfigSingle(7, (this.dtr ? DTR_ENABLE : 256) | (this.rts ? 514 : 512));
                    return;
                }
                throw new IOException("Could not claim interface " + this.mPortNumber);
            }
            throw new IOException("Unknown port number");
        }

        public boolean purgeHwBuffers(boolean z2, boolean z3) throws IOException {
            int i2 = 0;
            int i3 = z3 ? 10 : 0;
            if (z2) {
                i2 = 5;
            }
            int i4 = i3 | i2;
            if (i4 == 0) {
                return true;
            }
            setConfigSingle(18, i4);
            return true;
        }

        public void setDTR(boolean z2) throws IOException {
            this.dtr = z2;
            setConfigSingle(7, z2 ? DTR_ENABLE : 256);
        }

        public void setParameters(int i2, int i3, int i4, int i5) throws IOException {
            int i6;
            if (i2 > 0) {
                setBaudRate(i2);
                if (i3 != 5) {
                    if (i3 != 6) {
                        if (i3 != 7) {
                            if (i3 == 8) {
                                i6 = 2048;
                            } else {
                                throw new IllegalArgumentException("Invalid data bits: " + i3);
                            }
                        } else if (!this.mIsRestrictedPort) {
                            i6 = 1792;
                        } else {
                            throw new UnsupportedOperationException("Unsupported data bits: " + i3);
                        }
                    } else if (!this.mIsRestrictedPort) {
                        i6 = 1536;
                    } else {
                        throw new UnsupportedOperationException("Unsupported data bits: " + i3);
                    }
                } else if (!this.mIsRestrictedPort) {
                    i6 = 1280;
                } else {
                    throw new UnsupportedOperationException("Unsupported data bits: " + i3);
                }
                if (i5 != 0) {
                    if (i5 == 1) {
                        i6 |= 16;
                    } else if (i5 == 2) {
                        i6 |= 32;
                    } else if (i5 != 3) {
                        if (i5 != 4) {
                            throw new IllegalArgumentException("Invalid parity: " + i5);
                        } else if (!this.mIsRestrictedPort) {
                            i6 |= 64;
                        } else {
                            throw new UnsupportedOperationException("Unsupported parity: space");
                        }
                    } else if (!this.mIsRestrictedPort) {
                        i6 |= 48;
                    } else {
                        throw new UnsupportedOperationException("Unsupported parity: mark");
                    }
                }
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            throw new IllegalArgumentException("Invalid stop bits: " + i4);
                        }
                        throw new UnsupportedOperationException("Unsupported stop bits: 1.5");
                    } else if (!this.mIsRestrictedPort) {
                        i6 |= 2;
                    } else {
                        throw new UnsupportedOperationException("Unsupported stop bits: 2");
                    }
                }
                setConfigSingle(3, i6);
                return;
            }
            throw new IllegalArgumentException("Invalid baud rate: " + i2);
        }

        public void setRTS(boolean z2) throws IOException {
            this.rts = z2;
            setConfigSingle(7, z2 ? 514 : 512);
        }
    }

    public Cp21xxSerialDriver(UsbDevice usbDevice) {
        this.mDevice = usbDevice;
        for (int i2 = 0; i2 < usbDevice.getInterfaceCount(); i2++) {
            this.mPorts.add(new Cp21xxSerialPort(this.mDevice, i2));
        }
    }

    public static Map<Integer, int[]> getSupportedDevices() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Integer.valueOf(UsbId.VENDOR_SILABS), new int[]{60000, UsbId.SILABS_CP2105, UsbId.SILABS_CP2108, UsbId.SILABS_CP2110});
        return linkedHashMap;
    }

    public UsbDevice getDevice() {
        return this.mDevice;
    }

    public List<UsbSerialPort> getPorts() {
        return this.mPorts;
    }
}
