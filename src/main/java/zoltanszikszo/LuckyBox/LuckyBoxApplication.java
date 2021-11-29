package zoltanszikszo.LuckyBox;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import zoltanszikszo.LuckyBox.domain.User;
import zoltanszikszo.LuckyBox.domain.UserRepository;
import zoltanszikszo.LuckyBox.domain.Userboxes;
import zoltanszikszo.LuckyBox.domain.UserboxesRepository;

import java.time.LocalDate;

@SpringBootApplication
public class LuckyBoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(LuckyBoxApplication.class, args);
	}

	@Bean
	public CommandLineRunner luckyboxtest(UserboxesRepository userboxessRepository, UserRepository userRepository){
		return (args) -> {

			System.out.println("------------ Adding users for test ------------");

			User adminuser = new User("admin", "$2a$12$Q3crVElS9V7CFdZq5uTv..LiCprL2kyUSZxiOZGQG0Xk0qXrATJom", "admin@luckybox.com", "ADMIN");
			userRepository.save(adminuser);

			User testuser = new User("user", "$2a$12$Z0QixPu2SAXRngbIvQ7x9OvouqmjGDr5iUG9AxxG26O2CJZVLK6zu", "test@luckybox.com", "USER");
			userRepository.save(testuser);

			LocalDate now = LocalDate.now();

			System.out.println("------------ Adding some gift to our store which you can purchase ------------");

			userboxessRepository.save(new Userboxes("Holiday Box", "Christmas", 3000, now, "https://i.picsum.photos/id/519/200/200.jpg?hmac=7MwcBjyXrRX5GB6GuDATVm_6MFDRmZaSK7r5-jqDNS0", "Winter Box"));
			userboxessRepository.save(new Userboxes("Xmas Tree Box", "Santa Claus", 1000, now, "https://i.picsum.photos/id/658/200/200.jpg?hmac=f24wxXCkgtH72eZ6mY95KRxTyvEG-_3ysR9z-R0a1QM", "Winter Box"));
			userboxessRepository.save(new Userboxes("Moms Box", "Christmas", 3000, now, "https://i.picsum.photos/id/519/200/200.jpg?hmac=7MwcBjyXrRX5GB6GuDATVm_6MFDRmZaSK7r5-jqDNS0", "Winter Box"));
			userboxessRepository.save(new Userboxes("Easter Box", "Easter", 1000, now, "https://i.picsum.photos/id/658/200/200.jpg?hmac=f24wxXCkgtH72eZ6mY95KRxTyvEG-_3ysR9z-R0a1QM", "Spring Box"));
			userboxessRepository.save(new Userboxes("Birthday Box", "Birthday", 3000, now, "https://i.picsum.photos/id/519/200/200.jpg?hmac=7MwcBjyXrRX5GB6GuDATVm_6MFDRmZaSK7r5-jqDNS0", "Universal Box"));
			userboxessRepository.save(new Userboxes("New Year's Eve Box", "New Year", 1000, now, "https://i.picsum.photos/id/658/200/200.jpg?hmac=f24wxXCkgtH72eZ6mY95KRxTyvEG-_3ysR9z-R0a1QM", "Winter Box"));
			userboxessRepository.save(new Userboxes("Mom Days Box", "Love", 3000, now, "https://i.picsum.photos/id/519/200/200.jpg?hmac=7MwcBjyXrRX5GB6GuDATVm_6MFDRmZaSK7r5-jqDNS0", "Love Box"));
			userboxessRepository.save(new Userboxes("Dad Days Box", "Love", 1000, now, "https://i.picsum.photos/id/658/200/200.jpg?hmac=f24wxXCkgtH72eZ6mY95KRxTyvEG-_3ysR9z-R0a1QM", "Love Box"));
			userboxessRepository.save(new Userboxes("Girlfriend Box", "Love", 3000, now, "https://i.picsum.photos/id/519/200/200.jpg?hmac=7MwcBjyXrRX5GB6GuDATVm_6MFDRmZaSK7r5-jqDNS0", "Love Box"));
			userboxessRepository.save(new Userboxes("Boyfriend Box", "Love", 1000, now, "https://i.picsum.photos/id/658/200/200.jpg?hmac=f24wxXCkgtH72eZ6mY95KRxTyvEG-_3ysR9z-R0a1QM", "Love Box"));
			userboxessRepository.save(new Userboxes("Girlfriend Xmas Box", "Christmas", 3000, now, "https://i.picsum.photos/id/519/200/200.jpg?hmac=7MwcBjyXrRX5GB6GuDATVm_6MFDRmZaSK7r5-jqDNS0", "Winter Box"));
			userboxessRepository.save(new Userboxes("Boyfriend Santa's Box", "Santa Claus", 1000, now, "https://i.picsum.photos/id/658/200/200.jpg?hmac=f24wxXCkgtH72eZ6mY95KRxTyvEG-_3ysR9z-R0a1QM", "Winter Box"));

			System.out.println("------------ Fetch all gifts ------------");
			for(Userboxes userboxes : userboxessRepository.findAll()){
				System.out.println(userboxes.toString());
			}
		};
	}
}
