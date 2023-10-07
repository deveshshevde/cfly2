package cv;

import com.ctoo.mediaedit.R;

public class a extends d {
    public a() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", com.ctoo.mediaedit.filter.a.a(R.raw.blackmask));
    }
}
