package com.productservice.productservice;

import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Price;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.CategoryRepository;
import com.productservice.productservice.repositories.OrderRepository;
import com.productservice.productservice.repositories.PriceRepository;
import com.productservice.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
//This is combination of three annotation @ComponentScan @EnableAutoConfiguration @Configuration
public class ProductServiceApplication implements CommandLineRunner{

//    private final CategoryRepository categoryRepository;
//    private final ProductRepository productRepository;
//    private final PriceRepository priceRepository;
//
//    @Autowired
//    public ProductServiceApplication(CategoryRepository categoryRepository,
//                                     ProductRepository productRepository,
//                                     PriceRepository priceRepository) {
//        this.categoryRepository = categoryRepository;
//        this.productRepository = productRepository;
//        this.priceRepository = priceRepository;
//    }

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


//            Category category = new Category();
//            category.setName("Apple Devices");
//            Category savedCategory = categoryRepository.save(category);

//            Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("01fa256d-bc5c-4dae-9927-29f64c166c37"));
//
//            if(optionalCategory.isEmpty())
//            {
//                throw new Exception("Category was null");
//            }
//            Category category = optionalCategory.get();

//            Product product = new Product();
//            product.setTitle("iphone 15 pro");
//            product.setDescription("Best Iphone ever");
//            product.setCategory(category);
//            product.setCategory(category.get());

//            Product saveProduct = productRepository.save(product);

//              List<Product> products = category.getProducts();
//
//              for(Product pr: products)
//              {
//                  System.out.println(pr.getTitle());
//              }
//
//            Price price = new Price();
//            price.setCurrency("INR");
//            price.setValue(100000);
//
//            Price savedPrice = priceRepository.save(price);
//
//            Category category = new Category();
//            category.setName("Apple Devices");
//
//            Category savedCategory = categoryRepository.save(category);
//
//            Product product = new Product();
//            product.setTitle("iPhone 15 pro");
//            product.setDescription("Best iPhone ever");
//            product.setCategory(category);
//            product.setPrice(price);
//
//            productRepository.save(product);

//            Product savedProduct = productRepository.getById(UUID.fromString("f9b59066-1daa-4b21-a998-b5716edc9ed6"));
//
////            priceRepository.deleteById(UUID.fromString("68dfc3e9-7516-48c2-88ca-6fe012643e58"));
//
//            productRepository.delete(savedProduct);

        }
}
