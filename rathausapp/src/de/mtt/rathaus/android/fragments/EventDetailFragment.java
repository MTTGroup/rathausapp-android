package de.mtt.rathaus.android.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.mtt.rathaus.android.R;
import de.mtt.rathaus.android.activities.HomeActivity;
import de.mtt.rathaus.android.fragments.EventsFragment.OnEventSelectedListener;
import de.mtt.rathaus.android.model.Event;
import de.mtt.rathaus.android.utils.Helper;

public class EventDetailFragment extends Fragment implements OnEventSelectedListener {

	/**
	 * Customized Bundle Args for each Fragment
	 */
	public static EventDetailFragment newInstance() {
		EventDetailFragment fragment = new EventDetailFragment();
		return fragment;
	}
	private TextView detail;
	private TextView endDate;
	private Event event;
	private ImageView icon;
	private TextView startDate;

	private TextView title;

	public EventDetailFragment() {
	}
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		//set the title
		ActionBar actionBar = ((HomeActivity) getActivity()).getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(R.string.fragment_title_event_detail);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_event_detail, container, false);
		title = (TextView)rootView.findViewById(R.id.title);
		startDate = (TextView)rootView.findViewById(R.id.startDate);
		endDate = (TextView)rootView.findViewById(R.id.endDate);
		icon = (ImageView)rootView.findViewById(R.id.icon);
		detail = (TextView)rootView.findViewById(R.id.detail);

		title.setText(event.getTitle());
		startDate.setText(Helper.formatDate(event.getStartDate()));
		endDate.setText(Helper.formatDate(event.getEndDate()));
		detail.setText(event.getDetail());
		Picasso.with(getActivity()).setDebugging(true);
		Picasso.with(getActivity()).load(event.getPhoto()).error(R.drawable.ic_action_error).into(icon);

		return rootView;
	}


	@Override
	public void onEventSelected(Event event) {
		this.event = event;
	}


	@Override
	public void onResume() {
		super.onResume();

	}

}
