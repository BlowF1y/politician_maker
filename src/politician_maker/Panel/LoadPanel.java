package politician_maker.Panel;

import politician_maker.DATA.DBconnect;
import politician_maker.Main;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoadPanel extends JPanel {
    public LoadPanel(){
        set_view();
        setBackground(Color.PINK);
        setSize(500,600);
        setLayout(null);
    }
    private Object o;
    public JButton load;
    public DefaultListModel model;
    public JList save_list;
    private void set_view(){
        DBconnect DC = new DBconnect();
        NewgamePanel np = new NewgamePanel();
        JButton back = new JButton("뒤로가기");
        back.setBounds(10,10,100,20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.movePage(2);
            }
        });
        add(back);
        JLabel alert = new JLabel("이름 / 캐릭터 / 정당 / 지지율");
        alert.setBounds(50,50,400,50);
        alert.setFont(alert.getFont().deriveFont(20.0f));
        add(alert);

        model = new DefaultListModel();
        save_list = new JList();
        save_list.setBounds(50,100,400,300);
        save_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrolled = new JScrollPane(save_list);
        scrolled.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));


        add(save_list);


        JButton save_start = new JButton("시작하기");
        save_start.setBounds(170,420,150,20);
        save_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(save_list.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(Main.f,"세이브를 선택해주세요");
                }else {
                        Main.movePage(5);
                        ListModel list3 = save_list.getModel();
                        o = list3.getElementAt(save_list.getSelectedIndex());
                        String a = o.toString();
                        String[] array = a.split(",");
                        np.u_name = array[0].substring(array[0].lastIndexOf("[")+1);

                }

            }
        });
        add(save_start);

        JButton delete_save = new JButton("삭제하기");
        delete_save.setBounds(170,450,150,20);
        add(delete_save);
        delete_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(save_list.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(Main.f,"세이브를 선택해주세요");
                }else {
                    ListModel list3 = save_list.getModel();
                    o = list3.getElementAt(save_list.getSelectedIndex());
                    String a = o.toString();
                    String[] array = a.split(",");
                    DC.deleteDB(array[0].substring(array[0].lastIndexOf("[")+1));

                    model.clear();
                        DC.saveloadDB();
                        for (int i = 0; i < DC.Get_list().size();i++){
                            model.addElement(DC.Get_list().get(i));
                        }
                        save_list.setModel(model);
                        save_list.repaint();

                }
            }
        });
    }
}
