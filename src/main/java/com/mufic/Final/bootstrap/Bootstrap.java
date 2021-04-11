package com.mufic.Final.bootstrap;

import com.mufic.Final.api.v2.model.*;
import com.mufic.Final.api.v2.model.lists.*;
import com.mufic.Final.domain.*;
import com.mufic.Final.repositories.*;
import com.mufic.Final.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;


@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired private CityRepository cityRepository;
    @Autowired private StateRepository stateRepository;
    @Autowired private CountryRepository countryRepository;
    @Autowired private ProgramRepository programRepository;
    @Autowired private TermRepository termRepository;
    @Autowired private ProgramLevelRepository programLevelRepository;
    @Autowired private PointSystemRepository pointSystemRepository;
    @Autowired private PrivilegeRepository privilegeRepository;
    @Autowired private RegularTermRuleRepository regularTermRuleRepository;
    @Autowired private SummerTermRulesRepository summerTermRulesRepository;
    @Autowired private DepartmentService departmentService;
    @Autowired private StudentInfoService studentInfoService;
    @Autowired private StudentService studentService;
    @Autowired private CourseService courseService;
    @Autowired private RoleRepository roleRepository;
    @Autowired private UserService userService;
    @Autowired private TeachingStaffService teachingStaffService;
    @Autowired private CourseInTermService courseInTermService;
    @Autowired private LabService labService;
    @Autowired private PasswordEncoder encoder;



    private List<Country> countries() {
        List<Country> countries = new ArrayList<>();
        Country country = Country.builder().id(65L).name("Egypt").iso3("EGY").iso2("EG").phoneCode("20").capital("Cairo")
                .currency("EGP").nativ("مصر").emoji("??").emojiU("U+1F1EA U+1F1EC").wikiDataId("Q79").build();
        countries.add(country);
        return countries;
    }

    private List<State> states() {
        List<State> states = new ArrayList<>();
        states.add(State.builder().id(3222L).name("Kafr el-Sheikh Governorate").country(countryRepository.findById((long) 65).orElse(null)).countryCode("EG").build());
        states.add(State.builder().id(3223L).name("Cairo Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3224L).name("Damietta Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3225L).name("Aswan Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3226L).name("Sohag Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3227L).name("North Sinai Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3228L).name("Monufia Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3229L).name("Port Said Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3230L).name("Beni Suef Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3231L).name("Matrouh Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3232L).name("Qalyubia Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3233L).name("Suez Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3234L).name("Gharbia Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3235L).name("Alexandria Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3236L).name("Asyut Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3237L).name("South Sinai Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3238L).name("Faiyum Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3239L).name("Giza Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3240L).name("Red Sea Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3241L).name("Beheira Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3242L).name("Luxor Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3243L).name("Minya Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3244L).name("Ismailia Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3245L).name("Dakahlia Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3246L).name("New Valley Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        states.add(State.builder().id(3247L).name("Qena Governorate").country(countryRepository.getOne(65L)).countryCode("EG").build());
        return states;
    }

    private List<City> cities() {
        List<City> cities = new ArrayList<>();
        cities.add(City.builder().id(31755L).name("Abnūb").state(stateRepository.getOne(3236L)).stateCode("AST")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q975904").build());
        cities.add(City.builder().id(31756L).name("Abu Simbel").state(stateRepository.getOne(3225L)).stateCode("ASN")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31757L).name("Abū Qurqāş").state(stateRepository.getOne(3243L)).stateCode("MN")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31758L).name("Abū Tīj").state(stateRepository.getOne(3236L)).stateCode("AST")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31759L).name("Abū al Maţāmīr").state(stateRepository.getOne(3241L)).stateCode("BH")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31760L).name("Ad Dilinjāt").state(stateRepository.getOne(3241L)).stateCode("BH")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31761L).name("Ain Sukhna").state(stateRepository.getOne(3233L)).stateCode("SUZ")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31762L).name("Ajā").state(stateRepository.getOne(3245L)).stateCode("DK")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31763L).name("Akhmīm").state(stateRepository.getOne(3226L)).stateCode("SHG")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31764L).name("Al Badārī").state(stateRepository.getOne(3236L)).stateCode("AST")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31765L).name("Al Balyanā").state(stateRepository.getOne(3226L)).stateCode("SHG")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31766L).name("Al Bawīţī").state(stateRepository.getOne(3239L)).stateCode("GZ")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31767L).name("Al Bājūr").state(stateRepository.getOne(3228L)).stateCode("MNF")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31768L).name("Al Fashn").state(stateRepository.getOne(3230L)).stateCode("BNS")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31769L).name("Al Fayyūm").state(stateRepository.getOne(3238L)).stateCode("FYM")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31770L).name("Al Jammālīyah").state(stateRepository.getOne(3245L)).stateCode("DK")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31771L).name("Al Khānkah").state(stateRepository.getOne(3232L)).stateCode("KB")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31772L).name("Al Khārijah").state(stateRepository.getOne(3246L)).stateCode("WAD")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31773L).name("Al Manshāh").state(stateRepository.getOne(3226L)).stateCode("SHG")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31774L).name("Al Manzalah").state(stateRepository.getOne(3245L)).stateCode("DK")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());
        cities.add(City.builder().id(31775L).name("Al Manşūrah").state(stateRepository.getOne(3245L)).stateCode("DK")
                .country(countryRepository.getOne(65L)).countryCode("EG").latitude(27.26960000).longitude(31.15105000).wikiDataId("Q6655437").build());

        return cities;
    }

    CourseListDTO courseListDTO() {
        CourseListDTO courseListDTO = new CourseListDTO(new ArrayList<>());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BCS111").nameArabic("أساسیات علوم الحاسب").nameEnglish("Fundamentals of Computer Science").hours(3)
                .lecHours(2.50).labHours(1).description("").program(8L).force(1).preCourse("").build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BCS112").nameArabic("برمجة – ١").nameEnglish("Programming-1").hours(3)
                .lecHours(2.5).labHours(1).description("").program(8L).force(1).preCourse("").build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BCS213").nameArabic("برمجة – ٢").nameEnglish("Programming-2").hours(3)
                .lecHours(2.50).labHours(1).description("").program(8L).preCourse("BCS112").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BCS214").nameArabic("ھیاكل بیانات").nameEnglish("Data structures").hours(3)
                .lecHours(2.5).labHours(1).description("").program(8L).force(1).preCourse("").build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIT111").nameArabic("دوائر كھربائیة").nameEnglish("Electrical Circuits").hours(3)
                .lecHours(3).labHours(3).description("Basic ideas; Electrostatics; Columb`s law; Gauss law; Potential; Capacitors; Electric \n" +
                        "current; Resistors; Kirchhoff,s law; Magnetic field and forces; Induction and inductors; \n" +
                        "Basic circuit theory and circuit analysis; Fundamentals of three phase circuits and \n" +
                        "transformers.").program(7L).preCourse("").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BCS221").nameArabic("تصمیم منطقي").nameEnglish("Logic Design").hours(3)
                .lecHours(2.5).labHours(1).description("").program(7L).preCourse("BIT111").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BCS241").nameArabic("نظم التشغیل").nameEnglish("Operating Systems").hours(3)
                .lecHours(2.5).labHours(1).description("").program(8L).force(1).preCourse("").build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BCS251").nameArabic("هندسة البرمجيات").nameEnglish("Software Engineering").hours(3)
                .lecHours(2.5).labHours(1).description("This course presents a broad perspective of software engineering, focusing on the processes and techniques fundamental to the creation of reliable, software systems. It also presents the agile methods and software reuse, along with coverage of traditional plan-driven software engineering. The course is organized into major parts that include: Process Modeling Quality Management Project Management and Advanced Topics.").program(8L).preCourse("BCS213").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BCS316").nameArabic("تحلیل وتصمیم الخوارزمیات").nameEnglish("Algorithms Analysis and Design").hours(3)
                .lecHours(3).labHours(3).description("Algorithm concept: Analysis and complexity. Design methods, divide and conquer,binary search, merge sort, quick sort, selection, matrix multiplication, the greedy method. Dynamic programming: shortest paths, optimal search trees. Graph algorithms.Backtracking.NP-hard and NP-complete problems. Tries. Suffix Trees. Orders and Asymptotic analysis. Recurrence relations.").program(8L).preCourse("BCS214").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BCS322").nameArabic("عمارة الحاسبات").nameEnglish("Computer Architecture").hours(3)
                .lecHours(3).labHours(3).description("Design of a basic computer; Design concepts of Processors; Design of channels and controllers; Interconnections; Memory structures and design; Memory management;Cache memory systems; Firmware design; Reliability; Testing and fault tolerance; CISC computers; RISC computers; Computer interfacing; Design of network interface cards; Examples of computer architecture.").program(8L).preCourse("BCS221").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BMA112").nameArabic("تراكیب محددة").nameEnglish("Discrete Mathematics").hours(3)
                .lecHours(3).labHours(3).description("Introduces the foundations of discrete mathematics as they apply to computer science, \n" +
                        "focusing on providing a solid theoretical foundation for further work. Topics include \n" +
                        "functions, relations, sets, simple proof techniques, Boolean algebra, propositional logic, \n" +
                        "digital logic, elementary number theory, and the fundamentals of counting.").program(7L).preCourse("").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BCS323").nameArabic("نظریة الحاسبات").nameEnglish("Theory of computations").hours(3)
                .lecHours(3).labHours(3).description("Provide students with understanding of the foundations of theory of computation,including non-regular languages, multi-tape Turing machines, decidability, the haltingproblem, reducibility, incompressible strings and randomness, winning strategies for \n" +
                        "games, and complexity theory. ").program(8L).preCourse("BMA112").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BCS361").nameArabic("الذكاء الاصطناعى").nameEnglish("Artificial Intelligence").hours(3)
                .lecHours(3).labHours(3).description("This course covers the different methodologies of Knowledge Representations: \n" +
                        "Predicate Calculus, Structured Representations, and Network Representations. In \n" +
                        "addition, it introduces the State Space Search using both trees and graphs, heuristic \n" +
                        "search, model based reasoning, case-based reasoning, and reasoning with uncertain or \n" +
                        "incomplete knowledge. Moreover, this course gives an overview of AI Application \n" +
                        "Areas such as strategic planning, game planning, rule-based systems, and (fuzzy) expert \n" +
                        "systems.").program(8L).preCourse("BCS213").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BCS471").nameArabic("المعالجة على التوازى").nameEnglish("Parallel Processing").hours(3)
                .lecHours(3).labHours(3).description("Interconnection networks. Parallel computing and networks, direct and indirect \n" +
                        "networks. Parallel structure. Parallel architecture. MPI programming. Collective communication. Multiple communicator. Applications. Threads programming. Multi node clusters. GPU programming.").program(8L).preCourse("BCS322").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BCS472").nameArabic("الحوسبة عالیة الاداء").nameEnglish("High Performance Computing").hours(3)
                .lecHours(3).labHours(3).description("An in-depth study of the state of theart in high performance computing. Topics include \n" +
                        "parallel computer architectures, programming paradigms, and their applications. \n" +
                        "Parallel architectures include PC clusters, shared-memory multiprocessors, distributed\u0002memory multiprocessors, and multithreaded architectures. Parallel programming \n" +
                        "paradigms include message passing interface (MPI), its second generation MPI-2, and \n" +
                        "multithreaded programming. Applications include computational science and high \n" +
                        "performance Web and database servers for Internet-based electronic commerce and \n" +
                        "Bioinformatics. Map reduce computation. Cloud computing.").program(8L).preCourse("BCS471").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BCS495").nameArabic("موضوعات مختارة فى علوم الحاسب-1").nameEnglish("Selected Topics in Computer Science-1").hours(3)
                .lecHours(3).labHours(3).description("").program(8L).preCourse("").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BCS496").nameArabic("موضوعات مختارة فى علوم الحاسب-2").nameEnglish("Selected Topics in Computer Science-2").hours(3)
                .lecHours(3).labHours(3).description("").program(8L).preCourse("").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BDS121").nameArabic("مبادئ الاقتصاد").nameEnglish("Fundamentals of Economics").hours(3)
                .lecHours(3).labHours(3).description("Concept of economics - the economic problem. Theory of demand including: utility \n" +
                        "theory, theory of production, theory of cost, theory of firm including: pricing theory - \n" +
                        "Economics of education - Economics of science and technology - Economics of \n" +
                        "automation including: computerization.").program(6L).preCourse("").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BDS122").nameArabic("أساسيات الإدارة").nameEnglish("Fundamentals of Management").hours(3)
                .lecHours(3).labHours(3).description("History of Management, planning, fundamentals of planning, making decisions, \n" +
                        "strategic planning, plans and planning tools. Organizing and managing human \n" +
                        "resources. Influencing, leadership, controlling. Production management and control. \n" +
                        "Quality management. Management of service industries, accounting for risk, and \n" +
                        "economic analysis.").program(6L).preCourse("").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BDS123").nameArabic("تسویق ومبیعات").nameEnglish("Marketing & Sales").hours(3)
                .lecHours(3).labHours(3).description("Define marketing; Marketing process; Market analysis: customer base; competition; \n" +
                        "Best practices and lessons learned; Business research and forecasting tools and \n" +
                        "techniques; Trend analysis: economics; social; political; environmental; technology; \n" +
                        "Technology assessment practices and techniques; Presentation skills; Sales and \n" +
                        "advertising practices; Customer satisfaction strategies; Marketing and branding \n" +
                        "techniques; Product portfolio analysis; Global trade and international operations; \n" +
                        "Pricing strategies. Managing marketing through: customer relationships; social \n" +
                        "responsibility; marketing ethics. It emphasizes E-Commerce Application and \n" +
                        "Implementation through Business Models and Technology Essentials.").program(6L).preCourse("").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BDS211").nameArabic("مقدمھ فى نظم دعم القرار").nameEnglish("Introduction to Decision Support Systems").hours(3)
                .lecHours(3).labHours(3).description("Approaches and techniques to construct and implement an effective computer-based \n" +
                        "Decision Support Systems (DSS). Alternative software development tools or generators \n" +
                        "of a DSS. The role of computational tools (simulation, optimization, statistical and other \n" +
                        "quantitative models) and computer information systems (MIS, AI and ES) to support \n" +
                        "and enhance the capability of the DSS. Discussion and analysis of real life case studies \n" +
                        "of integrated DSS is stressed throughout the course.").program(8L).preCourse("BCS111").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BHU111").nameArabic("كتابة التقارير الفنية").nameEnglish("Technical Report Writing").hours(3)
                .lecHours(3).labHours(3).description("The basic rudiments of report writing; The rationale for report writing; the structure of \n" +
                        "reports; and such details as physical appearance and linguistic style; In addition to \n" +
                        "writing reports; student will also be given supplementary exercises as well as applied \n" +
                        "project to enhance their general writing skills.").program(5L).preCourse("").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BHU112").nameArabic("مهارات العرض و الإتصال").nameEnglish("Communication &  Presentation Skills").hours(3)
                .lecHours(3).labHours(3).description("Theories of communication – How to translate theories into complete strategies to \n" +
                        "communicate with diverse audience – Written Communications: Memoranda, Letters, \n" +
                        "Executive summaries, Business and research reports – Oral Communications: \n" +
                        "Listening, Presentation skills, Interviewing, Conducting meetings, Interpersonal \n" +
                        "communication – Negotiation – Intercultural communication – Importance of \n" +
                        "communication in team building.").program(6L).preCourse("").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BHU113").nameArabic("التفكير الابداعي").nameEnglish("Creative Thinking").hours(3)
                .lecHours(3).labHours(3).description("Creative thinking allows for going beyond our normal conditioned modes of thinking \n" +
                        "generating new approaches to problem solving, to see the world from varying \n" +
                        "perspectives, and to create what we desire for ourselves and our various communities. \n" +
                        "Applications to be covered will include, among others, communication, problem \n" +
                        "solving and decision making. This is an opportunity for students to learn how others \n" +
                        "think differently from themselves, to understand meta-cognition (thinking about \n" +
                        "thinking). The course includes Edwarddo Bono's CoRT (cognitive research trust) \n" +
                        "program of learning thinking, Vertical and lateral thinking approaches and Creative \n" +
                        "thinking tools like Brainstorming, Tony Buzan's Mind mapping and Edward do Bono's \n" +
                        "Six Thinking hats.").program(6L).preCourse("").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BHU114").nameArabic("أساسیات علم النفس").nameEnglish("Fundamentals of Psychology").hours(3)
                .lecHours(3).labHours(3).description("Research methods; social and emotional development; neurobiological foundations of \n" +
                        "behavior; learning; memory; personality; stress and its effect on well-being; abnormal \n" +
                        "behavior and pathology, and social psychology; Abnormal behavior . It also introduces \n" +
                        "the general principles of psychology as they are applied to work, relationships, and self. \n" +
                        "Includes perception, learning, development, motivation, emotion, therapy, \n" +
                        "communication, attitudes.").program(6L).preCourse("").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BHU115").nameArabic("أساسیات علم الاجتماع").nameEnglish("Fundamentals of Sociology").hours(3)
                .lecHours(3).labHours(3).description("Basic concepts – Basic examination of major theoretical perspectives, Structural \n" +
                        "functionalism, Symbolic interactionism, conflict theory – Types of Society: Tribal, \n" +
                        "agrarian, industrial, Post-industrial – Culture – Social networks – Social institutions – \n" +
                        "Deviance – Education – Religion – Race and ethnicity – Social class – Socialization – \n" +
                        "Gender identity – Social construction of the family – Community – Health – Social \n" +
                        "processes – Social change – Social Problems – Social demography.").program(6L).preCourse("").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BHU116").nameArabic("سیاسات مقارنة").nameEnglish("Comparative politics").hours(3)
                .lecHours(3).labHours(3).description("Central concepts and methods in comparative studies – Political development and \n" +
                        "democratization – revolution – political culture – Comparison of different countries \n" +
                        "with respect to the founding principles of: Political system – Electoral system – Parities \n" +
                        "– Interest organizations – Parliament – Government – Public administration – Policy \n" +
                        "processes – Political economy. Internationalization").program(6L).preCourse("").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BHU117").nameArabic("أساسیات علم البيئه").nameEnglish("Fundamentals of Environment ").hours(3)
                .lecHours(3).labHours(3).description("Studying the Earth; The Dynamic Earth; The Composition of the Earth; Oceans; \n" +
                        "Atmospheric forces; Astronomy; Change in the biosphere; Ecological Interactions; \n" +
                        "Biomes; People in the Global Ecosystem; Energy resources; Land & Water resources; \n" +
                        "Managing human impact.").program(6L).preCourse("").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BHU118").nameArabic("دراسات اجتماعیة و انسانیة").nameEnglish("Social & Human Studies").hours(3)
                .lecHours(3).labHours(3).description("The aim of the course is: 1) Permit students to meet specific requirements by \n" +
                        "encouraging them to choose from a broad variety of social and human studies. 2) Learn \n" +
                        "to utilise theoretical discussions and debate in order to strengthen the professional \n" +
                        "expertise of a certain special theme and/or to enhance the skill to thematise broader and \n" +
                        "intertwined cultural and societal issues within and around any field. 3) Foster an \n" +
                        "appreciation for the humanities.").program(6L).preCourse("").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BHU131").nameArabic("حقوق الإنسان").nameEnglish("Human rights").hours(3)
                .lecHours(3).labHours(3).description("Definition of human rights – historical development of the concept of human rights – \n" +
                        "culture relativism versus universally accepted human rights standards – various human \n" +
                        "rights: personal, political, civil, social, economical,…etc. – covering human rights \n" +
                        "within official international organizations – influence of business and global economic \n" +
                        "restructuring on human rights – monitoring human rights – human rights violations.").program(5L).preCourse("").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BHU165").nameArabic("موضوعات مختارة").nameEnglish("Selected Topics").hours(3)
                .lecHours(3).labHours(3).description("Topics which are not included in the curriculum and seems to be needed should be \n" +
                        "suggested as an elective course by CS department.").program(6L).preCourse("").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIO001").nameArabic("تأھیلي علم الأحیاء").nameEnglish("Biology-0").hours(3)
                .lecHours(3).labHours(3).description("").program(1L).preCourse("").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIO251").nameArabic("علم الاحیاء-١").nameEnglish("Biology-1").hours(3)
                .lecHours(3).labHours(3).description("This course should cover the basics of the biological science. It introduces the Tree of \n" +
                        "Life. It then covers the cell structure and function, the cell division. Moreover, Genetics \n" +
                        "are covered including the DNA, the Gene Expression, the Central Dogma of molecular \n" +
                        "biology including the Transcription and Translation processes. Also, the course \n" +
                        "highlights the different Genome Sequencing techniques. The Evolutionary Process is \n" +
                        "also explained.").program(9L).preCourse("").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIO252").nameArabic("علم الاحیاء-2").nameEnglish("Biology-2").hours(3)
                .lecHours(3).labHours(3).description("This course focuses on the basic principles of biochemistry, genetics, molecular \n" +
                        "biology, and recombinant DNA technologies. The material presented introduces \n" +
                        "modern biology at the molecular level: the structure and function of biological \n" +
                        "macromolecules, the basics of cellular metabolism, meiosis and inheritance, DNA \n" +
                        "replication, the basics of gene expression, and general recombinant DNA techniques.").program(9L).preCourse("BIO251").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIO261").nameArabic("الكيمياء العضويه-1").nameEnglish("Organic Chemistry-1").hours(3)
                .lecHours(3).labHours(3).description("This course will begin with a basic review of some of the important concepts \n" +
                        "established in inorganic chemistry. The chemistry of carbon compounds will be \n" +
                        "distinguished from inorganic chemistry. Fundamental concepts of the various classes \n" +
                        "of aliphatic and aromatic compounds will be examined. Fundamental concepts of \n" +
                        "hydrophobicity and hydrophilicity will be studied. Basic concepts of Biochemical and \n" +
                        "physiological analogies will be evident.").program(9L).preCourse("").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIO262").nameArabic("الكیمیاء العضویة-2").nameEnglish("Organic Chemistry-2").hours(3)
                .lecHours(3).labHours(3).description("This course introduces functional groups with emphasis on alcohols, phenols, ethers, \n" +
                        "aldehydes, ketones, amides, esters, amines, and carboxylic acids. Once the nature and \n" +
                        "reactivity of these functional groups is understood, the more important biological \n" +
                        "examples will covered. Biochemistry, particularly the properties and metabolism of \n" +
                        "biological macromolecules such as nucleic acids, lipids, and proteins will be \n" +
                        "introduced.").program(9L).preCourse("BIO261").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIO352").nameArabic("علم الاحیاء الجزیئیة والخلویة").nameEnglish("Molecular & Cell Biology").hours(3)
                .lecHours(3).labHours(3).description("Basics of the structure and function of cells and cell organelles, cell growth and \n" +
                        "division, motility, cell differentiation and specialization. Molecular basis of biological \n" +
                        "processes, emphasizing gene action in context of entire genome. Chromosomes and \n" +
                        "DNA metabolism: chromatin, DNA replication, repair, mutation, recombination, \n" +
                        "transposition. Transcription, protein synthesis, regulation of gene activity. Procaryotes \n" +
                        "and eucaryotes.").program(9L).preCourse("BIO252").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIO353").nameArabic("").nameEnglish("").hours(3)
                .lecHours(3).labHours(3).description("An introduction to the principles of heredity in diploid organisms, fungi, bacteria, and \n" +
                        "viruses. Mendelian inheritance; population genetics; quantitative genetics; linkage; sex \n" +
                        "determination; meiotic behavior of chromosome aberrations, gene structure, regulation, \n" +
                        "and replication; genetic code. Emphasis is on molecular genetics.").program(9L).preCourse("BIO252").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIO451").nameArabic("علم الوراثة").nameEnglish("Genetics").hours(3)
                .lecHours(3).labHours(3).description("Neural network concepts: Basic definition, connections, processing elements. Feed\u0002forward neural networks (non-recurrent neural networks). Back-propagation Learning\u0002Algorithm. Delta Rule. Scaling and Biases. Performance Issues. Associative memories. \n" +
                        "Heteroassociative, autoassociative and interpolative memories. Bi-directional \n" +
                        "associative memories. Counter propagation neural networks. Extreme Learning \n" +
                        "Machines. Support Vector Machines and Kernels. Kernel definition. Applications in \n" +
                        "Bioinformatics.").program(9L).preCourse("BIO252").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BMA111").nameArabic("ریاضة -١").nameEnglish("Math-1").hours(3)
                .lecHours(3).labHours(3).description("Sets, Venn Diagrams, Set Memberships of tables, Laws of set Theory, Partitions of \n" +
                        "sets, Power sets, Propositions and logical operations, Truth tables, Equivalence, \n" +
                        "Implications, Laws of Logic, Mathematical Induction and Quantifiers, Relations, paths \n" +
                        "and diagraphs, properties and types of binary relations, Manipulation of relations, \n" +
                        "closures, Warshall's algorithm, Equivalence and Partial Ordered relations, Posets and \n" +
                        "Hasse diagram, Lattice, Monoids, Semigroups and groups, Product and Quotients of \n" +
                        "algebraic structures, Isomorphism, Homomorphism, automorphism, Normal \n" +
                        "Subgroups, Codes and group codes, Rings, integral Domains and fields, Ring \n" +
                        "Homomorphism, algorithms, induction and recursion ; relations and functions ; Graphs \n" +
                        ", lattices, number systems and codes , Boolean algebra.").program(7L).preCourse("").force(1).build());

        courseListDTO.getCourses().add(CourseDTO.builder().code("BMA113").nameArabic("ریاضة -٢").nameEnglish("Math-2").hours(3)
                .lecHours(3).labHours(3).description("Numbers and Expressions, Linear equations and inequalities, Absolute value equations \n" +
                        "and equalities, Functions and graphs, Piecewise functions, Graphing equations and \n" +
                        "inequalities in two variables, Solving linear systems, Linear programming, Linear \n" +
                        "transformations, , Quadratic functions, Properties of exponents, Polynomial operations \n" +
                        "– equations, Rational roots, Fundamental Theorem of Algebra, Determinants and \n" +
                        "Cramer's Rule, Matrix operations Identity and inverse matrices, Symmetric matrices \n" +
                        "and quadratic forms, Positive matrices, Using matrices to solve systems, Eigen values \n" +
                        "and Eigen functions.").program(7L).preCourse("BMA111").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BMA214").nameArabic("ریاضة-٣").nameEnglish("Math-3").hours(3)
                .lecHours(3).labHours(3).description("Limits, Limits at infinity, Continuity, Rates of Change and Tangent Lines, Introduction \n" +
                        "to Derivatives, Differentiation Techniques - products, quotients and chain rules. \n" +
                        "Differentiability versus continuity, Higher Order Derivatives, Velocity and \n" +
                        "acceleration, Implicit differentiation, Derivatives of Trig Functions, Derivatives of \n" +
                        "Inverses, Derivatives of Inverse Trig Functions, Derivatives of Exponential and Log \n" +
                        "Functions, Extreme values of functions, Graphing, Extreme value problems (word \n" +
                        "problems), Mean Value Theorem, Related Rates, Linearization and Newton's Method, \n" +
                        "L'Hôspital's Rule, Definite Integrals, Estimating with rectangles, Trapezoidal Rule, \n" +
                        "Simpson's Rule, Ant derivatives, The Fundamental Theorems of Calculus.").program(7L).preCourse("BMA113").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIO452").nameArabic("لخوارزمیات الجینیة").nameEnglish("Genetic Algorithms").hours(3)
                .lecHours(3).labHours(3).description("Canonical Genetic Algorithm. Basic operators. Selection, Crossover and Mutation. \n" +
                        "Fitness functions. Replacement strategies. Floating point representations. Uniform and \n" +
                        "non-uniform mutations. Function optimization. Schema theory. Genetic programming. \n" +
                        "Tree representations. Applications. Fuzzy logic. Fuzzy rule-based systems. Evolution \n" +
                        "of fuzzy systems. Genetic learning of neural networks. Feature selection. Clustering \n" +
                        "using genetic algorithms. Evolution Strategies. Applications in Bioinformatics.").program(9L).preCourse("BMA214").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIO454").nameArabic("حسابات حیویة").nameEnglish("Bio-computing").hours(3)
                .lecHours(3).labHours(3).description("This course provides an introduction to the features of biological data, how that data \n" +
                        "are organized efficiently in databases, and how existing data resources can be utilized \n" +
                        "to solve a variety of biological problems. Relational databases, object oriented \n" +
                        "databases, ontologies, data modeling and description, survey of current biological \n" +
                        "databases with respect to above, implementation of a database focused on a biological \n" +
                        "topic. Biopython and Bioperl and R programming.").program(9L).preCourse("BIO252").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIO455").nameArabic("لمعلوماتیة الحیویة").nameEnglish("Bioinformatics").hours(3)
                .lecHours(3).labHours(3).description(" course will provide an overview of bioinformatics, the application of \n" +
                        "computational methods to analyse the rapidly expanding amount of biological \n" +
                        "information. Following the natural flow of this information in the cell, the course will \n" +
                        "begin with the analysis of gene sequences and progress to the study of protein \n" +
                        "structures. The classic dynamic programming method of sequence alignment will be \n" +
                        "presented first, and then it will be shown how this can be extended to allow rapid \n" +
                        "searching and scoring of the thousands of sequences in a genome. This will naturally \n" +
                        "lead to the question of how large amounts of biological information can be intelligently \n" +
                        "organized into a database. Discussion of sequence-structure relationships will form the \n" +
                        "bridge to protein structure. Particular emphasis will be placed here on statistically based \n" +
                        "\"predictions\" of secondary structure. For the analysis of 3D structures, mathematical \n" +
                        "constructions, such as Voronoipolyhedra, will be presented for calculating simple \n" +
                        "geometric quantities, such as distances, angles, axes, areas, and volumes. Finally, it will \n" +
                        "be shown how these simple quantities can be related to the basic properties of proteins \n" +
                        "and this will naturally lead to a brief overview of the more physical calculations that \n" +
                        "are possible on protein structures, namely molecular dynamics and Monte Carlo \n" +
                        "simulation. Microarray analysis. Clustering and Trees.").program(9L).preCourse("BIO252").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIO461").nameArabic("الفیزیاء الحیویة").nameEnglish("Biophysics").hours(3)
                .lecHours(3).labHours(3).description("The course provides a general introduction to quantitative aspects of biological \n" +
                        "processes and the underlying physical principles. Among the key topics covered in the \n" +
                        "course are the following: transport processes and rates of biochemical/biophysical \n" +
                        "reactions (including enzyme kinetics), structure and function of biological \n" +
                        "macromolecules and macromolecular assemblies, bioenergetics, protein synthesis, \n" +
                        "mechanism of inheritance, some commonly used experimental techniques in \n" +
                        "biophysics.").program(9L).preCourse("BIO252").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIO465").nameArabic("علم الجینات والبروتینات").nameEnglish("Genomics and Proteomics").hours(3)
                .lecHours(3).labHours(3).description("The course gives an overview of the fundamental concepts of the fields of genomics \n" +
                        "and proteomics. Genomics is the study of the functions and interactions of the genes in \n" +
                        "a genome whereas proteomics is defined as the study of all the proteins expressed by \n" +
                        "the genome. The genome and the proteome are intimately linked between a complex \n" +
                        "pathway of transcription and translation, which principally involves mRNA processing, \n" +
                        "protein folding and posttranslational modifications. Both genomics and proteomics \n" +
                        "incorporate areas of biotechnology, bioinformatics and biology, and utilize a multitude \n" +
                        "of methods and techniques to study gene and protein expression profiles of cells and \n" +
                        "whole biological systems.").program(9L).preCourse("BIO455").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIO466").nameArabic("المعلوماتیة الحیویة الھیكلیة").nameEnglish("Structural Bioinformatics").hours(3)
                .lecHours(3).labHours(3).description("This course introduces the practical application of structure analysis, database \n" +
                        "searching and molecular modeling techniques to study protein structure and function. \n" +
                        "The basic concepts of macromolecular structure are reviewed together with secondary \n" +
                        "structure calculation and structure-alignment approaches as well as molecular \n" +
                        "visualization software, and web-based tools. The student will gain practical knowledge \n" +
                        "in using software techniques to: handle and compare structural information, search the \n" +
                        "Protein Data Bank site, analyze protein structure and generate 3D structures on the basis \n" +
                        "of homology.").program(9L).preCourse("BIO455").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIO468").nameArabic("موضوعات مختارة فى الحوسبة الحیویة-1").nameEnglish("Selected Topics in Computational Biology-1").hours(3)
                .lecHours(3).labHours(3).description("").program(9L).preCourse("BIO252").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIO469").nameArabic("موضوعات مختارة فى الحوسبة الحیویة-2").nameEnglish("Selected Topics in Computational Biology-2").hours(3)
                .lecHours(3).labHours(3).description("").program(9L).preCourse("BIO252").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIO470").nameArabic("نظم علم الأحياء").nameEnglish("Systems Biology").hours(3)
                .lecHours(3).labHours(3).description("This course focuses mainly on the development of computational models and their \n" +
                        "applications to diverse biological systems. Because the biological sciences have \n" +
                        "become so complex that no individual can acquire complete knowledge in any given \n" +
                        "area of specialization, the education of future systems biologists must instead develop \n" +
                        "a student's ability to retrieve, reformat, merge, and analyze complex biological \n" +
                        "information. This course provides the student with the background and mastery of \n" +
                        "methods to execute standard systems biology tasks, understand the modern literature, \n" +
                        "and launch into specialized courses or projects that address biological questions using \n" +
                        "theoretical and computational means.").program(0L).preCourse("BIO252").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIO498").nameArabic("مشروع").nameEnglish("Project").hours(3)
                .lecHours(3).labHours(3).description("The project is an application of biological and computational techniques studied. The \n" +
                        "student should use biological databases in different aspects of bioinformatics for the \n" +
                        "purpose of classification, prediction, identification of genes, analysis of metabolic \n" +
                        "pathways, analysis of protein structures, design of ontologies, visualization of 3D \n" +
                        "structures, mining of data or ontologies, establishment of expert systems for analysis of \n" +
                        "diseases and cancer. An implementation of web servers is an asset.").program(11L).preCourse("BIO252").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIS211").nameArabic("نظم قواعد البيانات").nameEnglish("Database Systems").hours(3)
                .lecHours(3).labHours(3).description("The main objective of this course is to provide students with the background to design, \n" +
                        "implement, and use database management systems. Topics Include: Evolution of \n" +
                        "database management systems, Relational Data Model and Relational Algebra, \n" +
                        "Structured Query Language, Entity Relationship Modeling and Design, ERM to RM \n" +
                        "Conversion, Tables-Normalization, Forms/Reports/Menus Implementation. Upon \n" +
                        "successful completion of this course, students will have the skills to analyze business \n" +
                        "requirements and produce a viable model and implementation of a database to meet \n" +
                        "such requirements.").program(8L).preCourse("BCS214").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIS421").nameArabic("اكتشاف المعرفھ").nameEnglish("Knowledge Discovery").hours(3)
                .lecHours(3).labHours(3).description("Knowledge discovery in databases, Data mining process, Data cleaning and \n" +
                        "preparation, Mining association rules, Classification, Prediction, Clustering, Web \n" +
                        "mining, Applications of data mining, Mining advanced databases.").program(8L).preCourse("BCS213").force(0).build());

        courseListDTO.getCourses().add(CourseDTO.builder().code("BIT222").nameArabic("شبكات الحاسبات").nameEnglish("Computers Networks").hours(3)
                .lecHours(3).labHours(3).description("Definition; Objectives, Topologies; Classifications; Architecture; Standards; \n" +
                        "Applications; ISO-OSI model; Switching techniques; Flow control; Error detection and \n" +
                        "Correction; Congestion control; Routing; Internetworking; Public switched data \n" +
                        "network; ISDN and B-ISDN; Frame relay; ATM").program(8L).preCourse("BMA113").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIT416").nameArabic("الرسم بالحاسب وتصور البیانات").nameEnglish("Computer Graphics and Data Visualization").hours(3)
                .lecHours(3).labHours(3).description("Introduction to computer Graphics ; Overview of Graphics systems ; Line drawing \n" +
                        "algorithms ; Circle drawing algorithms ; Ellipse drawing algorithms ; Area filling \n" +
                        "algorithms ; polygon filling algorithms ; line clipping algorithms ; Polygon clipping \n" +
                        "algorithms; Two dimensional transformations; (translation-rotation-scaling-general \n" +
                        "transformations-composite transformations); Three dimensional object representation \n" +
                        "and projections ; three dimensional modeling and transformations(translation-rotation�scaling-sheer-reflection-composite) ; Three dimensional Viewing and Camera Model. \n" +
                        "Visible surface detection algorithms; Reflection and illumination models; Rendering \n" +
                        "algorithms for 3-D object; parametric representation of 3-D objects. Visual \n" +
                        "representation methods and techniques that increase the understanding of complex data \n" +
                        "and models. Emphasis will be placed on the identification of patterns, trends and \n" +
                        "differences from datasets across categories, space, and time. The ways that humans \n" +
                        "process and encode visual and textual information will be discussed in relation to \n" +
                        "selecting the appropriate method for the display of quantitative and qualitative data. \n" +
                        "Graphical methods for specialized data types (times series, categorical, etc.) are \n" +
                        "presented. Topics include charts, tables, 3Dgraphics, effective presentations, \n" +
                        "٣٤\n" +
                        "multimedia content, animation, and dashboard design. Examples and cases will be used \n" +
                        "from a variety of industries. Lab work will be on the visualization toolkit (VTK).").program(8L).preCourse("BCS112").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BIT441").nameArabic("معالجة الصور").nameEnglish("Image Processing").hours(3)
                .lecHours(3).labHours(3).description("Digital image Fundamentals ; Image enhancement in the spatial domain : grey level \n" +
                        "transformation ; Histogram processing ; Spatial filters ; Image enhancement in \n" +
                        "frequency domain : 2-D Fourier transform ; Other transforms ; Smoothing filters ; \n" +
                        "Sharpening filters ; Geometric transformations ; image segmentation : detection of \n" +
                        "discontinuities ; edge linking and boundary detection ; Thresholding ; Region based \n" +
                        "segmentation ; Morphological image processing : operation concepts ; some basic \n" +
                        "algorithms.").program(8L).preCourse("BIT416").force(0).build());
        //todo a
        courseListDTO.getCourses().add(CourseDTO.builder().code("BST121").nameArabic("احصاء واحتمالات-١").nameEnglish("Probability and Statistics-1").hours(3)
                .lecHours(3).labHours(3).description("Principles of discrete probability with applications to computing. Basics of descriptive \n" +
                        "statistics. Distributions, including normal (Gaussian), binomial and Poisson. Least \n" +
                        "squared concept, correlation and regression. Statistical tests most useful to software \n" +
                        "engineering: t-test, ANOVA and chi-squared. Design of experiments and testing of \n" +
                        "hypotheses. Statistical analysis of data from a variety of sources. Applications of \n" +
                        "statistics to performance analysis, reliability engineering, usability engineering, cost \n" +
                        "estimation, as well as process control evaluation.").program(7L).preCourse("BMA111").force(1).build());

        courseListDTO.getCourses().add(CourseDTO.builder().code("BST122").nameArabic("احصاء واحتمالات-٢").nameEnglish("Probability and Statistics-2").hours(3)
                .lecHours(3).labHours(3).description("Types of statistics, Population versus sample, basic terms - numerical descriptive \n" +
                        "measures for populations and samples, for ungrouped and grouped data: Measures of \n" +
                        "Central Tendency, Measures of Dispersion, And Measures of Position – sampling \n" +
                        "distribution for the sample means – sample proportions and sample variations- point \n" +
                        "and interval estimate for the means, proportions and variance – hypothesis testing – \n" +
                        "regression and correlation analysis.").program(7L).preCourse("BST121").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BLA001").nameArabic("معمل إحصاء حیوي").nameEnglish("Biostatistics Lab").hours(3)
                .lecHours(3).labHours(3).description("This lab covers basic topics in introductory statistics, including graphs, confidence \n" +
                        "intervals, hypothesis testing, comparison of means, regression, and designing \n" +
                        "experiments. It also introduces the principles behind such modern topics as likelihood, \n" +
                        "linear models, meta-analysis and computer-intensive methods. For most of the \n" +
                        "statistical techniques covered in this lab, the capabilities of one or more software \n" +
                        "packages (MINITAB, SAS, SPSS, and NCSS) may be used to perform the calculations \n" +
                        "needed for their application.").program(12L).preCourse("BST122").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BLA002").nameArabic("معمل Biopython و Biop").nameEnglish("Biopython & Bioperl Lab").hours(3)
                .lecHours(3).labHours(3).description("This lab begins with a very basic introduction that teaches the principles of Python/Perl \n" +
                        "programming languages. It then introduces the Biopython/Bioperl packages, which can \n" +
                        "be useful in solving life science problems. The lab will provide a wealth of \n" +
                        "supplementary information, including instructions for installing Python/Perl and \n" +
                        "Biopython/BioPerl. Next, sophisticated tools for bioinformatics, including relational \n" +
                        "database management systems and XML are covered. Moreover, applications with \n" +
                        "source code, such as sequence manipulation, filtering vector contamination, calculating \n" +
                        "DNA melting temperature, parsing a genbank file, and inferring splicing sites will be \n" +
                        "illustrated.").program(12L).preCourse("BCS213").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BLA003").nameArabic("معمل تطبیق الخوادم الحیویة").nameEnglish("Bioserver Implementation lab").hours(3)
                .lecHours(3).labHours(3).description("Biological Data Servers, or Bioservers, can monitor, analyze, archive and provide real\u0002time remote access to biological systems. They provide baseline data and research \n" +
                        "opportunities. The main goal of this lab is to develop and implement inexpensive open \n" +
                        "source bioservers that can be used in various bioinformatics and computational biology \n" +
                        "studies either in single biomolecule level or in systems biology level. To implement a \n" +
                        "bioserver, this lab depends on the open source operating systems (such as Linux) and \n" +
                        "programming platforms (such as JAVA).").program(12L).preCourse("BCS213").force(1).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BLA004").nameArabic("معمل تحلیل البیانات الجینومیة").nameEnglish("Data Analysis for Genomics lab").hours(3)
                .lecHours(3).labHours(3).description("Matlab and R programming. Next generation sequencing techniques. Epigenetics. DNA \n" +
                        "methylation microarray analysis. Histone gene expression analysis. Microarrays. Gene \n" +
                        "expression. Cancer genomics.").program(12L).preCourse("BIO252").force(0).build());
        courseListDTO.getCourses().add(CourseDTO.builder().code("BMA001").nameArabic("تأھیلي ریاضیات").nameEnglish("Math-0").hours(3)
                .lecHours(3).labHours(3).description("").program(1L).preCourse("").force(1).build());



        courseListDTO.getCourses().add(CourseDTO.builder().code("BTR481").nameArabic("تدریب میدانى").nameEnglish(" Field Trainin").hours(3)
                .lecHours(3).labHours(3).description("Types of statistics, Population versus sample, basic terms - numerical descriptive \n" +
                        "measures for populations and samples, for ungrouped and grouped data: Measures of \n" +
                        "Central Tendency, Measures of Dispersion, And Measures of Position – sampling \n" +
                        "distribution for the sample means – sample proportions and sample variations- point \n" +
                        "and interval estimate for the means, proportions and variance – hypothesis testing – \n" +
                        "regression and correlation analysis.").program(10L).preCourse("").force(1).build());

        return courseListDTO;
    }

    DepartmentListDTO departmentListDTO() {
        DepartmentListDTO departmentListDTO = new DepartmentListDTO(new ArrayList<>());
        departmentListDTO.getDepartments()
                .add(DepartmentDTO.builder().id(1L).nameArabic("عام").nameEnglish("General").code("G").graduationProjectHours(128)
                        .graduationHours(128).minTerms(4).maxDegreeOnFail(64).build());
        departmentListDTO.getDepartments()
                .add(DepartmentDTO.builder().id(2L).nameArabic("علو الحاسب").nameEnglish("Computer Science").code("CS").graduationProjectHours(128)
                        .graduationHours(128).minTerms(4).maxDegreeOnFail(64).build());
        departmentListDTO.getDepartments()
                .add(DepartmentDTO.builder().id(3L).nameArabic("تكنولوجيا المعلومات").nameEnglish("Information Technology").code("IT").graduationProjectHours(128)
                        .graduationHours(128).minTerms(4).maxDegreeOnFail(64).build());
        departmentListDTO.getDepartments()
                .add(DepartmentDTO.builder().id(4L).nameArabic("نظم المعلومات").nameEnglish("Information System").code("IS").graduationProjectHours(128)
                        .graduationHours(128).minTerms(4).maxDegreeOnFail(64).build());
        departmentListDTO.getDepartments()
                .add(DepartmentDTO.builder().id(5L).nameArabic("بحوث العمليات").nameEnglish("Orgnization Research").code("OR").graduationProjectHours(128)
                        .graduationHours(128).minTerms(4).maxDegreeOnFail(64).build());
        departmentListDTO.getDepartments()
                .add(DepartmentDTO.builder().id(6L).nameArabic("هندسه النظم").nameEnglish("Software Engineering").code("SE").graduationProjectHours(136)
                        .graduationHours(128).minTerms(8).maxDegreeOnFail(64).build());
        departmentListDTO.getDepartments()
                .add(DepartmentDTO.builder().id(7L).nameArabic("الحوسبه والمعلوماتيه الحيويه").nameEnglish("Bioinformatics").code("BIO").graduationProjectHours(136)
                        .graduationHours(128).minTerms(8).maxDegreeOnFail(64).build());

        return departmentListDTO;
    }

    List<PointSystem> pointSystems() {
        List<PointSystem> pointSystems = new ArrayList<>();
        pointSystems.add(PointSystem.builder().nameEnglish("A+").nameArabic("A+").degreeLow(90).degreeHigh(100).points(4).build());
        pointSystems.add(PointSystem.builder().nameEnglish("A").nameArabic("A").degreeLow(85).degreeHigh(90).points(4).build());
        pointSystems.add(PointSystem.builder().nameEnglish("B+").nameArabic("B+").degreeLow(80).degreeHigh(85).points(3).build());
        pointSystems.add(PointSystem.builder().nameEnglish("B").nameArabic("B").degreeLow(75).degreeHigh(80).points(3).build());
        pointSystems.add(PointSystem.builder().nameEnglish("C+").nameArabic("C+").degreeLow(70).degreeHigh(75).points(3).build());
        pointSystems.add(PointSystem.builder().nameEnglish("C").nameArabic("C").degreeLow(65).degreeHigh(70).points(2).build());
        pointSystems.add(PointSystem.builder().nameEnglish("D+").nameArabic("D+").degreeLow(60).degreeHigh(65).points(2).build());
        pointSystems.add(PointSystem.builder().nameEnglish("D").nameArabic("D").degreeLow(50).degreeHigh(60).points(2).build());
        pointSystems.add(PointSystem.builder().nameEnglish("F").nameArabic("F").degreeLow(0).degreeHigh(50).points(0).build());
        return pointSystems;
    }

    List<Privilege> privileges() {
        List<Privilege> privileges = new ArrayList<>();
        privileges.add(Privilege.builder().name(EPrivilege.READ_API).build());
        return privileges;
    }

    List<ProgramLevel> programLevels() {
        List<ProgramLevel> programLevels = new ArrayList<>();
        programLevels.add(ProgramLevel.builder().nameEnglish("Level 1").nameArabic("المستوى الاول").minHours(0).build());
        programLevels.add(ProgramLevel.builder().nameEnglish("Level 2").nameArabic("المستوى التانى").minHours(34).build());
        programLevels.add(ProgramLevel.builder().nameEnglish("Level 3").nameArabic("المستوى الثالث").minHours(68).build());
        programLevels.add(ProgramLevel.builder().nameEnglish("Level 4").nameArabic("المستوى الرابع").minHours(102).build());
        return programLevels;
    }

    List<Program> programs() {
        List<Program> programs = new ArrayList<>();
        programs.add(Program.builder().id(1L).nameArabic("متطلبات تاهيليه").nameEnglish("متطلبات تاهيليه").hours(0).build());
        Program program2 = Program.builder().id(2L).nameArabic("متطلبات جامعه").nameEnglish("متطلبات جامعه").hours(12).build();
        programs.add(program2);
        Program program3 = Program.builder().id(3L).nameArabic("متطلبات الكليه").nameEnglish("متطلبات الكليه").hours(63).build();
        programs.add(program3);
        Program program4 = Program.builder().id(4L).nameArabic("متطلبات تخصص").nameEnglish("متطلبات تخصص").hours(61).build();
        programs.add(program4);
        programs.add(Program.builder().id(5L).nameArabic("متطلبات جامعه اجباريه").nameEnglish("متطلبات جامعه اجباريه").hours(6).underRequirement(program2).build());
        programs.add(Program.builder().id(6L).nameArabic("متطلبات جامعه اختياريه").nameEnglish("متطلبات جامعه اختياريه").hours(6).underRequirement(program2).build());
        programs.add(Program.builder().id(7L).nameArabic("رياضيات وعلوم اساسيه اجباريه").nameEnglish("رياضيات وعلوم اساسيه اجباريه").hours(21).underRequirement(program3).build());
        programs.add(Program.builder().id(8L).nameArabic("علوم حاسب اساسيه").nameEnglish("علوم حاسب اساسيه").hours(42).underRequirement(program3).build());
        programs.add(Program.builder().id(9L).nameArabic("علوم تطبيقية").nameEnglish("علوم تطبيقية").hours(45).underRequirement(program4).build());
        programs.add(Program.builder().id(10L).nameArabic("تدريب ميدانى").nameEnglish("تدريب ميدانى").hours(2).underRequirement(program4).build());
        programs.add(Program.builder().id(11L).nameArabic("مشروع").nameEnglish("مشروع").hours(6).underRequirement(program4).build());
        programs.add(Program.builder().id(12L).nameArabic("موضوعات تحددها المؤسسه").nameEnglish("موضوعات تحددها المؤسسه").hours(8).underRequirement(program4).build());
        return programs;
    }

    List<RegularTermRules> regularTermRules() {
        List<RegularTermRules> regularTermRules = new ArrayList<>();

        regularTermRules.add(RegularTermRules.builder().gpaLow(0).gpaHigh(1).hourMin(9).hourMax(12).hourSpMin(2).hourSpMax(12).build());
        regularTermRules.add(RegularTermRules.builder().gpaLow(1).gpaHigh(2).hourMin(9).hourMax(15).hourSpMin(2).hourSpMax(12).build());
        regularTermRules.add(RegularTermRules.builder().gpaLow(2).gpaHigh(4).hourMin(9).hourMax(18).hourSpMin(2).hourSpMax(12).build());

        return regularTermRules;
    }

    List<SummerTermRules> summerTermRules() {
        List<SummerTermRules> summerTermRules = new ArrayList<>();
        summerTermRules.add(SummerTermRules.builder().gpaLow(0).gpaHigh(4).hourMin(0).hourMax(6).hourSpMin(0).hourSpMax(9).build());
        return summerTermRules;
    }

    List<Role> roles() {
        List<Role> roles = new ArrayList<>();
        roles.add(Role.builder().name(ERole.ROLE_ADMIN).description("Administrator ").privileges(new ArrayList<>()).build());
        roles.add(Role.builder().name(ERole.ROLE_STUDENT).description("STUDENT ").privileges(new ArrayList<>()).build());
        roles.add(Role.builder().name(ERole.ROLE_DOCTOR).description("DOCTOR ").privileges(new ArrayList<>()).build());
        roles.add(Role.builder().name(ERole.ROLE_USER).description("Administrator ").privileges(new ArrayList<>()).build());
        return roles;
    }

    StudentListDTO studentListDTO() {
        StudentListDTO studentListDTO = new StudentListDTO(new ArrayList<>());
        studentListDTO.getStudents().add(StudentDTO.builder().nameArabic("مصطفى خالد").nameEnglish("Mustafa Khaled").nationality("مصرى").gender(Gender.male.name())
                .religion("مسلم").DOB(new Date()).nationalId("123456789").guardianName("خالد ابراهيم").email("asdxasd012@gmail.com").secSchool("الثانوى العام").preQualfication("علمى رياضه").degrees(152)
                .studentInfo(1L).user(1L).guide(1L).department(1L).city(31755L).build());
        studentListDTO.getStudents().add(StudentDTO.builder().nameArabic("عمرو مجدي").nameEnglish("Amr magdy").nationality("مصرى").gender(Gender.male.name())
                .religion("مسلم").DOB(new Date()).nationalId("123476789").guardianName("مجدي محمد").email("amrd012@gmail.com").secSchool("الثانوى العام").preQualfication("علمى رياضه").degrees(252)
                .studentInfo(1L).user(2L).guide(1L).department(1L).city(31756L).build());
        studentListDTO.getStudents().add(StudentDTO.builder().nameArabic("احمد محمد زغلوال").nameEnglish("Ahmed mohamed").nationality("مصرى").gender(Gender.male.name())
                .religion("مسلم").DOB(new Date()).nationalId("123476778").guardianName("محمد زغلول").email("ahmed012@gmail.com").secSchool("الثانوى العام").preQualfication("علمى رياضه").degrees(352)
                .studentInfo(1L).user(3L).guide(1L).department(1L).city(31756L).build());
        studentListDTO.getStudents().add(StudentDTO.builder().nameArabic("وليد عطيه عبدالحميد").nameEnglish("Walid Atia").nationality("مصرى").gender(Gender.male.name())
                .religion("مسلم").DOB(new Date()).nationalId("52347378").guardianName("عطيه عبد الحميد").email("walid012@gmail.com").secSchool("الثانوى العام").preQualfication("علمى رياضه").degrees(352)
                .studentInfo(1L).user(3L).guide(1L).department(1L).city(31756L).build());
        return studentListDTO;
    }


    StudentInfoListDTO studentInfoListDTO() {
        StudentInfoListDTO studentInfoListDTO = new StudentInfoListDTO(new ArrayList<>());
        studentInfoListDTO.getStudentInfos().add(StudentInfoDTO.builder().gpa2Cnt(0).build());

        return studentInfoListDTO;
    }

    TeachingStaffListDTO teachingStaffListDTO() {
        TeachingStaffListDTO teachingStaffListDTO = new TeachingStaffListDTO(new ArrayList<>());

        teachingStaffListDTO.getTeachingStaffs().add(TeachingStaffDTO.builder().nameArabic("ا-د-عربى كشك").nameEnglish("Prof-Dr-Arabi").nationality("مصرى").gender(Gender.male.name())
                .religion("مسلم").DOB(new Date()).nationalId("123456789").email("asdxasd012@gmail.com").user(3L).city(31755L).phdDegree("Doctor").build());

        return teachingStaffListDTO;
    }

    UserListDTO userListDTO() {
        UserListDTO userListDTO = new UserListDTO(new ArrayList<>());

        UserDTO admin = UserDTO.builder().name("Mustafa").username("admin").email("admin@fci.com").password(encoder.encode("admin")).enabled(true).roles(new HashSet<>()).build();
        admin.getRoles().add("ROLE_ADMIN");
        userListDTO.getUsers().add(admin);

        UserDTO student = UserDTO.builder().name("AMR").username("student").email("student@fci.com").password(encoder.encode("student")).enabled(true).roles(new HashSet<>()).build();
        student.getRoles().add("ROLE_STUDENT");
        userListDTO.getUsers().add(student);

        UserDTO doctor = UserDTO.builder().name("AHMED").username("doctor").email("doctor@fci.com").password(encoder.encode("doctor")).enabled(true).roles(new HashSet<>()).build();
        doctor.getRoles().add("ROLE_DOCTOR");
        userListDTO.getUsers().add(doctor);
        return userListDTO;
    }

    List<Term> terms(){

        Term term1 = Term.builder().nameArabic("ترم اول لسنه 2017/2018").nameEnglish("First Term 2017/2018")
                .termType(TermType.regular).start(LocalDate.of(2017, 1, 1)).end(LocalDate.of(2017, 6, 1))
                .startRegistration(LocalDate.of(2017, 1, 1)).endRegistration(LocalDate.of(2017, 1, 7))
                .startUpdating(LocalDate.of(2017, 1, 10)).endUpdating(LocalDate.of(2017, 1, 17))
                .startWithdrawn(LocalDate.of(2017, 1, 20)).endWithdrawn(LocalDate.of(2017, 1, 27)).build();

        Term term2 = Term.builder().nameArabic("ترم صيفى 2017").nameEnglish("Summer Term 2017")
                .termType(TermType.summer).start(LocalDate.of(2017, 7, 1)).end(LocalDate.of(2017, 9, 1))
                .startRegistration(LocalDate.of(2017, 7, 1)).endRegistration(LocalDate.of(2017, 7, 7))
                .startUpdating(LocalDate.of(2017, 7, 10)).endUpdating(LocalDate.of(2017, 7, 17))
                .startWithdrawn(LocalDate.of(2017, 7, 20)).endWithdrawn(LocalDate.of(2017, 7, 27)).build();

        Term term3 = Term.builder().nameArabic("ترم ثانى لسنه 2017/2018").nameEnglish("Second Term 2017/2018")
                .termType(TermType.regular).start(LocalDate.of(2017, 9, 1)).end(LocalDate.of(2017, 12, 1))
                .startRegistration(LocalDate.of(2017, 9, 1)).endRegistration(LocalDate.of(2017, 9, 7))
                .startUpdating(LocalDate.of(2017, 9, 10)).endUpdating(LocalDate.of(2017, 9, 17))
                .startWithdrawn(LocalDate.of(2017, 9, 20)).endWithdrawn(LocalDate.of(2017, 9, 27)).build();

        Term term4 = Term.builder().nameArabic("ترم اول لسنه 2018/2019").nameEnglish("First Term 2018/2019")
                .termType(TermType.regular).start(LocalDate.of(2018, 1, 1)).end(LocalDate.of(2018, 6, 1))
                .startRegistration(LocalDate.of(2018, 1, 1)).endRegistration(LocalDate.of(2018, 1, 7))
                .startUpdating(LocalDate.of(2018, 1, 10)).endUpdating(LocalDate.of(2018, 1, 17))
                .startWithdrawn(LocalDate.of(2018, 1, 20)).endWithdrawn(LocalDate.of(2018, 1, 27)).build();

        Term term5 = Term.builder().nameArabic("ترم صيفى 2018").nameEnglish("Summer Term 2018")
                .termType(TermType.summer).start(LocalDate.of(2018, 7, 1)).end(LocalDate.of(2018, 9, 1))
                .startRegistration(LocalDate.of(2018, 7, 1)).endRegistration(LocalDate.of(2018, 7, 7))
                .startUpdating(LocalDate.of(2018, 7, 10)).endUpdating(LocalDate.of(2018, 7, 17))
                .startWithdrawn(LocalDate.of(2018, 7, 20)).endWithdrawn(LocalDate.of(2018, 7, 27)).build();

        Term term6 = Term.builder().nameArabic("ترم ثانى لسنه 2018/2019").nameEnglish("Second Term 2018/2019")
                .termType(TermType.regular).start(LocalDate.of(2018, 9, 1)).end(LocalDate.of(2018, 12, 1))
                .startRegistration(LocalDate.of(2018, 9, 1)).endRegistration(LocalDate.of(2018, 9, 7))
                .startUpdating(LocalDate.of(2018, 9, 10)).endUpdating(LocalDate.of(2018, 9, 17))
                .startWithdrawn(LocalDate.of(2018, 9, 20)).endWithdrawn(LocalDate.of(2018, 9, 27)).build();

        Term term7 = Term.builder().nameArabic("ترم اول لسنه 2019/2020").nameEnglish("First Term 2019/2020")
                .termType(TermType.regular).start(LocalDate.of(2019, 1, 1)).end(LocalDate.of(2019, 6, 1))
                .startRegistration(LocalDate.of(2019, 1, 1)).endRegistration(LocalDate.of(2019, 1, 7))
                .startUpdating(LocalDate.of(2019, 1, 10)).endUpdating(LocalDate.of(2019, 1, 17))
                .startWithdrawn(LocalDate.of(2019, 1, 20)).endWithdrawn(LocalDate.of(2019, 1, 27)).build();

        Term term8 = Term.builder().nameArabic("ترم صيفى 2019").nameEnglish("Summer Term 2019")
                .termType(TermType.summer).start(LocalDate.of(2019, 7, 1)).end(LocalDate.of(2019, 9, 1))
                .startRegistration(LocalDate.of(2019, 7, 1)).endRegistration(LocalDate.of(2019, 7, 7))
                .startUpdating(LocalDate.of(2019, 7, 10)).endUpdating(LocalDate.of(2019, 7, 17))
                .startWithdrawn(LocalDate.of(2019, 7, 20)).endWithdrawn(LocalDate.of(2019, 7, 27)).build();

        Term term9 = Term.builder().nameArabic("ترم ثانى لسنه 2019/2020").nameEnglish("Second Term 2019/2020")
                .termType(TermType.regular).start(LocalDate.of(2019, 9, 1)).end(LocalDate.of(2019, 12, 1))
                .startRegistration(LocalDate.of(2019, 9, 1)).endRegistration(LocalDate.of(2019, 9, 7))
                .startUpdating(LocalDate.of(2019, 9, 10)).endUpdating(LocalDate.of(2019, 9, 17))
                .startWithdrawn(LocalDate.of(2019, 9, 20)).endWithdrawn(LocalDate.of(2019, 9, 27)).build();

        Term term10 = Term.builder().nameArabic("ترم اول لسنه 2020/2021").nameEnglish("First Term 2020/2021")
                .termType(TermType.regular).start(LocalDate.of(2020, 1, 1)).end(LocalDate.of(2020, 6, 1))
                .startRegistration(LocalDate.of(2020, 1, 1)).endRegistration(LocalDate.of(2020, 1, 7))
                .startUpdating(LocalDate.of(2020, 1, 10)).endUpdating(LocalDate.of(2020, 1, 17))
                .startWithdrawn(LocalDate.of(2020, 1, 20)).endWithdrawn(LocalDate.of(2020, 1, 27)).build();

        Term term11 = Term.builder().nameArabic("ترم صيفى 2020").nameEnglish("Summer Term 2020")
                .termType(TermType.summer).start(LocalDate.of(2020, 7, 1)).end(LocalDate.of(2020, 9, 1))
                .startRegistration(LocalDate.of(2020, 7, 1)).endRegistration(LocalDate.of(2020, 7, 7))
                .startUpdating(LocalDate.of(2020, 7, 10)).endUpdating(LocalDate.of(2020, 7, 17))
                .startWithdrawn(LocalDate.of(2020, 7, 20)).endWithdrawn(LocalDate.of(2020, 7, 27)).build();

        Term term12 = Term.builder().nameArabic("ترم ثانى لسنه 2020/2021").nameEnglish("Second Term 2020/2021")
                .termType(TermType.regular).start(LocalDate.of(2020, 9, 2)).end(LocalDate.of(2020, 12, 1))
                .startRegistration(LocalDate.of(2020, 9, 1)).endRegistration(LocalDate.of(2020, 9, 7))
                .startUpdating(LocalDate.of(2020, 9, 10)).endUpdating(LocalDate.of(2020, 9, 17))
                .startWithdrawn(LocalDate.of(2020, 9, 20)).endWithdrawn(LocalDate.of(2020, 9, 27)).build();

        return new ArrayList<>(Arrays.asList(term1, term2, term3, term4, term5, term6, term7, term8, term9, term10
                , term11, term12));
    }

    CourseInTermListDTO courseInTermListDTO(){
        CourseInTermListDTO courseInTermListDTO=new CourseInTermListDTO(new ArrayList<>());
        CourseInTermDTO course101=CourseInTermDTO.builder().term(1L).course("BMA001").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course102=CourseInTermDTO.builder().term(1L).course("BIO001").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course103=CourseInTermDTO.builder().term(1L).course("BCS111").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course104=CourseInTermDTO.builder().term(1L).course("BIO261").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course105=CourseInTermDTO.builder().term(1L).course("BIT111").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course106=CourseInTermDTO.builder().term(1L).course("BCS213").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course107=CourseInTermDTO.builder().term(1L).course("BMA113").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course108=CourseInTermDTO.builder().term(1L).course("BMA112").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course109=CourseInTermDTO.builder().term(1L).course("BST121").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course110=CourseInTermDTO.builder().term(1L).course("BCS221").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course111=CourseInTermDTO.builder().term(1L).course("BIO252").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course112=CourseInTermDTO.builder().term(1L).course("BIO353").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course113=CourseInTermDTO.builder().term(1L).course("BIO451").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course114=CourseInTermDTO.builder().term(1L).course("BIS211").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course115=CourseInTermDTO.builder().term(1L).course("BCS316").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course116=CourseInTermDTO.builder().term(1L).course("BIT416").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course117=CourseInTermDTO.builder().term(1L).course("BIO454").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
//        CourseInTermDTO course118=CourseInTermDTO.builder().term(1L).course("BIO457").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course119=CourseInTermDTO.builder().term(1L).course("BIO498").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course120=CourseInTermDTO.builder().term(1L).course("BLA001").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course121=CourseInTermDTO.builder().term(1L).course("BLA002").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course201=CourseInTermDTO.builder().term(3L).course("BMA111").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course202=CourseInTermDTO.builder().term(3L).course("BIO251").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course203=CourseInTermDTO.builder().term(3L).course("BIO262").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course204=CourseInTermDTO.builder().term(3L).course("BHU131").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course205=CourseInTermDTO.builder().term(3L).course("BCS112").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course206=CourseInTermDTO.builder().term(3L).course("BCS214").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course207=CourseInTermDTO.builder().term(3L).course("BST122").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
//        CourseInTermDTO course208=CourseInTermDTO.builder().term(3L).course("BIO316").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course209=CourseInTermDTO.builder().term(3L).course("BCS241").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course210=CourseInTermDTO.builder().term(3L).course("BIO352").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course211=CourseInTermDTO.builder().term(3L).course("BIO452").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course212=CourseInTermDTO.builder().term(3L).course("BIO455").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course213=CourseInTermDTO.builder().term(3L).course("BIT222").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course214=CourseInTermDTO.builder().term(3L).course("BCS251").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course215=CourseInTermDTO.builder().term(3L).course("BCS322").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course216=CourseInTermDTO.builder().term(3L).course("BIO498").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course217=CourseInTermDTO.builder().term(3L).course("BLA004").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();
        CourseInTermDTO course218=CourseInTermDTO.builder().term(3L).course("BLA003").instructor(1L).lectureDay(Day.SATURDAY.name()).lectureTime(1).courseType(CourseType.GROUB.name()).minStudent(150).build();

        courseInTermListDTO.getCourseInTerms().addAll(Arrays.asList(course101, course102, course103, course104, course105, course106, course107, course108, course109
                , course110, course111, course112, course113, course114, course115, course116, course117, course119, course120, course121, course201, course202
                , course202, course203, course204, course205, course206, course207, course209, course210, course211, course212, course213, course214, course215
                , course216, course217, course218));
        return courseInTermListDTO;
    }

    LabListDTO labs(){
        LabListDTO labListDTO=new LabListDTO(new ArrayList<>());

        LabDTO labDTO01 = LabDTO.builder().courseInTerm(1L).labDay(Day.SUNDAY.name()).labTime(1).maxStudent(40).teachingStaff(1L).build();
        LabDTO labDTO02 = LabDTO.builder().courseInTerm(2L).labDay(Day.SUNDAY.name()).labTime(1).maxStudent(40).teachingStaff(1L).build();
        LabDTO labDTO03 = LabDTO.builder().courseInTerm(3L).labDay(Day.SUNDAY.name()).labTime(1).maxStudent(40).teachingStaff(1L).build();
        LabDTO labDTO04 = LabDTO.builder().courseInTerm(4L).labDay(Day.SUNDAY.name()).labTime(1).maxStudent(40).teachingStaff(1L).build();
        LabDTO labDTO05 = LabDTO.builder().courseInTerm(5L).labDay(Day.SUNDAY.name()).labTime(1).maxStudent(40).teachingStaff(1L).build();
        LabDTO labDTO06 = LabDTO.builder().courseInTerm(6L).labDay(Day.SUNDAY.name()).labTime(1).maxStudent(40).teachingStaff(1L).build();
        LabDTO labDTO07 = LabDTO.builder().courseInTerm(6L).labDay(Day.MONDAY.name()).labTime(1).maxStudent(40).teachingStaff(1L).build();
        LabDTO labDTO08 = LabDTO.builder().courseInTerm(7L).labDay(Day.SUNDAY.name()).labTime(1).maxStudent(40).teachingStaff(1L).build();
        LabDTO labDTO09 = LabDTO.builder().courseInTerm(8L).labDay(Day.SUNDAY.name()).labTime(1).maxStudent(40).teachingStaff(1L).build();
        LabDTO labDTO10 = LabDTO.builder().courseInTerm(9L).labDay(Day.SUNDAY.name()).labTime(1).maxStudent(40).teachingStaff(1L).build();

        labListDTO.getLabs().addAll(Arrays.asList(labDTO01, labDTO02, labDTO03, labDTO04, labDTO05, labDTO06, labDTO07, labDTO08, labDTO09, labDTO10));

        return labListDTO;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        countryRepository.saveAll(countries());
        countryRepository.flush();
        stateRepository.saveAll(states());
        cityRepository.saveAll(cities());
        roleRepository.saveAll(roles());
        userListDTO().getUsers().forEach(userService::createNew);
        programRepository.saveAll(programs());
        courseListDTO().getCourses().forEach(courseService::createNew);
        departmentListDTO().getDepartments().forEach(departmentService::createNew);
        pointSystemRepository.saveAll(pointSystems());
        privilegeRepository.saveAll(privileges());
        programLevelRepository.saveAll(programLevels());
        regularTermRuleRepository.saveAll(regularTermRules());
        summerTermRulesRepository.saveAll(summerTermRules());
        studentInfoListDTO().getStudentInfos().stream().forEach(studentInfoService::createNew);
        teachingStaffListDTO().getTeachingStaffs().forEach(teachingStaffService::createNew);
        studentListDTO().getStudents().forEach(studentService::createNew);
        termRepository.saveAll(terms());
        courseInTermListDTO().getCourseInTerms().forEach(courseInTermService::createNew);
        labs().getLabs().forEach(labService::createNew);

    }
}
