package Model;

import java.util.List;

/**
 * Created by Seth Cohen on 10/29/2017.
 */

public class RSSObject {


    private String status;
    private Feed feed;
    private List<Item> items;

    public RSSObject(String status, Feed feed, List<Item> items) {
        this.status = status;
        this.feed = feed;
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public Feed getFeed() {
        return feed;
    }

    public List<Item> getItems() {
        return items;
    }

}
