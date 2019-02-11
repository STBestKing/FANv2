package com.example.suntao.fanv2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CircleView extends View {

    int degree = 0;
    public int speed = 0;
    Paint paint;
    Bitmap bitmap;
    Matrix matrix;
    float width1, height1;
    int black = R.drawable.fan;
    int yellow = R.drawable.fan_yellow;
    int fan = black;

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width1 = (float) (bitmap.getWidth() * 1.5 / 2);
        height1 = (float) (bitmap.getHeight() * 1.5 / 2);

/*        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(18);  */

        matrix = new Matrix();
        matrix.setScale(1.5f, 1.5f);
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(35, 40);
        canvas.rotate(degree, width1, height1);
        canvas.drawBitmap(bitmap, matrix, paint);
        degree = degree + speed;
        invalidate();
    }

    protected void change() {
        bitmap = BitmapFactory.decodeResource(getResources(), fan);
    }

}