package cleancode.studycafe.tobe_pr;

import cleancode.studycafe.tobe_pr.io.provider.LockerPassFileReader;
import cleancode.studycafe.tobe_pr.io.provider.SeatPassFileReader;
import cleancode.studycafe.tobe_pr.provider.LockerPassProvider;
import cleancode.studycafe.tobe_pr.provider.SeatPassProvider;

public class StudyCafeApplication {

    public static void main(String[] args) {
        SeatPassProvider seatPassProvider = new SeatPassFileReader();
        LockerPassProvider lockerPassProvider = new LockerPassFileReader();
        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(
                seatPassProvider,
                lockerPassProvider
        );
        studyCafePassMachine.run();
    }

}
