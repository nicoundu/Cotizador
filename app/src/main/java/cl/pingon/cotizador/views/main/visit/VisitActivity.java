package cl.pingon.cotizador.views.main.visit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.ServerValue;

import cl.pingon.cotizador.R;
import cl.pingon.cotizador.data.CurrentUser;
import cl.pingon.cotizador.data.Nodes;
import cl.pingon.cotizador.model.Visits;

public class VisitActivity extends AppCompatActivity {

    private String key;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);
        Visits visits = (Visits) getIntent().getSerializableExtra(VisitFragment.VISIT);
        key = visits.getKey();
        getSupportActionBar().setTitle(visits.getClient());
        editText = findViewById(R.id.commentEt);

        String comment = visits.getComments();
        if (comment != null) {
            editText.setText(comment);
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        new Nodes().visits().child(key).child("comments").setValue(editText.getText().toString());
    }
}
