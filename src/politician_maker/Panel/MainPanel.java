package politician_maker.Panel;

import politician_maker.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    public MainPanel(){
        set_view();
        setBackground(Color.GRAY);
        setSize(500,600);
        setLayout(null);

    }
    private void set_view(){
        JLabel mainlabel = new JLabel("정치인 키우기");
        mainlabel.setBounds(80,10,500,100);
        mainlabel.setFont(mainlabel.getFont().deriveFont(50.0f));
        add(mainlabel);

        ImageIcon mainimg = new ImageIcon("IMG/main_img.jpg");
        JLabel imglabel = new JLabel(mainimg);
        imglabel.setBounds(120,150,250,250);
        add(imglabel);

        JButton Start_btn = new JButton("시작하기");
        Start_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.movePage(2);
            }
        });
        Start_btn.setBounds(125,450,250,20);
        add(Start_btn);


    }
}
