package com.example.calculadoraimc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtPeso, edtAltura, edtResultado;
    private Button btnCalcular, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPeso = (EditText) findViewById(R.id.edtpeso);
        edtAltura = (EditText) findViewById(R.id.edtaltura);
        edtResultado = (EditText) findViewById(R.id.edtresutado);
        btnCalcular = (Button) findViewById(R.id.button);
        btnCalcular = (Button) findViewById(R.id.button2);
        //Associar tratador de Eventos
        btnCalcular.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            double peso = Double.parseDouble(edtPeso.getText().toString());
            double altura = Double.parseDouble(edtAltura.getText().toString());
            double resultado = (peso / Math.pow(altura, 2));
            edtResultado.setText(String.format("%.2f", resultado));

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.app_name);
            dlg.setMessage(String.format("IMC= %.2f", resultado));
            dlg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            dlg.show();
        } else if (view.getId() == R.id.button2) {
            edtPeso.setText("");
            edtAltura.setText("");
            edtResultado.setText("");
            edtPeso.requestFocus();
            Toast.makeText(this, "Os dados foram apagados com sucesso!", Toast.LENGTH_LONG).show();
        }
    }
}