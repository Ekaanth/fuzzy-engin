package com.squapl.sa.domain;

public class MyPojo
{
    private Item[] items;

    public Item[] getItems ()
    {
        return items;
    }

    public void setItems (Item[] items)
    {
        this.items = items;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [items = "+items+"]";
    }
}