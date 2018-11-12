package cl.pingon.cotizador.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import cl.pingon.cotizador.R;
import cl.pingon.cotizador.model.Machines;

public class MachinesAdapter extends FirebaseRecyclerAdapter<Machines, MachinesAdapter.ViewHolder> {

    private MachinesListener listener;

    public MachinesAdapter(@NonNull FirebaseRecyclerOptions<Machines> options, MachinesListener listener) {
        super(options);
        this.listener = listener;
    }

    @Override
    protected void onBindViewHolder(@NonNull final MachinesAdapter.ViewHolder holder, int position, @NonNull Machines machines) {

        holder.titleTv.setText(machines.getName());
        holder.descriptionTv.setText(machines.getDescription());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Machines auxMachines = getItem(holder.getAdapterPosition());
                listener.clicked(auxMachines);
            }
        });

        Picasso.get().load(machines.getPhoto()).centerCrop().fit().into(holder.imageView);

    }

    @NonNull
    @Override
    public MachinesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_machines, parent, false);
        MachinesAdapter.ViewHolder viewHolder = new MachinesAdapter.ViewHolder(view);
        return viewHolder;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView titleTv, descriptionTv;
        private Button button;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.card_image);
            titleTv = itemView.findViewById(R.id.card_title);
            descriptionTv = itemView.findViewById(R.id.card_text);
            button = itemView.findViewById(R.id.action_button);

        }
    }
}
