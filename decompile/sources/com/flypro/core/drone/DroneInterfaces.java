package com.flypro.core.drone;

import com.flypro.core.MAVLink.WaypointManager;
import com.flypro.core.parameters.Parameter;
import java.util.List;

public class DroneInterfaces {

    public interface a {
        long a();
    }

    public interface b {
        void post(Runnable runnable);

        void postDelayed(Runnable runnable, long j2);

        void removeCallbacks(Runnable runnable);
    }

    public interface c {
        void onDroneEvent(DroneEventsType droneEventsType, en.a aVar);
    }

    public interface d {
        void a();

        void a(Parameter parameter, int i2, int i3);

        void a(List<Parameter> list);
    }

    public interface e {
        void notifyTimeOut(int i2);
    }

    public enum DroneEventsType {
        ORIENTATION,
        SPEED,
        BATTERY,
        GUIDEDPOINT,
        NAVIGATION,
        ATTITUDE,
        RADIO,
        RC_IN,
        RC_OUT,
        ARMING,
        AUTOPILOT_WARNING,
        MODE,
        STATE,
        MISSION_UPDATE,
        MISSION_RECEIVED,
        TYPE,
        HOME,
        GPS,
        GPS_FIX,
        GPS_COUNT,
        PARAMETER,
        CALIBRATION_IMU,
        CALIBRATION_TIMEOUT,
        HEARTBEAT_TIMEOUT,
        HEARTBEAT_FIRST,
        HEARTBEAT_RESTORED,
        DISCONNECTED,
        CONNECTED,
        MISSION_SENT,
        ARMING_STARTED,
        INVALID_POLYGON,
        MISSION_WP_UPDATE,
        FOLLOW_START,
        FOLLOW_STOP,
        FOLLOW_UPDATE,
        FOLLOW_CHANGE_TYPE,
        FOLLOW_TYPE_UPDATE,
        PARAMETERS_DOWNLOADED,
        WARNING_400FT_EXCEEDED,
        WARNING_SIGNAL_WEAK,
        FIRMWARE,
        WARNING_NO_GPS,
        MAGNETOMETER,
        FOOTPRINT,
        REMOTE_SIGNAL,
        REMOTE_SET,
        RC_CONTROL,
        PLAY_START,
        PLAY_PROGRESS,
        PLAY_END,
        RECORD_START,
        RECORD_END,
        CAL_IMU,
        TAKE_OFF,
        LAND_FINISH,
        RTL_FINISH,
        HDOP_VALUE,
        SPEED_CHANGE,
        YAW_CHANGE,
        UPDATE_LOG,
        UPDATE_IMU1,
        MISSION_RESULT,
        WAYPOINT_REACHED,
        MISSION_UPLOAD_TIMEOUT,
        MISSION_COUNT,
        UPDATE_FIRMWARE,
        RECEIVE_FAILED,
        RECEIVE_HEARTBEAT,
        BOOT_VERSION,
        VIBRATION
    }

    public interface f {
        void a(WaypointManager.WaypointEvent_Type waypointEvent_Type);

        void a(WaypointManager.WaypointEvent_Type waypointEvent_Type, int i2, int i3);
    }
}
