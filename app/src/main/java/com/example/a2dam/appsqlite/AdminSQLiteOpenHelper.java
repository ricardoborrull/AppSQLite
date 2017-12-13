package com.example.a2dam.appsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{
    public AdminSQLiteOpenHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        //Aquí creamos la tabla de usuario (nombre, edad, ciclo, curso y var, "var" es nota o despacho.)
        db.execSQL("create table estudiante(nombre text primary key, edad text, ciclo text, curso text, nota text");
        db.execSQL("create table profesor(nombre text primary key, edad text, ciclo text, curso text, despacho text");
    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int version1, int version2) {

        db.execSQL("drop table if exists estudiante");
        db.execSQL("drop table if exists profesor");

        db.execSQL("create table estudiante(nombre text primary key, edad text, ciclo text, curso text, nota text");
        db.execSQL("create table profesor(nombre text primary key, edad text, ciclo text, curso text, despacho text");

    }
}
