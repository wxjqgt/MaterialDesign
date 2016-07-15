package com.weibo.recycleview.flexBox;

import android.content.Context;

/**
 * Created by Administrator on 2016/7/15.
 */
public class DimenUtils
{
    public static int dip2px(Context context, float dpValue)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
