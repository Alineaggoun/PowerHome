package dam.iut.powerhome;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);

        Spinner spinner = findViewById(R.id.spinnerFlag);
        List<Country> items = new ArrayList<>();
        items.add(new Country(R.drawable.facebook, "United Kingdom"));
        items.add(new Country(R.drawable.facebook, "Sweden"));
        items.add(new Country(R.drawable.facebook, "United States"));
        items.add(new Country(R.drawable.facebook, "Switzerland"));
        items.add(new Country(R.drawable.facebook, "France"));
        items.add(new Country(R.drawable.facebook, "Japan"));
        items.add(new Country(R.drawable.facebook, "Taiwan"));

        // Utilisation du bon layout pour chaque élément du Spinner
        CountryAdapter adapter = new CountryAdapter(this, R.layout.item_country, items);
        spinner.setAdapter(adapter);
    }
}