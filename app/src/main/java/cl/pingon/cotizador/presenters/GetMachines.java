package cl.pingon.cotizador.presenters;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import cl.pingon.cotizador.data.Nodes;
import cl.pingon.cotizador.model.MachinesDetails;
import cl.pingon.cotizador.views.main.machines.MachinesDetailsCallback;

public class GetMachines {

    private MachinesDetailsCallback callback;

    public GetMachines(MachinesDetailsCallback callback) {
        this.callback = callback;
    }

    public void withKey(String key) {
        new Nodes().machines(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                MachinesDetails machinesDetails = dataSnapshot.getValue(MachinesDetails.class);
                callback.done(machinesDetails);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
