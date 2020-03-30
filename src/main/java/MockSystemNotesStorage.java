import java.util.ArrayList;
import java.util.List;


class MockSystemNotesStorage implements NotesStorage {
  public List<Note> list;

  public MockSystemNotesStorage() {
    list = new ArrayList<Note>();
  }

  @Override
  public void add(Note note) {
    list.add(note);
  }

  @Override
  public List<Note> getAllNotesOf(String name) {
    List<Note> tmp = new ArrayList<Note>();
    for (Note note : list) {
      if (note.getName() == name) {
        tmp.add(note);
      }
    }
    return tmp;
  }

  @Override
  public void clear() {
    list.clear();
  }
}