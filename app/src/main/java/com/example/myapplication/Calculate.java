package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;


public class Calculate extends AppCompatActivity {
    String input="",output="";
    TextView txtinput,txtoutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        txtinput=findViewById(R.id.txtinput);
        txtoutput=findViewById(R.id.txtoutput);
    }
    public void InputButtononClick(View v)
    {

        Button btn = (Button) v;
        if(btn.getId()==R.id.btn_equal)
        //if(btn.getText()=="=")
        {
            Solve();
            txtinput.setText("");
        }
        else if(btn.getId()==R.id.btn_Back)
        {
            input=input.substring(0,input.length()-2);
            txtinput.setText(input);
        }
        else if(btn.getId()==R.id.btn_Multiply)
        {
            input +="*";
            txtinput.setText(input);
        }
        else if(btn.getId()==R.id.btn_Minus ||btn.getId()==R.id.btn_plus
                ||btn.getId()==R.id.btn_Multiply ||btn.getId()==R.id.btn_Div ||btn.getId()==R.id.btn_Dot)
        {
            char lastindexchar=input.charAt(input.length()-1);
            if(lastindexchar!='+' && lastindexchar!='-' && lastindexchar!='*' &&lastindexchar!='/'&& lastindexchar!='.')
            {
                input+=btn.getText();
                txtoutput.setText("");
            }
            txtoutput.setText("");
        }
        else if(btn.getId()==R.id.btn_cancel)
        {
            input+="";
            txtinput.setText("");
            txtoutput.setText("");
        }
        else {
            input += btn.getText();
            txtinput.setText(input);
        }
    }
    //method to solve the expression
    public void Solve()
    {
        Expression ex=new Expression(input);
        double result=ex.calculate();
        txtoutput.setText(String.valueOf(result));

    }
}