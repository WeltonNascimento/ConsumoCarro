package com.example.consumocarro;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool;
    private TextInputEditText editPrecoGasolina;
    private TextView resultado;
    private  TextInputEditText kmAlcool;
    private TextInputEditText kmGasolina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.pAlcool);
        editPrecoGasolina = findViewById(R.id.pGasolina);
        resultado = findViewById(R.id.editResposta);

        kmAlcool = findViewById(R.id.kmLitroAlcool);
        kmGasolina = findViewById( R.id.kmLitroGasolina);
    }

    public void calcular(View view) {
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        String litroAlcool = kmAlcool.getText().toString();
        String litroGasolina = kmGasolina.getText().toString();


        //validar os campos digitados

        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);



        if (camposValidados && camposValidados) {

            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            Double kmLitroAlcool = Double.parseDouble(litroAlcool);
            Double kmLitroGas = Double.parseDouble(litroGasolina);



            Double alcool = ((1/kmLitroAlcool)*valorAlcool);
            Double gasolina = ((1/kmLitroGas)*valorGasolina);



            if ( alcool / gasolina >=0.7 ) {
                resultado.setText("Seu carro faz "+kmLitroGas+"Km/L. Abasteça com GASOLINA");
            } else  {
                resultado.setText("Seu carro faz "+kmLitroAlcool+"Km/L. Abasteça com ALCOOL");
            }

        }
        else {
            resultado.setText("Preencha os campos primeiro");
        }
    }


    public Boolean validarCampos(String pAlcool, String pGasolina) {

        Boolean camposValidados = true;



        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;

        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }

        return camposValidados;



    }




}
