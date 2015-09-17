package edu.itu.course.dropwizard.jdbi.dao;

import java.util.Date;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import edu.itu.course.dropwizard.api.beans.Device;
import edu.itu.course.dropwizard.api.beans.DeviceData;
import edu.itu.course.dropwizard.jdbi.mappers.DeviceDataMapper;

// TODO: Auto-generated Javadoc
/**
 * The Interface DeviceDataDAO.
 */
@RegisterMapper(DeviceDataMapper.class)
public interface DeviceDataDAO {
	 
 	/** The Constant DEVICE_DATA_TABLE. */
 	// NOTE: User is a reserved keyword in Derby
    public static final String DEVICE_DATA_TABLE = "device_data";

    /**
     * Creates the device data table.
     */
    @SqlUpdate("create table " + DEVICE_DATA_TABLE + " (id int(11) NOT NULL AUTO_INCREMENT,device_id int(11), data float, timestamp TIMESTAMP,PRIMARY KEY (id))")
    void createDeviceDataTable();

    /**
     * Insert.
     *
     * @param device the device
     */
    @SqlUpdate("insert into " + DEVICE_DATA_TABLE + " (id, device_id, data , timestamp) values (:id, :device_id, :data,:timestamp)")
    void insert(@BindBean final Device device);

    /**
     * Gets the device data by id.
     *
     * @param id the id
     * @return the device data by id
     */
    @SqlQuery("select * from " + DEVICE_DATA_TABLE + " where id = :id")
    DeviceData getDeviceDataById(@Bind("id") int id);
    
    /**
     * Gets the device data by device id.
     *
     * @param id the id
     * @return the device data by device id
     */
    @SqlQuery("select * from " + DEVICE_DATA_TABLE + " where device_id = :id")
    List<DeviceData> getDeviceDataByDeviceId(@Bind("id") int id);
    
    
    /**
     * Gets the device period data by device id.
     *
     * @param id the id
     * @param starttime the starttime
     * @param endendtime the endendtime
     * @return the device period data by device id
     */
    @SqlQuery("select * from " + DEVICE_DATA_TABLE + " where device_id = :id and timestamp between :starttime and :endtime order by id ASC")
    List<DeviceData> getDevicePeriodDataByDeviceId(@Bind("id") int id,@Bind("starttime") Date starttime,@Bind("endtime") Date endendtime);

    /**
     * Removes the device.
     *
     * @param deviceId the device id
     */
    @SqlUpdate("delete from " + DEVICE_DATA_TABLE + " where id = :it")
    void removeDevice(@Bind int deviceId);

    /**
     * Update device databy id.
     *
     * @param deviceId the device id
     */
    @SqlUpdate("update " + DEVICE_DATA_TABLE + "set name = :name  where id = :it ")
	void updateDeviceDatabyId(String deviceId);
    
    
    /**
     * Insert device data by id.
     *
     * @param deviceData the device data
     */
    @SqlUpdate("insert into " + DEVICE_DATA_TABLE + " (device_id, data,timestamp) values (:deviceId, :data, :timestamp)")
    void insertDeviceDataById(@BindBean final DeviceData deviceData);
    
    
}
