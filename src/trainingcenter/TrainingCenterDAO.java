package trainingcenter;

import java.util.List;

import org.hibernate.HibernateException;

public interface TrainingCenterDAO {
	
	public List<Course> getAllCourses() throws HibernateException;
	
	public Course loadCourse(Integer courseId) throws HibernateException;
	
	public void storeCourse(Course course) throws HibernateException;
	
	public void deleteCourse(Course course) throws HibernateException;
	
	public void updateCourse(Course course) throws HibernateException;
	
	public List<Company> getAllCompanies() throws HibernateException;
	
	public Company loadCompany(Integer companyId) throws HibernateException;
	
	public void storeCompany(Company company) throws HibernateException;
	
	public void deleteCompany(Company company) throws HibernateException;
	
	public void updateCompany(Company company) throws HibernateException;
	
	public List<Lesson> getAllLessons() throws HibernateException;
	
	public Lesson loadLesson(Integer lessonId) throws HibernateException;
	
	public void storeLesson(Lesson lesson) throws HibernateException;
	
	public void deleteLesson(Lesson lesson) throws HibernateException;
	
	public void updateLesson(Lesson lesson) throws HibernateException;
	
	public List<Student> getAllStudents() throws HibernateException;
	
	public Student loadStudent(Integer studentId) throws HibernateException;
	
	public void storeStudent(Student student) throws HibernateException;
	
	public void deleteStudent(Student student) throws HibernateException;
	
	public void updateStudent(Student student) throws HibernateException;
	
	public List<Teacher> getAllTeachers() throws HibernateException;
	
	public Teacher loadTeacher(Integer teacherId) throws HibernateException;
	
	public void storeTeacher(Teacher teacher) throws HibernateException;
	
	public void deleteTeacher(Teacher teacher) throws HibernateException;
	
	public void updateTeacher(Teacher teacher) throws HibernateException;
	
	public List<StudentCourse> getAllStudentCourses() throws HibernateException;
	
	public StudentCourse loadStudentCourse(Integer linkId) throws HibernateException;
	
	public void storeStudentCourse(StudentCourse link) throws HibernateException;
	
	public void deleteStudentCourse(StudentCourse link) throws HibernateException;
	
	public void updateStudentCourse(StudentCourse link) throws HibernateException;
	
	public List<Student> getStudentByCourse(Integer courseId) throws HibernateException;
	
	public List<Teacher> getTeacherByCourse(Integer courseId) throws HibernateException;
	
	public List<Lesson> getLessonsByCourse(Integer courseId) throws HibernateException;
	
	public List<Lesson> getLessonsByStudent(Integer studentId, Integer weekId) throws HibernateException;
	
	public List<Lesson> getLessonsByTeacher(Integer teacherId, Integer weekId) throws HibernateException;

}
