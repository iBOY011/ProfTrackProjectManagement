package ma.ac.usms.ensak.util;

public class ListItem {
    private final String id;
    private final String title;

    public ListItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}