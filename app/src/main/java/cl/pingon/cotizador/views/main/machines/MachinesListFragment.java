package cl.pingon.cotizador.views.main.machines;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;

import cl.pingon.cotizador.R;
import cl.pingon.cotizador.adapters.CategoriesAdapter;
import cl.pingon.cotizador.adapters.MachinesAdapter;
import cl.pingon.cotizador.adapters.MachinesListener;
import cl.pingon.cotizador.data.Nodes;
import cl.pingon.cotizador.model.Categories;
import cl.pingon.cotizador.model.Machines;
import cl.pingon.cotizador.views.main.MachinesDetailsActivity;

public class MachinesListFragment extends Fragment implements MachinesListener {

    public static final String MACHINES = "cl.pingon.cotizador.views.main.visit.KEY.MACHINES";
    private MachinesAdapter adapter;

    public MachinesListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_machines, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.machinesRv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        Categories categories = (Categories) getActivity().getIntent().getSerializableExtra(CategoriesFragment.CATEGORIES);
        FirebaseRecyclerOptions<Machines> options = new FirebaseRecyclerOptions.Builder<Machines>()
                .setQuery(new Nodes().machines_list(categories.getKey()), Machines.class)
                .setLifecycleOwner(this)
                .build();

        adapter = new MachinesAdapter(options, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void clicked(Machines machines) {
        Intent intent = new Intent(getActivity(), MachinesDetailsActivity.class);
        intent.putExtra(MACHINES, machines);
        startActivity(intent);
    }
}
