package de.mtt.rathaus.android.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import de.mtt.rathaus.android.R;
import de.mtt.rathaus.android.activities.HomeActivity;

public class MapsFragment extends Fragment {
	/**
	 * The fragment argument representing the menu navigation id for this fragment.
	 */
	private static final String	ARG_MENU_NAVIGATION	= "menu_navigation_id";


	/**
	 * Customized Bundle Args for each Fragment
	 */
	public static MapsFragment newInstance(int sectionNumber) {
		MapsFragment fragment = new MapsFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_MENU_NAVIGATION, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}


	public MapsFragment() {
	}


	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		//Set the arguments
		((HomeActivity) activity).onFragmentAttached(getArguments().getInt(ARG_MENU_NAVIGATION));
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		return rootView;
	}

}
