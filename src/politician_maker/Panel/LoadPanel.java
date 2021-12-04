package politician_maker.Panel;

import politician_maker.DATA.DBconnect;
import politician_maker.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadPanel extends JPanel {
    public LoadPanel(){
        set_view();
        setBackground(Color.PINK);
        setSize(500,600);
        setLayout(null);
    }
    private void set_view(){
        DBconnect DC = new DBconnect();
        JButton back = new JButton("뒤로가기");
        back.setBounds(10,10,100,20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.movePage(2);
            }
        });
        add(back);

        DefaultListModel model = new DefaultListModel();
        JList save_list = new JList();
        save_list.setBounds(50,50,400,400);
        save_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrolled = new JScrollPane(save_list);
        scrolled.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        add(save_list);



        JButton load = new JButton("목록불러오기");
        load.setBounds(170,470,150,20);
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DC.saveloadDB();
                for (int i = 0; i < DC.Get_list().size();i++){
                    model.addElement(DC.Get_list().get(i));
                }
                save_list.setModel(model);
            }
        });
        add(load);

        JButton save_start = new JButton("시작하기");
        save_start.setBounds(170,500,150,20);
        save_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.movePage(5);
            }
        });
        add(save_start);
    }
}
