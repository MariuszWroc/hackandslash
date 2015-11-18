package pl.mygames.hackandslash.service;

import java.util.List;
import pl.mygames.hackandslash.model.Npc;

public interface INpcService {
    void add(Npc npc);
    void delete(Npc npc);
    void update(Npc npc);
    List<Npc> findById(Integer id);	
    List<Npc> findAll();
	void delete(Integer id);
}
