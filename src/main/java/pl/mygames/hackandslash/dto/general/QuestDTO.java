package pl.mygames.hackandslash.dto.general;

import java.io.Serializable;
import java.util.List;
import pl.mygames.hackandslash.model.Quest;

public final class QuestDTO implements Serializable{
        private static final long serialVersionUID = 1L;
        
            private final Integer id;
	private final String description;
    private final List<AssignmentDTO> assignmentList;

    public QuestDTO() {
        this.id = null;
        this.description = null;
        this.assignmentList = null;
    }

    public QuestDTO(Quest quest) {
        this.id = quest.getId();
        this.description = quest.getDescription();
        this.assignmentList = null;
    }

    public Integer getId() {
        return id;
    }

    public List<AssignmentDTO> getAssignmentList() {
        return assignmentList;
    }
    
	public String getDescription() {
		return description;
	}

    @Override
    public String toString() {
        return "QuestDTO{" + "id=" + id + ", description=" + description + ", assignmentList=" + assignmentList + '}';
    }

}
