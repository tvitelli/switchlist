package org.timvitelli.switchlist.models;

import javax.persistence.*;

@Entity(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "reporting_mark")
    private String reportingMark;
    @ManyToOne
    @JoinColumn(name = "current_location")
    private Track currentLocation;
    @ManyToOne
    @JoinColumn(name = "future_location")
    private Track futureLocation;
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

    public Track getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Track currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Track getFutureLocation() {
        return futureLocation;
    }

    public void setFutureLocation(Track futureLocation) {
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
