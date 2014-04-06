package de.mtt.rathaus.android.model;

import java.util.Date;

/**
 * @author vpham
 * Event model entity
 */

public class Event {

	private Date createdAt;

	private String detail;

	private Date endDate;

	private String location;

	private String objectId;

	private String photo;

	private String shortDescription;

	private Date startDate;

	private String title;

	private Date updatedAt;


	public Event(){

	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Event other = (Event) obj;
		if (createdAt == null) {
			if (other.createdAt != null) {
				return false;
			}
		} else if (!createdAt.equals(other.createdAt)) {
			return false;
		}
		if (detail == null) {
			if (other.detail != null) {
				return false;
			}
		} else if (!detail.equals(other.detail)) {
			return false;
		}
		if (endDate == null) {
			if (other.endDate != null) {
				return false;
			}
		} else if (!endDate.equals(other.endDate)) {
			return false;
		}
		if (location == null) {
			if (other.location != null) {
				return false;
			}
		} else if (!location.equals(other.location)) {
			return false;
		}
		if (objectId == null) {
			if (other.objectId != null) {
				return false;
			}
		} else if (!objectId.equals(other.objectId)) {
			return false;
		}
		if (photo == null) {
			if (other.photo != null) {
				return false;
			}
		} else if (!photo.equals(other.photo)) {
			return false;
		}
		if (shortDescription == null) {
			if (other.shortDescription != null) {
				return false;
			}
		} else if (!shortDescription.equals(other.shortDescription)) {
			return false;
		}
		if (startDate == null) {
			if (other.startDate != null) {
				return false;
			}
		} else if (!startDate.equals(other.startDate)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (updatedAt == null) {
			if (other.updatedAt != null) {
				return false;
			}
		} else if (!updatedAt.equals(other.updatedAt)) {
			return false;
		}
		return true;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public String getDetail() {
		return detail;
	}



	public Date getEndDate() {
		return endDate;
	}



	public String getLocation() {
		return location;
	}



	public String getObjectId() {
		return objectId;
	}



	public String getPhoto() {
		return photo;
	}



	public String getShortDescription() {
		return shortDescription;
	}



	public Date getStartDate() {
		return startDate;
	}



	public String getTitle() {
		return title;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((detail == null) ? 0 : detail.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((objectId == null) ? 0 : objectId.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((shortDescription == null) ? 0 : shortDescription.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		return result;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public void setDetail(String detail) {
		this.detail = detail;
	}



	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


}
