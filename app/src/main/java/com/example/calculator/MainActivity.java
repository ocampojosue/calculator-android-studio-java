package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvScreen;
    boolean isNewOp = true;
    String number, op = "+", oldNumber = "", newNumber = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvScreen = findViewById(R.id.tvScreen);
    }
    //Este evento se dispara al presionar las teclas de los numeros, almcenando su valor en una variable para que se muestre al usuario/
    public void numberEvent(View view) {
        if (isNewOp)
            tvScreen.setText("");
        isNewOp = false;
        number = tvScreen.getText().toString();
        switch (view.getId()){
            case R.id.btn1:
                number += "1";
                break;
            case R.id.btn2:
                number += "2";
                break;
            case R.id.btn3:
                number += "3";
                break;
            case R.id.btn4:
                number += "4";
                break;
            case R.id.btn5:
                number += "5";
                break;
            case R.id.btn6:
                number += "6";
                break;
            case R.id.btn7:
                number += "7";
                break;
            case R.id.btn8:
                number += "8";
                break;
            case R.id.btn9:
                number += "9";
                break;
            case R.id.btn0:
                number += "0";
                break;
            case R.id.btnPoint:
                number += ".";
                break;
            case R.id.btnAddSubstrate:
                number = "-" + number;
                break;
            case R.id.btnAC:
                number = "0";
                isNewOp = true;
                break;
        }
        tvScreen.setText(number);
    }
    //Este evento se dispara al presionar el signo de cualquier operación, sea: +, -, * /
    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = tvScreen.getText().toString();
        switch (view.getId()){
            case R.id.btnAdd:
                op = "+";
                break;
            case R.id.btnSubstrate:
                op = "-";
                break;
            case R.id.btnMultiply:
                op = "*";
                break;
            case R.id.btnDivide:
                op = "/";
                break;
        }
    }

    //Este evento se dispara al presionar la tecla de igual para sacar el resultado/
    public void equalsEvent(View view) {
        newNumber = tvScreen.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        tvScreen.setText(result + "");
    }
    //Este evento se dispara al presionar el signo de "%" para sacar el porcentaje/
    public void percentEvent(View view) {
        Double no = Double.parseDouble(tvScreen.getText().toString())/100;
        tvScreen.setText(no + "");
        isNewOp = true;
    }
}