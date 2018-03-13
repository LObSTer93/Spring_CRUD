package dao;

import Exceptions.InfoNotFoundException;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DBConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class RepoImplTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Repo repo;

    private final int maxId = 5;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    public RepoImplTest(){
        System.out.println("HI");
    }

    @Before
    public void init(){
        repo = new RepoImpl(jdbcTemplate);

        IntStream.rangeClosed(1, maxId).forEach(id -> {
            Info info = new Info(id, "name" + id, "email" + id);
            repo.save(info);
        });
    }

    @Test
    public void getById() {
        Info info = repo.getById(1);
        assertNotNull(info);

        exception.expect(InfoNotFoundException.class);
        repo.getById(10);
    }

    @Test
    public void getAll() {
        checkCount(maxId);
    }

    @Test
    public void save() {
        checkCount(maxId);

        Info info = new Info(0, "name", "email");
        repo.save(info);

        checkCount(maxId+1);
    }

    @Test
    public void delete() {
        checkCount(maxId);
        repo.delete(2);
        checkCount(maxId-1);
    }

    @Test
    public void edit() {
        Info info = repo.getById(1);
        assertEquals(info.getName(), "name1");
        assertEquals(info.getEMail(), "email1");

        info.setName("name");
        info.setEMail("email");
        repo.edit(info);

        info = repo.getById(1);
        assertEquals(info.getName(), "name");
        assertEquals(info.getEMail(), "email");
    }

    private void checkCount(int neededCount){
        List<Info> all = repo.getAll();
        assertEquals(all.size(), neededCount);
    }
}