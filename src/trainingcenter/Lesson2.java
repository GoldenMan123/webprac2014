package trainingcenter;

import java.util.Date;

public class Lesson2 {
	
	private Integer lessonId;
	
	private String courseName;
	
	private Date time_start;
	
	private Date time_end;
	
	private Date date;

	public Integer getLessonId() {
		return lessonId;
	}

	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getTime_start() {
		return time_start;
	}

	public void setTime_start(Date time_start) {
		this.time_start = time_start;
	}

	public Date getTime_end() {
		return time_end;
	}

	public void setTime_end(Date time_end) {
		this.time_end = time_end;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
