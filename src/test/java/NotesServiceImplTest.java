import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotesServiceImplTest {
  MockSystemNotesStorage mock;
  NotesServiceImpl service;

  String testedName;
  int startListSize;

  @BeforeEach
  void setUp() {
    mock = new MockSystemNotesStorage();
    service = new NotesServiceImpl(mock);
    NotesServiceImpl.createWith(mock);

    testedName = "JonSnow";
    startListSize = mock.list.size();
  }

  @Test
  void testAddNote() {
    service.add(new Note(testedName, 4.5f));
    service.add(new Note(testedName, 4.0f));
    int addedNotes = mock.list.size() - startListSize;

    int expected = startListSize + addedNotes;
    int actual = mock.list.size();

    assertEquals(expected, actual);
  }

  @Test
  void testAverageNotesOfOneName() {
    service.add(new Note(testedName, 4.5f));
    service.add(new Note(testedName, 4.0f));
    service.add(new Note(testedName, 5.0f));
    service.add(new Note(testedName, 4.5f));

    float expected = 4.5f;
    float actual = service.averageOf(testedName);

    assertEquals(expected, actual);
  }

  @Test
  void testClearList() {
    service.add(new Note(testedName, 4.5f));
    service.add(new Note(testedName, 4.0f));

    int expected = startListSize;
    service.clear();
    int actual = mock.list.size();

    assertEquals(expected, actual);
  }

  @AfterEach
  void tearDown() {
    service = null;
    mock = null;
  }
}