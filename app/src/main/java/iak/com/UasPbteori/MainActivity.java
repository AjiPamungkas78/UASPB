package iak.com.UasPbteori;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.listView);



        final ArrayList<Weather> data = new ArrayList<>();
        data.add(new Weather(R.drawable.ak,"Akrapovic","Rp.800.000"));
        data.add(new Weather(R.drawable.nb,"Nobi","Rp.1.000.000"));
        data.add(new Weather(R.drawable.pro,"Prolinier","Rp.1.300.000"));
        data.add(new Weather(R.drawable.r,"R9","Rp.1.000.000"));
        data.add(new Weather(R.drawable.scor,"Scorpion","Rp.500.000"));
        data.add(new Weather(R.drawable.sc,"Scproject","Rp.2.100.000"));
        data.add(new Weather(R.drawable.ys,"Yoshimura","1.000.000"));
        data.add(new Weather(R.drawable.ter,"termignoni","Rp.525.000"));



        WeatherAdapter adapter = new WeatherAdapter(this, R.layout.list_view, data);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Weather weather=data.get(position);
                Intent toTarget = new Intent(getApplicationContext(),TargetActivity.class);
                toTarget.putExtra("title", weather.title);
                toTarget.putExtra("icon", weather.icon);
                toTarget.putExtra("item", weather.item);
                startActivity(toTarget);

            }
        });
    }
}
