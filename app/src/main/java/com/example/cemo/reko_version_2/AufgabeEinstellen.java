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

public class AufgabeEinstellen extends Activity {
    CheckBox Multiplikation, Addition, Division,Subtraktion;
    int a=1,b=10, x, y, z, s=10, c, operand, eingabe, punkt = 0;
    ArrayList<String> opi = new ArrayList<String>();
    int laenger = opi.size();
    TextView tvZahl1, tvZahl2, tvOperand, tvGleich, tvTimer, tvPunkte;
    Button starten;
    EditText bisi;
    boolean checked;
    String g;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aufgabe_einstellen);


        Addition = findViewById(R. id. cBAddition);
        Multiplikation = findViewById(R. id. cBMultiplikation);
        Subtraktion= findViewById(R. id. cBSubtraktion);
        Division = findViewById(R. id. cBDivision);
        tvOperand = findViewById(R. id. tvOperand);
        tvPunkte =findViewById(R. id.tvPunkt);



        tvTimer = findViewById(R. id. tvTimer);
        tvGleich = findViewById(R. id. tvGleich);
        bisi = findViewById(R. id. eTBis);

        starten = findViewById(R. id. btnStarten);


        Addition.setEnabled(true);
        Multiplikation.setEnabled(true);
        Subtraktion.setEnabled(true);
        Division.setEnabled(true);


    }

    public void setBis(){ //eingabe für die Obergrenze
        EditText bisi =(EditText)findViewById(R.id. eTBis);
        b = Integer.parseInt(bisi.getText().toString());
        bisi.setText(String.valueOf(b));


    }
    public void ergPruf(){  //muss ber erarbeitet werden
        EditText erPruf = (EditText)findViewById(R. id. etErgebnis);
        eingabe = Integer.parseInt(erPruf.getText().toString());

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
         c = opi.size();
    }
    public void zufal(){ //zufallszahlgenerator
        Random zuf = new Random();

        x = zuf.nextInt(b - a)+1;
        y = zuf.nextInt(b -a);

        tvZahl1 = (TextView)findViewById(R. id. tvZahl1);
        tvZahl1.setText(String.valueOf(x));

        tvZahl2 = (TextView)findViewById(R. id. tvZahl2);
        tvZahl2.setText(String.valueOf(y));
        operand = zuf.nextInt(c);
        if(operand == 0){
            z = x + y;
            tvOperand.setText("+");


        }else if(operand==1){
            z = x * y;
            tvOperand.setText("*");

        }else if(operand == 2){
            z = x - y;
            tvOperand.setText("-");

        }else if(operand == 3){
            z = x / y;
            tvOperand.setText("/");
        }
        if(z == eingabe) {
            punkt++;
        }
        tvPunkte.setText(String.valueOf(punkt));

    }
    public void onClick(View v) { //Button aktivierung

        setBis();
        zufal();


        /*Timer start und stop*/
        if(Multiplikation.isChecked() || Addition.isChecked()||Subtraktion.isChecked()||Division.isChecked()){
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

}
