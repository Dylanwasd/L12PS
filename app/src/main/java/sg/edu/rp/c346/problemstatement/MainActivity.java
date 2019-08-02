package sg.edu.rp.c346.problemstatement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spn1, spn2;
    TextView tvCat, tvSubCat;
    Button btnDisplay;
    WebView wvPage;
    ArrayList<String> alDisplay;
    ArrayAdapter<String> aaDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        tvCat = findViewById(R.id.textViewCategory);
        tvSubCat = findViewById(R.id.textViewSubCategory);
        btnDisplay = findViewById(R.id.buttonGo);
        wvPage.setWebViewClient(new WebViewClient());


        alDisplay = new ArrayList<>();


        aaDisplay = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alDisplay);


        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        alDisplay.clear();
                        String[] strDisplay =getResources().getStringArray(R.array.sub_category_rp);
                        alDisplay.addAll(Arrays.asList(strDisplay));
                        break;
                    case 1:
                        alDisplay.clear();
                        String[] strDisplay1 =getResources().getStringArray(R.array.sub_category_soi);
                        alDisplay.addAll(Arrays.asList(strDisplay1));
                        break;
                }
                spn2.setAdapter(aaDisplay);
                aaDisplay.notifyDataSetChanged();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),homePage.class);
                intent.putExtra("value",spn1.getSelectedItem().toString());
                startActivity(intent);

            }
        });

    }
}
