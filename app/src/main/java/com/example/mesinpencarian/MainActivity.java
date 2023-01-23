package com.example.mesinpencarian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView textClock, textDate;

    RecyclerView recyclerView;

    ArrayList<SetterGetter> datamenu;
    GridLayoutManager gridLayoutManager;
    DashboardAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_menu);

        addData();
        gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new DashboardAdapter(datamenu);
        recyclerView.setAdapter(adapter);

        //jam dan tanggal
        textClock = findViewById(R.id.clock);
        textDate = findViewById(R.id.date);

        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                Date date = new Date();

                @SuppressLint("SImpleDateFormat")
                DateFormat clockFormat = new SimpleDateFormat("HH:mm");

                @SuppressLint("SImpleDateFormat")
                DateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy");

                textClock.setText(clockFormat.format(new Date()));
                textDate.setText(dateFormat.format(new Date()));


                //interval
                handler.postDelayed(this, 1000);
            }
        });


    }

    public void addData(){
        datamenu = new ArrayList<>();
        datamenu.add(new SetterGetter("Info RS","logomenu1"));
        datamenu.add(new SetterGetter("Profil Dokter","logomenu2"));
        datamenu.add(new SetterGetter("Pelayanan","logomenu3"));
        datamenu.add(new SetterGetter("Buat Janji","logomenu4"));
        datamenu.add(new SetterGetter("Antrian","logomenu5"));
        datamenu.add(new SetterGetter("Pembatalan","logomenu6"));


    }
}