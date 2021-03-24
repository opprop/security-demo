package security;

import checkers.inference.InferenceChecker;
import checkers.inference.InferenceVisitor;
import org.checkerframework.common.basetype.BaseAnnotatedTypeFactory;
import org.checkerframework.framework.type.AnnotatedTypeMirror;

import javax.lang.model.element.ExecutableElement;

public class SecurityVisitor extends InferenceVisitor<SecurityChecker, BaseAnnotatedTypeFactory> {
    public SecurityVisitor(
            SecurityChecker checker,
            InferenceChecker ichecker,
            BaseAnnotatedTypeFactory factory,
            boolean infer) {
        super(checker, ichecker, factory, infer);
    }

    /**
     * Don't check that the constructor result is top. In the security type system, it is the expected
     * behavior that an object is created to be public.
     */
    @Override
    protected void checkConstructorResult(
            AnnotatedTypeMirror.AnnotatedExecutableType constructorType, ExecutableElement constructorElement) {}
}
