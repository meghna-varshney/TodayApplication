package e.meghna.todayapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SharedPreferences sharedPreferences = getSharedPreferences("e.meghna.todayapplication",MODE_PRIVATE);
        String str = sharedPreferences.getString("username", "");

        ((TextView)findViewById(R.id.textView)).setText(str);

    }
}
