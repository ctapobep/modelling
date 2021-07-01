package abstractalgebra.reals;

import abstractalgebra.abstractions.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RealTest {
    @Test public void formsAbelianGroupUnderAddition() {
        new GroupAssert<>(realField().toRing().toAdditiveGroup()).assertIsAbelianGroup();
    }
    @Test public void formsAbelianGroupUnderMultiplication() {
        new GroupAssert<>(realField().toMultiplicativeGroup()).assertIsAbelianGroup();
    }
    @Test public void formsRingUnderAdditionAndMultiplication() {
        new RingAssert<>(new Ring<>(new RealAddition(), new RealMultiplication(), new RealGenerator())).assertIsRing();
    }
    @Test public void formsFieldUnderAdditionAndMultiplication() {
        new FieldAssert<>(RealField.create()).assertIsField();
    }
    @Test public void test() {
        RealGenerator valueGenerator = new RealGenerator();
        Field<Real> field = new Field<>(new RealAddition(), new RealMultiplication(), valueGenerator);
        FieldElement<Real> real1 = field.random();
        FieldElement<Real> real2 = field.random();
        assertEquals(real2.add(real1), real1.add(real2));
    }

    static Field<Real> realField() {
        RealGenerator valueGenerator = new RealGenerator();
        return new Field<>(new RealAddition(), new RealMultiplication(), valueGenerator);
    }
}