package module6;

import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;


/** 
 * A class to represent AirportMarkers on a world map.
 *   
 * Author: Adam Setters and the UC San Diego Intermediate Software Development
 * MOOC team
 * @author Adam Cwojdzinski
 *
 */
public class AirportMarker extends CommonMarker {	
	public static int TRI_SIZE = 5;
	public static List<SimpleLinesMarker> routes;
	PImage img;
	
	public AirportMarker(Feature city, PImage img) {
		super(((PointFeature)city).getLocation(), city.getProperties());
		this.img = img;
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
	//	pg.fill(255, 200, 100);
	//	pg.ellipse(x, y, 5, 5);
		pg.pushStyle();
		pg.imageMode(PConstants.CORNER);
		// The image is drawn in object coordinates, i.e. the marker's origin (0,0) is at its geo-location.
		img.resize(25, 35);
		pg.image(img, x - 15, y - 25);
		pg.popStyle();
		
	}
	
	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		 // show with title
		
			String city = getCity() + " ";
			String country = getCountry() + " ";
			String name = getName() + " ";
			String code = getCode();
		
			
			pg.pushStyle();
			
			pg.fill(255, 255, 255);
			pg.textSize(12);
			pg.rectMode(PConstants.CORNER);
			pg.rect(x, y-TRI_SIZE-53, Math.max(pg.textWidth(city), pg.textWidth(name)) + 10, 53);
			pg.fill(0, 0, 0);
			pg.textAlign(PConstants.LEFT, PConstants.TOP);
			pg.text(city, x+3, y-TRI_SIZE-53);
			pg.text(country, x+3, y-TRI_SIZE-41);
			pg.text(name, x+3, y-TRI_SIZE-29);
			if (code != null) {
				pg.text(code, x+3, y-TRI_SIZE-17);
			}
			
			
			pg.popStyle();
		}
		
		private String getCity()
		{
			return getStringProperty("city");
		}
		
		private String getCountry()
		{
			return getStringProperty("country");
		}
		
		private String getName()
		{
			return getStringProperty("name");
		}
		
		private String getCode()
		{
			return getStringProperty("code");
		}
		
		
	}
