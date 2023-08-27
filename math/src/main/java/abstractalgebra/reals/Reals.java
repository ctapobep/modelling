package abstractalgebra.reals;

import functions.Set;

import java.math.BigDecimal;
import java.util.HashSet;

import static io.qala.datagen.RandomShortApi.Double;

public class Reals implements Set<Real> {
    private final Real min, max;
    private final HashSet<Real> excluded = new HashSet<>();

    public Reals() {
        this(new Real(-1000), new Real(1000));
    }

    public Reals(Real min, Real max) {
        this(min, max, new HashSet<>());
    }
    public Reals(Real min, Real max, java.util.Set<Real> exclusion) {
        this.min = min;
        this.max = max;
        this.excluded.addAll(exclusion);
    }

    public Real random() {
        Real real;
        do {
            real = new Real(BigDecimal.valueOf(Double(min.asDouble(), max.asDouble())));
        } while(!contains(real));
        return real;
    }

    public boolean contains(Real r) {
        if(this.excluded.contains(r))
            return false;
        BigDecimal val = r.asBigDecimal();
        return val.compareTo(min.asBigDecimal()) >= 0 && val.compareTo(max.asBigDecimal()) <= 0;
    }
}
