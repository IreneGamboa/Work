package com.baccom.mipos.utilities;

import com.baccom.mipos.R;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class SignatureVoucher extends ActionBarActivity implements
		OnTouchListener {

	ImageView imageView;
	private Bitmap bitmap;
	private Canvas canvas;
	private Path path, circlePath;
	private Paint paint;
	float downx = 0, downy = 0, upx = 0, upy = 0;
	private static final float TOUCH_TOLERANCE = 4;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signature_voucher);
		
		getSupportActionBar().setIcon(android.R.color.transparent);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		
		imageView = (ImageView) this.findViewById(R.id.imageView1);
		
		Display currentDisplay = getWindowManager().getDefaultDisplay();
		@SuppressWarnings("deprecation")
		float dw = currentDisplay.getWidth();
		@SuppressWarnings("deprecation")
		float dh = currentDisplay.getHeight();
		
		bitmap = Bitmap.createBitmap((int)dw, (int)dh, Bitmap.Config.ARGB_8888);
		
		canvas = new Canvas(bitmap);
		
		paint = new Paint();
		paint.setColor(Color.BLACK);
		imageView.setImageBitmap(bitmap);
		imageView.setOnTouchListener(this);
		path = new Path();
		
	}
	
	
	

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		int action = event.getAction();
		switch (action){
		case MotionEvent.ACTION_DOWN:
			downx = event.getX();
			downy = event.getY();
			break;
		case MotionEvent.ACTION_MOVE:
			break;
		case MotionEvent.ACTION_UP:
			upx = event.getX();
			upy = event.getY();
			canvas.drawLine(downx, downy, upx, upx, paint);
			imageView.invalidate();
			break;
		case MotionEvent.ACTION_CANCEL:
			break;
		default:
			break;
		}
		return true;
	}

	public void makeSale(View view){
		Intent voucher = new Intent(this, Voucher.class);
		startActivity(voucher);
	}
}


//private void touch_start(float x, float y) {
//	path.reset();
//	path.moveTo(x, y);
//	downx = x;
//	downy = y;
//}
//
//private void touch_move(float x, float y) {
//	float dx = Math.abs(x - downx);
//	float dy = Math.abs(y - downy);
//	if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
//		path.quadTo(downx, downy, (x + downx) / 2, (y + downy) / 2);
//		downx = x;
//		downy = y;
//
//		circlePath.reset();
//		circlePath.addCircle(downx, downy, 30, Path.Direction.CW);
//	}
//}
//
//private void touch_up() {
//	path.lineTo(downx, downy);
//	circlePath.reset();
//	// commit the path to our offscreen
//	canvas.drawPath(path, paint);
//	// kill this so we don't double draw
//	path.reset();
//}
//
//@Override
//public boolean onTouch(View v, MotionEvent event) {
//	// TODO Auto-generated method stub
//	int action = event.getAction();
//	float x = event.getX();
//	float y = event.getY();
//	switch (action) {
//	case MotionEvent.ACTION_DOWN:
//		touch_start(x,y);
//		imageView.invalidate();
//		break;
//	case MotionEvent.ACTION_MOVE:
//		touch_move(x,y);
//		imageView.invalidate();
//		break;
//	case MotionEvent.ACTION_UP:
//		touch_up();
//		imageView.invalidate();
//		break;
//	case MotionEvent.ACTION_CANCEL:
//		break;
//	default:
//		break;
//	}
//	return true;
//}