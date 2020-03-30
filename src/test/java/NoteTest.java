import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NoteTest {
  private static float epsilon = 0.01f;

  Note note;
  Float testedNote;
  String testedName;

  @BeforeEach
  void setUp() {
    testedNote = 4.5f;
    testedName = "Jon Snow";
  }

  @Test
  void testGetName() {
    note = Note.of(testedName, testedNote);
    assertEquals(testedName, note.getName());
  }

  @Test
  void testGetNoteWithEpsilon() {
    note = Note.of(testedName, testedNote);
    assertEquals(testedNote, note.getNote(), epsilon);
  }

  @Test
  void testConstructorWithNullName_ThrowException() {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
      note = Note.of(null, testedNote);
    });
    String actual = exception.getMessage();
    String expected = "Imię ucznia nie może być null";
    assertEquals(expected, actual);
  }

  @Test
  void testConstructorWithEmptyName_ThrowException() {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
      note = Note.of("", testedNote);
    });
    String actual = exception.getMessage();
    String expected = "Imię ucznia nie może być puste";
    assertEquals(expected, actual);
  }

  @Test
  void testConstructorWithLessThanRangeNote_ThrowException() {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
      note = Note.of(testedName, 1f);
    });
    String actual = exception.getMessage();
    String expected = "Niewłaściwa ocena";
    assertEquals(expected, actual);
  }

  @Test
  void testConstructorWithGreaterThanRangeNote_ThrowException() {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
      note = Note.of(testedName, 6.1f);
    });
    String actual = exception.getMessage();
    String expected = "Niewłaściwa ocena";
    assertEquals(expected, actual);
  }

  @AfterEach
  void tearDown() {
    testedNote = null;
    testedName = null;
  }
}