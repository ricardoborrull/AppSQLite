package com.example.a2dam.appsqlite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button AnStudent, AnProfesor, delN, delDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnStudent= (Button) findViewById(R.id.AnStudent);
        AnProfesor = (Button) findViewById(R.id.AnProfesor);
        delN = (Button) findViewById(R.id.delN);
        delDB = (Button) findViewById(R.id.delDB);

        AnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, AnadirEstudiante.class);
                startActivity(i);
            }
        });

        AnProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        delDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivity.this, "administracion", null, 1);
                SQLiteDatabase bd = admin.getWritableDatabase();
                bd.execSQL("drop database administracion");
                Toast.makeText(MainActivity.this, "Base de Datos borrada", Toast.LENGTH_SHORT).show();
            }
        });

        delN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
