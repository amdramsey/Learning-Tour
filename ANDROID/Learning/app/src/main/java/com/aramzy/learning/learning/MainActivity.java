package com.aramzy.learning.learning;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.OutputStreamWriter;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    EditText txt;
    TextView lblFontSize;
    Button btnP;
    Button btnM;
    CheckBox cbx1;
    CheckBox cbx2;
    Spinner spinColor;
    Spinner spinFont;
    RadioButton rdbLtr;
    RadioButton rdbRtl;
    EditText txtFN;
    Button btnN;
    Button btnS;
    Button btnG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (EditText)findViewById(R.id.text);
        lblFontSize = (TextView)findViewById(R.id.lblFontSize);
        btnP = (Button)findViewById(R.id.btnP);
        btnM = (Button)findViewById(R.id.btnM);
        cbx1 = (CheckBox)findViewById(R.id.cbx1);
        cbx2 = (CheckBox)findViewById(R.id.cbx2);
        spinColor = (Spinner)findViewById(R.id.spinColor);
        spinFont = (Spinner)findViewById(R.id.spinFont);
        txtFN = (EditText)findViewById(R.id.txtFN);
        btnN = (Button)findViewById(R.id.btnN);
        btnS = (Button)findViewById(R.id.btnS);
        btnG = (Button)findViewById(R.id.btnG);

        txt.setGravity(Gravity.TOP);

        fillColors();
        fillFonts();

        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPOnClick();
            }
        });


        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnMOnClick();
            }
        });

        cbx1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setBold();
            }
        });

        cbx2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setUnderline();
            }
        });

        spinColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setColor();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinFont.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setFont();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                New();
            }
        });

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });

        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Get();
            }
        });
    }

    protected void fillColors() {
        String[] colors = {
                "Black",
                "Red",
                "Blue",
                "Green",
                "Gray",
                "Orange",
                "Navy",
                "Brown",
                "Pink",
                "Yellow",
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, colors);
        spinColor.setAdapter(adapter);
    }

    protected void fillFonts() {
        String[] fonts = {
                "Sans serif",
                "Arial unicode",
                "Krungthep",
                "Comic sans",
                "Farah_ar",
                "Al Nile_ar",
                "Al tarikh_ar",
                "Al bayan_ar",
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fonts);
        spinFont.setAdapter(adapter);
    }

    protected void btnPOnClick() {
        if(Integer.parseInt(lblFontSize.getText().toString()) >= 50) {
            Toast.makeText(this, "The font must be smaller than 50", Toast.LENGTH_SHORT).show();
        } else {
            int font = Integer.parseInt(lblFontSize.getText().toString());
            font++;
            txt.setTextSize(font);
            lblFontSize.setText(String.valueOf(font));
        }
    }

    public void btnMOnClick() {
        if(Integer.parseInt(lblFontSize.getText().toString()) <= 10) {
            Toast.makeText(this, "The font must be greater than 10", Toast.LENGTH_SHORT).show();
        } else {
            int font = Integer.parseInt(lblFontSize.getText().toString());
            font--;
            txt.setTextSize(font);
            lblFontSize.setText(String.valueOf(font));
        }
    }

    protected void setBold() {
        setFont();
    }

    protected void setUnderline() {
        if(cbx2.isChecked()) {
            txt.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        } else {
            txt.setPaintFlags(Paint.LINEAR_TEXT_FLAG);
        }
        setBold();
    }

    protected void setColor() {
        String color = spinColor.getSelectedItem().toString();
        switch (color) {
            case "Black":
                txt.setTextColor(getResources().getColor(R.color.Black));
                break;
            case "Red":
                txt.setTextColor(getResources().getColor(R.color.Red));
                break;
            case "Blue":
                txt.setTextColor(getResources().getColor(R.color.Blue));
                break;
            case "Green":
                txt.setTextColor(getResources().getColor(R.color.Green));
                break;
            case "Gray":
                txt.setTextColor(getResources().getColor(R.color.Gray));
                break;
            case "Orange":
                txt.setTextColor(getResources().getColor(R.color.Orange));
                break;
            case "Navy":
                txt.setTextColor(getResources().getColor(R.color.Navy));
                break;
            case "Brown":
                txt.setTextColor(getResources().getColor(R.color.Brown));
                break;
            case "Pink":
                txt.setTextColor(getResources().getColor(R.color.Pink));
                break;
            case "Yellow":
                txt.setTextColor(getResources().getColor(R.color.Yellow));
                break;
            default:
                Toast.makeText(this, "Please select a color", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    protected void setFont() {
        String font = spinFont.getSelectedItem().toString();
        Typeface tf;
        switch (font) {
            case "Sans serif":
                tf = Typeface.SANS_SERIF;
                break;
            case "Krungthep":
                tf = Typeface.createFromAsset(getAssets(), "Krungthep.ttf");
                break;
            case "Comic sans":
                tf = Typeface.createFromAsset(getAssets(), "Comic Sans MS.ttf");
                break;
            case "Arial unicode":
                tf = Typeface.createFromAsset(getAssets(), "Arial Unicode.ttf");
                break;
            case "Farah_ar":
                tf = Typeface.createFromAsset(getAssets(), "Farah_ar.ttc");
                break;
            case "Al Nile_ar":
                tf = Typeface.createFromAsset(getAssets(), "Al Nile_ar.ttc");
                break;
            case "Al tarikh_ar":
                tf = Typeface.createFromAsset(getAssets(), "Al Tarikh_ar.ttc");
                break;
            case "Al bayan_ar":
                tf = Typeface.createFromAsset(getAssets(), "AlBayan_ar.ttc");
                break;
            default:
                Toast.makeText(this, "Please select a font", Toast.LENGTH_SHORT).show();
                tf = Typeface.SANS_SERIF;
                break;
        }
        if(cbx1.isChecked()) {
            txt.setTypeface(tf, Typeface.BOLD);
        } else {
            txt.setTypeface(tf, Typeface.NORMAL);
        }
    }

    protected void New() {
        txt.setText("");
        txt.setTextSize(14);
        lblFontSize.setText("14");

        cbx1.setChecked(false);
        cbx2.setChecked(false);

        spinColor.setSelection(0);
        spinFont.setSelection(0);

        txtFN.setText("");

        txt.requestFocus();
    }

    protected void Save() {}
    protected void Get() {}
}