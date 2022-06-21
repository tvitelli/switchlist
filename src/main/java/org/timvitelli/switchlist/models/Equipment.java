package org.timvitelli.switchlist.models;

import javax.persistence.*;

@Entity(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "reporting_mark")
    private String reportingMark;
    @Column(name = "current_location")
    private String currentLocation;
    @Column(name = "future_location")
    private String futureLocation;
    @Column(name = "load_status")
    private Boolean loadStatus;
    @Column(name = "type_id")
    private String typeId;
    @Column(name = "length")
    private Integer length;
    @Column(name = "owner_id")
    private String ownerId;

    public Equipment() {

    }
/*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "track_id")
    private Track track;

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportingMark() {
        return reportingMark;
    }

    public void setReportingMark(String equipmentId) {
        this.reportingMark = equipmentId;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getFutureLocation() {
        return futureLocation;
    }

    public void setFutureLocation(String futureLocation) {
        this.futureLocation = futureLocation;
    }

    public Boolean getLoadStatus() {
        return loadStatus;
    }

    public void setLoadStatus(Boolean loadStatus) {
        this.loadStatus = loadStatus;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }




}
