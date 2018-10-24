package cl.pingon.cotizador.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import cl.pingon.cotizador.R;
import cl.pingon.cotizador.model.Categories;

public class CategoriesAdapter extends FirebaseRecyclerAdapter<Categories, CategoriesAdapter.ViewHolder> {

    private CategoriesListener listener;

    public CategoriesAdapter(@NonNull FirebaseRecyclerOptions<Categories> options, CategoriesListener listener) {
        super(options);
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_categories, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    protected void onBindViewHolder(@NonNull final ViewHolder holder, int position, @NonNull Categories categories) {

        /*holder.clientTv.setText(categories.getName());
        holder.projectTv.setText(categories.getName());
        holder.dateTv.setText("");*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Categories auxCategories = getItem(holder.getAdapterPosition());
                listener.clicked(auxCategories);
            }
        });

        //Picasso.get().load(categories.getPhoto()).centerCrop().fit().into(holder.imageview);

    }



    public static class ViewHolder extends RecyclerView.ViewHolder {


        /*private TextView clientTv;
        private TextView projectTv;
        private TextView dateTv;*/

        public ViewHolder(View itemView) {
            super(itemView);

            /*clientTv = itemView.findViewById(R.id.clientTv);
            projectTv = itemView.findViewById(R.id.projectTv);
            dateTv = itemView.findViewById(R.id.dateTv);*/


        }


    }



    //create recycler holder, this assume you have the row list_item..
    //extend to firebase recycler adapter

}
