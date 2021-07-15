package linearalgebra.functions;

import abstractalgebra.abstractions.ValueGenerator;
import abstractalgebra.reals.RealGenerator;

import static io.qala.datagen.RandomShortApi.sample;

public class FunctionGenerator implements ValueGenerator<Function> {
    @Override public Function random() {
        return sample(
                new Constant(new RealGenerator().random()), new Sin(), new Cos()
        );
    }
}
