package org.yh.yhframe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.yh.library.utils.LogUtils;

public class ThreeFragment extends BaseFragment
{

    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle)
    {
        return inflater.inflate(R.layout.fragment_three, container, false);
    }


    @Override
    protected void setActionBarRes(ActionBarRes actionBarRes)
    {
        actionBarRes.title = "Three";
        actionBarRes.mainImageId = R.mipmap.logo_white_210;
        actionBarRes.rightImageId = R.mipmap.icon_home_menu_more;
    }
    @Override
    public void onChange()
    {
        super.onChange();
        LogUtils.e(TAG,"ThreeFragment onChange()");
    }
}