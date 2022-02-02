import ctl.CtlModelChecker;
import ctl.Formula;
import kripke.Kripke;
import kripke.util.CtlFactory;
import kripke.util.KripkeFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CTLApplication {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please input tht correct path of json file");
            return;
        }

        String path = args[0].trim();
        try {
            Kripke kripke = KripkeFactory.build(path);

            CtlModelChecker ctlModelChecker = new CtlModelChecker(kripke);
            boolean flag = true;
            while (flag) {
                System.out.println("Please Input your ctl formula (press quit to quit the program): \n");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String ctl = br.readLine();
                if ("quit".equals(ctl)) {
                    flag = false;
                }
                Formula formula = CtlFactory.build(ctl);
                System.out.println(ctlModelChecker.checkCtlFormula(formula) + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
