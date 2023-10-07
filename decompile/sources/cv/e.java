package cv;

import com.ctoo.mediaedit.R;
import com.ctoo.mediaedit.filter.a;

public class e extends d {
    public e() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", a.a(R.raw.whitemask));
    }
}
