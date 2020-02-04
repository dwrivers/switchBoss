import processing.core.PApplet;

public class Switch extends Component {

    private boolean open;
    private boolean normallyOpen;

    public Switch(SwitchBoss sketch, int id, int x, int y, String name, int orientation, boolean normallyOpen) {
        super(sketch, id, x, y, name, orientation);

        this.normallyOpen = normallyOpen;
        this.open = normallyOpen;

        switch (getOrientation()) {
            case 0: // N
                setHeight(3);
                setWidth(2);
                setInX(x + 1);
                setOutX(x + 1);
                setInY(y + 3);
                setOutY(y);
                break;
            case 1: // E
                setHeight(2);
                setWidth(3);
                setInX(x);
                setOutX(x + 3);
                setInY(y + 1);
                setOutY(y + 1);
                break;
            case 2: // S
                setHeight(3);
                setWidth(2);
                setInX(x + 1);
                setOutX(x + 1);
                setInY(y);
                setOutY(y + 3);
                break;
            case 3: // W
                setHeight(2);
                setWidth(3);
                setInX(x + 3);
                setOutX(x);
                setInY(y + 1);
                setOutY(y + 1);
                break;
            default:
                System.exit(-1); // error checks later (SHOULD NEVER HAPPEN)
        }
    }

    public void render(float scale, int panX, int panY) {
        int unit = (int) (UNIT * scale); // grid unit with scale taken into account
        int x = calcPos(getX(), scale, panX);
        int y = calcPos(getY(), scale, panY);

        super.render(scale, panX, panY);

        sketch.stroke(0, 0, 0);
        sketch.strokeWeight(3 * scale);
        if (getOrientation() == 0 || getOrientation() == 2) { // N/S facing
            sketch.line(x + unit, y, x + unit, y + unit);
            sketch.line(x + unit, y + 2 * unit, x + unit, y + 3 * unit);
            sketch.line(x, y + unit, x + 2 * unit, y + unit);
            sketch.line(x, y + 2 * unit, x + 2 * unit, y + 2 * unit);

        } else { // E / W facing
            sketch.line(x, y + unit, x + unit, y + unit);
            sketch.line(x + 2 * unit, y + unit, x + 3 * unit, y + unit);
            sketch.line(x + unit, y, x + unit, y + 2 * unit);
            sketch.line(x + 2 * unit, y, x + 2 * unit, y + 2 * unit);
        }
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
