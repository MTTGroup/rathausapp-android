package de.mtt.rathaus.android.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import de.mtt.rathaus.android.R;
import de.mtt.rathaus.android.model.Event;
import de.mtt.rathaus.android.utils.Helper;


public class EventAdapter extends ArrayAdapter<Event> {

	static class ViewHolder {
		TextView endDate;
		ImageView icon;
		TextView location;
		TextView shortDescription;
		TextView startDate;
		TextView title;
	}


	private final Context context;
	private List<Event> objects;

	public EventAdapter(Context ctx, List<Event> obj){
		super(ctx,0,obj);
		this.context = ctx;
		this.objects = obj;
	}

	@Override
	public int getCount() {
		return this.objects.size();
	}

	@Override
	public Event getItem(int position) {
		return this.objects.get(position);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.adapter_event_item, null,
					false);

			ViewHolder holder = new ViewHolder();
			holder.icon = (ImageView) convertView.findViewById(R.id.icon);
			holder.title = (TextView) convertView.findViewById(R.id.title);
			holder.endDate = (TextView) convertView.findViewById(R.id.endDate);
			holder.startDate = (TextView) convertView.findViewById(R.id.startDate);
			holder.location = (TextView) convertView.findViewById(R.id.location);
			holder.shortDescription = (TextView) convertView.findViewById(R.id.shortDescription);
			convertView.setTag(holder);
		}
		ViewHolder holder = (ViewHolder)convertView.getTag();
		// update the text:
		Event object = getItem(position);
		if (object != null) {
			holder.title.setText(object.getTitle());
			holder.endDate.setText(Helper.formatDate(object.getEndDate()));
			holder.startDate.setText(Helper.formatDate(object.getStartDate()));
			holder.location.setText(object.getLocation());
			holder.shortDescription.setText(object.getShortDescription());
		}

		holder.icon.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});

		return convertView;
	}

	public void setEvents(List<Event> events){
		this.objects = events;
		notifyDataSetChanged();
	}
}
