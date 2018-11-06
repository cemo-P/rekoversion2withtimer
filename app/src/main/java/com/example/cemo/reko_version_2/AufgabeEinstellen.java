package com.example.cemo.reko_version_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.CheckBoxPreference;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class AufgabeEinstellen extends Activity implements View.OnClickListener {
    CheckBox Multiplikation, Addition, Division,Subtraktion;
    int a=1,b=10, x, y, z, s=10, operand;
    ArrayList<String> opi = new ArrayList<String>();
    int laenger = opi.size();
    TextView tvZahl1, tvZahl2, tvOperand, tvGleich, tvTimer;
    Button starten;
    EditText bisi;
    boolean checked;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aufgabe_einstellen);


        Addition = (CheckBox)findViewById(R. id. cBAddition);
        Multiplikation = (CheckBox)findViewById(R. id. cBMultiplikation);
        Subtraktion= (CheckBox)findViewById(R. id. cBSubtraktion);
        Division = (CheckBox)findViewById(R. id. cBDivision);


        tvTimer = findViewById(R. id. tvTimer);
        tvGleich = (TextView)findViewById(R. id. tvGleich);
        bisi = findViewById(R. id. eTBis);

        starten = (Button)findViewById(R. id. btnStarten);


        Addition.setEnabled(true);
        Multiplikation.setEnabled(true);
        Subtraktion.setEnabled(true);
        Division.setEnabled(true);
        starten.setOnClickListener(this);


       //zufal();

        //
        // tvZahl1.setText(String.valueOf(x));







    }

    public void setBis(){
        EditText bisi =(EditText)findViewById(R.id. eTBis);
        b = Integer.parseInt(bisi.getText().toString());
        bisi.setText(String.valueOf(b));
    }
    public void zufal(){
        Random zuf = new Random();

        x = zuf.nextInt(b - a)+1;
        y = zuf.nextInt(b -a);
        operand = zuf.nextInt(4);
        tvZahl1 = (TextView)findViewById(R. id. tvZahl1);
        tvZahl1.setText(String.valueOf(x));
        tvOperand = (TextView)findViewById(R. id. tvOperand);
        tvZahl2 = (TextView)findViewById(R. id. tvZahl2);
        tvZahl2.setText(String.valueOf(y));
        if(operand == 0){
            tvOperand.setText("+");
        }else if(operand==1){
            tvOperand.setText("*");
        }else if(operand == 2){
            tvOperand.setText("-");
        }else if(operand == 3){
            tvOperand.setText("/");

        }


    }

    @Override
    public void onClick(View v) {
        if(Multiplikation.isChecked() || Addition.isChecked()||Subtraktion.isChecked()||Division.isChecked()){
            if(Multiplikation.isChecked()){
                opi.add("*");

            }else if(Addition.isChecked()){
                opi.add("+");

            }else if(Subtraktion.isChecked()){
                opi.add("-");

            }else if(Division.isChecked()){
                opi.add("/");

            }else if(!Multiplikation.isChecked()){
                opi.remove("*");
            }else if(!Addition.isChecked()){
                opi.remove("+");
            }else if(!Subtraktion.isChecked()){
                opi.remove("-");
            }else if(!Division.isChecked()){
                opi.remove("/");
            }
            setBis();
            zufal();

            new CountDownTimer(10_000, 1_000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    tvTimer.setText(String.valueOf(s));
                    s--;

                }

                @Override
                public void onFinish() {

                    s = 10;
                    tvTimer.setText("Zeit ist abgelaufen");
                }
            }.start();
            //Es muss implementiert werden

        }
        else
        {
            Toast.makeText(getApplicationContext(),"Bitte Wählen Sie eine Operand aus", Toast.LENGTH_LONG).show();

        }
    }



    public void SelectItem(View view) {
        checked = ((CheckBox) view).isChecked();

        switch (view.getId()){
            case R. id. cBAddition:
                if(checked){
                    opi.add("+");
                }
                else{
                    opi.remove("+");
                }
                break;
            case R. id. cBMultiplikation:
                if(checked){
                    opi.add("*");
                }
                else{
                    opi.remove("*");
                }
                break;
            case R. id. cBSubtraktion:
                if(checked){
                    opi.add("-");
                }
                else{
                    opi.remove("-");
                }
                break;
            case R. id. cBDivision:
                if(checked){
                    opi.add("/");
                }
                else{
                    opi.remove("/");
                }
                break;

        }

    }
}
