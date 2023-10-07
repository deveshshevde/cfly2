package com.flypro.core.parameters;

import com.MAVLink.common.msg_param_value;
import fg.i;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Objects;

public class Parameter implements Serializable, Comparable<Parameter> {

    /* renamed from: d  reason: collision with root package name */
    private static final DecimalFormat f14454d;
    private static final long serialVersionUID = -8773105020863165335L;

    /* renamed from: a  reason: collision with root package name */
    public String f14455a;

    /* renamed from: b  reason: collision with root package name */
    public double f14456b;

    /* renamed from: c  reason: collision with root package name */
    public int f14457c;

    static {
        DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance();
        f14454d = decimalFormat;
        decimalFormat.applyPattern("0.###");
    }

    public Parameter(msg_param_value msg_param_value) {
        this(msg_param_value.a(), (double) msg_param_value.f7016d, msg_param_value.f7020h);
    }

    public Parameter(String str) {
        this(str, i.f27244a, 0);
    }

    public Parameter(String str, double d2, int i2) {
        this.f14455a = str;
        this.f14456b = d2;
        this.f14457c = i2;
    }

    public Parameter(String str, Double d2) {
        this(str, d2.doubleValue(), 0);
    }

    public static void a(String str) throws Exception {
        if (str.equals("SYSID_SW_MREV")) {
            throw new Exception("ExludedName");
        } else if (str.contains("WP_TOTAL")) {
            throw new Exception("ExludedName");
        } else if (str.contains("CMD_TOTAL")) {
            throw new Exception("ExludedName");
        } else if (str.contains("FENCE_TOTAL")) {
            throw new Exception("ExludedName");
        } else if (str.contains("SYS_NUM_RESETS")) {
            throw new Exception("ExludedName");
        } else if (str.contains("ARSPD_OFFSET")) {
            throw new Exception("ExludedName");
        } else if (str.contains("GND_ABS_PRESS")) {
            throw new Exception("ExludedName");
        } else if (str.contains("GND_TEMP")) {
            throw new Exception("ExludedName");
        } else if (str.contains("CMD_INDEX")) {
            throw new Exception("ExludedName");
        } else if (str.contains("LOG_LASTFILE")) {
            throw new Exception("ExludedName");
        } else if (str.contains("FORMAT_VERSION")) {
            throw new Exception("ExludedName");
        }
    }

    public static DecimalFormat b() {
        return f14454d;
    }

    /* renamed from: a */
    public int compareTo(Parameter parameter) {
        return this.f14455a.compareTo(parameter.f14455a);
    }

    public String a() {
        return f14454d.format(this.f14456b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Parameter)) {
            return false;
        }
        return Objects.equals(this.f14455a, ((Parameter) obj).f14455a);
    }

    public int hashCode() {
        String str = this.f14455a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
