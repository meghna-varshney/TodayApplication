package e.meghna.todayapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText,edittxt1;
    Button button;
    String s1;
    String s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText =findViewById(R.id.editText);
        edittxt1 = findViewById(R.id.editText2);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("e.meghna.todayapplication",MODE_PRIVATE);
                String user = editText.getText().toString().trim();
                String pass = edittxt1.getText().toString().trim();
                String s_user = sharedPreferences.getString("username", "");
                String s_pass = sharedPreferences.getString("password", "");
                if(user.equals(s_user)&& pass.equals(s_pass))
                {
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "login successfu", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, " not successfull", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("e.meghna.todayapplication",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username",editText.getText().toString().trim());
        editor.putString("1234",edittxt1.getText().toString().trim());
        editor.putBoolean("bool",true);
        editor.apply();
    }
}
