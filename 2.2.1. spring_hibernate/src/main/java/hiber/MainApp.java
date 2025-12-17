package hiber;


import hiber.config.AppConfig;
import hiber.model.User;
import hiber.model.Car;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Toyota", 111);
      User user1 = new User("User1", "Lastname1", "user1@gmail.com");
      user1.setCar(car1);
      userService.add(user1);


      Car car2 = new Car("BMW",412);
      User user2 = new User("User2", "Lastname2", "user2@gmail.com");
      user2.setCar(car2);
      userService.add(user2);

      Car car3 = new Car("Mercedes", 500);
      User user3 = new User("User3", "Lastname3", "user3@gmail.com");
      user3.setCar(car3);
      userService.add(user3);

      Car car4 = new Car("Audi", 348);
      User user4 = new User("User4", "Lastname4", "user4@gmail.com");
      user4.setCar(car4);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar().getModel() + " " + user.getCar().getSeries());
         System.out.println();
      }



      User foundUser = userService.getUserByCarModelAndSeries("BMW", 412);
      System.out.println("Found user by car (BMW, 412):");
      System.out.println("Id = " + foundUser.getId());
      System.out.println("First Name = " + foundUser.getFirstName());
      System.out.println("Last Name = " + foundUser.getLastName());
      System.out.println("Email = " + foundUser.getEmail());
      context.close();
   }
}
