package com.example.user.buttonnavapp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.buttonnavapp.AdapterList;
import com.example.user.buttonnavapp.DetailActivity;
import com.example.user.buttonnavapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    ListView listView;

    String judul[] = {
            "Harga tiket pesawat naik", "Niana dan Natalia ", "Depot Langganan IDN tutup", "IDN adalah Sekolah "
    };

    int gambar[] = {
            R.drawable.pesawat, R.drawable.niana, R.drawable.depot, R.drawable.idn
    };

    String isi[] = {
            "Harga tiket pesawat mengalami kenaikan harga menjelang lebaran",
            "Niana dan Natalia adalah Adik Kakak",
            "Saat itu semua galon yang ada di IDN HABIS, dan saat menghubungi abang galon ternyata depotnya sudah ditutup, kami semua sangat kehausan",
            "IDN atau Islamic Development Network adalah satu-satunya sekolah IT yang pesantren  "
    };


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_news, container, false);
        listView = v.findViewById(R.id.listView);

        //set adapter

        AdapterList adapterList = new AdapterList(getActivity(), judul, gambar,isi);
        listView.setAdapter(adapterList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("judul", judul[position]);
                intent.putExtra("isi", isi[position]);
                intent.putExtra("gambar", gambar[position]);
                startActivity(intent);
            }
        });

        return v;
    }

}
