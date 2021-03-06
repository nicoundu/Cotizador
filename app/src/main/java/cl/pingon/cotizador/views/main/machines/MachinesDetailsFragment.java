package cl.pingon.cotizador.views.main.machines;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import cl.pingon.cotizador.R;
import cl.pingon.cotizador.model.Machines;
import cl.pingon.cotizador.model.MachinesDetails;
import cl.pingon.cotizador.presenters.GetMachines;

public class MachinesDetailsFragment extends Fragment implements MachinesDetailsCallback {

    public static final String MACHINES_DETAILS = "cl.pingon.cotizador.views.main.visit.KEY.MACHINES_DETAILS";

    private ImageView imageView;
    private TextView nameTv, configurationTv, electricConsumptionTv, verticalReachTv, horizontalReachTv, maxLoadTv;
    private Fragment inputCommentsFragment;

    public MachinesDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_machines_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.imageIv);
        nameTv = view.findViewById(R.id.nameTv);
        configurationTv = view.findViewById(R.id.configurationTv);
        electricConsumptionTv = view.findViewById(R.id.electricConsumptionTv);
        verticalReachTv = view.findViewById(R.id.verticalReachTv);
        horizontalReachTv = view.findViewById(R.id.horizontalReachTv);
        maxLoadTv = view.findViewById(R.id.maxLoadTv);

        Machines machines = (Machines) getActivity().getIntent().getSerializableExtra(MACHINES_DETAILS);
        new GetMachines(this).withKey(machines.getKey());

    }

    @Override
    public void done(MachinesDetails machinesDetails) {
        Picasso.get().load(machinesDetails.getPhoto()).centerCrop().fit().into(imageView);
        nameTv.setText(machinesDetails.getName());
        configurationTv.setText(machinesDetails.getConfiguration());
        electricConsumptionTv.setText(machinesDetails.getElectric_consumption());
        verticalReachTv.setText(machinesDetails.getVertical_reach());
        horizontalReachTv.setText(machinesDetails.getHorizontal_reach());
        maxLoadTv.setText(machinesDetails.getMax_load());

    }

}
