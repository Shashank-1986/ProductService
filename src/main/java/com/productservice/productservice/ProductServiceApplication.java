package com.productservice.productservice;

import com.productservice.productservice.inheritancerelations.singletable.*;
import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.CategoryRepository;
import com.productservice.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//This is combination of three annotation @ComponentScan @EnableAutoConfiguration @Configuration
public class ProductServiceApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ProductServiceApplication(CategoryRepository categoryRepository,
                                     ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

//    private MentorRepository mentorRepository;
//    private StudentRepository studentRepository;
//    private TaRepository taRepository;
//    private UserRepository userRepository;
//
//    public ProductServiceApplication(@Qualifier("tpc_mentorrepository") MentorRepository mentorRepository,
//                                     StudentRepository studentRepository,
//                                     TaRepository taRepository,
//                                     UserRepository userRepository) {
//       this.mentorRepository = mentorRepository;
//       this.studentRepository = studentRepository;
//       this.taRepository = taRepository;
//       this.userRepository = userRepository;
//    }

    //private StudentRepository studentRepository;
//    private MentorRepository mentorRepository;
//
//    private UserRepository userRepository;

//    ProductServiceApplication(@Qualifier("st_mentorrepository") MentorRepository mentorRepository,
//                              @Qualifier("st_studentrepository") StudentRepository studentRepository,
//                              @Qualifier("st_userrepository") UserRepository userRepository){
//        this.mentorRepository = mentorRepository;
//        this.userRepository = userRepository;
//        this.studentRepository = studentRepository;
//    }
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
        @Override
        public void run (String...args) throws Exception {
//            Mentor mentor = new Mentor();
//            mentor.setName("Shashank");
//            mentor.setEmail("miracle85.shashank@gmail.com");
//            mentor.setAvgRating(4.8);
//            mentorRepository.save(mentor);
//
//
//            Student student = new Student();
//            student.setName("Archana");
//            student.setEmail("archana10jan@gmail.com");
//            student.setPsp(4.9);
//            studentRepository.save(student);
//
//            User user = new User();
//            user.setName("Shivansh");
//            user.setEmail("banku@gmail.com");
//            userRepository.save(user);
//
//            Ta ta = new Ta();
//            ta.setName("Anshuman");
//            ta.setEmail("anshuman@gmail.com");
//            ta.setTa_session("DSA");
//            taRepository.save(ta);
//
//            List<User> userList = userRepository.findAll();
//
//            for(User u: userList)
//            {
//                System.out.println(u.toString());
//            }
//            User user = new User();
//            user.setEmail("miracle85.shashank@gmail.com");
//            user.setName("Shashank");
//            userRepository.save(user);
//
//            Student student = new Student();
//            student.setName("Archana");
//            student.setEmail("archanasingh10jan@gmail.com");
//            student.setPsp(4.9);
//            studentRepository.save(student);
//
//            Mentor mentor = new Mentor();
//            mentor.setName("Deepak Kasera");
//            mentor.setEmail("deepak@scaler.com");
//            mentor.setAvgRating(4.8);
//            mentorRepository.save(mentor);


            Category category = new Category();
            category.setName("Apple Devices");

            Category savedCategory = categoryRepository.save(category);

            Product product = new Product();
            product.setTitle("iphone 15 pro");
            product.setDescription("Best Iphone ever");
            product.setCategory(savedCategory);

            productRepository.save(product);


        }
}
