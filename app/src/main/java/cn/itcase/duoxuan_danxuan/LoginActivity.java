package cn.itcase.duoxuan_danxuan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class  LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        findViewById(R.id.tv_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(LoginActivity.this, AddActivity.class);
                startActivity(intent1);

//                startActivity(new Intent(WelActivity.this,MainActivity.class));
            }
        });

        findViewById(R.id.tv_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ListActivity.class));

            }
        });
    }
}
