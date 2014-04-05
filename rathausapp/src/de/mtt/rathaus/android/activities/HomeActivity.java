package de.mtt.rathaus.android.activities;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import de.mtt.rathaus.android.R;
import de.mtt.rathaus.android.fragments.AboutFragment;
import de.mtt.rathaus.android.fragments.ContactsFragment;
import de.mtt.rathaus.android.fragments.EventsFragment;
import de.mtt.rathaus.android.fragments.JobsFragment;
import de.mtt.rathaus.android.fragments.MapsFragment;
import de.mtt.rathaus.android.fragments.MenuNavigationFragment;
import de.mtt.rathaus.android.fragments.NewsFragment;
import de.mtt.rathaus.android.fragments.ProblemsFragment;


public class HomeActivity extends ActionBarActivity implements MenuNavigationFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
	 */
	private MenuNavigationFragment	mNavigationDrawerFragment;


	/**
	 * Used to store the last screen title. For use in {@link #restoreActionBar()}.
	 */
	private CharSequence				mTitle;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		mNavigationDrawerFragment = (MenuNavigationFragment) getSupportFragmentManager().findFragmentById(
				R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.global, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}


	public void onFragmentAttached(int index) {
		String[] titles = getResources().getStringArray(R.array.menu_navigation_items);
		mTitle = titles[index];
	}


	@Override
	public void onNavigationDrawerItemSelected(int index) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getSupportFragmentManager();

		switch(index){
		case 0:

			fragmentManager.beginTransaction().replace(R.id.container, EventsFragment.newInstance(index))
			.commit();
			break;
		case 1:
			fragmentManager.beginTransaction().replace(R.id.container, NewsFragment.newInstance(index))
			.commit();
			break;
		case 2:
			fragmentManager.beginTransaction().replace(R.id.container, ProblemsFragment.newInstance(index))
			.commit();
			break;
		case 3:
			fragmentManager.beginTransaction().replace(R.id.container, ContactsFragment.newInstance(index))
			.commit();
			break;
		case 4:
			fragmentManager.beginTransaction().replace(R.id.container, MapsFragment.newInstance(index))
			.commit();
			break;
		case 5:
			fragmentManager.beginTransaction().replace(R.id.container, JobsFragment.newInstance(index))
			.commit();
			break;
		case 6:
			fragmentManager.beginTransaction().replace(R.id.container, AboutFragment.newInstance(index))
			.commit();
			break;

		}
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_refresh) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

}
