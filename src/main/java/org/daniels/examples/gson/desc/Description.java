package org.daniels.examples.gson.desc;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public  class Description implements Serializable {

	private static final long serialVersionUID = -7835051066025214938L;

	//@Expose
	protected String name;
	protected String uid;

	public Description() {

	}

	public Description(final String name) {
		super();
		this.name = name;
	}

	public Description(final String name, final String uid) {
		super();
		this.name = name;
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(final String uid) {
		this.uid = uid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Description other = (Description) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}
	
}
