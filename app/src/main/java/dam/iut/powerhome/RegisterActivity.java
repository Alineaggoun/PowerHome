package dam.iut.powerhome;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {
    private Spinner spinner;
    private Button boutonInscription;
    private EditText txtBoxPrenom;
    private EditText txtBoxNom;
    private EditText txtBoxMdp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.registeractivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.spinner = (Spinner) findViewById(R.id.spinner_country_code);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.country_codes,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        this.txtBoxPrenom = (EditText) findViewById(R.id.prenom);
        this.txtBoxNom = (EditText) findViewById(R.id.nom);
        this.txtBoxMdp = (EditText) findViewById(R.id.mdp);
        this.boutonInscription = (Button) findViewById(R.id.buttonLogin);
        boutonInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean saisieValide = true;
                if(txtBoxPrenom.getText() == null || txtBoxPrenom.getText().toString().length() < 2 || txtBoxPrenom.getText().toString().length() > 25 ||
                        !(txtBoxPrenom.getText().toString().matches("^[a-zA-Z]*$"))) {
                    Toast.makeText(v.getContext(), "PrÃ©nom " + txtBoxPrenom.getText().toString() + " invalide !", Toast.LENGTH_LONG).show();
                    saisieValide = false;
                }
                if(txtBoxNom.getText() == null || txtBoxNom.getText().toString().length() < 2 || txtBoxNom.getText().toString().length() > 25 ||
                        !(txtBoxNom.getText().toString().matches("^[a-zA-Z]*$"))) {
                    Toast.makeText(v.getContext(), "Nom " + txtBoxNom.getText().toString() + " invalide !", Toast.LENGTH_LONG).show();
                    saisieValide = false;
                }

                if(txtBoxMdp.getText() == null || txtBoxMdp.getText().toString().length() < 8 ||
                        !(txtBoxMdp.getText().toString().matches("^[a-zA-Z0-9]*$"))) {
                    Toast.makeText(v.getContext(), "Mot de passe " + txtBoxMdp.getText().toString() + " invalide !", Toast.LENGTH_LONG).show();
                    saisieValide = false;
                }
                if(saisieValide){
                    Intent intent = new Intent(RegisterActivity.this, ResultatActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Nom", txtBoxNom.getText().toString());
                    bundle.putString("Prenom", txtBoxPrenom.getText().toString());
                    bundle.putString("MotDePasse", txtBoxMdp.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}