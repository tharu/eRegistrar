package edu.mum.cs.cs425.demowebapps.eregistrar.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="transcripts")
public class Transcript
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transcriptId;	
	private String degreeTitle;
	@OneToOne(mappedBy = "transcript", cascade = CascadeType.ALL)
	private Student student;
	
	public Transcript()
	{
		
	}
	
	public Transcript(long transcriptId, String degreeTitle)
	{
		this.transcriptId=transcriptId;
		this.degreeTitle= degreeTitle;
	}
	
	public long getTranscriptId() {
		return transcriptId;
	}
	public void setTranscriptId(long transcriptId) {
		this.transcriptId = transcriptId;
	}
	public String getDegreeTitle() {
		return degreeTitle;
	}
	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}
}
