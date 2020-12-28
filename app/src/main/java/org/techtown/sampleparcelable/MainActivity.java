package org.techtown.sampleparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//SampleData의 객체를 부가 데이터로 넣어 전달 할 것이다.
public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU = 101;
    public static final String KEY_SIMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                SampleData data = new SampleData(100, "Hello Android!"); //SampleData 객체 생성
                intent.putExtra(KEY_SIMPLE_DATA, data); //인텐트에 부가 데이터로 넣기, 이제 이 Parcel을 메뉴액티비티에서 꺼내 사용할 수 있다.
                startActivityForResult(intent,REQUEST_CODE_MENU);
            }
        });
    }
}