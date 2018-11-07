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
        this.callback = callback;
    }
    
    public void withKey(String key) {
        //TODO I don't know wich nodes you have, replace SOMETHING with the appropiate
         new Nodes().SOMETHING().child(key).addListenerForSingleValueEvent(new ValueEventListener() {
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
