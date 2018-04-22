package Tests;

import controller.MemberController;
import model.Entry;
import model.Member;
import org.junit.Before;
import org.junit.Test;
import repository.MemberRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class AddEntryRepositoryTest {



    private MemberRepository repositiroy;

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void testAddEntry1() throws IOException {

        MemberRepository repo = new MemberRepository(new ArrayList<Member>(), new ArrayList<Entry>());
        repo.addEntry(new Entry("cost" , 100, 10));
        assertTrue(repo.getAllEntries().size() == 0);

    }

    @Test
    public void testAddEntry2() throws IOException {

        List<Member> members=  new ArrayList<>();
        members.add(new Member("name",10));

        MemberRepository repo = new MemberRepository(members , new ArrayList<Entry>());
        repo.addEntry(new Entry("cost" , 100, 10));
        assertTrue(repo.getAllEntries().size() == 1);

    }

    @Test
    public void testAddEntry3() throws IOException {

        List<Member> members=  new ArrayList<>();
        members.add(new Member("name",11));
        members.add(new Member("name",12));

        MemberRepository repo = new MemberRepository(members , new ArrayList<Entry>());
        repo.addEntry(new Entry("cost" , 100, 10));
        assertTrue(repo.getAllEntries().size() == 0);

    }
}
