package abstractalgebra.reals;

import abstractalgebra.abstractions.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RealTest {
    @Test public void formsAbelianGroupUnderAddition() {
        new GroupAssert<>(realField().toRing().toAdditiveGroup(), new RealGenerator()).assertIsAbelianGroup();
    }
    @Test public void formsAbelianGroupUnderMultiplication() {
        new GroupAssert<>(realField().toMultiplicativeGroup(), new RealGenerator()).assertIsAbelianGroup();
    }
    @Test public void formsRingUnderAdditionAndMultiplication() {
        RealGenerator valueGenerator = new RealGenerator();
        new RingAssert<>(new Ring<>(new RealAddition(), new RealMultiplication(), valueGenerator), valueGenerator).assertIsRing();
    }
    @Test public void formsFieldUnderAdditionAndMultiplication() {
        RealGenerator valueGenerator = new RealGenerator();
        new FieldAssert<>(new Field<>(new RealAddition(), new RealMultiplication(), valueGenerator), valueGenerator).assertIsField();
    }
    @Test public void test() {
        RealGenerator valueGenerator = new RealGenerator();
        Field<Real> field = new Field<>(new RealAddition(), new RealMultiplication(), valueGenerator);
        RealGenerator reals = new RealGenerator();
        FieldElement<Real> real1 = field.create(reals.generate());
        FieldElement<Real> real2 = field.create(reals.generate());
        assertEquals(real2.add(real1), real1.add(real2));
    }

    static Field<Real> realField() {
        RealGenerator valueGenerator = new RealGenerator();
        return new Field<>(new RealAddition(), new RealMultiplication(), valueGenerator);
    }
}