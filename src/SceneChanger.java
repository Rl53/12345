public class SceneChanger {
    GameManager g;

    public SceneChanger(GameManager g) {
        this.g = g;
    }

    public void showScreen1() {
        g.ui.background[1].setVisible(true);
        g.ui.background[2].setVisible(false);
    }

    public void showScreen2() {
        g.ui.background[1].setVisible(false);
        g.ui.background[2].setVisible(true);
    }
}
