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

        ta.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        rect.left = 10;
        rect.top = 10;
        rect.bottom = this.heigth + 10;
        rect.right = this.width + 10;
        paint.setColor(this.color);
        canvas.drawRect(rect, paint);
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
