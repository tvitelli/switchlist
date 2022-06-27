package org.timvitelli.switchlist.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "track")
public class Track {

    //Class for holding and retrieving data in the Track table in the DB
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "track_name")
    private String trackName;
    @Column(name = "length")
    private Integer length;
    @Column(name = "lading_type")
    private String ladingType;

    public Track() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getLadingType() {
        return ladingType;
    }

    public void setLadingType(String ladingType) {
        this.ladingType = ladingType;
    }


}
