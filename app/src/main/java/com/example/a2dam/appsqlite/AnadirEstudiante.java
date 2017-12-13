package com.example.a2dam.appsqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AnadirEstudiante extends AppCompatActivity {

    private EditText nom, ed, cic, cur, not;
    private Button anadir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_estudiante);

        nom = (EditText) findViewById(R.id.nom);
        ed = (EditText) findViewById(R.id.ed);
        cic = (EditText) findViewById(R.id.cic);
        cur = (EditText) findViewById(R.id.cur);
        not = (EditText) findViewById(R.id.not);

        anadir = (Button) findViewById(R.id.anadir);

        anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(AnadirEstudiante.this, "administracion", null, 1);

                SQLiteDatabase bd = admin.getWritableDatabase();

                String nombre = nom.getText().toString();
                String edad = ed.getText().toString();
                String ciclo = cic.getText().toString();
                String curso = cur.getText().toString();
                String nota = not.getText().toString();

                ContentValues registro = new ContentValues();

                registro.put("nombre", nombre);
                registro.put("edad", edad);
                registro.put("ciclo", ciclo);
                registro.put("curso", curso);
                registro.put("nota", nota);

                bd.insert("estudiante", null, registro);

                bd.close();

                Intent i = new Intent(AnadirEstudiante.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
