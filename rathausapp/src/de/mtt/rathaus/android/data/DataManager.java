package de.mtt.rathaus.android.data;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQuery.CachePolicy;

import de.mtt.rathaus.android.model.Event;

/**
 * 
 * @author vpham
 * Singleton manage remote data from backend
 */
public class DataManager {

	private static DataManager instance;

	private static final String TAG = DataManager.class.getCanonicalName();

	public static final synchronized DataManager getInstance(Context ctx){
		if(instance == null){
			instance = new DataManager(ctx);
		}
		return instance;
	}

	private Context context = null;

	private List<Event> events = null;

	private DataManager(Context ctx){
		this.context = ctx;
	}

	public List<Event> getEvents(){
		events = new ArrayList<Event>();
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
		query.setCachePolicy(CachePolicy.NETWORK_ELSE_CACHE);

		try {
			List<ParseObject> objects = query.find();
			if(objects!=null && !objects.isEmpty()){
				for(int i = 0; i < objects.size(); i++){
					Event event = new Event();
					ParseObject object = objects.get(i);
					if(object!=null){
						event.setObjectId(object.getObjectId());
						event.setCreatedAt(object.getCreatedAt());
						event.setDetail(object.getString("Detail"));
						event.setEndDate(object.getDate("End_Date"));
						event.setLocation(object.getString("Location"));
						event.setPhoto(object.getString("Photo"));
						event.setShortDescription(object.getString("Short_Description"));
						event.setStartDate(object.getDate("Start_Date"));
						event.setTitle(object.getString("Title"));
						event.setUpdatedAt(object.getUpdatedAt());
						events.add(event);
					}
				}
			}
		} catch (ParseException e) {
			Log.d(TAG, "FAILED TO FETCH EVENTS LIST! ERROR : " + e.getMessage() );
		}

		return events;
	}


}
