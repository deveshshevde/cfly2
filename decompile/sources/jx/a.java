package jx;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.flypro.core.parameters.Parameter;
import com.flypro.core.parameters.ParameterMetadata;
import com.xeagle.android.widgets.adapterViews.ParamsAdapterItem;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

public class a {
    public static AlertDialog a(ParamsAdapterItem paramsAdapterItem, EditText editText, Context context) {
        View a2 = a(paramsAdapterItem, context);
        AlertDialog create = new AlertDialog.Builder(context).setView(a2).create();
        a(create, a2, paramsAdapterItem.b(), editText, context);
        return create;
    }

    private static View a(ParamsAdapterItem paramsAdapterItem, Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_parameters_info, (ViewGroup) null);
        ParameterMetadata b2 = paramsAdapterItem.b();
        a(inflate, (int) R.id.displayNameView, b2.b());
        a(inflate, (int) R.id.nameView, b2.a());
        a(inflate, (int) R.id.descView, b2.c());
        a(inflate, R.id.unitsLayout, R.id.unitsView, b2.d());
        a(inflate, R.id.rangeLayout, R.id.rangeView, a(b2.e()));
        a(inflate, R.id.valuesLayout, R.id.valuesView, b2.f());
        return inflate;
    }

    private static String a(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] split = str.split(" ");
        if (split.length != 2) {
            return str;
        }
        return split[0] + "  /  " + split[1];
    }

    private static void a(final DialogInterface dialogInterface, View view, ParameterMetadata parameterMetadata, final EditText editText, Context context) {
        if (parameterMetadata.f() != null) {
            try {
                Map<Double, String> i2 = parameterMetadata.i();
                final ArrayList arrayList = new ArrayList(i2.keySet());
                ArrayList arrayList2 = new ArrayList();
                final DecimalFormat b2 = Parameter.b();
                double doubleValue = b2.parse(editText.getText().toString()).doubleValue();
                int indexOf = arrayList.indexOf(Double.valueOf(doubleValue));
                if (indexOf == -1) {
                    arrayList.add(0, Double.valueOf(doubleValue));
                    arrayList2.add(String.format("%s: %s", new Object[]{b2.format(doubleValue), context.getResources().getString(R.string.metadata_custom_value)}));
                    indexOf = 0;
                }
                for (Map.Entry next : i2.entrySet()) {
                    arrayList2.add(String.format("%s: %s", new Object[]{b2.format(next.getKey()), next.getValue()}));
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.spinner_param_value_item, arrayList2);
                arrayAdapter.setDropDownViewResource(17367049);
                Spinner spinner = (Spinner) view.findViewById(R.id.valueSpinner);
                spinner.setAdapter(arrayAdapter);
                spinner.setSelection(indexOf);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    /* renamed from: a  reason: collision with root package name */
                    boolean f29836a = true;

                    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
                        editText.setText(b2.format(arrayList.get(i2)));
                        if (this.f29836a) {
                            this.f29836a = false;
                        } else {
                            dialogInterface.dismiss();
                        }
                    }

                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });
            } catch (Exception unused) {
                view.findViewById(R.id.valueSpinnerView).setVisibility(8);
                view.findViewById(R.id.valueTextView).setVisibility(0);
            }
        }
    }

    private static void a(View view, int i2, int i3, String str) {
        if (str != null) {
            ((TextView) view.findViewById(i3)).setText(str);
        } else {
            view.findViewById(i2).setVisibility(8);
        }
    }

    private static void a(View view, int i2, String str) {
        TextView textView = (TextView) view.findViewById(i2);
        if (str != null) {
            textView.setText(str);
        } else {
            textView.setVisibility(8);
        }
    }
}
