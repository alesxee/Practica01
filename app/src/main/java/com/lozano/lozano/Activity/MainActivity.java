package com.lozano.lozano.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.lozano.lozano.Database.dao.AutoDao;
import com.lozano.lozano.Model.AutoModel;
import com.lozano.lozano.R;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoDao autodao = new AutoDao(this);


        AutoModel ob = new AutoModel();
        ob.setMarca("FERRARI");
        ob.setPlaca("020202");

        AutoModel ob2 = new AutoModel();
        ob2.setMarca("BMW");
        ob2.setPlaca("090909");



        long estado = autodao.insertAuto(ob);
        long estado2 = autodao.insertAuto(ob2);


        Log.w(TAG,"RESULTADO 1: "+estado);
        Log.w(TAG,"RESULTADO 1: "+estado2);
        Log.w(TAG,"RESULTADO autodao: "+autodao);


    }
}
