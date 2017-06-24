/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author SOHAM
 */
public class TicTacLogic {
    String myList[][];
    int complete=0;
    boolean mStatus;
    JButton player1,player2;
    JLabel jLabel11;
    tictactoe tictac;
    public TicTacLogic(tictactoe tictac,JButton player1, JButton player2,JLabel jLabel11)
    {
        this.player1=player1;
        this.player2=player2;
        this.jLabel11=jLabel11;
        this.tictac=tictac;
        
        player1.setBackground(Color.green);
        player2.setBackground(Color.red);
        myList=new String[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
                myList[i][j]="";
        }
        mStatus=true;
    }
    public String onClick(int no)
    {
        ++complete;
        System.err.println("no is"+no);
        no--;
        int i=no/3;
        int j=no%3;
        try{
        if(myList[i][j].equals("X")|| myList[i][j].equals("O"))
            return myList[i][j];
        }
        catch(NullPointerException e)
        {
            //
        }
//check(no);
        if(mStatus)//p1
        {
        //    mStatus=false;
            myList[i][j]="X";
        }
        else
        {
          //  mStatus=true;
            myList[i][j]="O";
           // return "O";
        }
        
        if(check(no))
        {
            if(mStatus==true)
           jLabel11.setText("Player 1 Wins !");// JOptionPane.showMessageDialog(null,"Player 1 Wins");
            else
          jLabel11.setText("Player 2 Wins !"); // JOptionPane.showMessageDialog(null,"Player 2 Wins");
           
        }
        
        if(complete==9 && !check(no))
             jLabel11.setText("It's a Draw");
        
        toggleColors();
        mStatus=!mStatus;
        
        return myList[i][j];
    }
    
    public void reset(){
        new tictactoe().setVisible(true);
          tictac.dispose();
    }
    
    void toggleColors()
    {
        if(player1.getBackground()==Color.red)
        {
            player1.setBackground(Color.green);
            player2.setBackground(Color.red);
        }
        else
        {
            player1.setBackground(Color.red);
            player2.setBackground(Color.green);
            
        }
    }
    public boolean check(int no)
    {
        //if(mStatus)//p1  x
        try{
        {
            for(int i=0;i<3;i++)
            {
                int isWonRow=0;
                int isWonCol=0;
                for(int j=0;j<3;j++)
                {
                    if( mStatus?  myList[i][j].equals("X") :myList[i][j].equals("O"))
                    {
                        isWonRow++;
                    }
                    if(mStatus? myList[j][i].equals("X") : myList[j][i].equals("O"))
                    {
                        isWonCol++;
                    }
                }
                if(isWonRow==3|| isWonCol==3)
                {
                    return true;
                }
            }
            //diagonal
            int count=0;
            for(int i=0;i<3;i++)
            {
                
                if(mStatus? myList[i][i].equals("X"): myList[i][i].equals("O"))
                {
                    count++;
                }
                if(count==3)
                    return true;
            }
            count=0;
            for(int i=0;i<3;i++)
            {
                //int count=0;
                if(mStatus? myList[2-i][i].equals("X"): myList[2-i][i].equals("O"))
                {
                    count++;
                }
                if(count==3)
                    return true;
            }
            }
        }catch(NullPointerException e)
        {
            System.err.println("check exception");
        }
            
        return false;
    }
    
    public boolean getPlayer()
    {
        return mStatus;
    }
}
