package cl.pingon.cotizador.views.main.inputdata;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import cl.pingon.cotizador.R;
import cl.pingon.cotizador.data.Nodes;
import cl.pingon.cotizador.model.Machines;
import cl.pingon.cotizador.presenters.GetMachines;
import cl.pingon.cotizador.presenters.SendComments;

import static cl.pingon.cotizador.R.id.commentsEt;

public class InputCommentsFragment extends Fragment {

    public static final String MACHINES_DETAILS = "cl.pingon.cotizador.views.main.visit.KEY.MACHINES_DETAILS";
    private EditText commentEt;
    private ImageButton button;

    public InputCommentsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_input_comments, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        commentEt = view.findViewById(R.id.commentsFg);
        button = view.findViewById(R.id.saveBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String comment = commentEt.getText().toString();
                new SendComments().fromUser(key, comment);
            }
        });

        SendComments sendComments = (SendComments) getActivity().getIntent().getSerializableExtra(MACHINES_DETAILS);
        new SendComments().fromUser();





    }

}
