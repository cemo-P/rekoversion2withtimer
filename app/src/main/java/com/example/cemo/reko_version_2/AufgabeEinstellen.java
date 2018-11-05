package com.example.cemo.reko_version_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
    static int bis;
    int a=1,b=10, x, y, z, s;
    ArrayList<String> opi = new ArrayList<String>();
    TextView tvZahl1, tvZahl2, tvOperand, tvGleich;
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
        tvZahl1 = (TextView)findViewById(R. id. tvZahl1);
        tvOperand = (TextView)findViewById(R. id. tvOperand);
        tvZahl2 = (TextView)findViewById(R. id. tvZahl2);
        tvGleich = (TextView)findViewById(R. id. tvGleich);
        bisi = (EditText)findViewById(R. id. eTBis);

        starten = (Button)findViewById(R. id. btnStarten);


        Addition.setEnabled(true);
        Multiplikation.setEnabled(true);
        Subtraktion.setEnabled(true);
        Division.setEnabled(true);
        starten.setOnClickListener(this);

       zufal();

        tvZahl1.setText(String.valueOf(x));
        tvZahl2.setText(String.valueOf(y));




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
    public void setBis(){
        EditText bisi =(EditText)findViewById(R.id. eTBis);
        bis = Integer.parseInt(bisi.getText().toString());
    }

    public void zufal(){
        Random zuf = new Random();
        x = zuf.nextInt(b - a)+1;
        y = zuf.nextInt(b -a);
    }


    @Override
    public void onClick(View v) {
        if(Multiplikation.isChecked() || Addition.isChecked()||Subtraktion.isChecked()||Division.isChecked()){
            //Es muss implementiert werden

        }
        else
        {
            Toast.makeText(getApplicationContext(),"Bitte Wählen Sie eine Operand aus", Toast.LENGTH_LONG).show();

        }
    }
}
