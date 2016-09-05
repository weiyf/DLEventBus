package cn.weiyf.dleventbus.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import cn.weiyf.dleventbus.EventBus;
import cn.weiyf.dleventbus.EventCenter;
import cn.weiyf.dleventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new EventCenter<>(1, 1));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(tag = 1)
    public void test(EventCenter<Integer> eventCenter) {
        Toast.makeText(MainActivity.this, "result: " + eventCenter.getData(), Toast.LENGTH_SHORT).show();
    }
}
