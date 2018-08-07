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
import cl.pingon.cotizador.adapters.VisitListener;
import cl.pingon.cotizador.adapters.VisitsAdapter;
import cl.pingon.cotizador.data.CurrentUser;
import cl.pingon.cotizador.data.Nodes;
import cl.pingon.cotizador.model.Visits;

public class VisitFragment extends Fragment implements VisitListener{

    public static final String VISIT = "cl.pingon.cotizador.views.main.visit.KEY.VISIT";
    private VisitsAdapter adapter;


    public VisitFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_visit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.visitsRv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        FirebaseRecyclerOptions<Visits> options = new FirebaseRecyclerOptions.Builder<Visits>()
                .setQuery(new Nodes().visits(), Visits.class)
                .setLifecycleOwner(getActivity())
                .build();

        adapter = new VisitsAdapter(options, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void clicked(Visits visits) {
        Intent intent = new Intent(getActivity(), VisitActivity.class);
        intent.putExtra(VISIT, visits);
        startActivity(intent);
    }
}
