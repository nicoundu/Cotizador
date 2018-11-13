package cl.pingon.cotizador.views.main.machines;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import cl.pingon.cotizador.R;
import cl.pingon.cotizador.adapters.CategoriesAdapter;
import cl.pingon.cotizador.adapters.CommentsAdapter;
import cl.pingon.cotizador.data.Nodes;
import cl.pingon.cotizador.model.Categories;
import cl.pingon.cotizador.model.MachinesDetails;

public class CommentsFragment extends Fragment {

    private CommentsAdapter adapter;

    public CommentsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_comments, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.commentsRv);


        FirebaseRecyclerOptions<MachinesDetails> options = new FirebaseRecyclerOptions.Builder<MachinesDetails>()
                .setQuery(new Nodes().comments(""), MachinesDetails.class)
                .setLifecycleOwner(getActivity())
                .build();

        adapter = new CommentsAdapter(options);
        recyclerView.setAdapter(adapter);

    }


}