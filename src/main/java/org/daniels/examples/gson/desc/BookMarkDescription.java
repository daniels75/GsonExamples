package org.daniels.examples.gson.desc;



public class BookMarkDescription extends Description {

    /**
     *
     */
    private static final long  serialVersionUID           = 1620929584643703387L;

    public static final String SESSION_BOOKMARK_START_STR = "#%#%@7";
    public static final String WATCHPOINT_START_STR       = "#%#%@8";

    private String         type;
    private boolean            fromBookMark               = false;
    private boolean            defaultBookMark            = false;



    public BookMarkDescription() {
        super();
    }



    public BookMarkDescription(String name) {
		this.name = name;
	}



	public boolean isDefaultBookMark() {
        return defaultBookMark;
    }

    public void setDefaultBookMark(final boolean defaultBookMark) {
        this.defaultBookMark = defaultBookMark;
    }

    public boolean isFromBookMark() {
        return fromBookMark;
    }

    public void setFromBookMark(final boolean fromBookMark) {
        this.fromBookMark = fromBookMark;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        final BookMarkDescription that = (BookMarkDescription) o;

        return uid.equals(that.uid);
    }



    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (defaultBookMark ? 1 : 0);
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "[Name:" + name + ", type:" + type + "]";
    }


}