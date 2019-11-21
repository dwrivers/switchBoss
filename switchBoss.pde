
int y = 0;

void setup() 
{
  fullScreen();
}

void draw() {
  background(255);
  drawLine(0, height/3, width/3, 0, true);
  drawSwitch(width/3, height/3, 1.0, true);
}

void drawLine(float x, float y, float dx, float dy, boolean energized)
{
  strokeWeight(3);
  line(x, y, x + dx, y + dy);
  if (energized)
  {
    strokeWeight(0);
    fill(#66FF33, 200);
    rect(x - 5, y - 5, dx + 10, dy + 10);
  }
}

void drawSwitch(float x, float y, float size, boolean horiz)
{
  float dx = 0;
  float dy = 0;
  if (horiz) 
  {
    dx = 50 * size;
    strokeWeight(3);
    line(x, y, x + dx, y + dy);
    x += dx;
    line(x, y - dx/2, x, y + dx/2);
    x += dx/2;
    line(x, y - dx/2, x, y + dx/2);
    line(x, y, x + dx, y + dy);
  }
  else
  {
    dy = 50 * size;
    strokeWeight(3);
    line(x, y, x + dx, y + dy);
    y += dy;
    line(x - dy/2, y, x + dy/2, y);
    y += dy/2;
    line(x - dy/2, y, x + dy/2, y);
    line(x, y, x + dx, y + dy);
  }
}