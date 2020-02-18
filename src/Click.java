import java.util.ArrayList;

public class Click {

    public static final int UNIT = 20;

    float x;
    float y;

    public Click() {
        this.x = 0;
        this.y = 0;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public int calcPos(int coord, float scale, int pan) {
        return (int) ((scale * (scale + coord + pan)) + (UNIT * coord * scale));
    }

    public void mousePress(ArrayList<Component> components, int mouseX, int mouseY, float scale, int panX, int panY) {
        for (Component c : components) {
            int x = calcPos(c.getX(), scale, panX);
            int y = calcPos(c.getY(), scale, panY);
            if (c.getOrientation() == 0 || c.getOrientation() == 2) {
                if (mouseX >= x && mouseX <= x + 2 * 20 * scale && mouseY >= y && mouseY <= y + 3 * 20 * scale) {
                    if (c.getCurrentState() == 0) {
                        c.setCurrentState(1);
                    } else if (c.getCurrentState() == 1) {
                        c.setCurrentState(0);
                    }
                }
            } else {
                if (mouseX >= x && mouseX <= x + 3 * 20 * scale && mouseY >= y && mouseY <= y + 2 * 20 * scale) {
                    if (c.getCurrentState() == 0) {
                        c.setCurrentState(1);
                    } else if (c.getCurrentState() == 1) {
                        c.setCurrentState(0);
                    }
                }
            }
        }
    }
}