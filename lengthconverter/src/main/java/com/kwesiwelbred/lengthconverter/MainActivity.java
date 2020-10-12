package com.kwesiwelbred.lengthconverter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText val;
    TextView ans;
    Spinner from, to;
    Integer positionFrom, positionTO;
    Button convert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // registering the views
        val = findViewById(R.id.val);
        ans = findViewById(R.id.text_res);
        from = findViewById(R.id.from);
        to = findViewById(R.id.to);
        convert = findViewById(R.id.resBtn);

        //the units into arrayList
        List<String> unitlength = new ArrayList<String>();
        unitlength.add("Meter");
        unitlength.add("Centimeter");
        unitlength.add("Kilometer");
        unitlength.add("Miles");
        unitlength.add("Foot");
        unitlength.add("Inches");
        unitlength.add("Yard");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, unitlength);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from.setAdapter(dataAdapter);
        from.setOnItemSelectedListener(this);

        ArrayAdapter<String> unit = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, unitlength);
        unit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        to.setAdapter(unit);
        to.setOnItemSelectedListener(this);

        convert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (val.getText().length() == 0)
                    Toast.makeText(MainActivity.this, "Please enter value", Toast.LENGTH_LONG).show();
                else {
                    method(v);
                }

            }
        });
    }


    /**
     * <p>Callback method to be invoked when an item in this view has been
     * selected. This callback is invoked only when the newly selected
     * position is different from the previously selected position or if
     * there was no selected item.</p>
     * <p>
     * Implementers can call getItemAtPosition(position) if they need to access the
     * data associated with the selected item.
     *
     * @param parent   The AdapterView where the selection happened
     * @param view     The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id       The row id of the item that is selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        parent.getItemAtPosition(position);
        switch (parent.getId()) {
            case R.id.from:
                from.setSelection(position);
                positionFrom = from.getSelectedItemPosition();
                Log.e("from selected position:", String.valueOf(positionFrom));
                break;
            case R.id.to:
                to.setSelection(position);
                positionTO = to.getSelectedItemPosition();
                Log.e("to selected position:", String.valueOf(positionTO));
                break;

        }

    }

    /**
     * Callback method to be invoked when the selection disappears from this
     * view. The selection can disappear for instance when touch is activated
     * or when the adapter becomes empty.
     *
     * @param parent The AdapterView that now contains no selected item.
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void method(View view) {


        double value = Double.parseDouble(val.getText().toString());
        double res;
        double hun = 100;
        Log.e("from value in method", String.valueOf(positionFrom));


        if (positionFrom == 0) {
            if (positionTO == 0) {
                ans.setText(val.getText());
                val.setText("");
            }
            if (positionTO == 1) {
                res = value * hun;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 2) {
                res = value * 1000;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 3) {
                res = value * 0.000621371;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 4) {
                res = value * 3.28084;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 5) {
                res = value * 39.3701;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 6) {
                res = value * 1.09361;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
        }


        if (positionFrom == 1) {
            if (positionTO == 0) {
                res = value / 100;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 1) {
                ans.setText(val.getText());
                val.setText("");
            }
            if (positionTO == 2) {
                res = value / 10000;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 3) {
                res = value * 6.2137e-6;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 4) {
                res = value * 0.0328084;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 5) {
                res = value * 0.393701;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 6) {
                res = value * 0.0109361;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
        }


        if (positionFrom == 2) {
            if (positionTO == 0) {
                res = value * 1000;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 1) {
                res = value * 100000;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 2) {
                ans.setText(val.getText());
                val.setText("");
            }
            if (positionTO == 3) {
                res = value * 0.621371;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 4) {
                res = value * 3280.84;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 5) {
                res = value * 39370.1;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 6) {
                res = value * 1093.61;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
        }


        if (positionFrom == 3) {
            if (positionTO == 0) {
                res = value * 1609.34;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 1) {
                res = value * 160934;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 2) {
                res = value * 1.60934;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 3) {
                ans.setText(val.getText());
                val.setText("");
            }
            if (positionTO == 4) {
                res = value * 5280;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 5) {
                res = value * 63360;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 6) {
                res = value * 1760;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
        }


        if (positionFrom == 4) {
            if (positionTO == 0) {
                res = value * 0.3048;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 1) {
                res = value * 30.48;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 2) {
                res = value * 0.0003048;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 3) {
                res = value * 0.000189394;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 4) {
                ans.setText(val.getText());
                val.setText("");
            }
            if (positionTO == 5) {
                res = value * 12;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 6) {
                res = value * 0.333333;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
        }


        if (positionFrom == 5) {
            if (positionTO == 0) {
                res = value * 0.0254;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 1) {
                res = value * 2.54;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 2) {
                res = value * 2.54e-5;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 3) {
                res = value * 1.5783e-5;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 4) {
                res = value * 0.0833333;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 5) {
                ans.setText(val.getText());
                val.setText("");
            }
            if (positionTO == 6) {
                res = value * 0.0277778;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
        }


        if (positionFrom == 6) {
            if (positionTO == 0) {
                res = value * 0.9144;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 1) {
                res = value * 91.44;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 2) {
                res = value * 0.0009144;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 3) {
                res = value * 0.000568182;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 4) {
                res = value * 3;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 5) {
                res = value * 36;
                ans.setText(String.format(Locale.getDefault(), "%f", res));
            }
            if (positionTO == 6) {
                ans.setText(val.getText());
                val.setText("");
            }

        }
    }

}
