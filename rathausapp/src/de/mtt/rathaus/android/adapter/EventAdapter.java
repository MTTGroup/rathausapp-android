package de.mtt.rathaus.android.adapter;

import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;
import de.mtt.rathaus.android.model.Event;


public class EventAdapter extends ArrayAdapter<Event> {

	private final Context context;
	private final List<Event> objects;

	public EventAdapter(Context ctx, List<Event> obj){
		super(ctx,0,obj);
		this.context = ctx;
		this.objects = obj;
	}

}
