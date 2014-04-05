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
import de.mtt.rathaus.android.adapter.MenuNavigationAdapter.MenuNavigation;


public class MenuNavigationAdapter extends ArrayAdapter<MenuNavigation> {

	public class MenuNavigation{
		private int icon;
		private String status;
		private String title;

		public MenuNavigation(){
		}

		public MenuNavigation(int icon, String title, String status){
			this.icon = icon;
			this.title=title;
			this.status=status;
		}


		public int getIcon() {
			return icon;
		}


		public String getStatus() {
			return status;
		}


		public String getTitle() {
			return title;
		}


		public void setIcon(int icon) {
			this.icon = icon;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		public void setTitle(String title) {
			this.title = title;
		}


	};

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
			holder.title = (TextView) convertView.findViewById(R.id.status);
			holder.status = (TextView) convertView.findViewById(R.id.status);
			convertView.setTag(holder);
		}
		ViewHolder holder = (ViewHolder)convertView.getTag();
		// update the text:
		MenuNavigation object = getItem(position);
		if (object != null) {
			holder.icon.setImageResource(object.getIcon());
			holder.title.setText(object.getStatus());
			holder.status.setText(object.getStatus());
		}

		return convertView;
	}
}
