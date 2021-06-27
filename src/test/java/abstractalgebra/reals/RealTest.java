package abstractalgebra.reals;

import abstractalgebra.abstractions.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RealTest {
    @Test public void formsAbelianGroupUnderAddition() {
        new GroupAssert2<>(realField().toRing().toAdditiveGroup(), new RealGenerator()).assertIsAbelianGroup();
    }
    @Test public void formsAbelianGroupUnderMultiplication() {
        new GroupAssert2<>(realField().toMultiplicativeGroup(), new RealGenerator()).assertIsAbelianGroup();
    }
    @Test public void formsRingUnderAdditionAndMultiplication() {
        new RingAssert<>(new Ring<>(new RealAddition(), new RealMultiplication()), new RealGenerator()).assertIsRing();
    }
    @Test public void formsFieldUnderAdditionAndMultiplication() {
        new FieldAssert<>(new Field<>(new RealAddition(), new RealMultiplication()), new RealGenerator()).assertIsField();
    }
    @Test public void test() {
        Field<Real> field = new Field<>(new RealAddition(), new RealMultiplication());
        RealGenerator reals = new RealGenerator();
        FieldMember<Real> real1 = field.create(reals.generate());
        FieldMember<Real> real2 = field.create(reals.generate());
        assertEquals(real2.add(real1), real1.add(real2));
    }

    static Field<Real> realField() {
        return new Field<>(new RealAddition(), new RealMultiplication());
    }
}