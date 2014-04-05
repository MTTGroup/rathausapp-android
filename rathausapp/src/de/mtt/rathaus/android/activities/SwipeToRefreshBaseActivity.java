package de.mtt.rathaus.android.activities;

import de.mtt.rathaus.android.R;
import de.mtt.rathaus.android.R.id;
import de.mtt.rathaus.android.R.layout;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class SwipeToRefreshBaseActivity extends ActionBarActivity implements SwipeRefreshLayout.OnRefreshListener {

	private SwipeRefreshLayout refreshLayout;

	public TextView text;

	/**
	 * Disables swipe gesture. It prevents manual gestures but keeps the option to show
	 * refreshing programatically.
	 */
	public void disableSwipe() {
		refreshLayout.setEnabled(false);
	}

	/**
	 * Enables swipe gesture
	 */
	public void enableSwipe() {
		refreshLayout.setEnabled(true);
	}

	/**
	 * It shows the SwipeRefreshLayout progress
	 */
	public void hideSwipeProgress() {
		refreshLayout.setRefreshing(false);
	}

	public void initSwipeOptions() {
		refreshLayout.setOnRefreshListener(this);
		setAppearance();
		disableSwipe();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_swipe_refresh);
		refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
		text = (TextView)findViewById(R.id.text);
	}

	/**
	 * It must be overriden by parent classes if manual swipe is enabled.
	 */
	@Override
	public void onRefresh() {
		// Empty implementation
	}

	private void setAppearance() {
		refreshLayout.setColorScheme(android.R.color.holo_blue_bright,
				android.R.color.holo_green_light,
				android.R.color.holo_orange_light,
				android.R.color.holo_red_light);
	}

	@Override
	public void setContentView(int layoutResID) {
		View v = getLayoutInflater().inflate(layoutResID, refreshLayout, false);
		setContentView(v);
	}

	@Override
	public void setContentView(View view) {
		setContentView(view, view.getLayoutParams());
	}

	@Override
	public void setContentView(View view, ViewGroup.LayoutParams params) {
		refreshLayout.addView(view, params);
		initSwipeOptions();
	}

	/**
	 * It shows the SwipeRefreshLayout progress
	 */
	public void showSwipeProgress() {
		refreshLayout.setRefreshing(true);
	}
}