package com.hoho.android.usbserial.driver;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.util.Log;
import com.hoho.android.usbserial.driver.UsbSerialPort;
import java.io.IOException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProlificSerialDriver implements UsbSerialDriver {
    /* access modifiers changed from: private */
    public final String TAG = ProlificSerialDriver.class.getSimpleName();
    private final UsbDevice mDevice;
    private final UsbSerialPort mPort;

    class ProlificSerialPort extends CommonUsbSerialPort {
        private static final int CONTROL_DTR = 1;
        private static final int CONTROL_RTS = 2;
        private static final int DEVICE_TYPE_0 = 1;
        private static final int DEVICE_TYPE_1 = 2;
        private static final int DEVICE_TYPE_HX = 0;
        private static final int FLUSH_RX_REQUEST = 8;
        private static final int FLUSH_TX_REQUEST = 9;
        private static final int INTERRUPT_ENDPOINT = 129;
        private static final int PROLIFIC_CTRL_OUT_REQTYPE = 33;
        private static final int PROLIFIC_VENDOR_IN_REQTYPE = 192;
        private static final int PROLIFIC_VENDOR_OUT_REQTYPE = 64;
        private static final int PROLIFIC_VENDOR_READ_REQUEST = 1;
        private static final int PROLIFIC_VENDOR_WRITE_REQUEST = 1;
        private static final int READ_ENDPOINT = 131;
        private static final int SET_CONTROL_REQUEST = 34;
        private static final int SET_LINE_REQUEST = 32;
        private static final int STATUS_BUFFER_SIZE = 10;
        private static final int STATUS_BYTE_IDX = 8;
        private static final int STATUS_FLAG_CD = 1;
        private static final int STATUS_FLAG_CTS = 128;
        private static final int STATUS_FLAG_DSR = 2;
        private static final int STATUS_FLAG_RI = 8;
        private static final int USB_READ_TIMEOUT_MILLIS = 1000;
        private static final int USB_RECIP_INTERFACE = 1;
        private static final int USB_WRITE_TIMEOUT_MILLIS = 5000;
        private static final int WRITE_ENDPOINT = 2;
        private int mBaudRate = -1;
        private int mControlLinesValue = 0;
        private int mDataBits = -1;
        private int mDeviceType = 0;
        private UsbEndpoint mInterruptEndpoint;
        private int mParity = -1;
        private IOException mReadStatusException = null;
        private volatile Thread mReadStatusThread = null;
        private final Object mReadStatusThreadLock = new Object();
        private int mStatus = 0;
        private int mStopBits = -1;
        boolean mStopReadStatusThread = false;

        public ProlificSerialPort(UsbDevice usbDevice, int i2) {
            super(usbDevice, i2);
        }

        private final void ctrlOut(int i2, int i3, int i4, byte[] bArr) throws IOException {
            outControlTransfer(33, i2, i3, i4, bArr);
        }

        private void doBlackMagic() throws IOException {
            vendorIn(33924, 0, 1);
            vendorOut(1028, 0, (byte[]) null);
            vendorIn(33924, 0, 1);
            vendorIn(33667, 0, 1);
            vendorIn(33924, 0, 1);
            vendorOut(1028, 1, (byte[]) null);
            vendorIn(33924, 0, 1);
            vendorIn(33667, 0, 1);
            vendorOut(0, 1, (byte[]) null);
            vendorOut(1, 0, (byte[]) null);
            vendorOut(2, this.mDeviceType == 0 ? 68 : 36, (byte[]) null);
        }

        private final int getStatus() throws IOException {
            if (this.mReadStatusThread == null && this.mReadStatusException == null) {
                synchronized (this.mReadStatusThreadLock) {
                    if (this.mReadStatusThread == null) {
                        byte[] bArr = new byte[10];
                        if (this.mConnection.bulkTransfer(this.mInterruptEndpoint, bArr, 10, 100) != 10) {
                            Log.w(ProlificSerialDriver.this.TAG, "Could not read initial CTS / DSR / CD / RI status");
                        } else {
                            this.mStatus = bArr[8] & 255;
                        }
                        this.mReadStatusThread = new Thread(new Runnable() {
                            public void run() {
                                ProlificSerialPort.this.readStatusThreadFunction();
                            }
                        });
                        this.mReadStatusThread.setDaemon(true);
                        this.mReadStatusThread.start();
                    }
                }
            }
            IOException iOException = this.mReadStatusException;
            if (iOException == null) {
                return this.mStatus;
            }
            this.mReadStatusException = null;
            throw iOException;
        }

        private final byte[] inControlTransfer(int i2, int i3, int i4, int i5, int i6) throws IOException {
            byte[] bArr = new byte[i6];
            int controlTransfer = this.mConnection.controlTransfer(i2, i3, i4, i5, bArr, i6, 1000);
            if (controlTransfer == i6) {
                return bArr;
            }
            throw new IOException(String.format("ControlTransfer with value 0x%x failed: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(controlTransfer)}));
        }

        private final void outControlTransfer(int i2, int i3, int i4, int i5, byte[] bArr) throws IOException {
            int length = bArr == null ? 0 : bArr.length;
            int controlTransfer = this.mConnection.controlTransfer(i2, i3, i4, i5, bArr, length, 5000);
            if (controlTransfer != length) {
                throw new IOException(String.format("ControlTransfer with value 0x%x failed: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(controlTransfer)}));
            }
        }

        /* access modifiers changed from: private */
        public final void readStatusThreadFunction() {
            while (!this.mStopReadStatusThread) {
                try {
                    byte[] bArr = new byte[10];
                    int bulkTransfer = this.mConnection.bulkTransfer(this.mInterruptEndpoint, bArr, 10, 500);
                    if (bulkTransfer > 0) {
                        if (bulkTransfer == 10) {
                            this.mStatus = bArr[8] & 255;
                        } else {
                            throw new IOException(String.format("Invalid CTS / DSR / CD / RI status buffer received, expected %d bytes, but received %d", new Object[]{10, Integer.valueOf(bulkTransfer)}));
                        }
                    }
                } catch (IOException e2) {
                    this.mReadStatusException = e2;
                    return;
                }
            }
        }

        private void resetDevice() throws IOException {
            purgeHwBuffers(true, true);
        }

        private void setControlLines(int i2) throws IOException {
            ctrlOut(34, i2, 0, (byte[]) null);
            this.mControlLinesValue = i2;
        }

        private final boolean testStatusFlag(int i2) throws IOException {
            return (getStatus() & i2) == i2;
        }

        private final byte[] vendorIn(int i2, int i3, int i4) throws IOException {
            return inControlTransfer(PROLIFIC_VENDOR_IN_REQTYPE, 1, i2, i3, i4);
        }

        private final void vendorOut(int i2, int i3, byte[] bArr) throws IOException {
            outControlTransfer(64, 1, i2, i3, bArr);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|5|13|14|20|21|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0024 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void closeInt() {
            /*
                r4 = this;
                r0 = 1
                r4.mStopReadStatusThread = r0     // Catch:{ Exception -> 0x0024 }
                java.lang.Object r0 = r4.mReadStatusThreadLock     // Catch:{ Exception -> 0x0024 }
                monitor-enter(r0)     // Catch:{ Exception -> 0x0024 }
                java.lang.Thread r1 = r4.mReadStatusThread     // Catch:{ all -> 0x0021 }
                if (r1 == 0) goto L_0x001c
                java.lang.Thread r1 = r4.mReadStatusThread     // Catch:{ Exception -> 0x0010 }
                r1.join()     // Catch:{ Exception -> 0x0010 }
                goto L_0x001c
            L_0x0010:
                r1 = move-exception
                com.hoho.android.usbserial.driver.ProlificSerialDriver r2 = com.hoho.android.usbserial.driver.ProlificSerialDriver.this     // Catch:{ all -> 0x0021 }
                java.lang.String r2 = r2.TAG     // Catch:{ all -> 0x0021 }
                java.lang.String r3 = "An error occured while waiting for status read thread"
                android.util.Log.w(r2, r3, r1)     // Catch:{ all -> 0x0021 }
            L_0x001c:
                monitor-exit(r0)     // Catch:{ all -> 0x0021 }
                r4.resetDevice()     // Catch:{ Exception -> 0x0024 }
                goto L_0x0024
            L_0x0021:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0021 }
                throw r1     // Catch:{ Exception -> 0x0024 }
            L_0x0024:
                android.hardware.usb.UsbDeviceConnection r0 = r4.mConnection     // Catch:{ Exception -> 0x0030 }
                android.hardware.usb.UsbDevice r1 = r4.mDevice     // Catch:{ Exception -> 0x0030 }
                r2 = 0
                android.hardware.usb.UsbInterface r1 = r1.getInterface(r2)     // Catch:{ Exception -> 0x0030 }
                r0.releaseInterface(r1)     // Catch:{ Exception -> 0x0030 }
            L_0x0030:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hoho.android.usbserial.driver.ProlificSerialDriver.ProlificSerialPort.closeInt():void");
        }

        public boolean getCD() throws IOException {
            return testStatusFlag(1);
        }

        public boolean getCTS() throws IOException {
            return testStatusFlag(128);
        }

        public EnumSet<UsbSerialPort.ControlLine> getControlLines() throws IOException {
            int status = getStatus();
            EnumSet<UsbSerialPort.ControlLine> noneOf = EnumSet.noneOf(UsbSerialPort.ControlLine.class);
            if ((this.mControlLinesValue & 2) != 0) {
                noneOf.add(UsbSerialPort.ControlLine.RTS);
            }
            if ((status & 128) != 0) {
                noneOf.add(UsbSerialPort.ControlLine.CTS);
            }
            if ((this.mControlLinesValue & 1) != 0) {
                noneOf.add(UsbSerialPort.ControlLine.DTR);
            }
            if ((status & 2) != 0) {
                noneOf.add(UsbSerialPort.ControlLine.DSR);
            }
            if ((status & 1) != 0) {
                noneOf.add(UsbSerialPort.ControlLine.CD);
            }
            if ((status & 8) != 0) {
                noneOf.add(UsbSerialPort.ControlLine.RI);
            }
            return noneOf;
        }

        public boolean getDSR() throws IOException {
            return testStatusFlag(2);
        }

        public boolean getDTR() throws IOException {
            return (this.mControlLinesValue & 1) != 0;
        }

        public UsbSerialDriver getDriver() {
            return ProlificSerialDriver.this;
        }

        public boolean getRI() throws IOException {
            return testStatusFlag(8);
        }

        public boolean getRTS() throws IOException {
            return (this.mControlLinesValue & 2) != 0;
        }

        public EnumSet<UsbSerialPort.ControlLine> getSupportedControlLines() throws IOException {
            return EnumSet.allOf(UsbSerialPort.ControlLine.class);
        }

        public void openInt(UsbDeviceConnection usbDeviceConnection) throws IOException {
            UsbInterface usbInterface = this.mDevice.getInterface(0);
            if (usbDeviceConnection.claimInterface(usbInterface, true)) {
                for (int i2 = 0; i2 < usbInterface.getEndpointCount(); i2++) {
                    UsbEndpoint endpoint = usbInterface.getEndpoint(i2);
                    int address = endpoint.getAddress();
                    if (address == 2) {
                        this.mWriteEndpoint = endpoint;
                    } else if (address == 129) {
                        this.mInterruptEndpoint = endpoint;
                    } else if (address == 131) {
                        this.mReadEndpoint = endpoint;
                    }
                }
                if (this.mDevice.getDeviceClass() == 2) {
                    this.mDeviceType = 1;
                } else {
                    try {
                        if (((byte[]) this.mConnection.getClass().getMethod("getRawDescriptors", new Class[0]).invoke(this.mConnection, new Object[0]))[7] != 64) {
                            if (this.mDevice.getDeviceClass() != 0) {
                                if (this.mDevice.getDeviceClass() != 255) {
                                    Log.w(ProlificSerialDriver.this.TAG, "Could not detect PL2303 subtype, Assuming that it is a HX device");
                                }
                            }
                            this.mDeviceType = 2;
                        }
                        this.mDeviceType = 0;
                    } catch (NoSuchMethodException unused) {
                        Log.w(ProlificSerialDriver.this.TAG, "Method UsbDeviceConnection.getRawDescriptors, required for PL2303 subtype detection, not available! Assuming that it is a HX device");
                        this.mDeviceType = 0;
                    } catch (Exception e2) {
                        Log.e(ProlificSerialDriver.this.TAG, "An unexpected exception occured while trying to detect PL2303 subtype", e2);
                    }
                }
                setControlLines(this.mControlLinesValue);
                resetDevice();
                doBlackMagic();
                return;
            }
            throw new IOException("Error claiming Prolific interface 0");
        }

        public boolean purgeHwBuffers(boolean z2, boolean z3) throws IOException {
            if (z2) {
                vendorOut(8, 0, (byte[]) null);
            }
            if (!z3) {
                return true;
            }
            vendorOut(9, 0, (byte[]) null);
            return true;
        }

        public void setDTR(boolean z2) throws IOException {
            setControlLines(z2 ? this.mControlLinesValue | 1 : this.mControlLinesValue & -2);
        }

        public void setParameters(int i2, int i3, int i4, int i5) throws IOException {
            if (this.mBaudRate != i2 || this.mDataBits != i3 || this.mStopBits != i4 || this.mParity != i5) {
                byte[] bArr = new byte[7];
                if (i2 > 0) {
                    bArr[0] = (byte) (i2 & 255);
                    bArr[1] = (byte) ((i2 >> 8) & 255);
                    bArr[2] = (byte) ((i2 >> 16) & 255);
                    bArr[3] = (byte) ((i2 >> 24) & 255);
                    if (i4 == 1) {
                        bArr[4] = 0;
                    } else if (i4 == 2) {
                        bArr[4] = 2;
                    } else if (i4 == 3) {
                        bArr[4] = 1;
                    } else {
                        throw new IllegalArgumentException("Invalid stop bits: " + i4);
                    }
                    if (i5 == 0) {
                        bArr[5] = 0;
                    } else if (i5 == 1) {
                        bArr[5] = 1;
                    } else if (i5 == 2) {
                        bArr[5] = 2;
                    } else if (i5 == 3) {
                        bArr[5] = 3;
                    } else if (i5 == 4) {
                        bArr[5] = 4;
                    } else {
                        throw new IllegalArgumentException("Invalid parity: " + i5);
                    }
                    if (i3 < 5 || i3 > 8) {
                        throw new IllegalArgumentException("Invalid data bits: " + i3);
                    }
                    bArr[6] = (byte) i3;
                    ctrlOut(32, 0, 0, bArr);
                    resetDevice();
                    this.mBaudRate = i2;
                    this.mDataBits = i3;
                    this.mStopBits = i4;
                    this.mParity = i5;
                    return;
                }
                throw new IllegalArgumentException("Invalid baud rate: " + i2);
            }
        }

        public void setRTS(boolean z2) throws IOException {
            setControlLines(z2 ? this.mControlLinesValue | 2 : this.mControlLinesValue & -3);
        }
    }

    public ProlificSerialDriver(UsbDevice usbDevice) {
        this.mDevice = usbDevice;
        this.mPort = new ProlificSerialPort(usbDevice, 0);
    }

    public static Map<Integer, int[]> getSupportedDevices() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Integer.valueOf(UsbId.VENDOR_PROLIFIC), new int[]{8963});
        return linkedHashMap;
    }

    public UsbDevice getDevice() {
        return this.mDevice;
    }

    public List<UsbSerialPort> getPorts() {
        return Collections.singletonList(this.mPort);
    }
}
