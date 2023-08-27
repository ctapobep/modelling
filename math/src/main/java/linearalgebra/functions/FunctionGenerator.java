package linearalgebra.functions;

import abstractalgebra.abstractions.ValueGenerator;
import abstractalgebra.reals.Reals;

import static io.qala.datagen.RandomShortApi.sample;

public class FunctionGenerator implements ValueGenerator<Function> {
    @Override public Function random() {
        return sample(
                new Constant(new Reals().random()), new Sin(), new Cos()
        );
    }
}
