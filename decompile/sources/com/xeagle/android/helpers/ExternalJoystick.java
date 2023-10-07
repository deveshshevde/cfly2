package com.xeagle.android.helpers;

import android.util.Log;
import android.view.InputDevice;

public class ExternalJoystick {
    public void printInputDevicesToLog() {
        int[] deviceIds = InputDevice.getDeviceIds();
        Log.d("DEV", "Found " + deviceIds.length);
        for (int device : deviceIds) {
            InputDevice device2 = InputDevice.getDevice(device);
            Log.d("DEV", "name:" + device2.getName() + " Sources:" + device2.getSources());
        }
    }
}
