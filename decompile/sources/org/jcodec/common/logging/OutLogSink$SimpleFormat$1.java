package org.jcodec.common.logging;

import java.util.HashMap;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.tools.MainUtils;

class OutLogSink$SimpleFormat$1 extends HashMap<Logger.Level, MainUtils.ANSIColor> {
    OutLogSink$SimpleFormat$1() {
        put(Logger.Level.DEBUG, MainUtils.ANSIColor.BROWN);
        put(Logger.Level.INFO, MainUtils.ANSIColor.GREEN);
        put(Logger.Level.WARN, MainUtils.ANSIColor.MAGENTA);
        put(Logger.Level.ERROR, MainUtils.ANSIColor.RED);
    }
}
