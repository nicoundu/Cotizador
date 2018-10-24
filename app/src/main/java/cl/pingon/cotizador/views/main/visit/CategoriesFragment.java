package cl.pingon.cotizador.views.main.visit;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;

import cl.pingon.cotizador.R;
import cl.pingon.cotizador.adapters.CategoriesListener;
import cl.pingon.cotizador.adapters.CategoriesAdapter;
import cl.pingon.cotizador.data.Nodes;
import cl.pingon.cotizador.model.Categories;

public class CategoriesFragment extends Fragment implements CategoriesListener {

    public static final String CATEGORIES = "cl.pingon.cotizador.views.main.visit.KEY.CATEGORIES";
    private CategoriesAdapter adapter;


    public CategoriesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.categoriesRv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        FirebaseRecyclerOptions<Categories> options = new FirebaseRecyclerOptions.Builder<Categories>()
                .setQuery(new Nodes().categories(), Categories.class)
                .setLifecycleOwner(getActivity())
                .build();

        adapter = new CategoriesAdapter(options, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void clicked(Categories categories) {
        //TODO this is the example to pass a key to the other activity
        Intent intent = new Intent(getActivity(), CategoriesActivity.class);
        intent.putExtra(CATEGORIES, categories);
        startActivity(intent);
    }
}
