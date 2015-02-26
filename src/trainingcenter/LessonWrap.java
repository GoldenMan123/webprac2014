package trainingcenter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LessonWrap {
	
	private Integer lessonId;
	
	private Integer courseId;
	
	private Integer teacherId;
	
	private String time;
	
	private String duration;
	
	private Integer period;
	
	private String date_start;
	
	private String date_end;
	
	public Lesson toLesson() throws ParseException {
		DateFormat time_f = new SimpleDateFormat("HH:mm");
		DateFormat date_f = new SimpleDateFormat("dd.MM.yyyy");
		Lesson lesson = new Lesson();
		lesson.setLessonId(lessonId);
		lesson.setCourseId(courseId);
		lesson.setTeacherId(teacherId);
		lesson.setTime(time_f.parse(time));
		lesson.setDuration(time_f.parse(duration));
		lesson.setDate_start(date_f.parse(date_start));
		lesson.setDate_end(date_f.parse(date_end));
		lesson.setPeriod(period);
		return lesson;
	}

	public Integer getLessonId() {
		return lessonId;
	}

	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public String getDate_start() {
		return date_start;
	}

	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}

	public String getDate_end() {
		return date_end;
	}

	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}
	
	
}
