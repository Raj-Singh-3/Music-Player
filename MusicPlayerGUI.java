import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class MusicPlayerGUI {
    private JFrame frame;
    private DefaultListModel<String> songListModel;
    private JList<String> songList;
    private PlaylistManager playlistManager;
    private AudioPlayer audioPlayer;

    public void createAndShowGUI() {
        // Initialize components
        frame = new JFrame("Music Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        songListModel = new DefaultListModel<>();
        songList = new JList<>(songListModel);
        playlistManager = new PlaylistManager();
        audioPlayer = new AudioPlayer();

        // Panel for controls
        JPanel controlPanel = new JPanel();
        JButton playButton = new JButton("Play");
        JButton stopButton = new JButton("Stop");
        JButton addButton = new JButton("Add Song");
        JButton deleteButton = new JButton("Delete Song");

        controlPanel.add(playButton);
        controlPanel.add(stopButton);
        controlPanel.add(addButton);
        controlPanel.add(deleteButton);

        // Song list panel
        JScrollPane scrollPane = new JScrollPane(songList);

        // Add listeners
        playButton.addActionListener(e -> playSong());
        stopButton.addActionListener(e -> audioPlayer.stop());
        addButton.addActionListener(e -> addSong());
        deleteButton.addActionListener(e -> deleteSong());

        // Layout setup
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void playSong() {
        String selectedSong = songList.getSelectedValue();
        if (selectedSong != null) {
            audioPlayer.play(selectedSong);
        } else {
            JOptionPane.showMessageDialog(frame, "No song selected.");
        }
    }

    private void addSong() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String songPath = selectedFile.getAbsolutePath();
            playlistManager.addSong(songPath);
            songListModel.addElement(songPath);
        }
    }

    private void deleteSong() {
        String selectedSong = songList.getSelectedValue();
        if (selectedSong != null) {
            playlistManager.removeSong(selectedSong);
            songListModel.removeElement(selectedSong);
        } else {
            JOptionPane.showMessageDialog(frame, "No song selected.");
        }
    }
}
