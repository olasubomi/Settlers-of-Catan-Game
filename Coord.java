import objectdraw.*;
import java.awt.*;

public class Coord
{
    private boolean available;
    private FilledOval areaTester;
    private FilledOval selectionBubble;
    private double xCoord;
    private double yCoord;
    private double areaRadius;
    private int selectionRadius;
    private boolean habitable;

    public Coord(Location aLocation, DrawingCanvas canvas)
    {
        xCoord = aLocation.getX();
        yCoord = aLocation.getY();
        areaRadius = (Hexagon.LENGTH+11);
        selectionRadius = 15;
        areaTester = new FilledOval(xCoord - areaRadius, yCoord - areaRadius, (Hexagon.LENGTH+11)*2, (Hexagon.LENGTH+11)*2, canvas);
        areaTester.setColor(new Color(0, 145, 0, 100));
                areaTester.hide();
        selectionBubble = new FilledOval(xCoord - selectionRadius, yCoord - selectionRadius, selectionRadius*2, selectionRadius*2, canvas);
        selectionBubble.setColor(new Color(0, 145, 11, 125));//new Color(0,0, 255, 125));
                available = true;
        selectionBubble.hide();
    }
    
    public Location location()
    {
        return new Location(xCoord, yCoord);
    }

        public void showSelectionRadius()
        {
                selectionBubble.show();
        }

        public void hideSelectionRadius()
        {
                selectionBubble.hide();
        }

        public void showAreaTester()
        {
                areaTester.show();
        }

        public void hideAreaTester()
        {
                areaTester.hide();
        }

        public void changeTesterColor(Color colour)
        {
                areaTester.setColor(colour);
        }

	public boolean contains(Location loc)
	{
		return	selectionBubble.contains(loc);
	}
    
    public boolean isHabitable()
    {
        return habitable;
    }
    
    public void makeHabitable()
    {
        habitable = true;
    }
    
    public void makeInhabitable()
    {
        habitable = false;
    }
}
