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

    public static void main(String[] args) {
        f =new JFrame();
        mainPage = new MainPanel();
        gamePanel = new GamePanel();
        lobbyPanel = new LobbyPanel();
        newgamePanel = new NewgamePanel();
        loadPanel = new LoadPanel();
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

                newgamePanel.setVisible(true);
                break;
            case 4:
                f.setTitle("불러오기");
                loadPanel.setVisible(true);
                break;
            case 5:
                f.setTitle("게임화면");
                gamePanel.setVisible(true);
                break;
        }

    }
}
