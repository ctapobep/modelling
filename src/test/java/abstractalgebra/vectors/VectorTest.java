package abstractalgebra.vectors;

import abstractalgebra.abstractions.GroupAssert;
import abstractalgebra.reals.Real;
import abstractalgebra.reals.RealAddition;
import abstractalgebra.reals.RealGenerator;
import abstractalgebra.reals.RealMultiplication;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VectorTest {
    @Test public void formsGroupUnderAddition() {
        VectorGenerator generator = new VectorGenerator();
        new GroupAssert<>(new VectorAddition(generator.getDims()), generator).assertIsAbelianGroup();
    }
    @Test public void scalarIdentityExists() {
        VectorGenerator vectorGenerator = new VectorGenerator();
        Vector v = vectorGenerator.generate();
        VectorScalarMultiplication vectorMultiplication = new VectorScalarMultiplication(vectorGenerator.getDims());
        Real scalarIdentity = new RealMultiplication().identity();
        assertEquals(v, vectorMultiplication.calc(scalarIdentity, v));
    }
    @Test public void scalarMultiplicationIsDistributiveWithRespectToVectorAddition() {
        VectorGenerator vectorGenerator = new VectorGenerator();
        Vector v1 = vectorGenerator.generate(),
               v2 = vectorGenerator.generate();
        VectorScalarMultiplication vectorMultiplication = new VectorScalarMultiplication(vectorGenerator.getDims());
        VectorAddition vectorAddition = new VectorAddition(vectorGenerator.getDims());
        Real scalar = new RealGenerator().generate();
        assertEquals(
                vectorMultiplication.calc(scalar, vectorAddition.calc(v1, v2)),
                vectorAddition.calc(vectorMultiplication.calc(scalar, v1), vectorMultiplication.calc(scalar, v2)));
    }
    @Test public void scalarMultiplicationIsDistributiveWithRespectToFieldAddition() {
        VectorGenerator vectorGenerator = new VectorGenerator();
        Vector v = vectorGenerator.generate();
        VectorScalarMultiplication vectorMultiplication = new VectorScalarMultiplication(vectorGenerator.getDims());
        VectorAddition vectorAddition = new VectorAddition(vectorGenerator.getDims());
        Real scalar1 = new RealGenerator().generate(),
             scalar2 = new RealGenerator().generate();
        RealAddition realAddition = new RealAddition();
        assertEquals(
                vectorMultiplication.calc(realAddition.calc(scalar1, scalar2), v),
                vectorAddition.calc(vectorMultiplication.calc(scalar1, v), vectorMultiplication.calc(scalar2, v)));
    }
}
