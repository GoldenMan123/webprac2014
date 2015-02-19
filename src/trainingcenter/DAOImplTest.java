package trainingcenter;

import org.hibernate.HibernateException;
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
  
}
