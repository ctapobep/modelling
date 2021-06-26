package abstractalgebra.vectors;

import abstractalgebra.abstractions.ValueGenerator;
import abstractalgebra.reals.Real;
import abstractalgebra.reals.RealGenerator;

import static io.qala.datagen.RandomShortApi.integer;

public class VectorGenerator implements ValueGenerator<Vector> {
    private final int dims = integer(0, 50);

    @Override public Vector generate() {
        RealGenerator realGenerator = new RealGenerator();
        Real[] reals = new Real[dims];
        for (int i = 0; i < reals.length; i++)
            reals[i] = realGenerator.generate();
        return new Vector(reals);
    }
    public int getDims() {
        return dims;
    }
}
