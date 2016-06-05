package com.example.ext0132016.xxyyyy;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("SuHesaplama",MODE_PRIVATE,null);

        String createQuery = "Create table if not exists Water(_id integer primary key autoincrement, watername text,waterdate text); ";
        db.execSQL(createQuery);
    }

    public void AddWater(String watertype){

        db = openOrCreateDatabase("SuHesaplama",MODE_PRIVATE,null);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat myDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");

        Toast.makeText(this,"buraya geldi", Toast.LENGTH_SHORT).show();
        String waterdate = myDateFormat.format(c.getTime());
        Toast.makeText(this,"devam", Toast.LENGTH_SHORT).show();
        String insertQuery = "insert into Water (watername,waterdate) values ('";
        insertQuery +=watertype + "','"+waterdate + "')";
        Toast.makeText(this,"bittiiii", Toast.LENGTH_SHORT).show();
        db.execSQL(insertQuery);
    }


    public void BardakOnClick(View view){
        String txtBardak ="1 bardak icildi";
        AddWater(txtBardak);
        Toast.makeText(this,"1 bardak eklendi", Toast.LENGTH_SHORT).show();

    }

    public void Sise(View view){
        String txtSise ="1 Sise icildi";
        AddWater(txtSise);
        Toast.makeText(this, "1 Sise eklendi",Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "1 Sise eklendi", Toast.LENGTH_SHORT).show();

    }


    public void ArsivOnClick(View view){

        Intent ArsivAc = new Intent(this,Arsiv.class);
        startActivity(ArsivAc);


    }
}
