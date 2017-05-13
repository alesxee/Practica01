package com.lozano.lozano.Database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.lozano.lozano.Database.LozanoDatabaseHelper;
import com.lozano.lozano.Model.AutoModel;

/**
 * Created by ariso on 13/05/2017.
 */

public class AutoDao {

    private SQLiteDatabase mysqlitedatabase;
    public AutoDao(Context context) {
        mysqlitedatabase = new LozanoDatabaseHelper(context).getWritableDatabase();
    }

    public long insertAuto(AutoModel obj){
        return mysqlitedatabase.insert(AutoModel.TABLE_NAME, null, convertAutoTocontentValues(obj));
    }


    private ContentValues convertAutoTocontentValues(AutoModel obj){

        ContentValues contentValues = new ContentValues();
        contentValues.put(AutoModel.ID_FIELD, obj.getId());
        contentValues.put(AutoModel.MARCA_FIELD, obj.getMarca());
        contentValues.put(AutoModel.PLACA_FIELD, obj.getPlaca());

        //debido a que SQLite no puede guardar booleanos, estamos convirtiendo el Boolean a Integer
        //para poder guardar.
        //Integer tieneHijosInteger = cliente.getTieneHijos()?1:0;
        //contentValues.put(ClienteModel.TIENE_HIJOS_FIELD, tieneHijosInteger);

        return contentValues;

    }
}
