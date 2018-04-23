package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConfig.class)
@ActiveProfiles("test")
public class RepoTest {

    @Autowired
    private Repo repo;

    @Test
    public void getByIdTest(){
        Info info = repo.getById(1);
        assertNull(info);

        info = new Info(1, "name", "email");
        repo.save(info);

        info = repo.getById(1);
        assertNotNull(info);
    }

    @Test
    public void editTest(){
        Info info = new Info(1, "name", "email");
        repo.save(info);

        info = repo.getById(1);
        assertEquals(info.getName(), "name");
        assertEquals(info.getEmail(), "email");

        repo.edit("name1", "email1", 1);

        info = repo.getById(1);
        assertEquals(info.getName(), "name1");
        assertEquals(info.getEmail(), "email1");
    }
}