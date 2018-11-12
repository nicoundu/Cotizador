package cl.pingon.cotizador.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

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

        holder.textView.setText(categories.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Categories auxCategories = getItem(holder.getAdapterPosition());
                listener.clicked(auxCategories);
            }
        });

        Picasso.get().load(categories.getPhoto()).centerCrop().fit().into(holder.imageView);

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {


        private TextView textView;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tile_title);
            imageView = itemView.findViewById(R.id.tile_picture);


        }


    }


    //create recycler holder, this assume you have the row list_item..
    //extend to firebase recycler adapter

}
