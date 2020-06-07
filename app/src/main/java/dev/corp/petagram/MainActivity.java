package dev.corp.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_mascota);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        //GridLayoutManager glm = new GridLayoutManager(this,1);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ImageView back = findViewById(R.id.back);
        ImageView top = findViewById(R.id.top_five);
        FloatingActionButton camara = findViewById(R.id.floating);
        camara.setImageResource(R.drawable.ic_camara);
        recyclerView.setLayoutManager(llm);
        setData();
        defineAdapter();
      // back.setImageResource(0);
       top.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(MainActivity.this,TopFivePets.class);
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
