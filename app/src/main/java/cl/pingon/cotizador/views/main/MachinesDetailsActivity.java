package cl.pingon.cotizador.views.main;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import cl.pingon.cotizador.R;
import cl.pingon.cotizador.data.Nodes;
import cl.pingon.cotizador.model.Categories;
import cl.pingon.cotizador.model.Machines;
import cl.pingon.cotizador.model.MachinesDetails;
import cl.pingon.cotizador.views.main.machines.CategoriesFragment;
import cl.pingon.cotizador.views.main.machines.MachinesListFragment;

import static cl.pingon.cotizador.R.id.commentsFg;

public class MachinesDetailsActivity extends AppCompatActivity {

    private String key;
    private TextView nameTv, configurationTv, electricConsumptionTv, horizontalReachTv,verticalReachTv, maxLoadTv;
    private EditText commentsEt;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machines_details);

        Machines machines = (Machines) getIntent().getSerializableExtra(MachinesListFragment.MACHINES);
        getSupportActionBar().setTitle(machines.getName());

        key = machines.getKey();


        final ImageView imageView = findViewById(R.id.imageIv);
        final TextView nameTv = findViewById(R.id.nameTv);
        final TextView configurationTv = findViewById(R.id.configurationTv);
        final TextView electricConsumptionTv = findViewById(R.id.electricConsumptionTv);
        final TextView horizontalReachTv = findViewById(R.id.horizontalReachTv);
        final TextView verticalReachTv = findViewById(R.id.verticalReachTv);
        final TextView maxLoadTv = findViewById(R.id.maxLoadTv);
        final Fragment commentsFg = findViewById(R.id.commentsFg);

        DatabaseReference root = FirebaseDatabase.getInstance().getReference();
        root.child("machines").child(key).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    MachinesDetails machinesDetails = dataSnapshot.getValue(MachinesDetails.class);

                    Picasso.get().load(machinesDetails.getPhoto()).centerCrop().fit().into(imageView);
                    nameTv.setText(machinesDetails.getName());
                    configurationTv.setText(machinesDetails.getConfiguration());
                    electricConsumptionTv.setText(machinesDetails.getElectric_consumption());
                    horizontalReachTv.setText(machinesDetails.getHorizontal_reach());
                    verticalReachTv.setText(machinesDetails.getVertical_reach());
                    maxLoadTv.setText(machinesDetails.getMax_load());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


    @Override
    protected void onPause() {
        super.onPause();
        new Nodes().machines().child(key).child("comments").setValue(commentsEt.getText().toString());
    }
}
}
