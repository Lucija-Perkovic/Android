package hr.fer.wpu.labos5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ProductListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        for(final Map.Entry<Category, List<Product>> entry : Utils.loadData().entrySet()){
            for(final Product product : entry.getValue()){
                Bundle extras = getIntent().getExtras();

                Serializable name = extras.getSerializable("categoryName");

                if(entry.getKey().getName().equals(name)){
                    TextView textV = new TextView(this);
                    textV.setText(product.getName());
                    textV.setTextSize(20);
                    layout.addView(textV);
                    Button button = new Button(this);
                    button.setText("+");

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast toasty = Toast.makeText(ProductListActivity.this, R.string.toasty_message, Toast.LENGTH_SHORT);
                            toasty.show();
                        }
                    });
                    button.setLayoutParams(lp);
                    layout.addView(button);
                    Button button2 = new Button(this);
                    button2.setText("INFO");
                    button2.setLayoutParams(lp);
                    layout.addView(button2);
                }

            }


        }
        setContentView(layout);
    }
}