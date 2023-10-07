varying highp vec2 textureCoordinate;

precision highp float;

uniform sampler2D inputImageTexture;
uniform sampler2D curve;

uniform float strength;

void main()
{
	highp vec4 textureColor;
	highp float satVal = 65.0 / 100.0;

	highp float redCurveValue;
	highp float greenCurveValue;
	highp float blueCurveValue;

	highp vec4 sourceColor = texture2D(inputImageTexture, textureCoordinate);

	textureColor = sourceColor;

	satVal = strength;

	redCurveValue = texture2D(curve, vec2(textureColor.r, 0.0)).r;
	greenCurveValue = texture2D(curve, vec2(textureColor.g, 0.0)).g;
	blueCurveValue = texture2D(curve, vec2(textureColor.b, 0.0)).b;
	
	highp float G = (redCurveValue + greenCurveValue + blueCurveValue);
	G = G / 3.0;
	
	redCurveValue = ((1.0 - satVal) * G + satVal * redCurveValue);
	greenCurveValue = ((1.0 - satVal) * G + satVal * greenCurveValue);
	blueCurveValue = ((1.0 - satVal) * G + satVal * blueCurveValue);
	redCurveValue = (((redCurveValue) > (1.0)) ? (1.0) : (((redCurveValue) < (0.0)) ? (0.0) : (redCurveValue)));
	greenCurveValue = (((greenCurveValue) > (1.0)) ? (1.0) : (((greenCurveValue) < (0.0)) ? (0.0) : (greenCurveValue)));
	blueCurveValue = (((blueCurveValue) > (1.0)) ? (1.0) : (((blueCurveValue) < (0.0)) ? (0.0) : (blueCurveValue)));
	
	redCurveValue = texture2D(curve, vec2(redCurveValue, 0.0)).a;
	greenCurveValue = texture2D(curve, vec2(greenCurveValue, 0.0)).a;
	blueCurveValue = texture2D(curve, vec2(blueCurveValue, 0.0)).a;
	
	highp vec4 base = vec4(redCurveValue, greenCurveValue, blueCurveValue, 1.0);
	highp vec4 overlayer = vec4(250.0/255.0, 227.0/255.0, 193.0/255.0, 1.0);
	
	textureColor = overlayer * base;
	base = (textureColor - base) * 0.850980 + base;
	textureColor = base;

	vec4 resultColor = vec4(textureColor.r, textureColor.g, textureColor.b, 1.0);

	gl_FragColor = vec4(mix(sourceColor, resultColor, strength), 1.0);

}
  