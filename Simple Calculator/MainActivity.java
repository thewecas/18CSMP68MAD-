package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
TextView op;
String s1="",s2="",c="",res="";
int flag=0,dflag=0,fflag=0,rflag=0;
float result=0,f1,f2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btnDot).setOnClickListener(this);
        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnSub).setOnClickListener(this);
        findViewById(R.id.btnMul).setOnClickListener(this);
        findViewById(R.id.btnDiv).setOnClickListener(this);
        findViewById(R.id.btnEq).setOnClickListener(this);
        findViewById(R.id.btnClr).setOnClickListener(this);
        findViewById(R.id.btn0).setOnClickListener(this);

        op=findViewById(R.id.display);

        }

    @Override
    public void onClick(View view) {

        if(rflag==1) {
           clear();
            rflag=0;
        }

        switch (view.getId()){
            case R.id.btn0:
                if(flag==0)
                    s1+="0";
                else
                    s2+="0";
                break;
            case R.id.btn1:
                if(flag==0)
                    s1+="1";
                else
                    s2+="1";
                break;
            case R.id.btn2:
                if(flag==0)
                    s1+="2";
                else
                    s2+="2";
                break;
            case R.id.btn3:
                if(flag==0)
                    s1+="3";
                else
                    s2+="3";
                break;
            case R.id.btn4:
                if(flag==0)
                    s1+="4";
                else
                    s2+="4";
                break;
            case R.id.btn5:
                if(flag==0)
                    s1+="5";
                else
                    s2+="5";
                break;
            case R.id.btn6:
                if(flag==0)
                    s1+="6";
                else
                    s2+="6";
                break;
            case R.id.btn7:
                if(flag==0)
                    s1+="7";
                else
                    s2+="7";
                break;
            case R.id.btn8:
                if(flag==0)
                    s1+="8";
                else
                    s2+="8";
                break;
            case R.id.btn9:
                if(flag==0)
                    s1+="9";
                else
                    s2+="9";
                break;
            case R.id.btnDot:
                if(flag==0 && dflag==0) {
                    s1 += ".";
                    dflag=1;
                    fflag=1;
                }
                else if(flag==1 && dflag==0) {
                    s2 += ".";
                    dflag=1;
                    fflag=2;
                }
                break;
            case R.id.btnAdd:
                if(flag==0) {
                    c="+";
                    flag=1;
                    dflag=0;
                }
                break;
            case R.id.btnSub:
                if(flag==0) {
                    c="-";
                    flag=1;
                    dflag=0;
                }
                break;
            case R.id.btnMul:
                if(flag==0) {
                    c="*";
                    flag=1;
                    dflag=0;
                }
                break;
            case R.id.btnDiv:
                if(flag==0) {
                    c="/";
                    flag=1;
                    dflag=0;
                }
                break;
            case R.id.btnClr:
                clear();
                break;
            case R.id.btnEq:
                res=" = "+calculate();
                rflag=1;
                break;
    }
    op.setText(s1 + " " + c + " " + s2+res);
}
    private String calculate() {

        try {
            f1=(float)Integer.parseInt(s1);
        }
        catch(NumberFormatException e){
            f1=Float.parseFloat(s1);
        }
        try {
            f2=(float) Integer.parseInt(s2);
        }
        catch(NumberFormatException e){
            f2=Float.parseFloat(s2);
        }

        switch (c){
            case "+":
                result=f1+f2;
                break;
            case "-":
                result=f1-f2;
                break;
            case "*":
                result=f1*f2;
                break;
            case "/":
                if(f2==0.0)
                    result=0;
                else
                    result=f1+f2;
                break;
        }

        String s;
        if(fflag>0)
            s=Float.toString(result);
        else
            s=Integer.toString((int)result);
        //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
        return s;
    }

    private void clear(){
        s1="";
        s2="";
        c="";
        res="";
        flag=0;
        dflag=0;
    }




}
