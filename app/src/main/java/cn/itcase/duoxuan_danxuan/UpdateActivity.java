package cn.itcase.duoxuan_danxuan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

public class UpdateActivity extends Activity {

    UserInfoBean userInfoBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        userInfoBean = (UserInfoBean) getIntent().getSerializableExtra("bean");
        TextView tv_1 = findViewById(R.id.tv_1);
        TextView tv_2 = findViewById(R.id.tv_2);
        TextView tv_3 = findViewById(R.id.tv_3);
        TextView tv_4 = findViewById(R.id.tv_4);
        TextView tv_5 = findViewById(R.id.tv_5);

        tv_1.setText(userInfoBean.name1);
        tv_2.setText(userInfoBean.name2);
        tv_3.setText(userInfoBean.name3);
        tv_4.setText(userInfoBean.name4);
        tv_5.setText(userInfoBean.name5);


        findViewById(R.id.tv_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSupport.deleteAll(UserInfoBean.class, "times = ? ", userInfoBean.times);
                startActivity(new Intent(UpdateActivity.this, ListActivity.class));
                finish();
            }
        });


    }


}
