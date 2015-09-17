package edu.itu.course.dropwizard.api.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class DeviceData.
 */
@XmlRootElement
public class DeviceData {

	/** The id. */
	@JsonProperty("id")
	private int id;
    
    /** The device id. */
	@JsonProperty("deviceId")
    private int deviceId;
    
    /** The data. */
	@JsonProperty("data")
    private float data;
    
    /** The timestamp. */
	@JsonProperty("timestamp")
    private Date timestamp;
    
	public DeviceData() {
		super();
	}
	
	/**
	 * Instantiates a new device data.
	 *
	 * @param deviceId the device id
	 * @param data the data
	 * @param timestamp the timestamp
	 */
	public DeviceData(int deviceId, float data, Date timestamp) {
		this.deviceId = deviceId;
		this.data = data;
		this.timestamp = timestamp;
	}
	
	/**
	 * Instantiates a new device data.
	 *
	 * @param id the id
	 * @param deviceId the device id
	 * @param data the data
	 * @param timestamp the timestamp
	 */
	public DeviceData(int id,int deviceId, float data, Date timestamp) {
		this.id = id;
		this.deviceId = deviceId;
		this.data = data;
		this.timestamp = timestamp;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Gets the device id.
	 *
	 * @return the device id
	 */
	public int getDeviceId() {
		return deviceId;
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public float getData() {
		return data;
	}
	
	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	
	/* (non Javadoc) 
	* <p>Title: toString</p> 
	* <p>Description: </p> 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DeviceData [id=" + id + ", deviceId=" + deviceId + ", data="
				+ data + ", timestamp=" + timestamp + "]";
	}

	
}
