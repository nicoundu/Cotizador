package cl.pingon.cotizador.views.details;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import cl.pingon.cotizador.data.Nodes;
import cl.pingon.cotizador.model.MachinesDetails;

public class GetMachine {

    //TODO from activity or fragment call  new GetMachines(this).withKey..
    //TODO the view has to implemtn the interface
    //TODO in the view on machineReady set the view configurationTv.setText(machineDetails.getConfiguration);
    private Callback callback;

    public GetMachine(Callback callback) {
        this.callback = callback;
    }

    public void withKey(String key) {
        new Nodes().machine(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                MachinesDetails machinesDetails = dataSnapshot.getValue(MachinesDetails.class);
                callback.machineReady(machinesDetails);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public interface Callback {
        void machineReady(MachinesDetails machinesDetails);
    }
}
