import org.sikuli.script.Screen;

import java.util.Objects;

public class Arcarum {
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

                if(umamusume.strArcarumType.equals("Full Auto")){
                    if(umamusume.QuickSummon){
                        umamusume.clickImage(screen, strImagePath, "btnSummon" + ".png");
                    }
                    if (umamusume.V1orV2.equalsIgnoreCase("V1")) {
                        umamusume.waitUntilImage(screen, strImagePath, "btnFullAuto" + ".png");
                        umamusume.clickImage(screen, strImagePath, "btnFullAuto" + ".png");
                    } else {
                        umamusume.waitUntilImage(screen, strImagePath, "btnFullAutoV2" + ".png");
                        umamusume.clickImage(screen, strImagePath, "btnFullAutoV2" + ".png");
                    }
                    if(umamusume.isExistScreen(screen, strImagePath, umamusume.characterName + ".png")){
                        umamusume.clickImage(screen, strImagePath, umamusume.characterName + ".png");
                        umamusume.clickImage(screen, strImagePath, umamusume.characterSkill + ".png");
                        umamusume.clickImage(screen, strImagePath, "btnBack" + ".png");
                    }
                }else if (umamusume.strArcarumType.equals("Wanpan")){
                    umamusume.clickImage(screen, strImagePath, "btnAtk" + ".png");
                    Thread.sleep(2000);
                    umamusume.clickImage(screen, strImagePath, "btnBackBelow" + ".png");
                }else if(umamusume.strArcarumType.equals(("Luchador"))){
                    if(umamusume.QuickSummon){
                        umamusume.clickImage(screen, strImagePath, "btnSummon" + ".png");
                    }

                    if(!umamusume.str2ndChar.equals("")){
                        umamusume.clickImage(screen, strImagePath, "2ndChar" + ".png");
                        for (int i = 0; i < umamusume.arr2ndChar.length; i++) {
                            umamusume.clickImage(screen, strImagePath, "2ndChar" + umamusume.arr2ndChar[i] + ".png");
                            Thread.sleep(500);
                        }
                        umamusume.clickImage(screen, strImagePath, "btnBack" +   ".png");
                    }

                    if(!umamusume.str3rdChar.equals("")){
                        umamusume.clickImage(screen, strImagePath, "3rdChar" + ".png");
                        for (int i = 0; i < umamusume.arr3rdChar.length; i++) {
                            umamusume.clickImage(screen, strImagePath, "3rdChar" + umamusume.arr3rdChar[i] + ".png");
                            Thread.sleep(500);
                        }
                        umamusume.clickImage(screen, strImagePath, "btnBack" + ".png");
                    }

                    if(!umamusume.str4thChar.equals("")){
                        umamusume.clickImage(screen, strImagePath, "4thChar" + ".png");
                        for (int i = 0; i < umamusume.arr4thChar.length; i++) {
                            umamusume.clickImage(screen, strImagePath, "4thChar" + umamusume.arr4thChar[i] + ".png");
                            Thread.sleep(500);
                        }
                        umamusume.clickImage(screen, strImagePath, "btnBack" + ".png");
                    }

                    if(!umamusume.strDjeeta.equals("")){
                        umamusume.clickImage(screen, strImagePath, "Djeeta" + ".png");
                        for (int i = 0; i < umamusume.arrDjeeta.length; i++) {
                            umamusume.clickImage(screen, strImagePath, "Djeeta" + umamusume.arrDjeeta[i] + ".png");
                            Thread.sleep(500);
                        }
                    }

                    umamusume.clickImage(screen, strImagePath, "btnAtk" + ".png");
                    umamusume.waitUntilImage(screen, strImagePath, "btnNext" + ".png");
                    umamusume.clickImage(screen, strImagePath, "btnNext" + ".png");
                }
                umamusume.waitUntilImage(screen, strImagePath, "txtExpGained" + ".png");
                umamusume.clickImage(screen, strImagePath, "btnSandboxStage" + ".png");
                Thread.sleep(3000);
                System.out.println("End of Loop : ");
            } catch (Exception e) {
                if (e.toString().contains("CAPTCHA")) {
                    System.out.println("Captcha Found - Stopping Bot");
                } else {
                    System.out.println("Error Found - Restarting Bot");
                    umamusume.clickImage(screen, strImagePath, "imgRefresh" + ".png");
                }
            }
        }
    }
}
