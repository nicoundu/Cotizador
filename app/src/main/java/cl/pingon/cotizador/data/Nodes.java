package cl.pingon.cotizador.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Nodes {

    private DatabaseReference root = FirebaseDatabase.getInstance().getReference();

    public DatabaseReference users() { return root.child("users");}

    public DatabaseReference user(String key) {return users().child(key);}

    //This is the node to use with the adapter
    public DatabaseReference visits() { return root.child("visits").child(new CurrentUser().uid());}

}
