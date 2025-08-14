package com.cursoandroid.alcoolougasolina;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText precoAlcool, precoGasolina;
    private TextView resultado;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        precoAlcool = findViewById(R.id.PrecoAlcool);
        precoGasolina = findViewById(R.id.PrecoGasolina);
        resultado = findViewById(R.id.Resultado);





    }



    public void calcularMelhorPreco(View view){
        String valorGasolina = precoGasolina.getText().toString().replace(",", ".");
        String valorAlcool = precoAlcool.getText().toString().replace(",", ".");


        //recuperar valores digitados
        double valorGasolinaDouble = Double.parseDouble(valorGasolina);
        double valorAlcoolDouble = Double.parseDouble(valorAlcool);




        //validar os campos digitados
        boolean camposValidados = validarCompos(valorAlcool, valorGasolina);
        if(camposValidados){
            double porcentagemGasolina = valorGasolinaDouble * 0.70;


            if(porcentagemGasolina <= valorAlcoolDouble){
                resultado.setText("Melhor utilizar Álcool");
            }
            else{
                resultado.setText("Melhor utilizar Gasolina");
            }
        }
        else{
            resultado.setText("Preencha os campos corretamente!");
        }



    }

    public boolean validarCompos(String valorAlcool, String valorGasolina){

        boolean camposValidados = true;

        if(valorGasolina == null || valorGasolina.isEmpty()){
            camposValidados = false;
        }
        if(valorAlcool == null || valorAlcool.isEmpty()){
            camposValidados = false;
        }

        return camposValidados;
    }


}