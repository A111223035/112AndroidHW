package com.example.calculator_hw;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

enum State {FirstNumberInput, OperatorInputed, NumberInput}
enum OP { None, Add, Sub, Mul, Div}

public class MainActivity extends AppCompatActivity {

    private double theValue = 0;
    private double operand1 = 0, operand2 = 0;
    private OP op = OP.None;
    private State state = State.FirstNumberInput;
    private boolean isDecimal = false;
    private DecimalFormat df = new DecimalFormat("#.##########"); // Adjust the format as per your requirement

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences appSharePrefs = getSharedPreferences("pre_value", MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = appSharePrefs.edit();
        prefsEditor.putString("newItem", Double.toString(theValue));
        prefsEditor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences appSharePrefs = getSharedPreferences("pre_value", MODE_PRIVATE);
        theValue = Double.parseDouble(appSharePrefs.getString("newItem", "0.0"));
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        GridLayout keysGL = findViewById(R.id.keys);

        int kbHeight = keysGL.getHeight() / keysGL.getRowCount();
        int kbWidth = keysGL.getWidth() / keysGL.getColumnCount();

        Log.v("Value", "kbHeight = " + kbHeight);
        Log.v("Value", "kbWidth = " + kbWidth);

        Button btn;

        for (int i = 0; i < keysGL.getChildCount(); i++) {
            btn = (Button) keysGL.getChildAt(i);
            btn.setHeight(kbHeight);
            btn.setWidth(kbWidth);
            btn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
        }

        EditText edt = findViewById(R.id.display);
        edt.setText(df.format(theValue));
    }

    public void processKeyInput(View view) {
        Button b = (Button) view;
        String bstr = b.getText().toString();
        double bdouble;
        EditText edt = findViewById(R.id.display);

        switch (bstr) {
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
                bdouble = Double.parseDouble(bstr);
                if (isDecimal) {
                    String currentText = edt.getText().toString();
                    currentText += bstr;
                    theValue = Double.parseDouble(currentText);
                } else {
                    switch (state) {
                        case FirstNumberInput:
                            theValue = theValue * 10 + bdouble;
                            break;
                        case OperatorInputed:
                            theValue = bdouble;
                            operand2 = bdouble;
                            state = State.NumberInput;
                            break;
                        case NumberInput:
                            theValue = theValue * 10 + bdouble;
                            break;
                    }
                }
                edt.setText(df.format(theValue));
                break;
            case ".":
                if (!isDecimal) {
                    isDecimal = true;
                    String currentText = edt.getText().toString();
                    edt.setText(currentText + ".");
                }
                break;
            case "Clear":
                state = State.FirstNumberInput;
                theValue = 0;
                edt.setText("0");
                op = OP.None;
                operand2 = operand1 = 0;
                isDecimal = false;
                break;
            case "Back":
                String text = edt.getText().toString();
                if (text.length() > 0) {
                    text = text.substring(0, text.length() - 1);
                    if (text.equals("") || text.equals("-")) {
                        theValue = 0;
                        edt.setText("0");
                    } else {
                        theValue = Double.parseDouble(text);
                        edt.setText(text);
                    }
                }
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                isDecimal = false;
                switch (state) {
                    case FirstNumberInput:
                        operand1 = theValue;
                        operand2 = theValue;
                        switch (bstr) {
                            case "+": op = OP.Add; break;
                            case "-": op = OP.Sub; break;
                            case "*": op = OP.Mul; break;
                            case "/": op = OP.Div; break;
                        }
                        state = State.OperatorInputed;
                        break;
                    case OperatorInputed:
                        switch (bstr) {
                            case "+": op = OP.Add; break;
                            case "-": op = OP.Sub; break;
                            case "*": op = OP.Mul; break;
                            case "/": op = OP.Div; break;
                        }
                        operand2 = theValue;
                        break;
                    case NumberInput:
                        operand2 = theValue;
                        switch (op) {
                            case Add: theValue = operand1 + operand2; break;
                            case Sub: theValue = operand1 - operand2; break;
                            case Mul: theValue = operand1 * operand2; break;
                            case Div: theValue = operand1 / operand2; break;
                        }
                        operand1 = theValue;
                        switch (bstr) {
                            case "+": op = OP.Add; break;
                            case "-": op = OP.Sub; break;
                            case "*": op = OP.Mul; break;
                            case "/": op = OP.Div; break;
                        }
                        state = State.OperatorInputed;
                        edt.setText(df.format(theValue));
                        break;
                }
                break;
            case "=":
                isDecimal = false;
                if (state == State.OperatorInputed) {
                    switch (op) {
                        case Add: theValue = operand1 + operand2; break;
                        case Sub: theValue = operand1 - operand2; break;
                        case Mul: theValue = operand1 * operand2; break;
                        case Div: theValue = operand1 / operand2; break;
                    }
                    operand1 = theValue;
                } else if (state == State.NumberInput) {
                    operand2 = theValue;
                    switch (op) {
                        case Add: theValue = operand1 + operand2; break;
                        case Sub: theValue = operand1 - operand2; break;
                        case Mul: theValue = operand1 * operand2; break;
                        case Div: theValue = operand1 / operand2; break;
                    }
                    operand1 = theValue;
                    state = State.OperatorInputed;
                }
                edt.setText(df.format(theValue));
                break;
        }
    }
}
