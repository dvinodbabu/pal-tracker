package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    HashMap<Long, TimeEntry> repo = new HashMap();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        Long id = repo.size() + 1L;

        timeEntry.setId(id);

        repo.put(id, timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        return repo.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(repo.values());
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        repo.replace(id, timeEntry);
        timeEntry.setId(id);
        return timeEntry;
    }

    @Override
    public void delete(Long id) {
        repo.remove(id);
    }
}
