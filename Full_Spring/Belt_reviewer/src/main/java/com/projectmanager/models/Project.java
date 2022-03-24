package com.projectmanager.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Title is required!")
	@Size(min = 3, message = "Description must be at least 3 characters!")
	private String title;

	@NotEmpty(message = "Author is required!")
	@Size(min = 5, max = 40, message = "Description must be at least 3 characters")
	private String description;

	@NotNull(message = "Please enter a date!")
	@Future(message = "Due date must be in the future!")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date duedate;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User teamLead;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "projects_users", 
    joinColumns = @JoinColumn(name = "project_id"), 
    inverseJoinColumns = @JoinColumn(name = "user_id")
    )
	private List<User> members;
	
	@OneToMany(mappedBy="project",fetch = FetchType.LAZY)
	private List<Task> tasks;
	
	 
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    
    //constructors
    
    public Project() {
		
	}
    
    public Project( String title, String description,Date duedate, User teamLead, List<User> members) {
		this.title = title;
		this.description = description;
		this.duedate = duedate;
		this.teamLead = teamLead;
		this.members = members;
	}
    
	
	
	
	//getters and setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<User> getMembers() {
		return members;
	}
	public void setMembers(List<User> members) {
		this.members = members;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User getTeamLead() {
		return teamLead;
	}
	public void setTeamLead(User teamLead) {
		this.teamLead = teamLead;
	}
	
	
	
	

	
	//@NotEmpty(message = "A due date is required!")
	
	
	
	

}
