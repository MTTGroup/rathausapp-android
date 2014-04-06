package de.mtt.rathaus.android;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;


public class RathausApplication extends Application {

	public static final String PARSE_APPLICATION_ID = "LChRD35GzrvEBx0wous91BOz3H21EavBgg6iDOur";

	public static final String PARSE_CLIENT_KEY = "YwlxevjJBBh2BM0FOoK3BAIamrQc54vRWnbtcjsj";

	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
		Parse.initialize(this, PARSE_APPLICATION_ID, PARSE_CLIENT_KEY);


		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();

		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);

	}

}
