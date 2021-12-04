package politician_maker.Panel;

import politician_maker.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyPanel extends JPanel {
    public LobbyPanel(){
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

        JButton newGame = new JButton("새게임");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.movePage(3);
            }
        });
        newGame.setBounds(125,200,250,20);
        add(newGame);

        JButton saveLoad = new JButton("불러오기");
        saveLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.movePage(4);
            }
        });
        saveLoad.setBounds(125,300,250,20);
        add(saveLoad);

        JButton moveMain = new JButton("메인으로");
        moveMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.movePage(1);
            }
        });
        moveMain.setBounds(125,400,250,20);
        add(moveMain);

    }
}
