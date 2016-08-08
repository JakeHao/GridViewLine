package com.jake.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

public class GridViewLine extends GridView
{
    private float lineWidth = 1;
    private int lineColor = Color.GRAY;

    public GridViewLine(Context context)
    {
        super(context);
        init(context, null);
    }

    public GridViewLine(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context, attrs);
    }

    public GridViewLine(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attr)
    {
        if (attr != null)
        {
            TypedArray array = context.obtainStyledAttributes(attr, R.styleable.GridViewLine);
            lineColor = array.getColor(R.styleable.GridViewLine_line_color, Color.GRAY);
            lineWidth = array.getDimension(R.styleable.GridViewLine_line_width, 5);
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        int childCount = getChildCount();
        Paint paint = new Paint();
        paint.setStrokeWidth(lineWidth);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(lineColor);
        for (int i = 0; i < childCount; i++)
        {
            View cellView = getChildAt(i);
            canvas.drawLine(cellView.getRight(), cellView.getTop(), cellView.getRight(), cellView.getBottom(), paint);
            canvas.drawLine(cellView.getLeft(), cellView.getBottom(), cellView.getRight(), cellView.getBottom(), paint);
        }
    }
}
