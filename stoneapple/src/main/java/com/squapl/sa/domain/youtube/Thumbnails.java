package com.squapl.sa.domain.youtube;

public class Thumbnails
{
    private Default def;

    private High high;

    private Medium medium;

    public Default getDefault ()
    {
        return def;
    }

    public void setDefault (Default def)
    {
        this.def = def;
    }

    public High getHigh ()
    {
        return high;
    }

    public void setHigh (High high)
    {
        this.high = high;
    }

    public Medium getMedium ()
    {
        return medium;
    }

    public void setMedium (Medium medium)
    {
        this.medium = medium;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [default = "+def+", high = "+high+", medium = "+medium+"]";
    }
}
