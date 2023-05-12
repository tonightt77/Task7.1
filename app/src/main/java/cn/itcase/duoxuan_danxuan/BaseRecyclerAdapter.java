package cn.itcase.duoxuan_danxuan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public abstract class  BaseRecyclerAdapter<T> extends RecyclerView.Adapter<MyRVViewHolder> {
    public List<T> mDatas;
    private LayoutInflater mInflater;
    private int mlayoutId;
    public Context context;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;

    public BaseRecyclerAdapter(Context context, List<T> datas, int layoutId) {
        this.context = context;
        this.mDatas = datas;
        this.mlayoutId = layoutId;
        mInflater = LayoutInflater.from(context);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }


    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public MyRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyRVViewHolder viewHolder = new MyRVViewHolder(mInflater.inflate(mlayoutId, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyRVViewHolder holder, int position) {
        setView(holder, mDatas.get(position), position);
        setUpItemEvent(holder);
    }

    public abstract void setView(MyRVViewHolder holder, T datadto, int position);

    public void setUpItemEvent(final MyRVViewHolder holder) {
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition = holder.getAdapterPosition();
                    onItemClickListener.onItemClick(holder.itemView, layoutPosition);
                }
            });
        }
        if (null != onItemLongClickListener) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int layoutPosition = holder.getAdapterPosition();
                    onItemLongClickListener.onItemLongClick(holder.itemView, layoutPosition);
                    return true;
                }
            });
        }
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }
}
