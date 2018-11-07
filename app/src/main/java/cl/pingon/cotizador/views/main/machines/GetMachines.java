package cl.pingon.cotizador.views.main.machines;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import cl.pingon.cotizador.model.MachinesDetails;

import static cl.pingon.cotizador.R.id.root;

public class GetMachines {

    private MachinesDetailsCallback callback;

    public GetMachines(MachinesDetailsCallback callback) {
        this.callback = callback("machines").child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                MachinesDetails machinesDetails = dataSnapshot.getValue(MachinesDetails.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
