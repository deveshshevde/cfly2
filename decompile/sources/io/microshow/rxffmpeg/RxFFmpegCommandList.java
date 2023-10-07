package io.microshow.rxffmpeg;

import android.util.Log;
import java.util.ArrayList;

public class RxFFmpegCommandList extends ArrayList<String> {
    public RxFFmpegCommandList() {
        add("ffmpeg");
        add("-y");
    }

    public RxFFmpegCommandList append(String str) {
        add(str);
        return this;
    }

    public String[] build() {
        String[] strArr = new String[size()];
        for (int i2 = 0; i2 < size(); i2++) {
            strArr[i2] = (String) get(i2);
        }
        return strArr;
    }

    public String[] build(boolean z2) {
        String[] build = build();
        if (z2) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < build.length; i2++) {
                sb.append(build[i2]);
                if (i2 < build.length - 1) {
                    sb.append(" ");
                }
            }
            Log.e("TAG_FFMPEG", "cmd: " + sb.toString());
        }
        return build;
    }

    public RxFFmpegCommandList clearCommands() {
        clear();
        return this;
    }
}
