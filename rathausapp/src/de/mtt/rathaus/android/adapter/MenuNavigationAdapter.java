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
import de.mtt.rathaus.android.model.MenuNavigation;


public class MenuNavigationAdapter extends ArrayAdapter<MenuNavigation> {

	static class ViewHolder {
		ImageView icon;
		TextView status;
		TextView title;
	}

	Context context;

	List<MenuNavigation> objects;

	public MenuNavigationAdapter(Context context, List<MenuNavigation> objects) {
		super(context, 0, objects);
		this.context = context;
		this.objects = objects;
	}


	@Override
	public int getCount() {
		return this.objects.size();
	}

	@Override
	public MenuNavigation getItem(int position) {
		return this.objects.get(position);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.adapter_menu_navigation, null,
					false);

			ViewHolder holder = new ViewHolder();
			holder.icon = (ImageView) convertView.findViewById(R.id.icon);
			holder.title = (TextView) convertView.findViewById(R.id.title);
			holder.status = (TextView) convertView.findViewById(R.id.status);
			convertView.setTag(holder);
		}
		ViewHolder holder = (ViewHolder)convertView.getTag();
		// update the text:
		MenuNavigation object = getItem(position);
		if (object != null) {
			holder.icon.setImageResource(object.getIcon());
			holder.title.setText(object.getTitle());
			if(object.getStatus()==null || object.getStatus().equals("")){
				holder.status.setVisibility(View.GONE);
			}else{
				holder.status.setVisibility(View.VISIBLE);
				holder.status.setText(object.getStatus());
			}
		}

		return convertView;
	}

	public void setStatus(int position, int count){
		if(position==0){
			//get the number of new events
			if(count>0) {
				getItem(position).setStatus(String.valueOf(count));
				notifyDataSetChanged();
			}
		}

	}

}
