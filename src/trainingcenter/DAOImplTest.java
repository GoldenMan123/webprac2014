package trainingcenter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DAOImplTest {
	
	private boolean equals(Object a, Object b) {
		if (a == b) {
			return true;
		}
		if ((a == null) || (b == null)) {
			return false;
		}
		return a.equals(b);
	}
	
	@Test(dataProvider = "studentTestData")
	public void studentTest(String s1, String s2, String s3, boolean exc) {
		TrainingCenterDAO tc = new TrainingCenterDAOImpl();
		
		Integer rows = null;
		
		try {
			rows = tc.getAllStudents().size();
		} catch (HibernateException e) {
			assert(false);
		}
		
		assert(rows != null);
	  
		Student student = new Student();
		student.setFirstName(s1);
		student.setLastName(s2);
		student.setMiddleName(s3);
		
		boolean wasExc = false;
		  
		try {
			tc.storeStudent(student);
		} catch (HibernateException e) {
			assert(exc);
			wasExc = true;
		} 
				
		if (!wasExc) {
			assert(!exc);
		}
		
		if (exc) {
			return;
		}
		
		try {
			Student tmp = tc.loadStudent(student.getStudentId());
			assert(tmp != null);
			assert(equals(tmp.getFirstName(), s1));
			assert(equals(tmp.getLastName(), s2));
			assert(equals(tmp.getMiddleName(), s3));
			tmp.setFirstName(s2);
			tmp.setLastName(s1);
			tc.updateStudent(tmp);
			tmp = tc.loadStudent(student.getStudentId());
			assert(tmp != null);
			assert(equals(tmp.getFirstName(), s2));
			assert(equals(tmp.getLastName(), s1));
			assert(equals(tmp.getMiddleName(), s3));
			tc.deleteStudent(tmp);
		} catch (HibernateException e) {
			assert(false);
		}
		
		wasExc = false;
		
		try {
			tc.loadStudent(student.getStudentId());
		} catch (HibernateException e) {
			wasExc = true;
		}
		
		assert(wasExc);
		assert(rows.equals(tc.getAllStudents().size()));
	}

	@DataProvider
	public Object[][] studentTestData() {
		return new Object[][] {
			new Object[] { "TEST1", "TEST2", "TEST3", false },
			new Object[] { "TEST1", "TEST2", null, false },
			new Object[] { "TEST1", null, "TEST3", true },
			new Object[] { null, "TEST2", "TEST3", true },
			new Object[] { null, null, "TEST3", true },
			new Object[] { null, "TEST2", null, true },
			new Object[] { "TEST1", null, null, true },
			new Object[] { null, null, null, true },
		};
	}
	
	@Test(dataProvider = "teacherTestData")
	public void teacherTest(String s1, String s2, String s3, boolean exc) {
		TrainingCenterDAO tc = new TrainingCenterDAOImpl();
		
		Integer rows = null;
		
		try {
			rows = tc.getAllTeachers().size();
		} catch (HibernateException e) {
			assert(false);
		}
		
		assert(rows != null);
	  
		Teacher teacher = new Teacher();
		teacher.setFirstName(s1);
		teacher.setLastName(s2);
		teacher.setMiddleName(s3);
		
		boolean wasExc = false;
		  
		try {
			tc.storeTeacher(teacher);
		} catch (HibernateException e) {
			assert(exc);
			wasExc = true;
		} 
				
		if (!wasExc) {
			assert(!exc);
		}
		
		if (exc) {
			return;
		}
		
		try {
			Teacher tmp = tc.loadTeacher(teacher.getTeacherId());
			assert(tmp != null);
			assert(equals(tmp.getFirstName(), s1));
			assert(equals(tmp.getLastName(), s2));
			assert(equals(tmp.getMiddleName(), s3));
			tmp.setFirstName(s2);
			tmp.setLastName(s1);
			tc.updateTeacher(tmp);
			tmp = tc.loadTeacher(teacher.getTeacherId());
			assert(tmp != null);
			assert(equals(tmp.getFirstName(), s2));
			assert(equals(tmp.getLastName(), s1));
			assert(equals(tmp.getMiddleName(), s3));
			tc.deleteTeacher(tmp);
		} catch (HibernateException e) {
			assert(false);
		}
		
		wasExc = false;
		
		try {
			tc.loadTeacher(teacher.getTeacherId());
		} catch (HibernateException e) {
			wasExc = true;
		}
		
		assert(wasExc);
		assert(rows.equals(tc.getAllTeachers().size()));
	}

	@DataProvider
	public Object[][] teacherTestData() {
		return new Object[][] {
			new Object[] { "TEST1", "TEST2", "TEST3", false },
			new Object[] { "TEST1", "TEST2", null, false },
			new Object[] { "TEST1", null, "TEST3", true },
			new Object[] { null, "TEST2", "TEST3", true },
			new Object[] { null, null, "TEST3", true },
			new Object[] { null, "TEST2", null, true },
			new Object[] { "TEST1", null, null, true },
			new Object[] { null, null, null, true },
		};
	}
	
	@Test(dataProvider = "companyTestData")
	public void companyTest(String s1, String s2, boolean exc) {
		TrainingCenterDAO tc = new TrainingCenterDAOImpl();
		
		Integer rows = null;
		
		try {
			rows = tc.getAllCompanies().size();
		} catch (HibernateException e) {
			assert(false);
		}
		
		assert(rows != null);
	  
		Company company = new Company();
		company.setName(s1);
		company.setAddress(s2);
		
		boolean wasExc = false;
		  
		try {
			tc.storeCompany(company);
		} catch (HibernateException e) {
			assert(exc);
			wasExc = true;
		} 
				
		if (!wasExc) {
			assert(!exc);
		}
		
		if (exc) {
			return;
		}
		
		try {
			Company tmp = tc.loadCompany(company.getCompanyId());
			assert(tmp != null);
			assert(equals(tmp.getName(), s1));
			assert(equals(tmp.getAddress(), s2));
			tmp.setAddress(s2 + s2);
			tc.updateCompany(tmp);
			tmp = tc.loadCompany(company.getCompanyId());
			assert(tmp != null);
			assert(equals(tmp.getName(), s1));
			assert(equals(tmp.getAddress(), s2 + s2));
			tc.deleteCompany(tmp);
		} catch (HibernateException e) {
			assert(false);
		}
		
		wasExc = false;
		
		try {
			tc.loadCompany(company.getCompanyId());
		} catch (HibernateException e) {
			wasExc = true;
		}
		
		assert(wasExc);
		assert(rows.equals(tc.getAllCompanies().size()));
	}

	@DataProvider
	public Object[][] companyTestData() {
		return new Object[][] {
			new Object[] { "TEST1", "TEST2", false },
			new Object[] { null, "TEST2", true },
			new Object[] { "TEST1", null, false },
			new Object[] { null, null, true },
		};
	}
	
	@Test(dataProvider = "courseTestData", dependsOnMethods = { "companyTest" })
	public void courseTest(String s1, boolean exc) {
		TrainingCenterDAO tc = new TrainingCenterDAOImpl();
		
		Integer rows = null;
		
		try {
			rows = tc.getAllCourses().size();
		} catch (HibernateException e) {
			assert(false);
		}
		
		assert(rows != null);
		
		Company company = new Company();
		company.setName("TEST");
		company.setAddress("TEST");
		
		try {
			tc.storeCompany(company);
		} catch (HibernateException e) {
			assert(false);
		}
		
		Course course = new Course();
		course.setCompanyId(company.getCompanyId());
		course.setName(s1);
		
		boolean wasExc = false;
		  
		try {
			tc.storeCourse(course);
		} catch (HibernateException e) {
			assert(exc);
			wasExc = true;
		} 
				
		if (!wasExc) {
			assert(!exc);
		}
		
		if (exc) {
			try {
				tc.deleteCompany(company);
			} catch (HibernateException e) {
				assert(false);
			} 
			return;
		}
		
		try {
			Course tmp = tc.loadCourse(course.getCourseId());
			assert(tmp != null);
			assert(equals(tmp.getName(), s1));
			assert(equals(tmp.getCompanyId(), company.getCompanyId()));
			tmp.setName(s1 + s1);
			tc.updateCourse(tmp);
			tmp = tc.loadCourse(course.getCourseId());
			assert(tmp != null);
			assert(equals(tmp.getName(), s1 + s1));
			assert(equals(tmp.getCompanyId(), company.getCompanyId()));
			tc.deleteCourse(tmp);
		} catch (HibernateException e) {
			assert(false);
		}
		
		wasExc = false;
		
		try {
			tc.loadCourse(course.getCourseId());
		} catch (HibernateException e) {
			wasExc = true;
		}
		
		try {
			tc.deleteCompany(company);
		} catch (HibernateException e) {
			assert(false);
		}
		
		assert(wasExc);		
		assert(rows.equals(tc.getAllCourses().size()));
	}
	
	@DataProvider
	public Object[][] courseTestData() {
		return new Object[][] {
			new Object[] { "TEST", false },
			new Object[] { null, true },
		};
	}
	
	@Test(dataProvider = "studentCourseTestData", dependsOnMethods = { "studentTest", "courseTest" })
	public void studentCourseTest() {	
		TrainingCenterDAO tc = new TrainingCenterDAOImpl();
		
		Integer rows = null;
		
		try {
			rows = tc.getAllStudentCourses().size();
		} catch (HibernateException e) {
			assert(false);
		}
		
		assert(rows != null);
		
		Company company = new Company();
		company.setName("TEST");
		company.setAddress("TEST");
		
		Student student = new Student();
		student.setFirstName("TEST");
		student.setLastName("TEST");
		student.setMiddleName("TEST");
		
		try {
			tc.storeCompany(company);
			tc.storeStudent(student);
		} catch (HibernateException e) {
			assert(false);
		}
		
		Course course = new Course();
		course.setCompanyId(company.getCompanyId());
		course.setName("TEST");
		
		try {
			tc.storeCourse(course);
		} catch (HibernateException e) {
			assert(false);
		}
		
		StudentCourse link = new StudentCourse();
		link.setCourseId(course.getCourseId());
		link.setStudentId(student.getStudentId());
		
		try {
			tc.storeStudentCourse(link);
		} catch (HibernateException e) {
			assert(false);
		} 
				
		try {
			StudentCourse tmp = tc.loadStudentCourse(link.getLinkId());
			assert(tmp != null);
			assert(equals(tmp.getCourseId(), course.getCourseId()));
			assert(equals(tmp.getStudentId(), student.getStudentId()));
			tc.deleteStudentCourse(tmp);
		} catch (HibernateException e) {
			assert(false);
		}
		
		boolean wasExc = false;
		
		try {
			tc.loadStudentCourse(link.getLinkId());
		} catch (HibernateException e) {
			wasExc = true;
		}
		
		try {
			tc.deleteCourse(course);
			tc.deleteStudent(student);
			tc.deleteCompany(company);
		} catch (HibernateException e) {
			assert(false);
		}
		
		assert(wasExc);		
		assert(rows.equals(tc.getAllStudentCourses().size()));
	}
	
	@DataProvider
	public Object[][] studentCourseTestData() {
		return new Object[][] {
			new Object[] {},
		};
	}
	
	private Date parseDate(String str) {
		if (str == null) {
			return null;
		}
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		Date result;
		try {
			result = df.parse(str);
		} catch (ParseException e) {
			return null;
		}
		return result;
	}
	
	private Date parseTime(String str) {
		if (str == null) {
			return null;
		}
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date result;
		try {
			result = df.parse(str);
		} catch (ParseException e) {
			return null;
		}
		return result;
	}
	
	private boolean dateEquals(Date a, Date b) {
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		return equals(format.format(a), format.format(b));
	}
	
	private boolean timeEquals(Date a, Date b) {
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
		return equals(format.format(a), format.format(b));
	}
	
	@Test(dataProvider = "lessonTestData", dependsOnMethods = { "teacherTest", "courseTest" })
	public void lessonTest(String s1, String s2, String s3, String s4, Integer p, boolean exc) {	
		TrainingCenterDAO tc = new TrainingCenterDAOImpl();
		
		Integer rows = null;
		
		try {
			rows = tc.getAllLessons().size();
		} catch (HibernateException e) {
			assert(false);
		}
		
		assert(rows != null);
		
		Company company = new Company();
		company.setName("TEST");
		company.setAddress("TEST");
		
		Teacher teacher = new Teacher();
		teacher.setFirstName("TEST");
		teacher.setLastName("TEST");
		teacher.setMiddleName("TEST");
		
		try {
			tc.storeCompany(company);
			tc.storeTeacher(teacher);
		} catch (HibernateException e) {
			assert(false);
		}
		
		Course course = new Course();
		course.setCompanyId(company.getCompanyId());
		course.setName("TEST");
		
		try {
			tc.storeCourse(course);
		} catch (HibernateException e) {
			assert(false);
		}

		Date d1 = parseDate(s1);
		Date d2 = parseDate(s2);
		Date d3 = parseTime(s3);
		Date d4 = parseTime(s4);
		
		Lesson lesson = new Lesson();
		lesson.setCourseId(course.getCourseId());
		lesson.setTeacherId(teacher.getTeacherId());
		lesson.setDate_start(d1);
		lesson.setDate_end(d2);
		lesson.setTime(d3);
		lesson.setDuration(d4);
		lesson.setPeriod(p);
		
		boolean wasExc = false;
		
		try {
			tc.storeLesson(lesson);
		} catch (HibernateException e) {
			wasExc = true;
		} 
		
		if (wasExc != exc) {
			try {
				tc.deleteCourse(course);
				tc.deleteTeacher(teacher);
				tc.deleteCompany(company);
			} catch (HibernateException e) {
				assert(false);
			}
			assert(false);
		}
		
		if (exc) {
			try {
				tc.deleteCourse(course);
				tc.deleteTeacher(teacher);
				tc.deleteCompany(company);
			} catch (HibernateException e) {
				assert(false);
			}
			return;
		}
				
		try {
			Lesson tmp = tc.loadLesson(lesson.getLessonId());
			assert(tmp != null);
			assert(equals(tmp.getCourseId(), course.getCourseId()));
			assert(equals(tmp.getTeacherId(), teacher.getTeacherId()));
			assert(dateEquals(tmp.getDate_start(), d1));
			assert(dateEquals(tmp.getDate_end(), d2));
			assert(timeEquals(tmp.getTime(), d3));
			assert(timeEquals(tmp.getDuration(), d4));
			assert(equals(tmp.getPeriod(), p));
			tmp.setDate_end(tmp.getDate_start());
			tc.updateLesson(tmp);
			assert(equals(tmp.getCourseId(), course.getCourseId()));
			assert(equals(tmp.getTeacherId(), teacher.getTeacherId()));
			assert(dateEquals(tmp.getDate_start(), d1));
			assert(dateEquals(tmp.getDate_end(), d1));
			assert(timeEquals(tmp.getTime(), d3));
			assert(timeEquals(tmp.getDuration(), d4));
			assert(equals(tmp.getPeriod(), p));
			tc.deleteLesson(tmp);
		} catch (HibernateException e) {
			assert(false);
		}
		
		wasExc = false;	
		
		try {
			tc.loadLesson(lesson.getLessonId());
		} catch (HibernateException e) {
			wasExc = true;
		}
		
		try {
			tc.deleteCourse(course);
			tc.deleteTeacher(teacher);
			tc.deleteCompany(company);
		} catch (HibernateException e) {
			assert(false);
		}
		
		assert(wasExc);		
		assert(rows.equals(tc.getAllLessons().size()));
	}

	@DataProvider
	public Object[][] lessonTestData() {
		return new Object[][] {
			new Object[] { "20.02.2014", "21.02.2014", "08:45:00", "01:30:00", 0, false },
			new Object[] { "20.02.2014", "21.02.2014", null, "01:30:00", 2, true },
			new Object[] { "20.02.2014", "21.02.2014", "08:45:00", null, 0, true },
			new Object[] { "20.02.2014", null, "08:45:00", "01:30:00", 1, true },
			new Object[] { null, "21.02.2014", "08:45:00", "01:30:00", 2, true },
		};
	}
	
	@Test(dataProvider = "studentByCourseTestData", dependsOnMethods = { "studentCourseTest" })
	public void studentByCourseTest() {	
		TrainingCenterDAO tc = new TrainingCenterDAOImpl();
		
		List<Course> courses = null;
		try {
			courses = tc.getAllCourses();
		} catch (HibernateException e) {
			assert(false);
		}
		assert(courses != null);
		
		List<StudentCourse> links = null;
		try {
			links = tc.getAllStudentCourses();
		} catch (HibernateException e) {
			assert(false);
		}
		assert(links != null);
		
		for (Course course : courses) {
			List<Student> sbc = null; 
			try {
				sbc = tc.getStudentByCourse(course.getCourseId());
			} catch (HibernateException e) {
				assert(false);
			}
			assert(sbc != null);
			for (Student student : sbc) {
				boolean ok = false;
				for (StudentCourse link : links) {
					if ((link.getCourseId() == course.getCourseId()) &&
						(link.getStudentId() == student.getStudentId())) {
						ok = true;
						break;
					}
				}
				assert(ok);
			}
			for (StudentCourse link : links) {
				if (link.getCourseId() == course.getCourseId()) {
					boolean ok = false;
					for (Student student : sbc) {
						if (student.getStudentId() == link.getStudentId()) {
							ok = true;
							break;
						}
					}
					assert(ok);
				}
			}
		}
		
	}
	
	@DataProvider
	public Object[][] studentByCourseTestData() {
		return new Object[][] {
			new Object[] {},
		};
	}
	
	@Test(dataProvider = "teacherByCourseTestData", dependsOnMethods = { "courseTest", "lessonTest" })
	public void teacherByCourseTest() {
		TrainingCenterDAO tc = new TrainingCenterDAOImpl();
		
		List<Course> courses = null;
		try {
			courses = tc.getAllCourses();
		} catch (HibernateException e) {
			assert(false);
		}
		assert(courses != null);
		
		List<Lesson> lessons = null;
		try {
			lessons = tc.getAllLessons();
		} catch (HibernateException e) {
			assert(false);
		}
		assert(lessons != null);
		
		for (Course course : courses) {
			List<Teacher> tbc = null; 
			try {
				tbc = tc.getTeacherByCourse(course.getCourseId());
			} catch (HibernateException e) {
				assert(false);
			}
			assert(tbc != null);
			for (Teacher teacher : tbc) {
				boolean ok = false;
				for (Lesson lesson : lessons) {
					if ((lesson.getCourseId() == course.getCourseId()) &&
						lesson.getTeacherId() == teacher.getTeacherId()) {
						ok = true;
						break;
					}
				}
				assert(ok);
			}
			for (Lesson lesson : lessons) {
				if (lesson.getCourseId() == course.getCourseId()) {
					boolean ok = false;
					for (Teacher teacher : tbc) {
						if (lesson.getTeacherId() == teacher.getTeacherId()) {
							ok = true;
							break;
						}
					}
					assert(ok);
				}
			}
		}
		
	}
	
	@DataProvider
	public Object[][] teacherByCourseTestData() {
		return new Object[][] {
			new Object[] {},
		};
	}
	
	@Test(dataProvider = "lessonsByCourseTestData", dependsOnMethods = { "courseTest", "lessonTest" })
	public void lessonsByCourseTest() {
		TrainingCenterDAO tc = new TrainingCenterDAOImpl();
		
		List<Course> courses = null;
		try {
			courses = tc.getAllCourses();
		} catch (HibernateException e) {
			assert(false);
		}
		assert(courses != null);
		
		List<Lesson> lessons = null;
		try {
			lessons = tc.getAllLessons();
		} catch (HibernateException e) {
			assert(false);
		}
		assert(lessons != null);
		
		for (Course course : courses) {		
			List<Lesson> lbc = null;
			try {
				lbc = tc.getLessonsByCourse(course.getCourseId());
			} catch (HibernateException e) {
				assert(false);
			}
			assert(lessons != null);
			for (Lesson lesson : lbc) {
				assert(lesson.getCourseId() == course.getCourseId());
			}
			for (Lesson lesson1 : lessons) {
				if (lesson1.getCourseId() == course.getCourseId()) {
					boolean ok = false;
					for (Lesson lesson2 : lbc) {
						if (lesson2.getLessonId() == lesson1.getLessonId()) {
							ok = true;
							break;
						}
					}
					assert(ok);
				}
			}
		}
	}
	
	@DataProvider
	public Object[][] lessonsByCourseTestData() {
		return new Object[][] {
			new Object[] {},
		};
	}
	
	private boolean compareDate(Date a, Date b) {
		return DateTimeComparator.getDateOnlyInstance().compare(new DateTime(a), new DateTime(b)) <= 0;
	}	
	
	@Test(dataProvider = "lessonsByStudentTestData", dependsOnMethods = { "lessonTest", "studentCourseTest" })
	public void lessonsByStudentTest(Integer week_begin, Integer week_end) {
		TrainingCenterDAO tc = new TrainingCenterDAOImpl();
		
		List<Student> students = null;
		try {
			students = tc.getAllStudents();
		} catch (HibernateException e) {
			assert(false);
		}
		assert(students != null);
		
		List<Lesson> lessons = null;
		try {
			lessons = tc.getAllLessons();
		} catch (HibernateException e) {
			assert(false);
		}
		assert(lessons != null);
		
		List<StudentCourse> links = null;
		try {
			links = tc.getAllStudentCourses();
		} catch (HibernateException e) {
			assert(false);
		}
		assert(links != null);
		
		for (Student student : students) {
			for (int i = week_begin.intValue(); i < week_end.intValue(); ++i) {
				List<Lesson2> lbs = null;
				try {
					lbs = tc.getLessonsByStudent(student.getStudentId(), new Integer(i));
				} catch (HibernateException e) {
					assert(false);
				} catch (ParseException e) {
					assert(false);
				}
				assert(lbs != null);
				DateTime now = new DateTime(new Date()).plusWeeks(new Integer(i));
				for (Lesson2 lesson2 : lbs) {
					boolean ok = false;
					for (StudentCourse link : links) {
						try {
							Course cur_course = tc.loadCourse(link.getCourseId());
							if ((link.getStudentId() == student.getStudentId()) &&
									(equals(cur_course.getName(), lesson2.getCourseName()))) {
								ok = true;
								break;
							}
						} catch (HibernateException e) {
							assert(false);
						}
					}
					assert(ok);
					DateTime lesson_start = new DateTime(lesson2.getDate());
					Date lesson_day = now.withDayOfWeek(lesson_start.getDayOfWeek()).toDate();
					assert(compareDate(lesson2.getDate(), lesson_day) &&
						compareDate(lesson_day, lesson2.getDate()));
				}
			}
		}
		
	}
	
	@DataProvider
	public Object[][] lessonsByStudentTestData() {
		return new Object[][] {
			new Object[] { -100, 100 },
		};
	}
	
	@Test(dataProvider = "lessonsByTeacherTestData", dependsOnMethods = { "lessonTest", "teacherTest" })
	public void lessonsByTeacherTestData(Integer week_begin, Integer week_end) {
		TrainingCenterDAO tc = new TrainingCenterDAOImpl();
		
		List<Teacher> teachers = null;
		try {
			teachers = tc.getAllTeachers();
		} catch (HibernateException e) {
			assert(false);
		}
		assert(teachers != null);
		
		List<Lesson> lessons = null;
		try {
			lessons = tc.getAllLessons();
		} catch (HibernateException e) {
			assert(false);
		}
		assert(lessons != null);
		
		for (Teacher teacher : teachers) {
			for (int i = week_begin.intValue(); i < week_end.intValue(); ++i) {
				List<Lesson2> lbt = null;
				try {
					lbt = tc.getLessonsByTeacher(teacher.getTeacherId(), new Integer(i));
				} catch (HibernateException e) {
					assert(false);
				} catch (ParseException e) {
					assert(false);
				}
				assert(lbt != null);
				DateTime now = new DateTime(new Date()).plusWeeks(new Integer(i));
				for (Lesson2 lesson2 : lbt) {
					DateTime lesson_start = new DateTime(lesson2.getDate());
					Date lesson_day = now.withDayOfWeek(lesson_start.getDayOfWeek()).toDate();
					assert(compareDate(lesson2.getDate(), lesson_day) &&
						compareDate(lesson_day, lesson2.getDate()));
				}
			}
		}
		
	}
	
	@DataProvider
	public Object[][] lessonsByTeacherTestData() {
		return new Object[][] {
			new Object[] { -100, 100 },
		};
	}
	
	@Test(dataProvider = "coursesByCompanyTestData", dependsOnMethods = { "courseTest", "companyTest" })
	public void coursesByCompanyTest() {
		TrainingCenterDAO tc = new TrainingCenterDAOImpl();
		
		List<Course> courses = null;
		try {
			courses = tc.getAllCourses();
		} catch (HibernateException e) {
			assert(false);
		}
		assert(courses != null);
		
		List<Company> companies = null;
		try {
			companies = tc.getAllCompanies();
		} catch (HibernateException e) {
			assert(false);
		}
		assert(companies != null);
		
		for (Company company : companies) {
			List<Course> cbc = null; 
			try {
				cbc = tc.getCoursesByCompany(company.getCompanyId());
			} catch (HibernateException e) {
				assert(false);
			}
			assert(cbc != null);
			for (Course course : cbc) {
				assert(course.getCompanyId() == company.getCompanyId());
			}
			for (Course course1 : courses) {
				if (course1.getCompanyId() == company.getCompanyId()) {
					boolean ok = false;
					for (Course course2 : cbc) {
						if (course1.getCompanyId() == course2.getCompanyId()) {
							ok = true;
							break;
						}
					}
					assert(ok);
				}
			}
		}
		
	}
	
	@DataProvider
	public Object[][] coursesByCompanyTestData() {
		return new Object[][] {
			new Object[] {},
		};
	}
  
}
