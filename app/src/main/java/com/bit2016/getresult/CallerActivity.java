package com.bit2016.getresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CallerActivity extends AppCompatActivity {

    private  static int REQUEST_CODE_CALLEEACTIVITY =1;
    private  static int REQUEST_CODE_CALLEEACTIVITY2 =2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caller);

        findViewById(R.id.button_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CallerActivity.this, CalleeActivity.class);
                startActivityForResult(intent, REQUEST_CODE_CALLEEACTIVITY);
                //이걸 해줬을때만 callee activity가 finish를 하는 순간에 결과같이 넘어옴
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_CALLEEACTIVITY){
            if(resultCode== Activity.RESULT_OK){
                int dataNumber = data.getIntExtra("data-number", 0);
                String dataString=data.getStringExtra("data-string");

                String result="data number :"+dataNumber+", data string :"+dataString;
                TextView textView=(TextView)findViewById(R.id.textView_result);
                textView.setText(result);
            }
        }else if(requestCode == REQUEST_CODE_CALLEEACTIVITY2){
            //..
        }
        //activity를 여러개 불러야 하는경우.
    }
}
