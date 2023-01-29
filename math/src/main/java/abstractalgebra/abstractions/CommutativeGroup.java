package abstractalgebra.abstractions;

/**
 * AKA Abelian Group
 */
public class CommutativeGroup<T> extends Group<T> {

    public CommutativeGroup(MonotypicalGroupOp<T> add, ValueGenerator<T> valueGenerator) {
        super(add, valueGenerator);
        new GroupAssert<>(this).assertIsCommutativeGroup();
    }
}
