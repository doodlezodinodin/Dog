package ua.nure.dog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listenerOnButton();
    }

    public void listenerOnButton() {
        final EditText nameDog = findViewById(R.id.et_nameDog);
        Button btn = findViewById(R.id.btn_ok);

        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(".Stage");
                        intent.putExtra("nameDog", nameDog.getText().toString());
                        startActivity(intent);
                    }
                }
        );
    }
}
