package mypackage;

public class Cost
{
    public int calc(int x1,int x2,int y1,int y2)
    {
        int ret=((x1-x2)+(y1-y2))^2;
        return ret;
    }
    public int calc(int x1,int x2,int y1,int y2,int z1,int z2)
    {
        int ret=((x1-x2)+(y1-y2))^2 +((y1-z1)+(y2-z2))^2;
        return ret;
    }
}
