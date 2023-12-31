precision mediump float;

 varying mediump vec2 textureCoordinate;

 uniform sampler2D inputImageTexture;
 uniform sampler2D inputImageTexture2;

uniform float strength;

 void main()
 {
     vec4 originColor = texture2D(inputImageTexture, textureCoordinate);

     vec3 texel = texture2D(inputImageTexture, textureCoordinate).rgb;

     texel = vec3(
                  texture2D(inputImageTexture2, vec2(texel.r, .16666)).r,
                  texture2D(inputImageTexture2, vec2(texel.g, .5)).g,
                  texture2D(inputImageTexture2, vec2(texel.b, .83333)).b);

     texel.rgb = mix(originColor.rgb, texel.rgb, strength);

     gl_FragColor = vec4(texel, 1.0);
 }
