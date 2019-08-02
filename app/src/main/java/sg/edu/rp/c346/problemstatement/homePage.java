package sg.edu.rp.c346.problemstatement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class homePage extends AppCompatActivity {
WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        wv=findViewById(R.id.web);
        wv.setWebViewClient(new WebViewClient());
        Intent intentReceived = getIntent();
        int star= intentReceived.getIntExtra("value",0);
        if ( star == 0) {
            String URL = "https://www.rp.edu.sg/";
            wv.loadUrl(URL);
        } else if (star ==  1) {
            String URL1 = "https://www.rp.edu.sg/student-life";
            wv.loadUrl(URL1);
        } else if (star == 2) {
            String URL2 = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
            wv.loadUrl(URL2);

        }else{
            String URL3 = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
            wv.loadUrl(URL3);
        }


    }
}
