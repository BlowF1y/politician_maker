package politician_maker.Panel;

import politician_maker.DATA.DBconnect;
import politician_maker.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewgamePanel extends JPanel {

    static String u_name;

    public int chr_num;
    public int poli_party_num;
    static JTextField nameInsert;

    public NewgamePanel(){
        set_view();
        setBackground(Color.GRAY);
        setSize(500,600);
        setLayout(null);
    }



    private void set_view(){
        DBconnect DC = new DBconnect();
        JLabel mainlabel = new JLabel("새게임");
        mainlabel.setBounds(200,0,100,50);
        mainlabel.setFont(mainlabel.getFont().deriveFont(30.0f));
        add(mainlabel);

        JButton back = new JButton("뒤로가기");
        back.setBounds(10,10,100,20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.movePage(2);
            }
        });
        add(back);

        ImageIcon chrIMG_1 = new ImageIcon("IMG/LJM_charterSelect.jpg");
        Image c1 = chrIMG_1.getImage().getScaledInstance(100,200,chrIMG_1.getImage().SCALE_SMOOTH);
        ImageIcon chrIMGS1 = new ImageIcon(c1);
        JLabel chrSelectIMG1 = new JLabel(chrIMGS1);
        chrSelectIMG1.setBounds(50,50,100,200);
        add(chrSelectIMG1);


        ImageIcon chrIMG_2 = new ImageIcon("IMG/LJS_charterSelect.jpg");
        Image c2 = chrIMG_2.getImage().getScaledInstance(100,200,chrIMG_2.getImage().SCALE_SMOOTH);
        ImageIcon chrIMGS2 = new ImageIcon(c2);
        JLabel chrSelectIMG2 = new JLabel(chrIMGS2);
        chrSelectIMG2.setBounds(200,50,100,200);
        add(chrSelectIMG2);

        ImageIcon chrIMG_3 = new ImageIcon("IMG/HGY_charterSelect.jpg");
        Image c3 = chrIMG_3.getImage().getScaledInstance(100,200,chrIMG_3.getImage().SCALE_SMOOTH);
        ImageIcon chrIMGS3 = new ImageIcon(c3);
        JLabel chrSelectIMG3 = new JLabel(chrIMGS3);
        chrSelectIMG3.setBounds(350,50,100,200);
        add(chrSelectIMG3);

        ButtonGroup chrSE_BG = new ButtonGroup();
        JRadioButton chrSE_1 = new JRadioButton();
        chrSE_BG.add(chrSE_1);
        chrSE_1.setBounds(90,270,20,20);

        JRadioButton chrSE_2 = new JRadioButton();
        chrSE_BG.add(chrSE_2);
        chrSE_2.setBounds(240,270,20,20);

        JRadioButton chrSE_3 = new JRadioButton();
        chrSE_BG.add(chrSE_3);
        chrSE_3.setBounds(390,270,20,20);

        add(chrSE_1);
        add(chrSE_2);
        add(chrSE_3);

        JLabel name = new JLabel("이름 :");
        name.setBounds(130,300,100,50);
        add(name);

        nameInsert = new JTextField();
        nameInsert.setBounds(180,310,200,30);
        add(nameInsert);



        JLabel political_party = new JLabel("정당");
        political_party.setBounds(50,350,100,100);
        political_party.setFont(mainlabel.getFont().deriveFont(20.0f));
        add(political_party);

        ButtonGroup PP_BG = new ButtonGroup();
        JRadioButton PP_minju = new JRadioButton("더불어민주당");
        PP_minju.setBounds(50,430,110,20);

        JRadioButton PP_gugmin = new JRadioButton("국민의힘");
        PP_gugmin.setBounds(180,430,110,20);

        JRadioButton PP_hyekmyung = new JRadioButton("국가혁명배당금당");
        PP_hyekmyung.setBounds(300,430,150,20);

        PP_BG.add(PP_minju);
        PP_BG.add(PP_gugmin);
        PP_BG.add(PP_hyekmyung);
        add(PP_minju);
        add(PP_gugmin);
        add(PP_hyekmyung);


        JButton START = new JButton("시작하기");
        START.setBounds(200,500,100,20);
        START.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(chrSE_1.isSelected()){
                    chr_num = 1;
                }else if(chrSE_2.isSelected()){
                    chr_num = 2;
                }else if(chrSE_3.isSelected()){
                    chr_num = 3;
                }

                u_name = nameInsert.getText();

                if (PP_minju.isSelected()){
                    poli_party_num = 1;
                }else if(PP_gugmin.isSelected()){
                    poli_party_num = 2;
                }else if(PP_hyekmyung.isSelected()){
                    poli_party_num = 3;
                }
                DC.addDB(u_name,chr_num,poli_party_num);
                Main.movePage(5);

            }
        });
        add(START);
    }

}
