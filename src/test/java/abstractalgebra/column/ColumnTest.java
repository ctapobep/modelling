package abstractalgebra.column;

import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldElement;
import abstractalgebra.abstractions.Group;
import abstractalgebra.abstractions.GroupAssert2;
import abstractalgebra.reals.Real;
import abstractalgebra.reals.RealField;
import abstractalgebra.reals.RealGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ColumnTest {
    @Test public void formsGroupUnderAddition() {
        Field<Real> realField = RealField.create();
        RealGenerator realGenerator = new RealGenerator();
        ColumnGenerator<Real> generator = new ColumnGenerator<>(realField, realGenerator);
        Group<Column<Real>> columnGroup = new Group<>(new ColumnAddition<>(realField, generator.getDims()));
        new GroupAssert2<>(columnGroup, generator).assertIsAbelianGroup();
    }
    @Test public void scalarMultiplicationIsCompatibleWithFieldMultiplication() {
        Field<Real> realField = RealField.create();
        RealGenerator realGenerator = new RealGenerator();
        FieldElement<Real> s1 = realField.create(realGenerator.generate()),
                          s2 = realField.create(realGenerator.generate());
        Column<Real> v = new ColumnGenerator<>(realField, realGenerator).generate();

        ColumnScalarMultiplication<Real> scalarMultiplication = new ColumnScalarMultiplication<>(realField, v.dims());
        assertEquals(
                scalarMultiplication.calcLeft(s1.multiply(s2), v),
                scalarMultiplication.calcLeft(s2, scalarMultiplication.calcLeft(s1, v)));
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
