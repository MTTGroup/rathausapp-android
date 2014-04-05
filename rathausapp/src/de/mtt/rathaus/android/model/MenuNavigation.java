package de.mtt.rathaus.android.model;


public class MenuNavigation{

	private int icon;
	private int id;
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


	public int getId() {
		return id;
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


	public void setId(int id) {
		this.id = id;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public void setTitle(String title) {
		this.title = title;
	}


}