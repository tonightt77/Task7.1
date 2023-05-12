package cn.itcase.duoxuan_danxuan;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends Activity {
    @BindView(R.id.lv)
    RecyclerView lv;

    private List<UserInfoBean> itemBeanList = new ArrayList();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);


        List<UserInfoBean> temp = DataSupport.findAll(UserInfoBean.class);

        itemBeanList.addAll(temp);
        @SuppressLint("WrongConstant") final LinearLayoutManager manager = new LinearLayoutManager(ListActivity.this, LinearLayoutManager.VERTICAL, false);
        if (null == manager)
            return;
        lv.setLayoutManager(manager);
        myAdapter = new MyAdapter(ListActivity.this, itemBeanList, R.layout.item_meal);
        lv.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent1 = new Intent(ListActivity.this, UpdateActivity.class);
                intent1.putExtra("bean", itemBeanList.get(position));
                startActivity(intent1);
                finish();
            }
        });



    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    class MyAdapter extends BaseRecyclerAdapter<UserInfoBean> {

        private int selPosi;

        public void setSelPosi(int selPosi) {
            this.selPosi = selPosi;
        }

        public MyAdapter(Context context, List<UserInfoBean> datas, int layoutId) {
            super(context, datas, layoutId);
        }

        @Override
        public void setView(MyRVViewHolder holder, final UserInfoBean bean, int position) {
            if (null == holder || null == bean)
                return;
            //init view
            TextView tv_1 = holder.getView(R.id.tv_1);
            TextView tv_2 = holder.getView(R.id.tv_2);
            TextView tv_3 = holder.getView(R.id.tv_3);
            TextView tv_4 = holder.getView(R.id.tv_4);
            TextView tv_5 = holder.getView(R.id.tv_5);
            //set view

            tv_1.setText(bean.name1);
            tv_2.setText(bean.name2);
            tv_3.setText(bean.name3);
            tv_4.setText(bean.name4);
            tv_5.setText(bean.name5);
        }
    }
}
