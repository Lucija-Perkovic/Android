package hr.fer.wpu.labos5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ImageView imageV = new ImageView(this);
        LinearLayout.LayoutParams imageLayoutParams = new LinearLayout.LayoutParams(500,500);
        imageLayoutParams.gravity = Gravity.CENTER;
        imageV.setLayoutParams(imageLayoutParams);
        imageV.setImageResource(this.getResources()
                .getIdentifier("logo", "drawable", this.getPackageName()));
        layout.addView(imageV);
        TextView textV1 = new TextView(this);
        textV1.setText("Flower Power");
        textV1.setTextSize(25);
        textV1.setGravity(Gravity.CENTER);
        layout.addView(textV1);

        TextView textV2 = new TextView(this);
        textV2.setText("Kunska 3, Zagreb");
        textV2.setTextSize(20);
        textV2.setGravity(Gravity.CENTER);
        layout.addView(textV2);

        TextView textV3 = new TextView(this);
        textV3.setText("+385 1 6189 999");
        textV3.setTextSize(15);
        textV3.setGravity(Gravity.CENTER);
        textV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:01/6189-999"));
                startActivity(intent);

            }
        });
        layout.addView(textV3);

        TextView textV4 = new TextView(this);
        textV4.setText("email: info@ciklama.fer.hr");
        textV4.setTextSize(15);
        textV4.setGravity(Gravity.CENTER);
        layout.addView(textV4);

        TextView textV5 = new TextView(this);
        textV5.setText("http://www.ciklama.fer.hr");
        textV5.setTextSize(15);
        textV5.setGravity(Gravity.CENTER);
        layout.addView(textV5);

        TextView textV6 = new TextView(this);
        textV6.setText("App by: Lucija Perković");
        textV6.setTextSize(10);
        textV6.setGravity(Gravity.CENTER);
        layout.addView(textV6);

        setContentView(layout);

    }


}