package cl.pingon.cotizador.views.main;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import cl.pingon.cotizador.R;
import cl.pingon.cotizador.model.Machines;
import cl.pingon.cotizador.views.main.machines.MachinesDetailsCallback;
import cl.pingon.cotizador.views.main.machines.MachinesDetailsFragment;

public class MachinesDetailsActivity extends AppCompatActivity {

    private String key;
    private Fragment inputCommentsFragment;
    private Fragment commentsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machines_details);

        Machines machines = (Machines) getIntent().getSerializableExtra(MachinesDetailsFragment.MACHINES_DETAILS);
        getSupportActionBar().setTitle(machines.getName());

        key = machines.getKey();
        DatabaseReference root = FirebaseDatabase.getInstance().getReference();

    }

    public class GetMachine {
        private MachinesDetailsCallback callback;

        public GetMachine(MachinesDetailsCallback callback) {
            this.callback = callback;

        }

    }

}
