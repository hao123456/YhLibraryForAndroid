package org.yh.library.adapter.lv;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

public class YHListViewHolder<D>
{
    private SparseArray<View> mViews;
    protected int mPosition;
    private View mConvertView;
    private Context mContext;
    protected int mLayoutId;
    /**
     * Bean对象
     */
    protected D data;
    public YHListViewHolder(Context context, View itemView, ViewGroup parent, int position)
    {
        mContext = context;
        mConvertView = itemView;
        mPosition = position;
        mViews = new SparseArray<>();
        mConvertView.setTag(this);
    }


    public static YHListViewHolder get(Context context, View convertView,
                                       ViewGroup parent, int layoutId, int position)
    {
        if (convertView == null)
        {
            View itemView = LayoutInflater.from(context).inflate(layoutId, parent,
                    false);
            YHListViewHolder holder = new YHListViewHolder(context, itemView, parent, position);
            holder.mLayoutId = layoutId;
            return holder;
        }
        else
        {
            YHListViewHolder holder = (YHListViewHolder) convertView.getTag();
            holder.mPosition = position;
            return holder;
        }
    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return view
     */
    public <T extends View> T getView(int viewId)
    {
        View view = mViews.get(viewId);
        if (view == null)
        {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView()
    {
        return mConvertView;
    }

    public int getLayoutId()
    {
        return mLayoutId;
    }

    public void updatePosition(int position)
    {
        mPosition = position;
    }

    public int getItemPosition()
    {
        return mPosition;
    }


    /****以下为辅助方法*****/

    /**
     * 设置TextView的值
     *
     * @param viewId
     * @param text
     * @return this
     */
    public YHListViewHolder setText(int viewId, String text)
    {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public YHListViewHolder setImageResource(int viewId, int resId)
    {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    public YHListViewHolder setImageBitmap(int viewId, Bitmap bitmap)
    {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    public YHListViewHolder setImageDrawable(int viewId, Drawable drawable)
    {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    public YHListViewHolder setBackgroundColor(int viewId, int color)
    {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public YHListViewHolder setBackgroundRes(int viewId, int backgroundRes)
    {
        View view = getView(viewId);
        view.setBackgroundResource(backgroundRes);
        return this;
    }

    public YHListViewHolder setTextColor(int viewId, int textColor)
    {
        TextView view = getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    public YHListViewHolder setTextColorRes(int viewId, int textColorRes)
    {
        TextView view = getView(viewId);
        view.setTextColor(mContext.getResources().getColor(textColorRes));
        return this;
    }

    @SuppressLint("NewApi")
    public YHListViewHolder setAlpha(int viewId, float value)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
        {
            getView(viewId).setAlpha(value);
        }
        else
        {
            // Pre-honeycomb hack to set Alpha value
            AlphaAnimation alpha = new AlphaAnimation(value, value);
            alpha.setDuration(0);
            alpha.setFillAfter(true);
            getView(viewId).startAnimation(alpha);
        }
        return this;
    }

    public YHListViewHolder setVisible(int viewId, boolean visible)
    {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    public YHListViewHolder linkify(int viewId)
    {
        TextView view = getView(viewId);
        Linkify.addLinks(view, Linkify.ALL);
        return this;
    }

    public YHListViewHolder setTypeface(Typeface typeface, int... viewIds)
    {
        for (int viewId : viewIds)
        {
            TextView view = getView(viewId);
            view.setTypeface(typeface);
            view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }
        return this;
    }

    public YHListViewHolder setProgress(int viewId, int progress)
    {
        ProgressBar view = getView(viewId);
        view.setProgress(progress);
        return this;
    }

    public YHListViewHolder setProgress(int viewId, int progress, int max)
    {
        ProgressBar view = getView(viewId);
        view.setMax(max);
        view.setProgress(progress);
        return this;
    }

    public YHListViewHolder setMax(int viewId, int max)
    {
        ProgressBar view = getView(viewId);
        view.setMax(max);
        return this;
    }

    public YHListViewHolder setRating(int viewId, float rating)
    {
        RatingBar view = getView(viewId);
        view.setRating(rating);
        return this;
    }

    public YHListViewHolder setRating(int viewId, float rating, int max)
    {
        RatingBar view = getView(viewId);
        view.setMax(max);
        view.setRating(rating);
        return this;
    }

    public YHListViewHolder setTag(int viewId, Object tag)
    {
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }

    public YHListViewHolder setTag(int viewId, int key, Object tag)
    {
        View view = getView(viewId);
        view.setTag(key, tag);
        return this;
    }

    public YHListViewHolder setChecked(int viewId, boolean checked)
    {
        Checkable view = (Checkable) getView(viewId);
        view.setChecked(checked);
        return this;
    }

    /**
     * 关于事件的
     */
    public YHListViewHolder setOnClickListener(int viewId,
                                               View.OnClickListener listener)
    {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public YHListViewHolder setOnTouchListener(int viewId,
                                               View.OnTouchListener listener)
    {
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    public YHListViewHolder setOnLongClickListener(int viewId,
                                                   View.OnLongClickListener listener)
    {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }


}
