package es.patterndesingns.behavioralpatterns.memento.editor;

import es.patterndesingns.behavioralpatterns.memento.commands.ColorCommand;
import es.patterndesingns.behavioralpatterns.memento.commands.MoveCommand;
import es.patterndesingns.behavioralpatterns.memento.shapes.Shape;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;


public class CanvasMemento extends java.awt.Canvas {
    private final Editor editor;
    private JFrame frame;
    private static final int PADDING = 10;

    CanvasMemento(Editor editor) {
        this.editor = editor;
        createFrame();
        attachKeyboardListeners();
        attachMouseListeners();
        refresh();
    }

    private void createFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel();
        Border padding = BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING);
        contentPanel.setBorder(padding);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        frame.setContentPane(contentPanel);

        contentPanel.add(new JLabel("Select and drag to move."), BorderLayout.PAGE_END);
        contentPanel.add(new JLabel("Right click to change color."), BorderLayout.PAGE_END);
        contentPanel.add(new JLabel("Undo: Ctrl+Z, Redo: Ctrl+R"), BorderLayout.PAGE_END);
        contentPanel.add(this);
        frame.setVisible(true);
        contentPanel.setBackground(Color.LIGHT_GRAY);
    }

    private void attachKeyboardListeners() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getModifiersEx() & InputEvent.CTRL_DOWN_MASK) != 0) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_Z:
                            editor.undo();
                            break;
                        case KeyEvent.VK_R:
                            editor.redo();
                            break;
                        default: break;
                    }
                }
            }
        });
    }

    private MouseAdapter getMouseAdapter() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() != MouseEvent.BUTTON3) {
                    return;
                }
                Shape target = editor.getShapes().getChildAt(e.getX(), e.getY());
                if (target != null) {
                    editor.execute(new ColorCommand(editor, new Color(ThreadLocalRandom.current().nextInt(0x1000000))));
                    repaint();
                }
            }
        };
    }

    private MouseAdapter getMousePressed() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() != MouseEvent.BUTTON1) {
                    return; // Solo procesar clic izquierdo
                }

                Shape target = editor.getShapes().getChildAt(e.getX(), e.getY());
                boolean ctrlPressed = isControlKeyPressed(e);

                handleShapeSelection(target, ctrlPressed);

                repaint();
            }
        };
    }

    private boolean isControlKeyPressed(MouseEvent e) {
        return (e.getModifiersEx() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK;
    }


    private void handleShapeSelection(Shape target, boolean ctrlPressed) {
        if (target == null) {
            handleBackgroundClick(ctrlPressed);
        } else {
            handleShapeClick(target, ctrlPressed);
        }
    }

    private void handleBackgroundClick(boolean ctrlPressed) {
        if (!ctrlPressed) {
            editor.getShapes().unSelect();
        }
    }

    private void handleShapeClick(Shape target, boolean ctrlPressed) {
        if (ctrlPressed) {
            toggleShapeSelection(target);
        } else {
            selectSingleShape(target);
        }
    }

    private void toggleShapeSelection(Shape target) {
        if (target.isSelected()) {
            target.unSelect();
        } else {
            target.select();
        }
    }

    private void selectSingleShape(Shape target) {
        if (!target.isSelected()) {
            editor.getShapes().unSelect();
        }
        target.select();
    }

    private MouseAdapter getMouseDragged() {
        return new MouseAdapter() {
            MoveCommand moveCommand;

            @Override
            public void mouseDragged(MouseEvent e) {
                if ((e.getModifiersEx() & InputEvent.BUTTON1_DOWN_MASK) != InputEvent.BUTTON1_DOWN_MASK) {
                    return;
                }
                if (moveCommand == null) {
                    moveCommand = new MoveCommand(editor);
                    moveCommand.start(e.getX(), e.getY());
                }
                moveCommand.move(e.getX(), e.getY());
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() != MouseEvent.BUTTON1 || moveCommand == null) {
                    return;
                }
                moveCommand.stop(e.getX(), e.getY());
                editor.execute(moveCommand);
                this.moveCommand = null;
                repaint();
            }
        };
    }

    private void attachMouseListeners() {
        MouseAdapter colorized =getMouseAdapter();
        addMouseListener(colorized);

        MouseAdapter selector = getMousePressed();
        addMouseListener(selector);


        MouseAdapter dragged = getMouseDragged();
        addMouseListener(dragged);
        addMouseMotionListener(dragged);
    }

    @Override
    public int getWidth() {
        return editor.getShapes().getX() + editor.getShapes().getWidth() + PADDING;
    }

    @Override
    public int getHeight() {
        return editor.getShapes().getY() + editor.getShapes().getHeight() + PADDING;
    }

    void refresh() {
        this.setSize(getWidth(), getHeight());
        frame.pack();
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics graphics) {
        BufferedImage buffer = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D ig2 = buffer.createGraphics();
        ig2.setBackground(Color.WHITE);
        ig2.clearRect(0, 0, this.getWidth(), this.getHeight());

        editor.getShapes().paint(buffer.getGraphics());

        graphics.drawImage(buffer, 0, 0, null);
    }
}
