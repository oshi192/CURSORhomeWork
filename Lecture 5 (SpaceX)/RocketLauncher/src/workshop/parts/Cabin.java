package workshop.parts;

import workshop.CabinProvider;

public class Cabin implements CabinProvider {
    private final int  height;
    private final int  width;
    private final int  weight;
    private final int  capacity;
    public Cabin(CabinVariants cv)
    {
        this.height=cv.height;
        this.width=cv.width;
        this.weight=cv.weight;
        this.capacity=cv.capacity;
    }

    @Override
    public int getMass() {
        return weight;
    }
}
