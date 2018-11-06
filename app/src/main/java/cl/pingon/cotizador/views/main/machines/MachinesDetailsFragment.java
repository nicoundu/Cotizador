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

import cl.pingon.cotizador.R;
import cl.pingon.cotizador.model.MachinesDetails;

public class MachinesDetailsFragment extends Fragment implements MachinesDetailsCallback{

    private ImageView imageView;
    private TextView nameTv, configurationTv, electricConsumptionTv, verticalReachTv, horizontalReachTv, maxLoadTv;
    private Fragment inputCommentsFragment;


    public MachinesDetailsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_machines_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageView = view.findViewById(R.id.imageIv);
        nameTv = view.findViewById(R.id.nameTv);
        configurationTv = view.findViewById(R.id.configurationTv);
        electricConsumptionTv = view.findViewById(R.id.electricConsumptionTv);
        verticalReachTv = view.findViewById(R.id.verticalReachTv);
        horizontalReachTv = view.findViewById(R.id.horizontalReachTv);
        maxLoadTv = view.findViewById(R.id.maxLoadTv);
        inputCommentsFragment = view.findViewById(R.id.commentsFg);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void getMachinesDetails(String key) {
        nameTv.setText(MachinesDetails.getName);

    }
}
