package de.mtt.rathaus.android.interfaces;


/**
 * Listener for Menu Navigation Item Update.
 * For example: new Events, new Contacts, new Jobs...
 */

public interface OnMenuNavigationUpdatedListener {

	public void onMenuNavigationUpdated(int position, String status);

}
