package de.mtt.rathaus.android.fragments;

import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import de.mtt.rathaus.android.R;
import de.mtt.rathaus.android.activities.HomeActivity;
import de.mtt.rathaus.android.adapter.EventAdapter;
import de.mtt.rathaus.android.data.DataManager;
import de.mtt.rathaus.android.model.Event;

/**
 * @author vpham
 * EventsFragment represents upcoming Events
 */
public class EventsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
	/**
	 * The fragment argument representing the menu navigation id for this fragment.
	 */
	private static final String	ARG_MENU_NAVIGATION	= "menu_navigation_id";

	/**
	 * Customized Bundle Args for each Fragment
	 */
	public static EventsFragment newInstance(int sectionNumber) {
		EventsFragment fragment = new EventsFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_MENU_NAVIGATION, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	private EventAdapter adapter;

	private ListView eventList;

	private List<Event> events;

	private AsyncTask<Void, Void, List<Event>> fetchingTask;

	private SwipeRefreshLayout refreshLayout;

	public EventsFragment() {
	}


	private void fetching(){
		if(fetchingTask!=null ){
			fetchingTask.cancel(true);
			fetchingTask=null;
		}
		fetchingTask = new AsyncTask<Void, Void, List<Event>>(){
			@Override
			protected List<Event> doInBackground(Void... params) {
				events = DataManager.getInstance(getActivity()).getEvents();
				return events;
			}
			@Override
			protected void onPostExecute(List<Event> result) {
				super.onPostExecute(result);
				refreshLayout.setRefreshing(false);
				if(result!=null){
					adapter = new EventAdapter(getActivity(), result);
					eventList.setAdapter(adapter);
				}

			}
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				refreshLayout.setRefreshing(true);
			}
		}.execute();
	}


	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		//Set the arguments
		((HomeActivity) activity).onFragmentAttached(getArguments().getInt(ARG_MENU_NAVIGATION));
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		refreshLayout = (SwipeRefreshLayout)rootView.findViewById(R.id.swipe_container);
		refreshLayout.setOnRefreshListener(this);
		setAppearance();
		refreshLayout.setEnabled(true);
		refreshLayout.setRefreshing(false);
		eventList = (ListView)rootView.findViewById(R.id.eventList);

		return rootView;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if(id == R.id.action_refresh){
			fetching();
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onRefresh() {
		fetching();
	}

	@Override
	public void onResume() {
		super.onResume();
		fetching();
	}

	private void setAppearance() {
		refreshLayout.setColorScheme(R.color.orange_light,
				R.color.orange_dark,
				R.color.yellow_dark,
				R.color.yellow_light);
	}
}
