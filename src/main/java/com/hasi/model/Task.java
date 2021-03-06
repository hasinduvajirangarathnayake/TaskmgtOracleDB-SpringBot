package com.hasi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TASK")
public class Task {
	
	 private long id;
	private String taskname;
	  private String completedate;
	  private String status;
	  private String startdate;
	  
	  
	  public Task() {
		  
	  }
	  
	  public Task(String taskname, String completedate, String status, String startdate) {
		this.taskname = taskname;
		this.completedate = completedate;
		this.status = status;
		this.startdate = startdate;
	}
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		
		@Column(name = "TASKNAME", nullable = false)
		 public String getTaskname() {
			return taskname;
		}
		public void setTaskname(String taskname) {
			this.taskname = taskname;
		}
		
		
		@Column(name = "COMPLETEDATE", nullable = false)
		public String getCompletedate() {
			return completedate;
		}
		public void setCompletedate(String completedate) {
			this.completedate = completedate;
		}
		
		
		@Column(name = "STATUS", nullable = false)
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		
		@Column(name = "STARTDATE", nullable = false)
		public String getStartdate() {
			return startdate;
		}
		public void setStartdate(String startdate) {
			this.startdate = startdate;
		}
	
}
