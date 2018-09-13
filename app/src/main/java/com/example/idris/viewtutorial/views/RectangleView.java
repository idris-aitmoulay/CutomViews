package com.example.idris.viewtutorial.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.idris.viewtutorial.R;

public class RectangleView extends View {
    private int color = Color.MAGENTA;
    private int width = 100;
    private int heigth = 100;
    private int begin = 10;
    private int end = 10;


    private Rect rect;
    private Paint paint;

    public RectangleView(Context context) {
        super(context);
        init(null);
    }

    public RectangleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RectangleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public RectangleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(@Nullable AttributeSet set) {
        rect = new Rect();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        if (set == null)
            return;

        TypedArray ta = getContext().obtainStyledAttributes(set, R.styleable.RectangleView);
        color = ta.getColor(R.styleable.RectangleView_color, color);
        width = ta.getDimensionPixelSize(R.styleable.RectangleView_width, width);
        heigth = ta.getDimensionPixelSize(R.styleable.RectangleView_heigth, heigth);
        begin = ta.getDimensionPixelSize(R.styleable.RectangleView_begin, begin);
        end = ta.getDimensionPixelSize(R.styleable.RectangleView_end, end);

        ta.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        rect.left = begin;
        rect.top = end;
        rect.bottom = heigth + end;
        rect.right = width + begin;
        paint.setColor(color);
        canvas.drawRect(rect, paint);
    }
}
