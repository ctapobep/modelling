package abstractalgebra.abstractions;

public class GroupMember<T> extends MonoidMember<T> {

    public GroupMember(T value, MonotypicalGroupOp<T> add) {
        super(value, add);
    }

    public GroupMember<T> add(GroupMember<T> o2) {
        return new GroupMember<>(op.calc(value, o2.value), op);
    }
    public GroupMember<T> inverse() {
        return new GroupMember<>(this.op.inverse(this.value), op);
    }
}
