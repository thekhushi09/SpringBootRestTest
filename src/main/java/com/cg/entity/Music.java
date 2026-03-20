package com.cg.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity

@Table(name="abes_track")
public class Music {
	
	 @Id
	    @Column(name="track_id")
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer trackId;
	 
	 @Column(name="track_title")
	 private String trackTitle;
	 
	 @Column(name="album_name")
	 private String albumName;
	 
	 @Column(name="release_dt")
	 private LocalDate releaseDate;
	 
	 public Integer getTrackId() {
		 return trackId;
	 }
	 public String getTrackTitle() {
		 return trackTitle;
	 }
	 public String getAlbumName() {
		 return albumName;
	 }
	 public LocalDate getReleaseDate() {
		 return releaseDate;
	 }
	 public void setTrackId(Integer trackId) {
		 this.trackId = trackId;
	 }
	 public void setTrackTitle(String trackTitle) {
		 this.trackTitle = trackTitle;
	 }
	 public void setAlbumName(String albumName) {
		 this.albumName = albumName;
	 }
	 public void setReleaseDate(LocalDate releaseDate) {
		 this.releaseDate = releaseDate;
	 }
	 
	 
	 @Override
	 public String toString() {
		return "Music [trackId=" + trackId + ", trackTitle=" + trackTitle + ", albumName=" + albumName
				+ ", releaseDate=" + releaseDate + "]";
	 }
	 
	 
	 

}
