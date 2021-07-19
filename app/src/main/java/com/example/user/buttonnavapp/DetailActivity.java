package com.example.user.buttonnavapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView txtJudul, txtIsi;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtJudul = findViewById(R.id.txtdetailjudul);
        txtIsi = findViewById(R.id.txtdetailIsi);
        img = findViewById(R.id.imgDetail);

        Intent a = getIntent();
        String judul = a.getStringExtra("judul");
        int gambar = a.getIntExtra("gambar",0);
        String isi = a.getStringExtra("isi");

        txtJudul.setText(judul);
        txtIsi.setText(isi);
        img.setImageResource(gambar); ;
    }
}
