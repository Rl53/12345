public class GameManager{
    ActionHandler handler = new ActionHandler(this);
    public GUI ui = new GUI(this);
    public SceneChanger sceneChanger = new SceneChanger(this);
    public static void main(String[] args){

        new GameManager();





    }
}