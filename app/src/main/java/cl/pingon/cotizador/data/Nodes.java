package cl.pingon.cotizador.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        return root.child("categories").child(new CurrentUser().uid());
    }

    public DatabaseReference machine(String key) {
        return root.child("machines").child(key);
    }

    public DatabaseReference machines_details(String key) {
        return root.child("machines_details").child(key);
    }

}
