package com.earthquakeInfo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EarthquaeModel  implements java.io.Serializable{


	private String location;
	private String magnitude;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMagnitude() {
		return magnitude;
	}
	public void setMagnitude(String magnitude) {
		this.magnitude = magnitude;
	}
	public EarthquaeModel() {

	}


}
