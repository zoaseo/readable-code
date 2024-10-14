package cleancode.studycafe.tobe_pr.io.provider;

import cleancode.studycafe.tobe_pr.model.StudyCafePassType;
import cleancode.studycafe.tobe_pr.model.StudyCafeSeatPass;
import cleancode.studycafe.tobe_pr.model.StudyCafeSeatPasses;
import cleancode.studycafe.tobe_pr.provider.SeatPassProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SeatPassFileReader implements SeatPassProvider {

    private static final String PASS_LIST_CSV_PATH = "src/main/resources/cleancode/studycafe/pass-list.csv";

    @Override
    public StudyCafeSeatPasses getSeatPasses() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(PASS_LIST_CSV_PATH));
            List<StudyCafeSeatPass> studyCafePasses = new ArrayList<>();
            for (String line : lines) {
                String[] values = line.split(",");
                StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
                int duration = Integer.parseInt(values[1]);
                int price = Integer.parseInt(values[2]);
                double discountRate = Double.parseDouble(values[3]);

                StudyCafeSeatPass studyCafePass = StudyCafeSeatPass.of(studyCafePassType, duration, price, discountRate);
                studyCafePasses.add(studyCafePass);
            }

            return StudyCafeSeatPasses.of(studyCafePasses);
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }
}
