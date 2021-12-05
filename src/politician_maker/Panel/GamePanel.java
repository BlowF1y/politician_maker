package politician_maker.Panel;

import politician_maker.DATA.DBconnect;
import politician_maker.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    public static int president;
    public int count;
    public String PP;
    public int charNUM,potician_party;
    public JLabel namefield,Approval_rating,Political_party;
    public JPanel LGM_IMG,LGS_IMG,HGY_IMG;
    public JButton Approval_rating_BTN;

    public GamePanel(){
        set_view();
        setBackground(Color.ORANGE);
        setSize(500,600);
        setLayout(null);

    }

    void set_view(){
        NewgamePanel np = new NewgamePanel();
        DBconnect DC = new DBconnect();
        count = 0;
        president = 1000;
        PP = null;


        JButton back = new JButton("저장");
        back.setBounds(10,10,100,20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DC.updateDB(np.u_name,count);
                Main.movePage(2);
            }
        });
        add(back);


        Approval_rating = new JLabel();
        Approval_rating.setText("지지율 : "+String.valueOf(count)+"/"+String.valueOf(Math.round((double)count / (double)president * 100)/10.0+"%"));
        Approval_rating.setBounds(180,30,300,20);
        Approval_rating.setFont(Approval_rating.getFont().deriveFont(20.0f));
        add(Approval_rating);

        // 이재명 판넬
        LGM_IMG = new JPanel();
        LGM_IMG.setSize(250,250);
        ImageIcon LGMimg = new ImageIcon("IMG/LGM_ingame.jpg");
        Image I1 = LGMimg.getImage().getScaledInstance(250,250,LGMimg.getImage().SCALE_SMOOTH);
        ImageIcon IEE1 = new ImageIcon(I1);
        JLabel imglabel = new JLabel(IEE1);

        imglabel.setBounds(0,0,250,250);
        LGM_IMG.add(imglabel);
        LGM_IMG.setBounds(120,100,250,250);
        LGM_IMG.setVisible(false);
        add(LGM_IMG);

        //이준석 판넬
        LGS_IMG = new JPanel();
        LGM_IMG.setSize(250,250);
        ImageIcon LGSimg = new ImageIcon("IMG/LGS_ingame.jpg");
        Image I2 = LGSimg.getImage().getScaledInstance(250,250,LGSimg.getImage().SCALE_SMOOTH);
        ImageIcon IEE2 = new ImageIcon(I2);
        JLabel imglabel2 = new JLabel(IEE2);

        imglabel.setBounds(0,0,250,250);
        LGS_IMG.add(imglabel2);
        LGS_IMG.setBounds(120,100,250,250);
        LGS_IMG.setVisible(false);
        add(LGS_IMG);


        //허경영 판넬
        HGY_IMG = new JPanel();
        LGM_IMG.setSize(250,250);
        ImageIcon HGYimg = new ImageIcon("IMG/HGY_ingame.jpg");
        Image I3 = HGYimg.getImage().getScaledInstance(250,250,HGYimg.getImage().SCALE_SMOOTH);
        ImageIcon IEE3 = new ImageIcon(I3);
        JLabel imglabel3 = new JLabel(IEE3);

        imglabel.setBounds(0,0,250,250);
        HGY_IMG.add(imglabel3);
        HGY_IMG.setBounds(120,100,250,250);
        HGY_IMG.setVisible(false);
        add(HGY_IMG);



        namefield = new JLabel();
        namefield.setBounds(100,380,100,30);
        namefield.setFont(namefield.getFont().deriveFont(15.0f));
        add(namefield);

        Political_party = new JLabel();
        Political_party.setBounds(250,380,200,30);
        Political_party.setFont(Political_party.getFont().deriveFont(15.0f));
        add(Political_party);
        Approval_rating_BTN = new JButton("시작하기");
        Approval_rating_BTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DC.connectDB(np.u_name);
                if (count == 0){
                    count += DC.Get_rating();
                    charNUM = DC.Get_chr();
                    potician_party = DC.Get_PP();
                        if(potician_party == 1){
                            Political_party.setText("정당 : 더불어민주당");
                        }else if(potician_party == 2){
                            Political_party.setText("정당 : 국민의 힘");
                        }else if(potician_party == 3){
                            Political_party.setText("정당 : 국가혁명 배당금당");
                        }

                        if(charNUM == 1){
                            LGM_IMG.setVisible(true);
                        }else if(charNUM == 2){
                            LGS_IMG.setVisible(true);
                        }else if(charNUM == 3){
                            HGY_IMG.setVisible(true);
                        }

                    Approval_rating_BTN.setText("지지율 올리기");
                    Approval_rating.setText("지지율 : "+String.valueOf(count)+"/"+String.valueOf(Math.round((double)count / (double)president * 100)/1.0+"%"));
                    namefield.setText("이름 :"+np.u_name);
                }else if (count >= 1){
                           count += 1;
                    Approval_rating.setText("지지율 : "+String.valueOf(count)+"/"+String.valueOf(Math.round((double)count / (double)president * 100)/1.0+"%"));
                }
            }
        });
        Approval_rating_BTN.setBounds(150,450,200,50);
        add(Approval_rating_BTN);
    }
}
