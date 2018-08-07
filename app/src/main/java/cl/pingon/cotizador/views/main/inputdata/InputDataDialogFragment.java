package cl.pingon.cotizador.views.main.inputdata;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import cl.pingon.cotizador.R;

public class InputDataDialogFragment extends DialogFragment implements InputDataCallback {

    private EditText clientEt;
    private EditText projectEt;
    private EditText dateEt;
    private Button sendButton;
    private ProgressBar progressBar;

    public static InputDataDialogFragment newInstance() {
        return new InputDataDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment_finder, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        clientEt = view.findViewById(R.id.clientEt);
        projectEt = view.findViewById(R.id.projectEt);
        dateEt = view.findViewById(R.id.dateEt);
        sendButton = view.findViewById(R.id.sendBtn);
        progressBar = view.findViewById(R.id.progressBar);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCancelable(false);
                clientEt.setError(null);
                String client = clientEt.getText().toString();
                clientEt.setVisibility(View.GONE);
                projectEt.setError(null);
                String project = projectEt.getText().toString();
                projectEt.setVisibility(View.GONE);
                dateEt.setError(null);
                String date = dateEt.getText().toString();
                dateEt.setVisibility(View.GONE);
                sendButton.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);

                new DataValidation(InputDataDialogFragment.this).startValidation(client, project, date);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }


    @Override
    public void error(String error) {
        restoreViews();
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void succes() {
        dismiss();
    }

    private void restoreViews() {
        clientEt.setVisibility(View.VISIBLE);
        projectEt.setVisibility(View.VISIBLE);
        dateEt.setVisibility(View.VISIBLE);
        sendButton.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);

        setCancelable(true);

    }

}
