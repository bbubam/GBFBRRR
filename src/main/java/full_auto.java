import org.sikuli.script.Screen;

public class full_auto {
    public void run(Screen screen, String strImagePath, int intTotalLoop, int intWaitTime)throws Exception{
        for (int i = 0; i < intTotalLoop; i++) {
            umamusume.clickImage(screen, strImagePath , "imgUmamusume" + ".png");
            umamusume.waitUntilImage(screen,strImagePath , "btnSelectSummon" + ".png");
            umamusume.findSummon(screen,strImagePath);
            umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
            Thread.sleep(intWaitTime);

            if(umamusume.isExistScreen(screen,strImagePath, "txtCaptcha" + ".png")){
                do{
                    umamusume.PlaySong(strImagePath);
                }while(umamusume.isExistScreen(screen,strImagePath, "txtCaptcha" + ".png"));
            }

            if(umamusume.isExistScreen(screen,strImagePath , "imgElixir" + ".png")){
                umamusume.waitUntilImage(screen,strImagePath , "btnUse" + ".png");
                umamusume.useElixir(screen,strImagePath , "btnUse" + ".png");
                umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
            }

            if(umamusume.isOugi){
              if(umamusume.isExistScreen(screen,strImagePath , "btnOugiOff" + ".png"))
                  umamusume.clickImage(screen,strImagePath , "btnOugiOff" + ".png");
            }
            umamusume.waitUntilImage(screen,strImagePath , "btnSummon" + ".png");
            Thread.sleep(intWaitTime);
            umamusume.clickImage(screen,strImagePath , "btnFullAuto" + ".png");
            umamusume.waitUntilImage(screen,strImagePath , "btnOK" + ".png");
            umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
        }
        System.exit(0);
    }


}

