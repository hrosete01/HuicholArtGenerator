package editor;

import canvas.CanvasManager;
import globals.AppManager;
import controlP5.ControlP5;
import processing.core.PApplet;

//the ControlFrame class extends PApplet, so we 
//are creating a new processing applet inside a
//new frame with a controlP5 object loaded
public class ControlWindow extends PApplet {

	ControlP5 cp5;

	EditorManager parent;

	int w = 1;
	int h = 1;
	int abc = 100;

	public void setup() {
		size(w, h);
		frameRate(25);
		cp5 = new ControlP5(this);
		cp5.setColorBackground(color(50));
		cp5.setColorForeground(color(200,127,0));
		cp5.setColorActive(color(200,127,0));
		cp5.setColorCaptionLabel(color(255,255,0));
		
		cp5.addSlider("abc").setRange(0, 255).setPosition(10, 10);
		cp5.addSlider("testColorControl").plugTo(parent, "testColorControl").setRange(0, 255).setPosition(10, 30);
		cp5.addButton("gui_newFigure").plugTo(parent, "gui_newFigure").setPosition(10, 50).setLabel("NEW FIGURE");
		cp5.addSlider("viewPortScale").plugTo(parent, "viewPortScale").setRange(0.1f, 1).setPosition(10, 80).setValue(1f).setLabel("VIEWPORT SCALE");
		
		cp5.addToggle("showFigureGizmos").plugTo(parent, "showFigureGizmos").setValue(false).setPosition(10, 100).setLabel("SHOW FIGURE GIZMOS");
	}

	public void draw() {
		background(abc);
	}

	public ControlWindow() {
	}

	public ControlWindow(EditorManager theParent, int theWidth, int theHeight) {
		parent = theParent;
		w = theWidth;
		h = theHeight;
	}

	public ControlP5 control() {
		return cp5;
	}

	public void gui_newFigure(int theValue) {
		println("a button event from buttonA: " + theValue);
		parent.prepareNewFigure();
	}
	
	public void viewPortScale(float value){
		AppManager.canvasScale = value;
	}
	
	public void showFigureGizmos(boolean state){
		parent.showFigureGizmos = state;
	}

}