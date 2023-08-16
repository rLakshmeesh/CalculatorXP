package com.laksh.calculatorxp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//private TextView text;

    TextView tvInput = null;
    Button clrBtn,btndot,btndiv,btnsub,btnadd,btnmul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInput = findViewById(R.id.tvInput);
        clrBtn = findViewById(R.id.clrBtn);
        btndot=findViewById(R.id.btndot);
        btndiv=findViewById(R.id.btndiv);
        btnsub=findViewById(R.id.btnsub);
        btnadd=findViewById(R.id.btnadd);
        btnmul=findViewById(R.id.btnmul);
    }

    public void onDigit(View view) {
        Button v = (Button) view;
                   if (v!=clrBtn){
                       String text = v.getText().toString();
                       tvInput.append(text);
                    }
                   else {
                       tvInput.setText("");
                   }

    }
    public void onChar(View view){
        Button v = (Button) view;
        String expression = tvInput.getText().toString();

        if (v == btnadd || v == btnsub || v == btnmul || v == btndiv) {
            tvInput.append(v.getText().toString());
        }

    }
public void onEqual(View view) {
    String expression = tvInput.getText().toString();
    if (expression.contains("+")){
        String[] number=expression.split("\\+");
        String num1=number[0];
        String num2=number[1];
        Double numb1=Double.valueOf(num1);
        Double numb2=Double.valueOf(num2);
        Double add=numb1+numb2;
        tvInput.setText(String.valueOf(add));

    }
    else if (expression.contains("-")){
        String[] number=expression.split("-");
        String num3=number[0];
        String num4=number[1];
        Double numb3=Double.valueOf(num3);
        Double numb4=Double.valueOf(num4);
        Double sub=numb3-numb4;
        tvInput.setText(String.valueOf(sub));

    }
else if (expression.contains("/")){
        String[] number=expression.split("/");
        String num7=number[0];
        String num8=number[1];
        Double numb7=Double.valueOf(num7);
        Double numb8=Double.valueOf(num8);
       if (numb8 != 0) {
            double div = numb7 / numb8;
            tvInput.setText(String.valueOf(div));
        } else {
            tvInput.setText("Error: Division by zero");
        }
    }
    else {
        String[] number=expression.split("\\*");
        String num5=number[0];
        String num6=number[1];
        Double numb5=Double.valueOf(num5);
        Double numb6=Double.valueOf(num6);
        Double mul=numb5*numb6;
        tvInput.setText(String.valueOf(mul));

    }

   }
}
