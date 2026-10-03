package com.example.tsdmh_7s5_tarea1_lmua;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrincipalActivity extends AppCompatActivity {
    private EditText txtnombre;
    private EditText txtedad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtnombre = findViewById(R.id.txtNombre);
        txtedad = findViewById(R.id.txtEdad);
    }

    public void Btn1click(View v) {
        String nombre = txtnombre.getText().toString().trim();
        String edadStr = txtedad.getText().toString().trim();

        if (nombre.isEmpty()) {
            txtnombre.setError(getString(R.string.p1errorNombre));
            txtnombre.requestFocus();
            return;
        }

        if (edadStr.isEmpty()) {
            txtedad.setError(getString(R.string.p1errorEdad));
            txtedad.requestFocus();
            return;
        }

        Intent informacion = new Intent(this, RecibeActivity.class);
        informacion.putExtra("nombre", nombre);
        informacion.putExtra("edad", edadStr);
        startActivity(informacion);
    }
}