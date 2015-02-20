package trainingcenter;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class TrainingCenterDAOImpl implements TrainingCenterDAO {

	private static SessionFactory sessions = null;
	
	public TrainingCenterDAOImpl() {
		if (sessions == null) {
			Configuration configuration = new Configuration();
			configuration.configure();
			sessions = configuration.buildSessionFactory(
				new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build());
		}
	}
	
	@Override
	public List<Course> getAllCourses() {
		Session session = sessions.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Course> list = session.createCriteria(Course.class).list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public Course loadCourse(Integer courseId) {
		Session session = sessions.openSession();
		session.beginTransaction();
		Course course = (Course) session.load(Course.class, courseId);
		session.getTransaction().commit();
		return course;
	}

	@Override
	public void storeCourse(Course course) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.save(course);
		session.getTransaction().commit();
	}

	@Override
	public void deleteCourse(Course course) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.delete(course);
		session.getTransaction().commit();
	}

	@Override
	public void updateCourse(Course course) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.update(course);
		session.getTransaction().commit();
	}

	@Override
	public List<Company> getAllCompanies() {
		Session session = sessions.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Company> list = session.createCriteria(Company.class).list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public Company loadCompany(Integer companyId) {
		Session session = sessions.openSession();
		session.beginTransaction();
		Company company = (Company) session.load(Company.class, companyId);
		session.getTransaction().commit();
		return company;
	}

	@Override
	public void storeCompany(Company company) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.save(company);
		session.getTransaction().commit();
	}

	@Override
	public void deleteCompany(Company company) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.delete(company);
		session.getTransaction().commit();
	}

	@Override
	public void updateCompany(Company company) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.update(company);
		session.getTransaction().commit();
	}

	@Override
	public List<Lesson> getAllLessons() {
		Session session = sessions.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Lesson> list = session.createCriteria(Lesson.class).list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public Lesson loadLesson(Integer lessonId) {
		Session session = sessions.openSession();
		session.beginTransaction();
		Lesson lesson = (Lesson) session.load(Lesson.class, lessonId);
		session.getTransaction().commit();
		return lesson;
	}

	@Override
	public void storeLesson(Lesson lesson) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.save(lesson);
		session.getTransaction().commit();
	}

	@Override
	public void deleteLesson(Lesson lesson) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.delete(lesson);
		session.getTransaction().commit();
	}

	@Override
	public void updateLesson(Lesson lesson) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.update(lesson);
		session.getTransaction().commit();
	}

	@Override
	public List<Student> getAllStudents() {
		Session session = sessions.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Student> list = session.createCriteria(Student.class).list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public Student loadStudent(Integer studentId) {
		Session session = sessions.openSession();
		session.beginTransaction();
		Student student = (Student) session.load(Student.class, studentId);
		session.getTransaction().commit();
		return student;
	}

	@Override
	public void storeStudent(Student student) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
	}

	@Override
	public void deleteStudent(Student student) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.delete(student);
		session.getTransaction().commit();
	}

	@Override
	public void updateStudent(Student student) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.update(student);
		session.getTransaction().commit();
	}

	@Override
	public List<Teacher> getAllTeachers() {
		Session session = sessions.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Teacher> list = session.createCriteria(Teacher.class).list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public Teacher loadTeacher(Integer teacherId) {
		Session session = sessions.openSession();
		session.beginTransaction();
		Teacher teacher = (Teacher) session.load(Teacher.class, teacherId);
		session.getTransaction().commit();
		return teacher;
	}

	@Override
	public void storeTeacher(Teacher teacher) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.save(teacher);
		session.getTransaction().commit();
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.delete(teacher);
		session.getTransaction().commit();
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.update(teacher);
		session.getTransaction().commit();
	}

	@Override
	public List<StudentCourse> getAllStudentCourses() {
		Session session = sessions.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<StudentCourse> list = session.createCriteria(StudentCourse.class).list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public StudentCourse loadStudentCourse(Integer linkId) {
		Session session = sessions.openSession();
		session.beginTransaction();
		StudentCourse link = (StudentCourse) session.load(StudentCourse.class, linkId);
		session.getTransaction().commit();
		return link;
	}

	@Override
	public void storeStudentCourse(StudentCourse link) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.save(link);
		session.getTransaction().commit();
	}

	@Override
	public void deleteStudentCourse(StudentCourse link) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.delete(link);
		session.getTransaction().commit();
	}

	@Override
	public void updateStudentCourse(StudentCourse link) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.update(link);
		session.getTransaction().commit();
	}

	@Override
	public List<Student> getStudentByCourse(Integer courseId) {
		Session session = sessions.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select student from Student student,"
				+ "StudentCourse link where student.studentId ="
				+ "link.studentId and link.courseId = "
				+ courseId.toString());
		@SuppressWarnings("unchecked")
		List<Student> list = query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public List<Teacher> getTeacherByCourse(Integer courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lesson> getLessonsByCourse(Integer courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lesson> getLessonsByStudent(Integer studentId, Integer weekId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lesson> getLessonsByTeacher(Integer teacherId, Integer weekId) {
		// TODO Auto-generated method stub
		return null;
	}

}
