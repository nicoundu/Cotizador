package cl.pingon.cotizador.views.main;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import cl.pingon.cotizador.R;
import cl.pingon.cotizador.model.Machines;
import cl.pingon.cotizador.views.main.machines.MachinesDetailsCallback;
import cl.pingon.cotizador.views.main.machines.MachinesListFragment;

import static cl.pingon.cotizador.R.id.commentsFg;

public class MachinesDetailsActivity extends AppCompatActivity {


    private String key;
    private ImageView imageView;
    private TextView nameTv, configurationTv, electricConsumptionTv, verticalReachTv, horizontalReachTv, maxLoadTv;
    private Fragment inputCommentsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machines_details);


        Machines machines = (Machines) getIntent().getSerializableExtra(MachinesListFragment.MACHINES);
        getSupportActionBar().setTitle(machines.getName());

        key = machines.getKey();

        imageView = findViewById(R.id.imageIv);
        nameTv = findViewById(R.id.nameTv);
        configurationTv = findViewById(R.id.configurationTv);
        electricConsumptionTv = findViewById(R.id.electricConsumptionTv);
        verticalReachTv = findViewById(R.id.verticalReachTv);
        horizontalReachTv = findViewById(R.id.horizontalReachTv);
        maxLoadTv = findViewById(R.id.maxLoadTv);
        inputCommentsFragment = findViewById(commentsFg);

        DatabaseReference root = FirebaseDatabase.getInstance().getReference();

    }

    public class GetMachine {
        private MachinesDetailsCallback callback;

        public GetMachine(MachinesDetailsCallback callback) {
            this.callback = callback;

        }

        public void withKey(String key) {

        }
    }


}
