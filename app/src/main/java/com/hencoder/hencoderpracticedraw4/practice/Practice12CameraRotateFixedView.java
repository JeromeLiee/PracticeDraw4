package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice12CameraRotateFixedView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    Camera camera = new Camera();
    Matrix matrix = new Matrix();

    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float centerX1 = point1.x + bitmap.getWidth() / 2f;
        float centerY1 = point1.y + bitmap.getHeight() / 2f;
        float centerX2 = point2.x + bitmap.getWidth() / 2f;
        float centerY2 = point2.y + bitmap.getHeight() / 2f;

//        canvas.save();
//        camera.save();
//        camera.rotateX(30);
//        canvas.translate(centerX1, centerY1);
//        camera.applyToCanvas(canvas);
//        canvas.translate(-centerX1, -centerY1);
//        camera.restore();
//        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
//        canvas.restore();
//
//        canvas.save();
//        camera.save();
//        camera.rotateY(30);
//        canvas.translate(centerX2, centerY2);
//        camera.applyToCanvas(canvas);
//        canvas.translate(-centerX2, -centerY2);
//        camera.restore();
//        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
//        canvas.restore();

        canvas.save();
        matrix.reset();
        camera.save();
        camera.rotateX(30);
        camera.getMatrix(matrix);
        camera.restore();

        matrix.preTranslate(-centerX1, -centerY1);
        matrix.postTranslate(centerX1, centerY1);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        matrix.reset();
        camera.save();
        camera.rotateY(30);
        camera.getMatrix(matrix);
        camera.restore();

        matrix.preTranslate(-centerX2, -centerY2);
        matrix.postTranslate(centerX2, centerY2);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
