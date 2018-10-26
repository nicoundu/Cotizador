package cl.pingon.cotizador.data;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import cl.pingon.cotizador.model.MachinesDetails;

public class Nodes {

    private DatabaseReference root = FirebaseDatabase.getInstance().getReference();

    public DatabaseReference users() {
        return root.child("users");
    }

    public DatabaseReference user(String key) {
        return users().child(key);
    }

    //This is the node to use with the adapter
    public DatabaseReference categories() {
        return root.child("categories");
    }

    public DatabaseReference machines(String key) {
        return root.child("machines_list").child(key);
    }

    /*public DatabaseReference machines_details(String key) {
        return root.child("machines").child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                MachinesDetails machinesDetails = dataSnapshot.getValue(MachinesDetails.class);

                Picasso.get().load(machinesDetails.getPhoto()).centerCrop().fit().into(imageIv);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }*/

}
