package abstractalgebra.column;

import abstractalgebra.abstractions.*;
import abstractalgebra.abstractions.VectorSpacesAssert;
import abstractalgebra.reals.Real;
import abstractalgebra.reals.RealField;
import org.junit.Test;

public class FieldColumnTest {
    @Test public void formsGroupUnderAddition() {
        Field<Real> realField = RealField.create();
        ColumnGenerator<Real> generator = new ColumnGenerator<>(realField);

        MonotypicalGroupOp<FieldColumn<Real>> vectorAddition = new ColumnAddition<>(realField, generator.dims());
        ColumnScalarMultiplication<Real> vectorScalarMultiplication = new ColumnScalarMultiplication<>(realField, generator.dims());
        VectorSpace<Real, FieldColumn<Real>> vectorSpace = new VectorSpace<>(
                vectorAddition,
                vectorScalarMultiplication,
                generator);

        new VectorSpacesAssert<>(vectorSpace, realField).assertIsVectorSpace();
    }
//    @Test public void scalarMultiplicationIsDistributiveWithRespectToVectorAddition() {
//        ColumnGenerator columnGenerator = new ColumnGenerator(field, fieldGenerator);
//        VectorMember v1 = columnGenerator.generate(),
//               v2 = columnGenerator.generate();
//        VectorScalarMultiplication vectorMultiplication = new VectorScalarMultiplication(columnGenerator.getDims());
//        VectorAddition vectorAddition = new VectorAddition(columnGenerator.getDims());
//        Real scalar = new RealGenerator().generate();
//        assertEquals(
//                vectorMultiplication.calc(scalar, vectorAddition.calc(v1, v2)),
//                vectorAddition.calc(vectorMultiplication.calc(scalar, v1), vectorMultiplication.calc(scalar, v2)));
//    }
//    @Test public void scalarMultiplicationIsDistributiveWithRespectToFieldAddition() {
//        ColumnGenerator columnGenerator = new ColumnGenerator(field, fieldGenerator);
//        VectorMember v = columnGenerator.generate();
//        VectorScalarMultiplication vectorMultiplication = new VectorScalarMultiplication(columnGenerator.getDims());
//        VectorAddition vectorAddition = new VectorAddition(columnGenerator.getDims());
//        Real scalar1 = new RealGenerator().generate(),
//             scalar2 = new RealGenerator().generate();
//        RealAddition realAddition = new RealAddition();
//        assertEquals(
//                vectorMultiplication.calc(realAddition.calc(scalar1, scalar2), v),
//                vectorAddition.calc(vectorMultiplication.calc(scalar1, v), vectorMultiplication.calc(scalar2, v)));
//    }
}
