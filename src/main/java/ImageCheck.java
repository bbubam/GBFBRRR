import org.openqa.selenium.WebElement;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.List;

public class ImageCheck {

    public static void main(String[] args){
        run();
    }
    public static void run(){
        String strImagePath = umamusume.strImagePath;
        String imgToCheck = strImagePath + umamusume.strImageToCheck;
        System.out.println("Image Folder : " + imgToCheck);

        for (int i = 0; i < 100; i++) {
            try{
                Match matchCheck = umamusume.screen.find(new Pattern(imgToCheck));
                matchCheck.mouseMove();
                System.out.println("IMAGE FOUND WITH SCORE OF : " + matchCheck.getScore());
            }catch(Exception e){
                System.out.println("IMAGE NOT FOUND");
            }
        }


    }

}
