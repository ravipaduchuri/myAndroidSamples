package com.defyApps.myandroidsamples.customwidgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.defyApps.myandroidsamples.R;

/**
 * 
 * Provides Edit text with show/hide buttons to make the password text readable
 * or not
 * 
 */
public class CustomPasswordField extends EditText {

	//
	private Drawable imgShowButton = getResources().getDrawable(
			R.drawable.icon_show);
	private Drawable imgHideButton = getResources().getDrawable(
			R.drawable.icon_hide);

	public CustomPasswordField(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	void init() {
		// Set bounds of the Clear button
		imgShowButton.setBounds(0, 0, imgShowButton.getIntrinsicWidth(),
				imgShowButton.getIntrinsicHeight());
		imgHideButton.setBounds(0, 0, imgHideButton.getIntrinsicWidth(),
				imgHideButton.getIntrinsicHeight());

		CustomPasswordField bacTextView = CustomPasswordField.this;
		bacTextView.setPadding(bacTextView.getPaddingLeft(),
				bacTextView.getPaddingTop(),
				bacTextView.getPaddingRight() + 20,
				bacTextView.getPaddingBottom());

		// Display Show button by default
		this.setCompoundDrawables(this.getCompoundDrawables()[0],
				this.getCompoundDrawables()[1], imgShowButton,
				this.getCompoundDrawables()[3]);

		// Display Show/Hide button
		this.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				CustomPasswordField bacTextView = CustomPasswordField.this;
				if (bacTextView.getCompoundDrawables()[2] == null) {
					return false;
				}
				if (event.getAction() != MotionEvent.ACTION_UP) {
					return false;
				}
				if (event.getX() > bacTextView.getWidth()
						- bacTextView.getPaddingRight()
						- imgShowButton.getIntrinsicWidth()) {
					// Toggle between Show and Hide
					toggleHideShowButton();
				}
				return false;
			}
		});
	}

	// Display Show/Hide buttons and make the password text as readable or not
	void toggleHideShowButton() {
		int selectionChar = this.getSelectionStart();

		// Display Show Button and make the password readable
		if (this.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
			this.setCompoundDrawables(this.getCompoundDrawables()[0],
					this.getCompoundDrawables()[1], imgShowButton,
					this.getCompoundDrawables()[3]);
			this.setInputType(129);
			this.setSelection(selectionChar);
		} else {
			// Display Hide Button and make the password unreadable
			this.setCompoundDrawables(this.getCompoundDrawables()[0],
					this.getCompoundDrawables()[1], imgHideButton,
					this.getCompoundDrawables()[3]);
			this.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
			this.setSelection(selectionChar);
		}
	}

}
