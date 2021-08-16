package security;

import checkers.inference.BaseInferenceRealTypeFactory;
import org.checkerframework.common.basetype.BaseAnnotatedTypeFactory;
import org.checkerframework.common.basetype.BaseTypeChecker;

public class SecurityAnnotatedTypeFactory extends BaseInferenceRealTypeFactory {
    public SecurityAnnotatedTypeFactory(BaseTypeChecker checker, boolean isInfer) {
        super(checker, isInfer);
        postInit();
    }
}
