package com.example.tsdmh_7s5_tarea1_lmua;

import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RecibeActivity extends AppCompatActivity {
    private TextView lblresultado;
    private TextView lblEdadResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recibe);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lblresultado = findViewById(R.id.lblresultado);
        lblEdadResultado = findViewById(R.id.lblEdadResultado);

        Bundle datos = getIntent().getExtras();
        if (datos != null) {
            String nombre = datos.getString("nombre");
            String strEdad = datos.getString("edad");

            if (nombre != null && !nombre.trim().isEmpty()) {
                lblresultado.setText(nombre);
            } else {
                lblresultado.setText(getString(R.string.p2SinNombre));
            }

            // Validamos que el usuario haya ingresado un número válido
            if (strEdad != null && !strEdad.trim().isEmpty()) {
                try {
                    int edad = Integer.parseInt(strEdad.trim());

                    if (edad >= 18) {
                        lblEdadResultado.setText(getString(R.string.p2MayorEdad, edad));
                    } else {
                        lblEdadResultado.setText(getString(R.string.p2MenorEdad, edad));
                    }
                } catch (NumberFormatException e) {
                    lblEdadResultado.setText(getString(R.string.p2SinEdad));
                }
            } else {
                lblEdadResultado.setText(getString(R.string.p2SinEdad));
            }
        }
    }
}