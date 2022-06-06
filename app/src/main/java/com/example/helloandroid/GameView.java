package com.example.helloandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class GameView extends View {
    public static final int TARGET = R.drawable.ballon;
    private Paint paint;
    private Bitmap sun;
    private Rect sunRect;
    private int height;

    public GameView(Context context, int width, int height) {
        super(context);
        this.height = height;
        sun = BitmapFactory.decodeResource(getResources(), TARGET);

        float scale = ((float) width / (sun.getWidth() * 5));
        sunRect = new Rect(width - width / 5, 0, width,
                (int) (sun.getHeight() * scale));

        paint = new Paint();
        paint.setColor(0xFF000000);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10.0f);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(0, height, height / 10, paint);

        canvas.drawLine(0, height, height / 5, height - height / 5, paint);

        canvas.drawBitmap(sun, null, sunRect, paint);
    }
}
