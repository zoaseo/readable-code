package cleancode.studycafe.tobe_pr.model;

import java.util.List;

public class StudyCafePasses {

    private final List<StudyCafePass> passes;

    private StudyCafePasses(List<StudyCafePass> passes) {
        this.passes = passes;
    }

    public static StudyCafePasses of(List<StudyCafePass> passes) {
        return new StudyCafePasses(passes);
    }

    public List<StudyCafePass> findPassBy(StudyCafePassType studyCafePassType) {
        return this.passes.stream()
                .filter(studyCafePass -> studyCafePass.isSamePassType(studyCafePassType))
                .toList();
    }
}
