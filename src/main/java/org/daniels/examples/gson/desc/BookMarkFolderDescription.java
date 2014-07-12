package org.daniels.examples.gson.desc;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.gson.annotations.Expose;

public class BookMarkFolderDescription extends Description {

	/**
     *
     */
	private static final long serialVersionUID = 5578013884786573585L;

	public static final String ROOT = "ROOT";

	@Expose
	private List<Description> children;

	public BookMarkFolderDescription() {
		this(ROOT, "");
	}

	/**
	 * @param name
	 */
	public BookMarkFolderDescription(final String name) {
		this(name, "");
	}

	/**
	 * @param name
	 * @param uid
	 */
	public BookMarkFolderDescription(final String name, final String uid) {
		super(name, uid);
		children = Lists.newArrayList();
	}

	/**
	 * @return the children
	 */
	public List<Description> getChildren() {
		return children;
	}

	@Override
	public String toString() {
		final StringBuffer buf = new StringBuffer();
		buf.append("[Name:" + name + "]\n");
		if (children != null) {
			for (final Description desc : children) {
				buf.append(desc);
			}
		}
		buf.append("\n");
		return buf.toString();
	}

	public void addDescription(final Description desc) {
		if (children == null) {
			children = Lists.newArrayList();
		}
		children.add(desc);
	}

	public void removeDescription(final Description desc) {
		if (children == null) {
			children = Lists.newArrayList();
			return;
		}
		children.remove(desc);
	}

	public void setChildren(final List<Description> children) {
		this.children = children;
	}

	public boolean removeDescriptionFromChildren(final Description toRemove) {
		boolean found = false;

		if (children != null) {
			for (final Description desc : children) {

				if (desc.equals(toRemove)) {
					found = true;
					children.remove(desc);
					return found;
				}
				if (desc instanceof BookMarkFolderDescription) {
					found = ((BookMarkFolderDescription) desc)
							.removeDescriptionFromChildren(toRemove);
					if (found)
						return found;
				}
			}
		}

		return found;
	}

}