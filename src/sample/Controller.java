package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

public class Controller {
    public ImageView img1;
    public ImageView img2;
    public ImageView img3;
    public ImageView img4;
    public ImageView img5;
    public ImageView img6;
    public ImageView img7;
    public ImageView img8;
    public ImageView img9;
    public ImageView img10;
    public ImageView img11;
    public ImageView img12;
    public ImageView img13;
    public ImageView img14;
    public ImageView img15;
    public ImageView img16;
    private State state=State.NEW;
    private boolean[][] field=new boolean[4][4];

    public void img1Click(MouseEvent mouseEvent) {
          processClick(1);
    }
    public void img2Click(MouseEvent mouseEvent) {
        processClick(2);
    }
    public void img3Click(MouseEvent mouseEvent) {
        processClick(3);
    }
    public void img4Click(MouseEvent mouseEvent) {
        processClick(4);
    }
    public void img5Click(MouseEvent mouseEvent) {
        processClick(5);
    }
    public void img6Click(MouseEvent mouseEvent) {
        processClick(6);
    }
    public void img7Click(MouseEvent mouseEvent) {
        processClick(7);
    }
    public void img8Click(MouseEvent mouseEvent) {
        processClick(8);
    }
    public void img9Click(MouseEvent mouseEvent) {
        processClick(9);
    }
    public void img10Click(MouseEvent mouseEvent) {
        processClick(10);
    }
    public void img11Click(MouseEvent mouseEvent) {
        processClick(11);
    }
    public void img12Click(MouseEvent mouseEvent) {
        processClick(12);
    }
    public void img13Click(MouseEvent mouseEvent) {
        processClick(13);
    }
    public void img14Click(MouseEvent mouseEvent) {
        processClick(14);
    }
    public void img15Click(MouseEvent mouseEvent) {
        processClick(15);
    }
    public void img16Click(MouseEvent mouseEvent) {
        processClick(16);
    }

    private void processClick(int i)   {
        try {
            if (state == State.PLAYING || state==State.GENERATE) {
                //System.out.println("You clicked on " + i);
                switch(i){
                    case 1: toggle(2); toggle(5); toggle(6); break;
                    case 2: toggle(1); toggle(3); toggle(5); toggle(6); toggle(7); break;
                    case 3: toggle(2); toggle(4); toggle(8); toggle(6); toggle(7); break;
                    case 4: toggle(3); toggle(7); toggle(8); break;
                    case 5: toggle(1); toggle(2); toggle(6); toggle(9); toggle(10); break;
                    case 6: toggle(1); toggle(2); toggle(3); toggle(5); toggle(7); toggle(9); toggle(10); toggle(11);break;
                    case 7: toggle(2); toggle(3); toggle(4); toggle(6); toggle(8); toggle(10); toggle(11); toggle(12); break;
                    case 8: toggle(3); toggle(4); toggle(7); toggle(11); toggle(12); break;
                    case 9: toggle(5); toggle(6); toggle(10); toggle(13); toggle(14); break;
                    case 10: toggle(5); toggle(6); toggle(7); toggle(9); toggle(11); toggle(13); toggle(14); toggle(15);break;
                    case 11: toggle(6); toggle(7); toggle(8); toggle(10); toggle(12); toggle(14); toggle(15); toggle(16); break;
                    case 12: toggle(7); toggle(8); toggle(11); toggle(15); toggle(16); break;
                    case 13: toggle(9); toggle(10); toggle(14); break;
                    case 14: toggle(9); toggle(10); toggle(11); toggle(13); toggle(15); break;
                    case 15: toggle(10); toggle(11); toggle(12); toggle(14); toggle(16); break;
                    case 16: toggle(11); toggle(12); toggle(15); break;
                }
                if(isGameWin() && state==State.PLAYING){
                    state=State.END;

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Win");
                    alert.setHeaderText("Congratulation !");
                    alert.setContentText("You are winner!");
                    alert.showAndWait();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private boolean isGameWin() {
        int i,j,p=0;
        for(i=0;i<4;i++)
            for(j=0;j<4;j++)
                if(field[i][j])
                   p++;

        if(p==16 || p==0)
            return true;
        else
            return false;
    }

    public void btnNewClick(ActionEvent actionEvent) {

        if(state!=State.NEW)
            return;
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
                 field[i][j]=false;

        generateField();

    }

    private void generateField() {
        int i;
        state=State.GENERATE;
        try {
            Random random = new Random();
            for (i = 0; i < 19; i++) {
                processClick(random.nextInt(16) + 1);
            }
            state=State.PLAYING;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void toggle(int i) throws Exception{
        int col=(i-1)%4;
        int row=(i-1)/4;
        field[row][col] = !field[row][col];
        Image image;
        //System.out.println(img10.getImage().getUrl());
        String current = new java.io.File( "." ).getCanonicalPath();

        if(field[row][col]==false){
             image=new Image(new FileInputStream( current+"\\src\\resource\\obr1.png"));
        }
        else{
             image=new Image(new FileInputStream(current+"\\src\\resource\\obr2.png"));
        }
        switch(i) {
            case 1:   img1.setImage(image); break;
            case 2:   img2.setImage(image); break;
            case 3:   img3.setImage(image); break;
            case 4:   img4.setImage(image); break;
            case 5:   img5.setImage(image); break;
            case 6:   img6.setImage(image); break;
            case 7:   img7.setImage(image); break;
            case 8:   img8.setImage(image); break;
            case 9:   img9.setImage(image); break;
            case 10:   img10.setImage(image); break;
            case 11:   img11.setImage(image); break;
            case 12:   img12.setImage(image); break;
            case 13:   img13.setImage(image); break;
            case 14:   img14.setImage(image); break;
            case 15:   img15.setImage(image); break;
            case 16:   img16.setImage(image); break;
        }
    }

    public void btnExitClick(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(1);
    }
}
