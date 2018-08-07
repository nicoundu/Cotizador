package cl.pingon.cotizador.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import cl.pingon.cotizador.R;
import cl.pingon.cotizador.model.Visits;
import cl.pingon.cotizador.views.main.visit.VisitFragment;

public class VisitsAdapter extends FirebaseRecyclerAdapter<Visits, VisitsAdapter.ViewHolder> {

    private VisitListener listener;

    public VisitsAdapter(@NonNull FirebaseRecyclerOptions<Visits> options, VisitListener listener) {
        super(options);
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_visit, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    protected void onBindViewHolder(@NonNull final ViewHolder holder, int position, @NonNull Visits visits) {

        holder.clientTv.setText(visits.getClient());
        holder.projectTv.setText(visits.getProject());
        holder.dateTv.setText(visits.getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Visits auxVisits = getItem(holder.getAdapterPosition());
                listener.clicked(auxVisits);
            }
        });

    }



    public static class ViewHolder extends RecyclerView.ViewHolder {


        private TextView clientTv;
        private TextView projectTv;
        private TextView dateTv;

        public ViewHolder(View itemView) {
            super(itemView);

            clientTv = itemView.findViewById(R.id.clientTv);
            projectTv = itemView.findViewById(R.id.projectTv);
            dateTv = itemView.findViewById(R.id.dateTv);


        }


    }



    //create recycler holder, this assume you have the row list_item..
    //extend to firebase recycler adapter

}
