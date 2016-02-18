package pl.mygames.hackandslash.service;

import java.util.List;
import pl.mygames.hackandslash.model.Npc;
import pl.mygames.hackandslash.model.Quest;

public interface INpcService extends IGenericService<Npc, Integer>{
    void add(Npc npc);
    void delete(Npc npc);
    void update(Npc npc);
    Npc findById(Integer id);	
    List<Npc> findAll();
	void delete(Integer id);
}
