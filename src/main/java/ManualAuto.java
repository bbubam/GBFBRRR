import org.sikuli.script.Screen;

public class ManualAuto {

    boolean isRunning = true;


    public void run(Screen screen, String strImagePath, int intTotalLoop, int intWaitTime) throws Exception {
        while (isRunning) {
            try {
                System.out.println("Start of Loop");
                umamusume.clickImage(screen, strImagePath , "imgUmamusume" + ".png");
                umamusume.waitUntilImage(screen, strImagePath, "btnOK" + ".png");
                umamusume.clickImage(screen, strImagePath , "btnOK" + ".png");
                Thread.sleep(2000);

                if (umamusume.isExistScreen(screen, strImagePath, "imgElixir" + ".png")) {
                    umamusume.waitUntilImage(screen, strImagePath, "btnUse" + ".png");
                    umamusume.useElixir(screen, strImagePath, "qtyElixir" + ".png");
                    umamusume.waitUntilImage(screen, strImagePath, "btnOK" + ".png");
                    Thread.sleep(1000);
                    umamusume.clickImage(screen, strImagePath, "btnOK" + ".png");
                    Thread.sleep(1000);
                }

                umamusume.waitUntilImage(screen, strImagePath, "btnAtk" + ".png");

                if(umamusume.QuickSummon){
                    umamusume.clickImage(screen, strImagePath, "btnSummon" + ".png");
                }

                for (int i = 0; i < umamusume.intTurns; i++) {

                    umamusume.waitUntilImage(screen, strImagePath, "imgTurn" + (i+1) + ".png");
                    umamusume.waitUntilImage(screen, strImagePath, "btnAtk" + ".png");
                    System.out.println("Turn :" + (i+1));

                    String[] arrSkills = umamusume.mapSkills.get(i);
                    umamusume.arrDjeeta = arrSkills[0].split(",");
                    umamusume.arr2ndChar = arrSkills[1].split(",");
                    umamusume.arr3rdChar = arrSkills[2].split(",");
                    umamusume.arr4thChar = arrSkills[3].split(",");

                    if(!(umamusume.arr2ndChar[0].isEmpty())){
                        umamusume.clickImage(screen, strImagePath, "2ndChar" + ".png");
                        for (int j = 0; j < umamusume.arr2ndChar.length; j++) {
                            umamusume.clickImage(screen, strImagePath, "2ndChar" + umamusume.arr2ndChar[j] + ".png");
                            Thread.sleep(500);
                        }
                        umamusume.clickImage(screen, strImagePath, "btnBack" +   ".png");
                    }

                    if(!(umamusume.arr3rdChar[0].isEmpty())){
                        umamusume.clickImage(screen, strImagePath, "3rdChar" + ".png");
                        for (int j = 0; j < umamusume.arr3rdChar.length; j++) {
                            umamusume.clickImage(screen, strImagePath, "3rdChar" + umamusume.arr3rdChar[j] + ".png");
                            Thread.sleep(500);
                        }
                        umamusume.clickImage(screen, strImagePath, "btnBack" + ".png");
                    }

                    if(!(umamusume.arr4thChar[0].isEmpty())){
                        umamusume.clickImage(screen, strImagePath, "4thChar" + ".png");
                        for (int j = 0; j < umamusume.arr4thChar.length; j++) {
                            umamusume.clickImage(screen, strImagePath, "4thChar" + umamusume.arr4thChar[j] + ".png");
                            Thread.sleep(500);
                        }
                        umamusume.clickImage(screen, strImagePath, "btnBack" + ".png");
                    }

                    if(!(umamusume.arrDjeeta[0].isEmpty())){
                        umamusume.clickImage(screen, strImagePath, "Djeeta" + ".png");
                        for (int j = 0; j < umamusume.arrDjeeta.length; j++) {
                            umamusume.clickImage(screen, strImagePath, "Djeeta" + umamusume.arrDjeeta[j] + ".png");
                            Thread.sleep(500);
                        }
                    }

                    Thread.sleep(2000);
                    umamusume.clickImage(screen, strImagePath, "btnAtk" + ".png");
                    Thread.sleep(2000);
                    umamusume.clickImage(screen, strImagePath, "btnReload" + ".png");

                }

            }catch (Exception e) {
                if(e.toString().contains("CAPTCHA")){
                    System.out.println("Captcha Found - Stopping Bot");
                }else{
                    System.out.println("Error Found - Restarting Bot");
                    umamusume.clickImage(screen, strImagePath, "imgRefresh" + ".png");
                }
            }
        }
    }
}
