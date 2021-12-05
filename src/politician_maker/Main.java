package politician_maker;

import politician_maker.DATA.DBconnect;
import politician_maker.Panel.*;

import javax.swing.*;

public class Main {
    public static JFrame f;
    private static MainPanel mainPage;
    private static GamePanel gamePanel;
    private static LobbyPanel lobbyPanel;
    private static NewgamePanel newgamePanel;
    private static LoadPanel loadPanel;
    private static DBconnect DC;

    public static void main(String[] args) {
        f =new JFrame();
        mainPage = new MainPanel();
        gamePanel = new GamePanel();
        lobbyPanel = new LobbyPanel();
        newgamePanel = new NewgamePanel();
        loadPanel = new LoadPanel();
        DC = new DBconnect();
        f.add(mainPage);
        f.add(lobbyPanel);
        f.add(gamePanel);
        f.add(newgamePanel);
        f.add(loadPanel);

        f.setSize(500, 600);
        f.setLayout(null);
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        movePage(1);
    }

    public static void movePage(int index) {
        gamePanel.setVisible(false);
        mainPage.setVisible(false);
        loadPanel.setVisible(false);
        newgamePanel.setVisible(false);
        lobbyPanel.setVisible(false);

        switch (index) {
            case 1:
                f.setTitle("메인화면");
                mainPage.setVisible(true);
                break;
            case 2:
                f.setTitle("로비화면");
                lobbyPanel.setVisible(true);
                break;
            case 3:
                f.setTitle("새게임");
                newgamePanel.chrSE_BG.clearSelection();
                newgamePanel.PP_BG.clearSelection();
                newgamePanel.nameInsert.setText("");
                newgamePanel.setVisible(true);
                break;
            case 4:
                f.setTitle("불러오기");
                loadPanel.model.clear();
                DC.saveloadDB();
                    for (int i = 0; i < DC.Get_list().size();i++){
                        loadPanel.model.addElement(DC.Get_list().get(i));
                    }
                    loadPanel.save_list.setModel(loadPanel.model);
                loadPanel.setVisible(true);
                break;
            case 5:
                f.setTitle("게임화면");
                    gamePanel.count = 0;
                    gamePanel.charNUM = 0;
                    gamePanel.potician_party = 0;
                    gamePanel.namefield.setText("");
                    gamePanel.Approval_rating.setText("");
                    gamePanel.Political_party.setText("");
                    gamePanel.HGY_IMG.setVisible(false);
                    gamePanel.LGM_IMG.setVisible(false);
                    gamePanel.LGS_IMG.setVisible(false);
                    gamePanel.Approval_rating_BTN.setText("시작하기");
                gamePanel.repaint();
                gamePanel.setVisible(true);
                break;
        }

    }
}
