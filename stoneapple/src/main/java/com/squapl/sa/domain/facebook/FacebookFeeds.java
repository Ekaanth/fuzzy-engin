package com.squapl.sa.domain.facebook;

public class FacebookFeeds {
	 private Feed feed;

	    public Feed getFeed ()
	    {
	        return feed;
	    }

	    public void setFeed (Feed feed)
	    {
	        this.feed = feed;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [feed = "+feed+"]";
	    }

}
