package com.example.a2dam.appsqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AnadirProfesor extends AppCompatActivity {

    private EditText nom, ed, cic, cur, desp;
    private Button anadir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_profesor);

        nom = (EditText) findViewById(R.id.nom);
        ed = (EditText) findViewById(R.id.ed);
        cic = (EditText) findViewById(R.id.cic);
        cur = (EditText) findViewById(R.id.cur);
        desp = (EditText) findViewById(R.id.desp);

        anadir = (Button) findViewById(R.id.anadir);

        anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(AnadirProfesor.this, "administracion", null, 1);

                SQLiteDatabase bd = admin.getWritableDatabase();

                String nombre = nom.getText().toString();
                String edad = ed.getText().toString();
                String ciclo = cic.getText().toString();
                String curso = cur.getText().toString();
                String despacho = desp.getText().toString();

                ContentValues registro = new ContentValues();

                registro.put("nombre", nombre);
                registro.put("edad", edad);
                registro.put("ciclo", ciclo);
                registro.put("curso", curso);
                registro.put("despacho", despacho);

                Toast.makeText(AnadirProfesor.this, "Datos del usuario cargados", Toast.LENGTH_SHORT).show();

                bd.insert("profesor", null, registro);

                bd.close();
            }
        });
    }
}
