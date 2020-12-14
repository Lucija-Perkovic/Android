package hr.fer.wpu.labos5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        Button button = new Button(this);
        button.setText("KATEGORIJE PROIZVODA");
        button.setLayoutParams(lp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCategory = new Intent(MainActivity.this, CategoryListActivity.class);
                startActivity(intentCategory);
            }
        });
        layout.addView(button);

        Button button2 = new Button(this);
        button2.setText("INFO");
        button2.setLayoutParams(lp);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInfo = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intentInfo);
            }
        });
        layout.addView(button2);

        setContentView(layout);
    }
}