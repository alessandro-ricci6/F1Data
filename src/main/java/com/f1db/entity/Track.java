package com.f1db.entity;

import jakarta.persistence.*;

@Entity
public class Track {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "trackId")
    private int trackId;
    public int getTrackId() {
        return trackId;
    }
    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    @Basic
    @Column(name = "name")
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "country")
    private String country;
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "city")
    private String city;
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "length")
    private Integer length;
    public int getLength() {
        return length;
    }
    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        if(trackId != track.trackId) return false;
        if(name != null ? name.equals(track.name) : track.name != null) return false;
        if(country != null ? country.equals(track.country) : track.country != null) return false;
        if(city != null ? city.equals(track.city) : track.city != null) return false;
        if(length != null ? length.equals(track.length) :  track.length != null) return false;

        return  true;
    }

    @Override
    public int hashCode() {
        int result = trackId;
        result = result * 31 + (name != null ? name.hashCode() : 0);
        result = result * 31 + (country != null ? country.hashCode() : 0);
        result = result * 31 + (city != null ? city.hashCode() : 0);
        result = result * 31 + (length != null ? length.hashCode() : 0);

        return result;
    }
}
