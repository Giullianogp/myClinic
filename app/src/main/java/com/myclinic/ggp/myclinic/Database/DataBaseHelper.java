package com.myclinic.ggp.myclinic.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Giulliano on 24/05/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    private static String nomeBD = "myClinic.db";
    private static String createTable = "CREATE TABLE Cliente" +
                                        "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                        "nome VARCHAR(30)," +
                                        "email VARCHAR(30)," +
                                        "cidade VARCHAR(30)," +
                                        "cep VARCHAR(9)," +
                                        "logradouro VARCHAR(30)," +
                                        "numero VARCHAR(30)," +
                                        "complemento VARCHAR(30)," +
                                        "telefone VARCHAR(20));" ;


    public DataBaseHelper(Context context) {
        super(context, nomeBD, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE Cliente");
        db.execSQL(createTable);
    }
}
