package com.squapl.sa.domain;

public class Item
{
    private Statistics statistics;

    public Statistics getStatistics ()
    {
        return statistics;
    }

    public void setStatistics (Statistics statistics)
    {
        this.statistics = statistics;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [statistics = "+statistics+"]";
    }
}
