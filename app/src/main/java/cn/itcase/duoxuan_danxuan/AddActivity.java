package cn.itcase.duoxuan_danxuan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // Initialize the RadioGroup and RadioButtons from the layout.
        RadioGroup mRG = (RadioGroup) findViewById(R.id.radiogroup);
        final RadioButton mRB1 = (RadioButton) findViewById(R.id.radiobutton1);
        final RadioButton mRB2 = (RadioButton) findViewById(R.id.radiobutton2);
        final String[] sex = new String[1];

        // Set a listener to get the selected radio button's text.
        mRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // If the first RadioButton is selected, set sex[0] to "Lost", otherwise set it to "Found".
                if (checkedId == mRB1.getId()) {
                    sex[0] = "Lost";
                } else {
                    sex[0] = "Found";
                }

            }
        });

        // Initialize the EditText views from the layout.
        final EditText et_1 = findViewById(R.id.et_1);
        final EditText et_2 = findViewById(R.id.et_2);
        final EditText et_3 = findViewById(R.id.et_3);
        final EditText et_4 = findViewById(R.id.et_4);
        final EditText et_5 = findViewById(R.id.et_5);

        // Set a click listener for the login button.
        findViewById(R.id.tv_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if any of the EditText fields are empty. If yes, show a toast message and return.
                if(StringUtil.isEmpty(et_1.getText().toString())||
                        StringUtil.isEmpty(et_2.getText().toString())||
                        StringUtil.isEmpty(et_3.getText().toString())||
                        StringUtil.isEmpty(et_4.getText().toString())||
                        StringUtil.isEmpty(et_5.getText().toString())

                ){
                    Toast.makeText(AddActivity.this," Content cannot be empty ",Toast.LENGTH_SHORT).show();
                    return;
                }

                // If none of the fields are empty, create a new UserInfoBean and set its fields.
                UserInfoBean tempBean = new UserInfoBean();
                tempBean.times=System.currentTimeMillis()+"";
                tempBean.name1=(et_1.getText().toString());
                tempBean.name2=(et_2.getText().toString());
                tempBean.name3=(et_3.getText().toString());
                tempBean.name4=(et_4.getText().toString());
                tempBean.name5=(et_5.getText().toString());
                tempBean.save(); // Save the UserInfoBean.

                // Start the ListActivity and finish the current activity.
                startActivity(new Intent(AddActivity.this, ListActivity.class));
                finish();
            }
        });

    }
}
