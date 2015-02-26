package trainingcenter;

import java.text.ParseException;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class TrainingCenterController {

	private static TrainingCenterDAO dao = new TrainingCenterDAOImpl();

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndex(Model model) {
		return "index";
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String getStudents(Model model) {
		try {
			List<Student> students = dao.getAllStudents();
			model.addAttribute("students", students);
		} catch (HibernateException e) {
			return "error";
		}
		return "students";
	}

	@RequestMapping(value = "/student_add", method = RequestMethod.GET)
	public String getStudentAdd(Model model) {
        model.addAttribute("studentAttribute", new Student());
        return "student_add";
	}

	@RequestMapping(value = "/student_add", method = RequestMethod.POST)
	public String getStudentAdd(@ModelAttribute("studentAttribute") Student student, Model model) {
        try {
			dao.storeStudent(student);
		} catch (HibernateException e) {
			return "error";
		}
        return "redirect:students";
	}

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String getStudent(@RequestParam(value="id", required=true) Integer id,
        @RequestParam(value="week_id", required=false) Integer week_id, Model model) {
        if (week_id == null) {
            week_id = 0;
        }
        try {
            Student student = dao.loadStudent(id);
            model.addAttribute("student", student);
            List<Lesson> lessons = dao.getLessonsByStudent(id, week_id);
            model.addAttribute("lessons", lessons);
            model.addAttribute("week_id", week_id);
        } catch (HibernateException e) {
			return "error";
		}
		return "student";
    }

    @RequestMapping(value = "/student_del", method = RequestMethod.GET)
    public String delStudent(@RequestParam(value="id", required=true) Integer id, Model model) {
        try {
            Student student = dao.loadStudent(id);
            dao.deleteStudent(student);
        } catch (HibernateException e) {
			return "error";
		}
		return "redirect:students";
    }

	@RequestMapping(value = "/teachers", method = RequestMethod.GET)
	public String getTeachers(Model model) {
        try {
			List<Teacher> teachers = dao.getAllTeachers();
			model.addAttribute("teachers", teachers);
		} catch (HibernateException e) {
			return "error";
		}
		return "teachers";
	}

	@RequestMapping(value = "/teacher_add", method = RequestMethod.GET)
	public String getTeacherAdd(Model model) {
        model.addAttribute("teacherAttribute", new Teacher());
        return "teacher_add";
	}

	@RequestMapping(value = "/teacher_add", method = RequestMethod.POST)
	public String getTeacherAdd(@ModelAttribute("teacherAttribute") Teacher teacher, Model model) {
        try {
			dao.storeTeacher(teacher);
		} catch (HibernateException e) {
			return "error";
		}
        return "redirect:teachers";
	}

	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public String getTeacher(@RequestParam(value="id", required=true) Integer id,
        @RequestParam(value="week_id", required=false) Integer week_id, Model model) {
        if (week_id == null) {
            week_id = 0;
        }
        try {
            Teacher teacher = dao.loadTeacher(id);
            model.addAttribute("teacher", teacher);
            List<Lesson> lessons = dao.getLessonsByTeacher(id, week_id);
            model.addAttribute("lessons", lessons);
            model.addAttribute("week_id", week_id);
        } catch (HibernateException e) {
			return "error";
		}
		return "teacher";
    }

    @RequestMapping(value = "/teacher_del", method = RequestMethod.GET)
    public String delTeacher(@RequestParam(value="id", required=true) Integer id, Model model) {
        try {
            Teacher teacher = dao.loadTeacher(id);
            dao.deleteTeacher(teacher);
        } catch (HibernateException e) {
			return "error";
		}
		return "redirect:teachers";
    }

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
	public String getCompanies(Model model) {
        try {
			List<Company> companies = dao.getAllCompanies();
			model.addAttribute("companies", companies);
		} catch (HibernateException e) {
			return "error";
		}
		return "companies";
	}

	@RequestMapping(value = "/company_add", method = RequestMethod.GET)
	public String getCompanyAdd(Model model) {
        model.addAttribute("companyAttribute", new Company());
        return "company_add";
	}

	@RequestMapping(value = "/company_add", method = RequestMethod.POST)
	public String getCompanyAdd(@ModelAttribute("companyAttribute") Company company, Model model) {
        try {
			dao.storeCompany(company);
		} catch (HibernateException e) {
			return "error";
		}
        return "redirect:companies";
	}

	@RequestMapping(value = "/company", method = RequestMethod.GET)
    public String getCompany(@RequestParam(value="id", required=true) Integer id, Model model) {
        try {
            Company company = dao.loadCompany(id);
            model.addAttribute("company", company);
            List<Course> courses = dao.getCoursesByCompany(id);
			model.addAttribute("courses", courses);
        } catch (HibernateException e) {
			return "error";
		}
		return "company";
    }

    @RequestMapping(value = "/company_del", method = RequestMethod.GET)
    public String delCompany(@RequestParam(value="id", required=true) Integer id, Model model) {
        try {
            Company company = dao.loadCompany(id);
            dao.deleteCompany(company);
        } catch (HibernateException e) {
			return "error";
		}
		return "redirect:companies";
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
	public String getCourses(Model model) {
        try {
			List<Course> courses = dao.getAllCourses();
			model.addAttribute("courses", courses);
		} catch (HibernateException e) {
			return "error";
		}
		return "courses";
	}

	@RequestMapping(value = "/course_add", method = RequestMethod.GET)
    public String addCourse(@RequestParam(value="id", required=true) Integer id, Model model) {
        model.addAttribute("courseAttribute", new Course());
        try {
            Company company = dao.loadCompany(id);
            model.addAttribute("company", company);
        } catch (HibernateException e) {
			return "error";
		}
		return "course_add";
    }

    @RequestMapping(value = "/course_add", method = RequestMethod.POST)
	public String addCourse(@ModelAttribute("courseAttribute") Course course, Model model) {
        Integer companyId = null;
        try {
            companyId = course.getCompanyId();
			dao.storeCourse(course);
		} catch (HibernateException e) {
			return "error";
		}
		if (companyId == null) {
            return "error";
		}
        return "redirect:company?id=" + companyId.toString();
	}

	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public String getCourse(@RequestParam(value="id", required=true) Integer id, Model model) {
        try {
            Course course = dao.loadCourse(id);
            model.addAttribute("course", course);
            Company company = dao.loadCompany(course.getCompanyId());
            model.addAttribute("company", company);
            List<Student> students = dao.getStudentByCourse(id);
            List<Teacher> teachers = dao.getTeacherByCourse(id);
            List<Lesson> lessons = dao.getLessonsByCourse(id);
            model.addAttribute("students", students);
            model.addAttribute("teachers", teachers);
            model.addAttribute("lessons", lessons);
        } catch (HibernateException e) {
			return "error";
		}
		return "course";
	}

	@RequestMapping(value = "/course_del", method = RequestMethod.GET)
	public String delCourse(@RequestParam(value="id", required=true) Integer id, Model model) {
        try {
            Course course = dao.loadCourse(id);
            dao.deleteCourse(course);
        } catch (HibernateException e) {
			return "error";
		}
		return "redirect:courses";
	}

	@RequestMapping(value = "/student_course_del", method = RequestMethod.GET)
    public String delCourse(@RequestParam(value="course_id", required=true) Integer courseId,
        @RequestParam(value="student_id", required=true) Integer studentId, Model model) {
        try {
            List<StudentCourse> links = dao.getAllStudentCourses();
            for (StudentCourse link : links) {
                if ((link.getStudentId() == studentId) &&
                    (link.getCourseId() == courseId)) {
                    dao.deleteStudentCourse(link);
                    break;
                }
            }
        } catch (HibernateException e) {
			return "error";
		}
        return "redirect:course?id=" + courseId.toString();
    }

    @RequestMapping(value = "/student_course_add", method = RequestMethod.GET)
    public String getStudentCourseAdd(@RequestParam(value="id", required=true) Integer id, Model model) {
        try {
            Course course = dao.loadCourse(id);
            List<Student> students = dao.getAllStudents();
            model.addAttribute("course", course);
            model.addAttribute("students", students);
        } catch (HibernateException e) {
			return "error";
		}
        return "student_course_add";
    }

    @RequestMapping(value = "/student_course_add_post", method = RequestMethod.GET)
    public String getStudentCourseAddPost(@RequestParam(value="course_id", required=true) Integer courseId,
        @RequestParam(value="student_id", required=true) Integer studentId, Model model) {
        try {
            List<StudentCourse> links = dao.getAllStudentCourses();
            for (StudentCourse link : links) {
                if ((link.getStudentId() == studentId) &&
                    (link.getCourseId() == courseId)) {
                    return "redirect:course?id=" + courseId;
                }
            }
            StudentCourse link = new StudentCourse();
            link.setStudentId(studentId);
            link.setCourseId(courseId);
            dao.storeStudentCourse(link);
        } catch (HibernateException e) {
			return "error";
		}
        return "redirect:course?id=" + courseId;
    }

    @RequestMapping(value = "/lesson_del", method = RequestMethod.GET)
	public String delLesson(@RequestParam(value="id", required=true) Integer id, Model model) {
        Integer courseId = null;
        try {
            Lesson lesson = dao.loadLesson(id);
            courseId = lesson.getCourseId();
            dao.deleteLesson(lesson);
        } catch (HibernateException e) {
			return "error";
		}
		if (courseId == null) {
            return "error";
		}
		return "redirect:course?id=" + courseId.toString();
	}

	@RequestMapping(value = "/lesson", method = RequestMethod.GET)
	public String getLesson(@RequestParam(value="id", required=true) Integer id, Model model) {
        try {
            Lesson lesson = dao.loadLesson(id);
            Course course = dao.loadCourse(lesson.getCourseId());
            Company company = dao.loadCompany(course.getCompanyId());
            Teacher teacher = dao.loadTeacher(lesson.getTeacherId());
            model.addAttribute("lesson", lesson);
            model.addAttribute("course", course);
            model.addAttribute("company", company);
            model.addAttribute("teacher", teacher);
        } catch (HibernateException e) {
			return "error";
		}
		return "lesson";
	}

	@RequestMapping(value = "/lesson_add", method = RequestMethod.GET)
	public String getLessonAdd(@RequestParam(value="course_id", required=true) Integer course_id, Model model) {
        try {
            Course course = dao.loadCourse(course_id);
            List<Teacher> teachers = dao.getAllTeachers();
            model.addAttribute("course", course);
            model.addAttribute("teachers", teachers);
            model.addAttribute("lessonAttribute", new LessonWrap());
        } catch (HibernateException e) {
            return "error";
        }
        return "lesson_add";
	}

    @RequestMapping(value = "/lesson_add", method = RequestMethod.POST)
	public String getLessonAdd(@ModelAttribute("lessonAttribute") LessonWrap lesson_w, Model model) {
        Integer courseId = null;
        try {
            courseId = lesson_w.getCourseId();
			dao.storeLesson(lesson_w.toLesson());
		} catch (HibernateException e) {
			return "error";
		} catch (ParseException e) {
			return "error";
		}
		if (courseId == null) {
            return "error";
		}
        return "redirect:course?id=" + courseId.toString();
	}

}
