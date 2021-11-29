package zoltanszikszo.LuckyBox;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import zoltanszikszo.LuckyBox.domain.Userboxes;
import zoltanszikszo.LuckyBox.domain.UserboxesRepository;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserboxesRepositoryTest {

    @Autowired
    private UserboxesRepository userboxesRepository;

    @Test
    public void findByName() {
        List<Userboxes> boxes = userboxesRepository.findBoxesByName("Holiday Box");

        assertThat(boxes).hasSize(1);
        assertThat(boxes.get(0).getCategory()).isEqualTo("Christmas");
    }

    @Test
    public void createNewUserboxes(){
        LocalDate now = LocalDate.now();
        Userboxes userboxes = new Userboxes("Summer Box", "Summer", 5000, now, "https://i.picsum.photos/id/519/200/200.jpg?hmac=7MwcBjyXrRX5GB6GuDATVm_6MFDRmZaSK7r5-jqDNS0", "Summer Box");
        userboxesRepository.save(userboxes);
        assertThat(userboxes.getUserboxesid()).isNotNull();
    }

    @Test
    public void deleteNewUserboxes(){
        List<Userboxes> userboxes = userboxesRepository.findBoxesByName("Test Box");
        Userboxes box = userboxes.get(0);
        long id = box.getUserboxesid();
        userboxesRepository.delete(box);

        List <Userboxes> newBoxes = userboxesRepository.findBoxesByName("Test Box");

        assertThat(newBoxes).hasSize(0);
    }

}
