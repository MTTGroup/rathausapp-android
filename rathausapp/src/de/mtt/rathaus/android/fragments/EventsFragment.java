package de.mtt.rathaus.android.fragments;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import de.mtt.rathaus.android.R;
import de.mtt.rathaus.android.activities.HomeActivity;
import de.mtt.rathaus.android.data.DataManager;
import de.mtt.rathaus.android.model.Event;

/**
 * @author vpham
 * EventsFragment represents upcoming Events
 */
public class EventsFragment extends Fragment {
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


	public EventsFragment() {
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
		List<Event> events = DataManager.getInstance(getActivity()).getEvents();
		events.size();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		return rootView;
	}
}
