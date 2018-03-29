package com.study.rocky.rockyadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv_test = findViewById(R.id.rv_test);
        ListView lv_test= findViewById(R.id.lv_test);
        TestLVAdapter testLVAdapter = new TestLVAdapter();
        lv_test.setAdapter(testLVAdapter);
        rv_test.setLayoutManager(new LinearLayoutManager(this));
        RockyTestRVAdapter adapter = new RockyTestRVAdapter();
        rv_test.setAdapter(adapter);

        for (int i = 0; i < 10; i++) {
            adapter.addModel("Item Test哈哈哈哈或" + i);
            testLVAdapter.addModel("Item Test哈哈哈哈或" + i);
        }
    }
}
