package com.example.tokobukuwati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private BukuAdapter bukuAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Buku> bukus;
    private RequestQueue requestQueue;
    int data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        bukus = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
        String url = "https://tokobukuwati.000webhostapp.com/olinkoneksi.php";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        data = response.length();
                        try {
                            for (int i = 0; i < data; i++) {
                                JSONObject data = response.getJSONObject(i);
                                String gambarbuku = data.getString("gambar");
                                String judulbuku = data.getString("judul");
                                String deskripsibuku = data.getString("deskripsi");
                                String penulisbuku = data.getString("penulis");
                                String hargabuku = data.getString("harga");
                                bukus.add(new Buku(gambarbuku, judulbuku, deskripsibuku, penulisbuku, hargabuku));
                            }
                            bukuAdapter = new BukuAdapter(MainActivity.this, bukus);
                            recyclerView.setAdapter(bukuAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }
}
