import ctl.CtlModelChecker;
import ctl.Formula;
import ctl.atoms.False;
import kripke.Kripke;
import kripke.util.CtlFactory;
import kripke.util.KripkeFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CTLApplication {
    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("Please input tht correct path of json file");
            return;
        }

        String path = args[0].trim();
        try {
            Kripke kripke = KripkeFactory.build(path);

            CtlModelChecker ctlModelChecker = new CtlModelChecker(kripke);
//            Scanner scanner = new Scanner(System.in);
            boolean flag = true;
            while (flag){
                System.out.println("Input your ctl formula please\n");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String ctl = br.readLine();
                if ("quit".equals(ctl)){
                    flag=false;
                }
                Formula formula = CtlFactory.build(ctl);
                System.out.println(ctlModelChecker.checkCtlFormula(formula));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
