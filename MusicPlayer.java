public class MusicPlayer {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            MusicPlayerGUI gui = new MusicPlayerGUI();
            gui.createAndShowGUI();
        });
    }
}
