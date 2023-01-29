package abstractalgebra.abstractions;

public class GroupElement<T> extends MonoidElement<T> {

    public GroupElement(T value, MonotypicalGroupOp<T> add) {
        super(value, add);
    }

    public GroupElement<T> add(GroupElement<T> o2) {
        return new GroupElement<>(op.calc(value, o2.value), op);
    }
    public GroupElement<T> inverse() {
        return new GroupElement<>(this.op.inverse(this.value), op);
    }
}
