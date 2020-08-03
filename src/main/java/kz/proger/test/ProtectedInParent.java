package kz.proger.test;

public abstract class ProtectedInParent {
    void publicMethod() {
        System.out.println("Public");
    }

    protected abstract void method1();
}

class Child extends ProtectedInParent {

    private final ProtectedInParent delegate;

    Child(ProtectedInParent delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void method1() {
        delegate.method1();
    }
}
