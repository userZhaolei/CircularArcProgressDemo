package com.zl.view;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class CircularArcProgressView extends View {

    /**
     * 前景色
     **/
    int frontColor;
    /**
     * 背景色
     **/
    int behindColor;
    /**
     * 文字大小
     **/
    float textSize;
    /**
     * 文字颜色
     **/
    int textColor;
    /**
     * 进度条宽度
     **/
    int progWidth;


    Paint textPaint;
    Paint fontPaint;
    Paint behindPaint;
    private int resultW;
    private int resultH;

    CircularArcProgressViewListener circularArcProgressViewListener;

    int progress = 0;

    public CircularArcProgressView(Context context) {
        this(context, null);
    }

    public CircularArcProgressView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircularArcProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray t = getContext().obtainStyledAttributes(attrs,
                R.styleable.CircularArcProgressView);
        behindColor = t.getColor(R.styleable.CircularArcProgressView_frontColor, Color.RED);
        frontColor = t.getColor(R.styleable.CircularArcProgressView_behindColor, Color.parseColor("#FFB6C1"));
        textColor = t.getColor(R.styleable.CircularArcProgressView_textColor, Color.BLACK);
        textSize = t.getDimension(R.styleable.CircularArcProgressView_textSize, 30);
        progWidth = (int) t.getDimension(R.styleable.CircularArcProgressView_prgWidth, 80);

        init();
    }

    private void init() {
        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(textColor);
        textPaint.setTextSize(textSize);

        fontPaint = new Paint();
        fontPaint.setAntiAlias(true);
        fontPaint.setStrokeCap(Paint.Cap.ROUND);
        fontPaint.setColor(frontColor);
        fontPaint.setStrokeWidth(progWidth);


        behindPaint = new Paint();
        behindPaint.setAntiAlias(true);
        behindPaint.setStrokeCap(Paint.Cap.ROUND);
        behindPaint.setColor(behindColor);
        behindPaint.setStrokeWidth(progWidth);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int starX = getPaddingLeft() + 40;
        int starY = getPaddingTop() + getStatusBarHeight(getContext());

        int stopX = resultW - getPaddingRight() - 40;
        int stopY = starY;

        fontPaint.setColor(frontColor);
        canvas.drawLine(starX, starY, stopX, stopY, fontPaint);

        behindPaint.setColor(behindColor);
        float current = (stopX - starX) / 100f * progress + starX;
        canvas.drawLine(starX, starY, current, stopY, behindPaint);

        canvas.drawText(progress + "%", current - starX - textSize, starY + 10, textPaint);

  /*    paint.setStrokeWidth(40);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        path = new Path();
        path.moveTo(100,400);
        path.lineTo(100,400);
        path.lineTo(800,400);
        canvas.drawPath(path,  paint);

        int current = (800 - 100) / 100 * endx;
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        path = new Path();
        path.moveTo(100,400);
        path.lineTo(100,400);
        path.lineTo(current,400);
        canvas.drawPath(path,  paint);*/
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        /**resultW 代表最终设置的宽，resultH 代表最终设置的高*/
        resultW = widthSize;
        resultH = heightSize;

        /**计算尺寸的时候要将自身的 padding 考虑进去*/
        int contentW = getPaddingLeft() + getPaddingRight() + 300;
        int contentH = getPaddingTop() + getPaddingBottom() + 150;

        if (widthMode == MeasureSpec.AT_MOST) {
            resultW = contentW < widthSize ? contentW : widthSize;
        }

        if (heightMode == MeasureSpec.AT_MOST) {
            resultH = contentH < heightSize ? contentH : heightSize;
        }
        Log.d("circular", "onMeasure: " + resultH + ":" + widthSize);

        setMeasuredDimension(resultW, resultH);
    }


    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }

    public void setProgress(int progress) {
        if (progress > 100) {
            this.progress = 100;
            if(circularArcProgressViewListener!=null){
                circularArcProgressViewListener.success();
            }
            return;
        }
        this.progress = progress;
        invalidate();
    }

    public void setProgressWidth(int width) {
        this.progWidth = width;
        invalidate();
    }

    public void setProgressFrontColor(int color) {
        this.frontColor = color;
        invalidate();
    }

    public void setProgressBehindColor(int color) {
        this.behindColor = color;
        invalidate();
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
        invalidate();
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
        invalidate();
    }

    public void addCircularArcProgressViewListener(CircularArcProgressViewListener listener) {
        this.circularArcProgressViewListener = listener;
    }


    public interface CircularArcProgressViewListener {
        void success();
    }

}
