package org.yh.yhframe.base;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;

import org.yh.library.YHActivity;
import org.yh.yhframe.R;
import org.yh.yhframe.view.YhToolbar;
import org.zackratos.ultimatebar.UltimateBar;

/**
 * Created by yhlyl on 2017/4/25.
 */

public abstract class BaseActiciy extends YHActivity
{
    public YhToolbar toolbar;//标题栏
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        UltimateBar ultimateBar = new UltimateBar(this);
        ultimateBar.setColorBar(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initWidget()
    {
        super.initWidget();
        try
        {
            toolbar = (YhToolbar) findViewById(R.id.simple_toolbar);
            toolbar = bindView(R.id.simple_toolbar);
            toolbar.setRightTitleClickListener(this);
            toolbar.setLeftTitleClickListener(this);
        }
        catch (NullPointerException e)
        {
            throw new NullPointerException(
                    "TitleBar Notfound from Activity layout");
        }
    }

    @Override
    public void widgetClick(View v)
    {
        super.widgetClick(v);
        switch (v.getId())
        {
            case R.id.txt_right_title:
                onMenuClick();
                break;
            case R.id.txt_left_title:
                onBackClick();
                break;
        }
    }

    protected void onBackClick()
    {
    }

    protected void onMenuClick()
    {
    }
}
