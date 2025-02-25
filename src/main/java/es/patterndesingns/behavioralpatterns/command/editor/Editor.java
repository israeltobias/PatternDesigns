package es.patterndesingns.behavioralpatterns.command.editor;

import es.patterndesingns.behavioralpatterns.command.commands.*;

import javax.swing.*;
import java.awt.*;

public class Editor {
    private  JTextArea textField;
    private  String clipboard;
    private  CommandHistory history = new CommandHistory();

    public Editor() {
        super();
    }

    public JTextArea getTextField() {
        return textField;
    }

    public void setTextField(JTextArea textField) {
        this.textField = textField;
    }

    public String getClipboard() {
        return clipboard;
    }

    public void setClipboard(String clipboard) {
        this.clipboard = clipboard;
    }

    public CommandHistory getHistory() {
        return history;
    }

    public void setHistory(CommandHistory history) {
        this.history = history;
    }

    public void init() {
        JFrame frame = new JFrame("Text editor (type & use buttons, Luke!)");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        textField = new JTextArea();
        textField.setLineWrap(true);
        content.add(textField);
        JPanel buttons = getButtons();
        content.add(buttons);
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel getButtons() {
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton ctrlC = new JButton("Ctrl+C");
        JButton ctrlX = new JButton("Ctrl+X");
        JButton ctrlV = new JButton("Ctrl+V");
        JButton ctrlZ = new JButton("Ctrl+Z");
        Editor editor = this;
        ctrlC.addActionListener(e -> executeCommand(new CopyCommand(editor)));
        ctrlX.addActionListener(e -> executeCommand(new CutCommand(editor)));
        ctrlV.addActionListener(e -> executeCommand(new PasteCommand(editor)));
        ctrlZ.addActionListener(e -> undo());
        buttons.add(ctrlC);
        buttons.add(ctrlX);
        buttons.add(ctrlV);
        buttons.add(ctrlZ);
        return buttons;
    }

    private void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    private void undo() {
        if (history.isEmpty()) return;

        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }
}
