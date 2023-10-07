precision mediump float;

varying vec2 textureCoordinate;
varying vec2 textureCoordinate2;

uniform sampler2D inputImageTexture;
uniform sampler2D inputImageTexture2;

uniform float progress;
uniform float ratio;

const vec4 bgcolor = vec4(0.0, 0.0, 0.0, 1.0);

void main()
{
    vec2 uv = textureCoordinate;
    vec2 uv2 = textureCoordinate2;
    vec2 ratio2 = vec2(1.0, 1.0 / ratio);
    float s = pow(2.0 * abs(progress - 0.5), 3.0);
    float dist = length((vec2(uv) - 0.5) * ratio2);

    vec4 base = texture2D(inputImageTexture, uv);
    vec4 overlayer = texture2D(inputImageTexture2, uv2);
    gl_FragColor = mix(progress < 0.5 ? base : overlayer, bgcolor, step(s, dist));
}