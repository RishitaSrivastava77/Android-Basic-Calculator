package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void AddNumber(View v){
        EditText et1,et2;
        et1=findViewById(R.id.et_num1);
        et2=findViewById(R.id.et_num2);
        int num1,num2;
        num1=Integer.parseInt(et1.getText().toString());
        num2=Integer.parseInt(et2.getText().toString());
        //let's get reference of TextView--
        TextView tv_result=findViewById(R.id.tv_result);
        tv_result.setText("Result ="+(num1+num2));

        Toast.makeText(this,"Result ="+(num1+num2),Toast.LENGTH_LONG).show();
    }
    public void GoToCalculator(View v){
        Intent in=new Intent(this, Calculate.class);
        startActivity(in);
    }
}