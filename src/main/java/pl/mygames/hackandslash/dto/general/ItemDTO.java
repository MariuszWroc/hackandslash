package pl.mygames.hackandslash.dto.general;

import java.io.Serializable;
import pl.mygames.hackandslash.model.Item;


public final class ItemDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Integer id;

    public ItemDTO() {
    }

    public ItemDTO(Item item) {
        this.id = item.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    
}
