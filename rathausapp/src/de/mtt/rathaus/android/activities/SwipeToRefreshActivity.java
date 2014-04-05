package de.mtt.rathaus.android.activities;

import android.os.Bundle;


public class SwipeToRefreshActivity extends SwipeToRefreshBaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onRefresh() {
		super.text.setText("IS REFRESHING");
		super.hideSwipeProgress();
	}

	@Override
	protected void onResume() {
		super.onResume();
		super.initSwipeOptions();
		super.enableSwipe();
	}
}
