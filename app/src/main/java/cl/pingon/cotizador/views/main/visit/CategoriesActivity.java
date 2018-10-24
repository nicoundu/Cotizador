package cl.pingon.cotizador.views.main.visit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import cl.pingon.cotizador.R;
import cl.pingon.cotizador.data.Nodes;
import cl.pingon.cotizador.model.Categories;

public class CategoriesActivity extends AppCompatActivity {

    private String key;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        Categories categories = (Categories) getIntent().getSerializableExtra(CategoriesFragment.CATEGORIES);
        key = categories.getKey();
        //getSupportActionBar().setTitle(categories.getClient());
        editText = findViewById(R.id.commentEt);

        String comment = ""/*categories.getComments()*/;
        if (comment != null) {
            editText.setText(comment);
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        new Nodes().categories().child(key).child("comments").setValue(editText.getText().toString());
    }
}
