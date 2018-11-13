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
import cl.pingon.cotizador.model.Comments;
import cl.pingon.cotizador.model.MachinesDetails;

public class CommentsAdapter extends FirebaseRecyclerAdapter<Comments, CommentsAdapter.ViewHolder> {

    public CommentsAdapter(@NonNull FirebaseRecyclerOptions<Comments> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Comments comments) {

        holder.textView.setText(comments.getComments());
    }

    @NonNull
    @Override
    public CommentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_comments, parent, false);
        CommentsAdapter.ViewHolder viewHolder = new CommentsAdapter.ViewHolder(view);
        return viewHolder;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.commentsTv);
        }
    }
}
