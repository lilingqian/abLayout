package test.bawei.com.tablayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Succes_Activity extends AppCompatActivity {

    private  TextView ncountry,nsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succes_);

        ncountry = (TextView) findViewById(R.id.country);
        nsi= (TextView) findViewById(R.id.si);


    }
}
