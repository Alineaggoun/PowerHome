package dam.iut.powerhome;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerDL;
    private ActionBarDrawerToggle toggle;
    private FragmentManager fm;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);

//        Spinner spinner = findViewById(R.id.spinnerFlag);
//        List<Country> items = new ArrayList<>();
//        items.add(new Country(R.drawable.uk, "United Kingdom"));
//        items.add(new Country(R.drawable.sweden, "Sweden"));
//        items.add(new Country(R.drawable.usa, "United States"));
//        items.add(new Country(R.drawable.switzerland, "Switzerland"));
//        items.add(new Country(R.drawable.france, "France"));
//        items.add(new Country(R.drawable.japan, "Japan"));
//        items.add(new Country(R.drawable.taiwan, "Taiwan"));
//
//        // Utilisation du bon layout pour chaque élément du Spinner
//        CountryAdapter adapter = new CountryAdapter(this, R.layout.item_country, items);
//        spinner.setAdapter(adapter);

        drawerDL = findViewById(R.id.drawer);
        NavigationView navNV = findViewById(R.id.nav_view);

        toggle =
                new ActionBarDrawerToggle(this, drawerDL,
                        R.string.open, R.string.close);
        drawerDL.setDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fm = getSupportFragmentManager();
        navNV.setNavigationItemSelectedListener(this);
        navNV.getMenu().performIdentifierAction(R.id.nav_first, 0);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return toggle.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        if (item.getItemId() == R.id.nav_first){
            fm.beginTransaction().replace(R.id.contentFL,
                    new FirstFragment()).commit();}
//        } else if (item.getItemId() == R.id.nav_second) { ... }
        drawerDL.closeDrawer(GravityCompat.START);
        return true;
    }
}