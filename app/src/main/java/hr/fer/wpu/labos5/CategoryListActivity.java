package hr.fer.wpu.labos5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.LinkedList;
import java.util.List;

public class CategoryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        for(final Category category : Utils.loadData().keySet()){
            ImageView imageV = new ImageView(this);
            LinearLayout.LayoutParams imageLayoutParams = new LinearLayout.LayoutParams(500,500);
            imageLayoutParams.gravity = Gravity.CENTER;
            imageV.setLayoutParams(imageLayoutParams);
            imageV.setImageResource(this.getResources()
                    .getIdentifier(category.getImgName(), "drawable", this.getPackageName()));
            layout.addView(imageV);
            Button button = new Button(this);
            button.setText(category.getName());
            button.setLayoutParams(lp);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentProducts = new Intent(CategoryListActivity.this, ProductListActivity.class);
                    intentProducts.putExtra("categoryName", category.getName());
                    startActivity(intentProducts);
                }
            });
            layout.addView(button);
        }
        scroll.addView(layout);

        setContentView(scroll);
    }
}