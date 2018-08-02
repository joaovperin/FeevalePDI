
import br.jpe.dip.p5.Color;
import br.jpe.dip.p5.TestPerin;
import java.util.List;
import java.util.ArrayList;

Canvas canvas  = new Canvas(640, 640, Color.WHITE);

void setup(){
  size(640, 640);
  // Test Hello world from java library :D
  TestPerin.hello();
}

void draw(){
  canvas.render();
  List<Rect> l = new ArrayList();
  l.add(new Rect(180,60,220,40));
  l.add(new Rect(30,50,100,30));
  
  for (Rect r : l){
       r.render();
  }
  
}

class Canvas {
  int w, h;
  Color c;
  Canvas(int w, int h){this(w,h,Color.WHITE);}
  Canvas(int w, int h, Color c){this.w=w; this.h=h; this.c=c;}
  void render(){
    strokeWeight(5);
    color(0,0,0);
    fill(c.r,c.g, c.b);
    rect(0,0,w,h);
  }
}

class Rect {
  int x, y;
  int w, h, t;
  Color c, b;
  // Constructors
  Rect(int x, int y, int s){this(x,y,s,s);}
  Rect(int x, int y, int w, int h){this(x,y,w,h, Color.RED);}
  Rect(int x, int y, int w, int h, Color c){this(x,y,w,h,c,Color.BLACK);}
  Rect(int x, int y, int w, int h, Color c, Color b){this(x,y,w,h,c,b,1);}
  Rect(int x, int y, int w, int h, Color c, Color b, int t){this.x = x; this.y=y; this.w=w; this.h=h; this.c=c;this.b=b;this.t=t;}
  // Render
  void render(){
    strokeWeight(t);
    color(b.r,b.g,b.b);
    fill(c.r,c.g,c.b);
    rect(x,y,w,h);
  }
}
