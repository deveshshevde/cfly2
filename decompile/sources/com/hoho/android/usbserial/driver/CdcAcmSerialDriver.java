package com.hoho.android.usbserial.driver;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.util.Log;
import com.hoho.android.usbserial.driver.UsbSerialPort;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CdcAcmSerialDriver implements UsbSerialDriver {
    /* access modifiers changed from: private */
    public final String TAG = CdcAcmSerialDriver.class.getSimpleName();
    private final UsbDevice mDevice;
    private final List<UsbSerialPort> mPorts;

    public class CdcAcmSerialPort extends CommonUsbSerialPort {
        private static final int GET_LINE_CODING = 33;
        private static final int SEND_BREAK = 35;
        private static final int SET_CONTROL_LINE_STATE = 34;
        private static final int SET_LINE_CODING = 32;
        private static final int USB_RECIP_INTERFACE = 1;
        private static final int USB_RT_ACM = 33;
        private UsbEndpoint mControlEndpoint;
        private int mControlIndex;
        private UsbInterface mControlInterface;
        private UsbInterface mDataInterface;
        private boolean mDtr = false;
        private boolean mRts = false;

        public CdcAcmSerialPort(UsbDevice usbDevice, int i2) {
            super(usbDevice, i2);
        }

        private void openInterface() throws IOException {
            String access$000 = CdcAcmSerialDriver.this.TAG;
            Log.d(access$000, "claiming interfaces, count=" + this.mDevice.getInterfaceCount());
            this.mControlInterface = null;
            this.mDataInterface = null;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < this.mDevice.getInterfaceCount(); i4++) {
                UsbInterface usbInterface = this.mDevice.getInterface(i4);
                if (usbInterface.getInterfaceClass() == 2) {
                    if (i2 == this.mPortNumber) {
                        this.mControlIndex = i4;
                        this.mControlInterface = usbInterface;
                    }
                    i2++;
                }
                if (usbInterface.getInterfaceClass() == 10) {
                    if (i3 == this.mPortNumber) {
                        this.mDataInterface = usbInterface;
                    }
                    i3++;
                }
            }
            if (this.mControlInterface != null) {
                String access$0002 = CdcAcmSerialDriver.this.TAG;
                Log.d(access$0002, "Control iface=" + this.mControlInterface);
                if (this.mConnection.claimInterface(this.mControlInterface, true)) {
                    UsbEndpoint endpoint = this.mControlInterface.getEndpoint(0);
                    this.mControlEndpoint = endpoint;
                    if (endpoint.getDirection() != 128 || this.mControlEndpoint.getType() != 3) {
                        throw new IOException("Invalid control endpoint");
                    } else if (this.mDataInterface != null) {
                        String access$0003 = CdcAcmSerialDriver.this.TAG;
                        Log.d(access$0003, "data iface=" + this.mDataInterface);
                        if (this.mConnection.claimInterface(this.mDataInterface, true)) {
                            for (int i5 = 0; i5 < this.mDataInterface.getEndpointCount(); i5++) {
                                UsbEndpoint endpoint2 = this.mDataInterface.getEndpoint(i5);
                                if (endpoint2.getDirection() == 128 && endpoint2.getType() == 2) {
                                    this.mReadEndpoint = endpoint2;
                                }
                                if (endpoint2.getDirection() == 0 && endpoint2.getType() == 2) {
                                    this.mWriteEndpoint = endpoint2;
                                }
                            }
                            return;
                        }
                        throw new IOException("Could not claim data interface");
                    } else {
                        throw new IOException("No data interface");
                    }
                } else {
                    throw new IOException("Could not claim control interface");
                }
            } else {
                throw new IOException("No control interface");
            }
        }

        private void openSingleInterface() throws IOException {
            this.mControlIndex = 0;
            this.mControlInterface = this.mDevice.getInterface(0);
            this.mDataInterface = this.mDevice.getInterface(0);
            if (this.mConnection.claimInterface(this.mControlInterface, true)) {
                for (int i2 = 0; i2 < this.mControlInterface.getEndpointCount(); i2++) {
                    UsbEndpoint endpoint = this.mControlInterface.getEndpoint(i2);
                    if (endpoint.getDirection() == 128 && endpoint.getType() == 3) {
                        this.mControlEndpoint = endpoint;
                    } else if (endpoint.getDirection() == 128 && endpoint.getType() == 2) {
                        this.mReadEndpoint = endpoint;
                    } else if (endpoint.getDirection() == 0 && endpoint.getType() == 2) {
                        this.mWriteEndpoint = endpoint;
                    }
                }
                if (this.mControlEndpoint == null) {
                    throw new IOException("No control endpoint");
                }
                return;
            }
            throw new IOException("Could not claim shared control/data interface");
        }

        private int sendAcmControlMessage(int i2, int i3, byte[] bArr) throws IOException {
            int controlTransfer = this.mConnection.controlTransfer(33, i2, i3, this.mControlIndex, bArr, bArr != null ? bArr.length : 0, 5000);
            if (controlTransfer >= 0) {
                return controlTransfer;
            }
            throw new IOException("controlTransfer failed");
        }

        private void setDtrRts() throws IOException {
            sendAcmControlMessage(34, (this.mRts ? (char) 2 : 0) | this.mDtr ? 1 : 0, (byte[]) null);
        }

        /* access modifiers changed from: protected */
        public void closeInt() {
            try {
                this.mConnection.releaseInterface(this.mControlInterface);
                this.mConnection.releaseInterface(this.mDataInterface);
            } catch (Exception unused) {
            }
        }

        public boolean getCD() throws IOException {
            return false;
        }

        public boolean getCTS() throws IOException {
            return false;
        }

        public EnumSet<UsbSerialPort.ControlLine> getControlLines() throws IOException {
            EnumSet<UsbSerialPort.ControlLine> noneOf = EnumSet.noneOf(UsbSerialPort.ControlLine.class);
            if (this.mRts) {
                noneOf.add(UsbSerialPort.ControlLine.RTS);
            }
            if (this.mDtr) {
                noneOf.add(UsbSerialPort.ControlLine.DTR);
            }
            return noneOf;
        }

        public boolean getDSR() throws IOException {
            return false;
        }

        public boolean getDTR() throws IOException {
            return this.mDtr;
        }

        public UsbSerialDriver getDriver() {
            return CdcAcmSerialDriver.this;
        }

        public boolean getRI() throws IOException {
            return false;
        }

        public boolean getRTS() throws IOException {
            return this.mRts;
        }

        public EnumSet<UsbSerialPort.ControlLine> getSupportedControlLines() throws IOException {
            return EnumSet.of(UsbSerialPort.ControlLine.RTS, UsbSerialPort.ControlLine.DTR);
        }

        /* access modifiers changed from: protected */
        public void openInt(UsbDeviceConnection usbDeviceConnection) throws IOException {
            if (this.mPortNumber == -1) {
                Log.d(CdcAcmSerialDriver.this.TAG, "device might be castrated ACM device, trying single interface logic");
                openSingleInterface();
                return;
            }
            Log.d(CdcAcmSerialDriver.this.TAG, "trying default interface logic");
            openInterface();
        }

        public void setDTR(boolean z2) throws IOException {
            this.mDtr = z2;
            setDtrRts();
        }

        public void setParameters(int i2, int i3, int i4, int i5) throws IOException {
            byte b2;
            byte b3;
            if (i2 <= 0) {
                throw new IllegalArgumentException("Invalid baud rate: " + i2);
            } else if (i3 < 5 || i3 > 8) {
                throw new IllegalArgumentException("Invalid data bits: " + i3);
            } else {
                if (i4 == 1) {
                    b2 = 0;
                } else if (i4 == 2) {
                    b2 = 2;
                } else if (i4 == 3) {
                    b2 = 1;
                } else {
                    throw new IllegalArgumentException("Invalid stop bits: " + i4);
                }
                if (i5 == 0) {
                    b3 = 0;
                } else if (i5 == 1) {
                    b3 = 1;
                } else if (i5 == 2) {
                    b3 = 2;
                } else if (i5 == 3) {
                    b3 = 3;
                } else if (i5 == 4) {
                    b3 = 4;
                } else {
                    throw new IllegalArgumentException("Invalid parity: " + i5);
                }
                sendAcmControlMessage(32, 0, new byte[]{(byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255), b2, b3, (byte) i3});
            }
        }

        public void setRTS(boolean z2) throws IOException {
            this.mRts = z2;
            setDtrRts();
        }
    }

    public CdcAcmSerialDriver(UsbDevice usbDevice) {
        this.mDevice = usbDevice;
        this.mPorts = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < usbDevice.getInterfaceCount(); i4++) {
            i2 = usbDevice.getInterface(i4).getInterfaceClass() == 2 ? i2 + 1 : i2;
            if (usbDevice.getInterface(i4).getInterfaceClass() == 10) {
                i3++;
            }
        }
        for (int i5 = 0; i5 < Math.min(i2, i3); i5++) {
            this.mPorts.add(new CdcAcmSerialPort(this.mDevice, i5));
        }
        if (this.mPorts.size() == 0) {
            this.mPorts.add(new CdcAcmSerialPort(this.mDevice, -1));
        }
    }

    public static Map<Integer, int[]> getSupportedDevices() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Integer.valueOf(UsbId.VENDOR_ARDUINO), new int[]{1, 67, 16, 66, 59, 68, 63, 68, UsbId.ARDUINO_LEONARDO, UsbId.ARDUINO_MICRO});
        linkedHashMap.put(Integer.valueOf(UsbId.VENDOR_VAN_OOIJEN_TECH), new int[]{1155});
        linkedHashMap.put(1003, new int[]{8260});
        linkedHashMap.put(Integer.valueOf(UsbId.VENDOR_LEAFLABS), new int[]{4});
        linkedHashMap.put(Integer.valueOf(UsbId.VENDOR_ARM), new int[]{516});
        return linkedHashMap;
    }

    public UsbDevice getDevice() {
        return this.mDevice;
    }

    public List<UsbSerialPort> getPorts() {
        return this.mPorts;
    }
}
