package dev.corp.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class TopFivePets extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Mascota> mascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_five_pets);
        recyclerView = findViewById(R.id.rv_top);
        ImageView top = findViewById(R.id.top_five);
        top.setImageResource(0);
        ImageView back = findViewById(R.id.back);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        setData();
        defineAdapter();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TopFivePets.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    public void setData()
    {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.pet1,"Bruno ",10));
        mascotas.add(new Mascota(R.drawable.pet2,"Diego Go",5));
        mascotas.add(new Mascota(R.drawable.pet3,"Marshall",3));
        mascotas.add(new Mascota(R.drawable.pet4,"Caramelo ",20));
        mascotas.add(new Mascota(R.drawable.pet5,"Margarita ",1));
    }

    public void defineAdapter()
    {
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas,this);
        recyclerView.setAdapter(mascotaAdaptador);
    }
}
