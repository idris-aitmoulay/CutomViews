package com.example.idris.viewtutorial.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.idris.viewtutorial.R;

public class CircleView extends View {
    private int color = Color.MAGENTA;
    private int begin = 10;
    private int end = 10;
    private int rayon = 20;

    private Paint paint;

    public CircleView(Context context) {
        super(context);
        init(null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(@Nullable AttributeSet set) {

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        // if attrs null you should didn't do nothing.
        if (set == null)
            return;

        TypedArray ta = getContext().obtainStyledAttributes(set, R.styleable.CircleView);
        color = ta.getColor(R.styleable.CircleView_color, color);
        begin = ta.getDimensionPixelSize(R.styleable.CircleView_begin, begin);
        end = ta.getDimensionPixelSize(R.styleable.CircleView_end, end);
        rayon = ta.getDimensionPixelOffset(R.styleable.CircleView_rayon, rayon);

        ta.recycle();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(color);
        canvas.drawCircle(begin, end, rayon, paint);
    }
}
