package security;

import checkers.inference.BaseInferrableChecker;
import checkers.inference.InferenceChecker;
import checkers.inference.InferrableChecker;
import checkers.inference.SlotManager;
import checkers.inference.dataflow.InferenceAnalysis;
import checkers.inference.dataflow.InferenceTransfer;
import checkers.inference.model.ConstraintManager;
import org.checkerframework.common.basetype.BaseAnnotatedTypeFactory;
import org.checkerframework.framework.flow.CFTransfer;

public class SecurityChecker extends BaseInferrableChecker {

    @Override
    public void initChecker() {
        super.initChecker();
    }

    @Override
    public SecurityVisitor createVisitor(
            InferenceChecker ichecker, BaseAnnotatedTypeFactory factory, boolean infer) {
        return new SecurityVisitor(this, ichecker, factory, infer);
    }

    @Override
    public SecurityAnnotatedTypeFactory createRealTypeFactory(boolean infer) {
        return new SecurityAnnotatedTypeFactory(this, infer);
    }

    @Override
    public CFTransfer createInferenceTransferFunction(InferenceAnalysis analysis) {
        return new InferenceTransfer(analysis);
    }

    @Override
    public SecurityInferenceAnnotatedTypeFactory createInferenceATF(
            InferenceChecker inferenceChecker,
            InferrableChecker realChecker,
            BaseAnnotatedTypeFactory realTypeFactory,
            SlotManager slotManager,
            ConstraintManager constraintManager) {
        return new SecurityInferenceAnnotatedTypeFactory(
                inferenceChecker,
                realChecker.withCombineConstraints(),
                realTypeFactory,
                realChecker,
                slotManager,
                constraintManager);
    }

    @Override
    public boolean isInsertMainModOfLocalVar() {
        return false;
    }

    @Override
    public boolean withCombineConstraints() {
        return false;
    }
}
