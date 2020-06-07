package dev.corp.petagram;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MacotaViewHolder> {
    private ArrayList<Mascota> mascotas;
    private  Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas,Activity activity)
    {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MacotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascota,parent,false);
        return new MacotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MacotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.petName.setText(mascota.getPetName());
        holder.score.setText(mascota.getScore());
        holder.img_foto.setImageResource(mascota.getFoto());
        holder.btn_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.btn_like.setImageResource(R.drawable.croqueta);
                Toast.makeText(activity,"Te gusta esta mascota",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MacotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_foto;
        private TextView petName;
        private TextView score;
        private ImageButton btn_like;

        public MacotaViewHolder(@NonNull View itemView) {
            super(itemView);

            img_foto = itemView.findViewById(R.id.pet_image);
            petName = itemView.findViewById(R.id.tv_name);
            score = itemView.findViewById(R.id.text_score);
            btn_like = itemView.findViewById(R.id.btn_fav);

        }
    }
}
