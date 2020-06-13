import org.junit.jupiter.api.Test;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private List<String> initList(String... usernames) {
        return new ArrayList<>(Arrays.asList(usernames));
    }
    SILab2 testunit = new SILab2();




    @Test
    void everyPathTest() {
        // A-K user==null
        assertEquals(false, testunit.function(null, initList("nikola")));
        //A-B-K
        User user1 = new User(null, "12345", "nikola@gmail.com");
        assertEquals(false, testunit.function(user1, initList("filip")));

        // ako mailot e null
        User user2 = new User("nikola", "12345", null);
        assertEquals(false, testunit.function(user2, initList("random")));

        // A,B,C,D1,D2,I,K (opfatena od a-b-k)

        // A,B,C,D1,D2,(E,F,G,H,D3,D2),I,J
        User user3 = new User("nikola", "12345", "nikola@gmail.com");
        assertEquals(true, testunit.function(user3, initList("random")));

    }

    @Test
    void everyBranchTest() {
        // prv branch A->K if(user == null)
        assertEquals(false, testunit.function(null, initList("nikola")));

        // A->B (expected true) ->
        User user1 = new User("nikola", "pass123", "nikola@gmail.com");
        assertEquals(true, testunit.function(user1, initList("random1", "random2")));

        // B->K expected false ako barem eden e null od uslovite
        User falseUser = new User(null, "asdasda", "random@finki.mk");
        assertEquals(false, testunit.function(falseUser, initList("random1", "random2")));


        // B->C->D1->D2
        User user2 = new User("nikola", "pass123", null);
        assertEquals(false, testunit.function(user2, initList("randomUsername")));

        // D1->D2->(E->F->G->H->D3->D2)->I->J --- expect true
        User user3 = new User("goce", "snagata", "random@yahoo.com");
        assertEquals(true, testunit.function(user3, initList("c1c2c3", "javascript", "python")));

        // D1->D2->(E->F->G->H->D3->D2)->I->K --- expect false (ako gi nema @ i .)
        User user4 = new User("nikola", "1234567", "randomemailgmailcom");
        assertEquals(false, testunit.function(user4, initList("angele", "rabota", "ime")));

    }

}